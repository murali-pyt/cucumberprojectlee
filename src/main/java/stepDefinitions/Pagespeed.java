package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Pagespeed {
	
	WebDriver driver;

	@Given("User opens browser")
	public void user_opens_browser() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://docs.google.com/spreadsheets/d/1rpTAsX8tVlkE1AaNd36qC_0eE81TZk7XAIcAp9P9ks4/edit#gid=0");

	}

	@Then("User enters data")
	public void user_enters_data() {
		

	}

}