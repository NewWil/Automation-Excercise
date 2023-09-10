package AutomationExcercise;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RegisterUser extends BaseClass {

														/*--Test Case 1: Register User--*/
	@Test(enabled = true)
	public void RegUser() throws InterruptedException {

		// click signup / login button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		//. Verify 'New User Signup!' is visible
		WebElement signup = driver.findElement(By.xpath("(//h2)[3]"));
		
		if(signup.getText().equals("New User Signup!")) {
			System.out.println("New User Found!");
		}
		else {
			System.out.println("No New User Found!");
		}
		
		//input a name
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Test1234567");
		
		//input a email address
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("testd1234567@gmail.com");
		
		//Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		
		//verify ENTER ACCOUNT INFORMATION
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//b)[1]")));
		WebElement enterAcnInfo = driver.findElement(By.xpath("(//b)[1]"));
		
	
		if(enterAcnInfo.getText().equals("ENTER ACCOUNT INFORMATION")) {
			System.out.println("ENTER ACCOUNT INFORMATION is Visible");
		}else {
			System.out.println("ENTER ACCOUNT INFORMATION is Visible");
		}
	
		//--Fill details: Title, Name, Email, Password, Date of birth--//
		
		//click select tile
		driver.findElement(By.id("id_gender1")).click();
		
		//type password
		driver.findElement(By.id("password")).sendKeys("Failure21");
		
		//--select Date of Birth--//
		
		//select by month
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByIndex(21);
		
		//select by month
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByIndex(5);
		
		//select by month
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByIndex(22);
		
		//Select checkbox 'Sign up for our newsletter!'
		driver.findElement(By.id("newsletter")).click();
		
		//Select checkbox 'Receive special offers from our partners!'
		driver.findElement(By.id("optin")).click();
		
		
		//--Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number--//
		
		//Enter a first name
		driver.findElement(By.id("first_name")).sendKeys("Test");
		
		//Enter a Last name *
		driver.findElement(By.id("last_name")).sendKeys("Test");
				
		//Enter a Company *
		driver.findElement(By.id("company")).sendKeys("Test Company");
		
		//Enter a Address1 *
		driver.findElement(By.id("address1")).sendKeys("Test Address1");
		
		//Enter a Address2 *
		driver.findElement(By.id("address2")).sendKeys("Test Address2");
		
		//Select a Country
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByIndex(1);

		//Enter a State *
		driver.findElement(By.id("state")).sendKeys("Test State");
		
		//Enter a City *
		driver.findElement(By.id("city")).sendKeys("Test City");
		
		//Enter a Zipcode *
		driver.findElement(By.id("zipcode")).sendKeys("1234");
		
		
		//Enter a Mobile Number  *
		driver.findElement(By.id("mobile_number")).sendKeys("0 9 ikaw na bahala sa nine");
		
		//Click Create Account button
		driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
		
		// Verify that 'ACCOUNT CREATED!' is visible
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//b)")));
		WebElement accountCreated = driver.findElement(By.xpath("//b"));
		
		Assert.assertEquals(accountCreated.getText(), "ACCOUNT CREATED!", "CREATED ACCOUNT NOT FOUND");
	
		//Click 'Continue' button
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
		
		//Remove ads
		// Wait for the presence of the iframe
		WebDriverWait waitframe = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='aswift_1']")));

		// Wait for the visibility of the close button within the iframe
		//Thread.sleep(2000);
		WebElement closeButton = waitframe.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ns-r2a9x-e-14 button-common close-button']")));
		//WebElement closeButton = driver.findElement(By.xpath("//body[@class='jar']"));
		// Click on the close button within the iframens-ghm9v-e-5 close-button
		//closeButton.click();
		//driver.switchTo().defaultContent();
		
		
		//Click 'Delete Account' button
		String Delete = " Delete Account";
		driver.findElement(By.xpath("//a[contains(text(),'" +  Delete  + "')]")).click();
		
		//Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		WebElement ActualResult = driver.findElement(By.xpath("//b"));
		
		if(ActualResult.getText().equals("ACCOUNT DELETED!")) {
			System.out.println("ACCOUNT SUCCESSFULLY DELETED!");
		}else {
			System.out.println("ACCOUNT SUCCESSFULLY NOT DELETED!");
		}
		
		//Click CONTINUE BUTTON
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
	}
	
	
														/*--Test Case 2: Login User with correct email and password--*/
	@Test
	public void login_User_With_Correct_Email_Pass(){
		
		//click login/signup
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
		//Verify 'Login to your account' is visible
		String expected_login_result = "Login to your account";
		WebElement actual_login_result = driver.findElement(By.xpath("(//h2)[1]"));
		
		if(actual_login_result.getText().equals(expected_login_result)){
			System.out.println("Login to your account is visible");
		}
		
		else {
			System.out.println("Login to your account is NOT visible");
		}
		
		//--Login with correct email and password--//
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("testd123456@gmail.com");

		// input a email address
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Failure21");

		// Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

		
		//- Verify that 'Logged in as username' is visible-//
		
		String expected_LoggedInUsername= "Test123456";
		WebElement actual_LoggedInUsername = driver.findElement(By.xpath("//b"));
		
		if(actual_LoggedInUsername.getText().contains(expected_LoggedInUsername)) {
			System.out.println("Username Test123456 is Visible ");
		}
		else {
			System.out.println("Username Test123456 is NOT Visible");
		}
		
		//--Click 'Delete Account' button--//
		driver.findElement(By.xpath("(//li)[4]")).click();
		
		
		//--Verify that 'ACCOUNT DELETED!' is visible--//
		String expectedTitle = "Automation Exercise - Signup / Login";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Account has been Deleted!");
		}
		
		else {
			System.out.println("Account is NOT been Deleted!");
		}
		
	}
	
	
													/*--Test Case 3: Login User with incorrect email and password--*/
	@Test
	public void login_User_With_Incorrect_Email_Pass() {
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		// Verify 'Login to your account' is visible
		String expected_login_result = "Login to your account";
		WebElement actual_login_result = driver.findElement(By.xpath("(//h2)[1]"));

		if (actual_login_result.getText().equals(expected_login_result)) {
			System.out.println("Login to your account is visible");
		}

		else {
			System.out.println("Login to your account is NOT visible");
		}

		// --Login with incorrect email and password--//
		//input a incorrect email address
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("incorrect@gmail.com");

		// input a incorrect password
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("incorrect_password");

		// Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

		String ExpectedIncorrectMessage = "Your email or password is incorrect!";
		WebElement ActualIncorrectMessage = driver.findElement(By.xpath("(//p)[1]"));
		
		if(ActualIncorrectMessage.getText().endsWith(ExpectedIncorrectMessage)) {
			System.out.println("Your email or password is incorrect!");
		}
		else {
			System.out.println("Your email or password is correct!");
		}
	}
	
	
																	/*--Test Case 4: Logout User--*/
	@Test
	public void Logout_User() {
		// click login/signup
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		// Verify 'Login to your account' is visible
		String expected_login_result = "Login to your account";
		WebElement actual_login_result = driver.findElement(By.xpath("(//h2)[1]"));

		if (actual_login_result.getText().equals(expected_login_result)) {
			System.out.println("Login to your account is visible");
		}

		else {
			System.out.println("Login to your account is NOT visible");
		}

		// --Login with correct email and password--//
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("testd123456@gmail.com");

		// input a email address
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Failure21");

		// Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

		// - Verify that 'Logged in as username' is visible-//

		String expected_LoggedInUsername = "Test123456";
		WebElement actual_LoggedInUsername = driver.findElement(By.xpath("//b"));

		if (actual_LoggedInUsername.getText().contains(expected_LoggedInUsername)) {
			System.out.println("Username Test123456 is Visible ");
		} else {
			System.out.println("Username Test123456 is NOT Visible");
		}
		
		//--Click Logout--//
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Logout")));
		logoutLink.click();
		
		//--Verify that user is navigated to login page--//
		
		String ExpectedLoginPage = "Automation Exercise - Signup / Login";
		String ActualLoginPage = driver.getTitle();
		
		if(ActualLoginPage.equals(ExpectedLoginPage)) {
			System.out.println("Logged out is Successfull!");
		}
		else {
			System.out.println("Logged out is Unsuccessfull!");
		}
		
	}
	
													/*--Test Case 5: Register User with existing email--*/
	@Test
	public void Register_User_With_Existing_Email() {
		
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		// Verify 'New User Signup!' is visible
		String expected_login_result = "New User Signup!";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement actual_login_result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[3]")));

		if (actual_login_result.getText().equals(expected_login_result)) {
			System.out.println("New User Signup! is visible");
		}

		else {
			System.out.println("New User Signup! is NOT visible");
		}
		
		// --Enter name and already registered email address--//
		driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Test123456");

		// input a email address
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testd123456@gmail.com");

		// Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

		
		//--Verify error 'Email Address already exist!' is visible--//
		String expected_Message_Error = "Email Address already exist!";

		
		WebElement actual_Message_Error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//p)[1]"))));

		if(actual_Message_Error.getText().equals(expected_Message_Error)) {
			System.out.println("Email Address already exist!");
		}
		else {
			System.out.println("Email Address is not existing!");
		}
		
	}
	
															/*---Test Case 6: Contact Us Form---*/
	@Test
	public void Contact_Us_Form() throws InterruptedException {
		//Click Click on 'Contact Us' button
		String Contact_Us = "Contact us";
		driver.findElement(By.xpath("//a[contains(text(),'" +  Contact_Us  + "')]")).click();
		
		//Verify 'GET IN TOUCH' is visible
		String expected_Get_In_Touch = "GET IN TOUCH";
		WebElement Actual_Get_In_Touch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));	
		
		
		if (Actual_Get_In_Touch.getText().equals(expected_Get_In_Touch)) {
			System.out.println("'GET IN TOUCH' is visible");
		} else {
			System.out.println("'GET IN TOUCH' is NOT visible");
		}
		
		
		//Enter name, email, subject and message
		//Enter Name
		driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Test Name");
		
		//Enter Name
		driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("testd123456@gmail.com");
		
		//Enter Subject
		driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Test Subject");
		
		//Enter Message
		driver.findElement(By.id("message")).sendKeys("For Testing purposes only!");
		
		//-Upload file-//
		// Locate the file input element
		WebElement fileInput = driver.findElement(By.xpath("//input[@name='upload_file']"));

		// Specify the file path you want to upload
		String filePath = "C://Users//Administrator//Downloads//test.jpg";

		// Set the file path in the file input element
		fileInput.sendKeys(filePath);
		
		//-- Click 'Submit' button--//
		driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
		
		//click 'OK' button
		// Switch to the alert
		Alert alert = driver.switchTo().alert();

		// Accept the alert by clicking "OK"
		alert.accept();
		
		
		//Verify success message 'Success! Your details have been submitted successfully.' is visible
		String expected_Success_Message = "Success! Your details have been submitted successfully.";
		
		//wait until the element is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement Actual_Success_Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='status alert alert-success']")));
		
		if(Actual_Success_Message.getText().equals(expected_Success_Message)) {
			System.out.println("The Message is Succcessfully delivered!");
		}
		else {
			System.out.println("The Message is NOT delivered!");
		}
		
		///--Click 'Home' button and verify that landed to home page successfully--///
		driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
		

		
		// Wait for the presence of the iframe
		WebDriverWait waitframe = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("aswift_1")));
		
		// Wait for the visibility of the close button within the iframe
		WebElement closeButton = waitframe.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dismiss-button']")));

		// Click on the close button within the iframe
		closeButton.click();

		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		
		// verify that landed to home page successfully
		String expected_Home_Page = "Automation Exercise";
		String Actual_Home_Page = driver.getTitle();
		
		if(Actual_Home_Page.equals(expected_Home_Page)) {
			System.out.println("Landed to home page successfully");
		}
		else {
			System.out.println("NOT Landed to home page");
		}
		
	
		
	}
	
															/*--Test Case 7: Verify Test Cases Page--*/
	@Test
	public void Test_Cases_Page() {
		
		//Click Test Cases Button
		String Test_Cases = "Test Cases";
		driver.findElement(By.xpath("//a[contains(text(),'" +   Test_Cases  + "')]")).click();
		
		//click ads
		/*driver.switchTo().frame("aswift_4");
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		driver.switchTo().defaultContent();*/
		
		///Verify user is navigated to test cases page successfully
		String ExpectedResult = "TEST CASES";
		WebElement ActualResult = driver.findElement(By.xpath("//h2[1]"));
		
		if(ActualResult.getText().equals(ExpectedResult)){
			System.out.println("User is navigated to test cases page successfully!");
		}else {
			System.out.println("User is NOT navigated to test cases page!");
		}
		
	}
		
											/*--Test Case 8: Verify All Products and product detail page--*/
	@Test
	public void Verify_All_Products_And_Product_Detail_Page() {
		
		//Click on 'Products' button 
		driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();
		
		//Verify user is navigated to ALL PRODUCTS page successfully
		
		String ExpectedResult = "ALL PRODUCTS";
		WebElement ActualResult = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		
		if(ActualResult.getText().equals(ExpectedResult)) {
			System.out.println("User is navigated to ALL PRODUCTS page successfully ");
		}
		else {
			System.out.println("Navigation to ALL Product is Failed!");
		}
		
		//6. The products list is visible
		String Product_List = "ALL PRODUCTS";
		WebElement Product_Result = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		
		if(ActualResult.getText().equals(ExpectedResult)) {
			System.out.println("Product List is Available");
		}
		else {
			System.out.println("Product List is NOT available!");
		}
		
		
		//7. Click on 'View Product' of first product
		
		
		 int scrollPixels = 100;
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, " + scrollPixels + ");");

		 // Scroll to a specific element
		 WebElement element = driver.findElement(By.partialLinkText("View Product"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 
		 element.click();
		 
		 //8. User is landed to product detail page
		 String Actual = "Automation Exercise - Product Details";
		 String Exp_Title = driver.getTitle();
		 
		 if(Actual.equals(Exp_Title))
		 {		 
			 System.out.println("User is Landed to Product Detail Page!");
		 }else {
			 System.out.println("User is NOT Landed to Product Detail Page!");
			 
		 }
		 
		 
		 // 9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

		 //Product Name
		 String Actual_Product_Name =  "Blue Top";
		 WebElement Product_Name = driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]"));

		 if(Actual_Product_Name.equals(Product_Name.getText())) {
			 System.out.println("Product Name is Visible");
		 }
		 else {
			 System.out.println("Product Name is NOT Visible!");
		 }
		 
		 
		 //Category Name
		 String Actual_Category_Name =  "Category: Women > Tops";
		 WebElement Category_Name = driver.findElement(By.xpath("//p[contains(text(),'Category: Women > Tops')]"));

		 if(Actual_Category_Name.equals(Category_Name.getText())) {
			 System.out.println("Category Name is Visible");
		 }
		 else {
			 System.out.println("Category Name is NOT Visible!");
		 }
		 
		 //Price
		 String Actual_Price =  "Rs. 500";
		 WebElement Price = driver.findElement(By.xpath("//span[contains(text(),'Rs. 500')]"));

		 if(Actual_Price.equals(Price.getText())) {
			 System.out.println("Price is Visible");
		 }
		 else {
			 System.out.println("Price is NOT Visible!");
		 }
		 

		 //Price
		 String Actual_Availability =  "Availability: In Stock";
		 WebElement Availability = driver.findElement(By.xpath("//p[contains(text(),'In Stock')]"));
		
		 if (Actual_Availability.equals(Availability.getText())) {
				System.out.println("Availability is Visible");
		} 
		 else {
				System.out.println("Availability is NOT Visible!");
		}
		 

		 //Condition
		 String Actual_Condition =  "Condition: New";
		 WebElement Condition = driver.findElement(By.xpath("//p[contains(text(),'New')]"));
		
		 if (Actual_Condition.equals(Condition.getText())) {
				System.out.println("Condition is Visible");
		} 
		 else {
				System.out.println("Condition is NOT Visible!");
		}
		 
		 //Brand
		 String Actual_Brand =  "Brand: Polo";
		 WebElement Brand = driver.findElement(By.xpath("//p[contains(text(), 'Polo')]"));
		
		 if (Actual_Brand.equals(Brand.getText())) {
				System.out.println("Brand is Visible");
		} 
		 else {
				System.out.println("Brand is NOT Visible!");
		}
		 
}
												/*--Test Case 9: Search Product--*/
	
	@Test
	public void search_Product() {
		
		// Click on 'Products' button
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		
		//Verify user is navigated to ALL PRODUCTS page successfully
		String Exp_Product = "ALL PRODUCTS";
		WebElement Actual_Product = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
		
		if(Exp_Product.equals(Actual_Product.getText())) {
			System.out.println("User is Navigated to ALL PRODUCTS page successfully!");
		}else {
			System.out.println("User is NOT Navigated to ALL PRODUCTS page successfully!");
		}
		
		//Enter product name in search input and click search button
		//enter Product and CLick
		WebElement search_Product = driver.findElement(By.id("search_product"));
				search_Product.sendKeys("White");
		driver.findElement(By.id("submit_search")).click();
		
		//Verify 'SEARCHED PRODUCTS' is visible
		String Act_Searched_Product = "SEARCHED PRODUCTS";
		
		//Wait the result of the search product
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement Exp_Searched_Product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Searched Products')]")));

		if(Act_Searched_Product.equals(Exp_Searched_Product.getText())) {
			System.out.println("SEARCHED PRODUCT is Visible!");
		}else {
			System.out.println("SEARCHED PRODUCT is NOT Visible!");
		}
		
		//Verify all the products related to search are visible
		WebDriverWait wait_related_search = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement exp_related_search = wait_related_search.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'White')]")));
		
		String search = "White";
		
		List<WebElement> search_results = driver.findElements(By.xpath("//p[contains(text(),'White')]"));
		for(WebElement result: search_results) {
			String resultText = result.getText();
			
			if(resultText.contains("White")) {
				System.out.println("Search Result is Match!" + resultText);
			} /*
				 * else { System.out.println("Search Result NOT Match!"); }
				 */
				
		}
	}
	 				
																/*--Test Case 10: Verify Subscription in home page--*/
	@Test
	public void Subsciption_HomePpage() {
		
		//Scroll down to footer
		 WebElement element = driver.findElement(By.id("susbscribe_email"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 
		 //Verify text 'SUBSCRIPTION'
		 String Exp_Subscription = "SUBSCRIPTION";
		 WebElement Actual_Subscription = driver.findElement(By.xpath("//h2[contains(text(), 'Subscription')]"));
		 
		 if(Actual_Subscription.getText().equals(Exp_Subscription)) {
			 System.out.println("SUBSCRIPTION TEXT is Verified!");
		 }else {
			 System.out.println("SUBSCRIPTION TEXT is NOT Verified!");
		 }
		 
		 
		 //Enter email address in input and click arrow button
		 driver.findElement(By.id("susbscribe_email")).sendKeys("Test@gmail.com");
		 driver.findElement(By.id("subscribe")).click();
		 
		 //Verify success message 'You have been successfully subscribed!' is visible
		 String Exp_Message = "You have been successfully subscribed!";
		 WebElement Actual_Message = driver.findElement(By.xpath("//div[@class='alert-success alert']"));
		 
		 if(Actual_Message.getText().equals(Exp_Message)) {
			 System.out.println("Message has been sent!");
		 }else {
			 System.out.println("Message has NOT been sent!");
		 }
	}
	
	
	
	
	
	
	
}
