package BinManagerObject;
// TODO: Auto-generated Javadoc

/**
 * The Class Position.
 */
public class Position {

	/** The latitude. */
	private String latitude;
	
	/** The longitude. */
	private String longitude;
	
	/**
	 * Instantiates a new position.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public Position(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public String getLatitude() {
		return this.latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public String getLongitude() {
		return this.longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Edits the.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public void edit(String latitude, String longitude) {
		// TODO - implement Position.edit
		throw new UnsupportedOperationException();
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "("+latitude+","+longitude+")";
	}

}