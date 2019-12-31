package BinManagerDAO;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import BinManagerObject.Expense;
import BinManagerObject.ListExpenses;

public class ListExpensesDAOSQL implements Dao<ListExpenses> {
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	private String login = "196466";
	private String passwd = "BinManager";
	private QueryHandler queryHandler;

	public ListExpensesDAOSQL() {
			this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
		}

	private boolean isExist(String name, Date date) {
		
		String sql = "SELECT * from `expenses` WHERE Name='"+name+"' AND Date='"+date+"';";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		try {
			boolean exist = false;
			while(rs.next()) {
				exist = true;
			}
			return exist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.queryHandler.close();
		return false;
	}
	
	
	@Override
	public void update(ArrayList<String> infos) {
		String costCategory=infos.get(0);
		String name=infos.get(1);
		int price = Integer.parseInt(infos.get(2));
		String date=infos.get(3);
		try {
			Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			if (isExist(name, date1)) {
				String sql = "UPDATE `expenses` SET Cost Category='"+costCategory+"', Name='"+name+"', Price='"+price+"', Date='"+date+"' WHERE Name='"+name+"' AND Date='"+date+"';";
				this.queryHandler.executeUpdate(sql);
				this.queryHandler.close();
			}
			else {
				System.out.println("This Expense doesn't exist");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void delete(String name) {
		String sql = "DELETE FROM `expenses` WHERE Name='"+name+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}

	@Override
	public boolean add(ArrayList<String> infos) {
		String costCategory=infos.get(0);
		String name=infos.get(1);
		int price = Integer.parseInt(infos.get(2));
		String date=infos.get(3);
		try {
			Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			if (isExist(name, date1)) {
				System.out.println("The Expense exists already");
				return false;
			}
			else {
				String sql = "INSERT INTO `expenses` VALUES ('"+costCategory+"','"+name+"','"+price+"','"+date+"');";
				this.queryHandler.executeUpdate(sql);
				this.queryHandler.close();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public ListExpenses load(ArrayList<String> infos) {
		String sql = "SELECT * FROM `expenses`;";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		ListExpenses list = new ListExpenses();
		Expense Expense;
		
		try {
			while(rs.next()) {
			Date date = new Date(rs.getDate("Date").getTime());
			Expense = new Expense(rs.getString("Cost Category"),rs.getString("Name"),Integer.parseInt(rs.getString("Price")), date);
			list.addExpense(Expense);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return list;
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
