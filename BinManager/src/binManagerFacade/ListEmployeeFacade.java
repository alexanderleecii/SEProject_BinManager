package binManagerFacade;
import binManagerAbstractFactory.MySQLFactory;
import binManagerDAO.Dao;
import binManagerPerson.Employee;
import binManagerPerson.ListEmployee;
import binManagerPerson.Person;
import binManagerPerson.PersonRole;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ListEmployeeFacade.
 */
public class ListEmployeeFacade implements Facade<ListEmployee>{

	/** The list employee. */
	private ListEmployee listEmployee;
	
	/** The list employee dao. */
	private Dao<ListEmployee> listEmployeeDao;
	
	/**
	 * Instantiates a new list employee facade.
	 */
	public ListEmployeeFacade() {
		this.listEmployee = null;
		this.listEmployeeDao = null;
	}
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListEmployee> getDao(){
		if(this.listEmployeeDao == null) {
			this.listEmployeeDao = createDao();
		}
		return this.listEmployeeDao;
	}
	
	/**
	 * Gets the list employee.
	 *
	 * @return the list employee
	 */
	public ListEmployee getListEmployee() {
		return this.listEmployee;
	}
	
	/**
	 * Creates the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListEmployee> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListEmployee> p = new MySQLFactory<ListEmployee>(ListEmployee.class);
		return (Dao<ListEmployee>) p.createDao();
	}
	
	/**
	 * Update.
	 *
	 * @param info the info
	 */
	public void update(ArrayList<String> info) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee.editEmployee(info);
		dao.update(info);
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	public void delete(String email) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee.removeEmployee(email);
		dao.delete(email);
	}

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	public boolean add(ArrayList<String> info) {
		Dao<ListEmployee> dao = getDao();
		PersonRole pr=new Employee();
		Person p=new Person(info.get(0), info.get(1), info.get(2),pr);
		this.listEmployee.addEmployee(p);
		boolean res = dao.add(info);
		return res;
	}

	/**
	 * Load.
	 *
	 * @param infos the infos
	 * @return true, if successful
	 */
	public boolean load(ArrayList<String> infos) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee=dao.load(infos);
		return true;
	}


}