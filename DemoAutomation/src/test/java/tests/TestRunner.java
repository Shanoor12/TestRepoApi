package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	
			dryRun = true,
			features = "src/test/resources/Features",
			glue = "stepDefinitions",
			plugin = {"pretty", "html: html-report"}
			
		)
public class TestRunner {

}
