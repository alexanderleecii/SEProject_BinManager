package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BinManagerFacade.ListEmployeeFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class employeeManagementController extends homeController implements Initializable {
	
		@FXML
		private ListView<String> listEmployeeView;
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
		private Label nameEmployee;
		@FXML
		private Label emailEmployee;
		@FXML
		private AnchorPane paneEmployee;
		@FXML
		private TextField emailField;
		@FXML
		private TextField nameField;
		@FXML
		private TextField passwordField;
		private ListEmployeeFacade facade;
		
//		private ObservableList<Person> listEmployee = FXCollections.observableArrayList();
		private ObservableList<String> listName = FXCollections.observableArrayList();
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
	   
	   
	   public void seeMoreAction(ActionEvent event) {
		   password.setVisible(false);
		   passwordField.setVisible(false);
		   validateAddButton.setVisible(false);
		   nameField.setVisible(false);
		   emailField.setVisible(false);
		   nameEmployee.setVisible(true);
		   emailEmployee.setVisible(true);
		   nameEmployee.setText(listEmployeeView.getSelectionModel().getSelectedItem());
		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
		   emailEmployee.setText(facade.getListEmployee().getEmployee(i).getEmail());
		   name.setVisible(true);
		   moreInfo.setVisible(true);
		   editButton.setVisible(true);
		   deleteButton.setVisible(true);
		   paneEmployee.setVisible(true);
		   email.setVisible(true);
	   }
	   
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

	   public void deleteAction(ActionEvent event) {
		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
		   facade.delete(facade.getListEmployee().getEmployee(i).getEmail());
		   rout.goTo("employeeManagementPage");
	   }
	   
	   public void editAction(ActionEvent event) {
		   nameEmployee.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   nameField.setVisible(true);
		   validateEditButton.setVisible(true);
		   moreInfo.setText("Edit an employee");
	   }
	   
	   public void validateEditAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
		   info.add(facade.getListEmployee().getEmployee(i).getEmail());
		   info.add(nameField.getText());
		   facade.update(info); 
		   rout.goTo("employeeManagementPage");
		   
	   }
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
