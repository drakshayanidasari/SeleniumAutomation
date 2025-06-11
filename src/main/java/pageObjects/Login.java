package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
@FindBy(xpath="//button[@type='submit']") WebElement login;

@FindBy(xpath="//i[@class='icon-2x icon-signout']") WebElement logout;

	public void Setusername(String Email) {
		username.click();
		username.sendKeys(Email);
	}

	public void Setuserpassword(String Password) {
		password.clear();
		password.sendKeys(Password);
	}

	public void clickloginbtn() {
		login.click();
	}
	
	public void clicklogoutbutton() {
		logout.click();
	}

}
