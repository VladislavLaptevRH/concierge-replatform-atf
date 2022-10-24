package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/features/"}
        , glue = {"tests"}
        , plugin = {"usage", "json:target/cucumber-reports/Cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@estoreWishlist or @estoreThankYouPage or @estorePayment or @estoreOrderReview or @estoreMembership or @estoreHomePage or @estoreE2EFlow or @estoreContractTradePage or @estoreCGPage or @estoreCartPage or @estoreAddressPage or @conciergeRegression or @estoreRegression or @conciergeCartProductionTests or @conciergeHomePageProductionTest or @conciergePDPProductionTests"
)

public class RunTest extends AbstractTestNGCucumberTests {

}


