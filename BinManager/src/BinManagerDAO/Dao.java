package BinManagerDAO;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface Dao.
 *
 * @param <T> the generic type
 */
public interface Dao<T> {
	
	/**
	 * Update.
	 *
	 * @param infos the infos
	 */
	void update(ArrayList<String> infos);
	
	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	void delete(String email);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(int id);
	
	/**
	 * Adds the.
	 *
	 * @param infos the infos
	 * @return true, if successful
	 */
	boolean add(ArrayList<String> infos);

	/**
	 * Load.
	 *
	 * @param infos the infos
	 * @return the t
	 */
	T load(ArrayList<String> infos);
}


