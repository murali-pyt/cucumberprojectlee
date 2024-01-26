package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends Base_Class {

	LoginPageObjects Test = new LoginPageObjects();


	@Given("^User is on Homepage$")
	public void user_is_on_Homepage() throws InterruptedException {
		browserLaunch("chrome");
		urlLaunch("https://staging.wwmib.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@When("^Title of homepage is Pickyourtrail$")
	public void title_of_homepage_is_Pickyourtrail() throws Throwable {
		String title = driver.getTitle();
		String expected = "Customised Vacation Packages | International Holidays";
	//	Assert.assertEquals(title, expected);
	}

	@Then("^User enters Login$")
	public void user_enters_Login() throws InterruptedException {
		Test = new LoginPageObjects();
	//	webelementClick(Test.getLogin());
		Test.clickAction(Test.getLogin());
	}

	

	@Then("^User enter \"(.*)\"$")
	public void user_enter_mobile_number(String mobile) throws InterruptedException {
		// LoginPageObjects Test = new LoginPageObjects(driver);
		for (int i = 0; i < mobile.length(); i++) {
			char c = mobile.charAt(i);
			String s = new StringBuilder().append(c).toString();
			// Test.mobileNumber.sendKeys(s);
			sendKeys(Test.getMobileNumber(), s);
			Thread.sleep(150);
		}
	}

	@Then("^User enters \"(.*)\"$")
	public void user_enters_OTP(String otp) throws InterruptedException {
		// LoginPageObjects Test = new LoginPageObjects(driver);
		// Test.otp.sendKeys("666666");
		//String otp = "666666";
		sendKeys(Test.getOtp(), otp);

	}

	@Then("^User clicks Login$")
	public void user_Clicks_Login() throws InterruptedException {
		// LoginPageObjects Test = new LoginPageObjects(driver);
		Test.clickAction(Test.getLoginCTA());
		// Test.loginCTA.click();
	//	Assert.assertTrue(true);

	}

	@Then("^Checking all the logos are working or not$")
	public void checking_all_the_logos_are_working_or_not() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
		Actions act = new Actions(driver);
		act.moveToElement(Test.getDot()).perform();
		Thread.sleep(2000);
		
		Test.clickJavaScriptElement(Test.getTestimonials());
		  
	//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", Test.getTestimonials());		
		
	//	act.moveToElement(Test.getTestimonials()).click().perform();
	//	webelementClick(Test.getTestimonials());

		// Test.testimonials.click();
		String testimonialTitle = driver.getTitle();
		// System.out.println(testimonialTitle);
		String expectedTitle = "Pickyourtrail Reviews - Read What our Customers Say!";
	//	Assert.assertEquals(testimonialTitle, expectedTitle);

		driver.navigate().back();

		driver.navigate().refresh();
		try {
			act.moveToElement(Test.getDot()).perform();
		} catch (StaleElementReferenceException e) {
			// driver.navigate().refresh();
			WebElement dot1 = driver.findElement(By.xpath("(//button[contains(@id,\"radix\")])[5]"));
			act.moveToElement(dot1).perform();
		}
		
		Test.clickJavaScriptElement(Test.getVisa());

	//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", Test.getVisa());		

		// Test.visa.click();
		String visaTitle = driver.getTitle();
		// System.out.println(visaTitle);
		String expectedVisaTitle = "Tourist Visa Information for Indians - Requirements & Forms";
	//	Assert.assertEquals(visaTitle, expectedVisaTitle);

		driver.navigate().back();
		try {
			act.moveToElement(Test.getDot()).perform();
		} catch (StaleElementReferenceException e) {
			WebElement dot2 = driver.findElement(By.xpath("(//button[contains(@id,\"radix\")])[5]"));
			act.moveToElement(dot2).perform();
		}
		
		Test.clickJavaScriptElement(Test.getFaq());

	//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", Test.getFaq());		

		// Test.faq.click();
		String faqTitle = driver.getTitle();
		// System.out.println(faqTitle);
		String expectedFaqTitle = "FAQ on Travel, Visa, Holiday & Honeymoon Packages | PickYourtrail";
	//	Assert.assertEquals(faqTitle, expectedFaqTitle);

		driver.navigate().back();
		try {
			act.moveToElement(Test.getDot()).perform();
		} catch (StaleElementReferenceException e) {
			WebElement dot3 = driver.findElement(By.xpath("(//button[contains(@id,\"radix\")])[5]"));
			act.moveToElement(dot3).perform();
		}

		Test.clickJavaScriptElement(Test.getContactUs());
	//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", Test.getContactUs());		

		// Test.contactUs.click();
		String contactUsTitle = driver.getTitle();
		// System.out.println(contactUsTitle);
		String expectedContactUsTitle = "Contact Us | Pickyourtrail";
	//	Assert.assertEquals(contactUsTitle, expectedContactUsTitle);


		driver.navigate().back();
		try {
			act.moveToElement(Test.getDot()).perform();
		} catch (StaleElementReferenceException e) {
			WebElement dot5 = driver.findElement(By.xpath("(//button[contains(@id,\"radix\")])[5]"));
			act.moveToElement(dot5).perform();
		}

		Test.clickJavaScriptElement(Test.getAboutUs());

	//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", Test.getAboutUs());		

		// Test.aboutUs.click();
		String aboutUsTitle = driver.getTitle();
//		System.out.println(aboutUsTitle);
		String expectedAboutUsTitle = "About the Team | Pickyourtrail";
//		Assert.assertEquals(aboutUsTitle, expectedAboutUsTitle);

		driver.navigate().back();
		driver.close();
		}
		
		catch(Exception e) {
		driver.close();
		}
	}

}
