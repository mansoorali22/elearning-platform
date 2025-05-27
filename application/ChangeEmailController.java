package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class ChangeEmailController {

    @FXML
    private Button Change_Email;

    @FXML
    private TextField email_textfield;

    @FXML
    private Button Back_To_Home;
    
    @FXML
    private Label Change_info;
    
    
    @FXML
    void ChangeEmail(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (email_textfield.getText().isEmpty())
        {
        	Change_info.setText("Enter Data in given field!");
        }
        else
        {
        	
           boolean res1 = m.BLController().changeEmail(email_textfield.getText()); 
           
           if (res1)
           {
        	   Change_info.setText("Email changed successfully");
           }
           else
           {
        	   Change_info.setText("Email changed unsuccessful");
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

