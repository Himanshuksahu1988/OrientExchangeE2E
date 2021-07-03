package orientexchange;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop.Action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.HomePage;
import pageObject.LoginPage;

public class TC_LoginPage2_Excel_Data extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriver driver;
	XSSFSheet sheet1;

	@BeforeMethod
	public void initdriver() throws IOException {
		driver = initializedriver();

	}

	@Test(dataProvider = "Getdata")
	public void basepagenavigation(String username, String password) throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();
		HomePage hp = new HomePage(driver);
		hp.getSelectcity().click();
		Assert.assertEquals(driver.getTitle(), "Currency Exchange in Ahmedabad | Foreign Currency - Orientexchange");
		LoginPage lp = hp.getLogin();
		lp.customerlogin().click();
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
		lp.login().click();

		if (driver.getTitle().equals("Orientexchange - Buy & Sell Forex Online | Foreign Currency Exchange")) {
			log.info("Sucessfully login");
		} else {
			log.error(lp.error().getText());
			sa.assertEquals(lp.error().getText(), "  Email Id or Password does not exist. !");

			sa.assertAll();
		}

	}

	@AfterMethod
	public void closedriver() {

		driver.quit();

	}

	@DataProvider
	public Object[][] Getdata() throws IOException, InvalidFormatException {

		String[][] data = utility.getExcelData(0);
		return data;
	}

}
