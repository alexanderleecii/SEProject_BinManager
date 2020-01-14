package binManagerPerson;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager extends PersonRole {

	/** The list manager. */
	private static ArrayList<Manager> listManager;

	/**
	 * Gets the list manager.
	 *
	 * @return the list manager
	 */
	public static ArrayList<Manager> getListManager() {
		return Manager.listManager;
	}

	/**
	 * Adds the manager.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public static void addManager(String name, String email, String password) {
		// TODO - implement Manager.addManager
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the manager.
	 *
	 * @param email the email
	 */
	public static void removeManager(String email) {
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
		return "manager";
	}
}