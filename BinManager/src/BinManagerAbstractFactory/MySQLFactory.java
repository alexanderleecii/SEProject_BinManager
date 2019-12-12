package BinManagerAbstractFactory;
import BinManagerDAO.ExternalTechnicianDAO;
import BinManagerDAO.PersonDAOSQL;

public class MySQLFactory extends AbstractFactory {

	public void getPersonDAO() {
		// TODO - implement MySQLFactory.getPersonDAO
		throw new UnsupportedOperationException();
	}

	public PersonDAOSQL createPersonDAO() {
		// TODO - implement MySQLFactory.createPersonDAO
		throw new UnsupportedOperationException();
	}

	public ExternalTechnicianDAO createExternalTechnicianDAO() {
		// TODO - implement MySQLFactory.createExternalTechnicianDAO
		throw new UnsupportedOperationException();
	}

}