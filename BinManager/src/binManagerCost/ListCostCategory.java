package binManagerCost;

import java.util.ArrayList;

public class ListCostCategory {
	private ArrayList<String> listCostCategory;

	public ArrayList<String> getListCostCategory() {
		return this.listCostCategory;
	}

	public void setListCostCategory(ArrayList<String> listCostCategory) {
		this.listCostCategory = listCostCategory;
	}
	
	public void addCostCategory(String cat) {
		this.listCostCategory.add(cat);
	}
	
	public void removeCostCategory(int i) {
		this.listCostCategory.remove(i);
	}
	
}
