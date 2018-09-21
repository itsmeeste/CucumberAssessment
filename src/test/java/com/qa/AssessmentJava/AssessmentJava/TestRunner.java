package com.qa.AssessmentJava.AssessmentJava;

import org.junit.runner.RunWith;

import com.qa.AssessmentJava.AssessmentJava.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.FEATUREFILE)
public class TestRunner 
{

}
