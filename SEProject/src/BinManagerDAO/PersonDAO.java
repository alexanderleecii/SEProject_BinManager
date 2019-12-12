package BinManagerDAO;
import BinManagerPerson.Person;
import java.util.*;

public interface PersonDAO {

	/**
	 * 
	 * @param email
	 */
	Person load(String email);

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