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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.Buy_Currency_Card;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC_Buy_Currency_Card extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriver driver;

	@BeforeMethod
	public void initdriver() throws IOException {
		driver = initializedriver();

	}

	@Test(dataProvider = "getData")
	public void buy_curremcy(String username, String password) throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		log.info("Successfully Initialize the Browser");
		HomePage hp = new HomePage(driver);
		hp.getSelectcity().click();
		Assert.assertEquals(driver.getTitle(), "Currency Exchange in Ahmedabad | Foreign Currency - Orientexchange");
		LoginPage lp = hp.getLogin();
		lp.customerlogin().click();
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
		lp.login().click();

		Buy_Currency_Card bcc = hp.getBuycurrencyCard();
		Select slct = new Select(bcc.getSelectcurrency());
		slct.selectByVisibleText("Euro");

	}

	@AfterMethod
	public void closedriver() {
		driver.quit();
	}

	@DataProvider
	public String[][] getData() {
		String[][] data = new String[1][2];
		data[0][0] = "it@orientexchange.in";
		data[0][1] = "orient@123";
		return data;
	}

}
