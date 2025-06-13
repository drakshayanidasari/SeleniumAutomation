package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".//Features/Admin.feature",
    glue = "stepDefinitions", // patho of stepdefinition pate 
    dryRun = false,
    monochrome = true,
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // <-- Add this line
        "html:test-output"  // optional, if you still want HTML output in parallel
    }
)
public class TestRunner {
}


