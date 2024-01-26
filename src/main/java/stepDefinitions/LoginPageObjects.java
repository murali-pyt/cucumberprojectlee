package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPageObjects extends Base_Class{

   //  WebDriver driver;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement login;

	@FindBy(xpath = "(//input[@type=\"number\"])[1]")
	WebElement mobileNumber;

	@FindBy(xpath = "(//input[@aria-label=\"Please enter verification code. Digit 1\"])[1]")
	WebElement otp;

	@FindBy(xpath = "(//button[text()=\"Login\"])[1]")
	WebElement loginCTA;

	@FindBy(xpath = "(//button[contains(@id,\"radix\")])[5]")
	WebElement dot;

	@FindBy(xpath = "//a[text()=\"Testimonials\"]")
	WebElement testimonials;

	@FindBy(xpath = "//a[text()=\"Visa\"]")
	WebElement visa;

	@FindBy(xpath = "//a[text()=\"FAQ\"]")
	WebElement faq;

	@FindBy(xpath = "//a[text()=\"Contact Us\"]")
	WebElement contactUs;

	@FindBy(xpath = "//a[text()=\"Blog\"]")
	WebElement blog;

	@FindBy(xpath = "//a[text()=\"About Us\"]")
	WebElement aboutUs;
	

	public LoginPageObjects() {
		PageFactory.initElements(driver, this); 

	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(WebElement mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public WebElement getOtp() {
		return otp;
	}

	public void setOtp(WebElement otp) {
		this.otp = otp;
	}

	public WebElement getLoginCTA() {
		return loginCTA;
	}

	public void setLoginCTA(WebElement loginCTA) {
		this.loginCTA = loginCTA;
	}

	public WebElement getDot() {
		return dot;
	}

	public void setDot(WebElement dot) {
		this.dot = dot;
	}

	public WebElement getTestimonials() {
		return testimonials;
	}

	public void setTestimonials(WebElement testimonials) {
		this.testimonials = testimonials;
	}

	public WebElement getVisa() {
		return visa;
	}

	public void setVisa(WebElement visa) {
		this.visa = visa;
	}

	public WebElement getFaq() {
		return faq;
	}

	public void setFaq(WebElement faq) {
		this.faq = faq;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public void setContactUs(WebElement contactUs) {
		this.contactUs = contactUs;
	}

	public WebElement getBlog() {
		return blog;
	}

	public void setBlog(WebElement blog) {
		this.blog = blog;
	}

	public WebElement getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(WebElement aboutUs) {
		this.aboutUs = aboutUs;
	}

	public void clickAction(WebElement element) throws InterruptedException {
		try {
			pollingWait(element, 30);
			element.click();
		} catch (ElementNotInteractableException ex) {
			Thread.sleep(3000);
			clickJavaScriptElement(element);
		} catch (Exception ex) { //
			//Reports.reportStep("Failed to click the Webelement " + element, "FAIL");
			System.out.println("Failed to click the Webelement " + element);
			ex.printStackTrace();
		}
	}

	public void pollingWait(WebElement element, int timeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void clickJavaScriptElement(WebElement element) throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element); //
			System.out.println("Successfully clicked the Javascript Webelement");
		} catch (ElementNotInteractableException ex) {
			Thread.sleep(3000);
			System.out.println("Unable to click for the first time and trying one more time");
			element.click();
		} catch (Exception ex) {
			System.out.println("Failed to click the Javascript Webelement");
		}
	}

}
