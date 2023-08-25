package testPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testPractice.pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="button[routerlink*='/myorders']")
	WebElement orderButton;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForElementToDissappear() throws InterruptedException
	{
		Thread.sleep(1000);
		
	}
	
	public void waitForWebelementToAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void gotoCartPage()
	{
		cartButton.click();
	}
	
	public OrdersPage gotoOrdersPage()
	{
		orderButton.click();
		OrdersPage orderspage =  new OrdersPage(driver);
		return orderspage;
	}
	
	
	
	

}
