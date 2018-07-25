package com.zerobank.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

public class TestBase {
	protected WebDriver driver;
	Actions actions;

	protected ExtentReports report;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentTest extentLogger;

	@BeforeTest
	public void setUpTest() {
		
		report = new ExtentReports();

		/* System.getProperty("user.dir") --> get the path to current project */
		/*
		 * TEST-OUTPUT REPORT.HTML--> name of the report file
		 */
		// C:\Users\pizza\eclipse-workspace\final-testng-framework\test-output
		String filePath = System.getProperty("user.dir") + "/test-output/report.html";
		htmlReporter = new ExtentHtmlReporter(filePath);
		report.attachReporter(htmlReporter);
		report.setSystemInfo("ENVIRONMENT", "STAGING");
		report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));
		// report.setSystemInfo("OS", System.getProperty(""));
		htmlReporter.config().setReportName("Web Orders Automated Test Reports");

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();

		driver.get(ConfigurationReader.getProperty("url"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		
		//checking if the test method failed.
		if (result.getStatus() == ITestResult.FAILURE) {
			
			//get screenShot using the utility method and save the location of the screenshot
			String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
			//it captures the name of the test method
			extentLogger.fail(result.getName());
			
			//captures the exception thrown
			extentLogger.fail(result.getThrowable());
			
            //add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            
			//capture the exception thrown
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test Case Skipped is " + result.getName());
		}
		Driver.closeDriver();
	}


	@AfterTest
	public void tearDownTest() {
		report.flush();
	}

}

