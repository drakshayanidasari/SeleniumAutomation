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
		
	        launchBrowser(); // Only launches once
	        login = new Login(driver);
	        pim = new Pim(driver);
	        admin =new Admin(driver);
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
	    
	}

	@When("Enter the employee name in the field")
	public void enter_the_employee_name_in_the_field() {
	    
	}

	@When("click on the status dropdown")
	public void click_on_the_status_dropdown() {
	    
	}

	@When("Enter the username in the field")
	public void enter_the_username_in_the_field() {
	   
	}

	@When("Enter the password in the field")
	public void enter_the_password_in_the_field() {
	    
	}

	@When("Enter the confirm password")
	public void enter_the_confirm_password() {
	    
	}

	@When("click on the save button")
	public void click_on_the_save_button() {
	    
	}
}
