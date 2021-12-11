package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Rediff {
	WebDriver driver;
	
	@Given("User is on Rediff login page")
	public void user_is_on_Rediff_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");		
		driver= new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() {
		 driver.findElement(By.id("login1")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("admin");
	}

	@When("User clicks on signin button")
	public void user_clicks_on_signin_button() {
		driver.findElement(By.name("proceed")).click();
	}

	@Then("User is logged in")
	public void user_is_logged_in() {
	   System.out.println("Done");
	}

}
