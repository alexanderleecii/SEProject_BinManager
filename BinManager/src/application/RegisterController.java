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
import org.mindrot.jbcrypt.BCrypt;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterController.
 */
public class RegisterController extends HomeController implements Initializable {

	/** The register button. */
	@FXML
	   private Button registerButton;
	
	/** The go back. */
	@FXML
	   private Button goBack;
	   
   	/** The email field. */
   	@FXML
	   private TextField emailField;
	   
	   /** The name field. */
   	@FXML
	   private TextField nameField;
	   
	   /** The password field. */
   	@FXML
	   private PasswordField passwordField;
	  
	   /**
   	 * Initialize.
   	 *
   	 * @param location the location
   	 * @param resources the resources
   	 */
   	@Override
	   public void initialize(URL location, ResourceBundle resources) {
	      
	   }
	 
	   /**
   	 * Hash.
   	 *
   	 * @param password the password
   	 * @return the string
   	 */
   	//--Hash password	   
	   private static String hash(String password) {
		   System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
		   return "1";
	   }

	   /**
   	 * Check pass.
   	 *
   	 * @param plainPassword the plain password
   	 * @param hashedPassword the hashed password
   	 */
   	private void checkPass(String plainPassword, String hashedPassword) {
			if (BCrypt.checkpw(plainPassword, hashedPassword))
				System.out.println("The password matches.");
			else
				System.out.println("The password does not match.");
		}
	   //--Hash password

	   
	   /**
   	 * Register button action.
   	 *
   	 * @param event the event
   	 */
   	public void registerButtonAction(ActionEvent event) {
		   PersonFacade facade = new PersonFacade();
		   ArrayList<String> info = new ArrayList<>();
		   info.add(emailField.getText());
		   info.add(passwordField.getText());
		   info.add(nameField.getText());
		   info.add("citizen");
		   if(emailField.getText().equals("") || passwordField.getText().equals("") || nameField.getText().equals("")) {
			   alerte("You should fill all field"); 
		   }
		   else {
			   boolean res = facade.add(info);
			   if(!res) {
				   alerte("You already are in the database");
			   }
			   rout.goTo("connectionPage");
		   }
	   }
	   
   	/**
   	 * Go back action.
   	 *
   	 * @param event the event
   	 */
   	public void goBackAction(ActionEvent event) {
		   rout.goTo("connectionPage");
	   }
}
