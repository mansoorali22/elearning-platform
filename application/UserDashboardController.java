package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class UserDashboardController {

    @FXML
    private Button Manage_Profile;

    @FXML
    private Button View_Courses;
    
    @FXML
    private Button Back_To_Home;
   
    @FXML
    void ManageProfileBtn(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ProfileManagement.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void ViewCoursesBtn(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ViewCourse.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void DashboardBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("StudentUser.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}   
