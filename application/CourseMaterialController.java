package application;

import java.io.IOException;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CourseMaterialController {

    @FXML
    private Button Assignment;

    @FXML
    private Button Notes;
    
    @FXML
    private Button PastPaper;

    @FXML
    private Button Back_To_Home;

    @FXML
    void Assignment(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("Assignment.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @FXML
    void Notes(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("Notes.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void PastPaper(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("PastPaper.fxml");
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
