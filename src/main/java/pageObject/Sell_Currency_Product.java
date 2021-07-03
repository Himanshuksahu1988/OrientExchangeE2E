package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orientexchange.base;

public class Sell_Currency_Product extends base
{
	
	@FindBy(xpath="//a[text()='Add Product']")
	WebElement AddBtn;
	
	@FindBy(xpath="//select[@id='sel1']")
	WebElement Currency;
	
	@FindBy(xpath="//select[@id='buyproduct1']")
	WebElement Product;
	
	@FindBy(xpath="//input[@id='buyqty1']")
	WebElement Quantity;
	
	@FindBy(xpath="//a[@class='btn btn-warning removebuy']/i")
	WebElement CancelBtn;
	
	@FindBy(xpath="//input[@id='pickdoor1']")
	WebElement DoorPickup;
	
	@FindBy(id="pickbranch1")
	WebElement SelectBranch;
	
	@FindBy(css="input[id='daddress']")
	WebElement DoorPickupAddress;
	
	@FindBy(css="input[id='dpin']")
	WebElement DoorPickupPincode;
	
	@FindBy(xpath="//select[@name='address']")
	WebElement DoorPickupSlctBranch;
	
	@FindBy(xpath="//div[@id=\"door-box\"]/div[2]/div[2]/div/select")
	WebElement DoorPickupSlctState;
	
	@FindBy(xpath="//div[@class='row']/div[3]/div/select")
	WebElement DoorPickupSlctCountry;
	
	@FindBy(css="input[id='chkterms']")
	WebElement km_15_chkbox;
	
	@FindBy(css="input[id='buyforex']")
	WebElement SubmitBtn;
	
	@FindBy(css="select[id='loc']")
	WebElement Selectbrnchdrop;
	
	@FindBy(xpath="//select[@id='loc']")
	WebElement Choosebranch;
	
	public Sell_Currency_Product(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickAddbtn()
	{
		AddBtn.click();
		
	}
	
	public void CancelBtn()
	{
		CancelBtn.click();
	}
	
	public WebElement getCurrency()
	{
		return Currency;
	}
	
	public WebElement getProduct()
	{
		return Product;
	}
	
	public WebElement getQuantity()
	{
		return Quantity;
	}
	
	public WebElement selectDoorPickup()
	{
		return DoorPickup;
	}
	
	public WebElement getAddress()
	{
		return DoorPickupAddress;
	}
	public WebElement getPin()
	{
		return DoorPickupPincode;
	}
	public WebElement getBranch()
	{
		return DoorPickupSlctBranch;
	}
	public WebElement getState()
	{
		return DoorPickupSlctState;
	}
	
	public WebElement getCountry()
	{
		return DoorPickupSlctCountry;
	}
	
	public WebElement select_15_Checkbox()
	{
		return km_15_chkbox;
	}
	public WebElement ClickSubmit()
	{
		return SubmitBtn;
	}
	public WebElement SelectBrenchdrop()
	{
		return Selectbrnchdrop;
	}
	public WebElement ChooseBranch()
	{
		return Choosebranch; 
	}

}
