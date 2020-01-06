package BinManagerObject;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListBin.
 */
public class ListBin {
	
	/** The list bin. */
	private ArrayList<Bin> listBin;
	
	/**
	 * Instantiates a new list bin.
	 */
	public ListBin() {
		this.listBin = new ArrayList<>();
	}
	
	/**
	 * Gets the list bin.
	 *
	 * @return the list bin
	 */
	public ArrayList<Bin> getListBin() {
		return this.listBin;
	}
	
	/**
	 * Sets the list bin.
	 *
	 * @param listBin the new list bin
	 */
	public void setListBin(ArrayList<Bin> listBin) {
		this.listBin = listBin;
	}
	
	/**
	 * Adds the bin.
	 *
	 * @param b the b
	 */
	public void addBin(Bin b) {
		listBin.add(b);
	}
	
	/**
	 * Removes the bin.
	 *
	 * @param id the id
	 */
	public void removeBin(int id) {
		listBin.remove(getBin(id - 1));
	}
	
	/**
	 * Gets the bin.
	 *
	 * @param i the i
	 * @return the bin
	 */
	public Bin getBin(int i) {
		return listBin.get(i);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return listBin.size();
	}
	
	/**
	 * Edits the bin.
	 *
	 * @param info the info
	 */
	public void editBin(ArrayList<String> info) {
		int id = Integer.parseInt(info.get(0));
		int i = 0;
		while(i<listBin.size()) {
			if(id == getListBin().get(i).getId()) {
				getListBin().get(i).setType(info.get(1));
				
				boolean state = info.get(2).equals("full");
				getListBin().get(i).setState(state);
				
				String tmp = info.get(3).substring(1, info.get(3).length()-1);
				String[] coord = tmp.split(",");
				String latitude = coord[0];
				String longitude = coord[1];
				
				Position pos = new Position(latitude, longitude);
				getListBin().get(i).setPosition(pos);
				i=listBin.size();
			}
			i++;
		}
		
	}
}
