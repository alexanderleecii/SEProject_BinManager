package BinManagerCompany;

public class Company {

	Address Address;
	private String name;
	private String email;
	private String phoneNumber;

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

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param phoneNumber
	 */
	public void edit(String name, String email, String phoneNumber) {
		// TODO - implement Company.edit
		throw new UnsupportedOperationException();
	}

}