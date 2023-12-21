package com.example.timekeeping.Views;

import com.example.timekeeping.Controllers.ScheduleCellLiteController;
import com.example.timekeeping.Models.ScheduleLite;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ScheduleLiteCellFactory implements Callback<ListView<ScheduleLite>, ListCell<ScheduleLite>> {
    @Override
    public ListCell<ScheduleLite> call(ListView<ScheduleLite> scheduleLiteListView) {
        return new ListCell<ScheduleLite>() {
            @Override
            protected void updateItem(ScheduleLite scheduleLite, boolean empty) {
                super.updateItem(scheduleLite, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ScheduleCellLite.fxml"));
                    ScheduleCellLiteController controller = new ScheduleCellLiteController(scheduleLite);
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
