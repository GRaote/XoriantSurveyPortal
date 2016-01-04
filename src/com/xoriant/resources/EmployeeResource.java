package com.xoriant.resources;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.xoriant.dao.EmployeeDao;
import com.xoriant.model.Employee;

/**
 * 
 * @author raote_g
 * 
 */
@Path("Employees")
public class EmployeeResource {
	static final Logger logger = LogManager.getLogger(EmployeeResource.class
			.getName());

	/**
	 * Adds an employee from the form to the database table Employee
	 * 
	 * @param emp
	 * @throws SQLException
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerEmployeeForSurvey(Employee emp) throws SQLException {
		logger.info("In registerEmployeeForSurvey");
		EmployeeDao.instance.addEmployee(emp);
	}

	/**
	 * Gets the list of all employees from the database
	 * 
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<Employee> getEmployeeList(
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getEmployeeList");
		ArrayList<Employee> EmpList = null;;
		try {
			EmpList = EmployeeDao.instance.getAllEmployee();
		} catch (SQLException e) {
			throw new NotAuthorizedException("No Employees found",
					servletResponse);
		}
		return EmpList;
	}
}
