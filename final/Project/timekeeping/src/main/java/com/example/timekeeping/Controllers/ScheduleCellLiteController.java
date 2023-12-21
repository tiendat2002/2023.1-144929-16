package com.example.timekeeping.Controllers;

import com.example.timekeeping.Models.ScheduleLite;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleCellLiteController implements Initializable {
    public Label name_user;
    public Label room_user;
    public Label apart_user;
    public Label date_schedule;
    public Label time_schedule;
    public Label text_check;
    public FontAwesomeIconView icon_check;

    private final ScheduleLite scheduleLite;

    public ScheduleCellLiteController(ScheduleLite scheduleLite){
        this.scheduleLite = scheduleLite;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_user.setText(scheduleLite.nameProperty().getValue());
        room_user.setText(scheduleLite.roomProperty().getValue());
        apart_user.setText(scheduleLite.departmentProperty().getValue());
        date_schedule.setText(scheduleLite.dateProperty().getValue());
        time_schedule.setText(scheduleLite.timeProperty().getValue());
        if(scheduleLite.checkProperty().getValue() == 1){
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
