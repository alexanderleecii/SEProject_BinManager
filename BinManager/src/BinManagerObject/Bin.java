package BinManagerObject;
import java.util.*;
import BinManagerComment.Comment;
import BinManagerHistory.History;
public class Bin extends Object {

	Collection<Comment> Comment;
	BinManagerHistory.History History;
	private int id;
	private String type;
	private boolean state;
	private Position pos;
	
	public Bin(int id, String type, boolean state, Position pos) {
		this.id = id;
		this.type = type;
		this.state = state;
		this.pos = pos;
	}
	
	public int getId() {
		return this.id;
	}

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
	
	public Position getPosition() {
		return this.pos;
	}
	
	public void setPosition(Position newPos) {
		this.pos = newPos;
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