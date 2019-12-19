package application;

//import java.io.IOException;
import java.net.URL;



import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
//import BinManagerPerson.Person;
import javafx.event.*;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.stage.Stage;

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
	 
	   // When user click on myButton
	   // this method will be called.
	   public void loginAction(ActionEvent event) {
	       PersonFacade facade = new PersonFacade();
	       Routing rout= new Routing();
		   facade.load(emailField.getText(), passwordField.getText());
		   if(facade.getPerson().getRole().toString().equals("citizen")){
			   System.out.println("You are connected as citizen");
			   rout.goTo("homeCitizenPage");
		   }
		   else if(facade.getPerson().getRole().toString().equals("manager")){
			   System.out.println("You are connected as manager");
			   rout.goTo("homeManagerPage");
		   }
		   else if(facade.getPerson().getRole().toString().equals("employee")){
			   System.out.println("You are connected as employee");
			   rout.goTo("homeEmployeePage");
		   }
		   else{
			   System.out.println("There is a problem with your account");
		   }
		   
	   }
	   
	   public void registerAction(ActionEvent event) {
		   	Routing rout= new Routing();
       		rout.goTo("registerPage");
	   }
}
