module com.example.timekeeping {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;


    opens com.example.timekeeping to javafx.fxml;
    exports com.example.timekeeping;
    exports com.example.timekeeping.Controllers;
    exports com.example.timekeeping.Controllers.Admin;
    exports com.example.timekeeping.Controllers.Client;
    exports com.example.timekeeping.Views;
    exports com.example.timekeeping.Models;
}