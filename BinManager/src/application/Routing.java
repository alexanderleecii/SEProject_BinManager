package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Routing {
	private static Stage stage;
	
	public Routing(Stage primaryStage) {
		Routing.stage=primaryStage;
	}

	public Routing() {
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
