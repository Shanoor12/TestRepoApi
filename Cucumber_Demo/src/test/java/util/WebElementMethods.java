package util;

import java.util.List;
import java.util.NoSuchElementException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementMethods 

{
public static void enterText(WebDriver driver, By locator, String text)
{
try {
WebElement we =driver.findElement(locator);
if(we.isEnabled())
{
we.sendKeys(text);
}
else
System.out.println("element is disabled");
}
catch (NoSuchElementException e) {
System.out.println("element not found");
}
}
public static void clickElement(WebDriver driver,By locator)
{
try {
WebElement we =driver.findElement(locator);
if(we.isEnabled())
{
we.click();
}
else
System.out.println("element is displayed");
}
catch (NoSuchElementException e) {
System.out.println("element not found");
}
}



public static void selectRadio(WebDriver driver,By locator, String choice)
{
List<WebElement> radios = driver.findElements(locator);
if(radios.size()>0)
{
for(WebElement rb : radios)
{

if(rb.getAttribute("value").equals(choice))
{
rb.click();
break;
}
}
}
else
System.out.println("element not found");

}



public static void selectcheckbox(WebDriver driver,By locator, String choice)
{
List<WebElement> checkbox = driver.findElements(By.cssSelector("td.table5>input"));
if(checkbox.size()>0)
{
for(WebElement rb : checkbox)
{

if(rb.getAttribute("value").equals(choice))
{
rb.click();
break;
}
}
}
}
}