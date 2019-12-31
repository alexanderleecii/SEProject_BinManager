package application;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.ListExpenceFacade;
import BinManagerObject.Expence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class CostManagementController extends HomeController implements Initializable {
	@FXML
	private Button seeMoreButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button validateEditButton;
	@FXML
	private Button validateAddButton;
	@FXML
	private Label moreInfo;
	@FXML
	private Label name;
	@FXML
	private Label costCategory;
	@FXML
	private Label price;
	@FXML
	private Label nameExpence;
	@FXML
	private Label costCategoryExpence;
	@FXML
	private Label costField;
	@FXML
	private AnchorPane paneExpence;
	@FXML
	private TextField costCategoryField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField priceField;
	@FXML private TableView<Expence> tableView;
    @FXML private TableColumn<Expence, String> costCategoryCol;
    @FXML private TableColumn<Expence, String> nameCol;
    @FXML private TableColumn<Expence, Integer> priceCol;
    @FXML private TableColumn<Expence, Date> dateCol;
    @FXML private Button addButton;
    private ListExpenceFacade facade;
    private ObservableList<Expence> listExpence = FXCollections.observableArrayList();
   
    private String role = HomeController.getFacade().getPerson().getRole().toString();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	initMenuBar();
    	if(role.equals("admin") || role.equals("manager")) {
			addButton.setVisible(true);
		}
    	costCategoryCol.setCellValueFactory(new PropertyValueFactory<Expence,String>("CostCategory"));
    	nameCol.setCellValueFactory(new PropertyValueFactory<Expence,String>("Name"));
    	priceCol.setCellValueFactory(new PropertyValueFactory<Expence,Integer>("Price"));
    	dateCol.setCellValueFactory(new PropertyValueFactory<Expence,Date>("Date"));
    	this.facade = new ListExpenceFacade();
    	ArrayList<String> infos = new ArrayList<>();
		   facade.load(infos);
		   for(int i=0;i<facade.getListExpences().size();i++) {
				   listExpence.addAll(facade.getListExpences().getExpence(i));		
				   
		   }
		   tableView.setItems(listExpence);
    }
    

		
	  


}
