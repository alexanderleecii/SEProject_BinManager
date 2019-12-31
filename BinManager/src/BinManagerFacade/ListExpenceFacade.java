package BinManagerFacade;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;
import BinManagerObject.Expence;

import BinManagerObject.ListExpences;


public class ListExpenceFacade implements Facade<ListExpences> {
	
	private ListExpences listExpences;
	private Dao<ListExpences> listExpencesDao;
	
	public ListExpenceFacade() {
		this.listExpences = null;
		this.listExpencesDao = null;
	}
	
	public ListExpences getListExpences() {
		return this.listExpences;
	}
	
	@Override
	public Dao<ListExpences> getDao() {
		if(this.listExpencesDao == null) {
			this.listExpencesDao = createDao();
		}
		return this.listExpencesDao;
	}
	
	public Dao<ListExpences> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListExpences> p = new MySQLFactory<ListExpences>(ListExpences.class);
		return (Dao<ListExpences>) p.createDao();
	}

	@Override
	public void update(ArrayList<String> info) {
		Dao<ListExpences> dao = getDao();
		this.listExpences.editExpence(info);
		dao.update(info);
	}
	public void delete(String name) {
		Dao<ListExpences> dao = getDao();
		this.listExpences.removeExpence(name);
		dao.delete(name);
	}

	public boolean add(ArrayList<String> info) {
		Dao<ListExpences> dao = getDao();
		String date=info.get(3);
		Date date1;
		try {
			date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Expence ex=new Expence(info.get(0), info.get(1), Integer.parseInt(info.get(2)), date1);
			this.listExpences.addExpence(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		boolean res = dao.add(info);
		return res;
	}
	

	@Override
	public boolean load(ArrayList<String> info) {
		Dao<ListExpences> dao = getDao();
		this.listExpences=dao.load(info);
		return true;
	}



}
