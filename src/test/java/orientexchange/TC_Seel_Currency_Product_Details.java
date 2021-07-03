package orientexchange;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Sell_Currency;
import pageObject.Sell_Currency_Product;



public class TC_Seel_Currency_Product_Details extends base 
{
	
WebDriver driver;	
HomePage hp;	
LoginPage lp;
Sell_Currency scs;
Sell_Currency_Product scp;

		
@BeforeMethod
public void init() throws IOException
{
	driver=initializedriver();
	hp=new HomePage(driver);
	hp.getSelectcity().click();
	lp=hp.getLogin();
	lp.customerlogin().click();
	
}


//@Test
//public void validateTitle()
//{
//	String title=driver.getTitle();
//	Assert.assertEquals(title, "CashBack on Forex Travel Card - Best Foreign Exchange - "
//		+ "Money Changers & Forex Online | Orient Exchange");
//	
//}



@Test(dataProvider="getDataDoorpickup", priority=1)
public void validateDoorPickup(String username, String password,String Address,String pin, String branch,String state,String country)
{
	lp.emailid().sendKeys(username);
	lp.password().sendKeys(password);
	lp.login().click();
	scs = hp.getSellcurrency();
	utility.javascriptex(driver);
	utility.select(scs.getSell_crncy(), pros.getProperty("currencyname"));
	utility.select(scs.getSlct_prod(), pros.getProperty("producttype"));
	scs.getEnter_qnty().sendKeys(pros.getProperty("Quantity"));
	scp=scs.getBook_now();
	scp.ClickAddbtn();
	utility.sendkeys(driver, scp.getCurrency() ,10, pros.getProperty("currencyname"));
	utility.sendkeys(driver, scp.getProduct(), 10, pros.getProperty("producttype"));
	utility.sendkeys(driver, scp.getQuantity(), 10, pros.getProperty("Quantity"));
	scp.selectDoorPickup().click();
	
	scp.getAddress().sendKeys(Address);
	scp.getPin().sendKeys(pin);
	
	utility.select(scp.getBranch(), branch);
	utility.select(scp.getState(), state);
	utility.select(scp.getCountry(), country);
	
	scp.select_15_Checkbox().click();
	//scp.ClickSubmit().click();

}

@Test(dataProvider="getDataSelectBranch", priority=2)
public void validatePickupBranch(String username, String password, String branch)
{
	lp.emailid().sendKeys(username);
	lp.password().sendKeys(password);
	lp.login().click();
	scs = hp.getSellcurrency();
	utility.javascriptex(driver);
	utility.select(scs.getSell_crncy(), pros.getProperty("currencyname"));
	utility.select(scs.getSlct_prod(), pros.getProperty("producttype"));
	scs.getEnter_qnty().sendKeys(pros.getProperty("Quantity"));
	scp=scs.getBook_now();
	scp.SelectBrenchdrop().click();
	utility.select(scp.ChooseBranch(), branch);
	scp.select_15_Checkbox().click();
	
}



@DataProvider
public String[][] getDataDoorpickup() throws InvalidFormatException, IOException
{
	String[][] exceldata=utility.getExcelData(2);
	
	return exceldata;
}

@DataProvider
public String[][] getDataSelectBranch() throws InvalidFormatException, IOException
{
	String[][] exceldata=utility.getExcelData(3);
	
	return exceldata;
}



@AfterMethod
public void teardown()
{
	driver.quit();
}
	

}
