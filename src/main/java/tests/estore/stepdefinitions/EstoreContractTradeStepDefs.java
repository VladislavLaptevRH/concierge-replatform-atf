package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreLoginPage;
import tests.estore.pageObject.EstorePdpPageScreen;
import tests.estore.pageObject.EstoreUserAccountPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class EstoreContractTradeStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();
    EstorePdpPageScreen estorePdpPageScreen = new EstorePdpPageScreen();

    @Then("I verify that contract paragraph is displayed")
    public void iVerifyThatContractParagraphIsDisplayed() {
        estoreUserAccountPage.getDashboardTitle().should(Condition.visible, Duration.ofSeconds(35));
        estoreUserAccountPage.getDashboardTitle().shouldHave(Condition.text("CONTRACT ACCOUNT SIGN IN"), Duration.ofSeconds(20));
        estoreLoginPage.getParagraphContent().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify that logout from contract user is displayed")
    public void iVerifyThatLogoutFromContractUserIsDisplayed() {
        estoreLoginPage.getLogoutFromContractUser().should(Condition.visible, Duration.ofSeconds(20));
    }

    @When("I click on bed")
    public void iClickOnBed() {
        $(By.xpath("//*[text()='Bed']")).should(interactable, Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", $(By.xpath("//*[text()='Bed']")));
    }

    @When("I click on beds")
    public void iClickOnBeds() {
        $(By.xpath("//*[text()='Beds']")).should(interactable, Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", $(By.xpath("//*[text()='Beds']")));
    }

    @Then("I verify that the dropdown's are enabled")
    public void iVerifyThatTheDropdownSAreEnabled() {
        $(By.xpath("//*[text()='Bedroom Collections']")).should(interactable, Duration.ofSeconds(20));
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
        estoreUserAccountPage.getDashboardTitle().should(Condition.visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getDashboardTitle().shouldHave(Condition.text("TRADE PROGRAM SIGN IN"), Duration.ofSeconds(20));
        estoreLoginPage.getParagraphContentTrade().should(Condition.visible, Duration.ofSeconds(40));
    }

    @And("I verify that logout from trade user is displayed")
    public void iVerifyThatLogoutFromTradeUserIsDisplayed() {
        estoreLoginPage.getLogoutFromTradeUser().should(visible, Duration.ofSeconds(40));
    }

    @When("I click on confirm button from pop up zip code")
    public void iClickOnConfirmButtonFromPopUpZipCode() {

        $(By.xpath("//*[text()='CONFIRM']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='CONFIRM']")).click();
        $(By.xpath("//*[text()='CONFIRM CHANGE']")).should(interactable, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='CONFIRM CHANGE']")).should(visible, Duration.ofSeconds(20)).click();
    }

    @Then("I verify that currency should be in US dollar")
    public void iVerifyThatCurrencyShouldBeInUSDollar() {
        estorePdpPageScreen.getDollarSign().should(visible, Duration.ofSeconds(30));
    }

    @When("I choose zip code in cart to {string}")
    public void iChooseZipCodeInCartToUS(String country) {
        if (country.equals("US")) {
            estorePdpPageScreen.getPostalCodeField().should(visible, Duration.ofSeconds(30)).sendKeys("67021");
        }
        if (country.equals("CAN")) {
            estorePdpPageScreen.getPostalCodeField().should(visible, Duration.ofSeconds(30)).sendKeys("B3K 5X5");
        }
        estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(30)).click();
    }

    @Then("I verify that {string} price is used for each {string} product")
    public void iVerifyThatPriceIsUsedForEachProduct(String account, String brand) {
        if (account.equals("contract")) {
            $(By.xpath("//*[text()='Contract']")).should(visible, Duration.ofSeconds(30));
        }
        if (account.equals("trade")) {
            $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
        }
    }


    @Then("I verify the subtotal, shipping fee, taxes based on postal code")
    public void iVerifyTheSubtotalShippingFeeTaxesBasedOnPostalCode() {
        $(By.xpath("//*[text()='Subtotal ']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Standard Delivery Shipping']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Estimated Sales Tax for 19701']")).shouldNotBe(visible, Duration.ofSeconds(20));

    }
}