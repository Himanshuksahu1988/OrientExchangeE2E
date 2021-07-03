package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver driver;
	By customerlogin=By.xpath("//ul[@class='dropdown-menu show']/li[2]/a");
	By emailid= By.xpath("//input[@id='frmRegisterEmail']");
	By passwrd= By.xpath("//input[@id='frmRegisterPassword']");
	By login= By.xpath("//button[@id='btn-login']");
	By error=By.xpath("//div[@class='alert alert-danger']//text()//parent::div");
	By forgotpwd=By.xpath("//div[@class='row mb-3 mt-3 formfooter']/div[2]/a");
	
public LoginPage(WebDriver driver) 
{
	this.driver=driver;
}	
	
public WebElement customerlogin()
{
	return driver.findElement(customerlogin);
}

public WebElement emailid()
{
	return driver.findElement(emailid);
}
public WebElement password()
{
	return driver.findElement(passwrd);
}
public WebElement login()
{
	return driver.findElement(login);
}

public WebElement error()
{
	return driver.findElement(error);
}

public Forgotpwd forgotpwd()
{
	 driver.findElement(forgotpwd).click();
	 Forgotpwd fp=new Forgotpwd(driver);
	 return fp;
}

}
