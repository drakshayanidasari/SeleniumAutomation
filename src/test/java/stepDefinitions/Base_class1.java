package stepDefinitions;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.Admin;
import pageObjects.Login;
import pageObjects.Pim;

public class Base_class1 {

    public static WebDriver driver; // Shared across all step classes
    public Login lp;
    public Pim addpim;
    public Admin admin;

    // Launch browser if not already launched
    public static void launchBrowser() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


        }
    }

    // Close browser and clean up
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Utility method for generating random strings
    public static String randomstring() {
        return RandomStringUtils.randomAlphabetic(5);
    }
}
