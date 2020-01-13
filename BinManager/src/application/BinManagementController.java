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

// TODO: Auto-generated Javadoc
/**
 * The Class BinManagementController.
 */
public class BinManagementController extends HomeController implements Initializable{
	
	/** The list bin view. */
	@FXML
	private ListView<String> listBinView;
	
	/** The list comment view. */
	@FXML
	private ListView<String> listCommentView;
	
	/** The see more button. */
	@FXML
	private Button seeMoreButton;
	
	/** The see more comment button. */
	@FXML
	private Button seeMoreCommentButton;
	
	/** The edit button. */
	@FXML
	private Button editButton;
	
	/** The delete button. */
	@FXML
	private Button deleteButton;
	
	/** The alert comment button. */
	@FXML
	private Button alertCommentButton;
	
	/** The see comments button. */
	@FXML
	private Button seeCommentsButton;
	
	/** The see alerts button. */
	@FXML
	private Button seeAlertsButton;
	
	/** The add button. */
	@FXML
	private Button addButton;
	
	/** The validate edit button. */
	@FXML
	private Button validateEditButton;
	
	/** The validate add button. */
	@FXML
	private Button validateAddButton;
	
	/** The send comment button. */
	@FXML
	private Button sendCommentButton;
	
	/** The delete comment button. */
	@FXML
	private Button deleteCommentButton;
	
	/** The pane label. */
	@FXML
	private Label paneLabel;
	
	/** The more info. */
	@FXML
	private Label moreInfo;
	
	/** The type. */
	@FXML
	private Label type;
	
	/** The state. */
	@FXML
	private Label state;
	
	/** The position. */
	@FXML
	private Label position;
	
	/** The type bin. */
	@FXML
	private Label typeBin;
	
	/** The state bin. */
	@FXML
	private Label stateBin;
	
	/** The position bin. */
	@FXML
	private Label positionBin;
	
	/** The add alert comment. */
	@FXML
	private Label addAlertComment;
	
	/** The detail comment label. */
	@FXML
	private Label detailCommentLabel;
	
	/** The bin comment label. */
	@FXML
	private Label binCommentLabel;
	
	/** The username comment label. */
	@FXML
	private Label usernameCommentLabel;
	
	/** The pane bin. */
	@FXML
	private AnchorPane paneBin;
	
	/** The pane comment. */
	@FXML
	private AnchorPane paneComment;
	
	/** The pane detail comment. */
	@FXML
	private AnchorPane paneDetailComment;
	
	/** The type field. */
	@FXML
	private TextField typeField;
	
	/** The state field. */
	@FXML
	private TextField stateField;
	
	/** The position field. */
	@FXML
	private TextField positionField;
	
	/** The choice box. */
	@FXML
	private ChoiceBox<String> choiceBox;
	
	/** The comment area. */
	@FXML
	private TextArea commentArea;
	
	/** The text comment. */
	@FXML
	private TextArea textComment;
	
	/** The bin facade. */
	//Facade for the bin / listBin objects
	private ListBinFacade binFacade;
	
	/** The list name. */
	private ObservableList<String> listName = FXCollections.observableArrayList();
	
	/** The list comments. */
	private ObservableList<String> listComments = FXCollections.observableArrayList();
	
	/** The list alerts. */
	private ObservableList<String> listAlerts = FXCollections.observableArrayList();   
	
	/** The comment facade. */
	private ListCommentFacade commentFacade = new ListCommentFacade();
	
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
		//This method changes the display according to the connected user's role
		//Also loads the bin objects and displays them to the user
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
	
	/**
	 * See more action.
	 *
	 * @param event the event
	 */
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
	   
	   /**
   	 * Adds the action.
   	 *
   	 * @param event the event
   	 */
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

	   /**
   	 * Delete action.
   	 *
   	 * @param event the event
   	 */
   	public void deleteAction(ActionEvent event) {
		   int i = listBinView.getSelectionModel().getSelectedIndex();
		   binFacade.delete(binFacade.getListBin().getBin(i).getId());
		   rout.goTo("binManagementPage");
	   }
	   
	   /**
   	 * Edits the action.
   	 *
   	 * @param event the event
   	 */
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
	   
	   /**
   	 * Validate edit action.
   	 *
   	 * @param event the event
   	 */
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
	   
   	/**
   	 * Validate add action.
   	 *
   	 * @param event the event
   	 */
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
	   
	   /**
   	 * Alert comment action.
   	 *
   	 * @param event the event
   	 */
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
	   
	   /**
   	 * Send comment action.
   	 *
   	 * @param event the event
   	 */
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
	   
	   /**
   	 * See comments action.
   	 *
   	 * @param event the event
   	 */
   	public void seeCommentsAction(ActionEvent event) {   
		   
		   int j = listBinView.getSelectionModel().getSelectedIndex();
		   if(j!=-1) {
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
		   else {
			   alerte("You should select one bin");
		   }
	   }
	   
	   /**
   	 * See alerts action.
   	 *
   	 * @param event the event
   	 */
   	public void seeAlertsAction(ActionEvent event) {
		   
		   int j = listBinView.getSelectionModel().getSelectedIndex();
		   if(j!=-1) {
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
		   else {
			   alerte("You should select one bin");
		   }
	   }
	   
	   /**
   	 * See more comment action.
   	 *
   	 * @param event the event
   	 */
   	public void seeMoreCommentAction(ActionEvent event) {
		   int i = listCommentView.getSelectionModel().getSelectedIndex();
		   if(i != -1) {
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
		   else {
			   alerte("You should select one element");
		   }
	   }
	   
	   /**
   	 * Delete comment action.
   	 *
   	 * @param event the event
   	 */
   	public void deleteCommentAction(ActionEvent event) {
		   int i = listCommentView.getSelectionModel().getSelectedIndex();
		   if(commentFacade.getListComment().getComment(i).getType().equals("comment")) {
			   commentFacade.deleteComment(commentFacade.getListComment().getComment(i).getId());
		   }
		   else if(commentFacade.getListComment().getComment(i).getType().equals("alert")) {
			   commentFacade.deleteAlert(commentFacade.getListComment().getComment(i).getId());
		   }
		   rout.goTo("binManagementPage");
	   }
}
