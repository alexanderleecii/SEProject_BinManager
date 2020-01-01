package BinManagerAbstractFactory;

import BinManagerDAO.CommentDAOSQL;
import BinManagerDAO.Dao;
import BinManagerDAO.ListBinDAOSQL;
import BinManagerDAO.ListEmployeeDAOSQL;
import BinManagerDAO.ListExpensesDAOSQL;
import BinManagerDAO.ListManagerDAOSQL;
import BinManagerDAO.ListCitizenDAOSQL;
import BinManagerDAO.PersonDAOSQL;

public class MySQLFactory<T> implements AbstractFactory<T> {
	//The type attribute allows us later to know the generic type at runtime
	//To decide which type of Dao to create
	private final Class<T> type;
	
	public MySQLFactory(Class<T> type){
		this.type = type;
	}
	
	public Class<T> getType(){
		return this.type;
	}
	
	public Dao<?> createDao() {
		Dao<?> newDao = null;
		
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