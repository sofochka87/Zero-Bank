package com.zerobank.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zerobank.pages.AllPages;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LabelVerifications {

	LoginPage loginPage = new LoginPage(Driver.getDriver());
	AllPages allPages = new AllPages(Driver.getDriver());

	@Given("The user on the home page")
	public void The_user_on_the_home_page() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("Home page should be displayed")
	public void Home_page_should_be_displayed() {
		assertTrue(Driver.getDriver().getTitle().contains("Zero - Personal Banking - Loans - Credit Cards"));
	}
	@When("The user clicks on sing in button")
	public void The_user_clicks_on_sing_in_button() {
		loginPage.signInButton.click();
	}

	@Then("Sign in page should be displayed")
	public void Sign_in_page_should_be_displayed() {
		assertTrue(Driver.getDriver().getTitle().contains("Log in"));
	}
	@When("The user logs in with valid credentials")
	public void The_user_logs_in_with_valid_credentials(){
		loginPage.logIn(ConfigurationReader.getProperty("username"), 
				ConfigurationReader.getProperty("password"));
	}

	@Then("Account activity page should be displayed")
	public void Account_activity_page_should_be_displayed() {
		assertTrue(Driver.getDriver().getTitle().contains("Account"));
	}
	
    @Then("Verifying all tab labels")
	public void Verifying_all_tab_labels() {
		List<WebElement> activityTabs = Arrays.asList(
				allPages.accSummary, allPages.accActivity, 
				allPages.transFunds,allPages.payBillsTab,
				allPages.moneyMap, allPages.statements);
		List<String> expectedList = Arrays.asList(
				"Account Summary", "Account Activity", 
				"Transfer Funds", "Pay Bills",
				"My Money Map", "Online Statements");
		List<String> actualList = new ArrayList<>();
		activityTabs.forEach(tab -> {
			tab.click();
			actualList.add(tab.getText());
			assertTrue(Driver.getDriver().getTitle().contains(tab.getText()));
		});
		System.out.println(actualList);
		assertEquals(actualList, expectedList);
	}
    
    @Then("The user log out")
	public void The_user_log_out() {
    	Driver.getDriver().findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
    	Driver.getDriver().findElement(By.xpath("//*[@id=\"logout_link\"]")).click();
	}

//	@After
//	public void tearDown() {
//		Driver.getDriver().quit();
//	}

}
