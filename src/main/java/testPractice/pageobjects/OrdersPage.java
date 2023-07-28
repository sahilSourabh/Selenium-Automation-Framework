package testPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPractice.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	public WebDriver driver;
	public OrdersPage(WebDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-of-type(2)")
	List<WebElement> ordersList;
	
	public boolean verifyDisplayedOrders(String productName )
	{
		boolean itemMatch = ordersList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return itemMatch;
	}
	
	

}
