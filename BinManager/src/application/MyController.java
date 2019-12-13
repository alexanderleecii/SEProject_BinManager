package application;

import java.net.URL;

import java.util.ResourceBundle;

import BinManagerDAO.PersonDAOSQL;
import BinManagerPerson.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class MyController implements Initializable {
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
	       PersonDAOSQL p = new PersonDAOSQL();
		   Person example = p.load(emailField.getText());
		   System.out.println(example.getName());
	   }	
}
