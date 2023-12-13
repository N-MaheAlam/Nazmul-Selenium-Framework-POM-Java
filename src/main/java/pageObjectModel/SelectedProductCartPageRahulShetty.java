package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuableComponents.ReuseableComponentsClass;

public class SelectedProductCartPageRahulShetty extends ReuseableComponentsClass{

	
	
	WebDriver d;
	
	public SelectedProductCartPageRahulShetty(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
		
	}// constructor
	

	@FindBy(css=".cartSection h3")
	 List<WebElement> ListOfAllSelectedProductLocator;
	
	public boolean matchProductInCartPage(String zaraCoatVariable ) {
		boolean matchProduct = ListOfAllSelectedProductLocator.stream().anyMatch(cartProduct -> 
			cartProduct.getText().equalsIgnoreCase(zaraCoatVariable) );
		return matchProduct;
	}
	
	
	@FindBy(css=".totalRow button")
	WebElement clickOnCheckOutLocator;
	
	public CheckOutPageRahulShetty clickOnCheckOutButton() {
		clickOnCheckOutLocator.click();
		CheckOutPageRahulShetty checkOutPage = new CheckOutPageRahulShetty(d);
		return checkOutPage;
	}
	
}
