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
		private Label moreInfo;
		@FXML
		private Label name;
		@FXML
		private Label email;
		@FXML
		private Label nameEmployee;
		@FXML
		private Label emailEmployee;
		@FXML
		private AnchorPane paneEmployee;
		
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
		   rout.goTo("registerEmployeePage");
	   }

	   public void deleteAction(ActionEvent event) {
//		   int i = listEmployeeView.getSelectionModel().getSelectedIndex();
//		   facade.delete(facade.getListEmployee().getEmployee(i));
//		   rout.goTo("employeeManagementPage");
	   }
	   
	   public void editAction(ActionEvent event) {
		   
	   }

}
