package BinManagerPerson;
public class Person {

	private String name;
	private String email;
	private String password;

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public void edit(String name, String email, String password) {
		// TODO - implement Person.edit
		throw new UnsupportedOperationException();
	}

}