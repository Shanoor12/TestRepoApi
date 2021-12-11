package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.co.in/");

		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title of the page :" +title);
		
		System.out.println("Url :" +driver.getCurrentUrl());
		
		driver.close();

	}

}
