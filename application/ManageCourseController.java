package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ManageCourseController {

    @FXML
    private Button Create_Course;

    @FXML
    private Button Edit_Course;
    
    @FXML
    private Button View_Course;
    
    @FXML
    private Button Back_To_Home;
   
    @FXML
    void CreateCourseBtn(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("CreateCourse.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void EditCourseBtn(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("Edit_Course.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void ViewCourseBtn(ActionEvent event) {
        
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
            m.changeScene("Admin_Dashboard.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
} 
