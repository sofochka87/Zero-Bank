package com.zerobank.step_definitions;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.*;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInPositiveScenario {
	//LoginPage loginPage = new LoginPage(Driver.getDriver());

//	@Given("The user on the home page")
//	public void I_open_the_home_page() {
//		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		loginPage = new LoginPage(Driver.getDriver());
//	}
//	@Then("Home page should be displayed")
//	public void Home_page_should_be_displayed() {
//      assertTrue(Driver.getDriver().getTitle().contains("Zero - Personal Banking - Loans - Credit Cards"));
//	}
//	
//	@When("I click on sing in button")
//	public void positiveLogInTest() {
//		Driver.getDriver().findElement(By.xpath("//button[@id='signin_button']")).click();
//	}
//	
//	@Then("Sign in page should be displayed")
//	public void Sign_in_page_should_be_displayed() {
//      assertTrue(Driver.getDriver().getTitle().contains("Log in"));
//	}

//	@Then("I log in with valid credentials")
//	public void I_log_in_with_valid_credentials() {
//		loginPage.logIn("username", "password");
//	}
//	@And("Account activity page should be displayed")
//	public void Account_activity_page_should_be_displayed() {
//		assertTrue(Driver.getDriver().getTitle().contains("Account"));
//	}

//	@After
//	public void closure(){	
//		Driver.getDriver().quit();
//	}
}
