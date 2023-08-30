package tests.concierge.stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertTrue;

public class ConciergeSignInSignOutStepDefs {


    @Then("I verify that user is logged in")
    public void iVerifyThatUserIsLoggedIn() {
        $(By.xpath("(//*[text() = 'Automation Associate'])[1]")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that {string} search screen")
    public void iVerifyThatOnSearchScreen(String data) {
        switch (data) {
            case "Grid View is present in top right":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[text() = 'sort']/../..//*[local-name() = 'svg'])[2]")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[text() = 'sort']/../..//*[local-name() = 'svg'])[2]")).should(visible, Duration.ofSeconds(15));
                break;
            default: break;
        }
    }


}
