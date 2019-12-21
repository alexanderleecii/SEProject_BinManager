package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;

public class homeManagerController implements Initializable {
	
	@FXML
	private MenuBar menu;
	
	
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {

	       // TODO (don't really need to do anything here).
	      
	   }
	   
	   public void mapAction(ActionEvent event) {
		   System.out.println("map");
		   Routing rout= new Routing();
		   rout.goTo("mapPage");
	   }
	   
	   public void scheduleAction(ActionEvent event) {
		   	Routing rout= new Routing();
    		rout.goTo("schedulePage");
	   }
	   
	   public void citizenAction(ActionEvent event) {
		   	Routing rout= new Routing();
   		rout.goTo("citizenPage");
	   }
	   
	   public void externalTechnicianAction(ActionEvent event) {
		   	Routing rout= new Routing();
   		rout.goTo("externalTechnicianPage");
	   }
	   
	   public void employeeAction(ActionEvent event) {
		   	Routing rout= new Routing();
   		rout.goTo("employeePage");
	   }
	   
	   public void binAction(ActionEvent event) {
		   	Routing rout= new Routing();
  		rout.goTo("binPage");
	   }
	   
	   
	   public void usedObjectAction(ActionEvent event) {
		   	Routing rout= new Routing();
     		rout.goTo("usedObjectPage");
	   }
	   
	   public void profileAction(ActionEvent event) {
		   	Routing rout= new Routing();
    		rout.goTo("profilePage");
	   }
	   
	   public void costAction(ActionEvent event) {
		   	Routing rout= new Routing();
   		rout.goTo("costPage");
	   }
	   
	   public void storageAction(ActionEvent event) {
		   	Routing rout= new Routing();
   		rout.goTo("storagePage");
	   }
	   
	   public void logOutAction(ActionEvent event) {
		   Routing rout= new Routing();
   			rout.goTo("connectionPage");
	   }
}
