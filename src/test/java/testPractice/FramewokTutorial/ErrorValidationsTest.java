package testPractice.FramewokTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

import testPractice.TestComponents.BaseTest;
import testPractice.pageobjects.CartPage;
import testPractice.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	
	String productName="ZARA COAT 3";
	String cartProduct="ZARA COAT 33";
	
	@Test(groups={"ErrorHandling"})
	public void LoginErrorValidation() throws InterruptedException
	{
		String username = "AvosD@gmail.com";
		String password = "Avos@123";
		
		landingpage.loginApplication(username, password);
		landingpage.getLandingpageErrorMessage();
		System.out.println("Error Message: "+landingpage.getLandingpageErrorMessage());
		Assert.assertEquals(landingpage.getLandingpageErrorMessage(), "Incorrect email or password.");
		Thread.sleep(2000);
		
	}
	@Test
	public void ProductErrorValidation() throws InterruptedException
	{
		String username = "AvosD@gmail.com";
		String password = "Avos@1234";
		
		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);
		productcatalogue.getProductList();
		productcatalogue.getProductName(productName);
		CartPage cartpage = productcatalogue.addProductToCart(productName);

		productcatalogue.gotoCartPage();
		Thread.sleep(2000);
		boolean itemMatch = cartpage.verifyDisplayedProducts(cartProduct);
		Assert.assertFalse(itemMatch);
	}
	
	
	

}
