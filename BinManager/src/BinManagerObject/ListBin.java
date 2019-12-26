package BinManagerObject;

import java.util.ArrayList;

public class ListBin {
	private ArrayList<Bin> listBin;
	
	public ListBin() {
		this.listBin = new ArrayList<>();
	}
	
	public ArrayList<Bin> getListBin() {
		return this.listBin;
	}
	
	public void setListBin(ArrayList<Bin> listBin) {
		this.listBin = listBin;
	}
	
	public void addBin(Bin b) {
		listBin.add(b);
	}
	
	public void removeBin(int id) {
		listBin.remove(getBin(id - 1));
	}
	public Bin getBin(int i) {
		return listBin.get(i);
	}
	
	public int size() {
		return listBin.size();
	}
	
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
