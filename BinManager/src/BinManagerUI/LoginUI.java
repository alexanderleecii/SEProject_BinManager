package BinManagerUI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class LoginUI extends Application {
	@Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
        	
            Parent connectionPage = FXMLLoader.load(getClass().getResource("/connectionPage.fxml"));
            FXMLLoader registerPage = FXMLLoader.load(getClass().getResource("/registerPage.fxml"));
 
            primaryStage.setScene(new Scene(connectionPage));
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		launch(args);
	}
}