package com.example.timekeeping.Controllers.Admin;

import com.example.timekeeping.Models.Admin;
import com.example.timekeeping.Models.Model;
import com.example.timekeeping.Models.ScheduleAdmin;
import com.example.timekeeping.Models.ScheduleClient;
import com.example.timekeeping.Views.AccountTypes;
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
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HistoryAdminController implements Initializable {
    public DatePicker date_start;
    public DatePicker date_end;
    public ChoiceBox<String> department;
    public TextField search_text;
    public Button search_btn;
    public ListView<ScheduleAdmin> list_view;

    private List<ScheduleAdmin> list_schedule_admin;

    private Admin admin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.admin = Model.getInstance().getAdmin();
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
        this.list_schedule_admin = new ArrayList<>();
        list_view.setCellFactory(new ScheduleAdminCellFactory());
        addListEmployeeView(Model.getInstance().getDatabaseDriver().getHistoryEmployeeManager(admin.typeProperty().getValue(),admin.roomProperty().getValue()));
        if(admin.typeProperty().getValue() == 1) addListAdminView(Model.getInstance().getDatabaseDriver().getHistoryAdminManager(admin.idProperty().getValue()));
        addListener();
    }

    public void addListener(){
        search_btn.setOnAction(actionEvent -> {
            LocalDate dateStart = date_start.getValue();
            LocalDate dateEnd = date_end.getValue();
            String textSearch = search_text.getText();
            String room = department.getValue();

            List<ScheduleAdmin> filteredList = list_schedule_admin.stream()
                    .filter(schedule -> {
                        LocalDate scheduleDate = LocalDate.parse(schedule.dateProperty().getValue());
                        return (dateStart == null || scheduleDate.isAfter(dateStart) || scheduleDate.isEqual(dateStart)) &&
                                (dateEnd == null || scheduleDate.isBefore(dateEnd) || scheduleDate.isEqual(dateEnd)) &&
                                (textSearch == null || schedule.nameProperty().getValue().toLowerCase().contains(textSearch.toLowerCase()))&&
                                (room == null || schedule.roomProperty().getValue().equalsIgnoreCase(room));
                    })
                    .collect(Collectors.toList());
            list_view.getItems().setAll(filteredList);
        });
    }

    private void addListEmployeeView(ResultSet historySchedule){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            while (historySchedule.next()) {
                String name = historySchedule.getString("name");
                String room = historySchedule.getString("room");
                String department = historySchedule.getString("department");
                Integer type = historySchedule.getInt("type");
                Integer session = historySchedule.getInt("session");
                Integer check = historySchedule.getInt("is_check");
                String id = String.valueOf(historySchedule.getInt("user_id"));
                String date = dateFormat.format(historySchedule.getDate("date"));
                String time = timeFormat.format(historySchedule.getTime("time"));
                ScheduleAdmin scheduleAdmin = new ScheduleAdmin(type,name,session,room,date,time,department,id,check,0);
                list_view.getItems().add(scheduleAdmin);
                list_schedule_admin.add(scheduleAdmin);
            }
            list_view.refresh();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void addListAdminView(ResultSet historySchedule){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            while (historySchedule.next()) {
                String name = historySchedule.getString("name");
                String room = historySchedule.getString("room");
                String department = historySchedule.getString("department");
                Integer type = historySchedule.getInt("type");
                Integer session = historySchedule.getInt("session");
                Integer check = historySchedule.getInt("is_check");
                String id = String.valueOf(historySchedule.getInt("user_id"));
                String date = dateFormat.format(historySchedule.getDate("date"));
                String time = timeFormat.format(historySchedule.getTime("time"));
                ScheduleAdmin scheduleAdmin = new ScheduleAdmin(type,name,session,room,date,time,department,id,check,1);
                list_view.getItems().add(scheduleAdmin);
                list_schedule_admin.add(scheduleAdmin);
            }
            list_view.refresh();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
