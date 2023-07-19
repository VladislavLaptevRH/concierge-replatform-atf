package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/features/"}
        , glue = {"tests"}
        , plugin = {"usage", "json:target/cucumber-reports/Cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

        tags = "@concierge-All" +
                " or @concierge-Cart or @concierge-Client or @concierge-Contract or @concierge-EndToEnd or " +
                "@concierge-GiftCard or @concierge-HomePage or @concierge-OrderReview or @concierge-Payment or " +
                "@concierge-PDP or @concierge-Project or @concierge-Registry or @concierge-Sale or " +
                "@concierge-ThankYouPage or @concierge-Trade or @concierge-OrderHistory"
)

public class ConciergeTestRun extends AbstractTestNGCucumberTests {

}


