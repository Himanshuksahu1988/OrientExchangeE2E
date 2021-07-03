package pageObject;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Buy_Currency_Card 
{
	
	WebDriver driver;
	By slctsellcrncy=By.cssSelector("select[id='sellcurrency']");
	By slctprod=By.cssSelector("select[id='sellproduct']");
	By frxqnty=By.cssSelector("input[id='sellqty']");
	By booknow=By.xpath("//div[@id='default-process']/form/div/div[5]/button");
	
public Buy_Currency_Card(WebDriver driver) 
{
	this.driver=driver;
	
}	
public WebElement getSelectcurrency()
{
	return driver.findElement(slctsellcrncy); 
}	
public WebElement getSelectprod()
{
	return driver.findElement(slctprod);			
}
public WebElement getForexqnty()
{
	return driver.findElement(frxqnty);
}
public WebElement getBooknow()
{
	return driver.findElement(booknow);
}
	
}
