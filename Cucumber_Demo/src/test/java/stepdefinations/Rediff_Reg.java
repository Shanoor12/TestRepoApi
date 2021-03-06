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
import io.cucumber.datatable.DataTable;

public class Rediff_Reg


{
	WebDriver driver;
	@Given("User is on Rediff Registration page")
	public void user_is_on_Rediff_Registration_page() {
		driver = WebBrowser.openBrowser("http://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@When("User enters {string} {string} and {string}")
	public void user_enters_and(String name, String email, String password) {
		driver.findElement(By.cssSelector("input[name^='name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name^='login']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name^='passwd']")).sendKeys(password);
		
	}
	
	@When("User enters registration data")
	public void user_enters_registration_data(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class,  String.class);
		driver.findElement(By.cssSelector("input[name^='name']")).sendKeys(data.get("name"));
		driver.findElement(By.cssSelector("input[name^='login']")).sendKeys(data.get("email"));
		driver.findElement(By.cssSelector("input[name^='passwd']")).sendKeys(data.get("password"));
		List<WebElement> radios= driver.findElements(By.cssSelector("input[name^='gender']"));
		for(WebElement rb:radios)
		{
			if(rb.getAttribute("value").equals(data.get("gender")))
			{
				rb.click();
				break;
			}
		}
		Select dd =new Select(driver.findElement(By.id("country")));
		List<WebElement> options=dd.getOptions();
		for(WebElement op:options)
		{
			if(op.getText().equals(data.get("country")))
				{
			dd.selectByVisibleText(data.get("contry"));
			break;
				}
	    
		}

	}	
	
	@Then("User is Registered successfully")
	public void user_is_registered_successfully() {
		System.out.println("Done");
	}

}
