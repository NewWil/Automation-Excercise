package AutomationExcercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

public class BaseClass {
	WebDriver driver;

	@BeforeMethod
	public void launchBrower(){
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("disable-popup-blocking");
		option.addExtensions(new File ("./Extension/adBlock.crx"));
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(option);

		//Launch Browser
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		
		String expected = "Automation Exercise";
		String actual = driver.getTitle();
		
		//Verify if the home page is successfully visible
		if(actual.equals(expected)) {
			System.out.println("Home Page is visible");
		}
		else {
			System.out.println("Home Page is not Visible");
		}
	}
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

	
}
