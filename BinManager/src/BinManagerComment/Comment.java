package BinManagerComment;
import BinManagerPerson.Citizen;

public class Comment {

	Citizen Commenter;
	private Date date;

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

}