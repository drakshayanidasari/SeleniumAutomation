package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.Login;

public class Practiceexpand {
	public WebDriver driver;
	public Login lp;
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
	    
	    //System.setProperty("webdriver.chrome.driver", null)
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		lp=new Login(driver);
		
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@When("User enters Email as {string}")
	public void user_enters_email_as(String email) throws InterruptedException {
		Thread.sleep(3000);
		lp.Setusername(email);
	    
	}

	@When("User enters Password as {string}")
	public void user_enters_password_as(String password) throws InterruptedException {
		Thread.sleep(3000);
		lp.Setuserpassword(password);
	}

	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		Thread.sleep(3000);
		lp.clickloginbtn();
	    
	}

	/*@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
		Thread.sleep(3000);
	    Assert.assertEquals(expectedTitle, driver.getTitle());
	}*/

	@When("User clicks on Log out link")
	public void user_clicks_on_log_out_link() throws InterruptedException {
		Thread.sleep(3000);
		lp.clicklogoutbutton();
		
	    
	}
	@Then("close the browser")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
}
