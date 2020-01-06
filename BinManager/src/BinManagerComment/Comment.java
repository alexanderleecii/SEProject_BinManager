package BinManagerComment;

import BinManagerPerson.Citizen;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
public class Comment {

	/** The commenter. */
	Citizen commenter;
	
	/** The id. */
	private int id;
	
	/** The date. */
	private String date;
	
	/** The type. */
	private String type;
	
	/** The text. */
	private String text;
	
	/**
	 * Instantiates a new comment.
	 *
	 * @param citizen the citizen
	 * @param id the id
	 * @param date the date
	 * @param type the type
	 * @param text the text
	 */
	public Comment(Citizen citizen, int id, String date, String type, String text) {
		this.setId(id);
		this.commenter = citizen;
		this.date = date;
		this.type = type;
		this.text = text;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Edits the.
	 *
	 * @param date the date
	 * @param type the type
	 * @param text the text
	 */
	public void edit(String date, String type, String text) {
		// TODO - implement TextComment.edit
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}