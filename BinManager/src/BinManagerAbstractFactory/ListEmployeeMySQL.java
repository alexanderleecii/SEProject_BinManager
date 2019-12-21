package BinManagerAbstractFactory;

import BinManagerDAO.Dao;
import BinManagerDAO.ListEmployeeDAOSQL;
import BinManagerPerson.ListEmployee;

public class ListEmployeeMySQL extends MySQLFactory<ListEmployee>{
	@Override
	public Dao<ListEmployee> createDao() {
		Dao<ListEmployee> newDao = new ListEmployeeDAOSQL();
		return newDao;
	}
}
