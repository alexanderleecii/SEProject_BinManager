package binManagerPerson;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Citizen.
 */
public class Citizen extends PersonRole {

	/** The list citizen. */
	private static ArrayList<Citizen> listCitizen;

	/**
	 * Gets the list citizen.
	 *
	 * @return the list citizen
	 */
	public static ArrayList<Citizen> getListCitizen() {
		return Citizen.listCitizen;
	}

	/**
	 * Adds the citizen.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public static void addCitizen(String name, String email, String password) {
		// TODO - implement Citizen.addCitizen
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the citizen.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public static void removeCitizen(String name, String email, String password) {
		// TODO - implement Citizen.removeCitizen
		throw new UnsupportedOperationException();
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "citizen";
	}

}