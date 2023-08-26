package testPractice.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import testPractice.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\testPractice\\resources\\GlobalData.properties");
		
		prop.load(fis);
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			ChromeOptions option =  new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				option.addArguments("--headless");
			}
			
			 driver =  new ChromeDriver(option);
			 driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			 driver =  new EdgeDriver();
		}
		else
		{
			 driver =  new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.gotoLink(driver);
		return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\testPractice\\data\\PurchaseOrder.json");
		//json to String
		String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String to HashMap
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String, String>> data = 
				map.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>() {
				});
		
		return data;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
		String reportPath = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File file = new File(reportPath);
		FileUtils.copyFile(src, file);
		
		return (reportPath);
	}
	
	
	
	

}
