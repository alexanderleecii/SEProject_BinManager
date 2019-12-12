import java.util.*;
public class Truck {

	private String size;
	private static ArrayList<Truck> listTruck;

	public String getSize() {
		return this.size;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	public static ArrayList<Truck> getListTruck() {
		return Truck.listTruck;
	}

	/**
	 * 
	 * @param availability
	 * @param size
	 */
	public static void addTruck(boolean availability, String size) {
		// TODO - implement Truck.addTruck
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 */
	public static void removeTruck(int index) {
		// TODO - implement Truck.removeTruck
		throw new UnsupportedOperationException();
	}

}