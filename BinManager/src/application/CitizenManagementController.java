package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import binManagerFacade.ListCitizenFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class CitizenManagementController.
 */
public class CitizenManagementController extends HomeController implements Initializable {
	
		/** The list citizen view. */
		@FXML
		private ListView<String> listCitizenView;
		
		/** The see more button. */
		@FXML
		private Button seeMoreButton;
		
		/** The edit button. */
		@FXML
		private Button editButton;
		
		/** The delete button. */
		@FXML
		private Button deleteButton;
		
		/** The add button. */
		@FXML
		private Button addButton;
		
		/** The validate edit button. */
		@FXML
		private Button validateEditButton;
		
		/** The validate add button. */
		@FXML
		private Button validateAddButton;
		
		/** The more info. */
		@FXML
		private Label moreInfo;
		
		/** The name. */
		@FXML
		private Label name;
		
		/** The email. */
		@FXML
		private Label email;
		
		/** The password. */
		@FXML
		private Label password;
		
		/** The name citizen. */
		@FXML
		private Label nameCitizen;
		
		/** The email citizen. */
		@FXML
		private Label emailCitizen;
		
		/** The pane citizen. */
		@FXML
		private AnchorPane paneCitizen;
		
		/** The email field. */
		@FXML
		private TextField emailField;
		
		/** The name field. */
		@FXML
		private TextField nameField;
		
		/** The password field. */
		@FXML
		private TextField passwordField;
		
		/** The facade. */
		private ListCitizenFacade facade;
		
/** The list name. */
//		private ObservableList<Person> listCitizen = FXCollections.observableArrayList();
		private ObservableList<String> listName = FXCollections.observableArrayList();
	   
   	/**
   	 * Initialize.
   	 *
   	 * @param location the location
   	 * @param resources the resources
   	 */
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
	   
	   
	   /**
   	 * See more action.
   	 *
   	 * @param event the event
   	 */
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
	   
	   /**
   	 * Adds the action.
   	 *
   	 * @param event the event
   	 */
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

	   /**
   	 * Delete action.
   	 *
   	 * @param event the event
   	 */
   	public void deleteAction(ActionEvent event) {
		   int i = listCitizenView.getSelectionModel().getSelectedIndex();
		   facade.delete(facade.getListCitizen().getCitizen(i).getEmail());
		   rout.goTo("citizenManagementPage");
	   }
	   
	   /**
   	 * Edits the action.
   	 *
   	 * @param event the event
   	 */
   	public void editAction(ActionEvent event) {
		   nameCitizen.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   nameField.setVisible(true);
		   validateEditButton.setVisible(true);
		   moreInfo.setText("Edit an citizen");
	   }
	   
	   /**
   	 * Validate edit action.
   	 *
   	 * @param event the event
   	 */
   	public void validateEditAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   int i = listCitizenView.getSelectionModel().getSelectedIndex();
		   info.add(facade.getListCitizen().getCitizen(i).getEmail());
		   info.add(nameField.getText());
		   facade.update(info); 
		   rout.goTo("citizenManagementPage");
		   
	   }
	   
   	/**
   	 * Validate add action.
   	 *
   	 * @param event the event
   	 */
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
