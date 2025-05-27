package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class RegisterAlumniController {

    Random rand = new Random();

    int ID = rand.nextInt(9999);

    @FXML
    private Button Register_Logged;

    @FXML
    private Button Back_To_Home;
    
    @FXML
    private TextField fullName_textfield;

    @FXML
    private TextField password_textfield;
    
    @FXML
    private TextField email_textfield;

    @FXML
    private TextField phoneNo_textfield;
    
    @FXML
    private TextField yoc_textfield;
    
    
    @FXML
    private Label Alumni_Register_info;
    
    
    @FXML
    void AlumniRegister(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (fullName_textfield.getText().isEmpty() || password_textfield.getText().isEmpty() || email_textfield.getText().isEmpty() || phoneNo_textfield.getText().isEmpty() || yoc_textfield.getText().isEmpty())
        {
        	Alumni_Register_info.setText("Enter Data in all fields!!");
        }
        else{
        	

            boolean res1 = m.BLController().registerAlumni(ID, fullName_textfield.getText(), password_textfield.getText(), email_textfield.getText(),
            		phoneNo_textfield.getText(), yoc_textfield.getText(), "Alumni", "Unverified");
            
            
            if (res1)
            {
            	Alumni_Register_info.setText("Alumni Data stored successfully");
            }
            else
            {
            	Alumni_Register_info.setText("Alumni Data storing unsuccessful");
            }
        }
        
        
    }

    @FXML
    void AlumniRegisterBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("HomePage.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    


}

