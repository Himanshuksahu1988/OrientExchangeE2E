package orientexchange;

import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Sell_Currency;

public class TC_Sell_Currency extends base {

	WebDriver driver;
	HomePage hp;
	Properties pros;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initiate() throws IOException {
		driver = initializedriver();
	
	}

	@Test(dataProvider = "getData")
	public void sell_currency(String user_name, String user_pwd) throws InterruptedException, IOException 
	{
		//driver = initializedriver();
		hp = new HomePage(driver);
		Assert.assertEquals(hp.getSelectcity().getText(), "Ahmedabad");
		hp.getSelectcity().click();
		log.info("Sucessfully selected the city");

		LoginPage lp = hp.getLogin();
		lp.customerlogin().click();
		Assert.assertEquals(driver.getTitle(), "Login - Orient Exchange");
		log.info("Landed in login page");

		utility.sendkeys(driver, lp.emailid(), 5, user_name);
		// lp.emailid().sendKeys(user_name);
		utility.sendkeys(driver, lp.password(), 5, user_pwd);
		 //lp.password().sendKeys(user_pwd);
		utility.clicks(driver, lp.login(), 5);
		 //lp.login().click();

		Sell_Currency scs = hp.getSellcurrency();



		utility.javascriptex(driver);
		
//		Select curncy_sclect = new Select(scs.getSell_crncy());
//		curncy_sclect.selectByVisibleText("Euro");
		
		// Select Currency
		utility.select(scs.getSell_crncy(), pros.getProperty("currencyname"));
		log.info("Currency Selected ");
		

		// Select Product
//		Select prod_sclect = new Select(scs.getSlct_prod());
//		prod_sclect.selectByVisibleText("Cash");
		
		
		
		utility.select(scs.getSlct_prod(), "Cash");
		log.info("Product Selected");

		// Enter the Quantity
		scs.getEnter_qnty().sendKeys("1000");

		// Click book now
		scs.getBook_now();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		Object[][] data = new Object[1][2];
		
		pros=properties();
		String username=pros.getProperty("username");
		
		data[0][0] = username;
		data[0][1] = "orient@123";
		
	

		return data;

	}

}
