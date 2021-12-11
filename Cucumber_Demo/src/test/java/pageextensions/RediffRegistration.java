package pageextensions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffRegistration {
	
	@FindBy(css = "input[name^='name']")
	WebElement txtfullname;
	@FindBy(css = "input[name^='login']")
	WebElement txtemail;
	@FindBy(css = "input[name^='passwd']")
	WebElement txtpassword;
	@FindBy(css = "input[name^='gender']")
	List<WebElement> rbgender;
	@FindBy(id="country")
	WebElement ddcountry;
	
	public RediffRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void register(String name, String email, String password, String gender,String country)
	{
		txtfullname.sendKeys(name);
		txtemail.sendKeys(email);
		txtpassword.sendKeys(password);
		for(WebElement rb: rbgender)
		{
			if(rb.getAttribute("value").equals(gender))
			{
				rb.click();
				break;
			}
		}
		Select dd = new Select(ddcountry);
		dd.selectByVisibleText(country);
	}

}
