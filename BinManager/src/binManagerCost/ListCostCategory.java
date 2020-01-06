package binManagerCost;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCostCategory.
 */
public class ListCostCategory {
	
	/** The list cost category. */
	private ArrayList<String> listCostCategory;

	/**
	 * Gets the list cost category.
	 *
	 * @return the list cost category
	 */
	public ArrayList<String> getListCostCategory() {
		return this.listCostCategory;
	}

	/**
	 * Sets the list cost category.
	 *
	 * @param listCostCategory the new list cost category
	 */
	public void setListCostCategory(ArrayList<String> listCostCategory) {
		this.listCostCategory = listCostCategory;
	}
	
	/**
	 * Adds the cost category.
	 *
	 * @param cat the cat
	 */
	public void addCostCategory(String cat) {
		this.listCostCategory.add(cat);
	}
	
	/**
	 * Removes the cost category.
	 *
	 * @param i the i
	 */
	public void removeCostCategory(int i) {
		this.listCostCategory.remove(i);
	}
	
}
