package BinManagerAbstractFactory;

import BinManagerDAO.DAOSQL;
import BinManagerDAO.Dao;
import BinManagerDAO.PersonDAOSQL;
import BinManagerPerson.Person;

public class MySQLFactory<T> implements AbstractFactory<T> {

	public Dao<T> createDao() {
		Dao<T> newDao = new Dao<T>();
		return newDao;
	}

}