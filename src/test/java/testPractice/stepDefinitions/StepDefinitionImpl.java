package testPractice.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPractice.TestComponents.BaseTest;
import testPractice.pageobjects.CartPage;
import testPractice.pageobjects.CheckOutPage;
import testPractice.pageobjects.ConfirmationPage;
import testPractice.pageobjects.LandingPage;
import testPractice.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public CartPage cartpage;
	public CheckOutPage checkoutpage;
	public ConfirmationPage confirmationpage;
	
	@Given("Landing on Ecommerce page")
	public void Landing_on_Ecommerce_page() throws IOException
	{
		landingpage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password)
	{
		productcatalogue = landingpage.loginApplication(username, password);
		
	}
	
	@When("^Adding Product (.+) to the cart$")
	public void Adding_Product_to_the_cart(String productName) throws InterruptedException
	{
		productcatalogue.getProductList();
		productcatalogue.getProductName(productName);
		cartpage = productcatalogue.addProductToCart(productName);
	}
	
	@And("^Checkout product (.+) and Submit the Order$")
	public void Checkout_product_and_Submit_the_Order(String productName) throws InterruptedException
	{
		productcatalogue.gotoCartPage();
		Thread.sleep(2000);
		boolean itemMatch = cartpage.verifyDisplayedProducts(productName);
		Assert.assertTrue(itemMatch);
		
		checkoutpage =cartpage.gotoCheckOutPage();
		checkoutpage.selectCountry("ind", "India");

		confirmationpage = checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on the ConfirmationPage")
	public void message_displayed_on_ConfirmationPage(String string) throws InterruptedException
	{
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		Thread.sleep(2000);
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void error_message_displayed(String string) throws InterruptedException
	{
		landingpage.getLandingpageErrorMessage();
		System.out.println("Error Message: "+landingpage.getLandingpageErrorMessage());
		Assert.assertEquals(string,landingpage.getLandingpageErrorMessage());
		Thread.sleep(2000);
		driver.close();
	}

	
	
	
}
