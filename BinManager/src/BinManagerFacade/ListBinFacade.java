package BinManagerFacade;

import java.util.ArrayList;

import BinManagerAbstractFactory.MySQLFactory;
import BinManagerDAO.Dao;
import BinManagerObject.Bin;
import BinManagerObject.ListBin;
import BinManagerObject.Position;
import BinManagerPerson.Employee;
import BinManagerPerson.ListEmployee;
import BinManagerPerson.Person;
import BinManagerPerson.PersonRole;

public class ListBinFacade implements Facade<ListBin>{
	
	private ListBin listBin;
	private Dao<ListBin> listBinDao;
	
	public ListBinFacade() {
		this.listBin = null;
		this.listBinDao = null;
	}
	
	public ListBin getListBin() {
		return this.listBin;
	}
	
	@Override
	public Dao<ListBin> getDao() {
		if(this.listBinDao == null) {
			this.listBinDao = createDao();
		}
		return this.listBinDao;
	}
	
	public Dao<ListBin> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListBin> p = new MySQLFactory<ListBin>(ListBin.class);
		return (Dao<ListBin>) p.createDao();
	}

	@Override
	public void update(ArrayList<String> info) {
		Dao<ListBin> dao = getDao();
		this.listBin.editBin(info);
		dao.update(info);
	}

	public void delete(int id) {
		Dao<ListBin> dao = getDao();
		this.listBin.removeBin(id);
		dao.delete(id);
	}

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

	@Override
	public boolean load(ArrayList<String> info) {
		Dao<ListBin> dao = getDao();
		this.listBin=dao.load(info);
		return true;
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}

}
