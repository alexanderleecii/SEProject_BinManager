package application;

import java.net.URL;



import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LoginController implements Initializable {
	@FXML
	   private Button loginButton;
	  
	@FXML
	   private Button registerButton;
	
	   @FXML
	   private TextField emailField;
	   
	   @FXML
	   private PasswordField passwordField;
	  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
	 
	   public void loginAction(ActionEvent event) {
	       PersonFacade facade = new PersonFacade();
	       Routing rout= new Routing();
		   boolean res = facade.load(emailField.getText(), passwordField.getText());
		   if(!res) {
			   rout.alerte("Wrong email or password !");
			   rout.goTo("connectionPage");
		   }
		   else {
			   Routing.setPersonFacade(facade);
			   rout.goTo("homePage");
		   }
		   
	   }
	   
	   public void registerAction(ActionEvent event) {
		   	Routing rout= new Routing();
       		rout.goTo("registerPage");
	   }
}
