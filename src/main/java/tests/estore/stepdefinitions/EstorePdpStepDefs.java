package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.EstoreCartPage;
import tests.estore.pageObject.EstoreHomePage;
import tests.estore.pageObject.EstorePGScreen;
import tests.estore.pageObject.EstorePdpPageScreen;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class EstorePdpStepDefs {

    EstorePdpPageScreen estorePdpPageScreen = new EstorePdpPageScreen();

    EstoreCartPage estoreCartPage = new EstoreCartPage();

    EstoreHomePage estoreHomePage = new EstoreHomePage();

    EstorePGScreen estorePGScreen = new EstorePGScreen();

    @Then("I verify that user can see product details correctly mentioned for a product")
    public void iVerifyThatUserCanSeeProductDetailsCorrectlyMentionedForAProduct() {
        $(By.xpath("//*[text()='DETAILS']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='DETAILS']")).click();
        $(By.xpath("//*[text()='Loomed to a rich 802 grams per square meter']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Made of the finest 100% cotton terry cloth from Turkey']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bath sheets and towels are luxuriously oversized for enveloping comfort']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bath sheets, bath towels and hand towels may be monogrammed; placement will be front and center, just above the dobby']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Add a 1-initial or 3-initial monogram with choice of font color and style; choose Tone-on-Tone color option to match towel color']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Personalized items may not be returned and are not eligible for expedited shipping']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Care']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify user can see the correct price for hero image product and the line items")
    public void iVerifyUserCanSeeTheCorrectPriceForHeroImageProductAndTheLineItems() {
        estorePdpPageScreen.getMemberPrice().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getRegularPrice().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify view In-stock options")
    public void iVerifyViewInStockOptions() {
        estorePdpPageScreen.getInStockOptionsButton().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getInStockOptionsButton().click();
        estorePdpPageScreen.getInStockTitle().should(Condition.visible, Duration.ofSeconds(20));

        estorePdpPageScreen.getTurkishTowelCollectionTitle().should(Condition.and("", interactable, visible), Duration.ofSeconds(20));
        estorePdpPageScreen.getItemInStockOption().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getSizeInStockOption().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getColorInStockOption().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify Details, Dimensions and Fabric")
    public void iVerifyDetailsDimensionsAndFabric() {
        estorePdpPageScreen.getDetailsButton().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getDetailsButton().click();
        $(By.xpath("//*[text()='Made of the finest 100% cotton terry cloth from Turkey']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Personalized items may not be returned and are not eligible for expedited shipping']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Care']")).should(visible, Duration.ofSeconds(20));

        estorePdpPageScreen.getDimensionsButton().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getDimensionsButton().click();
        $(By.xpath("(//*[contains(text(),'Bath Sheet')])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[contains(text(),'Hand Towel')])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[contains(text(),'Bath Towel')])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//*[contains(text(),'Washcloth')])[1]")).should(visible, Duration.ofSeconds(20));
    }

    @Then("verify the product price as per the postal code")
    public void verifyTheProductPriceAsPerThePostalCode() {
        estorePdpPageScreen.getRegularTheFirstPrice().shouldHave(text("$29"), Duration.ofSeconds(60));
        estorePdpPageScreen.getRegularTheSecondPrice().shouldHave(text("$55"), Duration.ofSeconds(60));
    }

    @Then("I verify that price for product&line should be in US dollars on PDP page")
    public void iVerifyThatPriceForProductLineShouldBeInUS$() {
        $(By.xpath("(//*[contains(text(),'$')])[3]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I update {string} postal code on pdp page")
    public void iUpdatePostalCodeOnPdpPage(String country) {
        estorePdpPageScreen.getPostalCodePdp().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getPostalCodePdp().scrollIntoView(true);
        estorePdpPageScreen.getPostalCodePdp().click();
        $(By.xpath("//div[@id='country-zipcode-selection']")).should(visible, Duration.ofSeconds(20)).click();
        if (country.equals("CAN")) {
            $(By.xpath("//li[@data-value='CA']")).should(visible, Duration.ofSeconds(20)).click();
            $(By.xpath("//input[@id='postal-code-international']")).clear();
            $(By.xpath("//input[@id='postal-code-international']")).setValue("Y1A 9Z9");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(20));
            estorePdpPageScreen.getSubmitPostalCode().click();
            estorePdpPageScreen.getConfirmChangeButton().should(visible, Duration.ofSeconds(40)).click();
        }
        if (country.equals("US")) {
            $(By.xpath("//li[@data-value='US']")).should(visible, Duration.ofSeconds(20)).click();
            $(By.xpath("//input[@id='postal-code-international']")).clear();
            $(By.xpath("//input[@id='postal-code-international']")).setValue("82083");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(20));
            estorePdpPageScreen.getSubmitPostalCode().click();
        }

//        if (estorePdpPageScreen.getConfirmChangeButton().isDisplayed()) {
//        }
    }

    @Then("I verify line items {string}")
    public void iVerifyLineItems(String functional) {
        if (functional.equals("lineitemimage")) {
            estorePdpPageScreen.getLineItemImage().should(visible, Duration.ofSeconds(30));
        }
        if (functional.equals("customizeanproduct")) {
            estorePdpPageScreen.getSizeOption().should(visible, Duration.ofSeconds(20)).scrollIntoView(true);
            estorePdpPageScreen.getSizeOption().should(interactable, Duration.ofSeconds(20));
            Select selectSize = new Select(estorePdpPageScreen.getSizeOption());
            selectSize.selectByIndex(2);
            Select selectColor = new Select(estorePdpPageScreen.getColorOption());
            selectColor.selectByIndex(2);
        }
        if (functional.equals("addtowishlist")) {
            estoreCartPage.getAddToWishlistButton().should(visible, Duration.ofSeconds(20)).scrollIntoView(true);
            estoreCartPage.getAddToWishlistButton().should(interactable, Duration.ofSeconds(20)).click();
        }
        if (functional.equals("locationfunctionality")) {
            estorePdpPageScreen.getPostalCodePdp().should(visible, Duration.ofSeconds(30));
        }
    }

    @Then("I verify the sku for single and multiple ids")
    public void iVerifyTheSkuForSingleAndMultipleIds() {
        estorePdpPageScreen.getColorOption().should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getColorOption().scrollIntoView(true).should(visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getSizeOption().should(Condition.and("", visible, interactable), Duration.ofSeconds(20));

        Select selectColor = new Select(estorePdpPageScreen.getColorOption());
        selectColor.selectByIndex(3);
        estorePdpPageScreen.getColorOption().should(Condition.and("", visible, interactable), Duration.ofSeconds(20));
        sleep(3000);
        Select selectSize = new Select(estorePdpPageScreen.getSizeOption());
        selectSize.selectByIndex(3);

        estorePdpPageScreen.getSkuIdValue().shouldHave(text("Item# 17050042 CAML"), Duration.ofSeconds(30));
    }

    @Then("I verify that PDP screen is displayed")
    public void iVerifyThatPDPScreenIsDisplayed() {
        $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[2]")).should(visible, Duration.ofSeconds(30));
    }

    @And("I verify the browser back")
    public void iVerifyTheBrowserBack() {
        WebDriverRunner.getWebDriver().navigate().back();
        WebDriverRunner.getWebDriver().getCurrentUrl().equals("https://stg2.rhnonprod.com/us/en/");
        estoreHomePage.getHomePageLogo().should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify the browser forwards button")
    public void iVerifyTheBrowserForwardsButton() {
        WebDriverRunner.getWebDriver().navigate().forward();
        $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[2]")).should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify the search icon functionality")
    public void iVerifyTheSearchIconFunctionality() {
        estorePGScreen.getInStockFilter().should(visible, Duration.ofSeconds(30));
        estorePGScreen.getSofa().should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify the product price for the selected country")
    public void iVerifyTheProductPriceForTheSelectedCountry() {
        estorePdpPageScreen.getRegularTheFirstPrice().shouldHave(text("$29"), Duration.ofSeconds(30));
        estorePdpPageScreen.getMemberTheFirstPrice().shouldHave(text("$16"), Duration.ofSeconds(30));
    }

    @Then("I verify the product price on PDP for non-sale cushion and frame product")
    public void iVerifyTheProductPriceOnPDPForNonSaleCushionAndFrameProduct() {
        estorePdpPageScreen.getRegularTheFirstPrice().shouldHave(text("$19"), Duration.ofSeconds(30));
        estorePdpPageScreen.getMemberTheFirstPrice().shouldHave(text("$11"), Duration.ofSeconds(30));
        estorePdpPageScreen.getMemberTheSecondPrice().shouldHave(text("$27"), Duration.ofSeconds(30));
        estorePdpPageScreen.getRegularTheSecondPrice().shouldHave(text("$36"), Duration.ofSeconds(30));
    }

    @When("I update {string} postal code on cart page")
    public void iUpdatePostalCodeOnPDPPage(String zipCode) {
        estoreCartPage.getPostalCodeButton().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getPostalCodeButton().scrollIntoView(true);
        estoreCartPage.getPostalCodeButton().click();
        estorePdpPageScreen.getCountryZipCodeSelection().click();
        if (zipCode.equals("US")) {
            $(By.xpath("//li[@data-value='US']")).should(visible, Duration.ofSeconds(20)).click();
            estorePdpPageScreen.getPostalCodeField().should(visible, Duration.ofSeconds(20)).sendKeys("88989");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(25)).click();
        }
        if (zipCode.equals("CA")) {
            $(By.xpath("//li[@data-value='CA']")).should(visible, Duration.ofSeconds(20)).click();
            estorePdpPageScreen.getPostalCodeField().should(visible, Duration.ofSeconds(20)).sendKeys("Y1A 9Z9");
            estorePdpPageScreen.getSubmitPostalCode().should(visible, Duration.ofSeconds(25)).click();
            $(By.xpath("//*[text()='CONFIRM CHANGE']")).should(interactable, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='CONFIRM CHANGE']")).should(visible, Duration.ofSeconds(20)).click();
        }
    }

    @Then("I verify that price is showing for regular and member user")
    public void iVerifyThatPriceIsShowingForRegularUser() {
        estorePdpPageScreen.getMemberPrice().should(Condition.visible, Duration.ofSeconds(20));
        estorePdpPageScreen.getRegularPrice().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify that price for {string} and {string} with {string} was updated for {string}")
    public void iVerifyThatPriceForAndWithWasUpdatedFor(String arg0, String arg1, String arg2, String arg3) {
        if (arg3.equals("CAN") && (arg0.equals("prod2020027"))) {
            $(By.xpath("//*[text()='$55']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='$41']")).should(visible, Duration.ofSeconds(20));
        }
    }

    @When("I unselect the size option for {string} and {string} with {string} for estore")
    public void iUnselectTheSizeOptionForAndWithForEstore(String prodId, String arg1, String arg2) {
        Select sizeOption = new Select($(By.xpath("//select[@id='optionSelect-" + prodId + "-Size']")));
        sizeOption.selectByValue("");
    }

    @Then("I verify availability , delivery and return messages in PDP")
    public void iVerifyAvailabilityDeliveryAndReturnMessagesInPDP() {
        $(By.xpath("//*[text()='This item will be delivered on or before 01/26/24 ']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Ships free of charge via Standard Delivery Shipping']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='This item can be returned within 30 days of delivery.']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify link bellow {string} is displayed")
    public void iVerifyLinkBellowIsDisplayed(String arg0) {
        $(By.xpath("(//span[text()='In-Stock' and text()='View' and 'items'])[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//span[text()='View' and 'Sale' and 'items'])[3]")).should(visible, Duration.ofSeconds(20));
    }
}
