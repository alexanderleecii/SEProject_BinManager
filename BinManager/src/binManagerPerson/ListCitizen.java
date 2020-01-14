package binManagerPerson;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCitizen.
 */
public class ListCitizen {
	
	/** The list citizen. */
	private ArrayList<Person> listCitizen;

	/**
	 * Instantiates a new list citizen.
	 */
	public ListCitizen() {
		this.listCitizen = new ArrayList<>();
	}
	
	/**
	 * Gets the list citizen.
	 *
	 * @return the list citizen
	 */
	public ArrayList<Person> getListCitizen() {
		return listCitizen;
	}
	
	/**
	 * Sets the list citizen.
	 *
	 * @param listCitizen the new list citizen
	 */
	public void setListCitizen(ArrayList<Person> listCitizen) {
		this.listCitizen = listCitizen;
	}
	
	/**
	 * Adds the citizen.
	 *
	 * @param p the p
	 */
	public void addCitizen(Person p) {
		listCitizen.add(p);
	}
	
	/**
	 * Removes the citizen.
	 *
	 * @param email the email
	 */
	public void removeCitizen(String email) {
		listCitizen.remove(getCitizen(email));
	}
	
	/**
	 * Gets the citizen.
	 *
	 * @param i the i
	 * @return the citizen
	 */
	public Person getCitizen(int i) {
		return listCitizen.get(i);
	}
	
	/**
	 * Gets the citizen.
	 *
	 * @param email the email
	 * @return the citizen
	 */
	public Person getCitizen(String email) {
		int i = 0;
		while(i<listCitizen.size()) {
			if(email.equals(listCitizen.get(i).getEmail())) {
				return listCitizen.get(i);
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
		return listCitizen.size();
	}
	
	/**
	 * Edits the citizen.
	 *
	 * @param info the info
	 */
	public void editCitizen(ArrayList<String> info) {
		String email = info.get(0);
		int i = 0;
		while(i<listCitizen.size()) {
			if(email.equals(listCitizen.get(i).getEmail())) {
				listCitizen.get(i).setName(info.get(1));
				i=listCitizen.size();
			}
			i++;
		}
	}
}