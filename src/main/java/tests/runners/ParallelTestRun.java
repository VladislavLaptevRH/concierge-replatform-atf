package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/features/"}
        , glue = {"tests"}
        , plugin = {"usage", "json:target/cucumber-reports/Cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,

        tags = "@estoreParallelTestRun"
)

public class ParallelTestRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}