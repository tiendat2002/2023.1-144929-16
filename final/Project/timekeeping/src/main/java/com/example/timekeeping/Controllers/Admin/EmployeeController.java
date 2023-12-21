package com.example.timekeeping.Controllers.Admin;

import com.example.timekeeping.Models.Admin;
import com.example.timekeeping.Models.Employee;
import com.example.timekeeping.Models.Model;
import com.example.timekeeping.Models.ScheduleAdmin;
import com.example.timekeeping.Views.EmployeeCellFactory;
import com.example.timekeeping.Views.ScheduleAdminCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class EmployeeController implements Initializable {
    public DatePicker date_start;
    public DatePicker date_end;
    public ChoiceBox<String> department;
    public TextField search_text;
    public Button search_btn;
    public ListView list_view;

    private Admin admin;

    private List<Employee> list_employee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.admin = Model.getInstance().getAdmin();
        this.list_employee = new ArrayList<>();
        if(this.admin.typeProperty().getValue() == 0){
            department.setItems(FXCollections.observableArrayList(this.admin.roomProperty().getValue()));
            department.setValue(this.admin.roomProperty().getValue());
        }else {
            ObservableList<String> roomList = FXCollections.observableArrayList();
            ResultSet listRoom = Model.getInstance().getDatabaseDriver().getAllRoom();
            try{
                while (listRoom.next()){
                    roomList.add(listRoom.getString("name"));
                }
                department.setItems(roomList);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        list_view.setCellFactory(new EmployeeCellFactory());
        addListEmployeeView(Model.getInstance().getDatabaseDriver().getEmployeeManager(admin.typeProperty().getValue(),admin.roomProperty().getValue()));
        if(admin.typeProperty().getValue() == 1) addListAdminView(Model.getInstance().getDatabaseDriver().getAdminManager(admin.idProperty().getValue()));
        addListener();
    }

    private void addListener(){
        search_btn.setOnAction(actionEvent -> {
            LocalDate dateStart = date_start.getValue();
            LocalDate dateEnd = date_end.getValue();
            String textSearch = search_text.getText();
            String room = department.getValue();

            List<Employee> filteredList = list_employee.stream()
                    .filter(employee -> {
                        LocalDate scheduleDate = LocalDate.parse(employee.birthdayProperty().getValue());
                        return (dateStart == null || scheduleDate.isAfter(dateStart) || scheduleDate.isEqual(dateStart)) &&
                                (dateEnd == null || scheduleDate.isBefore(dateEnd) || scheduleDate.isEqual(dateEnd)) &&
                                (textSearch == null || employee.nameProperty().getValue().toLowerCase().contains(textSearch.toLowerCase()))&&
                                (room == null || employee.roomProperty().getValue().equalsIgnoreCase(room));
                    })
                    .collect(Collectors.toList());
            list_view.getItems().setAll(filteredList);
        });
    }

    private void addListAdminView(ResultSet adminList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            while (adminList.next()) {
                String name = adminList.getString("name");
                String room = adminList.getString("room");
                String department = adminList.getString("department");
                String salary = adminList.getString("salary");
                String id = String.valueOf(adminList.getInt("id"));
                String date = dateFormat.format(adminList.getDate("birth_day"));
                Employee employee = new Employee(name,room,date,department,salary,id,1);
                list_view.getItems().add(employee);
                list_employee.add(employee);
            }
            list_view.refresh();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void addListEmployeeView(ResultSet employeeList){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            while (employeeList.next()) {
                String name = employeeList.getString("name");
                String room = employeeList.getString("room");
                String department = employeeList.getString("department");
                String salary = employeeList.getString("salary");
                String id = String.valueOf(employeeList.getInt("id"));
                String date = dateFormat.format(employeeList.getDate("birth_day"));
                Employee employee = new Employee(name,room,date,department,salary,id,0);
                list_view.getItems().add(employee);
                list_employee.add(employee);
            }
            list_view.refresh();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
