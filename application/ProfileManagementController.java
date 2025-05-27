package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProfileManagementController {

    @FXML
    private Button Change_Name;

    @FXML
    private Button Change_Email;
    
    @FXML
    private Button Change_Password;
   
    @FXML
    private Button Change_Phone_No;

    @FXML
    private Button Back_To_Home;

    @FXML
    void ChangeName(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ChangeName.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void ChangeEmail(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ChangeEmail.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void ChangePassowrd(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ChangePassword.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void ChangePhoneNo(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ChangePhoneNo.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void DashboardBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("User_Dashboard.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
