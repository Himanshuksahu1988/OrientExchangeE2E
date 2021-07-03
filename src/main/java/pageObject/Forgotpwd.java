package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpwd 
{
	WebDriver driver;
	By forgotpwdtext=By.xpath("//form[@id='forgotpass']/div/div/input");
	By sndbtn=By.cssSelector("button[id='btn-go']");
	By resetpwdgttxt=By.cssSelector("div[id='errorDiv']");
	By resetpwderr=By.cssSelector("span[id='error']");
	By withoutemail=By.cssSelector("span[id='error']");

public Forgotpwd(WebDriver driver) 
{
	this.driver=driver;
	
}

public WebElement forgotpwdtext()
{
	return driver.findElement(forgotpwdtext);
}

public WebElement getSndbtn()
{
	return driver.findElement(sndbtn);
}

public WebElement getForgotpwdtext()
{
	return driver.findElement(resetpwdgttxt);
}

public WebElement getResetpwderr()
{
	return driver.findElement(resetpwderr);
}

public WebElement getWithoutemail()
{
	return driver.findElement(withoutemail);
}

}


