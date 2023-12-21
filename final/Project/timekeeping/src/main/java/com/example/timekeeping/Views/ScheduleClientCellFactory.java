package com.example.timekeeping.Views;

import com.example.timekeeping.Controllers.Client.ScheduleCellController;
import com.example.timekeeping.Controllers.ScheduleCellLiteController;
import com.example.timekeeping.Models.ScheduleClient;
import com.example.timekeeping.Models.ScheduleLite;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ScheduleClientCellFactory implements Callback<ListView<ScheduleClient>, ListCell<ScheduleClient>> {
    @Override
    public ListCell<ScheduleClient> call(ListView<ScheduleClient> scheduleClientListView) {
        return new ListCell<ScheduleClient>() {
            @Override
            protected void updateItem(ScheduleClient scheduleClient, boolean empty) {
                super.updateItem(scheduleClient, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Client/ScheduleCell.fxml"));
                    ScheduleCellController controller = new ScheduleCellController(scheduleClient);
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