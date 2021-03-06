package Pom.practiceAutomation;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Practice.automationtesting.Cart;
import Practice.automationtesting.Payment;
import Practice.automationtesting.Shop;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class practiceAutomationPOM {
	
	Shop home;
	Cart addcart;
	Payment checkout;
	
	WebDriver driver;
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Create Page Objects
		home = new Shop(driver);
		addcart = new Cart(driver);
		checkout =new Payment(driver);
	}
	
	
	
	@Given("User3 is on practice automation page")
	public void user3_is_on_practice_automation_page() {
		
		driver.get("http://practice.automationtesting.in/shop/");	
	    
	}
	
	@When("User3 clicks on any listed image item and click on add basket button")
	public void user3_clicks_on_any_listed_image_item_and_click_on_add_basket_button() {
		home.HomePage();
	}
	    

	@Then("The product will add to cart")
	public void the_product_will_add_to_cart() {
		System.out.println("product added to cart successfully");	
	    
	}

	@Given("User3 is on cart page")
	public void user3_is_on_cart_page() {
		driver.get("http://practice.automationtesting.in/basket/");	
		
		
	    
	}

	@When("User3 click on Increase quantity and click on update button")
	public void user3_click_on_Increase_quantity_and_click_on_update_button() {
		
		addcart.CartPage();
	    
	}

	@Then("User3 proceed to payment page")
	public void user3_proceed_to_payment_page() {
		
		System.out.println("User proceeded to payment page");
	    
	}

	@Given("User3 is on payment page")
	public void user3_is_on_payment_page() {
		System.out.println("Please fill all the details");
	    
	}

	@When("User enters registration data")
	public void user_enters_registration_data(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		
		checkout.PaymentPage(data.get("fisrtname"), data.get("lastname"), data.get("company")
				, data.get("email") ,data.get("phonenumber"), data.get("country") ,data.get("address"), data.get("city") , data.get("state"),data.get("phonenumber"));
	    
	}
	
	@Then("User process to payment")
	public void user_process_to_payment() {
	    System.out.println("Done");
	}
	
	

}
