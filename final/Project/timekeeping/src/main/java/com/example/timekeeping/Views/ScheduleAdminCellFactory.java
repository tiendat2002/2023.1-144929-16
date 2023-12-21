package com.example.timekeeping.Views;

import com.example.timekeeping.Controllers.Admin.ScheduleCellController;
import com.example.timekeeping.Controllers.ScheduleCellLiteController;
import com.example.timekeeping.Models.ScheduleAdmin;
import com.example.timekeeping.Models.ScheduleLite;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ScheduleAdminCellFactory implements Callback<ListView<ScheduleAdmin>, ListCell<ScheduleAdmin>> {
    @Override
    public ListCell<ScheduleAdmin> call(ListView<ScheduleAdmin> scheduleAdminListView) {
        return new ListCell<ScheduleAdmin>() {
            @Override
            protected void updateItem(ScheduleAdmin scheduleAdmin, boolean empty) {
                super.updateItem(scheduleAdmin, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/ScheduleCell.fxml"));
                    ScheduleCellController controller = new ScheduleCellController(scheduleAdmin);
                    loader.setController(controller);
                    setText(null);
                    try {
                        setGraphic(loader.load());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
