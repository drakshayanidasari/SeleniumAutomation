package ApplicationHooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Driver.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class applicationhooks {
	private Driverfactory df;
    private WebDriver driver;
    private Properties prop;

    // Disable Allure reporting globally for all scenarios
    @Before(order = 0)
    public void disableAllureReportingGlobally() {
        System.setProperty("allure.results.directory", "ignore-allure-results");
    }

    
    @Before(order = 2)
    public void launchBrowser() {
        String browser = prop.getProperty("browser");
        driver = new Driverfactory().init_driver(browser);
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destinationPath = "target/screenshots/" + screenshotName + ".png";

            try {
                FileUtils.copyFile(source, new File(destinationPath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Attach screenshot to Cucumber report
            byte[] fileContent = null;
            try {
                fileContent = Files.readAllBytes(Paths.get(destinationPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scenario.attach(fileContent, "image/png", screenshotName);
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        // Uncomment if you want to close the browser after tests
        // driver.quit();
    }
}

