package com.xoriant.resourcestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.xoriant.daotest.EmployeeSurveyDaoTest;
import com.xoriant.model.EmployeeSurvey;
import com.xoriant.model.Survey;

public class EmployeeSurveyResourceTest {
	private EmployeeSurvey empSurvey = null;
	private EmployeeSurvey empSurvey1 = null;
	private Survey survey = null;
	private Survey survey1 = null;

	/**
	 * 
	 */
	@Before
	public void init() {
		empSurvey = new EmployeeSurvey("e01001");
		empSurvey1 = new EmployeeSurvey("e01050");
		survey = new Survey("001");
		survey1 = new Survey("050");
	}

	/**
	 * 
	 */
	@Test
	public void testGetAllSurveys() {
		boolean gotException = true;

		try {
			EmployeeSurveyDaoTest.instance.getAllSurveyConduced();
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
	public void getEmployeeSurveysSuccessTest() throws SQLException {
		Map<String, EmployeeSurvey> empSurveys = null;
		empSurveys = EmployeeSurveyDaoTest.instance.getAllSurveyConduced();
		List<EmployeeSurvey> empSurveyList = new ArrayList<EmployeeSurvey>();
		empSurveyList.addAll(empSurveys.values());
		assertEquals(empSurveyList.contains(empSurvey), true);
	}

	/**
	 * @throws SQLException
	 * 
	 */
	@Test
	public void getEmployeeSurveysFailTest() throws SQLException {
		Map<String, EmployeeSurvey> empSurveys = null;
		empSurveys = EmployeeSurveyDaoTest.instance.getAllSurveyConduced();
		List<EmployeeSurvey> empSurveyList = new ArrayList<EmployeeSurvey>();
		empSurveyList.addAll(empSurveys.values());
		assertEquals(empSurveyList.contains(empSurvey1), false);
	}

	/**
	 * @throws SQLException
	 * 
	 */
	@Test
	public void getEmployeeByIdSurveysSuccessTest() throws SQLException {
		List<Survey> empSurveyList = null;
		empSurveyList = EmployeeSurveyDaoTest.instance
				.getAllSurveyConducedByEmpId("e01");
		assertEquals(empSurveyList.contains(survey), true);
	}

	/**
	 * @throws SQLException
	 * 
	 */
	@Test
	public void getEmployeeByIdSurveysFailTest() throws SQLException {
		List<Survey> empSurveyList = null;
		empSurveyList = EmployeeSurveyDaoTest.instance
				.getAllSurveyConducedByEmpId("e01");
		assertEquals(empSurveyList.contains(survey1), false);
	}

}
