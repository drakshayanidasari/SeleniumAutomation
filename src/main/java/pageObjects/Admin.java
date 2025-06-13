package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.When;
import utilities.WaitHelper;

public class Admin {
	WebDriver driver;
	WaitHelper waithelper;

	public Admin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}
	//(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]
	@FindBy(xpath="(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]") WebElement Admin;
	//(//*[@type='button'])[6]
	@FindBy(xpath="(//*[@type='button'])[6]") WebElement Addbutton;
	@FindBy(xpath="(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]") WebElement select;
	@FindBy(xpath="(//*[text()='Admin'])[3]") WebElement admin;
	@FindBy(xpath="//*[@placeholder='Type for hints...']")
	WebElement empname;
	@FindBy(xpath="(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]") WebElement status;
	@FindBy(xpath="//*[text()='Enabled']") WebElement enabled;

	@FindBy(xpath="//*[@class='oxd-input oxd-input--active oxd-input--error']")
	WebElement username;

	@FindBy(xpath="(//*[@type='password'])[1]")
	WebElement password;

	@FindBy(xpath="(//*[@type='password'])[2]")
	WebElement cnfpassword;

	@FindBy(xpath="//*[@type='submit']")
	WebElement save;
	//@FindBy(xpath="//*[@placeholder='Type for hints...']") WebElement empname;
	//ctrl+shift+p emulate a focused page
	//@FindBy(xpath="(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]") WebElement status;
	//@FindBy(xpath="//*[text()='Enabled']") WebElement enabled;
	//@FindBy(xpath="//*[@class='oxd-input oxd-input--active oxd-input--error']") WebElement username;
	//@FindBy(xpath="//*[@class='oxd-input oxd-input--active oxd-input--error']") WebElement username;
	//@FindBy(xpath="(//*[@type='password'])[1]") WebElement password;
	//@FindBy(xpath="(//*[@type='password'])[2]") WebElement cnfpassword;
	//@FindBy(xpath="//*[@type='submit']") WebElement save;
	
	
	public void clickAdminmodule() {
		waithelper.waitForElement(Admin, 20);
		Admin.click();
	}
	public void clickAddbtton() {
		waithelper.waitForElement(Addbutton, 20);
		Addbutton.click();
	}
	  // Method 1: Click the dropdown
    public void clickDropdownArrow() {
    	waithelper.waitForElement(select, 20);
        select.click();
    }

    // Method 2: Click the 'Admin' option
    public void clickAdminOption() {
    	waithelper.waitForElement(admin, 20);
        admin.click();
    }
    
    public void enterEmployeeName(String empName) {
    	waithelper.waitForElement(empname, 20);
        empname.sendKeys(empName);
    }

    public void clickStatusDropdown() {
    	waithelper.waitForElement(status, 20);
        status.click();
    }

    public void selectEnabledStatus() {
    	waithelper.waitForElement(enabled, 20);
        enabled.click();
    }

    public void enterUsername(String uname) {
    	waithelper.waitForElement(enabled, 20);
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
    	waithelper.waitForElement(enabled, 20);
    	password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
    	waithelper.waitForElement(enabled, 20);
    	cnfpassword.sendKeys(pwd);
    }

    public void clickSave() {
        waithelper.waitForElement(save, 20);
        save.click();
    }
}
