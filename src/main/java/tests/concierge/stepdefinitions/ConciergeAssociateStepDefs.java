package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import tests.concierge.pageObject.ConciergeHomePage;
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

    ConciergeHomePage conciergeHomePage = new ConciergeHomePage();
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

    @Then("I verify footer links for brand {string}")
    public void iVerifyFooterLinks(String brand) {
            switch (brand){
                case "RH":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'REGISTRY']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getRegistry().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH CONTEMPORARY":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH INTERIORS":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhinteriors.rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH MODERN":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhmodern.rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'REGISTRY']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getRegistry().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH OUTDOOR":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhoutdoor.rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH BEACH HOUSE":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhbeachhouse.rh.com/us/en/");
                    switchTo().window(0);
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH SKI HOUSE":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhskihouse.rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH BABY & CHILD":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhbabyandchild.rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'REGISTRY']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getRegistry().should(visible, Duration.ofSeconds(40));
                    break;
                case "RH TEEN":
                    $(By.xpath("//*[text() = 'RH.COM']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    switchTo().window(1);
                    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40));
                    assertEquals(Hooks.getCurrentUrl(), "https://rhteen.rh.com/us/en/");
                    switchTo().window(0);
                    $(By.xpath("//*[text() = 'DASHBOARD']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    $(By.xpath("//*[text() = 'Dashboard']")).should(visible, Duration.ofSeconds(40));
                    $(By.xpath("//*[text() = 'PROJECTS']")).should(Condition.and("",visible, enabled), Duration.ofSeconds(40)).click();
                    conciergeLoginPage.getProjects().should(visible, Duration.ofSeconds(40));
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
        if(!conciergeUserAccountPage.getBrandButton().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(3, SECONDS).await().until(() -> true);
        }
    conciergeUserAccountPage.getBrandButton().should(visible,Duration.ofSeconds(40)).click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(! conciergeUserAccountPage.getBrand(brand).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
    conciergeUserAccountPage.getBrand(brand).should(visible,Duration.ofSeconds(40)).click();
    conciergeUserAccountPage.getRhConciergeLogo().should(visible,Duration.ofSeconds(40)).click();
    }

    @Then("I verify that RH Brand dropdown is present in {string} home page")
    public void iVerifyThatRHBrandDropDownIsPresentInHomePage(String currentBrand){
        if(!conciergeUserAccountPage.getCurrentBrandByName(currentBrand).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            conciergeUserAccountPage.getCurrentBrandByName(currentBrand).should(visible,Duration.ofSeconds(40));
        }
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeUserAccountPage.getCurrentBrandByName(currentBrand).should(visible,Duration.ofSeconds(40));
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

    @Then("I verify flag icon for country selection")
    public void iVerifyFlagIconForCountrySelection(){
        conciergeHomePage.countrySelection.should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify brand dropdown")
    public void iVerifyBrand(){
        conciergeUserAccountPage.getBrandButton().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify top nav")
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
    public void iVerifyButtonOnHomepage(String button) {
        if (Hooks.cookie.equals("userservice")) {
            if(button.equals("RH card lookup")){
                conciergeUserAccountPage.getButton("RH Card lookup").should(visible, Duration.ofSeconds(40));
            } else {
                conciergeUserAccountPage.getButton(button).should(visible, Duration.ofSeconds(40));
            }
        } else {
            conciergeUserAccountPage.getButton(button).should(visible, Duration.ofSeconds(40));
        }
    }

    @When("I click {string} button on homepage")
    public void iClickbutton(String button){
        conciergeUserAccountPage.getButton(button).click();
    }

    @Then("I verify search item field and search button")
    public void iVerifySearchItem(){
        conciergeUserAccountPage.getSearchItemField().should(visible,Duration.ofSeconds(40));
        conciergeUserAccountPage.getSearchButton().should(visible,Duration.ofSeconds(40));
    }

    @Then("I verify order history page is displayed")
    public void iVerifyOrderHistory(){
        conciergeUserAccountPage.getOrderHistoryTitle().should(visible,Duration.ofSeconds(40));
        conciergeUserAccountPage.getOrderUser().should(visible,Duration.ofSeconds(40));
        conciergeUserAccountPage.getOrderSearch().should(visible,Duration.ofSeconds(40));
        conciergeUserAccountPage.getOrderTable().should(visible,Duration.ofSeconds(40));
    }

    @When("I search by {string}")
    public void iSearch(String field){
        conciergeUserAccountPage.getOrderSearch().click();
        switch (field){
            case "name":{
                conciergeUserAccountPage.getFirstName().should(visible,Duration.ofSeconds(40));
                conciergeUserAccountPage.getFirstName().setValue("Automation");
                conciergeUserAccountPage.getLastName().should(visible,Duration.ofSeconds(40));
                conciergeUserAccountPage.getLastName().setValue("Trade");
                conciergeUserAccountPage.getOrderSearchButton().click();
                break;
            }
            case "contact":{
                conciergeUserAccountPage.getPhoneNumber().should(visible,Duration.ofSeconds(40));
                conciergeUserAccountPage.getPhoneNumber().setValue("1234567890");
                conciergeUserAccountPage.getOrderSearchButton().click();
                break;
            }
            case "First Name":{
                conciergeUserAccountPage.getFirstName().should(visible,Duration.ofSeconds(40));
                conciergeUserAccountPage.getFirstName().setValue("Automation");
                conciergeUserAccountPage.getOrderSearchButton().click();
                break;
            }
            case "Last Name":{
                conciergeUserAccountPage.getLastName().should(visible,Duration.ofSeconds(40));
                conciergeUserAccountPage.getLastName().setValue("Trade");
                conciergeUserAccountPage.getOrderSearchButton().click();
                break;
            }
        }
    }
    @Then("I confirm user is not able to search only with first name")
    public void iNotAbletoSearch(){
        conciergeUserAccountPage.getFirstNameOnly().should(visible,Duration.ofSeconds(40));
    }

    @Then("I confirm table header {string}")
    public void iConfirmth(String header){
        conciergeUserAccountPage.getTableHeader(header).should(visible,Duration.ofSeconds(40));
    }


    @Then("I confirm order is shown for search filter {string}")
    public void iconfirmResult(String value){
        switch (value){
            case "name":{
                conciergeUserAccountPage.getResultName().should(visible,Duration.ofSeconds(40));
                break;
            }
            case "contact":{
                conciergeUserAccountPage.getResultPhoneNumber().should(visible,Duration.ofSeconds(40));
                break;
            }
            case "Last Name":{
                conciergeUserAccountPage.getLastNameOnly().should(visible,Duration.ofSeconds(40));
                break;
            }

        }
    }

    @Then("I verify the gallery")
    public void iVerifyGallery(){
        conciergeUserAccountPage.getExistingGallery().should(visible,Duration.ofSeconds(40));
    }

    @When("I sign out")
    public void isignout() {
        conciergeUserAccountPage.getNewPortBeachGallery().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getSignout().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getGallerySelect().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
    }

    @Then("I land in login page")
    public void ilandloginpage(String arg0) {
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

    @Then("I search by Name")
    public void iSearchbyName(){
        conciergeUserAccountPage.getProfileFirstName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileFirstName().setValue("test");
        conciergeUserAccountPage.getProfileLastName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileLastName().setValue("test");
        conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileSearchButton().click();
    }

    @Then("I search by No Details")
    public void iSearchbyNoDetails(){
        conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileSearchButton().click();
    }

    @Then("I confirm error message")
    public void iConirmerrormessage(){
        conciergeUserAccountPage.getProfileProvideEmail().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileProvideLName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileProvideLName().should(visible, Duration.ofSeconds(15));
    }

    @Then("I search by Initial of First name and Full last name")
    public void iSearchbyInitial(){
        conciergeUserAccountPage.getProfileFirstName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileFirstName().setValue("t");
        conciergeUserAccountPage.getProfileLastName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileLastName().setValue("test");
        conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileSearchButton().click();
    }

    @Then("I confirm registered profile")
    public void iConfirmregisteredprofile(){
        conciergeUserAccountPage.getProfileRegistered().should(visible, Duration.ofSeconds(120));
    }

    @Then("I confirm one time concierge user profile")
    public void iConfirmonetimeconcierge(){
        conciergeUserAccountPage.getProfileonetimeConciergeUser().should(visible, Duration.ofSeconds(120));
    }

    @Then("I search by email")
    public void iSearchbyemail(){
        conciergeUserAccountPage.getProfileemailormemberid().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileemailormemberid().setValue("test@test.com");
        conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileSearchButton().click();
    }

    @Then("I search by email and incorrect name")
    public void iSearchbyemailincorrectname(){
        conciergeUserAccountPage.getProfileemailormemberid().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileemailormemberid().setValue("test@test.com");
        conciergeUserAccountPage.getProfileFirstName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileFirstName().setValue("a");
        conciergeUserAccountPage.getProfileLastName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileLastName().setValue("a");
        conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileSearchButton().click();
    }

    @Then("I search by member id")
    public void iSearchbymemberid(){
        conciergeUserAccountPage.getProfileemailormemberid().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileemailormemberid().setValue("102000676");
        conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileSearchButton().click();
    }

    @Then("I confirm registered profile fields")
    public void iConfirmFields(){
        conciergeUserAccountPage.getProfileRegisteredEmail().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredRHMember().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredMemberID().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredCart().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredDetails().should(visible, Duration.ofSeconds(15));
    }

    @Then("I confirm one time concierge user fields")
    public void iConfirmCOnciergeFields(){
        conciergeUserAccountPage.getProfileRegisteredEmail().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredRHMember().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredMemberID().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredCart().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredDetails().should(visible, Duration.ofSeconds(15));
    }

    @Then("I click cart button")
    public void iclickcart(){
        conciergeUserAccountPage.getProfileRegisteredCart().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredCart().click();
    }

    @Then("I click details button")
    public void iclickdetails(){
        conciergeUserAccountPage.getProfileRegisteredDetails().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileRegisteredDetails().click();
    }

    @Then("I confirm user cart page")
    public void iUserCartpage(){
        conciergeUserAccountPage.getProfileCartPage().should(visible, Duration.ofSeconds(15));
    }

    @Then("I confirm user details page")
    public void iUserDetailspage(){
        conciergeUserAccountPage.getProfileDetailsPage().should(visible, Duration.ofSeconds(15));
    }

    @Then("I confirm fields of user details page")
    public void iConfirmFieldpage(){
        conciergeUserAccountPage.getDetailsClientName().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsClientEmail().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsRHMembership().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsSFContactID().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsSFCustomerID().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsPasswordReset().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsCreatedDate().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsLastActivity().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getDetailsViewCart().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileWishlistLink().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileOrderHistory().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getBackButton().should(visible, Duration.ofSeconds(15));
    }

    @Then("I click on wishlist link")
    public void iclickWishlist(){
        conciergeUserAccountPage.getProfileWishlistLink().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileWishlistLink().click();
    }
    @Then("I click on order history link")
    public void iclickHorderHistory(){
        conciergeUserAccountPage.getProfileOrderHistory().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getProfileOrderHistory().click();
    }

    @Then("I confirm user wishlist page")
    public void iwishlist(){
        conciergeUserAccountPage.getProfileWishlistPage().should(visible, Duration.ofSeconds(15));
    }

    @Then("I confirm user order history page")
    public void iOrderHistory(){
        conciergeUserAccountPage.getProfileOrderHistory().should(visible, Duration.ofSeconds(15));
    }

    @Then("I confirm user order history Registry page")
    public void iOrderHistoryRegistry(){
        conciergeUserAccountPage.getProfileOrderHistoryRegistry().should(visible, Duration.ofSeconds(15));
    }

    @Then("I search by registry only {string}")
    public void iClickregistryonly(String val){
        switch (val){
            case "Name":
                conciergeUserAccountPage.getProfileFirstName().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileFirstName().setValue("test");
                conciergeUserAccountPage.getProfileLastName().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileLastName().setValue("test");
                conciergeUserAccountPage.getProfileCheckbox().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileCheckbox().click();
                conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileSearchButton().click();

            case "email":
                conciergeUserAccountPage.getProfileemailormemberid().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileemailormemberid().setValue("test@test.com");
                conciergeUserAccountPage.getProfileCheckbox().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileCheckbox().click();
                conciergeUserAccountPage.getProfileSearchButton().should(visible, Duration.ofSeconds(15));
                conciergeUserAccountPage.getProfileSearchButton().click();
        }
    }


}
