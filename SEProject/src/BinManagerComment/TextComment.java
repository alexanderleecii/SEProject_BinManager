package BinManagerComment;
public class TextComment extends Comment {

	private String text;

	public String getText() {
		return this.text;
	}

	/**
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @param date
	 * @param type
	 */
	public void edit(Date date, String type) {
		// TODO - implement TextComment.edit
		throw new UnsupportedOperationException();
	}

}