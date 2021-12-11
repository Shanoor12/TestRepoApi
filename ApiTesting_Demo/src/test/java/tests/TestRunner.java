package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict =true,
		monochrome =true,
		//dryRun =true,
		//plugin="json:target/jsonReports/cucumber-report.json",
		features="src/test/resources/Features/Booker.feature",
		glue ="frameworkfinal",
		plugin= {"pretty", "html:target/html-report"}
		
		)

public class TestRunner {

}
