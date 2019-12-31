
package BinManagerObject;

import java.util.ArrayList;


public class ListExpenses {
	private ArrayList<Expense> listExpenses;

	public ListExpenses() {
			this.listExpenses = new ArrayList<>();
		}

	public ArrayList<Expense> getListExpenses() {
		return this.listExpenses;
	}

	public void setListExpenses(ArrayList<Expense> listExpenses) {
		this.listExpenses = listExpenses;
	}

	public void addExpense(Expense ex) {
		listExpenses.add(ex);
	}

	public void removeExpense(String name) {
		listExpenses.remove(getExpense(name));
	}

	public Expense getExpense(int i) {
		return listExpenses.get(i);
	}
	public Expense getExpense(String name) {
		int i = 0;
		while(i<listExpenses.size()) {
			if(name.equals(listExpenses.get(i).getName())) {
				return listExpenses.get(i);
			}
			i++;
		}
		return null;
	}

	public int size() {
		return listExpenses.size();
	}

	//currently only possible to edit the price
	public void editExpense(ArrayList<String> info) {
		String name = info.get(1);
		int i = 0;
		while(i<listExpenses.size()) {
			if(name.equals(listExpenses.get(i).getName())) {
				listExpenses.get(i).setPrice(Integer.parseInt(info.get(2)));
				i=listExpenses.size();
			}
			i++;
		}
		
	}
}
