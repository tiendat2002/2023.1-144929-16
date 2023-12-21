package com.example.timekeeping.Controllers.Admin;

import com.example.timekeeping.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) ->{
            switch (newVal){
                case HISTORY -> admin_parent.setCenter(Model.getInstance().getViewFactory().getHistoryAdminView());
                case EMPLOYEE -> admin_parent.setCenter(Model.getInstance().getViewFactory().getEmployeeView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDashboardAdminView());
            }
        } );
    }
}
