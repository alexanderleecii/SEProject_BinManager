package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import binManagerObject.Bin;
import binManagerObject.ListBin;
import binManagerObject.Position;

// TODO: Auto-generated Javadoc
/**
 * The Class ListBinTest.
 */
public class ListBinTest {

	/**
	 * Test set list bin.
	 */
	@Test
	public void testSetListBin() {
		ListBin l = new ListBin();
		
		Position pos = new Position("1.1","2.2");
		Bin b = new Bin(1,"recycling",false,pos);
		l.addBin(b);
		
		ListBin l1 = new ListBin();
		l1.setListBin(l.getListBin());
		
		assertEquals(l.getListBin(), l1.getListBin());
	}

	/**
	 * Test add bin.
	 */
	@Test
	public void testAddBin() {
		ListBin l = new ListBin();
		
		Position pos = new Position("1.1","2.2");
		Bin b = new Bin(1,"recycling",false,pos);
		l.addBin(b);
		
		ArrayList<Bin> testList = new ArrayList<>();
		testList.add(b);
		
		assertEquals(1,l.size());
		assertEquals(testList, l.getListBin());
	}

	/**
	 * Test remove bin.
	 */
	@Test
	public void testRemoveBin() {
		ListBin l = new ListBin();
		
		Position pos = new Position("1.1","2.2");
		Bin b = new Bin(1,"recycling",false,pos);
		Bin b2 = new Bin(2,"recycling",false,pos);
		l.addBin(b);
		l.addBin(b2);
		
		assertEquals(2,l.size());
		
		l.removeBin(2);
		
		ArrayList<Bin> testList = new ArrayList<>();
		testList.add(b);
		
		assertEquals(1,l.size());
		assertEquals(testList, l.getListBin());
	}

	/**
	 * Test get bin.
	 */
	@Test
	public void testGetBin() {
		ListBin l = new ListBin();
		Position pos = new Position("1.1","2.2");
		Bin b = new Bin(1,"recycling",false,pos);
		Bin b2 = new Bin(2,"recycling",false,pos);
		l.addBin(b);
		l.addBin(b2);
		assertEquals(b,l.getBin(0));
		assertEquals(b2,l.getBin(1));
	}

	/**
	 * Test size.
	 */
	@Test
	public void testSize() {
		ListBin l = new ListBin();
		assertEquals(0,l.size());
		Position pos = new Position("1.1","2.2");
		Bin b = new Bin(1,"recycling",false,pos);
		Bin b2 = new Bin(2,"recycling",false,pos);
		l.addBin(b);
		l.addBin(b2);
		assertEquals(2,l.size());
		
	}

}
