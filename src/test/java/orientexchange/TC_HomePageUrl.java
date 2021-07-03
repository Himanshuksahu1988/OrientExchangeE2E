package orientexchange;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.HomePage;
import pageObject.HomePageUrl;

public class TC_HomePageUrl extends base {

	WebDriver driver;
	HomePage hp;

	@BeforeMethod
	public void init() throws IOException {
		driver = initializedriver();
	}

	@Test
	public void ValidateHomePageURL() {
		SoftAssert sa = new SoftAssert();
		hp = new HomePage(driver);
		hp.getSelectcity();
		HomePageUrl hpurl = hp.getHomepageUrl();
		List<WebElement> Element = hpurl.HPUrl();

		for (WebElement Elmnt : Element) {
			String url = Elmnt.getAttribute("href");

			try {
				HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();

				huc.connect();

				int responsecode = huc.getResponseCode();

				if (responsecode <= 400) {
					// System.out.println(url+ " Is fine & Status is: " +huc.getResponseMessage());

				} else {
					System.out.println(url + " Is broken & Status is : " + huc.getResponseMessage());
					sa.assertEquals(huc.getResponseMessage(), "OK", url + "Url is Broken");
				}
				sa.assertAll();

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
