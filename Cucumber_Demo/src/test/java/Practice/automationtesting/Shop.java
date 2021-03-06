package Practice.automationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shop {
	
	//Variable declaration
			//Shop
	
			@CacheLookup @FindBy(xpath  ="//*[@id=\"content\"]/ul/li[1]/a[1]/img")
			WebElement clkitem; 
			@CacheLookup @FindBy(css  = "button[type='submit']")
			WebElement addtobsk;
			@CacheLookup @FindBy(xpath  ="//*[@id=\"content\"]/div[1]/a")
			WebElement viewdtl;
			
			//Constructor
			public Shop(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//Methods
			public void HomePage()
			
			{
				//Shop
				
				clkitem.click();
				addtobsk.click();
				
//				WebDriver driver = null;
//				WebDriverWait wait = new WebDriverWait(driver, 20);
//				addtobsk= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View Basket']")));
				
				viewdtl.click();
			}
				
//			
			public void navigateCartPage()
				{
					viewdtl.click();
				}
			
			
			
			
			
			

}
