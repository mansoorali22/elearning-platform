package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class ChangeNameController {

    @FXML
    private Button Change_Name;

    @FXML
    private TextField fullName_textfield;
    
    @FXML
    private Label Change_info;
    
    @FXML
    private Button Back_To_Home;

    
    @FXML
    void ChangeName(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (fullName_textfield.getText().isEmpty())
        {
        	Change_info.setText("Enter Data in given field!");
        }
        else
        {
        	
           boolean res1 = m.BLController().changeName(fullName_textfield.getText()); 
           
           if (res1)
           {
        	   Change_info.setText("Name changed successfully");
           }
           else
           {
        	   Change_info.setText("Name changed unsuccessful");
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

