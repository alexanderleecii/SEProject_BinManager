package binManagerDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import binManagerPerson.Employee;
import binManagerPerson.ListEmployee;
import binManagerPerson.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class ListEmployeeDAOSQL.
 */
public class ListEmployeeDAOSQL implements Dao<ListEmployee> {
	
	/** The url. */
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	
	/** The login. */
	private String login = "196466";
	
	/** The passwd. */
	private String passwd ="BinManager";
	
	/** The query handler. */
	private QueryHandler queryHandler;
	
	/**
	 * Instantiates a new list employee DAOSQL.
	 */
	public ListEmployeeDAOSQL() {
		this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
	}
	
	/**
	 * Load.
	 *
	 * @param infos the infos
	 * @return the list employee
	 */
	public ListEmployee load(ArrayList<String> infos) {
		String sql = "SELECT * FROM `person` WHERE role='employee';";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		ListEmployee list = new ListEmployee();
		try {
			while(rs.next()) {
				Person p = new Person(rs.getString("name"),rs.getString("email"), new Employee());
				list.addEmployee(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
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
		String email=infos.get(0);
		String name=infos.get(1);
		if (isExist(email)) {
			String sql = "UPDATE `person` SET name='"+name+"' WHERE email='"+email+"';";
			this.queryHandler.executeUpdate(sql);
			this.queryHandler.close();
		}
		else {
			System.out.println("This account doesn't exist");
		}
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
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	

}