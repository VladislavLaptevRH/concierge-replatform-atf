package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import tests.concierge.pageObject.ConciergeLoginPage;
import tests.concierge.pageObject.ConciergeUserAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

@Getter
public class ConciergeAssociateStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    private static final Logger Log = LoggerFactory.getLogger(ConciergeAssociateStepDefs.class);


    @Given("I log into Concierge as {string}")
    public void iLogIntoConciergeAs(String arg0) {
        if (!conciergeLoginPage.getUsernameField().exists()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        } else {
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        Log.debug("I log into Concierge as " + arg0);
        generalStepDefs.loginAsRole(arg0);
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    @Then("I expect that I am on the Concierge Dashboard page")
    public void iExpectThatIAmOnTheConciergeDashboardPage() {
        conciergeUserAccountPage.getMainMenuHeader().should(Condition.be(visible), Duration.ofSeconds(10));
        assertTrue(conciergeUserAccountPage.getMainMenuHeader().isDisplayed(), "");
    }

    @When("I change my store to number {string}")
    public void iChangeMyStoreToStoreNumber(String storeNumber) {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySelect().click();
        conciergeUserAccountPage.getCurrentLocationGalleryItemByName(storeNumber).click();
        conciergeUserAccountPage.getGallerySubmitButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @Then("I verify I see store Palo Alto in the header")
    public void iVerifyISeeStoreInTheHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(40));
        conciergeUserAccountPage.getNewPortBeachGallery().should(text("PALO ALTO"));
        assertEquals(conciergeUserAccountPage.getNewPortBeachGallery().getText(), "PALO ALTO");
    }

    @Then("user verifies list of galleries which have default value {string}")
    public void userVerifiesListOfGalleries(String galleryItem) {
        conciergeUserAccountPage.getGalleryItemByName(galleryItem).should(visible, Duration.ofSeconds(15));
    }

    @When("user clicks on gallery button from header")
    public void userClicksOnGalleryButtonFromHeader() {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
    }

    @When("I choose gallery number {string}")
    public void iChooseContractGallery(String galleryNumber) {
        conciergeUserAccountPage.getGalleryButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGalleryButton().click();
        conciergeUserAccountPage.getGalleryButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySelect().click();
        conciergeUserAccountPage.getCurrentLocationGalleryItemByName(galleryNumber).click();
        conciergeUserAccountPage.getGallerySubmitButton().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @Then("I verify footer links for {string}")
    public void iVerifyFooterLinks(String footer) {
        $(By.xpath("//*[text()='"+footer+"']")).should(visible, Duration.ofSeconds(40)).click();
        switch (footer) {
            case "RH.COM":
                switchTo().window(1);
                try {
                    assertEquals(Hooks.getCurrentUrl(), "https://rh.com/us/en/");
                } catch (ElementNotFound e){
                    assertEquals(Hooks.getCurrentUrl(), "https://rh.com/");
                }
                break;
            case "DASHBOARD":
                conciergeLoginPage.getDashboard().should(visible, Duration.ofSeconds(40));
                break;
            case "PROJECTS":
                conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                break;
            case "REGISTRY":
                conciergeLoginPage.getRegistry().should(visible, Duration.ofSeconds(40));
                break;
        }
    }

    @Then("I validate each cat and sub-cat")
    public void iValidateEachCatAndSubCat() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        for (int main = 1; main < conciergeUserAccountPage.getListOfMainCategories().size(); main++) {
            System.out.println("Main Category: " + conciergeUserAccountPage.getListOfMainCategories().get(main).getText());
            try {
                conciergeUserAccountPage.getListOfMainCategories().get(main).click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int sub = 0; sub < conciergeUserAccountPage.getListOfSubCategories().size(); sub++) {
                System.out.println("Sub Category: " + conciergeUserAccountPage.getListOfSubCategories().get(sub).getText());
                try {
                    conciergeUserAccountPage.getListOfSubCategories().get(sub).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                with().pollInterval(5, SECONDS).await().until(() -> true);

                for (int collection = 0; collection < conciergeUserAccountPage.getListOfCollections().size(); collection++) {
                    System.out.println("Collection: " + conciergeUserAccountPage.getListOfCollections().get(collection).getText());
                    try {
                        conciergeUserAccountPage.getListOfCollections().get(collection).click();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                    System.out.println(WebDriverRunner.getWebDriver().getTitle() + ": " + Hooks.getCurrentUrl());
                    if (!Hooks.getCurrentUrl().contains("concierge")) {
                        open(Hooks.conciergeURL);
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }

                    try {
                        conciergeUserAccountPage.getListOfMainCategories().get(main).click();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        conciergeUserAccountPage.getListOfSubCategories().get(sub).click();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Given("I choose {string} gallery for intl concierge")
    public void iChooseGalleryForIntlConcierge(String arg0) {
        System.out.println();
    }

    @Given("I log into intl Concierge as {string}")
    public void iLogIntoIntlConciergeAs(String accountRole) {
        conciergeLoginPage.getPasswordField().should(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofSeconds(40));
        if (accountRole.equals("associate")) {
            conciergeLoginPage.getUsernameField().setValue(Hooks.associateLogin);
            conciergeLoginPage.getPasswordField().setValue(Hooks.associatePassword);
        }
        conciergeLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getSignInButton().click();
    }

    @When("I choose gallery number {string} for gallery intl concierge")
    public void iChooseGalleryNumberForGalleryIntlConcierge(String arg0) {
        if(conciergeLoginPage.getCurrentLocation().isDisplayed() || conciergeLoginPage.getLocation().isDisplayed()){
           if(Hooks.cookie.equals("prodsupport")){
               conciergeLoginPage.getInputGalleryList().click();
               $(By.xpath("//*[text()='5: Newport Beach']")).click();
           } else {
               conciergeLoginPage.getLocationListButton().click();
               $(By.xpath("//*[text()='5: Newport Beach']")).click();
            }

        }
        else {
            conciergeLoginPage.getLocationInput().should(visible, Duration.ofSeconds(20));
            conciergeLoginPage.getLocationInput().click();
            $(By.xpath("//*[text()='701: Aynhoe']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='701: Aynhoe']")).click();
        }
        conciergeLoginPage.getContinueButton().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getContinueButton().click();
    }

    @Then("I change the brand to {string}")
    public void iChangeBrand(String brand){
    conciergeUserAccountPage.getBrandButton().should(visible,Duration.ofSeconds(40)).click();
    conciergeUserAccountPage.getBrand(brand).should(visible,Duration.ofSeconds(40)).click();
    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40)).click();
    }

    @Then("I verify the logo")
    public void iVerifyLogo(){
        conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40)).click();
    }

    @Then("I verify the username")
    public void iVerifyUsername(){
        conciergeUserAccountPage.getUsename().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify project button")
    public void iVerifyProjectButton(){
        conciergeUserAccountPage.getProjectsButton().should(visible,Duration.ofSeconds(40));
    }

    @Then("I Verify search leans")
    public void iVerifyDSearchLeans(){
        conciergeUserAccountPage.getSearchLens().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify user icon")
    public void iVerifyUserIcon(){
        conciergeUserAccountPage.getUserIcon().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify cart")
    public void iVerifyCart(){
        conciergeUserAccountPage.getCartButton().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify brand is button")
    public void iVerifyBrand(){
        conciergeUserAccountPage.getBrandButton().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify main menu")
    public void iVerifyMainMenu(){
        List<String> rhExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Outdoor", "BABY & CHILD", "TEEN", "SALE"));
        List<String> rhItems = new ArrayList<>();
        for (int i = 0; i < conciergeUserAccountPage.getMenuItems().size(); i++) {
            rhItems = new ArrayList(Arrays.asList(conciergeUserAccountPage.getMenuItems().get(i).getText()));
        }
        GeneralStepDefs.compareList(rhExpectedItems, rhItems);
    }

    @Then("I verify page label")
    public void iVerifyPageLabel(){
        conciergeUserAccountPage.getPageLabel1().should(visible,Duration.ofSeconds(40));
        conciergeUserAccountPage.getPageLabel2().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify button {string} on homepage")
    public void iVerifyButtonOnHomepage(String button){
        conciergeUserAccountPage.getButton(button).should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify search item field and search button")
    public void iVerifySearchItem(){
        conciergeUserAccountPage.getSearchItemField().should(visible,Duration.ofSeconds(40));
        conciergeUserAccountPage.getSearchButton().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify the gallery")
    public void iVerifyGallery(){
        conciergeUserAccountPage.getExistingGallery().should(visible,Duration.ofSeconds(40));
    }
}
