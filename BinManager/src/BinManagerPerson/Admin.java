package BinManagerPerson;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Admin.
 */
public class Admin extends PersonRole {

	/** The list admin. */
	private static ArrayList<Admin> listAdmin;

	/**
	 * Gets the list manager.
	 *
	 * @return the list manager
	 */
	public static ArrayList<Admin> getListManager() {
		return Admin.listAdmin;
	}

	/**
	 * Adds the admin.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public static void addAdmin(String name, String email, String password) {
		// TODO - implement Manager.addManager
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the admin.
	 *
	 * @param email the email
	 */
	public static void removeAdmin(String email) {
		// TODO - implement Manager.removeManager
		throw new UnsupportedOperationException();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "admin";
	}
}