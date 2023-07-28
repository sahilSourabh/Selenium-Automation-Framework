package testPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPractice.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By productLocator= By.cssSelector("b");
	By prodDetail = By.cssSelector(".card-body button:last-of-type");
	By toast = By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	
	public WebElement getProductName(String productName)
	{
		WebElement name = getProductList().stream()
				.filter(s -> s.findElement(productLocator).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
		return name;
	}
	
	public CartPage addProductToCart(String productName) throws InterruptedException
	{
		getProductName(productName).findElement(prodDetail).click();
		waitForElementToAppear(toast);
		waitForElementToDissappear();
		
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	
	
	

}
