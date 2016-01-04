package com.xoriant.model;

public class EmployeeSurvey {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empSurveyId == null) ? 0 : empSurveyId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeSurvey other = (EmployeeSurvey) obj;
		if (empSurveyId == null) {
			if (other.empSurveyId != null)
				return false;
		} else if (!empSurveyId.equals(other.empSurveyId))
			return false;
		return true;
	}

	public EmployeeSurvey(String empSurveyId) {
		super();
		this.empSurveyId = empSurveyId;
	}

	private String empSurveyId;

	private String empId;
	private String surveyId;
	private String title;
	private String finalChoice;

	public String getEmpSurveyId() {
		return empSurveyId;
	}

	public void setEmpSurveyId(String empSurveyId) {
		this.empSurveyId = empSurveyId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFinalChoice() {
		return finalChoice;
	}

	public void setFinalChoice(String finalChoice) {
		this.finalChoice = finalChoice;
	}

	public EmployeeSurvey(String empSurveyId, String empId, String surveyId,
			String title, String finalChoice) {
		super();
		this.empSurveyId = empSurveyId;
		this.empId = empId;
		this.surveyId = surveyId;
		this.title = title;
		this.finalChoice = finalChoice;
	}

	@Override
	public String toString() {
		return "EmployeeSurvey [empSurveyId=" + empSurveyId + ", empId="
				+ empId + ", surveyId=" + surveyId + ", title=" + title
				+ ", finalChoice=" + finalChoice + "]";
	}

}
