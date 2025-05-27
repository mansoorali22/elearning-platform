package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlumniController {

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
    private Label Alumni_Login_info;
    
    
    @FXML
    void AlumniLogin(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (username_textfield.getText().isEmpty() || password_textfield.getText().isEmpty())
        {
        	Alumni_Login_info.setText("Enter Data in all fields!!");
        }
        else
        {
            boolean res1 = m.BLController().AlumniLogin(username_textfield.getText() , password_textfield.getText());
            
            if (res1)
            {
            	Alumni_Login_info.setText("Alumni FOUND!");
                m.changeScene("User_Dashboard.fxml");
            }
            else	
            {
            	Alumni_Login_info.setText("Alumni NOT FOUND!");
            }
        }
        
    }

    @FXML
    void AlumniLoginBack(ActionEvent event) {
        
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
            m.changeScene("RegisterAlumni.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}