package stepdefinations;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.WebBrowser;
import util.WebElementMethods;

public class RediffLogin {
	
	WebDriver driver;
	@Given("User is on Rediff Login page")
	public void user_is_on_Rediff_Login_page() {	    
		driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");	
	}

	@When("User enters a valid username and password")
	public void user_enters_a_valid_username_and_password() {	  
		WebElementMethods.enterText(driver, By.id("login1"), "admin");
		WebElementMethods.enterText(driver, By.id("password"), "admin12");	   
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   WebElementMethods.clickElement(driver, By.name("proceed"));	   
	}

	@Then("User is logged in")
	public void user_is_logged_in() {
	   System.out.println("Done!!");	   
	}

	@When("User enters an invalid username and password")
	public void user_enters_an_invalid_username_and_password() { 
		WebElementMethods.enterText(driver, By.id("login1"), "testuser");
		WebElementMethods.enterText(driver, By.id("password"), "testuser12");
	}

	@Then("An error is displayed")
	public void an_error_is_displayed() {
		String acterror = driver.findElement(By.cssSelector("div#div_login_error>b")).getText();
		assertEquals(acterror, "Wrong username and password combination.");	   
	}

	@When("User enters username")
	public void user_enters_username() {
		WebElementMethods.enterText(driver, By.id("login1"), "testuser");	    
	}

	@When("User clicks on Forgot password link")
	public void user_clicks_on_Forgot_password_link() {
		 WebElementMethods.clickElement(driver, By.linkText("Forgot Password?"));
	}

	@Then("User is navigated to reset password page")
	public void user_is_navigated_to_reset_password_page() {
	   String title = driver.getTitle();
	   assertEquals(title, "Password help assistance");
	   
	}
	
	
	
//	@When("User logs in with data")
//	public void user_logs_in_with_data(DataTable dataTable) {
//		List<List<String>> data= dataTable.asLists();
//		for(List<String> lst :data)
//		{
//			WebElementMethods.enterText(driver, By.id("login1"), lst.get(0));
//			WebElementMethods.enterText(driver, By.id("password"), lst.get(1));
//			WebElementMethods.clickElement(driver,  By.name("proceed"));
//			driver.findElement(By.id("login1")).clear();
//			driver.findElement(By.id("password")).clear();
//		}
//	}
	
	@When("User logs in with data")
	public void user_logs_in_with_data(DataTable dataTable){

	List<Map<String, String>> data= dataTable.asMaps();
	for(Map<String, String> map:data)
	{
		WebElementMethods.enterText(driver, By.id("login1"), map.get("username"));
		WebElementMethods.enterText(driver, By.id("password"), map.get("password"));
		WebElementMethods.clickElement(driver,  By.name("proceed"));
		driver.findElement(By.id("login1")).clear();
		driver.findElement(By.id("password")).clear();
	}

}
}
