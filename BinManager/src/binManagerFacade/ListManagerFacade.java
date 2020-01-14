package binManagerFacade;
import binManagerAbstractFactory.MySQLFactory;
import binManagerDAO.Dao;
import binManagerPerson.ListEmployee;
import binManagerPerson.ListManager;
import binManagerPerson.Manager;
import binManagerPerson.Person;
import binManagerPerson.PersonRole;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ListManagerFacade.
 */
public class ListManagerFacade implements Facade<ListManager> {

	/** The list manager. */
	private ListManager listManager;
	
	/** The list manager dao. */
	private Dao<ListManager> listManagerDao;

	/**
	 * Instantiates a new list manager facade.
	 */
	public ListManagerFacade() {
			this.listManager = null;
			this.listManagerDao = null;
		}

	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListManager> getDao() {
		if (this.listManagerDao == null) {
			this.listManagerDao = createDao();
		}
		return this.listManagerDao;
	}

	/**
	 * Gets the list manager.
	 *
	 * @return the list manager
	 */
	public ListManager getListManager() {
		return this.listManager;
	}

	/**
	 * Creates the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListManager> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListManager> p = new MySQLFactory<ListManager>(ListManager.class);
		return (Dao<ListManager>) p.createDao();
	}
	

	/**
	 * Update.
	 *
	 * @param info the info
	 */
	public void update(ArrayList<String> info) {
		Dao<ListManager> dao = getDao();
		this.listManager.editManager(info);
		dao.update(info);
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	public void delete(String email) {
		Dao<ListManager> dao = getDao();
		this.listManager.removeManager(email);
		dao.delete(email);
	}

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	public boolean add(ArrayList<String> info) {
		Dao<ListManager> dao = getDao();
		PersonRole pr = new Manager();
		Person p = new Person(info.get(0), info.get(1), info.get(2), pr);
		this.listManager.addManager(p);
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
		Dao<ListManager> dao = getDao();
		this.listManager = dao.load(infos);
		return true;
	}

}

