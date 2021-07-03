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
import pageObject.LoginPage;

public class TC_HomePage extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriver driver;
	HomePage hp;

	@BeforeMethod
	public void initdriver() throws IOException {
		driver = initializedriver();

	}

	@Test(priority = 1)
	public void getTitleverify() {
		System.out.println(driver.getTitle());
	}

	@Test(priority = 2)
	public void home_page() throws IOException, InterruptedException {
		hp = new HomePage(driver);
		hp.getSelectcity().click();
		hp.getMenu().click();
		hp.getlogo().click();
		log.info("Succefully clicked on the Logo");

		WebElement chrt = hp.getHomepageratechrt();
		log.info(chrt.getText());

		// Login Page
		hp.getLogin();

	}

	@Test(priority = 3)
	public void Directpay() {
		hp = new HomePage(driver);
		hp.getSelectcity().click();
		// Direct Pay ,Offers and TellNo
		hp.getDirectpay().click();
		log.info("Sucessfully clicked on directPay");
	}

	// Mouse over on Our Services
	@Test(priority = 4)
	public void OurServices() {
		hp = new HomePage(driver);
		hp.getSelectcity().click();
		hp.getlogo().click();
		utility.Actioncls(driver).moveToElement(hp.getMorefrcurrency()).contextClick().build().perform();
		utility.Actioncls(driver).moveToElement(hp.getMoElemnt()).click().build().perform();
	}

	@Test(priority = 5)
	public void ValidateOffers() {
		hp = new HomePage(driver);
		hp.getSelectcity().click();
		hp.getOffers().click();
		log.info("Succefully clicked on the Offers Page");

	}

	@Test(priority = 6)
	public void validateTellno() {
		hp = new HomePage(driver);
		hp.getSelectcity().click();
		hp.getTeleno().click();
		Assert.assertEquals(hp.getTeleno().getText(), "8884445321");
		log.info(hp.getTeleno().getText());
	}

	@AfterMethod
	public void teardown() {
		
			driver.quit();
			
		
	}

	

}
