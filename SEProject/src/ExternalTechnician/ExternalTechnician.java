package ExternalTechnician;
import BinManagerCompany.TechnicianCompany;
import java.util.*;

public class ExternalTechnician {

	TechnicianCompany Company;
	private String name;
	private String specialization;
	private static ArrayList<ExternalTechnician> listExternalTechnician;

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	/**
	 * 
	 * @param specialization
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public static ArrayList<ExternalTechnician> getListExternalTechnician() {
		return ExternalTechnician.listExternalTechnician;
	}

	/**
	 * 
	 * @param name
	 * @param specialization
	 */
	public static void addExternalTechnician(String name, String specialization) {
		// TODO - implement ExternalTechnician.addExternalTechnician
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 */
	public static void removeExternalTechnician(int index) {
		// TODO - implement ExternalTechnician.removeExternalTechnician
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param specialization
	 */
	public void edit(String name, String specialization) {
		// TODO - implement ExternalTechnician.edit
		throw new UnsupportedOperationException();
	}

}