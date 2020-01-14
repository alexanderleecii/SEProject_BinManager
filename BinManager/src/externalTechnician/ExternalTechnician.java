package externalTechnician;
import java.util.*;

import binManagerCompany.TechnicianCompany;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalTechnician.
 */
public class ExternalTechnician {

	/** The Company. */
	TechnicianCompany Company;
	
	/** The name. */
	private String name;
	
	/** The specialization. */
	private String specialization;
	
	/** The list external technician. */
	private static ArrayList<ExternalTechnician> listExternalTechnician;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the specialization.
	 *
	 * @return the specialization
	 */
	public String getSpecialization() {
		return this.specialization;
	}

	/**
	 * Sets the specialization.
	 *
	 * @param specialization the new specialization
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * Gets the list external technician.
	 *
	 * @return the list external technician
	 */
	public static ArrayList<ExternalTechnician> getListExternalTechnician() {
		return ExternalTechnician.listExternalTechnician;
	}

	/**
	 * Adds the external technician.
	 *
	 * @param name the name
	 * @param specialization the specialization
	 */
	public static void addExternalTechnician(String name, String specialization) {
		// TODO - implement ExternalTechnician.addExternalTechnician
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the external technician.
	 *
	 * @param index the index
	 */
	public static void removeExternalTechnician(int index) {
		// TODO - implement ExternalTechnician.removeExternalTechnician
		throw new UnsupportedOperationException();
	}

	/**
	 * Edits the.
	 *
	 * @param name the name
	 * @param specialization the specialization
	 */
	public void edit(String name, String specialization) {
		// TODO - implement ExternalTechnician.edit
		throw new UnsupportedOperationException();
	}

}