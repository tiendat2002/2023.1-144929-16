package com.example.timekeeping.Controllers;

import com.example.timekeeping.Models.Model;
import com.example.timekeeping.Views.AccountTypes;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountTypes> acc_selected;
    public TextField acc_user_name;
    public TextField acc_password;
    public Button btn_login;
    public Label error_text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selected.setItems(FXCollections.observableArrayList(AccountTypes.CLIENT,AccountTypes.ADMIN));
        acc_selected.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selected.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selected.getValue()));
        btn_login.setOnAction(event -> onLogin());
    }

    private void onLogin() {
        Stage stage = (Stage) error_text.getScene().getWindow();
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountTypes.CLIENT) {
            Model.getInstance().evaluateClientCred(acc_user_name.getText(),acc_password.getText());
            if(Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else {
                acc_user_name.setText("");
                acc_password.setText("");
                error_text.setText("No Such Login Credentials");
            }
        }else {
            Model.getInstance().evaluateAdminCred(acc_user_name.getText(),acc_password.getText());
            if(Model.getInstance().getAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else {
                acc_user_name.setText("");
                acc_password.setText("");
                error_text.setText("No Such Login Credentials");
            }
        }
    }


}
