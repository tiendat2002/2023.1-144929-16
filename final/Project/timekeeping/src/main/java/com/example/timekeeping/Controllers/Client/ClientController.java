package com.example.timekeeping.Controllers.Client;

import com.example.timekeeping.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case HISTORY -> client_parent.setCenter(Model.getInstance().getViewFactory().getHistoryClientView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardClientView());
            }
        });
    }
}
