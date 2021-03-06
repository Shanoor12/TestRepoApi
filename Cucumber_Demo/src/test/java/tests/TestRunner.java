package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	
			//dryRun = true,
			features = "src/test/resources/Features/PracticeAutomation.feature",
			glue = "Pom.practiceAutomation",
			plugin="json:target/jsonReports/cucumber-report.json",
			//plugin = {"pretty","html:target/html-report"},
			monochrome =  true
			//tags= {"@login"}
			//tags = {"@reg and @pri1"}
		)

public class TestRunner 

{
	

}
