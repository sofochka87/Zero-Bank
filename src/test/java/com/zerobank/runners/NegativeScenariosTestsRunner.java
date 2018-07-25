package com.zerobank.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@negativeScenarios",
		features = "src/test/resources/com/zeroBank/features",
		glue = "com/zerobank/step_definitions"
)
public class NegativeScenariosTestsRunner {
}