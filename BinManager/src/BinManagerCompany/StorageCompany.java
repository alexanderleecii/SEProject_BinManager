package BinManagerCompany;
import Address;

public class StorageCompany extends Company {

	private static ArrayList<StorageCompany> listStorageCompany;

	public static ArrayList<StorageCompany> getListStorageCompany() {
		return this.listStorageCompany;
	}

	/**
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param email
	 * @param address
	 */
	public static void addStorageCompany(String name, String phoneNumber, String email, Address address) {
		// TODO - implement StorageCompany.addStorageCompany
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public static void removeStorageCompany(String email) {
		// TODO - implement StorageCompany.removeStorageCompany
		throw new UnsupportedOperationException();
	}

}