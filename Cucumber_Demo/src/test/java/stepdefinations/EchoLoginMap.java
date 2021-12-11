package stepdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import util.WebBrowser;
import util.WebElementMethods;

public class EchoLoginMap {
	WebDriver driver;
	
	@Given("User2 is on Echo Login page")
	public void user2_is_on_Echo_Login_page() {
		driver = WebBrowser.openBrowser("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
	    
	}

	@When("User2 logs in with data")
	public void user2_logs_in_with_data(DataTable dataTable) {
		List<Map<String, String>> data= dataTable.asMaps();
		for(Map<String, String> map:data)
		{
			WebElementMethods.enterText(driver, By.id("txtCustomerID"), map.get("username"));
			WebElementMethods.enterText(driver, By.id("txtPassword"), map.get("password"));
			WebElementMethods.clickElement(driver,  By.id("Butsub"));
			driver.findElement(By.id("txtCustomerID")).clear();
			driver.findElement(By.id("txtPassword")).clear();
		}
	    
	}

}
