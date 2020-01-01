package BinManagerCompany;
public class Address {

	private String country;
	private String city;
	private String postCode;
	private String street;

	public String getCountry() {
		return this.country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return this.city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * 
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return this.street;
	}

	/**
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 
	 * @param country
	 * @param city
	 * @param postCode
	 * @param street
	 */
	public void edit(String country, String city, String postCode, String street) {
		// TODO - implement Address.edit
		throw new UnsupportedOperationException();
	}

}