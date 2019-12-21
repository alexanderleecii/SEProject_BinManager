package BinManagerFacade;
import java.util.*;

import BinManagerDAO.Dao;

public interface Facade<T> {

	public Dao<T> getDao();
	/**
	 * 
	 * @param info
	 */
	public void update(ArrayList<String> info);

	/**
	 * 
	 * @param email
	 */
	public void delete(String email);

	/**
	 * 
	 * @param info
	 * @return 
	 */
	public boolean add(ArrayList<String> info);
	
	public boolean load(ArrayList<String> info);

}