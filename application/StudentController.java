package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

    @FXML
    private Button User_Logged;

    @FXML
    private Button Back_To_Home;
    
    @FXML
    private TextField username_textfield;

    @FXML
    private TextField password_textfield;
    
    @FXML
    private Hyperlink Sign_Up;

    @FXML
    private Label Student_Login_info;
    
    
    @FXML
    void StudentLogin(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (username_textfield.getText().isEmpty() || password_textfield.getText().isEmpty())
        {
        	Student_Login_info.setText("Enter Data in all fields!!");
        }
        else
        {
            boolean res1 = m.BLController().StudentLogin(username_textfield.getText() , password_textfield.getText());
            
            if (res1)
            {
            	Student_Login_info.setText("Student FOUND!");
                m.changeScene("User_Dashboard.fxml");
            }
            else	
            {
            	Student_Login_info.setText("Student NOT FOUND!");
            }
        }
        
    }

    @FXML
    void StudentLoginBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("HomePage.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void SignUP(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("RegisterStudent.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

