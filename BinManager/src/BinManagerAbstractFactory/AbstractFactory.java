package BinManagerAbstractFactory;
import BinManagerDAO.Dao;

public interface AbstractFactory<T> {

	public Dao<?> createDao();

}