package com.example.timekeeping.Controllers.Client;

import com.example.timekeeping.Models.ScheduleClient;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleCellController implements Initializable {
    public Label name_user;
    public Label room_user;
    public Label apart_user;
    public Label date_schedule;
    public Label time_schedule;
    public Label id_user;
    public Label part_schedule;
    public Label type_schedule;
    public Label text_check;
    public FontAwesomeIconView icon_check;

    private final ScheduleClient scheduleClient;

    public ScheduleCellController(ScheduleClient scheduleClient){
        this.scheduleClient = scheduleClient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_user.setText(scheduleClient.idProperty().getValue());

        switch (scheduleClient.partProperty().getValue()){
            case 0: part_schedule.setText("Morning");
            break;
            case 1: part_schedule.setText("Afternoon");
            break;
            default: part_schedule.setText("Evening");
            break;
        }

        if(scheduleClient.typeProperty().getValue() == 0){
            type_schedule.setText("In");
        } else {
            type_schedule.setText("Out");
        }

        name_user.setText(scheduleClient.nameProperty().getValue());
        room_user.setText(scheduleClient.roomProperty().getValue());
        apart_user.setText(scheduleClient.departmentProperty().getValue());
        date_schedule.setText(scheduleClient.dateProperty().getValue());
        time_schedule.setText(scheduleClient.timeProperty().getValue());
        if(scheduleClient.checkProperty().getValue() == 1){
            text_check.setText("Complete");
            text_check.getStyleClass().remove("schedule_delete_btn");
            text_check.getStyleClass().add("schedule_edit_btn");
            icon_check.setIcon(FontAwesomeIcon.CHECK);
        }else {
            text_check.setText("Fall");
            text_check.getStyleClass().add("schedule_delete_btn");
            text_check.getStyleClass().remove("schedule_edit_btn");
            icon_check.setIcon(FontAwesomeIcon.CLOSE);
        }
    }
}
