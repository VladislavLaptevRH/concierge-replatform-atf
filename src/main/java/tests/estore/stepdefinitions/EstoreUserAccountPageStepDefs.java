package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.EstoreAddressScreen;
import tests.estore.pageObject.EstorePaymentPage;
import tests.estore.pageObject.EstoreUserAccountPage;

import javax.naming.ldap.Rdn;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;

public class EstoreUserAccountPageStepDefs {
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    String additionalEmail;
    String firstName;

    @When("I go to profile payment method")
    public void iGoToProfilePaymentMethod() {
        estoreUserAccountPage.getProfileIconButton().should(Condition.visible, Duration.ofSeconds(120));
        estoreUserAccountPage.getProfileIconButton().click();
        estoreUserAccountPage.getProfileButton().shouldHave(Condition.text("PROFILE"), Duration.ofSeconds(30));
        estoreUserAccountPage.getProfileButton().click();

        estoreUserAccountPage.getMyProfileButton().shouldHave(Condition.text("My Account"), Duration.ofSeconds(30));
        estoreUserAccountPage.getMyProfileButton().click();
        estoreUserAccountPage.getPaymentMethodsButton().shouldHave(Condition.text("Payment Methods"), Duration.ofSeconds(20));
        estoreUserAccountPage.getPaymentMethodsButton().click();
    }


    @When("I add new card for estore")
    public void iAddNewCardForEstore() {
        estoreUserAccountPage.getAddCardButton().should(Condition.visible, Duration.ofSeconds(30));
        estoreUserAccountPage.getAddCardButton().click();
        estoreUserAccountPage.getSelectTypeOfCardNewCard().should(Condition.visible, Duration.ofSeconds(20));
        Select selectCard = new Select(estoreUserAccountPage.getSelectTypeOfCardNewCard());
        selectCard.selectByValue("CC");
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
        estorePaymentPage.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
        estorePaymentPage.getCvcField().setValue("737");

        switchTo().defaultContent();
        estoreUserAccountPage.getBillingAddressFirstName().setValue("TestName");
        estoreUserAccountPage.getBillingAddressLastName().setValue("TestLastName");
        estoreUserAccountPage.getBillingAddressStreetAddress().setValue("StreetAddress");
        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");
        estoreUserAccountPage.getBillingAddressCity().setValue("testCity");
        Select selectState = new Select(estoreUserAccountPage.getBillingAddressSelectState());
        selectState.selectByValue("AZ");
        estoreUserAccountPage.getBillingAddressPostalCode().setValue("12345");
        estoreUserAccountPage.getBillingAddressPhone().setValue("(555) 555-1234");
        estoreUserAccountPage.getSaveCardButton().click();
        estorePaymentPage.getContinueToCheckout().click();

    }

    @When("I update the address details")
    public void iUpdateTheAddressDetails() {
        estoreAddressScreen.getEditShippinggAddress().shouldHave(Condition.text("Edit"), Duration.ofSeconds(20));
        estoreAddressScreen.getEditShippinggAddress().click();

        estoreUserAccountPage.getSelectTypeOfCardNewCard().should(Condition.visible, Duration.ofSeconds(20));
        Select selectCard = new Select(estoreUserAccountPage.getSelectTypeOfCardNewCard());
        selectCard.selectByValue("CC");
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card number']")));
        estorePaymentPage.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card security code']")));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();

        firstName = estoreGeneralStepDefs.generateRandomString(5);
        sleep(3000);
        estoreUserAccountPage.getBillingAddressFirstName().clear();
        estoreUserAccountPage.getBillingAddressFirstName().setValue(firstName);

//        estoreUserAccountPage.getBillingAddressLastName().setValue("TestLastName");
//        estoreUserAccountPage.getBillingAddressStreetAddress().setValue("StreetAddress");
//        estoreUserAccountPage.getBillingAddressAptFloor().setValue("2");
//        estoreUserAccountPage.getBillingAddressCity().setValue("testCity");
//        Select selectState = new Select(estoreUserAccountPage.getBillingAddressSelectState());
//        selectState.selectByValue("AZ");

        $(By.xpath("//*[text()='EDIT']")).shouldHave(Condition.text("EDIT"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='EDIT']")).click();

        estorePaymentPage.getContinueToCheckout().shouldHave(Condition.text("CONTINUE"),Duration.ofSeconds(20));
        estorePaymentPage.getContinueToCheckout().click();

//        estoreUserAccountPage.getSaveCardButton().click();
//        estorePaymentPage.getContinueToCheckout().click();

    }

    @Then("I verify that it is shows new address")
    public void iVerifyThatItIsShowsNewAddress() {
        $(By.xpath("//*[contains(text(),'" + firstName + "')]")).shouldHave(Condition.text(firstName), Duration.ofSeconds(20));
    }
}
