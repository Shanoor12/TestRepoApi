package Practice.automationtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Payment {
	
	
	//Variable declaration
		@FindBy(id ="billing_first_name")
		WebElement fstname; 
		@FindBy(id ="billing_last_name")
		WebElement lstname;
		@FindBy(id  ="billing_company")
		WebElement blgcmpn;
		@FindBy(id  ="billing_email")
		WebElement blgemail;
		@FindBy(id  ="billing_phone")
		WebElement blgphn;
		@FindBy(id  ="billing_city_field")
		WebElement blgcountry;
		@FindBy(id="billing_address_1")
		WebElement blgadd1;
		@FindBy(id="billing_city")
		WebElement blgcity;
		@FindBy(id="select2-chosen-2")
		WebElement blgstate;
		@FindBy(id="billing_postcode")
		WebElement blgpostcode;
		@FindBy(id="place_order")
		WebElement plcorder;
		
		
		
		//Constructor
		public Payment(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Methods
		public void PaymentPage(String fistname, String lastname, 
				String company,String email ,String phonenumber, String country, String Address1 ,String city, String state, String postcode)
		{
			fstname.sendKeys(fistname);
			lstname.sendKeys(lastname);
			blgcmpn.sendKeys(company);
			blgemail.sendKeys(email);
			blgphn.sendKeys(phonenumber);
			
			Select dd = new Select(blgcountry);
			dd.selectByVisibleText(country);
			
			blgadd1.sendKeys(Address1);
			blgcity.sendKeys(city);
			
			Select dd1 = new Select(blgstate);
			dd1.selectByVisibleText(state);
			
			blgpostcode.sendKeys(postcode);
			
		
			
		}

		

}
