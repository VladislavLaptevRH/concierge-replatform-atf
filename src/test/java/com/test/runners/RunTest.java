package com.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features/accessibility"}
        ,glue = {"com.test"}
        ,plugin = {"usage", "json:target/cucumber-reports/Cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunTest extends AbstractTestNGCucumberTests {

}


