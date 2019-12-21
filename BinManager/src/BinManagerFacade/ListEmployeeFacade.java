package BinManagerFacade;
import BinManagerPerson.ListEmployee;
import java.util.*;
import BinManagerAbstractFactory.ListEmployeeMySQL;
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
		ListEmployeeMySQL p = new ListEmployeeMySQL();
		return p.createDao();
	}
	
	public void update(ArrayList<String> info) {
		Dao<ListEmployee> dao = getDao();
		dao.update(info);
	}

	public void delete(String email) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee.removeEmployee(email);
		dao.delete(email);
	}

	public boolean add(ArrayList<String> info) {
		Dao<ListEmployee> dao = getDao();
		boolean res = dao.add(info);
		return res;
	}

	public boolean load(ArrayList<String> infos) {
		Dao<ListEmployee> dao = getDao();
		this.listEmployee=dao.load(infos);
		return true;
	}


}