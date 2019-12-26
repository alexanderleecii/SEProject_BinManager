package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BinManagerFacade.ListBinFacade;
import BinManagerFacade.ListEmployeeFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BinManagementController extends HomeController implements Initializable{
	@FXML
	private ListView<String> listBinView;
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
	private Label type;
	@FXML
	private Label state;
	@FXML
	private Label position;
	@FXML
	private Label typeBin;
	@FXML
	private Label stateBin;
	@FXML
	private Label positionBin;
	@FXML
	private AnchorPane paneBin;
	@FXML
	private TextField typeField;
	@FXML
	private TextField stateField;
	@FXML
	private TextField positionField;
	
	private ListBinFacade facade;
	
	private ObservableList<String> listName = FXCollections.observableArrayList();
	
	private String role = HomeController.getFacade().getPerson().getRole().toString();
	@Override
   public void initialize(URL location, ResourceBundle resources) {
		initMenuBar();
		if(role.equals("admin") || role.equals("manager")) {
			addButton.setVisible(true);
		}
	   this.facade = new ListBinFacade();
	   ArrayList<String> infos = new ArrayList<>();
	   facade.load(infos);
	   for(int i=0;i<facade.getListBin().size();i++) {
		   listName.add("Bin "+facade.getListBin().getBin(i).getId());
	   }
	   listBinView.setItems(listName);
   }
	
	public void seeMoreAction(ActionEvent event) {
			paneBin.setVisible(true);	
			moreInfo.setVisible(true);
			validateAddButton.setVisible(false);
			type.setVisible(true);
			state.setVisible(true);
			position.setVisible(true);
		   typeField.setVisible(false);
		   stateField.setVisible(false);
		   positionField.setVisible(false);
		   int i = listBinView.getSelectionModel().getSelectedIndex();
		   typeBin.setVisible(true);
		   typeBin.setText(facade.getListBin().getBin(i).getType());
		   stateBin.setVisible(true);
		   
		   String stateStr;
		   if(facade.getListBin().getBin(i).getState() == false) {
			   stateStr = "not full";
		   }
		   else {
			   stateStr = "full";
		   }
		   stateBin.setText(stateStr);
		   
		   positionBin.setVisible(true);
		   positionBin.setText(facade.getListBin().getBin(i).getPosition().toString());
		   
		   if(!role.equals("citizen") && !role.equals("visitor")) {
			   editButton.setVisible(true);
		   }
		   
		   if(role.equals("admin") || role.equals("manager")) {
			   deleteButton.setVisible(true);
		   }
	   }
	   
	   public void addAction(ActionEvent event) {
		   typeBin.setVisible(false);
		   stateBin.setVisible(false);
		   positionBin.setVisible(false);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   paneBin.setVisible(true);
		   type.setVisible(true);
		   state.setVisible(true);
		   position.setVisible(true);
		   typeField.setVisible(true);
		   stateField.setVisible(true);
		   positionField.setVisible(true);
		   validateAddButton.setVisible(true);
		   moreInfo.setVisible(true);
		   moreInfo.setText("Add a bin");
	   }

	   public void deleteAction(ActionEvent event) {
		   int i = listBinView.getSelectionModel().getSelectedIndex();
		   facade.delete(facade.getListBin().getBin(i).getId());
		   rout.goTo("binManagementPage");
	   }
	   
	   public void editAction(ActionEvent event) {
		   typeBin.setVisible(false);
		   stateBin.setVisible(false);
		   positionBin.setVisible(false);
		   typeField.setVisible(true);
		   stateField.setVisible(true);
		   positionField.setVisible(true);
		   editButton.setVisible(false);
		   deleteButton.setVisible(false);
		   validateEditButton.setVisible(true);
		   moreInfo.setText("Edit a bin");
	   }
	   
	   public void validateEditAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   int i = listBinView.getSelectionModel().getSelectedIndex();
		   info.add(""+facade.getListBin().getBin(i).getId());
		   info.add(typeField.getText());
		   info.add(stateField.getText());
		   info.add(positionField.getText());
		   facade.update(info); 
		   rout.goTo("binManagementPage");
		   
	   }
	   public void validateAddAction(ActionEvent event) {
		   ArrayList<String> info = new ArrayList<>();
		   info.add(typeField.getText());
		   info.add(stateField.getText());
		   info.add(positionField.getText());
		   if(typeField.getText().equals("") || stateField.getText().equals("") || positionField.getText().equals("")) {
			   alerte("You should fill all field");
		   }
		   else {
			   boolean res = facade.add(info);
			   if(!res) {
				   alerte("The bin is already in the database");
			   }
			   rout.goTo("binManagementPage");
		   }
	   }
}
