
package application;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import binManagerFacade.ListManagerFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerManagementController.
 */
public class ManagerManagementController extends HomeController implements Initializable {

	/** The list manager view. */
	@FXML
	private ListView<String> listManagerView;
	
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
	
	/** The name manager. */
	@FXML
	private Label nameManager;
	
	/** The email manager. */
	@FXML
	private Label emailManager;
	
	/** The pane manager. */
	@FXML
	private AnchorPane paneManager;
	
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
	private ListManagerFacade facade;

/** The list name. */
//			private ObservableList<Person> listManager = FXCollections.observableArrayList();
	private ObservableList<String> listName = FXCollections.observableArrayList();
	
	/** The role. */
	private String role = HomeController.getFacade().getPerson().getRole().toString();
	
	/**
	 * Initialize.
	 *
	 * @param location the location
	 * @param resources the resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initMenuBar();
		if (role.equals("admin")) {
			addButton.setVisible(true);
		}
		this.facade = new ListManagerFacade();
		ArrayList<String> infos = new ArrayList<>();
		facade.load(infos);
		for (int i = 0; i < facade.getListManager().size(); i++) {
			listName.add(facade.getListManager().getManager(i).getName());
		}

		listManagerView.setItems(listName);
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
		nameField.setVisible(false);
		emailField.setVisible(false);
		nameManager.setVisible(true);
		emailManager.setVisible(true);
		nameManager.setText(listManagerView.getSelectionModel().getSelectedItem());
		int i = listManagerView.getSelectionModel().getSelectedIndex();
		if(i!=-1) {
			   emailManager.setText(facade.getListManager().getManager(i).getEmail());
			   name.setVisible(true);
			   moreInfo.setVisible(true);
			   editButton.setVisible(true);
			   if(HomeController.getFacade().getPerson().getRole().toString().contentEquals("admin")) {
				   deleteButton.setVisible(true); 
			   }
			   
			   paneManager.setVisible(true);
			   email.setVisible(true);
		   }else {
			   alerte("You should select one manager");
		   }
		
	}

	/**
	 * Adds the action.
	 *
	 * @param event the event
	 */
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

	/**
	 * Delete action.
	 *
	 * @param event the event
	 */
	public void deleteAction(ActionEvent event) {
		int i = listManagerView.getSelectionModel().getSelectedIndex();
		facade.delete(facade.getListManager().getManager(i).getEmail());
		rout.goTo("managerManagementPage");
	}

	/**
	 * Edits the action.
	 *
	 * @param event the event
	 */
	public void editAction(ActionEvent event) {
		nameManager.setVisible(false);
		editButton.setVisible(false);
		deleteButton.setVisible(false);
		nameField.setVisible(true);
		validateEditButton.setVisible(true);
		moreInfo.setText("Edit a manager");
	}

	/**
	 * Validate edit action.
	 *
	 * @param event the event
	 */
	public void validateEditAction(ActionEvent event) {
		ArrayList<String> info = new ArrayList<>();
		int i = listManagerView.getSelectionModel().getSelectedIndex();
		info.add(facade.getListManager().getManager(i).getEmail());
		info.add(nameField.getText());
		facade.update(info);
		rout.goTo("managerManagementPage");

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
