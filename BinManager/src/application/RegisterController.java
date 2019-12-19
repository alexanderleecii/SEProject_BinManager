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

public class RegisterController implements Initializable {
	@FXML
	   private Button registerButton;
	  
	   @FXML
	   private TextField emailField;
	   
	   @FXML
	   private TextField nameField;
	   
	   @FXML
	   private PasswordField passwordField;
	  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
	 
	   public void registerAction(ActionEvent event) {
		   PersonFacade facade = new PersonFacade();
		   ArrayList<String> info = new ArrayList<>();
		   info.add(emailField.getText());
		   info.add(passwordField.getText());
		   info.add(nameField.getText());
		   info.add("citizen");
		   facade.add(info);
		   Routing rout= new Routing();
		   rout.goTo("connectionPage");
	   }
}
