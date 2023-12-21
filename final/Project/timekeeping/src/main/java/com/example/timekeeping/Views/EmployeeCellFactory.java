package com.example.timekeeping.Views;

import com.example.timekeeping.Controllers.Admin.EmployeeCellController;
import com.example.timekeeping.Controllers.ScheduleCellLiteController;
import com.example.timekeeping.Models.Employee;
import com.example.timekeeping.Models.ScheduleLite;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class EmployeeCellFactory implements Callback<ListView<Employee>, ListCell<Employee>> {
    @Override
    public ListCell<Employee> call(ListView<Employee> employeeListView) {
        return new ListCell<Employee>() {
            @Override
            protected void updateItem(Employee employee, boolean empty) {
                super.updateItem(employee, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/EmployeeCell.fxml"));
                    EmployeeCellController controller = new EmployeeCellController(employee);
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
