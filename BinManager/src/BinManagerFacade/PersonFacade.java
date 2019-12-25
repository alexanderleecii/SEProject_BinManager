package BinManagerFacade;
import BinManagerPerson.Person;


import java.util.*;

import BinManagerAbstractFactory.MySQLFactory;
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
		//Creates a SQLDao using parameterized classes
		MySQLFactory<Person> p = new MySQLFactory<Person>(Person.class);
		return (Dao<Person>) p.createDao();
	}
	
	public void update(ArrayList<String> info) {
		Dao<Person> dao = getDao();
		this.person.setName(info.get(2));
		this.person.setPassword(info.get(1));
		dao.update(info);
	}

	public void delete(String email) {
		Dao<Person> dao = getDao();
		dao.delete(email);
	}

	public boolean add(ArrayList<String> info) {
		Dao<Person> dao = getDao();
		boolean res = dao.add(info);
		return res;
	}

	public boolean load(ArrayList<String> infos) {
		Dao<Person> dao = getDao();
		this.person = dao.load(infos);
		if(person == null) {
			return false;
		}
		return true;
	}
	

}