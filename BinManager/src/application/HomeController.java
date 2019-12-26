package application;

import java.net.URL;
import java.util.ResourceBundle;

import BinManagerFacade.PersonFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class HomeController implements Initializable {
	
	@FXML
	private MenuBar menuManager;
	@FXML
	private MenuBar menuCitizen;
	@FXML
	private MenuBar menuEmployee;
	@FXML
	private MenuBar menuAdmin;
	@FXML
	private MenuBar menuVisitor;
	@FXML
	private Label personConnected;
	
	protected Routing rout = new Routing();
	
	//The facade attribute holds the information of the user currently logged in
	private static PersonFacade facade;
	
	public static PersonFacade getFacade() {
		return HomeController.facade;
	}
	public static void setPersonFacade(PersonFacade facade) {
		HomeController.facade = facade;
	}
	
   @Override
   public void initialize(URL location, ResourceBundle resources) {
	  initMenuBar();
	// exemple d'injection de code : il faut cr�er un label en FXML et utilis� setText avec son id par exemple 
	  personConnected.setText("You are connected as "+ HomeController.getFacade().getPerson().getRole().toString());
   }
   public void initMenuBar() {
	   //INITIALISATION DE DE LA MENUBAR
	   //Par default j'ai mis les 4 menuBar en FXML non visible et je mets a visible seulement celle necessaire
	   if(!(HomeController.getFacade() == null)) {
		   menuVisitor.setVisible(false);
		   if(HomeController.getFacade().getPerson().getRole().toString().equals("manager")){
			   menuManager.setVisible(true);
		   }
		   else if(HomeController.getFacade().getPerson().getRole().toString().equals("employee")) {
			   menuEmployee.setVisible(true);
		   }
		   else if(HomeController.getFacade().getPerson().getRole().toString().equals("citizen")) {
			   menuCitizen.setVisible(true);
		   }
		   else if(HomeController.getFacade().getPerson().getRole().toString().equals("admin")) {
			   menuAdmin.setVisible(true);
		   }
	   }
   }
   //FONCTION QUI CREE LES POPUPSS
   public void alerte(String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERREUR");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
	}
   
   //EN DESSOUS TOUT LES LIENS VERS LES PAGES DANS LA MANUBAR !!
   public void mapAction(ActionEvent event) {
	   rout.goTo("mapPage");
   }
   
   public void scheduleAction(ActionEvent event) {
		rout.goTo("schedulePage");
   }
   
   public void citizenAction(ActionEvent event) {
		rout.goTo("citizenPage");
   }
   
   public void externalTechnicianAction(ActionEvent event) {
		rout.goTo("externalTechnicianPage");
   }
   
   public void employeeAction(ActionEvent event) {
		rout.goTo("employeeManagementPage");
   }
   
   public void binAction(ActionEvent event) {
	   rout.goTo("binManagementPage");
   }
   
   
   public void usedObjectAction(ActionEvent event) {
 		rout.goTo("usedObjectPage");
   }
   
   public void profileAction(ActionEvent event) {
		rout.goTo("profilePage");
   }
   
   public void costAction(ActionEvent event) {
		rout.goTo("costPage");
   }
   
   public void storageAction(ActionEvent event) {
		rout.goTo("storagePage");
   }
   public void loginAction(ActionEvent event) {
	   rout.goTo("connectionPage");
   }
   
   public void logOutAction(ActionEvent event) {
		HomeController.setPersonFacade(null);
		rout.goTo("mapPage");
   }
}
