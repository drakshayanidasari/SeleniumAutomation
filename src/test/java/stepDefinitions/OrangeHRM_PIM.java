package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Login;
import pageObjects.Pim;

public class OrangeHRM_PIM extends Base_class1 {

    Pim pim;
    Login login;

    @Given("I launched the application")
    public void i_launched_the_application() throws InterruptedException {
        launchBrowser(); // Only launches once
        login = new Login(driver);
        pim = new Pim(driver);}
    @And("I logged in with username {string} and password {string}")
    public void i_logged_in_with_username_and_password(String username, String password) {
        login.Setusername(username);
        login.Setuserpassword(password);
        login.clickloginbtn();
    }


    @And("I navigate to the PIM page")
    public void i_navigate_to_the_pim_page() {
        pim.clickPimTab();
    }

    @When("I start adding a new employee")
    public void i_start_adding_a_new_employee() {
        pim.clickAddButton();
    }
    
    /*@And("I upload the employee image")
    public void i_upload_the_employee_image() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Click the image upload icon
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.oxd-icon.bi-plus"))).click();
        
        // Upload the image file
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
        fileInput.sendKeys("C:\\Users\\NeelimaBusam\\OneDrive\\Pictures\\photo.jpg");
    }*/
    
    @And("I upload the employee image")
    public void i_upload_the_employee_image() {
    pim.uploadEmployeePhoto("C:\\Users\\NeelimaBusam\\OneDrive\\Pictures\\photo.jpg");

    }
    

    @And("I enter employee details:")
    public void i_enter_employee_details(DataTable table) throws InterruptedException {
    	Thread.sleep(3000);
        Map<String, String> employee = table.asMaps().get(0);
        pim.setFirstName(employee.get("firstName"));
        pim.setMiddleName(employee.get("middleName"));
        pim.setLastName(employee.get("lastName"));
        pim.setEmployeeId(employee.get("id"));
    }
    
    /*@And("I upload the employee image {string}")
    public void i_upload_the_employee_image(String imagePath) throws InterruptedException {
        Thread.sleep(4000); // Optional wait for dialog to load
        pim.uploadEmployeePhoto(imagePath);
    }*/
    
    

    @And("I save the employee")
    public void i_save_the_employee() {
        pim.clickSave();
    }

    @Then("the personal details page should open")
    public void the_personal_details_page_should_open() {
        String title = pim.getTitle();
        if (title.contains("Personal Details")) {
            System.out.println("Personal Details page is opened successfully.");
        } else {
            System.out.println("Personal Details page did NOT open. Actual title: " + title);
        }
    }

}
