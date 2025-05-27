package application;
	
import java.io.File;
import java.io.IOException;

import application.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.fxml.*;
import database.*;

public class Main extends Application {
    
    private static Stage stg;
    private static Controller control = new Controller(); // BL controller object
    
    public void start(Stage primaryStage) {
        try
        {
        	File file = new File("D:\\Fast.png");
        	Image fasticon = new Image(file.toURI().toString());
        	
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root,600,400);
            primaryStage.getIcons().add(fasticon);
            primaryStage.setTitle("FAST");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public Controller BLController() {
    	return control;
    }
    
    
}
