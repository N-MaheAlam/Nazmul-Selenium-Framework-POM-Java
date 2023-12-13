package resuableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectModel.SelectedProductCartPageRahulShetty;

public class ReuseableComponentsClass {
	
	WebDriver d;
	
	
	public ReuseableComponentsClass(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement clickToCartLocator;
	public SelectedProductCartPageRahulShetty goToSelectedProductCartPage() {
		clickToCartLocator.click();
		SelectedProductCartPageRahulShetty  selectProductPage= new SelectedProductCartPageRahulShetty(d);
		return selectProductPage;
	}
	public void elementToBeAppear(By listProductsCss) {
		//Create an explicit wait 
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(4));
		
		// wait until the visibility of all element [ All products]
		wait.until(ExpectedConditions.visibilityOf(d.findElement(listProductsCss)));
	}
	
	public void elementToBeDisapprear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
			

}
