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

public class mapController implements Initializable {
		@FXML
		private MenuBar menu;
	
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	      
	   }
	   
	   public void mapAction(ActionEvent event) {
		   System.out.println("map");
		   Routing rout= new Routing();
		   rout.goTo("mapPage");
	   }
	   
	   public void usedObjectAction(ActionEvent event) {
		   	Routing rout= new Routing();
     		rout.goTo("usedObjectPage");
	   }
	   
	   public void profileAction(ActionEvent event) {
		   	Routing rout= new Routing();
    		rout.goTo("profilePage");
	   }
	   
	   public void logOutAction(ActionEvent event) {
		   	//A FAIRE
	   }
}
