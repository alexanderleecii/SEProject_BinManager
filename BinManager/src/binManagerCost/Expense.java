package binManagerCost;


import java.util.*;

import BinManagerObject.Object;

public class Expense extends Object {

	
	private String costCategory;
	private String name;
	private int price;
	private Date date;

	public Expense(String costCategory, String name, int price, Date date) {
			this.costCategory = costCategory;
			this.name = name;
			this.price = price;
			this.date = date;
		}

	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price=price;
	}

	public String getCostCategory() {
		return this.costCategory;
	}

	/**
	 * 
	 * @param type
	 */
	public void setName(String name) {
		this.name= name;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param state
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}

	/**
	 * 
	 * @param type
	 * @param state
	 */
	public void edit(String name, Date date) {
		// TODO - implement Bin.edit
		throw new UnsupportedOperationException();
	}

}
