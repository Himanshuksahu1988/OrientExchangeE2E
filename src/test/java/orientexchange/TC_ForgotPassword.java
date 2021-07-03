package orientexchange;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop.Action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

import pageObject.Forgotpwd;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC_ForgotPassword extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriver driver;

	@BeforeMethod
	public void initdriver() throws IOException {
		driver = initializedriver();

	}

	@Test(dataProvider = "Getdata")
	public void forgot_password(String emailid) throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		// driver=initializedriver();
		log.info("Successfully Initialize the Browser");
		String urlpath = pros.getProperty("url");
		driver.get(urlpath);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// HomePage Object Created and Select City
		HomePage hp = new HomePage(driver);
		hp.getSelectcity().click();
		Assert.assertEquals(driver.getTitle(), "Currency Exchange in Ahmedabad | Foreign Currency - Orientexchange");

		// Login Page link click on Home Page
		LoginPage lp = hp.getLogin();
		lp.customerlogin().click();

		// Forgot Password link click on Login Page
		Forgotpwd fp = lp.forgotpwd();
		Assert.assertEquals(driver.getTitle(),
				"Forgot Password - Orient Exchange and Financial Services Private Limited.");
		log.info("Forgot Password Page Displyed with Title:--" + driver.getTitle());

		// Enter the Email id
		fp.forgotpwdtext().sendKeys(emailid);

		// Click on the send button
		fp.getSndbtn().click();

		Thread.sleep(5000);
		// Verify The Pass & Failure Message with log

		System.out.println(fp.getForgotpwdtext().getText());

		if (fp.getForgotpwdtext().getText().equals("Please check your email for link")) {
			log.info("Password reset Mail sucessfully send to user");
		} else if (fp.getResetpwderr().getText().equals("Please enter valid email address")) {
			log.error(fp.getResetpwderr().getText());
		} else if (fp.getWithoutemail().getText().equals("Email is required")) {
			log.error(fp.getWithoutemail().getText());
		}

	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}

	@AfterTest
	public void closedriver() {

	}

	@DataProvider
	public String[][] Getdata() throws IOException, InvalidFormatException {

		String[][] exceldata = utility.getExcelData(1);

		return exceldata;
	}

}
