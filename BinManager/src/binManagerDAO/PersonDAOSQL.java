package binManagerDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import binManagerPerson.Admin;
import binManagerPerson.Citizen;
import binManagerPerson.Employee;
import binManagerPerson.Manager;
import binManagerPerson.Person;
import binManagerPerson.PersonRole;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonDAOSQL.
 */
public class PersonDAOSQL implements Dao<Person> {
	
	/** The url. */
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	
	/** The login. */
	private String login = "196466";
	
	/** The passwd. */
	private String passwd ="BinManager";
	
	/** The query handler. */
	private QueryHandler queryHandler;
	
	/**
	 * Instantiates a new person DAOSQL.
	 */
	public PersonDAOSQL() {
		this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
	}
	
	/**
	 * Checks if is exist.
	 *
	 * @param email the email
	 * @return true, if is exist
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
	
	/**
	 * Load.
	 *
	 * @param infos the infos
	 * @return the person
	 */
	public Person load(ArrayList<String> infos) {
		String email = infos.get(0);
		String password = infos.get(1);
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
					else if(rs.getString("role").equals("admin")) {
						role = new Admin();
					}
					Person p = new Person(rs.getString("name"),rs.getString("email"),rs.getString("password"),role);
					return p;
				}
				else {
					System.out.println("Incorrect password");
					return null;
				}
			}
			if(!exist) {
				System.out.println("Incorrect email");
				return null;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.queryHandler.close();
		return null;
	}

	/**
	 * Adds the.
	 *
	 * @param infos the infos
	 * @return true, if successful
	 */
	public boolean add(ArrayList<String> infos) {
		String email=infos.get(0);
		String password=infos.get(1);
		String name=infos.get(2);
		String role=infos.get(3);
		if (isExist(email)) {
			System.out.println("You already have an account");
			return false;
		}
		else {
			String sql = "INSERT INTO `person` VALUES ('"+email+"','"+password+"','"+name+"','"+role+"');";
			this.queryHandler.executeUpdate(sql);
			this.queryHandler.close();
		}
		return true;
	}
	
	/**
	 * Update.
	 *
	 * @param infos the infos
	 */
	public void update(ArrayList<String> infos) {
		String name=infos.get(2);
		String email=infos.get(0);
		String password=infos.get(1);
		String sql = "UPDATE `person` SET name='"+name+"',password='"+password+"'WHERE email='"+email+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	public void delete(String email) {
		String sql = "DELETE FROM `person` WHERE email='"+email+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
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