package SeleniumFramework01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndFuntionalRawCodeTesting {

	public static void main(String[] args) {
		
		
		
		String zaraCoatVariable = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver d = new ChromeDriver();
		
		
		// Go to the link
		d.get("https://www.rahulshettyacademy.com/client");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Put email address in the label
		d.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("anshika@gmail.com");
		
		//Put password in password field
		d.findElement(By.xpath("(//input[@id='userPassword'])[1]")).sendKeys("Iamking@000");
		
		//click on log in button
		d.findElement(By.id("login")).click();
		
		//Create an explicit wait 
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(4));
		
		// wait until the visibility of all element [ All products]
		wait.until(ExpectedConditions.visibilityOf(d.findElement(By.className("mb-3"))));
		
		// Store all the class name with "mb-3" in a list [each product has this css class]
		List<WebElement> products = d.findElements(By.className("mb-3"));
		
		/*-
		 * run a stream to filter all the product. Search a tag "b" only spcefily in This web
		 * element boundary , not in whole page. Get the text and match if the text is same 
		 * as "ZARA COAT 3". Then pick the first one. or if you can not find , return null.
		 */
		WebElement zaraCoat = products.stream().filter(product ->product.findElement(By.cssSelector("b"))
				.getText().equals(zaraCoatVariable)).findFirst().orElse(null);
		
		
		// Click on Zara coat product "ADD TO CART" Button
		zaraCoat.findElement(By.cssSelector(".card-body button:last-child")).click();
		
		
		//wait until the visibility of an text "Product Added to Cart"
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("toast-container"))));
		
		// Wait until the animation is disappeared 
		wait.until(ExpectedConditions.invisibilityOf(d.findElement(By.cssSelector(".ng-animating"))));
		
		//Click on "Cart" Button
		d.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		// Storing all the cart products 
		List<WebElement> cartProducts = d.findElements(By.cssSelector(".cartSection h3"));
		
		// running a stream, trying to find any match , get the text then match with "ZARA COAT 3" 
		// if finds, store boolean value as "true"
		 boolean matchProduct = cartProducts.stream().anyMatch(cartProduct -> 
		 						cartProduct.getText().equalsIgnoreCase(zaraCoatVariable) );
		 
		 Assert.assertTrue(matchProduct);
		 
		 // Click on "CheckOut" button
		 d.findElement(By.cssSelector(".totalRow button")).click();
		 
		 Actions act = new Actions(d);
		 
		 // In "Select Country" put the value "ban" using "Actions" class
		 act.sendKeys(d.findElement(By.xpath("//input[@placeholder='Select Country']")), "ban")
		 .build().perform();
		 
		 // wait until all the country related with the sufix of "ban" appears
		 wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".ta-results"))));
		 
		 
		 // Select bangladesh from the search results
		 d.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		 
		 // Click on "Place Order" button
		 d.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		 
		 // Store the "THANKYOU FOR THE ORDER." message in a String variable
		  String orderConfirmationMessage = d.findElement(By.className("hero-primary")).getText();
		  
		  // Check if the result is true I mean same message and also ignore the cases.
		 Assert.assertTrue(orderConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		 // Quit the browser
		 d.quit();
		
		
		

	}

}
