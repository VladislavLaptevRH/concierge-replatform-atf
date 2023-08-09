package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/features/"}
        , glue = {"tests"}
        , plugin = {"usage", "json:target/cucumber-reports/Cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,

        tags = "@estoreTestRun"
)

public class RunTest extends AbstractTestNGCucumberTests {


}