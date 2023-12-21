package com.example.timekeeping.Controllers.Client;

import com.example.timekeeping.Models.*;
import com.example.timekeeping.Views.ScheduleClientCellFactory;
import com.example.timekeeping.Views.ScheduleLiteCellFactory;
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

public class HistoryClientController implements Initializable {
    public DatePicker date_start;
    public DatePicker date_end;
    public Button search_btn;
    public ListView<ScheduleClient> list_view;

    private Client client;

    private List<ScheduleClient> list_schedule_client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.client = Model.getInstance().getClient();
        this.list_schedule_client = new ArrayList<>();
        list_view.setCellFactory(new ScheduleClientCellFactory());
        addListView(Model.getInstance().getDatabaseDriver().getHistoryClient(client.idProperty().getValue()));
        addListener();
    }

    private void addListener(){
        search_btn.setOnAction(actionEvent -> {
            LocalDate dateStart = date_start.getValue();
            LocalDate dateEnd = date_end.getValue();

            List<ScheduleClient> filteredList = list_schedule_client.stream()
                    .filter(schedule -> {
                        LocalDate scheduleDate = LocalDate.parse(schedule.dateProperty().getValue());
                        return (dateStart == null || scheduleDate.isAfter(dateStart) || scheduleDate.isEqual(dateStart)) &&
                                (dateEnd == null || scheduleDate.isBefore(dateEnd) || scheduleDate.isEqual(dateEnd))
                                ;
                    })
                    .collect(Collectors.toList());
            list_view.getItems().setAll(filteredList);
        });
    }

    private void addListView(ResultSet historySchedule){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            while (historySchedule.next()) {
                String name = this.client.nameProperty().getValue();
                String room = this.client.roomProperty().getValue();
                String department = this.client.departmentProperty().getValue();
                Integer type = historySchedule.getInt("type");
                Integer session = historySchedule.getInt("session");
                Integer check = historySchedule.getInt("is_check");
                String id = String.valueOf(this.client.idProperty().getValue());
                String date = dateFormat.format(historySchedule.getDate("date"));
                String time = timeFormat.format(historySchedule.getTime("time"));
                ScheduleClient scheduleClient = new ScheduleClient(type,name,session,room,date,time,department,id,check);
                list_view.getItems().add(scheduleClient);
                list_schedule_client.add(scheduleClient);
            }
            list_view.refresh();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
