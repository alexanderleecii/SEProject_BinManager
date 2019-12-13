package BinManagerDAO;
import java.util.*;

public interface Dao<T> {

	/**
	 * 
	 * @param email
	 */
	T load(String email);

	/**
	 * 
	 * @param infos
	 */
	void save(ArrayList<String> infos);

	/**
	 * 
	 * @param email
	 */
	void delete(String email);

}


