package com.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/features/"}
        , glue = {"com.test"}
        , plugin = {"usage", "json:target/cucumber-reports/Cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@conciergeRegression or @conciergeSmoke or @rhnonprodFilter or @eStoreRegression or @eStoreSmoke"
)

public class RunTest extends AbstractTestNGCucumberTests {

}


