package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import BinManagerPerson.Employee;
import BinManagerPerson.ListEmployee;
import BinManagerPerson.Person;

public class ListEmployeeTest {
	
	@Test
	public void testGetListEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetListEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEmployee() {
		ListEmployee l = new ListEmployee();
		
		Person e = new Person("haha","jojo@et.com", new Employee());
		l.addEmployee(e);
		
		ArrayList<Person> testList = new ArrayList<>();
		testList.add(e);
		
		assertEquals(1,l.size());
		assertEquals(testList, l.getListEmployee());
	}

	@Test
	public void testRemoveEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditEmployee() {
		fail("Not yet implemented");
	}

}
