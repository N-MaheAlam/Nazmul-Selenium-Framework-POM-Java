package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuableComponents.ReuseableComponentsClass;

public class ThankConfirmationPage extends ReuseableComponentsClass  {

	WebDriver d ;
	public ThankConfirmationPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(className = "hero-primary")
	WebElement thankYouMessageLocator;
	
	public String getThankYouMessage() {
		return thankYouMessageLocator.getText();
	}

}
