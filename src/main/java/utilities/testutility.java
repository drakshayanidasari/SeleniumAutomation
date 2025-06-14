package utilities;

import java.util.UUID;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import io.qameta.allure.Allure;
import io.qameta.allure.model.StepResult;

import io.qameta.allure.model.Status;

import org.openqa.selenium.WebElement;

import java.util.UUID;

public class testutility {
	public static String randomPassword;

	private static Faker faker = new Faker();
	public static void enterRandomPassword(WebElement element, String fieldName) {
        String stepName = "Entered random password into " + fieldName;
        String stepUUID = UUID.randomUUID().toString();

        try {
            StepResult stepResult = new StepResult().setName(stepName);
            Allure.getLifecycle().startStep(stepUUID, stepResult);

            // Generate password with pattern
            randomPassword = Faker.instance().regexify("[A-Z]{1}[a-z]{1}[0-9]{1}[!@#$%^&]{1}[A-Za-z0-9!@#$%^&]{7,8}");
            element.sendKeys(randomPassword);

            // Print to console
            System.out.println("Entered Random Password: " + randomPassword);

            // Add to Allure report (as attachment)
            //Allure.addAttachment("Random Password for " + fieldName, randomPassword);

            Allure.getLifecycle().updateStep(step -> step.setStatus(Status.PASSED));
        } catch (Exception e) {
            Allure.getLifecycle().updateStep(step -> step.setStatus(Status.FAILED));
            throw e;
        } finally {
            Allure.getLifecycle().stopStep(stepUUID);
        }
    }
	
	public static void enterRandomUsername(WebElement element, String fieldName) {
	    String stepName = "Entered random username into " + fieldName;
	    String stepUUID = UUID.randomUUID().toString();

	    try {
	        StepResult stepResult = new StepResult().setName(stepName);
	        Allure.getLifecycle().startStep(stepUUID, stepResult);

	        // Generate random username using Faker and regex
	        String randomUsername = Faker.instance().regexify("[a-z]{5,8}[0-9]{2,4}");
	        element.sendKeys(randomUsername);

	        // Print to console
	        System.out.println("Entered Random Username: " + randomUsername);

	        // Optionally attach to Allure report
	        // Allure.addAttachment("Random Username for " + fieldName, randomUsername);

	        Allure.getLifecycle().updateStep(step -> step.setStatus(Status.PASSED));
	    } catch (Exception e) {
	        Allure.getLifecycle().updateStep(step -> step.setStatus(Status.FAILED));
	        throw e;
	    } finally {
	        Allure.getLifecycle().stopStep(stepUUID);
	    }
	}

	public static void enterConfirmPassword(WebElement element, String fieldName) {
	    String stepName = "Entered confirm password into " + fieldName;
	    String stepUUID = UUID.randomUUID().toString();

	    try {
	        StepResult stepResult = new StepResult().setName(stepName);
	        Allure.getLifecycle().startStep(stepUUID, stepResult);

	        // Use the already generated password
	        if (randomPassword == null || randomPassword.isEmpty()) {
	            throw new IllegalStateException("randomPassword is null or not generated yet!");
	        }

	        element.sendKeys(randomPassword);

	        // Print to console
	        System.out.println("Entered Confirm Password: " + randomPassword);

	        // Optionally attach to Allure report
	        // Allure.addAttachment("Confirm Password for " + fieldName, randomPassword);

	        Allure.getLifecycle().updateStep(step -> step.setStatus(Status.PASSED));
	    } catch (Exception e) {
	        Allure.getLifecycle().updateStep(step -> step.setStatus(Status.FAILED));
	        throw e;
	    } finally {
	        Allure.getLifecycle().stopStep(stepUUID);
	    }
	}

}
