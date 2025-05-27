package application;

import java.io.IOException;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CourseDetailController {

    @FXML
    private Button Syllabus;

    @FXML
    private Button Books;
    
    @FXML
    private Button Course_outline;

    @FXML
    private Button Back_To_Home;

    @FXML
    void Syllabus(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("Syllabus.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @FXML
    void Books(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("Books.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void CourseOutline(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("CourseOutline.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @FXML
    void DashboardBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ViewCourse.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}