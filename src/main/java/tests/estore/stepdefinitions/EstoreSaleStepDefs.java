package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreCGScreen;
import tests.estore.pageObject.EstoreSaleScreen;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class EstoreSaleStepDefs {

    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();

    @When("I click on estore sale button")
    public void iClickOnEstoreSaleButton() {
        estoreSaleScreen.getSaleButtonMenu().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleButtonMenu().click();
    }

    @Then("I verify that I'm able to navigate different category")
    public void iVerifyThatIMAbleToNavigateDifferentCategory() {
        estoreSaleScreen.getSaleCategoryButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleCategoryButton().click();
        estoreSaleScreen.getSofasButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSofasButton().click();

        estoreSaleScreen.getSofasButton().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify sale category for estore")
    public void iVerifySaleCategoryForEstore() {
        estoreSaleScreen.getSaleLivingCategory().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleDiningCategory().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getBedLivingCategory().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getTextilesSaleCategory().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify the back button from sale PDP page")
    public void iVerifyTheBackButtonFromSalePDPPage() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        estoreCGScreen.getBackToTopButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();
    }
}
