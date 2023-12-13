package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuableComponents.ReuseableComponentsClass;

public class CheckOutPageRahulShetty extends ReuseableComponentsClass{

	WebDriver d;
	public CheckOutPageRahulShetty(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
		// TODO Auto-generated constructor stub
	}
	
	
	 @FindBy(xpath ="//input[@placeholder='Select Country']")
	 WebElement countryHolderLocator;
	 
	 By countryByLocator = By.cssSelector(".ta-results");
	 
	 @FindBy(xpath ="(//button[@type='button'])[2]")
	 WebElement bangladeshLocator;
	 
	 public void clickOnCountryBangladesh(String countrySufix) {
		 Actions act = new Actions(d);
		 
		 // In "Select Country" put the value "ban" using "Actions" class
		 act.sendKeys(countryHolderLocator, countrySufix)
		 .build().perform();
		 elementToBeAppear(countryByLocator);
		 bangladeshLocator.click();
		 
	 }
	 
	 @FindBy(xpath ="//a[normalize-space()='Place Order']")
	 WebElement placeOrderButtonLocator;
	
	 
	 public ThankConfirmationPage clickPlaceOrderButtonToGoThankConfirmationPage() {
		 placeOrderButtonLocator.click();
		 return new ThankConfirmationPage(d);
	 }
	

}
