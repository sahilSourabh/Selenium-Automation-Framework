package testPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPractice.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group input")
	WebElement countryField;
	
	@FindBy(css=".ta-results button")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit ")
	WebElement submit;
	
	public void selectCountry(String countryValue, String countryName)
	{
		countryField.sendKeys(countryValue);
		WebElement select = countryList.stream().filter(s -> s.getText().equalsIgnoreCase(countryName)).findFirst()
				.orElse(null);
		select.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
	
	
	

}
