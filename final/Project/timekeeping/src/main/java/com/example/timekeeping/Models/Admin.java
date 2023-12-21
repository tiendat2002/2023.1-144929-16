package com.example.timekeeping.Models;

import javafx.beans.property.*;

public class Admin {
    private final StringProperty name;
    private final StringProperty room;
    private final StringProperty birthday;
    private final StringProperty department;
    private final StringProperty salary;
    private final StringProperty position;
    private final IntegerProperty id;

    private final IntegerProperty type;

    public Admin(String name, String room, String birthday, String department, String position, String salary, Integer id, Integer type){
        this.name = new SimpleStringProperty(this,"Name",name);
        this.room = new SimpleStringProperty(this,"Room",room);
        this.position = new SimpleStringProperty(this,"Position",position);
        this.birthday = new SimpleStringProperty(this,"Birthday",birthday);
        this.department= new SimpleStringProperty(this,"Department",department);
        this.salary = new SimpleStringProperty(this,"Salary",salary);
        this.id = new SimpleIntegerProperty(this,"Id", id);
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


    public IntegerProperty idProperty() {
        return id;
    }


    public StringProperty positionProperty() {
        return position;
    }

    public IntegerProperty typeProperty() {
        return type;
    }
}
