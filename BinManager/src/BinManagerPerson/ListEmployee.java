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
	public void removeEmployee(String email) {
		listEmployee.remove(getEmployee(email));
	}
	public Person getEmployee(int i) {
		return listEmployee.get(i);
	}
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
	
	public int size() {
		return listEmployee.size();
	}
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
