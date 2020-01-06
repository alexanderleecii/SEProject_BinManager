package application;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BinManagerFacade.ListExpenseFacade;
import binManagerCost.Expense;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class CostManagementController.
 */
public class CostManagementController extends HomeController implements Initializable {
	
	/** The see more button. */
	@FXML
	private Button seeMoreButton;
	
	/** The edit button. */
	@FXML
	private Button editButton;
	
	/** The delete button. */
	@FXML
	private Button deleteButton;
	
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
	
	/** The cost category. */
	@FXML
	private Label costCategory;
	
	/** The price. */
	@FXML
	private Label price;
	
	/** The name expense. */
	@FXML
	private Label nameExpense;
	
	/** The cost category expense. */
	@FXML
	private Label costCategoryExpense;
	
	/** The cost field. */
	@FXML
	private Label costField;
	
	/** The pane expense. */
	@FXML
	private AnchorPane paneExpense;
	
	/** The cost category field. */
	@FXML
	private TextField costCategoryField;
	
	/** The name field. */
	@FXML
	private TextField nameField;
	
	/** The price field. */
	@FXML
	private TextField priceField;
	
	/** The table view. */
	@FXML private TableView<Expense> tableView;
    
    /** The cost category col. */
    @FXML private TableColumn<Expense, String> costCategoryCol;
    
    /** The name col. */
    @FXML private TableColumn<Expense, String> nameCol;
    
    /** The price col. */
    @FXML private TableColumn<Expense, Integer> priceCol;
    
    /** The date col. */
    @FXML private TableColumn<Expense, Date> dateCol;
    
    /** The add button. */
    @FXML private Button addButton;
    
    /** The facade. */
    private ListExpenseFacade facade;
    
    /** The list expense. */
    private ObservableList<Expense> listExpense = FXCollections.observableArrayList();
   
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
