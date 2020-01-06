package BinManagerAbstractFactory;

import BinManagerDAO.CommentDAOSQL;
import BinManagerDAO.Dao;
import BinManagerDAO.ListBinDAOSQL;
import BinManagerDAO.ListEmployeeDAOSQL;
import BinManagerDAO.ListExpensesDAOSQL;
import BinManagerDAO.ListManagerDAOSQL;
import BinManagerDAO.ListCitizenDAOSQL;
import BinManagerDAO.PersonDAOSQL;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating MySQL objects.
 *
 * @param <T> the generic type
 */
public class MySQLFactory<T> implements AbstractFactory<T> {
	//The type attribute allows us later to know the generic type at runtime
	/** The type. */
	//To decide which type of Dao to create
	private final Class<T> type;
	
	/**
	 * Instantiates a new my SQL factory.
	 *
	 * @param type the type
	 */
	public MySQLFactory(Class<T> type){
		this.type = type;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Class<T> getType(){
		return this.type;
	}
	
	/**
	 * Creates a new MySQL object.
	 *
	 * @return the dao<?>
	 */
	public Dao<?> createDao() {
		Dao<?> newDao = null;
		//In this switch we create the DAO needed by the class calling the createDao method
		switch(this.getType().toString()) {
			case "class BinManagerPerson.Person":
				newDao = new PersonDAOSQL();
				break;
			case "class BinManagerPerson.ListEmployee":
				newDao = new ListEmployeeDAOSQL();
				break;
			case "class BinManagerPerson.ListManager":
				newDao = new ListManagerDAOSQL();
				break;
			case "class BinManagerPerson.ListCitizen" :
				newDao = new ListCitizenDAOSQL();
				break;
			case "class BinManagerObject.ListBin":
				newDao = new ListBinDAOSQL();
				break;
			case "class BinManagerComment.ListComment":
				newDao = new CommentDAOSQL();
				break;
			case "class binManagerCost.ListExpenses":
				newDao = new ListExpensesDAOSQL();
				break;
		}
		return newDao;
	}
}