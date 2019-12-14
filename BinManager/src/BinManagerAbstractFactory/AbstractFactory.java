package BinManagerAbstractFactory;
import BinManagerDAO.Dao;
import BinManagerDAO.PersonDAOSQL;
import BinManagerDAO.ExternalTechnicianDAOSQL;

public class AbstractFactory {

	public void getPersonDAO() {
		// TODO - implement AbstractFactory.getPersonDAO
		throw new UnsupportedOperationException();
	}

	public PersonDAOSQL createPersonDAO() {
		// TODO - implement AbstractFactory.createPersonDAO
		throw new UnsupportedOperationException();
	}

	public ExternalTechnicianDAOSQL createExternalTechnicianDAO() {
		// TODO - implement AbstractFactory.createExternalTechnicianDAO
		throw new UnsupportedOperationException();
	}

}