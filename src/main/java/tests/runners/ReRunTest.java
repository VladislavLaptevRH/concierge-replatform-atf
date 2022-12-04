package tests.runners;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        monochrome = true,
        features = {"@target/rerun.txt"}
        , glue = {"tests"}
        , plugin = {"usage", "html:target/cucumber-html-report/Rerun.html"}
)

public class ReRunTest extends AbstractTestNGCucumberTests  {

}
