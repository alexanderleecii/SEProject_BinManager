package BinManagerDAO;
import BinManagerPerson.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PersonDAOSQL implements Dao<Person> {

	
	public PersonDAOSQL() {
		
	}
	/**
	 * 
	 * @param email
	 */
	public Person load(String email) {
		String url = "jdbc:mysql://localhost/BinManager";
		String login = "debian-sys-maint";
		String passwd ="qJRBGtUqgfjE6kGE";
		Connection cn =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * from Person WHERE email='"+email+"'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Person p = new Person(rs.getString("name"),rs.getString("email"),rs.getString("password"));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param infos
	 */
	public void save(ArrayList<String> infos) {
		String url = "jdbc:mysql://localhost/BinManager";
		String login = "debian-sys-maint";
		String passwd ="qJRBGtUqgfjE6kGE";
		Connection cn =null;
		Statement st =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO `Person` (`name`) VALUES ('"+infos.get(0)+"');";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param email
	 */
	public void delete(String email) {
		String url = "jdbc:mysql://localhost/BinManager";
		String login = "debian-sys-maint";
		String passwd ="qJRBGtUqgfjE6kGE";
		Connection cn =null;
		Statement st =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "DELETE FROM `Person` WHERE email='"+email+"';";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}