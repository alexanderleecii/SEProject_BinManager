package BinManagerFacade;
import BinManagerPerson.Employee;


import BinManagerPerson.ListEmployee;
import BinManagerPerson.Person;
import BinManagerPerson.PersonRole;

import java.util.*;
import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;

public class ListEmployeeFacade implements Facade<ListEmployee>{

	private ListEmployee listEmployee;
	private Dao<ListEmployee> listEmployeeDao;
	
	public ListEmployeeFacade() {
		this.listEmployee = null;
		this.listEmployeeDao = null;
	}
	
	public Dao<ListEmployee> getDao(){
		if(this.listEmployeeDao == null) {
			this.listEmployeeDao = createDao();
		}
		return this.listEmployeeDao;
	}
	
	public ListEmployee getListEmployee() {
		return this.listEmployee;
	}
	
	public Dao<ListEmployee> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListEmployee> p = new MySQLFactory<ListEmployee>(ListEmployee.class);
		return (Dao<ListEmployee>) p.createDao();
	}
	
	public void update(ArrayList<String> info) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee.editEmployee(info);
		dao.update(info);
	}

	public void delete(String email) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee.removeEmployee(email);
		dao.delete(email);
	}

	public boolean add(ArrayList<String> info) {
		Dao<ListEmployee> dao = getDao();
		PersonRole pr=new Employee();
		Person p=new Person(info.get(0), info.get(1), info.get(2),pr);
		this.listEmployee.addEmployee(p);
		boolean res = dao.add(info);
		return res;
	}

	public boolean load(ArrayList<String> infos) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee=dao.load(infos);
		return true;
	}


}