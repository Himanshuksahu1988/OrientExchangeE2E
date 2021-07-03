package orientexchange;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class utility {
	public XSSFWorkbook workbook;
	public XSSFSheet sheet1;
	public static String system_path=System.getProperty("user.dir");;

	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;

	//Screen Shot
	public static String getScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = system_path+"\\src\\main\\java\\Screenshots"
				+ System.currentTimeMillis() + ".png";
		File Destination = new File(path);
		
		try {
			FileUtils.copyFile(source, Destination);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return path;

	}

	//Extent Report
	public static ExtentReports getEReport() {
		File path = new File("./reports/index.html");
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("HImanshu Kumar Sahu");
		reporter.config().setDocumentTitle("Automation Script");

		extent = new ExtentReports();

		extent.attachReporter(reporter);
		

		return extent;

	}

	// Send Keys
	public static void sendkeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);

	}

	// Clicks
	public static void clicks(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	// Select
	public static void select(WebElement element, String value) {
		Select slct = new Select(element);
		slct.selectByVisibleText(value);
	}

	// Actions
	public static Actions Actioncls(WebDriver driver) {
		Actions actn = new Actions(driver);
		return actn;
	}

	// Xls Driven
	public static String[][] getExcelData(int sheet_no) throws IOException, InvalidFormatException {
		File filepath = new File("D:\\MyFolder\\Java\\JavaProject\\OrientExchange_E2E\\src\\main\\java\\resources\\datash.xlsx");

		FileInputStream fis = new FileInputStream(filepath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(sheet_no);

		int row_count = sheet.getLastRowNum();
		System.out.println("row_count " + row_count);

		int cell_count = sheet.getRow(0).getLastCellNum();
		System.out.println("cell_count " + cell_count);
		row_count = row_count + 1;

		String[][] exceldata = new String[row_count][cell_count];
		for (int i = 0; i < row_count; i++) {
			for (int j = 0; j < cell_count; j++) {
				exceldata[i][j] = sheet.getRow(i).getCell(j).toString();
			}

		}
		return exceldata;

	}
	
	public static void javascriptex(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,300)");
	}

}
