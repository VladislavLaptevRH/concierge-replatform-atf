package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreUserAccountPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EstoreSignoutStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();

    @When("I click on estore sign out button")
    public void iClickOnEstoreSignOutButton() {
        estoreUserAccountPage.clickToSignOutButton();
    }

    @When("I click on confirm sign out button")
    public void iClickOnConfirmSignOutButton() {
        estoreUserAccountPage.clickToConfirmSignOutButton();
    }

    @When("I click on estore my account icon for not logged user")
    public void iClickOnEstoreMyAccountIconForNotLoggedUser() {
        $(By.xpath("//a[@data-analytics-nav='account-icon']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//a[@data-analytics-nav='account-icon']")).click();
    }

    @Then("I verify that user is completely signed out of all brands")
    public void iVerifyThatUserIsCompletelySignedOutOfAllBrands() {
        $(By.xpath("//img[@src='/auth/resources/tojme/login/rh2/img/rh-logo.svg']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on estore account after signout")
    public void iClickOnEstoreAccountAfterSignout() {
    }
}