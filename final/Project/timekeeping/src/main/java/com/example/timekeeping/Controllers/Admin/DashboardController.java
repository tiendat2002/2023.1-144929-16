package com.example.timekeeping.Controllers.Admin;

import com.example.timekeeping.Models.Admin;
import com.example.timekeeping.Models.Model;
import com.example.timekeeping.Models.ScheduleLite;
import com.example.timekeeping.Views.ScheduleLiteCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Label day_off;
    public Label position;
    public Label room;
    public Label department;
    public Label salary;
    public Text monday;
    public Label m_monday;
    public Label a_monday;
    public Label e_monday;
    public Text tuesday;
    public Label m_tuesday;
    public Label a_tuesday;
    public Label e_tuesday;
    public Text wednesday;
    public Label m_wednesday;
    public Label a_wednesday;
    public Label e_wednesday;
    public Text thursday;
    public Label m_thursday;
    public Label a_thursday;
    public Label e_thursday;
    public Text friday;
    public Label e_sunday;
    public Label a_sunday;
    public Label m_sunday;
    public Text sunday;
    public Label e_saturday;
    public Label a_saturday;
    public Label m_saturday;
    public Text saturday;
    public Label e_friday;
    public Label a_friday;
    public Label m_friday;
    public Label salary_reduced;
    public ListView<ScheduleLite> attended_list;
    public Label name;
    public Label date;
    public LineChart chart_day_off;

    private Admin admin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.admin = Model.getInstance().getAdmin();
        attended_list.setCellFactory(new ScheduleLiteCellFactory());
        position.setText(this.admin.positionProperty().getValue());
        salary.setText(this.admin.salaryProperty().getValue());
        department.setText(this.admin.departmentProperty().getValue());
        room.setText(this.admin.roomProperty().getValue());
        name.setText("Hi, " + this.admin.nameProperty().getValue());
        date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        addDayOfWeek();
        handelScheduleInThisWeek(Model.getInstance().getDatabaseDriver().getHistoryAdminThisWeek(admin.idProperty().getValue()));
        handelChart(Model.getInstance().getDatabaseDriver().getHistoryAdminThisMonth(admin.idProperty().getValue()));
        addListView(Model.getInstance().getDatabaseDriver().getHistoryAdmin(admin.idProperty().getValue()));
    }

    public void handelScheduleInThisWeek(ResultSet schedule) {
        try {
            while (schedule.next()) {
                Date dateFromDatabase = schedule.getDate("date");

                // Chuyển đổi đối tượng Date thành LocalDate
                LocalDate localDate = dateFromDatabase.toLocalDate();

                // Lấy ngày trong tuần của localDate
                DayOfWeek dayOfWeek = localDate.getDayOfWeek();

                // Sử dụng switch để so sánh với các giá trị DayOfWeek
                switch (dayOfWeek) {
                    case MONDAY:
                        if(schedule.getInt("morning") == 1){
                            m_monday.getStyleClass().remove("inactive");
                            m_monday.getStyleClass().add("active");
                        }else {
                            m_monday.getStyleClass().remove("active");
                            m_monday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_monday.getStyleClass().remove("inactive");
                            a_monday.getStyleClass().add("active");
                        }else {
                            a_monday.getStyleClass().remove("");
                            a_monday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_monday.getStyleClass().remove("inactive");
                            e_monday.getStyleClass().add("active");
                        }else {
                            e_monday.getStyleClass().remove("active");
                            e_monday.getStyleClass().add("inactive");
                        }
                        break;
                    case TUESDAY:
                        if(schedule.getInt("morning") == 1){
                            m_tuesday.getStyleClass().remove("inactive");
                            m_tuesday.getStyleClass().add("active");
                        }else {
                            m_tuesday.getStyleClass().remove("active");
                            m_tuesday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_tuesday.getStyleClass().remove("inactive");
                            a_tuesday.getStyleClass().add("active");
                        }else {
                            a_tuesday.getStyleClass().remove("");
                            a_tuesday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_tuesday.getStyleClass().remove("inactive");
                            e_tuesday.getStyleClass().add("active");
                        }else {
                            e_tuesday.getStyleClass().remove("active");
                            e_tuesday.getStyleClass().add("inactive");
                        }
                        break;
                    case WEDNESDAY:
                        if(schedule.getInt("morning") == 1){
                            m_wednesday.getStyleClass().remove("inactive");
                            m_wednesday.getStyleClass().add("active");
                        }else {
                            m_wednesday.getStyleClass().remove("active");
                            m_wednesday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_wednesday.getStyleClass().remove("inactive");
                            a_wednesday.getStyleClass().add("active");
                        }else {
                            a_wednesday.getStyleClass().remove("");
                            a_wednesday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_wednesday.getStyleClass().remove("inactive");
                            e_wednesday.getStyleClass().add("active");
                        }else {
                            e_wednesday.getStyleClass().remove("active");
                            e_wednesday.getStyleClass().add("inactive");
                        }
                        break;
                    case THURSDAY:
                        if(schedule.getInt("morning") == 1){
                            m_thursday.getStyleClass().remove("inactive");
                            m_thursday.getStyleClass().add("active");
                        }else {
                            m_thursday.getStyleClass().remove("active");
                            m_thursday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_thursday.getStyleClass().remove("inactive");
                            a_thursday.getStyleClass().add("active");
                        }else {
                            a_thursday.getStyleClass().remove("");
                            a_thursday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_thursday.getStyleClass().remove("inactive");
                            e_thursday.getStyleClass().add("active");
                        }else {
                            e_thursday.getStyleClass().remove("active");
                            e_thursday.getStyleClass().add("inactive");
                        }
                        break;
                    case FRIDAY:
                        if(schedule.getInt("morning") == 1){
                            m_friday.getStyleClass().remove("inactive");
                            m_friday.getStyleClass().add("active");
                        }else {
                            m_friday.getStyleClass().remove("active");
                            m_friday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_friday.getStyleClass().remove("inactive");
                            a_friday.getStyleClass().add("active");
                        }else {
                            a_friday.getStyleClass().remove("");
                            a_friday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_friday.getStyleClass().remove("inactive");
                            e_friday.getStyleClass().add("active");
                        }else {
                            e_friday.getStyleClass().remove("active");
                            e_friday.getStyleClass().add("inactive");
                        }
                        break;
                    case SATURDAY:
                        if(schedule.getInt("morning") == 1){
                            m_saturday.getStyleClass().remove("inactive");
                            m_saturday.getStyleClass().add("active");
                        }else {
                            m_saturday.getStyleClass().remove("active");
                            m_saturday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_saturday.getStyleClass().remove("inactive");
                            a_saturday.getStyleClass().add("active");
                        }else {
                            a_saturday.getStyleClass().remove("");
                            a_saturday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_saturday.getStyleClass().remove("inactive");
                            e_saturday.getStyleClass().add("active");
                        }else {
                            e_saturday.getStyleClass().remove("active");
                            e_saturday.getStyleClass().add("inactive");
                        }
                        break;
                    default:
                        if(schedule.getInt("morning") == 1){
                            m_sunday.getStyleClass().remove("inactive");
                            m_sunday.getStyleClass().add("active");
                        }else {
                            m_sunday.getStyleClass().remove("active");
                            m_sunday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("afternoon") == 1){
                            a_sunday.getStyleClass().remove("inactive");
                            a_sunday.getStyleClass().add("active");
                        }else {
                            a_sunday.getStyleClass().remove("");
                            a_sunday.getStyleClass().add("inactive");
                        }
                        if(schedule.getInt("evening") == 1){
                            e_sunday.getStyleClass().remove("inactive");
                            e_sunday.getStyleClass().add("active");
                        }else {
                            e_sunday.getStyleClass().remove("active");
                            e_sunday.getStyleClass().add("inactive");
                        }
                }            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addDayOfWeek(){
        LocalDate today = LocalDate.now();

        // Lấy ngày đầu tiên của tuần (thường là thứ Hai)
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);

        // In ra ngày và tháng của các ngày trong tuần
        for (int i = 0; i < 7; i++) {
            LocalDate date = startOfWeek.plusDays(i);
            String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM"));
            switch (i) {
                case 0:
                    monday.setText(formattedDate);
                    break;
                case 1:
                    tuesday.setText(formattedDate);
                    break;
                case 2:
                    wednesday.setText(formattedDate);
                    break;
                case 3:
                    thursday.setText(formattedDate);
                    break;
                case 4:
                    friday.setText(formattedDate);
                    break;
                case 5:
                    saturday.setText(formattedDate);
                    break;
                default:
                    sunday.setText(formattedDate);
                    break;
            }
        }
    }
    public Map<Integer,Integer> handelScheduleToDayOff(ResultSet schedule){
        Map<Integer,Integer> dayOffMap = new HashMap<>();
        try {
            while (schedule.next()) {
                Date scheduleDate = schedule.getDate("date");
                LocalDate localDate = scheduleDate.toLocalDate();
                Integer dayOfMonth = localDate.getDayOfMonth();
                Integer day_off =0;
                if(schedule.getInt("m_status") == 2) day_off++;
                if(schedule.getInt("a_status") == 2) day_off++;
                if(schedule.getInt("e_status") == 2) day_off++;
                dayOffMap.put(dayOfMonth,day_off);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dayOffMap;
    }

    public void handelChart(ResultSet adminScheduleThisMonth){
        LocalDate currentDate = LocalDate.now();

        // Xác định ngày đầu tiên và cuối cùng của tháng hiện tại
        LocalDate firstDayOfMonth = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), 1);
        LocalDate lastDayOfMonth = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), firstDayOfMonth.lengthOfMonth());

        // Tạo trục x với các giá trị ngày từ ngày đầu tiên đến cuối tháng
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        // Tạo trục y với giá trị từ 1 đến 3
        NumberAxis yAxis = new NumberAxis(1, 3, 0);
        yAxis.setLabel("Value");

        // Tạo BarChart với trục x và trục y
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Bar Chart Example");

        // Tạo dữ liệu cho BarChart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Data Series");
        Map<Integer,Integer> dayoffMap = handelScheduleToDayOff(adminScheduleThisMonth);
        // Thêm các điểm dữ liệu vào series
        for (LocalDate date = firstDayOfMonth; date.isBefore(lastDayOfMonth.plusDays(1)); date = date.plusDays(1)) {
            Integer dayOfMonth = date.getDayOfMonth();
            Integer dayOff = 0;
            if(dayoffMap.get(dayOfMonth) != null) {
                dayOff = dayoffMap.get(dayOfMonth);
            };
            series.getData().add(new XYChart.Data<>(String.valueOf(dayOfMonth), dayOff ));
        }

        // Thêm series vào BarChart
        chart_day_off.getData().add(series);
    }

    public void addListView(ResultSet historySchedule){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            while (historySchedule.next()) {
                String name = this.admin.nameProperty().getValue();
                String room = this.admin.roomProperty().getValue();
                String department = this.admin.departmentProperty().getValue();
                Integer check = historySchedule.getInt("is_check");
                String date = dateFormat.format(historySchedule.getDate("date"));
                String time = timeFormat.format(historySchedule.getTime("time"));
                ScheduleLite scheduleLite = new ScheduleLite(name,room,date,time,department,check);
                attended_list.getItems().add(scheduleLite);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }}
