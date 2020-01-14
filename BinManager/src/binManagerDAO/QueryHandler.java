package binManagerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryHandler.
 */
public class QueryHandler {
	
	/** The url. */
	private String url;
	
	/** The login. */
	private String login;
	
	/** The password. */
	private String password;
	
	/** The cn. */
	private Connection cn;
	
	/**
	 * Instantiates a new query handler.
	 */
	public QueryHandler() {
		this.url="";
		this.login="";
		this.password="";
		this.cn=null;
	}
	
	/**
	 * Instantiates a new query handler.
	 *
	 * @param url the url
	 * @param login the login
	 * @param password the password
	 */
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
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}
	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Creates the statement.
	 *
	 * @return the statement
	 */
	public Statement createStatement() {
		Statement st = null;
		try {
			st = this.cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 * @return the result set
	 */
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
	
	/**
	 * Execute update.
	 *
	 * @param query the query
	 */
	public void executeUpdate(String query) {
		Statement st = createStatement();
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Close.
	 */
	public void close() {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
