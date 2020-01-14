package binManagerFacade;

import java.util.ArrayList;

import binManagerAbstractFactory.MySQLFactory;
import binManagerComment.Comment;
import binManagerComment.ListComment;
import binManagerDAO.CommentDAOSQL;
import binManagerDAO.Dao;
import binManagerObject.ListBin;
import binManagerPerson.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCommentFacade.
 */
public class ListCommentFacade implements Facade<ListComment>{
	
	/** The list comment. */
	private ListComment listComment;
	
	/** The comment dao. */
	private Dao<ListComment> commentDao;
	
	/**
	 * Instantiates a new list comment facade.
	 */
	public ListCommentFacade() {
		this.listComment = null;
		this.commentDao = null;
	}
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	@Override
	public Dao<ListComment> getDao() {
		if(this.commentDao == null) {
			this.commentDao = createDao();
		}
		return this.commentDao;
	}
	
	/**
	 * Gets the list comment.
	 *
	 * @return the list comment
	 */
	public ListComment getListComment() {
		return this.listComment;
	}
	
	/**
	 * Creates the dao.
	 *
	 * @return the dao
	 */
	public Dao<ListComment> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListComment> p = new MySQLFactory<ListComment>(ListComment.class);
		return (Dao<ListComment>) p.createDao();
	}

	/**
	 * Update.
	 *
	 * @param info the info
	 */
	@Override
	public void update(ArrayList<String> info) {
		Dao<ListComment> dao = getDao();
		dao.update(info);
		//TODO update date and text comment in comment object
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Delete comment.
	 *
	 * @param id the id
	 */
	public void deleteComment(int id) {
		CommentDAOSQL dao = (CommentDAOSQL) getDao();
		this.listComment.removeComment(id);
		dao.deleteComment(id);
	}
	
	/**
	 * Delete alert.
	 *
	 * @param id the id
	 */
	public void deleteAlert(int id) {
		CommentDAOSQL dao = (CommentDAOSQL) getDao();
		this.listComment.removeComment(id);
		dao.deleteAlert(id);
	}

	/**
	 * Adds the.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	@Override
	public boolean add(ArrayList<String> info) {
		Dao<ListComment> dao = getDao();
		boolean res = dao.add(info);
		return res;
	}

	/**
	 * Load.
	 *
	 * @param info the info
	 * @return true, if successful
	 */
	@Override
	public boolean load(ArrayList<String> info) {
		Dao<ListComment> dao = getDao();
		this.listComment = dao.load(info);
		if(listComment == null) {
			return false;
		}
		return true;
	}

}
