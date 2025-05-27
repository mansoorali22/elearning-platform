package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class ChangePhoneNoController {

    @FXML
    private Button Change_PhoneNo;

    @FXML
    private TextField phoneNO_textfield;
    
    @FXML
    private Button Back_To_Home;
    
    @FXML
    private Label Change_info;
    
    
    @FXML
    void ChangePhoneNo(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (phoneNO_textfield.getText().isEmpty())
        {
        	Change_info.setText("Enter Data in given field!");
        }
        else
        {
        	
           boolean res1 = m.BLController().changePhoneNo(phoneNO_textfield.getText()); 
           
           if (res1)
           {
        	   Change_info.setText("PhoneNO changed successfully");
           }
           else
           {
        	   Change_info.setText("PhoneNO changed unsuccessful");
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

