package BinManagerObject;
public class Position {

	private String latitude;
	private String longitude;
	
	public Position(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return this.latitude;
	}

	/**
	 * 
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	/**
	 * 
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public void edit(String latitude, String longitude) {
		// TODO - implement Position.edit
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return "("+latitude+","+longitude+")";
	}

}