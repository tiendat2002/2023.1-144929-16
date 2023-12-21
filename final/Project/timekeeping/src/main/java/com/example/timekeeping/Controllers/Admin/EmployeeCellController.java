package com.example.timekeeping.Controllers.Admin;

import com.example.timekeeping.Models.Employee;
import com.example.timekeeping.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeCellController implements Initializable {
    public Label name_user;
    public Label room_user;
    public Label birth_user;
    public Label apart_user;
    public Label salary_user;
    public Label id_user;
    public Button edit_btn;
    public Button delete_btn;

    private final Employee employee;

    public EmployeeCellController(Employee employee){
        this.employee = employee;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_user.setText(employee.nameProperty().getValue());
        room_user.setText(employee.roomProperty().getValue());
        birth_user.setText(employee.birthdayProperty().getValue());
        apart_user.setText(employee.departmentProperty().getValue());
        salary_user.setText(employee.salaryProperty().getValue());
        id_user.setText(employee.idProperty().getValue());
        addListener();
    }

    public void addListener(){
        delete_btn.setOnAction(actionEvent -> {
            Model.getInstance().getDatabaseDriver().deleteEmployee(Integer.valueOf(employee.idProperty().getValue()),employee.typeProperty().getValue());
        });
    }
}
