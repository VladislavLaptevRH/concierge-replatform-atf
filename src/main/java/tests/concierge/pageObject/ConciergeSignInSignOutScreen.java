package tests.concierge.pageObject;

import com.codeborne.selenide.WebDriverRunner;
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

public class ConciergeSignInSignOutScreen {

    @Then("I click {string} on signIn signOut screen")
    public void iClickOnSignInSignOutScreen(String button) {
        switch (button) {
            case "on Associate Name":
                $(By.xpath("(//*[text() = 'Automation Associate'])[1]")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[text() = 'Automation Associate'])[1]")).click();
                break;
            case "on sign out button":
                $(By.xpath("//*[text() = 'SIGN OUT']")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'SIGN OUT']")).click();
                break;
            default: break;
        }
    }

    @Then("I verify that {string} on signIn signOut screen")
    public void iVerifyThatSignInSignOutScreen(String data) {
        switch (data) {
            case "user is able to sign out":
                $(By.xpath("//button[@class = 'login-form__submit']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            default: break;
        }
    }
}
