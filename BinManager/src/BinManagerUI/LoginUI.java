package BinManagerUI;

import application.Routing;

import javafx.application.Application;
import javafx.stage.Stage;
// TODO: Auto-generated Javadoc
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;


/**
 * The Class LoginUI.
 */
public class LoginUI extends Application {
	
	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
        	Routing rout= new Routing(primaryStage);
        	rout.goTo("mapPage");
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}