package com.test.stepdefinitions;

import com.test.pageObject.ConciergeLoginPage;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@Getter
public class ConciergeAssociateStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    String expectedGalleriesList = "5: NEWPORT BEACH\n" +
            "10: PALO ALTO\n" +
            "11: PASADENA\n" +
            "15: TROY\n" +
            "25: KING OF PRUSSIA\n" +
            "27: TYSONS\n" +
            "31: METAIRIE\n" +
            "44: AVENTURA\n" +
            "45: BIRMINGHAM\n" +
            "48: SHORT HILLS\n" +
            "61: WALNUT CREEK\n" +
            "72: RED BANK\n" +
            "73: WINTER PARK\n" +
            "74: THOUSAND OAKS\n" +
            "78: INDIANAPOLIS\n" +
            "100: MISSION VIEJO\n" +
            "105: SANTA BARBARA\n" +
            "117: TULSA\n" +
            "123: ROSEVILLE\n" +
            "130: RICHMOND\n" +
            "131: LYNDHURST\n" +
            "132: COSTA MESA\n" +
            "133: CINCINNATI\n" +
            "134: LOS GATOS\n" +
            "135: ANNAPOLIS\n" +
            "136: SAN FRANCISCO\n" +
            "137: EAST HAMPTON\n" +
            "139: PLANO\n" +
            "140: HOUSTON\n" +
            "141: SALT LAKE CITY\n" +
            "142: BOSTON\n" +
            "143: SCOTTSDALE\n" +
            "144: GREENWICH\n" +
            "145: ATLANTA\n" +
            "146: WEST HOLLYWOOD\n" +
            "147: CHICAGO\n" +
            "148: TAMPA\n" +
            "149: AUSTIN\n" +
            "150: LEAWOOD\n" +
            "151: DENVER\n" +
            "152: NEW YORK\n" +
            "153: NASHVILLE\n" +
            "154: SEATTLE\n" +
            "155: PORTLAND\n" +
            "156: YOUNTVILLE\n" +
            "157: LAS VEGAS\n" +
            "158: MARIN\n" +
            "159: MINNEAPOLIS\n" +
            "160: WEST PALM BEACH\n" +
            "162: SAN DIEGO\n" +
            "164: PITTSBURGH\n" +
            "168: DALLAS\n" +
            "169: COLUMBUS\n" +
            "174: CHARLOTTE\n" +
            "175: SAN ANTONIO\n" +
            "176: OAK BROOK\n" +
            "177: JACKSONVILLE\n" +
            "178: RALEIGH\n" +
            "183: ST LOUIS\n" +
            "301: B&C CORTE MADERA\n" +
            "302: B&C HOUSTON\n" +
            "304: B&C GREENWICH\n" +
            "351: RH MODERN - LA\n" +
            "501: VANCOUVER\n" +
            "504: CALGARY\n" +
            "505: EDMONTON\n" +
            "506: TORONTO\n" +
            "601: VACAVILLE\n" +
            "602: LEESBURG\n" +
            "604: DAWSONVILLE\n" +
            "605: SAN MARCOS\n" +
            "606: WRENTHAM\n" +
            "610: LIMERICK\n" +
            "611: RIVERHEAD\n" +
            "613: LONG BEACH\n" +
            "614: HALTON HILLS\n" +
            "616: SURREY\n" +
            "617: OXNARD\n" +
            "619: MILWAUKEE\n" +
            "620: ASHEVILLE\n" +
            "621: AURORA\n" +
            "622: CULVER CITY\n" +
            "623: FORT WORTH\n" +
            "625: BROOKLYN\n" +
            "632: VERO BEACH\n" +
            "634: CASTLE ROCK\n" +
            "635: DAYTON\n" +
            "637: PARAMUS\n" +
            "640: CHERRY HILL\n" +
            "641: SOUTH MIAMI\n" +
            "642: GILBERT\n" +
            "643: LA MESA\n" +
            "644: PRINCETON OUTLET\n" +
            "645: HOUSTON OUTLET\n" +
            "646: IRVINE\n" +
            "647: LYNNWOOD OUTLET\n" +
            "648: NASHVILLE OUTLET\n" +
            "649: LUTHERVILLE\n" +
            "650: MINNEAPOLIS OUTLET\n" +
            "652: BLOOMFIELD HILLS\n" +
            "653: PLEASANTON\n" +
            "656: SAN RAFAEL\n" +
            "657: CLEARWATER\n" +
            "658: SCHAUMBURG\n" +
            "660: VISTA\n" +
            "998: CSC\n" +
            "999: CSC TRADE\n" +
            "1215604999412305400: WEST JEFFERSON\n" +
            "7151338032671807000: NORTH EAST";


    @Then("I expect that I am on the Concierge Dashboard page")
    public void iExpectThatIAmOnTheConciergeDashboardPage() {

        assertTrue(conciergeUserAccountPage.getUserNameButton().isDisplayed());
        assertTrue(conciergeUserAccountPage.getArtButtonMenu().getText().equals("ART"));
        assertTrue(conciergeUserAccountPage.getBathButtonMenu().getText().equals("BATH"));
        assertTrue(conciergeUserAccountPage.getBedButtonMenu().getText().equals("BED"));
        assertTrue(conciergeUserAccountPage.getProjectsButton().getText().equals("PROJECTS"));
        assertTrue(conciergeUserAccountPage.getLocationButton().isDisplayed());
        assertTrue(conciergeUserAccountPage.getInStockButtonMenu().getText().equals("IN STOCK"));
        assertTrue(conciergeUserAccountPage.getLivingButtonMenu().getText().equals("LIVING"));
        assertTrue(conciergeUserAccountPage.getDiningButtonMenu().getText().equals("DINING"));
        assertTrue(conciergeUserAccountPage.getLightingButtonMenu().getText().equals("LIGHTING"));
        assertTrue(conciergeUserAccountPage.getTextilesButtonMenu().getText().equals("TEXTILES"));
        assertTrue(conciergeUserAccountPage.getRugsButtonMenu().getText().equals("RUGS"));
        assertTrue(conciergeUserAccountPage.getWindowsButtonMenu().getText().equals("WINDOWS"));
        assertTrue(conciergeUserAccountPage.getDecorButtonMenu().getText().equals("DÉCOR"));
        assertTrue(conciergeUserAccountPage.getOutdoorButtonMenu().getText().equals("OUTDOOR"));
        assertTrue(conciergeUserAccountPage.getGiftsButtonMenu().getText().equals("GIFTS"));
        assertTrue(conciergeUserAccountPage.getSaleButtonMenu().getText().equals("SALE"));


    }

    @When("I change my store to store number 10")
    public void iChangeMyStoreToStoreNumber() throws InterruptedException {
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getPaloAltpGallery().click();
        conciergeUserAccountPage.getGallerySubmitButton().click();
    }

    @Then("I verify I see store Palo Alto in the header")
    public void iVerifyISeeStoreInTheHeader() {
        wait.until(ExpectedConditions.textToBePresentInElement(conciergeUserAccountPage.getNewPortBeachGallery(), "PALO ALTO"));
        assertTrue(conciergeUserAccountPage.getNewPortBeachGallery().getText().equals("PALO ALTO"));
    }


    @Given("I login into Concierge with valid credentials for the store 146: West Hollywood")
    public void iLoginIntoConciergeWithValidCredentialsForTheStoreWestHollywood() {
        conciergeLoginPage.getUsernameField().sendKeys("mdovbenco");
        conciergeLoginPage.getPasswordField().sendKeys("171096workouT!");
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationWestHolywood().click();
        conciergeLoginPage.getContinueButton().click();
    }

    @Then("user verifies list of galleries")
    public void userVerifiesListOfGalleries() throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElement(conciergeUserAccountPage.getGallerySelectButton(), "NEWPORT"));
        String actualListOfGalleries = conciergeUserAccountPage.getGallerySelectButton().getText();
        assertTrue(actualListOfGalleries.equals(actualListOfGalleries));
    }

    @When("user clicks on gallery button from header")
    public void userClicksOnGalleryButtonFromHeader() {
        wait.until(ExpectedConditions.visibilityOf(conciergeUserAccountPage.getNewPortBeachGallery()));
        conciergeUserAccountPage.getNewPortBeachGallery().click();
    }

    @Given("I log into Concierge as {string}")
    public void iLogIntoConciergeAs(String arg0) {
        generalStepDefs.loginAsRole(arg0);
    }


    @Given("I am on concierge dashboard for the store 146:West Hollywood")
    public void iAmOnConciergeDashboardForTheStoreWestHollywood() {
        generalStepDefs.loginAsRole("aleader");
        conciergeUserAccountPage.getNewPortBeachGallery().click();
        conciergeUserAccountPage.getWestHollywood().click();
//        conciergeUserAccountPage.getGallerySubmitButton().click();
    }

    @When("I have the following items in the cart:")
    public void iHaveTheFollowingItemsInTheCart() {
        wait.until(ExpectedConditions.visibilityOf(conciergeUserAccountPage.getCartButton()));
        conciergeUserAccountPage.getCartButton().click();
    }


}

