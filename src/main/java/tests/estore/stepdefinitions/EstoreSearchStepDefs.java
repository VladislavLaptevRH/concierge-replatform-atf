package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreCGScreen;
import tests.estore.pageObject.EstoreUserAccountPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EstoreSearchStepDefs {
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();

    @Then("I verify that search result for search product via product name is displayed")
    public void iVerifyThatSearchResultForSearchProductViaProductNameIsDisplayed() {
        $(By.xpath("//*[text()='802-GRAM TURKISH TOWEL COLLECTION']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I introduced random text for search field")
    public void iIntroducedRandomTextForSearchField() {
        generalStepDefs.waitForJSandJQueryToLoad();
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[2]")).should(visible, Duration.ofSeconds(60));
        $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[2]")).click();
        estoreUserAccountPage.getSearchItemField().should(Condition.and("", visible, enabled), Duration.ofSeconds(40));
        estoreUserAccountPage.getSearchItemField().should(empty, Duration.ofMinutes(1));
        estoreUserAccountPage.getSearchItemField().click();
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(3000);
        estoreUserAccountPage.getSearchItemField().setValue(generalStepDefs.getAlphaNumericString(7));

        $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSecondary']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSecondary']")).click();

    }

    @Then("I verify that we cannot find what you are looking message is not displayed")
    public void iVerifyThatWeCannotFindWhatYouAreLookingMessageIsNotDisplayed() {
        $(By.xpath("//*[text()='We’re sorry, we cannot find what you are looking for.']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify count of search results")
    public void iVerifyCountOfSearchResults() {
        $(By.xpath("//*[text()='156']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I scroll to the bottom of the estore page")
    public void iScrollToTheBottomOfTheEstorePage() {
        sleep(3000);
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    @When("I click on estore back to top button")
    public void iClickOnEstoreBackToTopButton() {
        estoreCGScreen.getBackToTopButton().should(visible, Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();
    }

    @Then("I verify that search results for {string} is displayed")
    public void iVerifyThatSearchResultsForIsDisplayed(String arg0) {
        $(By.xpath("//*[text()='" + arg0 + "']")).should(visible, Duration.ofSeconds(20));
    }
}
