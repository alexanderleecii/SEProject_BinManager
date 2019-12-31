package application;

import java.net.URL;


import java.util.ArrayList;
import java.util.ResourceBundle;

import BinManagerFacade.ListCommentFacade;
import BinManagerFacade.ListBinFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BinManagementController extends HomeController implements Initializable{
	@FXML
	private ListView<String> listBinView;
	@FXML
	private ListView<String> listCommentView;
	@FXML
	private Button seeMoreButton;
	@FXML
	private Button seeMoreCommentButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button alertCommentButton;
	@FXML
	private Button seeCommentsButton;
	@FXML
	private Button seeAlertsButton;
	@FXML
	private Button addButton;
	@FXML
	private Button validateEditButton;
	@FXML
	private Button validateAddButton;
	@FXML
	private Button sendCommentButton;
	@FXML
	private Button deleteCommentButton;
	@FXML
	private Label paneLabel;
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
	private Label addAlertComment;
	@FXML
	private Label detailCommentLabel;
	@FXML
	private Label binCommentLabel;
	@FXML
	private Label usernameCommentLabel;
	@FXML
	private AnchorPane paneBin;
	@FXML
	private AnchorPane paneComment;
	@FXML
	private AnchorPane paneDetailComment;
	@FXML
	private TextField typeField;
	@FXML
	private TextField stateField;
	@FXML
	private TextField positionField;
	@FXML
	private ChoiceBox<String> choiceBox;
	@FXML
	private TextArea commentArea;
	@FXML
	private TextArea textComment;
	
	private ListBinFacade binFacade;
	
	private ObservableList<String> listName = FXCollections.observableArrayList();
	
	private ObservableList<String> listComments = FXCollections.observableArrayList();
	private ObservableList<String> listAlerts = FXCollections.observableArrayList();   
	
	private ListCommentFacade commentFacade = new ListCommentFacade();
	
	private String role = HomeController.getFacade().getPerson().getRole().toString();
	@Override
   public void initialize(URL location, ResourceBundle resources) {
		initMenuBar();
		if(role.equals("admin") || role.equals("manager")) {
			addButton.setVisible(true);
		}
		if(!role.equals("citizen")) {
			seeCommentsButton.setVisible(true);
			seeAlertsButton.setVisible(true);
		}
	   this.binFacade = new ListBinFacade();
	   ArrayList<String> infos = new ArrayList<>();
	   binFacade.load(infos);
	   for(int i=0;i<binFacade.getListBin().size();i++) {
		   listName.add("Bin "+binFacade.getListBin().getBin(i).getId());
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
		   if(i!=-1) {
			   typeBin.setVisible(true);
			   typeBin.setText(binFacade.getListBin().getBin(i).getType());
			   stateBin.setVisible(true);
			   
			   String stateStr;
			   if(binFacade.getListBin().getBin(i).getState() == false) {
				   stateStr = "not full";
			   }
			   else {
				   stateStr = "full";
			   }
			   stateBin.setText(stateStr);
			   
			   positionBin.setVisible(true);
			   positionBin.setText(binFacade.getListBin().getBin(i).getPosition().toString());
			   
			   if(!role.equals("citizen") && !role.equals("visitor")) {
				   editButton.setVisible(true);
			   }
			   
			   if(role.equals("admin") || role.equals("manager")) {
				   deleteButton.setVisible(true);
			   }
			   if(role.equals("citizen")) {
				   alertCommentButton.setVisible(true);
			   }
		   }else {
			   alerte("You should select one bin");
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
		   binFacade.delete(binFacade.getListBin().getBin(i).getId());
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
		   info.add(""+binFacade.getListBin().getBin(i).getId());
		   info.add(typeField.getText());
		   info.add(stateField.getText());
		   info.add(positionField.getText());
		   binFacade.update(info); 
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
			   boolean res = binFacade.add(info);
			   if(!res) {
				   alerte("The bin is already in the database");
			   }
			   rout.goTo("binManagementPage");
		   }
	   }
	   
	   public void alertCommentAction(ActionEvent event) {
		   paneBin.setVisible(false);
		   moreInfo.setVisible(false);
		   type.setVisible(false);
		   state.setVisible(false);
		   position.setVisible(false);
		   typeBin.setVisible(false);
		   stateBin.setVisible(false);
		   positionBin.setVisible(false);
		   
		   paneComment.setVisible(true);
		   addAlertComment.setVisible(true);
		   choiceBox.setVisible(true);
		   commentArea.setVisible(true);
		   sendCommentButton.setVisible(true);
		   
		   choiceBox.getItems().clear();
		   choiceBox.getItems().addAll("Comment", "Alert");
		   choiceBox.getSelectionModel().select("Comment");
		   
	   }
	   
	   public void sendCommentAction(ActionEvent event) {
		   ListCommentFacade commentFacade = new ListCommentFacade();
		   if(commentArea.getText().equals("")) {
			   alerte("Please add some text");
		   }
		   else {
			   ArrayList<String> info = new ArrayList<>();
			   int i = listBinView.getSelectionModel().getSelectedIndex();
			   info.add(""+binFacade.getListBin().getBin(i).getId());
			   info.add(choiceBox.getSelectionModel().getSelectedItem());
			   info.add(super.getFacade().getPerson().getEmail());
			   info.add(commentArea.getText());
			   boolean res = commentFacade.add(info);
			   if(!res) {
				   alerte("There was an issue posting this comment");
			   }
			   rout.goTo("binManagementPage");
		   }
	   }
	   
	   public void seeCommentsAction(ActionEvent event) {
		   addButton.setVisible(false);
		   seeMoreButton.setVisible(false);
		   seeMoreCommentButton.setVisible(true);
		   
		   paneBin.setVisible(false);
		   moreInfo.setVisible(false);
		   type.setVisible(false);
		   state.setVisible(false);
		   position.setVisible(false);
		   typeBin.setVisible(false);
		   stateBin.setVisible(false);
		   positionBin.setVisible(false);
		   
		   seeCommentsButton.setVisible(false);
		   seeAlertsButton.setVisible(false);
		   
		   paneLabel.setText("Comments");
		   
		   ArrayList<String> infos = new ArrayList<>();
		   
		   int j = listBinView.getSelectionModel().getSelectedIndex();
		   
		   infos.add("comments");
		   infos.add(""+binFacade.getListBin().getBin(j).getId());
		   commentFacade.load(infos);
		   for(int i=0;i<commentFacade.getListComment().size();i++) {
			   listComments.add("Comment "+commentFacade.getListComment().getComment(i).getId()+"  "+commentFacade.getListComment().getComment(i).getDate());
		   }
		   listBinView.setVisible(false);
		   listCommentView.setVisible(true);
		   
		   listCommentView.setItems(listComments);
	   }
	   
	   public void seeAlertsAction(ActionEvent event) {
		   addButton.setVisible(false);
		   seeMoreButton.setVisible(false);
		   seeMoreCommentButton.setVisible(true);
		   
		   paneBin.setVisible(false);
		   moreInfo.setVisible(false);
		   type.setVisible(false);
		   state.setVisible(false);
		   position.setVisible(false);
		   typeBin.setVisible(false);
		   stateBin.setVisible(false);
		   positionBin.setVisible(false);
		   
		   seeCommentsButton.setVisible(false);
		   seeAlertsButton.setVisible(false);
		   
		   paneLabel.setText("Alerts");
		   
		   ArrayList<String> infos = new ArrayList<>();
		   
		   int j = listBinView.getSelectionModel().getSelectedIndex();
		   
		   infos.add("alerts");
		   infos.add(""+binFacade.getListBin().getBin(j).getId());
		   commentFacade.load(infos);
		   for(int i=0;i<commentFacade.getListComment().size();i++) {
			   listAlerts.add("Alert "+commentFacade.getListComment().getComment(i).getId()+"  "+commentFacade.getListComment().getComment(i).getDate());
		   }
		   listBinView.setVisible(false);
		   listCommentView.setVisible(true);
		   
		   listCommentView.setItems(listAlerts);
	   }
	   
	   public void seeMoreCommentAction(ActionEvent event) {
		   int i = listCommentView.getSelectionModel().getSelectedIndex();
		   paneDetailComment.setVisible(true);
		   detailCommentLabel.setVisible(true);
		   if(commentFacade.getListComment().getComment(i).getType().equals("alert")) {
			   detailCommentLabel.setText("Alert");
		   }
		   else {
			   detailCommentLabel.setText("Comment");
		   }
		   binCommentLabel.setVisible(true);
		   usernameCommentLabel.setVisible(true);
		   textComment.setVisible(true);
		   deleteCommentButton.setVisible(true);
		   
		   binCommentLabel.setText("Bin : |||");//TODO change to get the real id
		   usernameCommentLabel.setText("User : |||");//TODO change to get the real username
		   textComment.setText(commentFacade.getListComment().getComment(i).getText());
	   }
	   
	   public void deleteCommentAction(ActionEvent event) {
		   System.out.println("delete ok");
	   }
}
