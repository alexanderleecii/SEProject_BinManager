package BinManagerFacade;
import BinManagerPerson.Person;

import java.util.*;

import BinManagerAbstractFactory.PersonMySQL;
import BinManagerDAO.Dao;

public class PersonFacade implements Facade<Person>{

	private Person person;
	private Dao<Person> personDao;
	
	public PersonFacade() {
		this.person = null;
		this.personDao = null;
	}
	
	public Dao<Person> getDao(){
		if(this.personDao == null) {
			this.personDao = createDao();
		}
		return this.personDao;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public Dao<Person> createDao(){
		PersonMySQL p = new PersonMySQL();
		return p.createDao();
	}
	/**
	 * 
	 * @param info
	 */
	public void update(ArrayList<String> info) {
		Dao<Person> dao = getDao();
		dao.update(info);
	}

	/**
	 * 
	 * @param email
	 */
	public void delete(String email) {
		Dao<Person> dao = getDao();
		dao.delete(email);
	}

	/**
	 * 
	 * @param info
	 */
	public void add(ArrayList<String> info) {
		Dao<Person> dao = getDao();
		dao.add(info);
	}

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public void load(String email, String password) {
		Dao<Person> dao = getDao();
		this.person = dao.load(email,password);
	}

}