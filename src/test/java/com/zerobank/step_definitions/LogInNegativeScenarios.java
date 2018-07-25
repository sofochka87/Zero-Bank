 package com.zerobank.step_definitions;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInNegativeScenarios {
	LoginPage loginPage = new LoginPage(Driver.getDriver());
	String actualMessage; 
	String expectedMessage = "Login and/or password are wrong.";
	String messageLocation ="//div[@class='alert alert-error']";

	@When ("The user logs in with blank user ID")
	public void The_user_logs_in_with_blank_user_ID() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.logIn("", "password");
		}
	@Then("Error Message should be displayed")
	public void Error_Message_should_be_displayed(){
		actualMessage = Driver.getDriver().findElement(By.xpath(messageLocation)).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@And ("The user logs in with blank password")
	public void The_user_logs_in_with_blank_password(){
		loginPage.logIn("username", "");
	}
	@And ("The user logs in with invalid user ID")
	public void The_user_logs_in_with_invalid_user_ID(){
		loginPage.logIn("invalidUserID", "password");
	}
	@And ("The user logs in with invalid password")
	public void The_user_logs_in_with_invalid_password(){
		loginPage.logIn("username", "Invalid password");
	}
	@And ("The user logs in with wrong credentials")
	public void The_user_logs_in_with_wrong_credentials(){
		loginPage.logIn("xxxxx", "xxx123");
	}

}
