package com.xoriant.daotest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xoriant.dao.supp.ConnectionFactoryTest;
import com.xoriant.model.Employee;

/**
 * 
 * @author raote_g
 * 
 */
public enum EmployeeDaoTest {
	instance;

	/**
	 * Adds employee
	 * 
	 * @param employee
	 * @throws SQLException
	 */
	public void addEmployee(Employee employee) throws SQLException {
		Connection connection = ConnectionFactoryTest.getConnection();
		String query = "INSERT INTO EMPLOYEE VALUES(?,?)";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setString(1, employee.getEmpId());
		pStatement.setString(2, employee.getEname());
		pStatement.executeUpdate();

	}

	/**
	 * Gets the list of all employees
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Employee> getAllEmployee() throws SQLException {
		Connection connection = ConnectionFactoryTest.getConnection();
		ArrayList<Employee> employee = new ArrayList<>();
		String query = "SELECT * FROM EMPLOYEE";
		PreparedStatement pStatement = connection.prepareStatement(query);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			employee.add(new Employee(resultSet.getString("empId"), resultSet
					.getString("ename")));
		}
		return employee;
	}
}
