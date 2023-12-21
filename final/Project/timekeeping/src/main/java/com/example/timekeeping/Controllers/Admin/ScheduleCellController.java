package com.example.timekeeping.Controllers.Admin;

import com.example.timekeeping.Models.Model;
import com.example.timekeeping.Models.ScheduleAdmin;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleCellController implements Initializable {
    public FontAwesomeIconView in_arrow;
    public FontAwesomeIconView out_arrow;
    public Label name_user;
    public Label room_user;
    public Label apart_user;
    public Label date_schedule;
    public Label time_schedule;
    public Label id_user;
    public Button edit_btn;
    public Button delete_btn;

    private final ScheduleAdmin scheduleAdmin;

    public ScheduleCellController(ScheduleAdmin scheduleAdmin){
        this.scheduleAdmin = scheduleAdmin;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_user.setText(scheduleAdmin.idProperty().getValue());
        if(scheduleAdmin.typeProperty().getValue() == 0){
            in_arrow.getStyleClass().removeAll();
            if(scheduleAdmin.checkProperty().getValue() ==1) {
                in_arrow.getStyleClass().add("icon_success");
            }else {
                in_arrow.getStyleClass().add("icon_fall");
            }
        }else {
            out_arrow.getStyleClass().removeAll();
            if(scheduleAdmin.checkProperty().getValue() ==1) {
                out_arrow.getStyleClass().add("icon_success");
            }else {
                out_arrow.getStyleClass().add("icon_fall");
            }
        }

        name_user.setText(scheduleAdmin.nameProperty().getValue());
        room_user.setText(scheduleAdmin.roomProperty().getValue());
        apart_user.setText(scheduleAdmin.departmentProperty().getValue());
        date_schedule.setText(scheduleAdmin.dateProperty().getValue());
        time_schedule.setText(scheduleAdmin.timeProperty().getValue());
        addListener();
    }

    public void addListener(){
        delete_btn.setOnAction(actionEvent -> {
            Model.getInstance().getDatabaseDriver().deleteSchedule(Integer.valueOf(scheduleAdmin.idProperty().getValue()),scheduleAdmin.is_employeeProperty().getValue());
            Model.getInstance().getDatabaseDriver().handleAfterDeleted(scheduleAdmin.is_employeeProperty().getValue(),scheduleAdmin.sessionProperty().getValue(),scheduleAdmin.dateProperty().getValue(),scheduleAdmin.typeProperty().getValue());
        });
    }
}
