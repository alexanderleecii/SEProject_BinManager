package binManagerCost;


import java.util.*;

import BinManagerObject.Object;

// TODO: Auto-generated Javadoc
/**
 * The Class Expense.
 */
public class Expense extends Object {

	
	/** The cost category. */
	private String costCategory;
	
	/** The name. */
	private String name;
	
	/** The price. */
	private int price;
	
	/** The date. */
	private Date date;

	/**
	 * Instantiates a new expense.
	 *
	 * @param costCategory the cost category
	 * @param name the name
	 * @param price the price
	 * @param date the date
	 */
	public Expense(String costCategory, String name, int price, Date date) {
			this.costCategory = costCategory;
			this.name = name;
			this.price = price;
			this.date = date;
		}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price=price;
	}

	/**
	 * Gets the cost category.
	 *
	 * @return the cost category
	 */
	public String getCostCategory() {
		return this.costCategory;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name= name;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the cost category.
	 *
	 * @param costCategory the new cost category
	 */
	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}

	/**
	 * Edits the.
	 *
	 * @param name the name
	 * @param date the date
	 */
	public void edit(String name, Date date) {
		// TODO - implement Bin.edit
		throw new UnsupportedOperationException();
	}

}
