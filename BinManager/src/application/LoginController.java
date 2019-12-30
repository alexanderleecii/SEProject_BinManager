package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LoginController extends HomeController implements Initializable {
	@FXML
	   private Button loginButton;
	  
	@FXML
	   private Button registerButton;
	
	   @FXML
	   private TextField emailField;
	   
	   @FXML
	   private PasswordField passwordField;
	   
	   protected Routing rout = new Routing();
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
	   }
	 
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
