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

public class RegisterController extends HomeController implements Initializable {

	@FXML
	   private Button registerButton;
	@FXML
	   private Button goBack;
	   @FXML
	   private TextField emailField;
	   
	   @FXML
	   private TextField nameField;
	   
	   @FXML
	   private PasswordField passwordField;
	  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	      
	   }
	 
	   //--Hash password	   
	   private static String hash(String password) {
		   System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
		   return "1";
	   }

	   private void checkPass(String plainPassword, String hashedPassword) {
			if (BCrypt.checkpw(plainPassword, hashedPassword))
				System.out.println("The password matches.");
			else
				System.out.println("The password does not match.");
		}
	   //--Hash password

	   
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
	   public void goBackAction(ActionEvent event) {
		   rout.goTo("connectionPage");
	   }
}
