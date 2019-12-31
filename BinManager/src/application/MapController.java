package application;

//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MapController extends HomeController implements Initializable {
		@FXML
		private Label map;
		@FXML
		private Pane msgLayout;
		@FXML
		private Button logInButton;
		
		protected Routing rout = new Routing();
		
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   map.setText("The map will be displayed here");
	   }
	   
	   public void registerAction(ActionEvent event) {
		   rout.goTo("registerPage");
	   }
	   
	   
	   
}
