package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AdminDashboardController {

    @FXML
    private Button Manage_Course;

    @FXML
    private Button Alumni_Verification;
    
    @FXML
    private Button Back_To_Home;
   
    @FXML
    void ManageCourseBtn(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ManageCourse.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void AlumniVerificationBtn(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("AlumniVerification.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void DashboardBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("HomePage.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}   
