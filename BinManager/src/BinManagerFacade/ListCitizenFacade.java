package BinManagerFacade;
import BinManagerPerson.Citizen;

import BinManagerPerson.ListCitizen;
import BinManagerPerson.Person;
import BinManagerPerson.PersonRole;

import java.util.*;
import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCitizenFacade.
 */
public class ListCitizenFacade implements Facade<ListCitizen>{

	/** The list citizen. */
	private ListCitizen listCitizen;
	
	/** The list citizen dao. */
	private Dao<ListCitizen> listCitizenDao;
	
	/**
	 * Instantiates a new list citizen facade.
	 */
	public ListCitizenFacade() {
		this.listCitizen = null;
		this.listCitizenDao = null;
	}
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListCitizen> getDao(){
		if(this.listCitizenDao == null) {
			this.listCitizenDao = createDao();
		}
		return this.listCitizenDao;
	}
	
	/**
	 * Gets the list citizen.
	 *
	 * @return the list citizen
	 */
	public ListCitizen getListCitizen() {
		return this.listCitizen;
	}
	
	/**
	 * Creates the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListCitizen> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListCitizen> p = new MySQLFactory<ListCitizen>(ListCitizen.class);
		return (Dao<ListCitizen>) p.createDao();
	}
	
	/**
	 * Update.
	 *
	 * @param info the info
	 */
	public void update(ArrayList<String> info) {
		Dao<ListCitizen> dao = getDao();
		this.listCitizen.editCitizen(info);
		dao.update(info);
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	public void delete(String email) {
		Dao<ListCitizen> dao = getDao();
		this.listCitizen.removeCitizen(email);
		dao.delete(email);
	}

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	public boolean add(ArrayList<String> info) {
		Dao<ListCitizen> dao = getDao();
		PersonRole pr=new Citizen();
		Person p=new Person(info.get(0), info.get(1), info.get(2),pr);
		this.listCitizen.addCitizen(p);
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
		Dao<ListCitizen> dao = getDao();
		this.listCitizen=dao.load(infos);
		return true;
	}


}