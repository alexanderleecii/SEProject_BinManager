package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import binManagerObject.Bin;
import binManagerPerson.Employee;
import binManagerPerson.ListEmployee;
import binManagerPerson.Person;

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
		ListEmployee emp=new ListEmployee();
		Person e = new Person("haha","jojo@et.com", new Employee());
		Person f = new Person("hehe","jojo@et.com", new Employee());
		emp.addEmployee(e);
		emp.addEmployee(f);
		assertEquals(2, emp.size());
		emp.removeEmployee("jojo@et.com");
		
		ArrayList<Person> testList = new ArrayList<>();
		testList.add(f);
		assertEquals(1, testList.size());
		assertEquals(testList, emp.getListEmployee());
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
