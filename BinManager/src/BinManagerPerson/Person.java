package BinManagerPerson;
public class Person {

	private String name;
	private String email;
	private String password;
	private PersonRole role;

	public Person(String name, String email, String password, PersonRole role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public Person(String name, String email, PersonRole role) {
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
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

	public PersonRole getRole() {
		return role;
	}

	public void setRole(PersonRole role) {
		this.role = role;
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