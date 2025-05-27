package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogic.CourseMaterial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseOutlineController implements Initializable {

	Main m = new Main();
	
    @FXML
    private TableView<CourseMaterial> table;
    @FXML
    private TableColumn<CourseMaterial, String> Title;
    @FXML
    private TableColumn<CourseMaterial, String> Course_Name;
    @FXML
    private TableColumn<CourseMaterial, String>	Link;
    
    @FXML
    private Button Back_To_Home;
    
    
	ObservableList<CourseMaterial> list = FXCollections.observableArrayList();
	
	void ListofSyllabus() throws IOException {
		list.clear();
		list.addAll(m.BLController().CourseOutline());
		
		
        Title.setCellValueFactory(new PropertyValueFactory<CourseMaterial, String>("title"));
        Course_Name.setCellValueFactory(new PropertyValueFactory<CourseMaterial, String>("MaterialType"));
        Link.setCellValueFactory(new PropertyValueFactory<CourseMaterial, String>("description"));

        table.setItems(list);
     }
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 try {
			 ListofSyllabus();
		 } 
		 catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
        }
	
	    @FXML
	    void DashboardBack(ActionEvent event) {
	        
	        Main m = new Main();
	        try {
	            m.changeScene("CourseDetail.fxml");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }

		  
}
