package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogic.Alumni;
import BusinessLogic.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditCourseController implements Initializable {

	Main m = new Main();
	
    @FXML
    private TableView<Course> table;
    @FXML
    private TableColumn<Course, String> Course_ID;
    @FXML
    private TableColumn<Course, String> Course_Name;
    @FXML
    private TableColumn<Course, String>	Course_Type;

    @FXML
    private Button Back_To_Home;
    
    
	ObservableList<Course> list = FXCollections.observableArrayList();
	
	void ListofCourses() throws IOException {
		list.clear();
		list.addAll(m.BLController().viewCourse());
		
		
        Course_ID.setCellValueFactory(new PropertyValueFactory<Course, String>("courseID"));
        Course_Name.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        Course_Type.setCellValueFactory(new PropertyValueFactory<Course, String>("courseType"));

        table.setItems(list);
     }
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 try {
			 ListofCourses();
		 } 
		 catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
        }
	
	 @FXML
	 void Edit_Course(ActionEvent event) {
		 Main m = new Main();
		 try {
			 m.changeScene("EditCourseField.fxml");			 
	     } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	     }	 
		 
		 
	 }
	 
	  @FXML
	 void BackToDashboard(ActionEvent event) {
	        
	        Main m = new Main();
	        try {
	            m.changeScene("Admin_Dashboard.fxml");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 }
	  

}
