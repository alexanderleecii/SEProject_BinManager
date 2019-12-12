package application;
import java.sql.*;

public class JDBC {

	public static void lireEnBase() {
		String url = "jdbc:mysql://localhost/BinManager";
		String login = "debian-sys-maint";
		String passwd ="sNsaZIYtvDwdnS8G";
		Connection cn =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * from Person";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
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
	}
	
	public static void sauverEnBase(String email, String name, String password){
		String url = "jdbc:mysql://localhost/BinManager";
		String login = "debian-sys-maint";
		String passwd ="sNsaZIYtvDwdnS8G";
		Connection cn =null;
		Statement st =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO `Person`(`email`, `name`, `password`) VALUES ('"+email+"', '"+name+"','"+password+"')";
			System.out.println(sql);
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

	public static void main(String[] args) {
		sauverEnBase("kmille42@hotmail.fr", "Camille Thomas", "1234");
		lireEnBase();
	}
}