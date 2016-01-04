package com.xoriant.resourcestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.xoriant.daotest.SurveyDaoTest;
import com.xoriant.model.Survey;

public class SurveyResourcesTest {
	private Survey survey = null;
	private Survey survey1 = null;

	/**
	 * 
	 */
	@Before
	public void init() {
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
			SurveyDaoTest.instance.getAllSurvey();
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
	public void getSurveysSuccessTest() throws SQLException {
		Map<String, Survey> surveys = null;
		surveys = SurveyDaoTest.instance.getAllSurvey();
		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList.addAll(surveys.values());
		assertEquals(surveyList.contains(survey), true);
	}

	/**
	 * @throws SQLException
	 * 
	 */
	@Test
	public void getSurveysFailTest() throws SQLException {
		Map<String, Survey> surveys = null;
		surveys = SurveyDaoTest.instance.getAllSurvey();
		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList.addAll(surveys.values());
		assertEquals(surveyList.contains(survey1), false);
	}

}
