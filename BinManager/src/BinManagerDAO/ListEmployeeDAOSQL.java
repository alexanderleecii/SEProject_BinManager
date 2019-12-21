package BinManagerDAO;
import BinManagerPerson.Employee;
import BinManagerPerson.ListEmployee;
import BinManagerPerson.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ListEmployeeDAOSQL implements Dao<ListEmployee> {
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	private String login = "196466";
	private String passwd ="BinManager";
	private QueryHandler queryHandler;
	
	public ListEmployeeDAOSQL() {
		this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
	}
	
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
	
	public boolean add(ArrayList<String> infos) {
		return true;
	}
	
	public void update(ArrayList<String> infos) {
	}

	public void delete(String email) {
		String sql = "DELETE FROM `person` WHERE email='"+email+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}

	
	

}