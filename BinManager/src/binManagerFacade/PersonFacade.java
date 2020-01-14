package binManagerFacade;
import binManagerAbstractFactory.MySQLFactory;
import binManagerDAO.Dao;
import binManagerPerson.Person;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonFacade.
 */
public class PersonFacade implements Facade<Person>{

	/** The person. */
	private Person person;
	
	/** The person dao. */
	private Dao<Person> personDao;
	
	/**
	 * Instantiates a new person facade.
	 */
	public PersonFacade() {
		this.person = null;
		this.personDao = null;
	}
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public Dao<Person> getDao(){
		if(this.personDao == null) {
			this.personDao = createDao();
		}
		return this.personDao;
	}
	
	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}
	
	/**
	 * Creates the dao.
	 *
	 * @return the dao
	 */
	public Dao<Person> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<Person> p = new MySQLFactory<Person>(Person.class);
		return (Dao<Person>) p.createDao();
	}
	
	/**
	 * Update.
	 *
	 * @param info the info
	 */
	public void update(ArrayList<String> info) {
		Dao<Person> dao = getDao();
		this.person.setName(info.get(2));
		this.person.setPassword(info.get(1));
		dao.update(info);
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	public void delete(String email) {
		Dao<Person> dao = getDao();
		dao.delete(email);
	}

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	public boolean add(ArrayList<String> info) {
		Dao<Person> dao = getDao();
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
		Dao<Person> dao = getDao();
		this.person = dao.load(infos);
		if(person == null) {
			return false;
		}
		return true;
	}
	

}