package BinManagerFacade;
import BinManagerPerson.Citizen;

import BinManagerPerson.ListCitizen;
import BinManagerPerson.Person;
import BinManagerPerson.PersonRole;

import java.util.*;
import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;

public class ListCitizenFacade implements Facade<ListCitizen>{

	private ListCitizen listCitizen;
	private Dao<ListCitizen> listCitizenDao;
	
	public ListCitizenFacade() {
		this.listCitizen = null;
		this.listCitizenDao = null;
	}
	
	public Dao<ListCitizen> getDao(){
		if(this.listCitizenDao == null) {
			this.listCitizenDao = createDao();
		}
		return this.listCitizenDao;
	}
	
	public ListCitizen getListCitizen() {
		return this.listCitizen;
	}
	
	public Dao<ListCitizen> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListCitizen> p = new MySQLFactory<ListCitizen>(ListCitizen.class);
		return (Dao<ListCitizen>) p.createDao();
	}
	
	public void update(ArrayList<String> info) {
		Dao<ListCitizen> dao = getDao();
		this.listCitizen.editCitizen(info);
		dao.update(info);
	}

	public void delete(String email) {
		Dao<ListCitizen> dao = getDao();
		this.listCitizen.removeCitizen(email);
		dao.delete(email);
	}

	public boolean add(ArrayList<String> info) {
		Dao<ListCitizen> dao = getDao();
		PersonRole pr=new Citizen();
		Person p=new Person(info.get(0), info.get(1), info.get(2),pr);
		this.listCitizen.addCitizen(p);
		boolean res = dao.add(info);
		return res;
	}

	public boolean load(ArrayList<String> infos) {
		Dao<ListCitizen> dao = getDao();
		this.listCitizen=dao.load(infos);
		return true;
	}


}