package com.xoriant.resourcestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

//import static org.mockito.Mockito.*;
import com.xoriant.daotest.EmployeeDaoTest;
import com.xoriant.model.Employee;

/**
 * 
 * @author raote_g
 * 
 */
public class EmployeeResourceTest {
	private Employee employee;
	private Employee employee1;

	/**
	 * 
	 */
	@Before
	public void init() {
		employee = new Employee("e10", "Gaurang");
		employee1 = new Employee("e11", "Gaurang");
	}

	/**
	 * 
	 */
	@Test
	public void getAllEmployeesNullTest() {
		boolean gotException = true;

		try {
			EmployeeDaoTest.instance.getAllEmployee();
		} catch (SQLException | NullPointerException e) {
			System.out.println("Null pointer exception");
			gotException = false;
		}

		if (!gotException) {
			fail("Returned null");
		}
	}

	/**
	 * @throws SQLException
	 * 
	 */
	@Test
	public void getEmployeeSuccessTest() throws SQLException {
		ArrayList<Employee> empList = null;
		empList = EmployeeDaoTest.instance.getAllEmployee();
		assertEquals(empList.contains(employee1), true);
	}

	/**
	 * @throws SQLException
	 * 
	 */
	@Test
	public void getEmployeeFailTest() throws SQLException {
		ArrayList<Employee> empList = null;
		empList = EmployeeDaoTest.instance.getAllEmployee();
		assertEquals(empList.contains(employee), false);
	}

}
