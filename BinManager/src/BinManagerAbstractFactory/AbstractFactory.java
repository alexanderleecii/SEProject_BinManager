package BinManagerAbstractFactory;
import BinManagerDAO.Dao;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Abstract objects.
 *
 * @param <T> the generic type
 */
//This interface allows to hide the creation of the DAO to the Facade
public interface AbstractFactory<T> {

	/**
	 * Creates a new Abstract object.
	 *
	 * @return the dao<?>
	 */
	public Dao<?> createDao();

}