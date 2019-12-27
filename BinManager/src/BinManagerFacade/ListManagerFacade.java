package BinManagerFacade;
import BinManagerPerson.Manager;
import BinManagerPerson.ListEmployee;
import BinManagerPerson.ListManager;
import BinManagerPerson.Person;
import BinManagerPerson.PersonRole;

import java.util.*;
import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;

public class ListManagerFacade implements Facade<ListManager> {

	private ListManager listManager;
	private Dao<ListManager> listManagerDao;

	public ListManagerFacade() {
			this.listManager = null;
			this.listManagerDao = null;
		}

	public Dao<ListManager> getDao() {
		if (this.listManagerDao == null) {
			this.listManagerDao = createDao();
		}
		return this.listManagerDao;
	}

	public ListManager getListManager() {
		return this.listManager;
	}

	public Dao<ListManager> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListManager> p = new MySQLFactory<ListManager>(ListManager.class);
		return (Dao<ListManager>) p.createDao();
	}
	

	public void update(ArrayList<String> info) {
		Dao<ListManager> dao = getDao();
		this.listManager.editManager(info);
		dao.update(info);
	}

	public void delete(String email) {
		Dao<ListManager> dao = getDao();
		this.listManager.removeManager(email);
		dao.delete(email);
	}

	public boolean add(ArrayList<String> info) {
		Dao<ListManager> dao = getDao();
		PersonRole pr = new Manager();
		Person p = new Person(info.get(0), info.get(1), info.get(2), pr);
		this.listManager.addManager(p);
		boolean res = dao.add(info);
		return res;
	}

	public boolean load(ArrayList<String> infos) {
		Dao<ListManager> dao = getDao();
		this.listManager = dao.load(infos);
		return true;
	}

}

