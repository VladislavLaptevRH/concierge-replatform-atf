package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/features/"}
        , glue = {"tests"}
        , plugin = {"usage", "json:target/cucumber-reports/Cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"},

        tags = "@estoreCriticalPath or @estoreWishlist or @estoreThankYouPage or @estorePayment or @estoreOrderReview " +
                "or @estoreMembership or @estoreHomePage or @estoreE2EFlow or @estoreContractTradePage or " +
                "@estoreCGPage or @estoreCartPage or @estoreAddressPage or @estoreRegression or @concierge-All" +
                " or @concierge-Cart or @concierge-Client or @concierge-Contract or @concierge-EndToEnd or " +
                "@concierge-GiftCard or @concierge-HomePage or @concierge-OrderReview or @concierge-Payment or " +
                "@concierge-PDP or @concierge-Project or @concierge-Registry or @concierge-Sale or " +
                "@concierge-ThankYouPage or @concierge-Trade or @concierge-OrderHistory"
)

public class RunTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}


