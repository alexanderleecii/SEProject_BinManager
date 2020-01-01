package BinManagerCompany;

import java.util.ArrayList;

public class TruckCompany extends Company {
	private ArrayList<Truck> trucks;

	public ArrayList<Truck> getTrucks() {
		return this.trucks;
	}

	public void setTrucks(ArrayList<Truck> trucks) {
		this.trucks = trucks;
	}
}