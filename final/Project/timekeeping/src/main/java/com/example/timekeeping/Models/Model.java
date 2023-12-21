package com.example.timekeeping.Models;

import com.example.timekeeping.Views.AccountTypes;
import com.example.timekeeping.Views.ViewFactory;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private final DatabaseDriver databaseDriver;

    private AccountTypes loginAccountType = AccountTypes.CLIENT;

//    Client Data Section
    private final Client client;

    private final Admin admin;
    private boolean clientLoginSuccessFlag;

    private boolean adminLoginSuccessFlag;
//    Admin Data Section
    private Model(){
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
//        Client Data Section
        this.clientLoginSuccessFlag = false;
        this.adminLoginSuccessFlag = false;
        this.client= new Client("","", null,"","",null,0, null);
        this.admin = new Admin("","", null,"","",null,0, 0);

//        Admin Data Section

    }

    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory(){
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver(){
        return databaseDriver;
    }

    public AccountTypes getLoginAccountType(){
        return loginAccountType;
    }

    public void setLoginAccountType(AccountTypes accountType){
        this.loginAccountType = loginAccountType;
    }
    public boolean getClientLoginSuccessFlag(){
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag){
        this.clientLoginSuccessFlag = flag;
    }

    public boolean getAdminLoginSuccessFlag() {
        return adminLoginSuccessFlag;
    }

    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }


    public Client getClient(){
        return client;
    }

    public Admin getAdmin(){
        return admin;
    }

    public void evaluateClientCred(String userName,String password){
        ResultSet resultSet = databaseDriver.getInfoClient(userName,password);
        try{
            if(resultSet.next()){
                this.client.nameProperty().set(resultSet.getString("name"));
                this.client.salaryProperty().set(resultSet.getString("salary"));
                this.client.birthdayProperty().set(resultSet.getString("birth_day"));
                this.client.positionProperty().set(resultSet.getString("position"));
                this.client.roomProperty().set(resultSet.getString("room"));
                this.client.departmentProperty().set(resultSet.getString("department"));
                this.client.managerProperty().set(databaseDriver.getInfoManager(resultSet.getInt("manager_id")));
                this.client.idProperty().set(resultSet.getInt("id"));
                this.clientLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void evaluateAdminCred(String userName, String password){
        ResultSet resultSet = databaseDriver.getInfoAdmin(userName,password);
        try{
            if(resultSet.next()){
                this.admin.nameProperty().set(resultSet.getString("name"));
                this.admin.salaryProperty().set(resultSet.getString("salary"));
                this.admin.birthdayProperty().set(resultSet.getString("birth_day"));
                this.admin.positionProperty().set(resultSet.getString("position"));
                this.admin.roomProperty().set(resultSet.getString("room"));
                this.admin.departmentProperty().set(resultSet.getString("department"));
                this.admin.typeProperty().set(resultSet.getInt("type"));
                this.admin.idProperty().set(resultSet.getInt("id"));
                this.adminLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

