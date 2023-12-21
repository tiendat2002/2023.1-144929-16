package com.example.timekeeping.Models;

import javafx.beans.property.*;

public class ScheduleClient{
    private final IntegerProperty type;
    private final StringProperty name;
    private final StringProperty room;
    private final StringProperty date;
    private final IntegerProperty part;
    private final StringProperty time;
    private final StringProperty department;
    private final StringProperty id;
    private final IntegerProperty check;

    public ScheduleClient(Integer type, String name, Integer part, String room, String date, String time, String department, String id, Integer check){
        this.type = new SimpleIntegerProperty(this,"Type", type);
        this.part = new SimpleIntegerProperty(this,"Part", part);
        this.name = new SimpleStringProperty(this,"Name",name);
        this.room = new SimpleStringProperty(this,"Room",room);
        this.date = new SimpleStringProperty(this,"Birthday",date);
        this.time = new SimpleStringProperty(this,"Birthday",time);
        this.department= new SimpleStringProperty(this,"Department",department);
        this.id = new SimpleStringProperty(this,"Id", id);
        this.check = new SimpleIntegerProperty(this,"Check", check);
    }

    public StringProperty nameProperty() {
        return name;
    }


    public StringProperty roomProperty() {
        return room;
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

    public IntegerProperty partProperty() {
        return part;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public StringProperty dateProperty() {
        return date;
    }

    public IntegerProperty checkProperty() {
        return check;
    }
}
