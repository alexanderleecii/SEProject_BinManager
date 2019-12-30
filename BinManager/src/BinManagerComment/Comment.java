package BinManagerComment;

import BinManagerPerson.Citizen;

public class Comment {

	Citizen commenter;
	private int id;
	private String date;
	private String type;
	private String text;
	
	public Comment(Citizen citizen, int id, String date, String type, String text) {
		this.setId(id);
		this.commenter = citizen;
		this.date = date;
		this.type = type;
		this.text = text;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * 
	 * @param date
	 * @param type
	 */
	public void edit(String date, String type, String text) {
		// TODO - implement TextComment.edit
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}