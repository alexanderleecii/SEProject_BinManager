package BinManagerPerson;

import java.util.ArrayList;

public class ListCitizen {
	private ArrayList<Person> listCitizen;

	public ListCitizen() {
		this.listCitizen = new ArrayList<>();
	}
	public ArrayList<Person> getListCitizen() {
		return listCitizen;
	}
	
	public void setListCitizen(ArrayList<Person> listCitizen) {
		this.listCitizen = listCitizen;
	}
	
	public void addCitizen(Person p) {
		listCitizen.add(p);
	}
	public void removeCitizen(String email) {
		listCitizen.remove(getCitizen(email));
	}
	public Person getCitizen(int i) {
		return listCitizen.get(i);
	}
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
	
	public int size() {
		return listCitizen.size();
	}
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