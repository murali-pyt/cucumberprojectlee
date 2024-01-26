package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Baseclass {
	 WebDriver driver = new ChromeDriver();
	
	
	
	

	protected LoginPageObjects Test = new LoginPageObjects();

	public Baseclass() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://staging.wwmib.com/");
		Test = PageFactory.initElements(driver, LoginPageObjects.class);

	}
}
