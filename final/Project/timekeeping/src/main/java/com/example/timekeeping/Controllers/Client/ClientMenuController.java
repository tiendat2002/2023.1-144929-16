package com.example.timekeeping.Controllers.Client;

import com.example.timekeeping.Models.Model;
import com.example.timekeeping.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button history_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener();
    }

    private void addListener(){
        dashboard_btn.setOnAction(actionEvent -> {
            onDashboard();
        });

        history_btn.setOnAction(actionEvent -> onHistory());
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }

    private void onHistory(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.HISTORY);
    }
}
