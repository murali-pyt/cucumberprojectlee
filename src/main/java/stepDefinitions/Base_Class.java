package stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

//	public static WebDriver driver;
	protected static WebDriver driver;
	public static Robot r;

	public static WebDriver browserLaunch(String browsername) {

		switch (browsername) {

		case "chrome":

		//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.err.println("Browser not available");
			break;

		}
		return driver;

	}

	public void urlLaunch(String url) {

		driver.get(url);

	}

	public void webelementClick(WebElement a) {

		a.click();

	}

	public void sendKeys(WebElement a, String data) {

		a.sendKeys(data);
	}
	
	

	public void dynamicWait(int sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void downKey() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}
	
	public void enterKey() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	

}
