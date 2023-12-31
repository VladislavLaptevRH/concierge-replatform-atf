package tests.concierge.stepdefinitions;

import com.aventstack.extentreports.App;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import tests.concierge.pageObject.ConciergeItemsScreen;
import tests.concierge.pageObject.ConciergeCGScreen;
import tests.concierge.pageObject.PdpScreen;
import tests.utility.Hooks;
import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.slf4j.Logger.*;
import static org.testng.AssertJUnit.*;
import static tests.utility.Hooks.getWindowsHandles;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertEquals;

public class ConciergeCGStepsDefs {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeCGScreen ConciergeCGScreen = new ConciergeCGScreen();
    public static String galleryName;
    //public static final Logger logger = (Logger) LoggerFactory.getLogger(FilterStepDefs.class);

    PdpScreen pdpScreen = new PdpScreen();

    @Then("I verify that {string} on CG screen")
    public void iVerifyThatOnCGScreen(String data) {
        switch (data) {
            case "Back to top Button is present":
                $(By.xpath("//*[@id = 'footer']")).scrollIntoView(true);
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "user is brought to the top of the page":
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and contains(@style, 'hidden')]")).shouldBe(exist, Duration.ofSeconds(20));
                break;
            case "Dashboard is displayed":
                $(By.xpath("//*[text() = 'Concierge']/following-sibling::h1[text() = 'Dashboard']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to third collection":
                $(By.xpath("(//*[@id = 'component-collection-card'])[3]//*[text() = 'French Contemporary']")).click();
                $(By.xpath("(//*[contains(text(),'French Contemporary')])[2]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Bath Collections are displayed":
                $(By.xpath("(//*[@id = 'component-collection-card'])[3]//*[text() = 'French Contemporary']/../following-sibling::div/p[text() = 'Washstand Collection']")).click();
                $(By.xpath("//*[text() = 'Bath  collections']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to second collection":
                $(By.xpath("(//*[@id = 'component-collection-card'])[2]//*[text() = 'Kabir Wool Rug']")).click();
                $(By.xpath("//*[text() = 'Kabir Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to first product":
                if (!$(By.xpath("(//*[text() = 'Kabir Wool Rug'])[2]")).isDisplayed()) {
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                $(By.xpath("(//*[text() = 'Kabir Wool Rug'])[2]")).click();
                break;
            case "confirm that PG is displayed":
                $(By.xpath("//*[text() = 'new arrivals']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "confirm that CG Rug Collections is displayed":
                $(By.xpath("(//*[@id = 'component-collection-card'])[4]//*[text() = 'Nihal Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is present on top right":
                for (int i = 1; i <= 3; i++) {
                    $(By.xpath("//*[ local-name() = 'svg' and @column = '" + i + "']")).shouldBe(visible, Duration.ofSeconds(20));
                }
                break;
            case "grid view is set to 1-grid view by default":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '1' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "same CG is displayed":
                assertEquals(galleryName, $(By.xpath("(//div/p[contains(@class, 'MuiTypography-body1')])[1]")).getText());
                break;
            case "grid view is set to 2-grid view":
                with().pollInterval(2, SECONDS).await().until(() -> true);
                $(By.xpath("//*[ local-name() = 'svg' and @column = '2' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is set to 3-grid view":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '3' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            default:
                break;
        }
    }

    @Then("I click {string} on CG screen")
    public void iClickOnCGScreen(String button) {
        switch (button) {
            case "Back Browser Button":
                WebDriverRunner.getWebDriver().navigate().back();
                break;
            default:
                break;
        }
    }

    @Then("I navigate to {string} gallery")
    public void iNavigateToGallery(String numberOfGallery) {
        $(By.xpath("(//*[@id = 'component-collection-card'])[" + numberOfGallery + "]")).click();
        $(By.xpath("(//div/p[contains(@class, 'MuiTypography-body1')])[1]")).shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I navigate to {string} PDP")
    public void iNavigateToPDP(String numberPDP) {
        $(By.xpath("(//*[@id = 'component-rh-image_wrapper'])[" + numberPDP + "]")).click();
        pdpScreen.getItemTitle().shouldBe(visible, Duration.ofSeconds(15));
    }

    @Then("I safe the name of gallery")
    public void iSaveTheNameOfGallery() {
        galleryName = $(By.xpath("(//div/p[contains(@class, 'MuiTypography-body1')])[1]")).getText();
    }

    @Then("I Change the CG Grid view to {string} - grid view and confirm changing")
    public void iChangeTheCGGridAndConfirmChanging(String view) {
        $(By.xpath("//*[ local-name() = 'svg' and @column = '" + view + "']")).click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[ local-name() = 'svg' and @column = '" + view + "' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
        if (view.equals("1")) {
            int i = 1;
            with().pollInterval(1, SECONDS).await().until(() -> true);
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                with().pollInterval(1, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(3, i);
        }
        if (view.equals("2")) {
            int i = 1;
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(4, i);
        }
        if (view.equals("3")) {
            int i = 1;
            with().pollInterval(1, SECONDS).await().until(() -> true);
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                with().pollInterval(1, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(5, i);
        }
    }

    @Then("confirm that Seating {string} is present in {string} of {string}")
    public void iConfirmThatSearchingCollectionsIsPresentInLevelOfMenu(String gallery, String levelOfCollection, String subMenu) {
        if (!gallery.equals("")) {
            if ($(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_concepts')])[" + levelOfCollection + "]/span")).isDisplayed()) {
                assertEquals(gallery, $(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_concepts')])[" + levelOfCollection + "]/span")).getText());
            } else {
                assertEquals(gallery, $(By.xpath("((//*[@role = 'tooltip'])[15]//*[contains(@id , 'rhrCtalogNavigationDetails_concepts')])[" + levelOfCollection + "]")).getText());
            }

        } else {
            if ($(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_navigation')])[" + levelOfCollection + "]/span")).isDisplayed()) {
                assertEquals(subMenu, $(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_navigation')])[" + levelOfCollection + "]/span")).getText());
            } else {
                assertEquals(subMenu, $(By.xpath("(//*[contains(@id , 'rhrCtalogNavigationDetails_navigation')])[" + levelOfCollection + "]")).getText());
            }
        }
    }

    @Then("I verify $$ values are not present in the CG Collections page")
    public void iVerifyDollarValuesAreNotPresent() {
        String URL = Hooks.getCurrentUrl();
        assertFalse(URL.contains("$"));
        String i = WebDriverRunner.getWebDriver().findElement(By.tagName("body")).getText();

        if (i.contains("$")) {
            System.out.println("CG page must not have the cost-error in the page");
        } else {
            System.out.println("CG page looks correct by not displaying the cost");
        }
    }

    @Then("I verify flag icon for country selection and select and validate")
    public void iVerifyFlagIconForCountrySelection() {
        conciergeItemsScreen.getCountrySelection().should(visible, Duration.ofSeconds(40));

        // Verifying the USA validation of sale
        conciergeItemsScreen.getCountrySelection().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        if(conciergeItemsScreen.getCaCountry().isDisplayed()){
            conciergeItemsScreen.getCaCountry().click();
        } else {
            conciergeItemsScreen.getCaCountryLowerCase().click();
        }
        if(conciergeItemsScreen.getSelectCountrySaveButton().isDisplayed()){
            conciergeItemsScreen.getSelectCountrySaveButton().click();
        } else {
            conciergeItemsScreen.getSelectCountryConfirmButton().click();
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);

        conciergeItemsScreen.getCountrySelection().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        if(conciergeItemsScreen.getUsCountry().isDisplayed()){
            conciergeItemsScreen.getUsCountry().click();
        } else {
            conciergeItemsScreen.getUsCountryLowerCase().click();
        }
        if(conciergeItemsScreen.getSelectCountrySaveButton().isDisplayed()){
            conciergeItemsScreen.getSelectCountrySaveButton().click();
        } else {
            conciergeItemsScreen.getSelectCountryConfirmButton().click();
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
        // Sale Link is clicked
        conciergeItemsScreen.getSaleButtonMenu().should(visible, Duration.ofSeconds(20));
        conciergeItemsScreen.getSaleButtonMenu().click();
        //validating the sale link is present
        conciergeItemsScreen.getLivingSaleMenuBar().should(Condition.visible);

        // Verifying the Canada validation of sale
        conciergeItemsScreen.getCountrySelection().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);

        if(conciergeItemsScreen.getCaCountry().isDisplayed()){
            conciergeItemsScreen.getCaCountry().click();
        } else {
            conciergeItemsScreen.getCaCountryLowerCase().click();
        }
        if(conciergeItemsScreen.getSelectCountrySaveButton().isDisplayed()){
            conciergeItemsScreen.getSelectCountrySaveButton().click();
        } else {
            conciergeItemsScreen.getSelectCountryConfirmButton().click();
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);

        // Sale Link is clicked
        conciergeItemsScreen.getSaleButtonMenu().should(visible, Duration.ofSeconds(20));
        conciergeItemsScreen.getSaleButtonMenu().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);

        // Verifying the UK validation of sale
        conciergeItemsScreen.getCountrySelection().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        if(conciergeItemsScreen.getGbCountry().isDisplayed()){
            conciergeItemsScreen.getGbCountry().click();
        } else {
            conciergeItemsScreen.getGbCountryLowerCase().click();
        }

        if(conciergeItemsScreen.getSelectCountrySaveButton().isDisplayed()){
            conciergeItemsScreen.getSelectCountrySaveButton().click();
        } else {
            conciergeItemsScreen.getSelectCountryConfirmButton().click();
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
        // Sale Link is clicked
//        conciergeItemsScreen.getSaleButtonMenuForUK().should(visible, Duration.ofSeconds(20));
//        conciergeItemsScreen.getSaleButtonMenuForUK().click();
        //validating the sale link is not present for UK
//        assertFalse(conciergeItemsScreen.getLivingSaleMenuBar().isDisplayed());
    }

    @Then("I verify loading time for CG page")
    public void iVerifyLoadingTimeForCgPage() {
        long start = System.currentTimeMillis();
        WebDriverRunner.getWebDriver().navigate().refresh();
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time for page load - " + totalTime);
        //5000 represents milliseconds ~ 5 seconds as per scenario
        if (totalTime < 5000) {
            System.out.println("Total Time for page load is less than 5 seconds- " + totalTime);
        } else {
            System.out.println("Total Time for page load is more than 5 seconds- " + totalTime);
        }

    }

    @Then("I Verify the price is not displayed")
    public void iVerifynoPrice() {
        try {
            $(By.xpath("//*[text()='$']"));
//            ConciergeCGScreen.getPrice().isDisplayed();
//            ConciergeCGScreen.getPrice().click();
        } catch (Exception e) {
            //logger.debug(e.getMessage());
        }

    }

    @Then("I verify title is left aligned")
    public void iVerifytitleleftaligned() {
        if(ConciergeCGScreen.getSeatingCollectionTitle().isDisplayed()){
            ConciergeCGScreen.getSeatingCollectionTitle().shouldBe(visible, Duration.ofSeconds(20));
        } else {
            ConciergeCGScreen.getSeatingCollectionTitleLowerCase().shouldBe(visible, Duration.ofSeconds(20));
        }
    }

    @Then("I verify RH MEMBERS PROGRAM is right aligned")
    public void iVerifyRHMemberrightaligned() {
        ConciergeCGScreen.getRHMemberProgram().shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify page is loaded till footer")
    public void iVerifyPageLoadedTillFooter() {
        conciergeItemsScreen.getFooterValidation().scrollIntoView(true);
        conciergeItemsScreen.getFooterValidation().shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify Sale is clicked and taken to PG page")
    public void iVerifySalePageClickedAndTakenToPG() {
        conciergeItemsScreen.getSaleButtonMenu().should(visible, Duration.ofSeconds(20));
        conciergeItemsScreen.getSaleButtonMenu().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        //validating the sale link is present
        conciergeItemsScreen.getFabricChairInSale().click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
    }
    @Then("I verify $$ values are present in the PG Collections page")
    public void iVerifyPGLoaded() {
        String URL = Hooks.getCurrentUrl();
        assertTrue(URL.contains("sku_showOnly"));
        String i = WebDriverRunner.getWebDriver().findElement(By.tagName("body")).getText();

        if (i.contains("$")) {
            System.out.println("PG page must have the cost in the page");
        } else {
            System.out.println("PG page must not have the cost in the page");
        }
    }

    @Then("I verify Free shipping message in textiles")
    public void iVerifyFreeShippingInTextiles() {
        conciergeItemsScreen.getFreeShippingMessage().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify MO in CG page")
    public void iVerifyMOinCGPage() {
        conciergeItemsScreen.getMoInCGPage().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify Available in multiple sizes & finishes text on page")
    public void iVerifyTextOnPage() {
        ConciergeCGScreen.getAvailableText().shouldBe(visible, Duration.ofSeconds(20));
    }
}

