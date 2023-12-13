package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuableComponents.ReuseableComponentsClass;

public class LandingPageRahulShetty extends ReuseableComponentsClass{
	
	
	WebDriver d;
	
	public LandingPageRahulShetty(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
		
	}// constructor ends
	
	
	
	@FindBy(xpath= "//input[@id='userEmail']")
	WebElement userEmailId;;
	
	@FindBy(xpath ="(//input[@id='userPassword'])[1]")
	WebElement userPassword;
	
	
	@FindBy(id="login")
	WebElement logInButton;
	
	public AllProductPageRahulShetty logInRahulShetty(String email, String password) {
		userEmailId.sendKeys(email);
		userPassword.sendKeys(password);
		logInButton.click();
		AllProductPageRahulShetty allProductPage =  new AllProductPageRahulShetty(d);
		return allProductPage;
	}
	
	public void goToLandingPage() {
		d.get("https://www.rahulshettyacademy.com/client");
	}

}// class ends 
