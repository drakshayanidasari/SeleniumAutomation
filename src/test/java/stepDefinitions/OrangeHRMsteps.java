package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import junit.framework.Assert;
import pageObjects.Login;

public class OrangeHRMsteps {

    WebDriver driver;
    Login lp;

    @Given("I launches the application")
    public void i_launch_the_application() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        lp = new Login(driver);
        Thread.sleep(1000);
    }

    @When("I log in with username {string} and password {string}")
    public void i_log_in_with_username_and_password(String username, String password) throws InterruptedException {
        lp.Setusername(username);
        Thread.sleep(500);
        lp.Setuserpassword(password);
        Thread.sleep(500);
        lp.clickloginbtn();
        Thread.sleep(1000);
    }

    @Then("the dashboard visible")
    public void the_dashboard_should_be_visible() {
        Assert.assertTrue("Page title doesn't contain OrangeHRM", driver.getTitle().contains("OrangeHRM"));
    }
}
