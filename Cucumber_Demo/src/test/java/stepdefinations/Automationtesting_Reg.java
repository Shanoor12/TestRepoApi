package stepdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.WebBrowser;

public class Automationtesting_Reg 


{
	WebDriver driver;
	@Given("User1 is on automationtesting page")
	public void User1_is_on_automationtesting_page() {
		driver = WebBrowser.openBrowser("http://demo.automationtesting.in/Register.html");
	}
	
	@When("User1 enters registration data")
	public void user1_enters_registration_data(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class,  String.class);
		driver.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys(data.get("name"));
		driver.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys(data.get("lastname"));
		driver.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys(data.get("email"));
		List<WebElement> radios= driver.findElements(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(2) > input"));
		for(WebElement rb:radios)
		{
			if(rb.getAttribute("value").equals(data.get("gender")))
			{
				rb.click();
				break;
			}
		}
		Select dd =new Select(driver.findElement(By.id("Skills")));
		List<WebElement> options=dd.getOptions();
		for(WebElement op:options)
		{
			if(op.getText().equals(data.get("skills")))
				{
			dd.selectByVisibleText(data.get("skills"));
			break;
				}
	    
		}

	}
	    
	

	@Then("User1 is registered successfully")
	public void user1_is_registered_successfully() {
		System.out.println("Done");
	    
	}


}
