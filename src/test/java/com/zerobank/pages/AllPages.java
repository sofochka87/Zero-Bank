package com.zerobank.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AllPages {

	public AllPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id='account_summary_tab']/a")
	public WebElement accSummary;
	
	@FindBy(xpath = "//li[@id='account_activity_tab']/a")
	public WebElement accActivity;
	
	@FindBy(xpath = "//li[@id='transfer_funds_tab']")
	public WebElement transFunds;
	
	@FindBy(xpath = "//li[@id='pay_bills_tab']")
	public WebElement payBillsTab;
	
	@FindBy(xpath = "//li[@id='money_map_tab']")
	public WebElement moneyMap;
	
	@FindBy(xpath = "//li[@id='online_statements_tab']") 
	public WebElement statements;
	
//	@FindBy(xpath = "//ul[@class='nav nav-tabs']/li")
//		 public List<WebElement> activity;
	
	
	
	public void logOut() {
		//logOutLink.click();
	}
	
}
