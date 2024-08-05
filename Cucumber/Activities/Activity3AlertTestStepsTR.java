package com.FSTCucumber.Activities;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
	    glue = {"stepDefinition"},
	    tags = "@activity3",
	    plugin = {"pretty", "html:target/cucumber-reports"},
	    monochrome = true
	    )
public class Activity3AlertTestStepsTR {

}