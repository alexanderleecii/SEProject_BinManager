package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BinManagerFacade.PersonFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class myProfileController extends homeController implements Initializable {
	
		@FXML
		private Label name;
		@FXML
		private Label email;
		@FXML
		private Label password;
		@FXML
		private Button nameEditButton;
		@FXML
		private Button passwordEditButton;
		@FXML
		private Button deleteButton;
		@FXML
		private Label editLabel1;
		@FXML
		private Label editLabel2;
		@FXML
		private Button validateNameButton;
		@FXML
		private Button validatePasswordButton;
		@FXML
		private TextField editTextField1;
		@FXML
		private TextField editTextField2;
		@FXML
		private AnchorPane editPane;
		
		private PersonFacade facade;
		protected Routing rout = new Routing();
		
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   editPane.setVisible(false);
		   validateNameButton.setVisible(false);
		   validatePasswordButton.setVisible(false);
		   facade = Routing.getFacade();
		   name.setText(facade.getPerson().getName());
		   email.setText(facade.getPerson().getEmail());
		   String pswd = "";
		   for(int i=0;i<facade.getPerson().getPassword().length();i++) {
			   pswd+="*";
		   }
		   password.setText(pswd);
	   }
	   
	   public void nameEditAction(ActionEvent event) {
		   validatePasswordButton.setVisible(false);
		   editPane.setVisible(true);
		   editLabel1.setText("Name :");
		   editLabel2.setVisible(false);
		   editTextField1.setVisible(true);
		   editTextField2.setVisible(false);
		   validateNameButton.setVisible(true);
		   
	   }
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
	   public void validateNameAction(ActionEvent event) {
		   ArrayList<String> infos = new ArrayList<>();
		   infos.add(facade.getPerson().getEmail());
		   infos.add(facade.getPerson().getPassword());
		   infos.add(editTextField1.getText());
		   infos.add(facade.getPerson().getRole().toString());
		   facade.update(infos);
		   rout.goTo("profilePage");
		   
	   }
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
	   public void deleteAction(ActionEvent event) {
	   }
	   
}
