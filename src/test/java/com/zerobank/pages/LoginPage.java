package com.zerobank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		// using the driver initialize or locate all elements in this class
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[@id=\"signin_button\"]")
	public WebElement signInButton;
	
	@FindBy(xpath="//*[@id=\"onlineBankingMenu\"]/div/strong")
	public WebElement bankingMenu;
	
	@FindBy(xpath="//*[@id=\"account_summary_link\"]")
	public WebElement accActivity;

	// Using @FindBy specify a way to locate the WE
	@FindBy(xpath = "//input[@id='user_login']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//input[@name ='submit']")
	public WebElement submitButton;

	
	public void logIn(String uid, String pwd){
		userName.sendKeys(uid);
		password.sendKeys(pwd);
		submitButton.click();
	}

}
