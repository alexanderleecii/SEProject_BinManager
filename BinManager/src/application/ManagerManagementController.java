
package application;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import BinManagerFacade.ListManagerFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ManagerManagementController extends HomeController implements Initializable {

	@FXML
	private ListView<String> listManagerView;
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
	private Label nameManager;
	@FXML
	private Label emailManager;
	@FXML
	private AnchorPane paneManager;
	@FXML
	private TextField emailField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField passwordField;
	private ListManagerFacade facade;

//			private ObservableList<Person> listManager = FXCollections.observableArrayList();
	private ObservableList<String> listName = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initMenuBar();
		this.facade = new ListManagerFacade();
		ArrayList<String> infos = new ArrayList<>();
		facade.load(infos);
		for (int i = 0; i < facade.getListManager().size(); i++) {
			listName.add(facade.getListManager().getManager(i).getName());
		}
		listManagerView.setItems(listName);
	}

	public void seeMoreAction(ActionEvent event) {
		password.setVisible(false);
		passwordField.setVisible(false);
		validateAddButton.setVisible(false);
		nameField.setVisible(false);
		emailField.setVisible(false);
		nameManager.setVisible(true);
		emailManager.setVisible(true);
		nameManager.setText(listManagerView.getSelectionModel().getSelectedItem());
		int i = listManagerView.getSelectionModel().getSelectedIndex();
		emailManager.setText(facade.getListManager().getManager(i).getEmail());
		name.setVisible(true);
		moreInfo.setVisible(true);
		if (HomeController.getFacade().getPerson().getRole().toString().equals("manager")) {
			editButton.setVisible(false);
			deleteButton.setVisible(false);
		}else {
		editButton.setVisible(true);
		deleteButton.setVisible(true);
		}
		paneManager.setVisible(true);
		email.setVisible(true);
	}

	public void addAction(ActionEvent event) {
		nameManager.setVisible(false);
		emailManager.setVisible(false);
		editButton.setVisible(false);
		deleteButton.setVisible(false);
		paneManager.setVisible(true);
		email.setVisible(true);
		name.setVisible(true);
		password.setVisible(true);
		nameField.setVisible(true);
		emailField.setVisible(true);
		passwordField.setVisible(true);
		validateAddButton.setVisible(true);
		moreInfo.setVisible(true);
		moreInfo.setText("Add a manager");
	}

	public void deleteAction(ActionEvent event) {
		int i = listManagerView.getSelectionModel().getSelectedIndex();
		facade.delete(facade.getListManager().getManager(i).getEmail());
		rout.goTo("managerManagementPage");
	}

	public void editAction(ActionEvent event) {
		nameManager.setVisible(false);
		editButton.setVisible(false);
		deleteButton.setVisible(false);
		nameField.setVisible(true);
		validateEditButton.setVisible(true);
		moreInfo.setText("Edit a manager");
	}

	public void validateEditAction(ActionEvent event) {
		ArrayList<String> info = new ArrayList<>();
		int i = listManagerView.getSelectionModel().getSelectedIndex();
		info.add(facade.getListManager().getManager(i).getEmail());
		info.add(nameField.getText());
		facade.update(info);
		rout.goTo("managerManagementPage");

	}

	public void validateAddAction(ActionEvent event) {
		ArrayList<String> info = new ArrayList<>();
		info.add(emailField.getText());
		info.add(passwordField.getText());
		info.add(nameField.getText());
		info.add("manager");
		if (emailField.getText().equals("") || passwordField.getText().equals("") || nameField.getText().equals("")) {
			alerte("You should fill all field");
		} else {
			boolean res = facade.add(info);
			if (!res) {
				alerte("This manager is already in the database");
			}
			rout.goTo("managerManagementPage");
		}
	}

}
