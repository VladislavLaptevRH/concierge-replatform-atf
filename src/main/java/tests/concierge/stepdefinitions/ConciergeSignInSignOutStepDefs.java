package tests.concierge.stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConciergeSignInSignOutStepDefs {


    @Then("I verify that user is logged in")
    public void iVerifyThatUserIsLoggedIn() {
        $(By.xpath("(//*[text() = 'Automation Associate'])[1]")).should(visible, Duration.ofSeconds(15));
    }


}
