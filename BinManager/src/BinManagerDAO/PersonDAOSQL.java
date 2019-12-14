package BinManagerDAO;
import BinManagerPerson.Person;

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
	public Person load(String email) {
		String sql = "SELECT * from person WHERE email='"+email+"'";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		try {
			while(rs.next()) {
				Person p = new Person(rs.getString("name"),rs.getString("email"),rs.getString("password"));
				return p;
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
		String sql = "INSERT INTO `Person` (`name`) VALUES ('"+infos.get(0)+"');";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}
	
	/**
	 * 
	 * @param infos
	 */
	public void update(ArrayList<String> infos) {
		// TODO Auto-generated method stub
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