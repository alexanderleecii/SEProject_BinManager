package application;

import java.net.URL;



import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
import BinManagerPerson.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LoginController implements Initializable {
	@FXML
	   private Button loginButton;
	  
	   @FXML
	   private TextField emailField;
	   
	   @FXML
	   private PasswordField passwordField;
	  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
	 
	   // When user click on myButton
	   // this method will be called.
	   public void loginAction(ActionEvent event) {
	       PersonFacade facade = new PersonFacade();
		   facade.load(emailField.getText(), passwordField.getText());
//		   Person example = facade.getPerson();
//		   System.out.println(example.getName());
	   }
}
