
package BinManagerObject;

import java.util.ArrayList;


public class ListExpences {
	private ArrayList<Expence> listExpences;

	public ListExpences() {
			this.listExpences = new ArrayList<>();
		}

	public ArrayList<Expence> getListExpences() {
		return this.listExpences;
	}

	public void setListExpences(ArrayList<Expence> listExpences) {
		this.listExpences = listExpences;
	}

	public void addExpence(Expence ex) {
		listExpences.add(ex);
	}

	public void removeExpence(String name) {
		listExpences.remove(getExpence(name));
	}

	public Expence getExpence(int i) {
		return listExpences.get(i);
	}
	public Expence getExpence(String name) {
		int i = 0;
		while(i<listExpences.size()) {
			if(name.equals(listExpences.get(i).getName())) {
				return listExpences.get(i);
			}
			i++;
		}
		return null;
	}

	public int size() {
		return listExpences.size();
	}

	//currently only possible to edit the price
	public void editExpence(ArrayList<String> info) {
		String name = info.get(1);
		int i = 0;
		while(i<listExpences.size()) {
			if(name.equals(listExpences.get(i).getName())) {
				listExpences.get(i).setPrice(Integer.parseInt(info.get(2)));
				i=listExpences.size();
			}
			i++;
		}
		
	}
}
