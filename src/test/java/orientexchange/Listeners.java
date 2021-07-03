package orientexchange;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listeners extends base implements ITestListener {
	ExtentReports extent = utility.getEReport();
	WebDriver driver = null;
	String datapath;	
	
	@Override
	public void onTestStart(ITestResult result) {
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest logger = extent.createTest(result.getName());
		datapath = utility.getScreenshot(driver);
		
		
		try {
			logger.log(Status.PASS, "Test Cases is Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(datapath).build());
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		datapath = utility.getScreenshot(driver);

		try {
			ExtentTest logger = extent.createTest(result.getName());
			logger.log(Status.FAIL, "Error Occoured : " + result.getThrowable());

			// String datapath=utility.getScreenshot(driver);
			logger.log(Status.FAIL, "Test case is Faild",
					MediaEntityBuilder.createScreenCaptureFromPath(datapath).build());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
