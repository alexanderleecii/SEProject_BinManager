package application;

//import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
//import BinManagerPerson.Person;
import javafx.event.*;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class mapController extends homeController implements Initializable {
		@FXML
		private MenuBar menu;
	
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
	   }
	   
}
