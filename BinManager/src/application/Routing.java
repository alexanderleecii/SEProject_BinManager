package application;

import java.io.IOException;

import BinManagerFacade.PersonFacade;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Routing {
	private static Stage stage;
	private static PersonFacade facade; 
	
	public Routing(Stage primaryStage) {
		Routing.stage=primaryStage;
	}

	public Routing() {
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Routing.stage = stage;
	}
	public static PersonFacade getFacade() {
		return facade;
	}
	public static void setPersonFacade(PersonFacade facade) {
		Routing.facade = facade;
	}

	public void goTo(String page) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/"+page+".fxml"));
			stage.setScene(new Scene(root));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
