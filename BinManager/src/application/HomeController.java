package application;

import java.net.URL;




import java.util.ResourceBundle;

import BinManagerFacade.PersonFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
public class HomeController implements Initializable {
	
	/** The menu manager. */
	@FXML
	private MenuBar menuManager;
	
	/** The menu citizen. */
	@FXML
	private MenuBar menuCitizen;
	
	/** The menu employee. */
	@FXML
	private MenuBar menuEmployee;
	
	/** The menu admin. */
	@FXML
	private MenuBar menuAdmin;
	
	/** The menu visitor. */
	@FXML
	private MenuBar menuVisitor;
	
	/** The person connected. */
	@FXML
	private Label personConnected;
	
	/** The rout. */
	protected Routing rout = new Routing();
	
	/** The facade. */
	//The facade attribute holds the information of the user currently logged in
	private static PersonFacade facade;
	
	/**
	 * Gets the facade.
	 *
	 * @return the facade
	 */
	public static PersonFacade getFacade() {
		return HomeController.facade;
	}
	
	/**
	 * Sets the person facade.
	 *
	 * @param facade the new person facade
	 */
	public static void setPersonFacade(PersonFacade facade) {
		HomeController.facade = facade;
	}
	
   /**
    * Initialize.
    *
    * @param location the location
    * @param resources the resources
    */
   @Override
   public void initialize(URL location, ResourceBundle resources) {
	  initMenuBar();
	// exemple d'injection de code : il faut creer un label en FXML et utiliser setText avec son id par exemple 
	  personConnected.setText("You are connected as "+ HomeController.getFacade().getPerson().getRole().toString());
   }
   
   /**
    * Inits the menu bar.
    */
   public void initMenuBar() {
	   //INITIALISATION DE LA MENUBAR
	   //Par default j'ai mis les 4 menuBar en FXML non visible et je mets a visible seulement celle necessaire
	   if(!(HomeController.getFacade() == null)) {  
		   if(HomeController.getFacade().getPerson().getRole().toString().equals("manager")){
			   menuVisitor.setVisible(false);
			   menuAdmin.setVisible(false);
			   menuCitizen.setVisible(false);
			   menuEmployee.setVisible(false);
			   menuManager.setVisible(true);
		   }
		   else if(HomeController.getFacade().getPerson().getRole().toString().equals("employee")) {
			   menuVisitor.setVisible(false);
			   menuManager.setVisible(false);
			   menuAdmin.setVisible(false);
			   menuCitizen.setVisible(false);
			   menuEmployee.setVisible(true);
		   }
		   else if(HomeController.getFacade().getPerson().getRole().toString().equals("citizen")) {
			   menuVisitor.setVisible(false);
			   menuManager.setVisible(false);
			   menuEmployee.setVisible(false);
			   menuAdmin.setVisible(false);
			   menuCitizen.setVisible(true);
		   }
		   else if(HomeController.getFacade().getPerson().getRole().toString().equals("admin")) {
			   menuVisitor.setVisible(false);
			   menuManager.setVisible(false);
			   menuCitizen.setVisible(false);
			   menuEmployee.setVisible(false);
			   menuAdmin.setVisible(true);
		   }
	   }else {
		   menuVisitor.setVisible(true);
	   }
   }
   
   /**
    * Alerte.
    *
    * @param msg the msg
    */
   //FONCTION QUI CREE LES POPUPSS
   public void alerte(String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
	}
   
   //EN DESSOUS TOUT LES LIENS VERS LES PAGES DANS LA MENUBAR !!
   /**
    * Map action.
    *
    * @param event the event
    */
   //An "action" is called when the corresponding item is clicked
   public void mapAction(ActionEvent event) {
	   rout.goTo("mapPage");
   }
   
   /**
    * Schedule action.
    *
    * @param event the event
    */
   public void scheduleAction(ActionEvent event) {
		//rout.goTo("schedulePage"); //TODO create this page
	   rout.goTo("homePage");
   }
   
   /**
    * Citizen action.
    *
    * @param event the event
    */
   public void citizenAction(ActionEvent event) {
		rout.goTo("citizenManagementPage");
   }
   
   /**
    * External technician action.
    *
    * @param event the event
    */
   public void externalTechnicianAction(ActionEvent event) {
		//rout.goTo("externalTechnicianPage"); //TODO create this page
	   rout.goTo("homePage");
   }
   
   /**
    * Employee action.
    *
    * @param event the event
    */
   public void employeeAction(ActionEvent event) {
		rout.goTo("employeeManagementPage");
   }
   
   /**
    * Manager action.
    *
    * @param event the event
    */
   public void managerAction(ActionEvent event) {
		rout.goTo("managerManagementPage");
  }

   
   /**
    * Bin action.
    *
    * @param event the event
    */
   public void binAction(ActionEvent event) {
	   rout.goTo("binManagementPage");
   }
   
   
   /**
    * Used object action.
    *
    * @param event the event
    */
   public void usedObjectAction(ActionEvent event) {
 		//rout.goTo("usedObjectPage"); //TODO create this page
	   rout.goTo("homePage");
   }
   
   /**
    * Profile action.
    *
    * @param event the event
    */
   public void profileAction(ActionEvent event) {
		rout.goTo("profilePage");
   }
   
   /**
    * Cost action.
    *
    * @param event the event
    */
   public void costAction(ActionEvent event) {
		rout.goTo("costPage");
   }
   
   /**
    * Storage action.
    *
    * @param event the event
    */
   public void storageAction(ActionEvent event) {
		//rout.goTo("storagePage"); //TODO create this page
	   rout.goTo("homePage");
   }
   
   /**
    * Login action.
    *
    * @param event the event
    */
   public void loginAction(ActionEvent event) {
	   rout.goTo("connectionPage");
   }
   
   /**
    * Log out action.
    *
    * @param event the event
    */
   public void logOutAction(ActionEvent event) {
		HomeController.setPersonFacade(null);
		rout.goTo("mapPage");
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
