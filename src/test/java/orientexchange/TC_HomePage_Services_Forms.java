package orientexchange;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop.Action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class TC_HomePage_Services_Forms extends base 
{	
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	WebDriver driver;
	HomePage hp;
	@BeforeMethod
	public void initdriver() throws IOException
	{
		driver=initializedriver();
		
	}
	
	@Test
	public void validateFCDD() throws IOException, InterruptedException
	{
		
		//HomePage Object
		hp=new HomePage(driver);
		hp.getSelectcity().click();
		hp.getFcdd();
		
		log.info("Sucessfully clicked on the FCDD");
			
	}
	@Test
	public void validateBuycurrencyCard()
	{
		hp=new HomePage(driver);
		hp.getSelectcity().click();
		hp.getBuycurrencyCard();
		log.info("Sucessfully clicked on the BuyCurrency Card");
		
	}
	
	@Test
	public void validateloadforexcrd()
	{
		hp=new HomePage(driver);
		hp.getSelectcity().click();
		hp.getSellcurrency();
		log.info("Clicked Sucessfully clicked in forex card");
		
	}
	
	@Test
	public void validateSellcurrency()
	{
		hp=new HomePage(driver);
		hp.getSelectcity().click();
		hp.getSellcurrency();
		log.info("Clicked Sucessfully on Sell CUrrency");
		
	}
	
	@Test
	public void validateInsurance()
	{
		hp=new HomePage(driver);
		hp.getSelectcity().click();
		hp.getinsurance();
		log.info("Sucessfully clicked on Insurance Page");
	}
	
	@Test
	public void validateSendmoneyAbroad()
	{
		hp=new HomePage(driver);
		hp.getSelectcity().click();
		log.info("Sucessfully clicked on SendMoenyAbroad ");
		
	}
	
	
	@AfterMethod
	public void closedriver()
	{
		driver.quit();
	}
	
	
}
