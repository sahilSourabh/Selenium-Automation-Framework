package testPractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPractice.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver1;
	public LandingPage(WebDriver driver) {
		
		//Initialization
		super(driver);
		this.driver1=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPwd;
	
	@FindBy(id="login")
	WebElement userLogin;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void gotoLink(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductCatalogue loginApplication(String usrname, String pwd)
	{
		userEmail.sendKeys(usrname);
		userPwd.sendKeys(pwd);
		userLogin.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver1);
		return productcatalogue;
	}
	
	public String getLandingpageErrorMessage()
	{
		waitForWebelementToAppear(errorMessage);
		String errmsg = errorMessage.getText();
		return errmsg;
		
	}
	
	
	
	
	
	

}
