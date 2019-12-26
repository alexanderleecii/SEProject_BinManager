package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BinManagerFacade.ListCitizenFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class CitizenManagementController extends HomeController implements Initializable {
	
		@FXML
		private ListView<String> listCitizenView;
		@FXML
		private Button seeMoreButton;
		@FXML
		private Button editButton;
		@FXML
		private Button deleteButton;
		@FXML
		private Button addButton;
		@FXML
		private Button validateEditButton;
		@FXML
		private Button validateAddButton;
		@FXML
		private Label moreInfo;
		@FXML
		private Label name;
		@FXML
		private Label email;
		@FXML
		private Label password;
		@FXML
		private Label nameCitizen;
		@FXML
		private Label emailCitizen;
		@FXML
		private AnchorPane paneCitizen;
		@FXML
		private TextField emailField;
		@FXML
		private TextField nameField;
		@FXML
		private TextField passwordField;
		private ListCitizenFacade facade;
		
//		private ObservableList<Person> listCitizen = FXCollections.observableArrayList();
		private ObservableList<String> listName = FXCollections.observableArrayList();
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   this.facade = new ListCitizenFacade();
		   ArrayList<String> infos = new ArrayList<>();
		   facade.load(infos);
		   for(int i=0;i<facade.getListCitizen().size();i++) {
				   listName.add(facade.getListCitizen().getCitizen(i).getName());
		   }
		   listCitizenView.setItems(listName);
	   }
	   
	   
	   public void seeMoreAction(ActionEvent event) {
		   password.setVisible(false);
		   passwordField.setVisible(false);
		   validateAddButton.setVisible(false);
		   validateEditButton.setVisible(false);
		   nameField.setVisible(false);
		   emailField.setVisible(false);
		   nameCitizen.setVisible(true);
		   emailCitizen.setVisible(true);
		   nameCitizen.setText(listCitizenView.getSelectionModel().getSelectedItem());
		   int i = listCitizenView.getSelectionModel().getSelectedIndex();
		   if(i!=-1) {
			   emailCitizen.setText(facade.getListCitizen().getCitizen(i).getEmail());
			   name.setVisible(true);
			   moreInfo.setVisible(true);
			   editButton.setVisible(true);
			   deleteButton.setVisible(true);
			   paneCitizen.setVisible(true);
			   email.setVisible(true);
		   }else {
			   alerte("You should select one citizen");
		   }
	   }
	   
	   public void addAction(ActionEvent event) {
		   nameCitizen.setVisible(false);
		   emailCitizen.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   paneCitizen.setVisible(true);
		   email.setVisible(true);
		   name.setVisible(true);
		   password.setVisible(true);
		   nameField.setVisible(true);
		   emailField.setVisible(true);
		   passwordField.setVisible(true);
		   validateAddButton.setVisible(true);
		   moreInfo.setVisible(true);
		   moreInfo.setText("Add a citizen");
	   }

	   public void deleteAction(ActionEvent event) {
		   int i = listCitizenView.getSelectionModel().getSelectedIndex();
		   facade.delete(facade.getListCitizen().getCitizen(i).getEmail());
		   rout.goTo("citizenManagementPage");
	   }
	   
	   public void editAction(ActionEvent event) {
		   nameCitizen.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   nameField.setVisible(true);
		   validateEditButton.setVisible(true);
		   moreInfo.setText("Edit an citizen");
	   }
	   
	   public void validateEditAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   int i = listCitizenView.getSelectionModel().getSelectedIndex();
		   info.add(facade.getListCitizen().getCitizen(i).getEmail());
		   info.add(nameField.getText());
		   facade.update(info); 
		   rout.goTo("citizenManagementPage");
		   
	   }
	   public void validateAddAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   info.add(emailField.getText());
		   info.add(passwordField.getText());
		   info.add(nameField.getText());
		   info.add("citizen");
		   if(emailField.getText().equals("") || passwordField.getText().equals("") || nameField.getText().equals("")) {
			   alerte("You should fill all field"); 
		   }
		   else {
			   boolean res = facade.add(info);
			   if(!res) {
				   alerte("The citizen is already in the database");
			   }
			   rout.goTo("citizenManagementPage");
		   }
	   }

}
