package BinManagerFacade;

import java.util.ArrayList;

import BinManagerAbstractFactory.MySQLFactory;
import BinManagerComment.Comment;
import BinManagerComment.ListComment;
import BinManagerDAO.Dao;
import BinManagerObject.ListBin;
import BinManagerPerson.Person;

public class ListCommentFacade implements Facade<ListComment>{
	private ListComment listComment;
	private Dao<ListComment> commentDao;
	
	public ListCommentFacade() {
		this.listComment = null;
		this.commentDao = null;
	}
	
	@Override
	public Dao<ListComment> getDao() {
		if(this.commentDao == null) {
			this.commentDao = createDao();
		}
		return this.commentDao;
	}
	
	public ListComment getListComment() {
		return this.listComment;
	}
	
	public Dao<ListComment> createDao(){
		//Creates a SQLDao using parameterized classes
		MySQLFactory<ListComment> p = new MySQLFactory<ListComment>(ListComment.class);
		return (Dao<ListComment>) p.createDao();
	}

	@Override
	public void update(ArrayList<String> info) {
		Dao<ListComment> dao = getDao();
		dao.update(info);
		//TODO update date and text comment in comment object
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}
	
	public void delete(int id) {
		Dao<ListComment> dao = getDao();
		this.listComment.removeComment(id);
		dao.delete(id);
	}

	@Override
	public boolean add(ArrayList<String> info) {
		Dao<ListComment> dao = getDao();
		boolean res = dao.add(info);
		return res;
	}

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
