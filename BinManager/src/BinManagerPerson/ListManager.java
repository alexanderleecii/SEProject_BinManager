package BinManagerPerson;



import java.util.ArrayList;

public class ListManager {
	private ArrayList<Person> listManager;

	public ListManager() {
		this.listManager = new ArrayList<>();
	}

	public ArrayList<Person> getListManager() {
		return listManager;
	}

	public void setListManager(ArrayList<Person> listManager) {
		this.listManager = listManager;
	}

	public void addManager(Person p) {
		listManager.add(p);
	}

	public void removeManager(String email) {
		listManager.remove(getManager(email));
	}

	public Person getManager(int i) {
		return listManager.get(i);
	}

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

	public int size() {
		return listManager.size();
	}

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
