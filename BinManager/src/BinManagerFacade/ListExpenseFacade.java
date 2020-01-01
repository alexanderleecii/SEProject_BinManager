package BinManagerFacade;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;
import binManagerCost.Expense;
import binManagerCost.ListExpenses;


public class ListExpenseFacade implements Facade<ListExpenses> {
	
	private ListExpenses listExpenses;
	private Dao<ListExpenses> listExpensesDao;
	
	public ListExpenseFacade() {
		this.listExpenses = null;
		this.listExpensesDao = null;
	}
	
	public ListExpenses getListExpenses() {
		return this.listExpenses;
	}
	
	@Override
	public Dao<ListExpenses> getDao() {
		if(this.listExpensesDao == null) {
			this.listExpensesDao = createDao();
		}
		return this.listExpensesDao;
	}
	
	public Dao<ListExpenses> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListExpenses> p = new MySQLFactory<ListExpenses>(ListExpenses.class);
		return (Dao<ListExpenses>) p.createDao();
	}

	@Override
	public void update(ArrayList<String> info) {
		Dao<ListExpenses> dao = getDao();
		this.listExpenses.editExpense(info);
		dao.update(info);
	}
	public void delete(String name) {
		Dao<ListExpenses> dao = getDao();
		this.listExpenses.removeExpense(name);
		dao.delete(name);
	}

	public boolean add(ArrayList<String> info) {
		Dao<ListExpenses> dao = getDao();
		String date=info.get(3);
		Date date1;
		try {
			date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Expense ex=new Expense(info.get(0), info.get(1), Integer.parseInt(info.get(2)), date1);
			this.listExpenses.addExpense(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		boolean res = dao.add(info);
		return res;
	}
	

	@Override
	public boolean load(ArrayList<String> info) {
		Dao<ListExpenses> dao = getDao();
		this.listExpenses=dao.load(info);
		return true;
	}



}
