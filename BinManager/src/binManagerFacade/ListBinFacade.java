package binManagerFacade;

import java.util.ArrayList;

import binManagerAbstractFactory.MySQLFactory;
import binManagerDAO.Dao;
import binManagerObject.Bin;
import binManagerObject.ListBin;
import binManagerObject.Position;
import binManagerPerson.Employee;
import binManagerPerson.ListEmployee;
import binManagerPerson.Person;
import binManagerPerson.PersonRole;

// TODO: Auto-generated Javadoc
/**
 * The Class ListBinFacade.
 */
public class ListBinFacade implements Facade<ListBin>{
	
	/** The list bin. */
	private ListBin listBin;
	
	/** The list bin dao. */
	private Dao<ListBin> listBinDao;
	
	/**
	 * Instantiates a new list bin facade.
	 */
	public ListBinFacade() {
		this.listBin = null;
		this.listBinDao = null;
	}
	
	/**
	 * Gets the list bin.
	 *
	 * @return the list bin
	 */
	public ListBin getListBin() {
		return this.listBin;
	}
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	@Override
	public Dao<ListBin> getDao() {
		if(this.listBinDao == null) {
			this.listBinDao = createDao();
		}
		return this.listBinDao;
	}
	
	/**
	 * Creates the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListBin> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListBin> p = new MySQLFactory<ListBin>(ListBin.class);
		return (Dao<ListBin>) p.createDao();
	}

	/**
	 * Update.
	 *
	 * @param info the info
	 */
	@Override
	public void update(ArrayList<String> info) {
		Dao<ListBin> dao = getDao();
		this.listBin.editBin(info);
		dao.update(info);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(int id) {
		Dao<ListBin> dao = getDao();
		this.listBin.removeBin(id);
		dao.delete(id);
	}

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	@Override
	public boolean add(ArrayList<String> info) {
		Dao<ListBin> dao = getDao();
		boolean state = info.get(1).contentEquals("full");
		String tmp = info.get(2).substring(1, info.get(2).length()-1);
		String[] coord = tmp.split(",");
		String latitude = coord[0];
		String longitude = coord[1];
		Position pos = new Position(latitude,longitude);
		
		load(new ArrayList<String>());
		int lastIndex = getListBin().getBin(getListBin().size()-1).getId();
		
		Bin b = new Bin(lastIndex + 1, info.get(0), state, pos);
		this.listBin.addBin(b);
		boolean res = dao.add(info);
		return res;
	}

	/**
	 * Load.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	@Override
	public boolean load(ArrayList<String> info) {
		Dao<ListBin> dao = getDao();
		this.listBin=dao.load(info);
		return true;
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}

}
