package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sell_Currency 
{
	WebDriver driver;	
	
	By  sell_crncy=By.xpath("//select[@id='sel']");
	By  visibility=By.xpath("//select[@id='sel']/option[1]");
	By  slct_prod=By.xpath("//select[@id='buyproduct']");
	By  entr_qtny=By.xpath("//input[@id='buyqty']");
	By  book_now=By.xpath("//div[@id='tabDefaultContent']/div[1]/form/div/div[5]/button");
	
		
	
public Sell_Currency(WebDriver driver) 
{
	this.driver=driver;	
}

public WebElement getSell_crncy()
{
	return driver.findElement(sell_crncy);
}

public WebElement getSlct_prod()
{
	return driver.findElement(slct_prod);
	
}
public WebElement getEnter_qnty()
{
	return driver.findElement(entr_qtny);
}
public Sell_Currency_Product getBook_now()
{
	driver.findElement(book_now).click();
	
	return new Sell_Currency_Product(driver);
}

public By getvisibility()
{
	return visibility;
}






}
