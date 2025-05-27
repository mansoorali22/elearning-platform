package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class RegisterController {

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
    private TextField cGPA_textfield;
    
    @FXML
    private TextField semesterNo_textfield;
    
    @FXML
    private Label Student_Register_info;
    
    
    @FXML
    void StudentRegister(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (fullName_textfield.getText().isEmpty() || password_textfield.getText().isEmpty() || email_textfield.getText().isEmpty() || phoneNo_textfield.getText().isEmpty() || cGPA_textfield.getText().isEmpty() || semesterNo_textfield.getText().isEmpty())
        {
        	Student_Register_info.setText("Enter Data in all fields!!");
        }
        else{
        	
        	int semester = Integer.parseInt(semesterNo_textfield.getText());
            double cGPA = Double.parseDouble( cGPA_textfield.getText());
            boolean res1 = m.BLController().registerStudent(ID, fullName_textfield.getText(), password_textfield.getText(), email_textfield.getText(),
            		phoneNo_textfield.getText(),semester , cGPA, "Student");
            
            
            if (res1)
            {
            	Student_Register_info.setText("Student Data stored successfully");
            }
            else
            {
            	Student_Register_info.setText("Student Data storing unsuccessful");
            }
        }
        
        
    }

    @FXML
    void StudentRegisterBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("HomePage.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    

}

