package tests.estore.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EstoreOrderReviewStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    EstoreAbstractStepDefs estoreAbstractStepDefs = new EstoreAbstractStepDefs();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreItemPage estoreItemPage = new EstoreItemPage();


    @When("I click on estore edit payment button on order review page")
    public void iClickOnEstoreEditPaymentButtonOnOrderReviewPage() {
        $(By.xpath("(//*[text()='Edit'])[3]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[text()='Edit'])[3]")).click();
    }

    @Then("I verify that payment has been changed")
    public void iVerifyThatPaymentHasBeenChanged() {
        $(By.xpath("//*[text()='7543']")).should(visible,Duration.ofSeconds(20));
    }
}
