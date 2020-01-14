package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import binManagerCost.*;

import org.junit.Test;

public class ListExpensesTest {

	@Test
	public void testGetListExpenses() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon", 3, d);

		l.addExpense(e);
		assertEquals(e,l.getExpense(0));
	}

	@Test
	public void testSetListExpenses() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon", 3, d);

		l.addExpense(e);
		
		ListExpenses l2 = new ListExpenses();
		l2.setListExpenses(l.getListExpenses());
		assertEquals(l.getExpense(0),l2.getExpense(0));
	}

	@Test
	public void testAddExpense() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon", 3, d);
		
		assertEquals(0,l.size());
		
		l.addExpense(e);
		
		assertEquals(1,l.size());
	}

	@Test
	public void testRemoveExpense() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon", 3, d);
		
		l.addExpense(e);
		assertEquals(1,l.size());
		
		l.removeExpense("boulon");
		assertEquals(0,l.size());
	}

	@Test
	public void testGetExpenseInt() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon1", 3, d);
		Expense e2 = new Expense("piece", "boulon2", 2, d);
		
		l.addExpense(e);
		l.addExpense(e2);
		
		assertEquals(e,l.getExpense(0));
		assertEquals(e2,l.getExpense(1));
	}

	@Test
	public void testGetExpenseString() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon1", 3, d);
		Expense e2 = new Expense("piece", "boulon2", 2, d);
		
		l.addExpense(e);
		l.addExpense(e2);
		
		assertEquals(e,l.getExpense("boulon1"));
		assertEquals(e2,l.getExpense("boulon2"));
	}

	@Test
	public void testSize() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon1", 3, d);
		Expense e2 = new Expense("piece", "boulon2", 2, d);
		
		l.addExpense(e);
		l.addExpense(e2);
		
		assertEquals(2,l.size());
	}

	@Test
	public void testEditExpense() {
		ListExpenses l = new ListExpenses();
		Date d = new Date();
		Expense e = new Expense("piece", "boulon1", 3, d);
		
		l.addExpense(e);
		ArrayList<String> a = new ArrayList<String>();
		a.add(e.getCostCategory());
		a.add(e.getName());
		a.add("4");
		l.editExpense(a);
		e.setPrice(4);
		
		assertEquals(e,l.getExpense(0));
	}

}
