package com.FSTCucumber.Activities;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    //tags = "@activity4"
	    tags ="@activity5"
	)

	public class Activity4and5LoginTR {


}
