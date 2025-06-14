package testRunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import AllureReports.Openallurereport;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = ".//Features/Admin.feature",
    glue = "stepDefinitions", // path to step definition package
    dryRun = false,
    monochrome = true,
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "html:test-output"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void generateAllureReport() {
        Openallurereport.openAllureReport();
    }
}
