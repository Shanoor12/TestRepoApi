package pomstepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageextensions.RediffLogin;
import pageextensions.RediffRegistration;

public class RediffPOM {
	
	RediffLogin rlogin;
	RediffRegistration rreg;
	WebDriver driver;
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Create Page Objects
		rlogin = new RediffLogin(driver);
		rreg = new RediffRegistration(driver);
	}
	//Call Methods from the page classes using the Page Objects
	@Given("User is on Rediff Login page")
	public void user_is_on_Rediff_Login_page() {
	   driver.get("https://mail.rediff.com/cgi-bin/login.cgi");	   
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
	   rlogin.login(username, password);
	}

	@Then("The User is logged in")
	public void the_User_is_logged_in() {
	    System.out.println("Done");
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String experror) {
	   assertEquals(rlogin.getError(), experror);
	}

	@Given("User is navigated to registration page")
	public void user_is_navigated_to_registration_page() {
	   rlogin.navigateToRegistartion();
	}

	@When("User enters registration data")
	public void user_enters_registration_data(DataTable dataTable) {		
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		
		rreg.register(data.get("name"), data.get("email"), data.get("password")
				, data.get("gender"), data.get("country"));
	}

	@Then("User is registred successfully")
	public void user_is_registred_successfully() {
	   System.out.println("Done");
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}

}
