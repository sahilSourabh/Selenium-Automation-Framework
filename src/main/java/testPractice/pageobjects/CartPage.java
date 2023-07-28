package testPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPractice.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartList;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	public boolean verifyDisplayedProducts(String productName )
	{
		boolean itemMatch = cartList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return itemMatch;
	}
	
	public CheckOutPage gotoCheckOutPage()
	{
		checkoutButton.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}
	
	
	
	
	
	
	
	
	

}
