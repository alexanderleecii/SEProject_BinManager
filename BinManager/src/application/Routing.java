package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Routing {
	private static Stage stage;
	
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
	public void alerte(String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERREUR");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
	}
	
}
