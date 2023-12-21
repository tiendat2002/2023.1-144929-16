package com.example.timekeeping.Views;

import com.example.timekeeping.Controllers.Admin.AdminController;
import com.example.timekeeping.Controllers.Client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {

    private AccountTypes loginAccountType;

//    Client

    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardClientView;
    private AnchorPane historyClientView;


//    Admin

    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane dashboardAdminView;

    private AnchorPane historyAdminView;

    private AnchorPane employeeView;


    public ViewFactory(){
        this.loginAccountType = AccountTypes.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public void setLoginAccountType(AccountTypes loginAccountType){
        this.loginAccountType = loginAccountType;
    }

    public AccountTypes getLoginAccountType(){
        return loginAccountType;
    }




//    Client
// Dashboard Client View

    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem(){
        return clientSelectedMenuItem;
    }
    public AnchorPane getDashboardClientView(){
        if(dashboardClientView==null){
          try {
              dashboardClientView = new FXMLLoader(getClass().getResource("/FXML/Client/DashboardClient.fxml")).load();
          }catch (Exception e){
              e.printStackTrace();
          }
        }
        return dashboardClientView;
    }

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Client/Client.fxml"));
        ClientController controller = new ClientController();
        loader.setController(controller);
        createStage(loader);

    }


// History Client View

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }
public AnchorPane getHistoryClientView(){
    if(historyClientView == null){
        try{
            historyClientView = new FXMLLoader(getClass().getResource("/FXML/Client/History.fxml")).load();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    return historyClientView;
}

//Admin
//    Dashboard Admin View

public AnchorPane getDashboardAdminView(){
        if(dashboardAdminView == null){
            try{dashboardAdminView = new FXMLLoader(getClass().getResource("/FXML/Admin/DashboardAdmin.fxml")).load();}
        catch(Exception e){
                e.printStackTrace();
        }
        }

        return dashboardAdminView;
}


public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
}

// History Admin View
    public AnchorPane getHistoryAdminView(){
        if(historyAdminView == null){
            try{
                historyAdminView = new FXMLLoader(getClass().getResource("/FXML/Admin/History.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return historyAdminView;
    }

//    Employee Admin View
    public AnchorPane getEmployeeView(){
        if(employeeView == null) {
            try{
                employeeView = new FXMLLoader(getClass().getResource("/FXML/Admin/Employee.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return employeeView;
    }

//    Login view

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.jpg"))));
        stage.setTitle("Timekeeping app");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }

}
