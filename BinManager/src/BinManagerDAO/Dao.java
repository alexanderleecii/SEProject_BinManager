package BinManagerDAO;
import java.util.*;

public interface Dao<T> {
	
	/**
	 * 
	 * @param infos
	 */
	void update(ArrayList<String> infos);
	
	/**
	 * 
	 * @param email
	 */
	void delete(String email);
	
	/**
	 * 
	 * @param infos
	 * @return 
	 */
	boolean add(ArrayList<String> infos);

	/**
	 * 
	 * @param email
	 */
	T load(ArrayList<String> infos);
}


