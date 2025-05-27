package application;

///////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageController {
	
//public class FirstScreenController {

    @FXML
    private Button Admin_Login;

    @FXML
    private Button Student_Login;

    @FXML
    private Button Alumni_Login;
    
    @FXML
    void AdminLogin(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("AdminLogin.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @FXML
    void StudentLogin(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("StudentUser.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @FXML
    void AlumniLogin(ActionEvent event) {
        
        Main m = new Main();
        try {
            m.changeScene("User.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
//    @FXML
//    void FinancialOfficerLogin(ActionEvent event) throws IOException {
//        Main m = new Main();
//        m.changeScene("LoginFinancialOfficer.fxml");
//    }

//}
}