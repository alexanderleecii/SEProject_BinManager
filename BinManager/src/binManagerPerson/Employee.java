package binManagerPerson;
import schedule.Schedule;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee extends PersonRole {

	/** The Schedule. */
	Schedule Schedule;
	
	/** The account number. */
	private String accountNumber;
	
	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	/**
	 * Creates the schedule.
	 *
	 * @return the schedule
	 */
	public Schedule createSchedule() {
		// TODO - implement Employee.createSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the schedule.
	 *
	 * @return the schedule
	 */
	public Schedule getSchedule() {
		// TODO - implement Employee.getSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 * Edits the.
	 *
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 * @param accountNumber the account number
	 */
	public void edit(String name, String email, String password, String accountNumber) {
		// TODO - implement Employee.edit
		throw new UnsupportedOperationException();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "employee";
	}
	
}