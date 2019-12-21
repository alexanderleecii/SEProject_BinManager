package BinManagerPerson;
import java.util.*;

public class Admin extends PersonRole {

	private static ArrayList<Admin> listAdmin;

	public static ArrayList<Admin> getListManager() {
		return Admin.listAdmin;
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public static void addAdmin(String name, String email, String password) {
		// TODO - implement Manager.addManager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public static void removeAdmin(String email) {
		// TODO - implement Manager.removeManager
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "admin";
	}
}