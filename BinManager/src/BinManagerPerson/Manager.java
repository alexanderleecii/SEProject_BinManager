package BinManagerPerson;
import java.util.*;

public class Manager extends PersonRole {

	private static ArrayList<Manager> listManager;

	public static ArrayList<Manager> getListManager() {
		return Manager.listManager;
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public static void addManager(String name, String email, String password) {
		// TODO - implement Manager.addManager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public static void removeManager(String email) {
		// TODO - implement Manager.removeManager
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "manager";
	}
}