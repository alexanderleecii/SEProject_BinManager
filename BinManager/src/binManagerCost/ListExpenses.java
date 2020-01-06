
package binManagerCost;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class ListExpenses.
 */
public class ListExpenses {
	
	/** The list expenses. */
	private ArrayList<Expense> listExpenses;

	/**
	 * Instantiates a new list expenses.
	 */
	public ListExpenses() {
			this.listExpenses = new ArrayList<>();
		}

	/**
	 * Gets the list expenses.
	 *
	 * @return the list expenses
	 */
	public ArrayList<Expense> getListExpenses() {
		return this.listExpenses;
	}

	/**
	 * Sets the list expenses.
	 *
	 * @param listExpenses the new list expenses
	 */
	public void setListExpenses(ArrayList<Expense> listExpenses) {
		this.listExpenses = listExpenses;
	}

	/**
	 * Adds the expense.
	 *
	 * @param ex the ex
	 */
	public void addExpense(Expense ex) {
		listExpenses.add(ex);
	}

	/**
	 * Removes the expense.
	 *
	 * @param name the name
	 */
	public void removeExpense(String name) {
		listExpenses.remove(getExpense(name));
	}

	/**
	 * Gets the expense.
	 *
	 * @param i the i
	 * @return the expense
	 */
	public Expense getExpense(int i) {
		return listExpenses.get(i);
	}
	
	/**
	 * Gets the expense.
	 *
	 * @param name the name
	 * @return the expense
	 */
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

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return listExpenses.size();
	}

	/**
	 * Edits the expense.
	 *
	 * @param info the info
	 */
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
