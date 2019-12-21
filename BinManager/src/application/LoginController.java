package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LoginController extends homeController implements Initializable {
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
	       ArrayList<String> infos = new ArrayList<>();
	       infos.add(emailField.getText());
	       infos.add(passwordField.getText());
		   boolean res = facade.load(infos);
		   if(!res) {
			   alerte("Wrong email or password !");
			   rout.goTo("connectionPage");
		   }
		   else {
			   Routing.setPersonFacade(facade);
			   rout.goTo("homePage");
		   }
		   
	   }
	   
	   public void registerAction(ActionEvent event) {
       		rout.goTo("registerPage");
	   }
}
