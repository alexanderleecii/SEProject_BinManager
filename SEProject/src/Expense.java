import java.util.*;
public class Expense {

	private String costCategory;
	private String amount;
	private Date date;
	private static ArrayList<String> listCostCategory;
	private static ArrayList<Expense> listExpense;

	public String getCostCategory() {
		return this.costCategory;
	}

	/**
	 * 
	 * @param costCategory
	 */
	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}

	public String getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public static ArrayList<String> getListCostCategory() {
		return Expense.listCostCategory;
	}

	/**
	 * 
	 * @param listCostCategory
	 */
	public static void setListCostCategory(ArrayList<String> listCostCategory) {
		Expense.listCostCategory = listCostCategory;
	}

	/**
	 * 
	 * @param costCategory
	 */
	public static void addCostCategory(String costCategory) {
		// TODO - implement Expense.addCostCategory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param costCategory
	 */
	public static void removeCostCategory(String costCategory) {
		// TODO - implement Expense.removeCostCategory
		throw new UnsupportedOperationException();
	}

	public static ArrayList<Expense> getListExpense() {
		return Expense.listExpense;
	}

	/**
	 * 
	 * @param costCategory
	 * @param amount
	 * @param date
	 */
	public static void addExpense(String costCategory, String amount, Date date) {
		// TODO - implement Expense.addExpense
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 */
	public static void removeExpense(int index) {
		// TODO - implement Expense.removeExpense
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param costCategory
	 * @param amount
	 * @param date
	 */
	public void edit(String costCategory, String amount, Date date) {
		// TODO - implement Expense.edit
		throw new UnsupportedOperationException();
	}

}