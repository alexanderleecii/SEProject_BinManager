package BinManagerPerson;



import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListManager.
 */
public class ListManager {
	
	/** The list manager. */
	private ArrayList<Person> listManager;

	/**
	 * Instantiates a new list manager.
	 */
	public ListManager() {
		this.listManager = new ArrayList<>();
	}

	/**
	 * Gets the list manager.
	 *
	 * @return the list manager
	 */
	public ArrayList<Person> getListManager() {
		return listManager;
	}

	/**
	 * Sets the list manager.
	 *
	 * @param listManager the new list manager
	 */
	public void setListManager(ArrayList<Person> listManager) {
		this.listManager = listManager;
	}

	/**
	 * Adds the manager.
	 *
	 * @param p the p
	 */
	public void addManager(Person p) {
		listManager.add(p);
	}

	/**
	 * Removes the manager.
	 *
	 * @param email the email
	 */
	public void removeManager(String email) {
		listManager.remove(getManager(email));
	}

	/**
	 * Gets the manager.
	 *
	 * @param i the i
	 * @return the manager
	 */
	public Person getManager(int i) {
		return listManager.get(i);
	}

	/**
	 * Gets the manager.
	 *
	 * @param email the email
	 * @return the manager
	 */
	public Person getManager(String email) {
		int i = 0;
		while (i < listManager.size()) {
			if (email.equals(listManager.get(i).getEmail())) {
				return listManager.get(i);
			}
			i++;
		}
		return null;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return listManager.size();
	}

	/**
	 * Edits the manager.
	 *
	 * @param info the info
	 */
	public void editManager(ArrayList<String> info) {
		String email = info.get(0);
		int i = 0;
		while (i < listManager.size()) {
			if (email.equals(listManager.get(i).getEmail())) {
				listManager.get(i).setName(info.get(1));
				i = listManager.size();
			}
			i++;
		}

	}
}
