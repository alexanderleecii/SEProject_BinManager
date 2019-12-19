package BinManagerPerson;
import java.util.*;

public class Citizen extends PersonRole {

	private static ArrayList<Citizen> listCitizen;

	public static ArrayList<Citizen> getListCitizen() {
		return Citizen.listCitizen;
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public static void addCitizen(String name, String email, String password) {
		// TODO - implement Citizen.addCitizen
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public static void removeCitizen(String name, String email, String password) {
		// TODO - implement Citizen.removeCitizen
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return "citizen";
	}

}