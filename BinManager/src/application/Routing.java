package application;

import java.io.IOException;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class Routing.
 */
//This class changes the view depending on what button is pressed (in the Controllers)
public class Routing {
	
	/** The stage. */
	private static Stage stage;
	
	/**
	 * Instantiates a new routing.
	 *
	 * @param primaryStage the primary stage
	 */
	public Routing(Stage primaryStage) {
		Routing.stage=primaryStage;
	}

	/**
	 * Instantiates a new routing.
	 */
	public Routing() {
	}
	
	/**
	 * Gets the stage.
	 *
	 * @return the stage
	 */
	public static Stage getStage() {
		return stage;
	}

	/**
	 * Sets the stage.
	 *
	 * @param stage the new stage
	 */
	public static void setStage(Stage stage) {
		Routing.stage = stage;
	}

	/**
	 * Go to.
	 *
	 * @param page the page
	 */
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
