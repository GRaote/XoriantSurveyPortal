package com.xoriant.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.xoriant.resourcestest.SurveyResourcesTest;

/**
 * 
 * @author raote_g
 * 
 */
@RunWith(Suite.class)
@SuiteClasses(value = { SurveyResourcesTest.class })
public class SurveyTestSuite {

}