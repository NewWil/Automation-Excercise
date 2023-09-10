package AutomationExcercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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
	public void launchBrower() throws InterruptedException{
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addExtensions(new File ("./Extension/adBlock.crx"));
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(option);

		// Open a new tab/window
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        
        // Get window handles for all tabs/windows
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        
        // Switch to the new tab (index 1)
        driver.switchTo().window(tabs.get(0));
        driver.close();
      
		//close new Tab
       
	    
        driver.switchTo().window(tabs.get(1));
        driver.get("http://automationexercise.com");
        
        //Back to the main page since it is opening due to the adsblocker installed
        driver.switchTo().window(tabs.get(1));
  
  
        //maximize windows
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
