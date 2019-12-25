package BinManagerAbstractFactory;

import BinManagerDAO.Dao;
import BinManagerDAO.ListEmployeeDAOSQL;
import BinManagerDAO.PersonDAOSQL;

public class MySQLFactory<T> implements AbstractFactory<T> {
	//The type attribute allows us later to know the generic type at runtime
	//To decide which type of Dao to create
	private final Class<T> type;
	
	public MySQLFactory(Class<T> type){
		this.type = type;
	}
	
	public Class<T> getType(){
		return this.type;
	}
	
	public Dao<?> createDao() {
		Dao<?> newDao = null;
		
		switch(this.getType().toString()) {
			case "class BinManagerPerson.Person":
				newDao = new PersonDAOSQL();
				break;
			case "class BinManagerPerson.ListEmployee":
				newDao = new ListEmployeeDAOSQL();
				break;
		}
		return newDao;
	}

}