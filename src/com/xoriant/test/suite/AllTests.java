package com.xoriant.test.suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author raote_g
 * 
 */
@RunWith(Suite.class)
@SuiteClasses(value = { EmployeeSurveyTestSuite.class, EmployeeTestSuite.class,
		SurveyTestSuite.class })
public class AllTests {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses();
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
