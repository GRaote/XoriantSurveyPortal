package com.xoriant.daotest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.xoriant.dao.supp.ConnectionFactoryTest;
import com.xoriant.model.Survey;

/**
 * 
 * @author raote_g
 * 
 */
public enum SurveyDaoTest {
	instance;

	/**
	 * Adds survey
	 * 
	 * @param survey
	 * @throws SQLException
	 */
	public void addSurvey(Survey survey) throws SQLException {
		Connection connection = ConnectionFactoryTest.getConnection();
		String query = "INSERT INTO SURVEY VALUES(?,?,?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setString(1, survey.getSurveyId());
		pStatement.setString(2, survey.getTitle());
		pStatement.setString(3, survey.getChoice1());
		pStatement.setString(4, survey.getChoice2());
		pStatement.setString(5, survey.getStatus());
		pStatement.executeUpdate();

	}

	/**
	 * Gets the list of Surveys
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Survey> getAllSurvey() throws SQLException {

		Connection connection = ConnectionFactoryTest.getConnection();
		Map<String, Survey> surveyList = new HashMap<String, Survey>();
		String query = "SELECT * FROM SURVEY";
		PreparedStatement pStatement = connection.prepareStatement(query);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			surveyList.put(
					resultSet.getString("surveyId"),
					new Survey(resultSet.getString("surveyId"), resultSet
							.getString("title"),
							resultSet.getString("choice1"), resultSet
									.getString("choice2"), resultSet
									.getString("status")));
		}

		return surveyList;
	}
}
