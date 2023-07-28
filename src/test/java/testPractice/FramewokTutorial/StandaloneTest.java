package testPractice.FramewokTutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		//Login
		//ADD particular items to the CART
		//checking if the selected item displaying in Cart
		//Select Country from dropdown of suggestions
		
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		//1.
		driver.findElement(By.id("userEmail")).sendKeys("AvosD@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Avos@1234");
		driver.findElement(By.id("login")).click();
		//2.
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = items.stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ADIDAS ORIGINAL"))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//3.
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> list = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean itemMatch = list.stream().anyMatch(s->s.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(itemMatch);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		//4.
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		List<WebElement> country = driver.findElements(By.cssSelector(".ta-results button"));
		WebElement select = country.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		select.click();
//		Actions action = new Actions(driver);
//		action.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".form-group input"))));
//		driver.findElement(By.xpath("(//button[contains(.,'India')])[2]")).click();
		
		driver.findElement(By.cssSelector(".action__submit ")).click();
		
		
		Thread.sleep(2000);
		driver.close();
		

	
	}

}
;