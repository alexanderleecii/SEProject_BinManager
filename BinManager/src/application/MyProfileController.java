package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import binManagerFacade.PersonFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class MyProfileController.
 */
public class MyProfileController extends HomeController implements Initializable {
	
		/** The name. */
		@FXML
		private Label name;
		
		/** The email. */
		@FXML
		private Label email;
		
		/** The password. */
		@FXML
		private Label password;
		
		/** The name edit button. */
		@FXML
		private Button nameEditButton;
		
		/** The password edit button. */
		@FXML
		private Button passwordEditButton;
		
		/** The delete button. */
		@FXML
		private Button deleteButton;
		
		/** The edit label 1. */
		@FXML
		private Label editLabel1;
		
		/** The edit label 2. */
		@FXML
		private Label editLabel2;
		
		/** The validate name button. */
		@FXML
		private Button validateNameButton;
		
		/** The validate password button. */
		@FXML
		private Button validatePasswordButton;
		
		/** The edit text field 1. */
		@FXML
		private TextField editTextField1;
		
		/** The edit text field 2. */
		@FXML
		private TextField editTextField2;
		
		/** The edit pane. */
		@FXML
		private AnchorPane editPane;
		
		/** The facade. */
		private PersonFacade facade;
		
		/** The rout. */
		protected Routing rout = new Routing();
		
	   /**
   	 * Initialize.
   	 *
   	 * @param location the location
   	 * @param resources the resources
   	 */
   	@Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   editPane.setVisible(false);
		   validateNameButton.setVisible(false);
		   validatePasswordButton.setVisible(false);
		   facade = HomeController.getFacade();
		   name.setText(facade.getPerson().getName());
		   email.setText(facade.getPerson().getEmail());
		   String pswd = "";
		   for(int i=0;i<facade.getPerson().getPassword().length();i++) {
			   pswd+="*";
		   }
		   password.setText(pswd);
	   }
	   
	   /**
   	 * Name edit action.
   	 *
   	 * @param event the event
   	 */
   	public void nameEditAction(ActionEvent event) {
		   validatePasswordButton.setVisible(false);
		   editPane.setVisible(true);
		   editLabel1.setText("Name :");
		   editLabel2.setVisible(false);
		   editTextField1.setVisible(true);
		   editTextField2.setVisible(false);
		   validateNameButton.setVisible(true);
		   
	   }
	   
   	/**
   	 * Password edit action.
   	 *
   	 * @param event the event
   	 */
   	public void passwordEditAction(ActionEvent event) {
		   validateNameButton.setVisible(false);
		   editPane.setVisible(true);
		   editLabel1.setText("Old pswd :");
		   editLabel2.setVisible(true);
		   editLabel2.setText("New pswd :");
		   editTextField1.setVisible(true);
		   editTextField2.setVisible(true);
		   validatePasswordButton.setVisible(true);
	   }
	   
   	/**
   	 * Validate name action.
   	 *
   	 * @param event the event
   	 */
   	public void validateNameAction(ActionEvent event) {
		   ArrayList<String> infos = new ArrayList<>();
		   infos.add(facade.getPerson().getEmail());
		   infos.add(facade.getPerson().getPassword());
		   infos.add(editTextField1.getText());
		   infos.add(facade.getPerson().getRole().toString());
		   facade.update(infos);
		   rout.goTo("profilePage");
		   
	   }
	   
   	/**
   	 * Validate password action.
   	 *
   	 * @param event the event
   	 */
   	public void validatePasswordAction(ActionEvent event) {
		   if(editTextField1.getText().equals(facade.getPerson().getPassword())) {
			   ArrayList<String> infos = new ArrayList<>();
			   infos.add(facade.getPerson().getEmail());
			   infos.add(editTextField2.getText());
			   infos.add(facade.getPerson().getName());
			   infos.add(facade.getPerson().getRole().toString());
			   facade.update(infos);
			   rout.goTo("profilePage");
		   }
		   else {
			   alerte("Your old password is wrong");
		   }
	   }
	   
   	/**
   	 * Delete action.
   	 *
   	 * @param event the event
   	 */
   	public void deleteAction(ActionEvent event) {
		   facade.delete(facade.getPerson().getEmail());
		   rout.goTo("connectionPage");
	   }
	   
}
