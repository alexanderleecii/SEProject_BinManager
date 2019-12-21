package application;

import java.awt.Panel;
//import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.PersonFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import BinManagerPerson.Person;
import javafx.event.*;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
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
		
		private ObservableList<String> listEmployee = FXCollections.observableArrayList("Mark");
		
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		   initMenuBar();
		   fillTheList(listEmployee);
		   listEmployeeView.setItems(listEmployee);
	   }
	   
	   public void fillTheList(ObservableList<String> list) {
		   list.add("Lalala");
		   list.add("Lololo");
		   list.add("Mamama");
		   list.add("Dedede");
		   list.add("Momomo");
		   list.add("Lalala");
		   list.add("Lololo");
		   list.add("Mamama");
		   list.add("Dedede");
		   list.add("Momomo");
	   }
	   
	   public void seeMoreAction(ActionEvent event) {
		   nameEmployee.setText(listEmployeeView.getSelectionModel().getSelectedItem());
		   name.setVisible(true);
		   moreInfo.setVisible(true);
		   editButton.setVisible(true);
		   deleteButton.setVisible(true);
		   paneEmployee.setVisible(true);
	   }
	   
}
