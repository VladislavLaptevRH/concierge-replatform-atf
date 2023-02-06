package tests.concierge.stepdefinitions;

import tests.concierge.pageObject.ConciergeItemsScreen;
import tests.concierge.pageObject.GiftCardEnquiryScreen;
import tests.concierge.pageObject.PdpScreen;
import tests.concierge.pageObject.SelectOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.*;

public class GiftCardEnquiryStepDefs {

    GiftCardEnquiryScreen giftCardEnquiryScreen = new GiftCardEnquiryScreen();
    PdpScreen productPageScreen = new PdpScreen();
    SelectOption selectOption = new SelectOption();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();


    @When("I click on gift card enquiry")
    public  void iClickOnGiftCardEnquiry() {
        giftCardEnquiryScreen.getGiftCardEnquiry().should(visible, Duration.ofMinutes(1));
        giftCardEnquiryScreen.getGiftCardEnquiry().click();
    }

    @When ("I enter gift card information")
    public void iEnterGiftCardInformation() {
        giftCardEnquiryScreen.getCardNumberField().setValue("6006493887999901635");
        giftCardEnquiryScreen.getCardPinField().setValue("9559");
        giftCardEnquiryScreen.getSubmitButton().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
    }

    @Then("I verify transaction details")
    public void iVerifyTransactionDetails() {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList( "CARD NUMBER", "BALANCE", "DATE", "GALLERY", "CHARGE", "STATUS"));
        for (int i = 0; i < giftCardEnquiryScreen.getListOfTransactionDetailsHeading().size(); i++) {
            items.add(giftCardEnquiryScreen.getListOfTransactionDetailsHeading().get(i).getText());
        }
        assertNotEquals(giftCardEnquiryScreen.getListOfTransactions().size(), 0);
        assertEquals(items, expectedItems);
    }

    @When("I click on purchase gift card")
    public void iClickOnPurchaseGiftCard() {
        giftCardEnquiryScreen.getPurchaseCard().scrollIntoView(true);
        giftCardEnquiryScreen.getPurchaseCard().should(visible, Duration.ofMinutes(1));
        giftCardEnquiryScreen.getPurchaseCard().click();
    }

    @Then("I verify gift card PDP page is loaded")
    public void iVerifyGiftCardPDPPageIsLoaded() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        selectOption.getValueOption().scrollIntoView(true);
        selectOption.getValueOption().should(visible, Duration.ofMinutes(1));
    }

    @When("I click on agree and add to cart button")
    public void iClickOnAgreeAndAddToCartButton() {
        conciergeItemsScreen.getAgreeAndAddToCartButton().click();
    }

    @When("I select options")
    public void iSelectOptions() {
        selectOption.getValueOption().should(visible, Duration.ofMinutes(1));
        selectOption.getValueOption().click();

        selectOption.getSelectAmount().should(visible, Duration.ofMinutes(1));
        selectOption.getSelectAmount().click();

        selectOption.getToInputField().should(visible, Duration.ofMinutes(1));
        selectOption.getToInputField().setValue("John Cena");

        selectOption.getFromInputField().should(visible, Duration.ofMinutes(1));
        selectOption.getFromInputField().setValue("The Rock");

        with().pollInterval(5, SECONDS).await().until(() -> true);

        selectOption.getQuantityElement().should(visible, Duration.ofMinutes(1));
        Select selectQty = new Select(selectOption.getQuantityElement());
        selectQty.selectByIndex(2);
    }
}
