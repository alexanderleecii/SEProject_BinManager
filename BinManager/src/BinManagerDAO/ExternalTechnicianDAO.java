package BinManagerDAO;
import ExternalTechnician.ExternalTechnician;
import java.util.*;

public interface ExternalTechnicianDAO {

	/**
	 * 
	 * @param email
	 */
	ExternalTechnician load(String email);

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