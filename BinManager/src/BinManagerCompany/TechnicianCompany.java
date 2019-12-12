package BinManagerCompany;
import Address;

public class TechnicianCompany extends Company {

	private static ArrayList<TechnicianCompany> listTechnicianComany;

	public static ArrayList<TechnicianCompany> getListTechnicianComany() {
		return this.listTechnicianComany;
	}

	/**
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param email
	 * @param address
	 */
	public static void addTechnicianCompany(String name, String phoneNumber, String email, Address address) {
		// TODO - implement TechnicianCompany.addTechnicianCompany
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public static void removeTechnicianCompany(String email) {
		// TODO - implement TechnicianCompany.removeTechnicianCompany
		throw new UnsupportedOperationException();
	}

}