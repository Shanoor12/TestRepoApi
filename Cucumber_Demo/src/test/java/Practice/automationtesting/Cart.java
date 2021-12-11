package Practice.automationtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	
	
	//Variable declaration
	@FindBy(name  ="cart[3636638817772e42b59d74cff571fbb3][qty]")
	WebElement qty; 
	@FindBy(css ="input[type='submit']")
	WebElement btn;
	@FindBy(xpath   ="//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
	WebElement chkout;
	
	
	
	//Constructor
	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void CartPage()
	{
		qty.clear();
		qty.sendKeys("2");
		btn.click();
		chkout.click();
	}
	
	public void navigatePaymentPage()
	{
		chkout.click();
	}

}
