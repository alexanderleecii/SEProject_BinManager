package binManagerPerson;
// TODO: Auto-generated Javadoc

/**
 * The Class Person.
 */
public class Person {

	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The role. */
	private PersonRole role;

	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 * @param role the role
	 */
	public Person(String name, String email, String password, PersonRole role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param email the email
	 * @param role the role
	 */
	public Person(String name, String email, PersonRole role) {
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public PersonRole getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(PersonRole role) {
		this.role = role;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Edits the.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public void edit(String name, String email, String password) {
		// TODO - implement Person.edit
		throw new UnsupportedOperationException();
	}

}