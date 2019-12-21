package BinManagerPerson;

import java.util.ArrayList;

public class ListEmployee {
	private ArrayList<Person> listEmployee;

	public ListEmployee() {
		this.listEmployee = new ArrayList<>();
	}
	public ArrayList<Person> getListEmployee() {
		return listEmployee;
	}
	
	public void setListEmployee(ArrayList<Person> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	public void addEmployee(Person p) {
		listEmployee.add(p);
	}
	public void removeEmployee(Person p) {
		listEmployee.remove(p);
	}
	public Person getEmployee(int i) {
		return listEmployee.get(i);
	}
	public int size() {
		return listEmployee.size();
	}
}
