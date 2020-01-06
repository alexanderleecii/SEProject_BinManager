package Schedule;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
public class Task {

	/** The Object. */
	Collection<Object> Object;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Edits the.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	public void edit(Date startDate, Date endDate) {
		// TODO - implement Task.edit
		throw new UnsupportedOperationException();
	}

}