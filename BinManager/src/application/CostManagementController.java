package application;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.ListExpenseFacade;
import BinManagerObject.Expense;
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
	private Label nameExpense;
	@FXML
	private Label costCategoryExpense;
	@FXML
	private Label costField;
	@FXML
	private AnchorPane paneExpense;
	@FXML
	private TextField costCategoryField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField priceField;
	@FXML private TableView<Expense> tableView;
    @FXML private TableColumn<Expense, String> costCategoryCol;
    @FXML private TableColumn<Expense, String> nameCol;
    @FXML private TableColumn<Expense, Integer> priceCol;
    @FXML private TableColumn<Expense, Date> dateCol;
    @FXML private Button addButton;
    private ListExpenseFacade facade;
    private ObservableList<Expense> listExpense = FXCollections.observableArrayList();
   
    private String role = HomeController.getFacade().getPerson().getRole().toString();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	initMenuBar();
    	if(role.equals("admin") || role.equals("manager")) {
			addButton.setVisible(true);
		}
    	costCategoryCol.setCellValueFactory(new PropertyValueFactory<Expense,String>("CostCategory"));
    	nameCol.setCellValueFactory(new PropertyValueFactory<Expense,String>("Name"));
    	priceCol.setCellValueFactory(new PropertyValueFactory<Expense,Integer>("Price"));
    	dateCol.setCellValueFactory(new PropertyValueFactory<Expense,Date>("Date"));
    	this.facade = new ListExpenseFacade();
    	ArrayList<String> infos = new ArrayList<>();
		   facade.load(infos);
		   for(int i=0;i<facade.getListExpenses().size();i++) {
				   listExpense.addAll(facade.getListExpenses().getExpense(i));		
				   
		   }
		   tableView.setItems(listExpense);
    }
    

		
	  


}
