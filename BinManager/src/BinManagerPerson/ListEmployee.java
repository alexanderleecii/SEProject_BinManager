package BinManagerPerson;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListEmployee.
 */
public class ListEmployee {
	
	/** The list employee. */
	private ArrayList<Person> listEmployee;

	/**
	 * Instantiates a new list employee.
	 */
	public ListEmployee() {
		this.listEmployee = new ArrayList<>();
	}
	
	/**
	 * Gets the list employee.
	 *
	 * @return the list employee
	 */
	public ArrayList<Person> getListEmployee() {
		return listEmployee;
	}
	
	/**
	 * Sets the list employee.
	 *
	 * @param listEmployee the new list employee
	 */
	public void setListEmployee(ArrayList<Person> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	/**
	 * Adds the employee.
	 *
	 * @param p the p
	 */
	public void addEmployee(Person p) {
		listEmployee.add(p);
	}
	
	/**
	 * Removes the employee.
	 *
	 * @param email the email
	 */
	public void removeEmployee(String email) {
		listEmployee.remove(getEmployee(email));
	}
	
	/**
	 * Gets the employee.
	 *
	 * @param i the i
	 * @return the employee
	 */
	public Person getEmployee(int i) {
		return listEmployee.get(i);
	}
	
	/**
	 * Gets the employee.
	 *
	 * @param email the email
	 * @return the employee
	 */
	public Person getEmployee(String email) {
		int i = 0;
		while(i<listEmployee.size()) {
			if(email.equals(listEmployee.get(i).getEmail())) {
				return listEmployee.get(i);
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
		return listEmployee.size();
	}
	
	/**
	 * Edits the employee.
	 *
	 * @param info the info
	 */
	public void editEmployee(ArrayList<String> info) {
		String email = info.get(0);
		int i = 0;
		while(i<listEmployee.size()) {
			if(email.equals(listEmployee.get(i).getEmail())) {
				listEmployee.get(i).setName(info.get(1));
				i=listEmployee.size();
			}
			i++;
		}
		
	}
}
