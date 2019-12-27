package BinManagerUI;

import application.Routing;

import javafx.application.Application;
import javafx.stage.Stage;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;


public class LoginUI extends Application {
	@Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
        	Routing rout= new Routing(primaryStage);
        	rout.goTo("connectionPage");
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		launch(args);
	}
}