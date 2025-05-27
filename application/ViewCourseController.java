package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ViewCourseController {

    @FXML
    private Button Course_Details;

    @FXML
    private Button Course_Material;
    
    @FXML
    private Button Back_To_Home;
   
    @FXML
    void CourseDetails(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("CourseDetail.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void CourseMaterial(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("CourseMaterial.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void DashboardBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("User_Dashboard.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}   
