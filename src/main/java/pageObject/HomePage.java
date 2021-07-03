package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	WebDriver driver;
	private By selectcity=By.xpath("//a[@title='Ahmedabad']");
	private By menu=By.xpath("//div[@class='row']/div/a/i");
	private By logo=By.cssSelector("a[class='px-4']");
	private By offers=By.xpath("//div[@class='sticky-body']/div/div/div[2]/div/a[1]");
	private By teleno=By.xpath("//div[@class='sticky-body']/div/div/div[2]/div/a[2]");
	private By directpay=By.xpath("//img[@src='img/home.png']");
	private By login=By.cssSelector("button[class='btn btn-rounded btn-quaternary mb-2 dropdown-toggle']");
	private By homepageratechrt=By.xpath("//table[@class='table table-bordered']/tbody/tr[1]");
	private By viewmore=By.linkText("moneychangelist");
	private By buycurrency_card=By.xpath("//ul[@class='nav nav-tabs nav-tabs-default hideinmob']/li[1]/a[1]");
	private By sellcurrency=By.xpath("//ul[@class='nav nav-tabs nav-tabs-default hideinmob']/li[2]/a[1]");
	private By sendmoneyabroad=By.xpath("//ul[@class='nav nav-tabs nav-tabs-default hideinmob']/li[4]/a[1]");
	private By reloadforexcard=By.xpath("//ul[@class='nav nav-tabs nav-tabs-default hideinmob']/li[5]/a[1]");
	private By fcdd=By.xpath("//ul[@class='nav nav-tabs nav-tabs-default hideinmob']/li[6]/a");
	private By insurance=By.xpath("//ul[@class='nav nav-tabs nav-tabs-default hideinmob']/li[7]/a[1]");
	private By tr=By.xpath("//*[@id='tabDefault']/li[8]");
	private By moforeigncrny= By.xpath("//h5[text()='Foreign Currency']");
	private By moforeigncrncyreadmore=By.linkText("Read more");
	private By moforexcrd=By.xpath("//h5[text()='Forex Card']");
	private By moor=By.xpath("//h5[text()='Outward Remittance']");
	private By moot=By.xpath("//h5[text()='Overseas Travel Insurance']");
	
	private By majorctywesrv=By.xpath("//*[@id=\"footer\"]/div[1]/div/div[2]/ul/li/a");
	private By areawesrv=By.xpath("//table[@cellspacing='9']/tbody/tr/td/u/a");
	private By gothroughvariusoffer=By.xpath("//div[@class='col-lg-10']/li/a");
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public WebElement getSelectcity()
	{
		return driver.findElement(selectcity);
	}
	
	public WebElement getMenu()
	{
		return driver.findElement(menu);
	}
	
	public WebElement getlogo()
	{
		return driver.findElement(logo);
	}
	public WebElement getOffers()
	{
		return driver.findElement(offers);
	}
	public WebElement getTeleno()
	{
		return driver.findElement(teleno);
	}
	public WebElement getDirectpay()
	{
		return driver.findElement(directpay);
	}
	public LoginPage getLogin()
	{
		driver.findElement(login).click();
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	public WebElement getHomepageratechrt()
	{
		return driver.findElement(homepageratechrt);
	}
	public WebElement getViewmore()
	{
		return driver.findElement(viewmore);
	}
	public Buy_Currency_Card getBuycurrencyCard()
	{
		driver.findElement(buycurrency_card).click();
		Buy_Currency_Card bc=new Buy_Currency_Card(driver);
		
		return bc;
		
	}
	public Sell_Currency getSellcurrency()
	{
		driver.findElement(sellcurrency).click();
		Sell_Currency sc=new Sell_Currency(driver);
		return sc;
	}
	public void getSendmoneyabrd()
	{
		driver.findElement(sendmoneyabroad).click();
		Boolean flag=driver.findElement(sendmoneyabroad).isEnabled();
	}
	public void getreloadforexcrd()
	{
		driver.findElement(reloadforexcard).click();
	}
	public void getFcdd()
	{
		driver.findElement(fcdd).click();;
	}
	public void getinsurance()
	{
		driver.findElement(insurance).click();
	}
	public void getTraderemitance()
	{
		driver.findElement(tr).click();
	}
	public WebElement getMorefrcurrency()
	{
		return driver.findElement(moforeigncrny);
	}
	public WebElement getMoreforexcard()
	{
		return driver.findElement(moforexcrd);
	}
	public WebElement getMoor()
	{
		return driver.findElement(moor);
	}
	public WebElement getMoot()
	{
		return driver.findElement(moot);
	}
	public WebElement getMoElemnt()
	{
		return driver.findElement(moforeigncrncyreadmore);
		
	}
	
	public List<WebElement> getMejorcityweserv()
	{
		return driver.findElements(majorctywesrv);
	}
	
	public List<WebElement> getAreawesrv()
	{
		return driver.findElements(areawesrv);
	}
	public List<WebElement> getGothroughvariusoffer()
	{
		return driver.findElements(gothroughvariusoffer);
	}
	
	public HomePageUrl getHomepageUrl()
	{
		return new HomePageUrl(driver);
	}
	
}
