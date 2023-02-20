package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreGuestHouseScreen;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;


public class EstoreGuestHouseStepDefs {
    EstoreGuestHouseScreen estoreGuestHouseScreen = new EstoreGuestHouseScreen();

    @Given("I go to estore guesthouse home page")
    public void iGoToEstoreGuesthouseHomePage() {
        open("https://stg2-rhguesthouse.rhnonprod.com/");
    }

    @When("I click on the estore guesthouse dining room page")
    public void iClickOnTheEstoreGuesthouseDiningRoomPage() {
        estoreGuestHouseScreen.getDiningRoomGuestHouse().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getDiningRoomGuestHouse().click();
    }

    @Then("I verify that estore guesthouse dining room page is accessible")
    public void iVerifyThatEstoreGuesthouseDiningRoomPageIsAccessible() {
        estoreGuestHouseScreen.getDiningRoomTeraceTitle().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getBreakfast().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getBrunch().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getLunch().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getDinner().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getWineList().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on the estore Champagne Caviar bar page")
    public void iClickOnTheEstoreChampagneCaviarBarPage() {
        estoreGuestHouseScreen.getCaviarBar().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getCaviarBar().click();
    }

    @Then("I verify that estore Champagne Caviar bar page is displayed")
    public void iVerifyThatEstoreChampagneCaviarBarPageIsDisplayed() {
        estoreGuestHouseScreen.getChampageCaviarBarTitle().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getChampageCaviarBarMenu().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getChampageReservations().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on estore guest rooms suites page")
    public void iClickOnEstoreGuestRoomsSuitesPage() {
        estoreGuestHouseScreen.getGuestRoomsSuites().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getGuestRoomsSuites().click();
    }

    @Then("I verify that estore guesthouse rooms suites page is displayed")
    public void iVerifyThatEstoreGuesthouseRoomsSuitesPageIsDisplayed() {
        estoreGuestHouseScreen.getGuestRoomsText().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getGuestRoomsSuites().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getTheResidenceText().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on estore guesthouse rooftop pool page")
    public void iClickOnEstoreGuesthouseRooftopPoolPage() {
        estoreGuestHouseScreen.getGuestRooftopPool().should(Condition.visible, Duration.ofSeconds(20));
        estoreGuestHouseScreen.getGuestRooftopPool().click();
    }

    @Then("I verify that estore guesthouse rooftop pool page is displayed")
    public void iVerifyThatEstoreGuesthouseRooftopPoolPageIsDisplayed() {
        estoreGuestHouseScreen.getPrivateRooftopPoolText().should(Condition.visible, Duration.ofSeconds(20));
    }
}
