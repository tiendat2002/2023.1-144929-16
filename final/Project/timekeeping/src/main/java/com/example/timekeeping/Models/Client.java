package com.example.timekeeping.Models;

import javafx.beans.property.*;

import java.sql.ResultSet;

public class Client {
    private final StringProperty name;
    private final StringProperty room;
    private final StringProperty birthday;
    private final StringProperty department;
    private final StringProperty salary;
    private final StringProperty position;
    private final IntegerProperty id;
    private final StringProperty manager;

    public Client(String name, String room, String birthday, String department, String position, String salary, Integer id, String manager){
        this.name = new SimpleStringProperty(this,"Name",name);
        this.room = new SimpleStringProperty(this,"Room",room);
        this.position = new SimpleStringProperty(this,"Position",position);
        this.birthday = new SimpleStringProperty(this,"Birthday",birthday);
        this.department= new SimpleStringProperty(this,"Department",department);
        this.salary = new SimpleStringProperty(this,"Salary",salary);
        this.id = new SimpleIntegerProperty(this,"Id", id);
        this.manager = new SimpleStringProperty(this,"Manager",manager);
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


    public IntegerProperty idProperty() {
        return id;
    }


    public StringProperty positionProperty() {
        return position;
    }

    public StringProperty managerProperty() {
        return manager;
    }

}
