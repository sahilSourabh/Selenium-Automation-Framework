package testPractice.FramewokTutorial;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testPractice.TestComponents.BaseTest;
import testPractice.pageobjects.CartPage;
import testPractice.pageobjects.CheckOutPage;
import testPractice.pageobjects.ConfirmationPage;
import testPractice.pageobjects.OrdersPage;
import testPractice.pageobjects.ProductCatalogue;

public class StandaloneTest2 extends BaseTest {
	
	String username = "AvosD@gmail.com";
	String password = "Avos@1234";
	String productName="ZARA COAT 3";
	String countryValue="Ind";
	String countryName="India";

	@Test(dataProvider="getData",groups="Purchase")
	public void SubmitOrder(String username,String password,String productName) throws InterruptedException, IOException{
		
		//Login
		//ADD particular items to the CART
		//checking if the selected item displaying in Cart
		//Select Country from dropdown of suggestions
		//Verify if select product is displayed in Orders
		//Create Error Validations class
		//Create Order validation
		//Run Tests Paralelly\
		//Perform test using Parameterization
	
		
		//LandingPage landingpage = launchApplication();
		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);
		//1.
		//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		productcatalogue.getProductList();
		productcatalogue.getProductName(productName);
		CartPage cartpage = productcatalogue.addProductToCart(productName);
		
		//3.
		productcatalogue.gotoCartPage();
		//CartPage cartpage = new CartPage(driver);
		Thread.sleep(2000);
		boolean itemMatch = cartpage.verifyDisplayedProducts(productName);
		Assert.assertTrue(itemMatch);
		
		CheckOutPage checkoutpage =cartpage.gotoCheckOutPage();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		//4.
		//CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.selectCountry(countryValue, countryName);

		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Thread.sleep(2000);
		//driver.close();

	}
	
	//@Test(dataProvider="getData",dependsOnMethods={"SubmitOrder"})
	//@Test(dependsOnMethods={"SubmitOrder"})
	public void OrderHistoryTest(String username,String password,String productName ) throws InterruptedException
	{
		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);
		OrdersPage orderspage = productcatalogue.gotoOrdersPage();
		Thread.sleep(2000);
		boolean orderMatch =orderspage.verifyDisplayedOrders(productName);
		//System.out.println(orderMatch);
		Assert.assertTrue(orderMatch);
		Thread.sleep(2000);
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] { { "AvosD@gmail.com", "Avos@1234", "ADIDAS ORIGINAL" },
			{ "acekazuki@gmail.com", "Ace@1234", "ZARA COAT 3" }};
	}
	
	
	
	
	
	

}
;