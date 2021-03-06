package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import util.WebBrowser;
import util.WebElementMethods;

public class RediffLogin 
{
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
	
	

}
