package application;

//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MapController.
 */
public class MapController extends HomeController implements Initializable {
		
		/** The map. */
		@FXML
		private Label map;
		
		/** The msg layout. */
		@FXML
		private Pane msgLayout;
		
		/** The log in button. */
		@FXML
		private Button logInButton;
		
		/** The rout. */
		protected Routing rout = new Routing();
		
	   /**
   	 * Initialize.
   	 *
   	 * @param location the location
   	 * @param resources the resources
   	 */
   	@Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   if(!(HomeController.getFacade() == null)) {
			   logInButton.setVisible(false);
		   }
		   map.setText("The map will be displayed here");
	   }
	   
	   /**
   	 * Register action.
   	 *
   	 * @param event the event
   	 */
   	public void registerAction(ActionEvent event) {
		   rout.goTo("registerPage");
	   }
	   
	   
	   
}
