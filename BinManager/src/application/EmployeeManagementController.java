package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import binManagerFacade.ListEmployeeFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeManagementController.
 */
public class EmployeeManagementController extends HomeController implements Initializable {
	
		/** The list employee view. */
		@FXML
		private ListView<String> listEmployeeView;
		
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
		
		/** The name employee. */
		@FXML
		private Label nameEmployee;
		
		/** The email employee. */
		@FXML
		private Label emailEmployee;
		
		/** The pane employee. */
		@FXML
		private AnchorPane paneEmployee;
		
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
		private ListEmployeeFacade facade;
		
/** The list name. */
//		private ObservableList<Person> listEmployee = FXCollections.observableArrayList();
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
		   this.facade = new ListEmployeeFacade();
		   ArrayList<String> infos = new ArrayList<>();
		   facade.load(infos);
		   for(int i=0;i<facade.getListEmployee().size();i++) {
				   listName.add(facade.getListEmployee().getEmployee(i).getName());
		   }
		   listEmployeeView.setItems(listName);
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
		   nameEmployee.setVisible(true);
		   emailEmployee.setVisible(true);
		   nameEmployee.setText(listEmployeeView.getSelectionModel().getSelectedItem());
		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
		   if(i!=-1) {
			   emailEmployee.setText(facade.getListEmployee().getEmployee(i).getEmail());
			   name.setVisible(true);
			   moreInfo.setVisible(true);
			   editButton.setVisible(true);
			   deleteButton.setVisible(true);
			   paneEmployee.setVisible(true);
			   email.setVisible(true);
		   }else {
			   alerte("You should select one employee");
		   }
	   }
	   
	   /**
   	 * Adds the action.
   	 *
   	 * @param event the event
   	 */
   	public void addAction(ActionEvent event) {
		   nameEmployee.setVisible(false);
		   emailEmployee.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   paneEmployee.setVisible(true);
		   email.setVisible(true);
		   name.setVisible(true);
		   password.setVisible(true);
		   nameField.setVisible(true);
		   emailField.setVisible(true);
		   passwordField.setVisible(true);
		   validateAddButton.setVisible(true);
		   moreInfo.setVisible(true);
		   moreInfo.setText("Add an employee");
	   }

	   /**
   	 * Delete action.
   	 *
   	 * @param event the event
   	 */
   	public void deleteAction(ActionEvent event) {
		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
		   facade.delete(facade.getListEmployee().getEmployee(i).getEmail());
		   rout.goTo("employeeManagementPage");
	   }
	   
	   /**
   	 * Edits the action.
   	 *
   	 * @param event the event
   	 */
   	public void editAction(ActionEvent event) {
		   nameEmployee.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   nameField.setVisible(true);
		   validateEditButton.setVisible(true);
		   moreInfo.setText("Edit an employee");
	   }
	   
	   /**
   	 * Validate edit action.
   	 *
   	 * @param event the event
   	 */
   	public void validateEditAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
		   info.add(facade.getListEmployee().getEmployee(i).getEmail());
		   info.add(nameField.getText());
		   facade.update(info); 
		   rout.goTo("employeeManagementPage");
		   
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

}
