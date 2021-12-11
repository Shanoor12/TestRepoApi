package pageextensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLogin {
	
	//Variable declaration
		@CacheLookup @FindBy(id="login1")
		WebElement txtusername; 
		@CacheLookup @FindBy(id="password")
		WebElement txtpassword;
		@CacheLookup @FindBy(name = "proceed")
		WebElement btnlogin;
		@CacheLookup @FindBy(linkText = "Create a new account")
		WebElement lnkcreateacc;
		@CacheLookup @FindBy(css="div.div_login_error>b")
		WebElement lblerror;
		
		//Constructor
		public RediffLogin(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Methods
		public void login(String username, String password)
		{
			txtusername.sendKeys(username);
			txtpassword.sendKeys(password);
			btnlogin.click();
		}
		
		public String getError()
		{
			return lblerror.getText();
		}
		
		public void navigateToRegistartion()
		{
			lnkcreateacc.click();
		}

}
