package application;

//import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MapController extends HomeController implements Initializable {
		@FXML
		private Label map;
		
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   map.setText("THE MAP WILL BE DISPLAYED HERE");
	   }
	   
}
