package tests.estore.stepdefinitions;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreSearchScreen;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class EstorePgStepDefs {

    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();

    @Then("I validate {string},{string} and {string} grid view should work")
    public void iValidateAndGridViewShouldWork(String arg0, String arg1, String arg2) {
        if (arg2.equals(3)) {
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().click();
            estoreSearchScreen.getThreeColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
        }
        if (arg1.equals("2")) {
            estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
        }
        if (arg0.equals("1")) {
            estoreSearchScreen.getOneColumnInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getOneColumnInRowGridButton().click();
        }
    }


    @Then("I verify that two grids are default view in PG")
    public void iVerifyThatTwoGridsAreDefaultViewInPG() {
        estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
    }

}
