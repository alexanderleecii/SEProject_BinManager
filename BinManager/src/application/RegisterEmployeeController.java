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

public class RegisterEmployeeController extends homeController implements Initializable {
	
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
		   initMenuBar();
	   }
	   
	   public void registerAction(ActionEvent event) {
		   PersonFacade facade = new PersonFacade();
		   ArrayList<String> info = new ArrayList<>();
		   info.add(emailField.getText());
		   info.add(passwordField.getText());
		   info.add(nameField.getText());
		   info.add("employee");
		   if(emailField.getText().equals("") || passwordField.getText().equals("") || nameField.getText().equals("")) {
			   alerte("You should fill all field"); 
		   }
		   else {
			   boolean res = facade.add(info);
			   if(!res) {
				   alerte("The employee is already in the database");
			   }
			   rout.goTo("employeeManagementPage");
		   }
	   }
	   public void goBackAction(ActionEvent event) {
		   rout.goTo("employeeManagementPage");
	   }
	   
}
