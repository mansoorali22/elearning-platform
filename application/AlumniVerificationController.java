package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogic.Alumni;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlumniVerificationController implements Initializable {

	Main m = new Main();
	
    @FXML
    private TableView<Alumni> table;
    @FXML
    private TableColumn<Alumni, String> Year_of_completion;
    @FXML
    private TableColumn<Alumni, String> name;
    @FXML
    private TableColumn<Alumni, String>	status;

    @FXML
    private Button Verify_Login;
    
    @FXML
    private Button Back_To_Home;
    
    
	ObservableList<Alumni> list = FXCollections.observableArrayList();
	
	void ListofAlumni() throws IOException {
		list.clear();
		list.addAll(m.BLController().AlumniDatabase());
		
		
        Year_of_completion.setCellValueFactory(new PropertyValueFactory<Alumni, String>("yearCompletion"));
        name.setCellValueFactory(new PropertyValueFactory<Alumni, String>("fullName"));
        status.setCellValueFactory(new PropertyValueFactory<Alumni, String>("status"));

        table.setItems(list);
     }
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 try {
			 ListofAlumni();
		 } 
		 catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
        }
	
	    @FXML
	    void AlumniLoginBack(ActionEvent event) {
	        
	        Main m = new Main();
	        try {
	            m.changeScene("Admin_Dashboard.fxml");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }
	
	    @FXML
	  	void Verify(ActionEvent event) {
	  		int selectedID = table.getSelectionModel().getSelectedIndex();
	  		Main m = new Main();
	  		m.BLController().VerifyALumni(selectedID);
	  		list.clear();
			list.addAll(m.BLController().AlumniDatabase());
			
			
	        Year_of_completion.setCellValueFactory(new PropertyValueFactory<Alumni, String>("yearCompletion"));
	        name.setCellValueFactory(new PropertyValueFactory<Alumni, String>("fullName"));
	        status.setCellValueFactory(new PropertyValueFactory<Alumni, String>("status"));

	        table.setItems(list);
	     }  	
		  
}
