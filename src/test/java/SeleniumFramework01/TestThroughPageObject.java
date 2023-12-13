package SeleniumFramework01;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestUsableProperties.DriverBaseClass;
import pageObjectModel.AllProductPageRahulShetty;
import pageObjectModel.CheckOutPageRahulShetty;
import pageObjectModel.LandingPageRahulShetty;
import pageObjectModel.SelectedProductCartPageRahulShetty;
import pageObjectModel.ThankConfirmationPage;

public class TestThroughPageObject extends DriverBaseClass{
	
	
	@Test
	public void endToendSibmitOrdertTest() throws IOException {
		
		String zaraCoatVariable = "ZARA COAT 3";
			
		LandingPageRahulShetty landingPage = lunchApplication();
		
		
		AllProductPageRahulShetty productPage = 
				landingPage.logInRahulShetty("anshika@gmail.com", "Iamking@000");
		
		
		
		
		productPage.addProductToCart(zaraCoatVariable);
		
		productPage.goToSelectedProductCartPage();
		
		SelectedProductCartPageRahulShetty selectProductPage = new SelectedProductCartPageRahulShetty(d);
		
		 boolean matchProduct = selectProductPage.matchProductInCartPage(zaraCoatVariable);
		 Assert.assertTrue(matchProduct);
		 
		 CheckOutPageRahulShetty checkOutPage= selectProductPage.clickOnCheckOutButton();
		 checkOutPage.clickOnCountryBangladesh("ban");
		 ThankConfirmationPage thankYouPage = checkOutPage.clickPlaceOrderButtonToGoThankConfirmationPage();
		 String orderConfirmationMessage = thankYouPage.getThankYouMessage();
		 Assert.assertTrue(orderConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 d.quit();
		 
		
		
		
	}

}
