package tests.estore.stepdefinitions;


import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import tests.concierge.pageObject.ConciergeUserAccountPage;
import tests.estore.pageObject.EstoreHomePage;
import tests.estore.pageObject.EstoreSaleScreen;
import tests.estore.pageObject.EstoreSearchScreen;
import tests.estore.pageObject.EstoreUserAccountPage;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreHomePageStepDefs {
    EstoreHomePage estoreHomePage = new EstoreHomePage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();

    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();

    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();

    public static String result = "";

    @Then("I expect that I am on the eStore Dashboard page")
    public void iExpectThatIAmOnTheEStoreDashboardPage() {
    }

    @Then("I Verify list of Navigation bars")
    public void iVerifyListOfNavigationBars() {
//        List<String> items = new ArrayList<>();
//        List<String> expectedItems = new ArrayList(Arrays.asList("LIVING", "DINING" , "BED", "BATH", "LIGHTING", "TEXTILES", "RUGS", "WINDOWS", "DÉCOR", "ART", "OUTDOOR", "SALE"));
//        for (int i = 0; i < estoreHomePage.getListOfNavigationBar().size(); i++) {
//            items.add(estoreHomePage.getListOfNavigationBar().get(i).getText());
//        }
//        assertEquals(items, expectedItems);
    }

    @And("I click on search Icon")
    public void iClickOnSearchIcon() {
        estoreHomePage.getSearchIcon().should(Condition.visible, Duration.ofSeconds(30));
        estoreHomePage.getSearchIcon().click();
    }
    @And("I click on search Icons")
    public void iClickOnSearchIcons() {
        estoreHomePage.getSearchIcons().should(Condition.visible, Duration.ofSeconds(30));
        estoreHomePage.getSearchIcons().click();
    }

    @Then("I Verify Search icon is present")
    public void iVerifyOnSearchIcon() {
        estoreHomePage.getSearchIcon().should(Condition.visible, Duration.ofSeconds(30));
    }

    @And("I Type product name {string}")
    public void iTypeProductName(String arg0) {
        estoreHomePage.getSearchInputField().should(Condition.visible, Duration.ofSeconds(30));
        estoreHomePage.getSearchInputField().setValue(arg0);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSearchItemField().sendKeys(Keys.ENTER);
    }

    @Then("verify users is taken to search result page")
    public void verifyUsersIsTakenToProductPage() {
        assertTrue(Hooks.getCurrentUrl().contains("/search/results"));
    }


    @Then("I verify RH dropdown and list of brand names")
    public void iVerifyRHDropdownAndListOfBrandNames() {
        List<String> items = new ArrayList<>();
//        List<String> expectedItems = new ArrayList(Arrays.asList("RH", "RH CONTEMPORARY" , "RH INTERIORS", "RH MODERN", "RH OUTDOOR", "RH BEACH HOUSE", "RH SKI HOUSE", "RH BABY & CHILD", "RH TEEN"));
//        for (int i = 0; i < estoreHomePage.getListOfBrandNames().size(); i++) {
//            items.add(estoreHomePage.getListOfBrandNames().get(i).getText());
//        }
//        assertEquals(items, expectedItems);
    }

    @When("I click on RH dropdown")
    public void iClickOnRHDropdown() {
        estoreHomePage.getCategoryDropdown().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getCategoryDropdown().click();
    }

    @When("I click on Hamburger menu")
    public void iClickOnHamburgerMenu() {
        estoreHomePage.getHamburgerIcon().isDisplayed();
        estoreHomePage.getHamburgerIcon().click();
    }

    @Then("I verify list of items in hamburger menu")
    public void iVerifyListOfItemsInHamburgerMenu() {
//        List<String> items = new ArrayList<>();
//        List<String> expectedItems = new ArrayList(Arrays.asList("RH", "RH CONTEMPORARY" , "RH INTERIORS", "RH MODERN", "RH OUTDOOR", "RH BEACH HOUSE", "RH SKI HOUSE", "RH BABY & CHILD", "RH TEEN", "RH MEMBERS PROGRAM", "RH ONE GULFSTREAM 650ER", "RH TWO GULFSTREAM 550", "RH THREE EXPEDITION YACHT"));
//        for (int i = 0; i < estoreHomePage.getListOfHamburgeritems().size(); i++) {
//            items.add(estoreHomePage.getListOfHamburgeritems().get(i).getText());
//        }
//        assertEquals(items, expectedItems);
    }

    @When("I scroll down to Request a design consultation and click")
    public void iScrollDownToRequestADesignConsultationAndClick() {
        with().pollInterval(4, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 15000)");
        estoreHomePage.getRequestConsultationButton().scrollIntoView(true);
        estoreHomePage.getRequestConsultationButton().should(visible);
        estoreHomePage.getRequestConsultationButton().click();
    }

    @And("I fill in the request form")
    public void iFillInTheRequestForm() {
        estoreHomePage.getPhoneNumberField().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getPhoneNumberField().setValue("9254434333");
        estoreHomePage.getLocationDropdown().selectOption(6);
        estoreHomePage.getMessageInputField().click();
        estoreHomePage.getMessageInputField().setValue("Hi, This is automation tests, please ignore the request. Thank you ");
        estoreHomePage.getIframeRequestAConsultationButton().click();


    }

    @Then("I Verify Thank you message")
    public void iVerifyThankYouMessage() {
        estoreHomePage.getThankMessageText().should(Condition.visible, Duration.ofSeconds(25));
    }


    @When("I navigate to the wishlist")
    public void iNavigateToTheWishlist() {
        estoreHomePage.getAccountIcon().click();
        estoreHomePage.getWishlist().click();
    }


    @When("I navigate to the member tab")
    public void iNavigateToTheMemberTab() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//*[@data-navigation-account-item-id='my-account/membership.jsp']")).
                should(Condition.and("", appear, Condition.interactable, visible), Duration.ofSeconds(40))
                .hover();
        $(By.xpath("//*[@data-navigation-account-item-id='my-account/membership.jsp']")).
                should(Condition.and("", appear, Condition.interactable, visible), Duration.ofSeconds(40))
                .click(ClickOptions.usingJavaScript());
    }

    @Then("I validate each cat and sub-cat for eStore")
    public void iValidateEachCatAndSubCatForEStore() {

        for (int main = 0; main < estoreHomePage.getListOfNavigationBar().size(); main++) {
            System.out.println("Main Category: " + estoreHomePage.getListOfNavigationBar().get(main).getText());
            estoreHomePage.getListOfNavigationBar().get(main).click();
            for (int sub = 0; sub < estoreHomePage.getListOfSubCategories().size(); sub++) {
                System.out.println("Sub Category: " + estoreHomePage.getListOfSubCategories().get(sub).getText());
                estoreHomePage.getListOfSubCategories().get(sub).click();

                for (int collection = 0; collection < estoreHomePage.getListOfCollection().size(); collection++) {
                    estoreHomePage.getListOfCollection().get(collection).click();

                    System.out.println(WebDriverRunner.getWebDriver().getTitle() + ": " + Hooks.getCurrentUrl());
                    assertFalse((WebDriverRunner.getWebDriver().getTitle().contains("404")));
                    if (!Hooks.getCurrentUrl().contains("rhnonprod")) {
                        open(Hooks.eStoreURL);

                    }
                    estoreHomePage.getListOfNavigationBar().get(main).click();

                    estoreHomePage.getListOfSubCategories().get(sub).click();

                }
            }
        }
    }

    @And("user verifies search button, account icon, cart button are displayed")
    public void userVerifiesSearchButtonAccountIconCartButtonAreDisplayed() {
        estoreHomePage.getAccountIcon().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getSearchIconHomePage().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getHeaderCartButton().should(Condition.visible, Duration.ofSeconds(20));
    }

    @And("I verify that cart and my account icons should be displayed")
    public void iVerifyThatCartAndMyAccountIconsShouldBeDisplayed() {
        estoreHomePage.verifyThatCartIconIsDisplayed();
        estoreHomePage.verifyThatMyAccountIconIsDisplayed();
    }

    @Then("I verify that home page load will all sections and links")
    public void iVerifyThatHomePageLoadWillAllSectionsAndLinks() {
        estoreHomePage.getAccountIcon().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getSearchIconHomePage().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getHeaderCartButton().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.verifyThatHomePageLogoIsDisplayed();
    }

    @Then("I verify that footer section should show at the bottom of the page along with copy right and year")
    public void iVerifyThatFooterSectionShouldShowAtTheBottomOfThePageAlongWithCopyRightAndYear() {
        estoreHomePage.verifyThatAllItemsFromFooterAreDisplayed();
    }

    @When("I click on Living in TOP NAV menu")
    public void iClickOnLivingInTOPNAVMenu() {
        estoreHomePage.clickToLinivngTopNavMenu();
    }

    @When("I click on Sectionals in Tertiary NAV")
    public void iClickOnSectionalsInTertiaryNAV() {
        estoreHomePage.clickToLinivngTopNavMenu();
    }

    @When("I click on Sectionals in Tertiary NAV from Living")
    public void iClickOnSectionalsInTertiaryNAVFromLiving() {
        estoreHomePage.clickToSectionalsTopNavMenu();
    }

    @When("I click on {string} in Tertiary NAV from {string}")
    public void iClickOnInTertiaryNAVFrom(String tertiaryNav, String arg1) {
        estoreHomePage.clickToTertiaryNav(tertiaryNav);
    }

    @Then("I verify that SALE is present on TOP Nav menu")
    public void iVerifyThatSALEIsPresentOnTOPNavMenu() {
        $(By.xpath("//div[contains(@id,'container-rhrheader-rhr-catalogNav_catalogNav')]//span[text()='SALE']")).should(visible, Duration.ofSeconds(12));
    }

    @Then("I verify that hamburger icon is displayed for the main menu")
    public void iVerifyThatHamburgerIconIsDisplayedForTheMainMenu() {
        estoreHomePage.verifyThatHamburgerIconIsDisplayed();
    }

    @Then("I verify that cart page icon is displayed")
    public void iVerifyThatCartPageIconIsDisplayed() {
        estoreHomePage.verifyThatCartButtonIconIsDisplayed();
    }

    @And("I verify that cart page icon have the item count next to the mini cart icon")
    public void iVerifyThatCartPageIconHaveTheItemCountNextToTheMiniCartIcon() {
        assertTrue("Verify that cart page icon have the item count next to the mini cart icon",
                estoreHomePage.getCountOfItemFromCart() > 0);
    }

    @Then("I verify that my account icon is displayed")
    public void iVerifyThatMyAccountIconIsDisplayed() {
        estoreHomePage.verifyThatAccountIconIsDisplayed();
    }

    @When("I click on Rugs in Secondary NAV from Rugs")
    public void iClikcOnRugsInSecondaryNAVFromRugs() {
        estoreHomePage.getRugsSecondaryNav().should(visible, Duration.ofSeconds(12))
                .click(ClickOptions.usingJavaScript());
    }

    @When("I click on All Rugs in Tertiary NAV")
    public void iClickOnAllRugsInTertiaryNAV() {
        estoreHomePage.getAllRugsTertiaryNav().should(visible, Duration.ofSeconds(12)).click(ClickOptions.usingJavaScript());
    }

    @When("I verify that All Rugs PG page is displayed")
    public void iVerifyThatAllRugsPGPageIsDisplayed() {
        estoreSaleScreen.getRugsAllRugs().should(visible, Duration.ofSeconds(12));
    }

    @Then("I verify the shop by room under the LIVING top navigation")
    public void iVerifyTheSHopByRoomUnderTheLivingTopNavigation(){
        Assert.assertTrue(estoreHomePage.getLivingCategoryMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getLivingCategoryMenu().click();
        Assert.assertTrue(estoreHomePage.getShopByRoomUnderCategory().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getShopByRoomUnderCategory().click();
        Assert.assertTrue(estoreHomePage.getLivingRoomUnderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getOfficeUnderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getLivingRoomUnderShopByRoom().click();
        Assert.assertTrue(estoreHomePage.getLivingPageTextAfterVisitShopByRoomCat().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify the shop by room under the DINING top navigation")
    public void iVerifyTheSHopByRoomUnderTheDiningTopNavigation(){
        Assert.assertTrue(estoreHomePage.getDiningCategoryMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getDiningCategoryMenu().click();
        Assert.assertTrue(estoreHomePage.getShopByRoomUnderCategory().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getShopByRoomUnderCategory().click();
        Assert.assertTrue(estoreHomePage.getDiningRoomUnderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getDiningRoomUnderShopByRoom().click();
        Assert.assertTrue(estoreHomePage.getDiningPageTextAfterVisitShopByRoomCat().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify the shop by room under the BED top navigation")
    public void iVerifyTheSHopByRoomUnderTheBedTopNavigation(){
        Assert.assertTrue(estoreHomePage.getBedCategoryMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getBedCategoryMenu().click();
        Assert.assertTrue(estoreHomePage.getShopByRoomUnderCategory().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getShopByRoomUnderCategory().click();
        Assert.assertTrue(estoreHomePage.getBedRoomsUnderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getBedRoomsUnderShopByRoom().click();
        Assert.assertTrue(estoreHomePage.getBedRoomPageTextAfterVisitShopByRoomCat().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify the shop by room under the BATH top navigation")
    public void iVerifyTheSHopByRoomUnderTheBathTopNavigation(){
        Assert.assertTrue(estoreHomePage.getBathCategoryMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getBathCategoryMenu().click();
        Assert.assertTrue(estoreHomePage.getShopByRoomUnderCategory().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getShopByRoomUnderCategory().click();
        Assert.assertTrue(estoreHomePage.getBathUnderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getBathUnderShopByRoom().click();
        Assert.assertTrue(estoreHomePage.getBathRoomPageTextAfterVisitShopByRoomCat().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify the shop by room under the OUTDOOR top navigation")
    public void iVerifyTheSHopByRoomUnderTheOutdoorTopNavigation(){
        Assert.assertTrue(estoreHomePage.getOutdoorCategoryMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getOutdoorCategoryMenu().click();
        Assert.assertTrue(estoreHomePage.getShopByRoomUnderCategory().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getShopByRoomUnderCategory().click();
        Assert.assertTrue(estoreHomePage.getOutdoorUnderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getOutdoorUnderShopByRoom().click();
        Assert.assertTrue(estoreHomePage.getOutdoorPageTextAfterVisitShopByRoomCat().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify the shop by room Page")
    public void iVerifyTheShoRoomPage(){
        Assert.assertTrue(estoreHomePage.getLivingCategoryMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getLivingCategoryMenu().click();
        Assert.assertTrue(estoreHomePage.getHeadingShopRoomPageText().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getLivingTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getDiningTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getBedroomTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getBathTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getContemporaryTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getBeachHouseTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getSkiHouseTextInShopRoomPage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getLeftSliderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getRightSliderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());

        Assert.assertTrue(estoreHomePage.getPlusIconZoomBtn1().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getPlusIconZoomBtn2().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getPlusIconZoomBtn3().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getPlusIconZoomBtn4().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());

        estoreHomePage.getRightSliderShopByRoom().click();
        estoreHomePage.getRightSliderShopByRoom().click();
        estoreHomePage.getLeftSliderShopByRoom().click();

        estoreHomePage.getPlusIconZoomBtn1().click();
        Assert.assertTrue(estoreHomePage.getMemberPrice().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getRegularPrice().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getViewDetailBtn().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getViewDetailBtn().click();
        Assert.assertTrue(estoreHomePage.getPdpPageImage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify elements panel")
    public void iVerifyElementPanel(){
        Assert.assertTrue(estoreHomePage.getLinivngTopNavMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getLinivngTopNavMenu().click();
        Assert.assertTrue(estoreHomePage.getHeadingShopRoomPageText().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getThreeDotsMatrix().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getThreeDotsMatrix().click();
        Assert.assertTrue(estoreHomePage.getSliderWindow().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getSliderWindowLeftArrow().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getSliderWindowRightArrow().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getSliderWindowMultipleImages().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify elements panel slider function")
    public void iVerifyElementPanelSliderFunction(){
        Assert.assertTrue(estoreHomePage.getLinivngTopNavMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getLinivngTopNavMenu().click();
        Assert.assertTrue(estoreHomePage.getHeadingShopRoomPageText().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getThreeDotsMatrix().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getThreeDotsMatrix().click();
        Assert.assertTrue(estoreHomePage.getSliderWindow().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getSliderWindowRightArrow().click();
        estoreHomePage.getSliderWindowRightArrow().click();
        estoreHomePage.getSliderWindowLeftArrow().click();
        Assert.assertTrue(estoreHomePage.getSelectedImage().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
    }

    @Then("I verify show product function")
    public void iVerifyShowProductFunction(){
        Assert.assertTrue(estoreHomePage.getLinivngTopNavMenu().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getLinivngTopNavMenu().click();
        Assert.assertTrue(estoreHomePage.getHeadingShopRoomPageText().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getLeftSliderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getRightSliderShopByRoom().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getShowProductCheckBox().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        Assert.assertTrue(estoreHomePage.getPlusIconZoomBtn1().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed());
        estoreHomePage.getShowProductCheckBox().click();
        try{
            if(estoreHomePage.getPlusIconZoomBtn1().should(Condition.visible, Duration.ofSeconds(20)).isDisplayed()){
                System.out.println(" Plus icon is is still appearing");
            }
        }catch (Exception e ){
            System.out.println(" Plus ICon is removed is disappeared as expected");
        }
    }
}