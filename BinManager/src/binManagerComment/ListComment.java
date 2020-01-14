package binManagerComment;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListComment.
 */
public class ListComment {
	
	/** The list comment. */
	private ArrayList<Comment> listComment;
	
	/**
	 * Instantiates a new list comment.
	 */
	public ListComment() {
		this.listComment = new ArrayList<>();
	}

	/**
	 * Gets the list comment.
	 *
	 * @return the list comment
	 */
	public ArrayList<Comment> getListComment() {
		return listComment;
	}

	/**
	 * Sets the list comment.
	 *
	 * @param listComment the new list comment
	 */
	public void setListComment(ArrayList<Comment> listComment) {
		this.listComment = listComment;
	}
	
	/**
	 * Adds the comment.
	 *
	 * @param c the c
	 */
	public void addComment(Comment c) {
		getListComment().add(c);
	}
	
	/**
	 * Gets the comment.
	 *
	 * @param i the i
	 * @return the comment
	 */
	public Comment getComment(int i) {
		return getListComment().get(i);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return getListComment().size();
	}
	
	/**
	 * Removes the comment.
	 *
	 * @param id the id
	 */
	public void removeComment(int id) {
		int j = 0;
		while(this.listComment.get(j).getId() != id) {
			j++;
		}
		this.listComment.remove(j);
	}
}
