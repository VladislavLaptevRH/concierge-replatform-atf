package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreLoginPage;
import tests.estore.pageObject.EstoreUserAccountPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstoreContractTradeStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();

    @Then("I verify that contract paragraph is displayed")
    public void iVerifyThatContractParagraphIsDisplayed() {
        estoreUserAccountPage.getDashboardTitle().should(Condition.visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getDashboardTitle().shouldHave(Condition.text("CONTRACT ACCOUNT SIGN IN"), Duration.ofSeconds(20));
        estoreLoginPage.getParagraphContent().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify that logout from contract user is displayed")
    public void iVerifyThatLogoutFromContractUserIsDisplayed() {
        estoreLoginPage.getLogoutFromContractUser().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on bed")
    public void iClickOnBed() {
        $(By.xpath("//*[text()='Bed']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bed']")).click();
    }

    @When("I click on beds")
    public void iClickOnBeds() {
        $(By.xpath("//*[text()='Beds']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Beds']")).click();
    }

    @Then("I verify that the dropdown's are enabled")
    public void iVerifyThatTheDropdownSAreEnabled() {
        $(By.xpath("//*[text()='Bedroom Collections']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I go to TN brand")
    public void iGoToTNBrand() {
        $(By.xpath("//a[@data-testid='brand-link']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//a[@data-testid='brand-link']")).click();
        $(By.xpath("//li[@data-analytics-url='https://rhteen." + Hooks.profile + ".rhnonprod.com/']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//li[@data-analytics-url='https://rhteen." + Hooks.profile + ".rhnonprod.com/']")).click();
    }

    @Then("I verify that trade paragraph is displayed")
    public void iVerifyThatTradeParagraphIsDisplayed() {
        estoreUserAccountPage.getDashboardTitle().should(Condition.visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getDashboardTitle().shouldHave(Condition.text("TRADE PROGRAM SIGN IN"), Duration.ofSeconds(20));
        estoreLoginPage.getParagraphContentTrade().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify that logout from trade user is displayed")
    public void iVerifyThatLogoutFromTradeUserIsDisplayed() {
        estoreLoginPage.getLogoutFromTradeUser().should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that trade price is used for each B&C product")
    public void iVerifyThatTradePriceIsUsedForEachBCProduct() {
        $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
    }

    @When("I click on confirm button from pop up zip code")
    public void iClickOnConfirmButtonFromPopUpZipCode() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='CONFIRM']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='CONFIRM']")).click();
    }
}