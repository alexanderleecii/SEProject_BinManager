package BinManagerDAO;
public class Connection {
	private String url = "jdbc:mysql://localhost/BinManager";
	private String login = "debian-sys-maint";
	private String passwd ="qJRBGtUqgfjE6kGE";
	
	public Connection(String url, String login, String passwd) {
		this.url = url;
		this.login = login;
		this.passwd = passwd;
	}
	
	public Statement createStatement() {
		// TODO - implement Connection.createStatement
		throw new UnsupportedOperationException();
	}

}