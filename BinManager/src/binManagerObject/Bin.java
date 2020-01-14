package binManagerObject;
import java.util.*;

// TODO: Auto-generated Javadoc
import binManagerComment.Comment;
import binManagerHistory.History;

/**
 * The Class Bin.
 */
public class Bin extends Object {

	/** The Comment. */
	Collection<Comment> Comment;
	
	/** The History. */
	binManagerHistory.History History;
	
	/** The id. */
	private int id;
	
	/** The type. */
	private String type;
	
	/** The state. */
	private boolean state;
	
	/** The pos. */
	private Position pos;
	
	/**
	 * Instantiates a new bin.
	 *
	 * @param id the id
	 * @param type the type
	 * @param state the state
	 * @param pos the pos
	 */
	public Bin(int id, String type, boolean state, Position pos) {
		this.id = id;
		this.type = type;
		this.state = state;
		this.pos = pos;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public boolean getState() {
		return this.state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Position getPosition() {
		return this.pos;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param newPos the new position
	 */
	public void setPosition(Position newPos) {
		this.pos = newPos;
	}


	/**
	 * Edits the.
	 *
	 * @param type the type
	 * @param state the state
	 */
	public void edit(String type, boolean state) {
		// TODO - implement Bin.edit
		throw new UnsupportedOperationException();
	}

}