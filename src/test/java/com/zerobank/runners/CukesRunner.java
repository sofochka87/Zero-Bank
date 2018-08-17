package com.zerobank.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports", //generates every time we run the cukes runner
				"json:target/cucumber.json"
		},
		features = "src/test/resources/com/zeroBank/features",
		glue = "com/zerobank/step_definitions"
)
public class CukesRunner {
}