package application;

import java.io.IOException;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminController {

    @FXML
    private Button Admin_Logged;

    @FXML
    private Button Back_To_Home;
    
    @FXML
    private TextField username_textfield;

    @FXML
    private TextField password_textfield;
    
    @FXML
    private Label Admin_Login_info;

    @FXML
    void AdminLogin(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (username_textfield.getText().isEmpty() || password_textfield.getText().isEmpty())
        {
        	Admin_Login_info.setText("Enter Data in all fields!!");
        }
        else
        {
            boolean res1 = m.BLController().AdminLogin(username_textfield.getText() , password_textfield.getText());
            
            if (res1)
            {
            	Admin_Login_info.setText("Administrator FOUND!");
                m.changeScene("Admin_Dashboard.fxml");
            }
            else
            {
            	Admin_Login_info.setText("Administrator NOT FOUND!");
            }
        }
        
    }

    @FXML
    void AdminLoginBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("HomePage.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}