package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser 

{
	public static WebDriver openBrowser(String url) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;



		}



		public static void verifyTitle(WebDriver driver, String string) {
		// TODO Auto-generated method stub

		}



		}