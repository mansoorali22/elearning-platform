package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class ChangePasswordController {

    @FXML
    private Button Change_Password;

    @FXML
    private TextField password_textfield;
    
    @FXML
    private Button Back_To_Home;
    
    @FXML
    private Label Change_info;
    
    
    @FXML
    void ChangePassword(ActionEvent event) throws IOException {
        
        
        Main m = new Main();

        if (password_textfield.getText().isEmpty())
        {
        	Change_info.setText("Enter Data in given field!");
        }
        else
        {
        	
           boolean res1 = m.BLController().changePassword(password_textfield.getText()); 
           
           if (res1)
           {
        	   Change_info.setText("Password changed successfully");
           }
           else
           {
        	   Change_info.setText("Password changed unsuccessful");
           }
        }
        
        
        
    }

    @FXML
    void BackToProfileManagement(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("HomePage.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    

}

