package BinManagerDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import BinManagerObject.Bin;
import BinManagerObject.Expence;
import BinManagerObject.ListBin;
import BinManagerObject.ListExpences;
import BinManagerObject.Position;
import BinManagerPerson.Employee;
import BinManagerPerson.Person;

public class ListExpencesDAOSQL implements Dao<ListExpences> {
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	private String login = "196466";
	private String passwd = "BinManager";
	private QueryHandler queryHandler;

	public ListExpencesDAOSQL() {
			this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
		}

	private boolean isExist(String name, Date date) {
		
		String sql = "SELECT * from `expences` WHERE Name='"+name+"' AND Date='"+date+"';";
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
				String sql = "UPDATE `expences` SET Cost Category='"+costCategory+"', Name='"+name+"', Price='"+price+"', Date='"+date+"' WHERE Name='"+name+"' AND Date='"+date+"';";
				this.queryHandler.executeUpdate(sql);
				this.queryHandler.close();
			}
			else {
				System.out.println("This expence doesn't exist");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void delete(String name) {
		String sql = "DELETE FROM `expences` WHERE Name='"+name+"';";
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
				System.out.println("The expence exists already");
				return false;
			}
			else {
				String sql = "INSERT INTO `expences` VALUES ('"+costCategory+"','"+name+"','"+price+"','"+date+"');";
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
	public ListExpences load(ArrayList<String> infos) {
		String sql = "SELECT * FROM `expences`;";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		ListExpences list = new ListExpences();
		Expence expence;
		
		try {
			while(rs.next()) {
			Date date = new Date(rs.getDate("Date").getTime());
			expence = new Expence(rs.getString("Cost Category"),rs.getString("Name"),Integer.parseInt(rs.getString("Price")), date);
			System.out.println("haha");
			System.out.println(expence);
			list.addExpence(expence);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("noe feil med sql");
			e1.printStackTrace();
		} 
		return list;
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
