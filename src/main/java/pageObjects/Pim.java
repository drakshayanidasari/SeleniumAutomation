package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Pim {

    private final WebDriver driver;

    public Pim(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* ------------------- Locators ------------------- */

    @FindBy(xpath = "//*[text()='PIM']")
    private WebElement pimTab;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;
    
    /* Image uploader – typically a hidden <input type='file'> element */
    @FindBy(xpath = "//input[@type='file']")
    private WebElement imageUploadInput;


    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    /* 👇 Adjust the locator so it points to your Employee Id field exactly */
    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input")
    private WebElement employeeIdInput;

    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    /* ------------------- Page Actions ------------------- */

    public void clickPimTab() {
        pimTab.click();
    }

    public void clickAddButton() {
        addButton.click();
    }
    
    public void uploadEmployeePhoto(String imagePath) {
        imageUploadInput.sendKeys(imagePath);
        System.out.println("File uploaded successfully: " + imagePath);
    }


    public void setFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setMiddleName(String middleName) {
        middleNameInput.clear();
        middleNameInput.sendKeys(middleName);
    }

    public void setLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setEmployeeId(String empId) {
        employeeIdInput.clear();
        employeeIdInput.sendKeys(empId);
    }

    /**
     * Upload photo using the Robot class to interact with the native file‑chooser.
     * @param absolutePath fully‑qualified path to the image on the local disk
     */
   
    /*public void uploadEmployeePhoto(String imagePath) {
        WebElement fileInput = driver.findElement(By.xpath("//*[@class='oxd-icon bi-plus']"));
        fileInput.sendKeys("C:\\Users\\NeelimaBusam\\OneDrive\\Pictures\\photo.jpg");
        System.out.println("File upload successfully");
    }*/
        
       /* WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
            fileInput.sendKeys("C:\\Users\\NeelimaBusam\\OneDrive\\Pictures\\photo.jpg");
    }*/
         
    

    public void clickSave() {
        saveButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
