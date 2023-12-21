package com.example.timekeeping.Models;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleAdmin {
    private final IntegerProperty type;
    private final StringProperty name;
    private final StringProperty room;
    private final StringProperty date;

    private final StringProperty time;
    private final StringProperty department;
    private final StringProperty id;
    private final IntegerProperty session;

    private final IntegerProperty check;

    private final IntegerProperty is_employee;

    public ScheduleAdmin(Integer type, String name,Integer session, String room, String date, String time, String department, String id,Integer check,Integer is_employee){
        this.type = new SimpleIntegerProperty(this,"Type", type);
        this.name = new SimpleStringProperty(this,"Name",name);
        this.room = new SimpleStringProperty(this,"Room",room);
        this.date = new SimpleStringProperty(this,"Date",date);
        this.time = new SimpleStringProperty(this,"Time",time);
        this.department= new SimpleStringProperty(this,"Department",department);
        this.id = new SimpleStringProperty(this,"Id", id);
        this.session = new SimpleIntegerProperty(this,"Session", session);
        this.check = new SimpleIntegerProperty(this, "Check",check);
        this.is_employee = new SimpleIntegerProperty(this,"Is_Employee", is_employee);
    }

    public StringProperty nameProperty() {
        return name;
    }


    public StringProperty roomProperty() {
        return room;
    }


    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty timeProperty() {
        return time;
    }


    public StringProperty departmentProperty() {
        return department;
    }



    public StringProperty idProperty() {
        return id;
    }

    public IntegerProperty typeProperty() {
        return type;
    }

    public IntegerProperty sessionProperty() {
        return session;
    }

    public IntegerProperty checkProperty() {
        return check;
    }

    public IntegerProperty is_employeeProperty() {
        return is_employee;
    }
}
