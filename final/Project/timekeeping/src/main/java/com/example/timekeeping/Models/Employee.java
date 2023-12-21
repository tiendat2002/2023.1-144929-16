package com.example.timekeeping.Models;

import javafx.beans.property.*;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.util.Date;

public class Employee {

    private final StringProperty name;
    private final StringProperty room;
    private final StringProperty birthday;
    private final StringProperty department;
    private final StringProperty salary;
    private final StringProperty id;

    private final IntegerProperty type;

    public Employee(String name, String room, String birthday, String department, String salary, String id,Integer type){
        this.name = new SimpleStringProperty(this,"Name",name);
        this.room = new SimpleStringProperty(this,"Room",room);
        this.birthday = new SimpleStringProperty(this,"Birthday",birthday);
        this.department= new SimpleStringProperty(this,"Department",department);
        this.salary = new SimpleStringProperty(this,"Salary",salary);
        this.id = new SimpleStringProperty(this,"Id", id);
        this.type = new SimpleIntegerProperty(this,"Type",type);
    }

    public StringProperty nameProperty() {
        return name;
    }


    public StringProperty roomProperty() {
        return room;
    }


    public StringProperty birthdayProperty() {
        return birthday;
    }


    public StringProperty departmentProperty() {
        return department;
    }


    public StringProperty salaryProperty() {
        return salary;
    }


    public StringProperty idProperty() {
        return id;
    }
    public IntegerProperty typeProperty() {
        return type;
    }
}
