package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuableComponents.ReuseableComponentsClass;

public class AllProductPageRahulShetty extends ReuseableComponentsClass{

	
	WebDriver d;
	
	public AllProductPageRahulShetty( WebDriver d) {
	
		super(d);
		this.d= d;
		PageFactory.initElements(d, this);
				
	}
	
	@FindBy(className="mb-3")
	List<WebElement> products;
	
	By addProductLocator = By.cssSelector(".card-body button:last-child");
	
	By productsListBy = By.className("mb-3");
	By productAddtoCartMessageLocator = By.id("toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement animationLocator;
	
	public List<WebElement> returnProductList() {
		elementToBeAppear(productsListBy);
		return products;
	}
	
	public WebElement isProductPresent(String zaraCoatVariable) {
		WebElement zaraCoat = products.stream().filter(product ->product.findElement(By.cssSelector("b"))
				.getText().equals(zaraCoatVariable)).findFirst().orElse(null);
		return zaraCoat;
	}
	
	public void addProductToCart(String productName) {
		WebElement zaraCoat = isProductPresent(productName);
				zaraCoat.findElement(addProductLocator).click();
				elementToBeAppear(productAddtoCartMessageLocator);
				elementToBeDisapprear(animationLocator);
	}
	
}// Class ends
