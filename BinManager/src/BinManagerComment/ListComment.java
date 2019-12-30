package BinManagerComment;

import java.util.ArrayList;

public class ListComment {
	private ArrayList<Comment> listComment;
	
	public ListComment() {
		this.listComment = new ArrayList<>();
	}

	public ArrayList<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(ArrayList<Comment> listComment) {
		this.listComment = listComment;
	}
	
	public void addComment(Comment c) {
		getListComment().add(c);
	}
	
	public Comment getComment(int i) {
		return getListComment().get(i);
	}
	
	public int size() {
		return getListComment().size();
	}
	
	public void removeComment(int id) {
		int j = 0;
		while(this.listComment.get(j).getId() != id) {
			j++;
		}
		this.listComment.remove(j);
	}
}
