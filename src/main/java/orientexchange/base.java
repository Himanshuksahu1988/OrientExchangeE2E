package orientexchange;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class base 
{
	protected WebDriver driver;
	protected Properties pros;
	String pathdata=System.getProperty("user.dir");

	
	@BeforeClass
	public Properties properties() throws IOException
	{
		pros=new Properties();
		
		FileInputStream fis=new FileInputStream(pathdata+"\\src\\main\\java\\resources\\datasheet.properties");
		pros.load(fis);
		
		return pros;
	}
	
	
	
	public WebDriver initializedriver() throws IOException
	{
		//String browsername=pros.getProperty("browser");
		String browsername=System.getProperty("browse");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", pathdata+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", pathdata +"\\src\\main\\java\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", pathdata +"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		String urlpath = pros.getProperty("url");
		driver.get(urlpath);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
		

	

}
