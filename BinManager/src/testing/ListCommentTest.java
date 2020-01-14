package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import BinManagerComment.Comment;
import BinManagerComment.ListComment;
import BinManagerObject.Bin;
import BinManagerObject.ListBin;
import BinManagerObject.Position;
import BinManagerPerson.Citizen;

public class ListCommentTest {

	@Test
	public void testGetListComment() {
		ListComment l = new ListComment();
		Citizen c = new Citizen();
		Comment com = new Comment(c, 0, "12-02-2019", "Alert", "testing");

		l.addComment(com);
		assertEquals(com,l.getComment(0));
	}

	@Test
	public void testSetListComment() {
		ListComment l = new ListComment();
		Citizen c = new Citizen();
		Comment com = new Comment(c, 0, "12-02-2019", "Alert", "testing");

		l.addComment(com);
		
		ListComment l2 = new ListComment();
		l2.setListComment(l.getListComment());
		assertEquals(l.getComment(0),l2.getComment(0));
	}

	@Test
	public void testAddComment() {
		ListComment l = new ListComment();
		Citizen c = new Citizen();
		Comment com = new Comment(c, 0, "12-02-2019", "Alert", "testing");

		l.addComment(com);
		
		ArrayList<Comment> testComment = new ArrayList<>();
		testComment.add(com);
		
		assertEquals(1,l.size());
		assertEquals(testComment, l.getListComment());
	}

	@Test
	public void testGetComment() {
		ListComment l = new ListComment();
		Citizen c = new Citizen();
		Comment com = new Comment(c, 0, "12-02-2019", "Alert", "testing");
		Comment com2 = new Comment(c, 1, "12-02-2019", "Alert", "testing");
		
		l.addComment(com);
		l.addComment(com2);
		
		assertEquals(com,l.getComment(0));
		assertEquals(com2,l.getComment(1));
	}

	@Test
	public void testSize() {
		ListComment l = new ListComment();
		Citizen c = new Citizen();
		Comment com = new Comment(c, 0, "12-02-2019", "Alert", "testing");
		Comment com2 = new Comment(c, 1, "12-02-2019", "Alert", "testing");
		
		l.addComment(com);
		l.addComment(com2);
		assertEquals(2,l.size());
	}

	@Test
	public void testRemoveComment() {
		ListComment l = new ListComment();
		Citizen c = new Citizen();
		Comment com = new Comment(c, 0, "12-02-2019", "Alert", "testing");
		Comment com2 = new Comment(c, 1, "12-02-2019", "Alert", "testing");
		
		l.addComment(com);
		l.addComment(com2);
		assertEquals(2,l.size());
		l.removeComment(1);
		assertEquals(1,l.size());
	}

}
