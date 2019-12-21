package BinManagerPerson;
import Schedule.Schedule;

public class Employee extends PersonRole {

	Schedule Schedule;
	private String accountNumber;
	
	public String getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Schedule createSchedule() {
		// TODO - implement Employee.createSchedule
		throw new UnsupportedOperationException();
	}

	public Schedule getSchedule() {
		// TODO - implement Employee.getSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 * @param accountNumber
	 */
	public void edit(String name, String email, String password, String accountNumber) {
		// TODO - implement Employee.edit
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "employee";
	}
	
}