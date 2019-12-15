package BinManagerAbstractFactory;

import BinManagerDAO.Dao;
import BinManagerDAO.PersonDAOSQL;
import BinManagerPerson.Person;

public class PersonMySQL extends MySQLFactory<Person>{
	@Override
	public Dao<Person> createDao() {
		Dao<Person> newDao = new PersonDAOSQL();
		return newDao;
	}
}
