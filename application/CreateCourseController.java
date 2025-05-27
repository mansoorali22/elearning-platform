package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class CreateCourseController {


    @FXML
    private Button Create_Course;

    @FXML
    private Button Back_To_Home;
    
    @FXML
    private TextField Course_ID;
    
    @FXML
    private TextField Course_Type;

    @FXML
    private TextField Course_Name;
      
    @FXML
    private Label Create_info;
    
    
    @FXML
    void CreateCourseBtn(ActionEvent event) throws IOException {
        
        Main m = new Main();

        if (Course_ID.getText().isEmpty() ||Course_Type.getText().isEmpty() || Course_Name.getText().isEmpty())
        {
        	Create_info.setText("Enter Data in all fields!!");
        }
        else{
        	

            boolean res1 = m.BLController().createCourse(Course_ID.getText(), Course_Type.getText(), Course_Name.getText()); //Function to add in controller class
            
            
            if (res1)
            {
            	Create_info.setText("Course Data stored successfully");
            }
            else
            {
            	Create_info.setText("Course Data storing unsuccessful");
            }
        }
        
        
    }

    @FXML
    void DashboardBack(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("ManageCourse.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    


}