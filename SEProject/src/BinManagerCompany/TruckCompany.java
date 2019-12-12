package BinManagerCompany;
import java.util.*;

public class TruckCompany extends Company {

	Collection<Truck> Truck;
	private static ArrayList<TruckCompany> listTruckCompany;

	public static ArrayList<TruckCompany> getListTruckCompany() {
		return this.listTruckCompany;
	}

	/**
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param email
	 * @param address
	 */
	public static void addTruckCompany(String name, String phoneNumber, String email, Address address) {
		// TODO - implement TruckCompany.addTruckCompany
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public static void removeTruckCompany(String email) {
		// TODO - implement TruckCompany.removeTruckCompany
		throw new UnsupportedOperationException();
	}

}