package BinManagerHistory;
public class Event {

	private String type;
	private Date date;

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @param type
	 * @param date
	 */
	public void edit(String type, Date date) {
		// TODO - implement Event.edit
		throw new UnsupportedOperationException();
	}

}