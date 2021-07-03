package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orientexchange.base;

public class HomePageUrl extends base
{
	
	@FindBy(xpath="//div[@class='container']/div/div/ul/li/a")
	List<WebElement> homepageurl; 
	
	
public HomePageUrl(WebDriver driver) {
	PageFactory.initElements(driver, this);
}	
	


public List<WebElement> HPUrl()
{
	
	return homepageurl;
	
	
//	for(WebElement HpUrl : homepageurl)
//	{
//		String url=HpUrl.getAttribute("href");
//		
//	}
	
	
}
	

}
