package BinManagerDAO;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import binManagerCost.Expense;
import binManagerCost.ListExpenses;

// TODO: Auto-generated Javadoc
/**
 * The Class ListExpensesDAOSQL.
 */
public class ListExpensesDAOSQL implements Dao<ListExpenses> {
	
	/** The url. */
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	
	/** The login. */
	private String login = "196466";
	
	/** The passwd. */
	private String passwd = "BinManager";
	
	/** The query handler. */
	private QueryHandler queryHandler;

	/**
	 * Instantiates a new list expenses DAOSQL.
	 */
	public ListExpensesDAOSQL() {
			this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
		}

	/**
	 * Checks if is exist.
	 *
	 * @param name the name
	 * @param date the date
	 * @return true, if is exist
	 */
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
	
	
	/**
	 * Update.
	 *
	 * @param infos the infos
	 */
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

	
	/**
	 * Delete.
	 *
	 * @param name the name
	 */
	public void delete(String name) {
		String sql = "DELETE FROM `expenses` WHERE Name='"+name+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}

	/**
	 * Adds the.
	 *
	 * @param infos the infos
	 * @return true, if successful
	 */
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

	/**
	 * Load.
	 *
	 * @param infos the infos
	 * @return the list expenses
	 */
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

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
