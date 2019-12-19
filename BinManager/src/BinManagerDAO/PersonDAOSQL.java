package BinManagerDAO;
import BinManagerPerson.Citizen;
import BinManagerPerson.Employee;
import BinManagerPerson.Manager;
import BinManagerPerson.Person;
import BinManagerPerson.PersonRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PersonDAOSQL implements Dao<Person> {
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	private String login = "196466";
	private String passwd ="BinManager";
	private QueryHandler queryHandler;
	
	public PersonDAOSQL() {
		this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
	}
	/**
	 * 
	 * @param email
	 */
	
	public boolean isExist(String email) {
		String sql = "SELECT * from person WHERE email='"+email+"'";
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
	
	public Person load(String email, String password) {
		String sql = "SELECT * from person WHERE email='"+email+"'";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		try {
			boolean exist = false;
			while(rs.next()) {
				exist = true;
				if(password.equals(rs.getString("password"))) {
					PersonRole role = new PersonRole();
					if(rs.getString("role").equals("citizen")) {
						role = new Citizen();
					}
					else if(rs.getString("role").equals("employee")) {
						role = new Employee();
					}
					else if(rs.getString("role").equals("manager")) {
						role = new Manager();
					}
					Person p = new Person(rs.getString("name"),rs.getString("email"),rs.getString("password"),role);
					return p;
				}
				else {
					System.out.println("Incorrect password");
				}
			}
			if(!exist) {
				System.out.println("Incorrect email");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.queryHandler.close();
		return null;
	}

	/**
	 * 
	 * @param infos
	 */
	public void add(ArrayList<String> infos) {
		String email=infos.get(0);
		String password=infos.get(1);
		String name=infos.get(2);
		String role=infos.get(3);
		if (isExist(email)) {
			System.out.println("You already have an account");
		}
		else {
			String sql = "INSERT INTO `person` VALUES ('"+email+"','"+password+"','"+name+"','"+role+"');";
			this.queryHandler.executeUpdate(sql);
			this.queryHandler.close();
		}
	}
	
	/**
	 * 
	 * @param infos
	 */
	public void update(ArrayList<String> infos) {
		String name=infos.get(0);
		String email=infos.get(1);
		String password=infos.get(2);
		if (isExist(email)) {
			String sql = "UPDATE `Person` SET name='"+name+"',password='"+password+"'WHERE email='"+email+"';";
			this.queryHandler.executeUpdate(sql);
			this.queryHandler.close();
		}
		else {
			System.out.println("This account doesn't exist");
		}
	}

	/**
	 * 
	 * @param email
	 */
	public void delete(String email) {
		String sql = "DELETE FROM `Person` WHERE email='"+email+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}

}