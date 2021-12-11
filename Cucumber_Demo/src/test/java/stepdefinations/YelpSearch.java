package stepdefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import util.WebBrowser;

public class YelpSearch 



{
	WebDriver driver;
	@Given(" person is on yelp home page")
	
	public void  person_is_on_yelp_home_page()
	{
		 driver = WebBrowser.openBrowser("https://www.yelp.com/");
	}
	
	@When("person searches for {string}")
	
	public void person_searches_for(String Restuarant) 
	{
		driver.findElement(By.id("find_desc")).sendKeys(Restuarant);
		driver.findElement(By.id("search_description")).click();
		
	}
	
	//@Then("The Results for {string} are displayed")
	
	public void The_Results_for_are_displayed(String expresult)
	{
		
		
	}

	//@when("I Filter results by(string}")
	public void I_Filter_results_by(String criteria){
		List<WebElement> chkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for(WebElement ch :chkboxes)
		{
			if(ch.getAttribute("value").equals(criteria))
			{
				if(! ch.isSelected())
				{
					ch.click();
				}
			}
		}
			
	}
	
	
//	@Then("I see results filtered by criteria {string}")
//	public void i_see_results_filtered_by_criteria
	
	
	
	

}
