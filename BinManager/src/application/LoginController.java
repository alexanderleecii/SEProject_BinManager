package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import binManagerFacade.PersonFacade;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
public class LoginController extends HomeController implements Initializable {
	
	/** The login button. */
	@FXML
	   private Button loginButton;
	  
	/** The register button. */
	@FXML
	   private Button registerButton;
	
	   /** The email field. */
   	@FXML
	   private TextField emailField;
	   
	   /** The password field. */
   	@FXML
	   private PasswordField passwordField;
	   
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
	   }
	 
	   /**
   	 * Login button action.
   	 *
   	 * @param event the event
   	 */
   	public void loginButtonAction(ActionEvent event) {
	       PersonFacade facade = new PersonFacade();
	       ArrayList<String> infos = new ArrayList<>();
	       infos.add(emailField.getText());
	       infos.add(passwordField.getText());
		   boolean res = facade.load(infos);
		   if(!res) {
			   alerte("Wrong email or password !");
			   rout.goTo("connectionPage");
		   }
		   else {
			   //I don't think the routing class should hold the facade
			   HomeController.setPersonFacade(facade);
			   rout.goTo("homePage");
		   }
		   
	   }
}
