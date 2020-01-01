package BinManagerAbstractFactory;
import BinManagerDAO.Dao;

//This interface allows to hide the creation of the DAO to the Facade
public interface AbstractFactory<T> {

	public Dao<?> createDao();

}