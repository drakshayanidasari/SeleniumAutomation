package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.Admin;
import pageObjects.Login;
import pageObjects.Pim;

public class AdminHRMsteps extends Base_class1 {

    Admin admin;
    Pim pim;
    Login login;

    @Given("I launchess the application")
    public void i_launchess_the_application() {
        launchBrowser();
        login = new Login(driver);
        pim = new Pim(driver);
        admin = new Admin(driver);
    }

    @Given("I logged with username {string} and password {string}")
    public void i_logged_with_username_and_password(String username, String password) {
        login.Setusername(username);
        login.Setuserpassword(password);
        login.clickloginbtn();
    }

    @Given("I navigate to ADMIN page")
    public void i_navigate_to_admin_page() {
        admin.clickAdminmodule();
    }

    @When("click on the add button")
    public void click_on_the_add_button() {
        admin.clickAddbtton();
    }

    @When("click on the user role dropdown")
    public void click_on_the_user_role_dropdown() {
        admin.clickDropdownArrow();
    }

    @When("select the Admin user option")
    public void select_the_admin_user_option() {
        admin.clickAdminOption();
    }

    @When("Enter the employee name in the field {string}")
    public void enter_the_employee_name_in_the_field(String empName) {
        admin.enterEmployeeName(empName);  // Must trigger and select from dropdown
    }

    @When("click on the status dropdown")
    public void click_on_the_status_dropdown() {
        admin.clickStatusDropdown();
        admin.selectEnabledStatus(); // Selecting "Enabled" immediately
    }

    @When("Enter the username as {string}")
    public void enter_the_username_as(String uname) throws InterruptedException {
    	Thread.sleep(3000);
        admin.enterUsername(uname);
    }

    @When("Enter the password as {string}")
    public void enter_the_password_as(String pwd) throws InterruptedException {
    	Thread.sleep(3000);
        admin.enterPassword(pwd);
    }

    @When("Enter the confirm password as {string}")
    public void enter_the_confirm_password_as(String cpwd) throws InterruptedException {
    	Thread.sleep(3000);
        admin.enterConfirmPassword(cpwd);
    }

    @When("click on the save button")
    public void click_on_the_save_button() {
        admin.clickSave();
    }
}
