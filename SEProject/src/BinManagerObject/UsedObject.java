package BinManagerObject;
public class UsedObject extends Object {

	private String name;
	private String description;
	private String reference;
	private String price;
	private static ArrayList<UsedObject> listUsedObject;

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

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return this.reference;
	}

	/**
	 * 
	 * @param reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	public static ArrayList<UsedObject> getListUsedObject() {
		return this.listUsedObject;
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param reference
	 * @param price
	 */
	public static void addUsedObject(String name, String description, String reference, String price) {
		// TODO - implement UsedObject.addUsedObject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reference
	 */
	public static void removeUsedObject(String reference) {
		// TODO - implement UsedObject.removeUsedObject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param reference
	 * @param price
	 */
	public void edit(String name, String description, String reference, String price) {
		// TODO - implement UsedObject.edit
		throw new UnsupportedOperationException();
	}

}