package binManagerFacade;
import java.util.*;

import binManagerDAO.Dao;

// TODO: Auto-generated Javadoc
/**
 * The Interface Facade.
 *
 * @param <T> the generic type
 */
public interface Facade<T> {

	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public Dao<T> getDao();
	
	/**
	 * Update.
	 *
	 * @param info the info
	 */
	public void update(ArrayList<String> info);

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	public void delete(String email);

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	public boolean add(ArrayList<String> info);
	
	/**
	 * Load.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	public boolean load(ArrayList<String> info);

}