package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreItemPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class EstoreProjectStepDefs {
    EstoreItemPage estoreItemPage = new EstoreItemPage();

    // Fix DuplicateStepDefinitionException - change the steps names so they uniqe from concierge step definition

    @When("I click on aggree&add estore button")
    public void iClickOnAggreeAddButton() {
        estoreItemPage.getAggreeeAndAddToCardButton().should(Condition.and("", visible, interactable), Duration.ofSeconds(12));
        estoreItemPage.getAggreeeAndAddToCardButton().scrollIntoView(true).should(interactable).click();
    }
}