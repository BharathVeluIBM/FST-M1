package com.FSTCucumber.Activities;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(
//	    features = "src/test/resources/Features",
//	    glue = {"stepDefinition"},
//	    tags = "@activity1",
//	    plugin = {"pretty", "html:target/cucumber-reports"},
//	    monochrome = true
//	)

//@CucumberOptions(
//	    features = "src/test/resources/Features",
//	    glue = {"stepDefinition"},
//	    tags = "@activity1",
//	    plugin = {"html: test-reports"},
//	    monochrome = true
//	)

@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = {"stepDefinition"},
	    tags = "@activity1",
	    plugin = {"json: test-reports/json-report.json"},
	    monochrome = true
	)

public class Activity6 {

}
