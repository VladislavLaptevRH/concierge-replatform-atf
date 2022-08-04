package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreItemPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class EstoreProjectStepDefs {
    EstoreItemPage estoreItemPage = new EstoreItemPage();

    // Fix DuplicateStepDefinitionException - change the steps names so they uniqe from concierge step definition

  /*  @When("I click on aggree&add estore button")
    public void iClickOnAggreeAddButton() {
        try {
            estoreItemPage.getAggreeeAndAddToCardButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            estoreItemPage.getAggreeeAndAddToCardButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Agree&add to cart button is not displayed");
        }
    }*/
}
