package com.xoriant.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.xoriant.dao.SurveyDao;
import com.xoriant.model.Survey;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author raote_g
 * 
 */
@Path("Surveys")
public class SurveyResources {
	static final Logger logger = LogManager.getLogger(SurveyResources.class
			.getName());

	/**
	 * Adds a new survey to the database table Survey
	 * 
	 * @param survey
	 * @throws IOException
	 * @throws SQLException
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addNewSurvey(Survey survey) throws IOException, SQLException {
		logger.info("In addNewSurvey");
		SurveyDao.instance.addSurvey(survey);
	}

	/**
	 * Gets all the lists of surveys
	 * 
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Survey> getSurveyList(
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getSurveyList");
		Map<String, Survey> surveys = null;
		try {
			surveys = SurveyDao.instance.getAllSurvey();
		} catch (SQLException e) {
			throw new NotAuthorizedException("No Surveys found",
					servletResponse);
		}
		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList.addAll(surveys.values());
		return surveyList;
	}

	/**
	 * Gets the total number of surveys
	 * 
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Path("Counts")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountOfSurvey(
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getCountOfSurvey");
		Map<String, Survey> surveys = null;
		try {
			surveys = SurveyDao.instance.getAllSurvey();
		} catch (SQLException e) {
			throw new NotAuthorizedException("No Surveys found",
					servletResponse);
		}
		int count = surveys.size();
		return String.valueOf(count);
	}

	/**
	 * Gets the survey by survey id
	 * 
	 * @param id
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Survey getSurvey(@PathParam("id") String id,
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getSurvey");
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		Map<String, Survey> surveys = null;
		try {
			surveys = SurveyDao.instance.getAllSurvey();
		} catch (SQLException e) {
			throw new NotAuthorizedException("Survey not found",
					servletResponse);
		}
		listOfSurvey.addAll(surveys.values());
		Survey sur = null;
		Iterator<Survey> itr = listOfSurvey.iterator();
		while (itr.hasNext()) {
			Survey survey = itr.next();
			if (survey.getSurveyId().equals(id)) {
				sur = survey;
			}
		}

		return sur;
	}

	/**
	 * Gets the results of the survey by survey id
	 * 
	 * @param id
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Path("SurveyResult/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Survey getSurveyResult(@PathParam("id") String id,
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getSurveyResult");
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		Map<String, Survey> surveys = null;
		try {
			surveys = SurveyDao.instance.getAllSurvey();
		} catch (SQLException e) {
			throw new NotAuthorizedException("Survey not found",
					servletResponse);
		}
		listOfSurvey.addAll(surveys.values());
		Survey sur = null;
		Iterator<Survey> itr = listOfSurvey.iterator();
		while (itr.hasNext()) {
			Survey survey = itr.next();
			if (survey.getSurveyId().equals(id)) {
				sur = survey;
			}
		}

		return sur;
	}

	/**
	 * Fetches a random survey
	 * 
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Path("Random")
	@Produces(MediaType.APPLICATION_JSON)
	public Survey getRandomSurvey(@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getRandomSurvey");
		Random random = new Random();
		ArrayList<Survey> listOfAllSurveys = new ArrayList<Survey>();
		ArrayList<Survey> listOfOpenSurveys = new ArrayList<Survey>();
		Map<String, Survey> surveys = null;
		try {
			surveys = SurveyDao.instance.getAllSurvey();
		} catch (SQLException e) {
			throw new NotAuthorizedException("Survey not found",
					servletResponse);
		}
		listOfAllSurveys.addAll(surveys.values());
		for (Survey survey : listOfAllSurveys) {
			if (survey.getStatus().equalsIgnoreCase("open")) {
				listOfOpenSurveys.add(survey);
			}
		}
		int index = random.nextInt(listOfOpenSurveys.size());
		return listOfOpenSurveys.get(index);
	}

	/**
	 * Returns survey status
	 * 
	 * @param status
	 * @param servletResponse
	 * @param servletRequest
	 * @return
	 */
	@GET
	@Path("/Status/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Survey> getSurveyListByStatus(
			@PathParam("status") String status,
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest servletRequest) {
		logger.info("In getSurveyListByStatus");
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		Map<String, Survey> surveys = null;
		try {
			surveys = SurveyDao.instance.getAllSurvey();
		} catch (SQLException e) {
			throw new NotAuthorizedException("No Surveys found",
					servletResponse);
		}
		listOfSurvey.addAll(surveys.values());
		ArrayList<Survey> listOfSurveyStatus = new ArrayList<Survey>();
		for (Survey survey : listOfSurvey) {
			if (survey.getStatus().equals(status)) {
				listOfSurveyStatus.add(survey);
			}
		}

		return listOfSurveyStatus;
	}

}
