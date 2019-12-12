package BinManagerObject;
import java.util.*;

public class Bin extends Object {

	Collection<Comment> Comment;
	History History;
	private String type;
	private boolean state;
	private static ArrayList<Bin> listBin;

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public boolean getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	public static ArrayList<Bin> getListBin() {
		return this.listBin;
	}

	/**
	 * 
	 * @param type
	 * @param state
	 * @param position
	 */
	public static void addBin(String type, boolean state, Position position) {
		// TODO - implement Bin.addBin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 */
	public static void removeBin(int index) {
		// TODO - implement Bin.removeBin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param state
	 */
	public void edit(String type, boolean state) {
		// TODO - implement Bin.edit
		throw new UnsupportedOperationException();
	}

}