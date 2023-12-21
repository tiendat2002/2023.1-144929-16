package com.example.timekeeping.Models;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


public class DatabaseDriver {

//    Config my DB
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/timekeeper_app?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private Connection conn;



    public DatabaseDriver(){
        try {
            this.conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    Client Section
    public ResultSet getInfoClient(String user_name,String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user WHERE user_name = '"+user_name+"'AND password = '"+password +"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public String getInfoManager(Integer id) throws SQLException {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT name,room FROM admin WHERE id = '" + id + "';");

            // Check if the resultSet has any data
            if (resultSet.next()) {
                return resultSet.getString("name") + "(" + resultSet.getString("room") + ")";
            } else {
                // Handle the case where no data is found for the given ID
                return "No manager";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the resultSet and statement in the final block to ensure proper cleanup
            if (resultSet != null) {
                resultSet.close();
            }
            // Add similar cleanup for the statement if needed
        }
    }

    public ResultSet getHistoryClientThisWeek(Integer id){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            LocalDate currentDate = LocalDate.now();
            LocalDate firstDayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

            // Lấy ngày cuối cùng của tuần hiện tại
            LocalDate lastDayOfWeek = firstDayOfWeek.plusDays(6);

            // Tạo chuỗi định dạng ngày
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Tạo câu truy vấn SQL với điều kiện ngày trong tuần
            resultSet = statement.executeQuery("SELECT * FROM calendar_client WHERE user_id = '" + id + "' AND date BETWEEN '"
                    + firstDayOfWeek.format(formatter) + "' AND '" + lastDayOfWeek.format(formatter) + "';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryClientThisMonth(Integer id) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT * FROM calendar_client WHERE user_id = '" + id + "' AND DATE_FORMAT(date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m')";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryClient(Integer id){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT * FROM schedule_client WHERE user_id = '" + id + "';";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }


//    Admin Section
    public ResultSet getInfoAdmin(String user_name, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM admin WHERE user_name = '"+user_name+"'AND password = '"+password +"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryAdminThisWeek(Integer id){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            LocalDate currentDate = LocalDate.now();
            LocalDate firstDayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

            // Lấy ngày cuối cùng của tuần hiện tại
            LocalDate lastDayOfWeek = firstDayOfWeek.plusDays(6);

            // Tạo chuỗi định dạng ngày
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Tạo câu truy vấn SQL với điều kiện ngày trong tuần
            resultSet = statement.executeQuery("SELECT * FROM calendar_admin WHERE admin_id = '" + id + "' AND date BETWEEN '"
                    + firstDayOfWeek.format(formatter) + "' AND '" + lastDayOfWeek.format(formatter) + "';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryAdminThisMonth(Integer id) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT * FROM calendar_admin WHERE admin_id = '" + id + "' AND DATE_FORMAT(date, '%Y-%m') = DATE_FORMAT(NOW(), '%Y-%m')";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryAdmin(Integer id){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT * FROM schedule_admin WHERE admin_id = '" + id + "';";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryEmployeeManager(Integer type, String room) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            if(type == 1) {
                String query = "SELECT * FROM schedule_client";
                resultSet = statement.executeQuery(query);
            }
            else {
                String query = "SELECT * FROM schedule_client JOIN user WHERE  schedule_client.user_id = user.id AND user.room = '" +room + "';";
                resultSet = statement.executeQuery(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getHistoryAdminManager(Integer id) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT * FROM schedule_admin JOIN admin WHERE  schedule_admin.admin_id = user.id;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getEmployeeManager( Integer type, String room) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            if(type == 1){
                ResultSet resultSet1 = statement.executeQuery("SELECT * FROM user");
            }
            else {
                String query = "SELECT * FROM user WHERE room = '" +room + "';";
                resultSet = statement.executeQuery(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public ResultSet getAdminManager(Integer id){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT * FROM admin WHERE id != '" + id + "';";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void deleteEmployee(Integer id,Integer type){
        Statement statement;
        try {
            statement = this.conn.createStatement();
            String query;
            if(type == 0) {
                query = "DELETE FROM user WHERE id = '" + id + "';";
            } else{
                query = "DELETE FROM admin WHERE id ='"+id+"';";
            }
            statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSchedule(Integer id,Integer type){
        Statement statement;
        try {
            statement = this.conn.createStatement();
            String query;
            if(type == 0) {
                query = "DELETE FROM schedule_client WHERE id = '" + id + "';";
            } else{
                query = "DELETE FROM schedule_admin WHERE id ='"+id+"';";
            }
            statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //    Common Section
    public ResultSet getAllRoom(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            String query = "SELECT name FROM room;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void handleAfterDeleted(Integer is_employee, Integer session, String date, Integer type) {
        Statement statement;
        try {
            statement = this.conn.createStatement();
            String query;
            if(is_employee == 0){
                switch (session){
                    case 0: query = "UPDATE calendar_client SET m_status = 2 WHERE date = '"+date+"';";break;
                    case 1: query = "UPDATE calendar_client SET a_status = 2 WHERE date = '"+date+"';";break;
                    default: query = "UPDATE calendar_client SET e_status = 2 WHERE date = '"+date+"';";break;
                }
            }else {
                switch (session){
                    case 0: query = "UPDATE calendar_admin SET m_status = 2 WHERE date = '"+date+"';";break;
                    case 1: query = "UPDATE calendar_admin SET a_status = 2 WHERE date = '"+date+"';";break;
                    default: query = "UPDATE calendar_admin SET e_status = 2 WHERE date = '"+date+"';";break;
                }
            }
            statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
