package BinManagerPerson;
import Schedule.Schedule;
import java.util.*;

public class Employee extends PersonRole {

	Schedule Schedule;
	private String accountNumber;
	private static ArrayList<Employee> listEmployee;

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

	public static ArrayList<Employee> getListEmployee() {
		return Employee.listEmployee;
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 * @param accountNumber
	 */
	public static void addEmployee(String name, String email, String password, String accountNumber) {
		// TODO - implement Employee.addEmployee
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public static void removeEmployee(String email) {
		// TODO - implement Employee.removeEmployee
		throw new UnsupportedOperationException();
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

}