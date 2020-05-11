package com.shopping.demo.Run;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/shopping/feature", dryRun = false,
			glue = {"classpath:com.shopping.demo.StepDefinition"}, monochrome = true,
			plugin ="json:target/jsonReports/cucumber-report.json")
public class Runner{

}
