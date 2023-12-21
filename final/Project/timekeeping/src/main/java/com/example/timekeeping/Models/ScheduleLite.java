package com.example.timekeeping.Models;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleLite {
    private final StringProperty name;
    private final StringProperty room;
    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty department;

    private final IntegerProperty check;

    public ScheduleLite(String name,String room, String date,String time, String department, Integer check){
        this.name = new SimpleStringProperty(this,"Name",name);
        this.room = new SimpleStringProperty(this,"Room",room);
        this.date = new SimpleStringProperty(this,"Birthday",date);
        this.time = new SimpleStringProperty(this,"Birthday",time);
        this.department= new SimpleStringProperty(this,"Department",department);
        this.check = new SimpleIntegerProperty(this,"Check", check);
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

    public IntegerProperty checkProperty() {
        return check;
    }
}
