package Schedule;
import java.util.*;

public class Task {

	Collection<Object> Object;
	private Date startDate;
	private Date endDate;

	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public void edit(Date startDate, Date endDate) {
		// TODO - implement Task.edit
		throw new UnsupportedOperationException();
	}

}