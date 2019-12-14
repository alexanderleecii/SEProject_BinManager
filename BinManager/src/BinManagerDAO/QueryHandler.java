package BinManagerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHandler {
	private String url;
	private String login;
	private String password;
	private Connection cn;
	
	public QueryHandler() {
		this.url="";
		this.login="";
		this.password="";
		this.cn=null;
	}
	
	public QueryHandler(String url, String login, String password) {
		this.url=url;
		this.login=login;
		this.password=password;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cn=DriverManager.getConnection(url, login, password);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Statement createStatement() {
		Statement st = null;
		try {
			st = this.cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		Statement st = createStatement();
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void executeUpdate(String query) {
		Statement st = createStatement();
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
