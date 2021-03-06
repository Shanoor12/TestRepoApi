package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	
			//dryRun = true,
			features = "src/test/resources/Features",
			glue = "stepdefinitions",
			plugin = {"pretty","html:target/html-report"},
			monochrome =  true
		)
public class TestRunner {

}
