package stepdefinations;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.WebBrowser;

public class AmazonSearch {
	
	
	WebDriver driver;
	
	@Given("User is on Amazon Home page")
	public void user_is_on_Amazon_Home_page()
	{
		 driver = WebBrowser.openBrowser("https://www.amazon.in/");
		
	}
	
	@When("User searches for {string}")
	public void user_searches_for(String product) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
	@Then("Results for {string} are displayed")
	public void results_for_are_displayed(String expresult) {
		WebElement actresult =driver.findElement(By.cssSelector("div#search>span>div>span>h1>div>div>pan:nth-chi"));
		//assertTrue(actresult.contains(expresult));
	}
	
	@When("User sorts the results by {string}")
	public void user_sorts_the_results_by(String criteria) {
		driver.findElement(By.id("a-autoid-0-announce")).click();
		List<WebElement>options=driver.findElements(By.cssSelector("a.a-dropdown-link"));
		for(WebElement op : options)
		{
			if(op.getText().equals(criteria))
			{
				op.click();
				break;
			}
		}
	}
	
	@Then("Reults are sorted by {string}")
	public void results_are_sorted_by(String criteria) {
		driver.findElement(By.xpath("//span[text()='Smartphones']")).click();
	}
	
	@Then("Results are Filtered {string}")
	public void results_are_Filtered(String criteria) {
		System.out.println("Done");
	}

}
