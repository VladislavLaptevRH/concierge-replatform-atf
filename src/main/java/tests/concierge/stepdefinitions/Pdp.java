package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.*;

public class Pdp {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    PdpScreen pdpScreen = new PdpScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    SelectOption selectOption = new SelectOption();

    ConciergeE2EStepDefs conciergeE2EStepDefs = new ConciergeE2EStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();


    public static String firstProductNameInPG;
    public static String regularPriceInPG;
    public static String memberPriceInPG;
    public static String tradePriceInPG;
    public String zipCodeInTheCart;
    public static String tradePriceInPDP;

    public static String SKU;

    @When("I click on add monogram checkbox from pdp")
    public void iClickOnAddMonogramCheckboxFromPdp() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getAddMonogramCheckBoxPdp().click();
    }

    @When("I choose monogram properties for pdp")
    public void iChooseMonogramPropertiesForPdp() {
//        conciergeCartPageScreen.getMonogramColors().get(2).should(visible, Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).click();
//        conciergeItemsScreen.getMonogramColorChampagne().should(visible, Duration.ofSeconds(40));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getMonogramColorChampagne().scrollIntoView(true);
        conciergeItemsScreen.getMonogramColorChampagne().click();
        conciergeCartPageScreen.getMonogramText().setValue("test");
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was added for pdp")
    public void iVerifyThatMonogramWasAddedForPdp() {
        $(By.xpath("//*[text()='Bauer Bodoni 1 (BDNI-HC)']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Text']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Style']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Color']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='MCHA']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on \"view in stock items\" link")
    public void iClickOnViewInStockItems() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='In-Stock']")).shouldHave(text("In-Stock"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='In-Stock']")).scrollIntoView(true);
        $(By.xpath("//*[text()='In-Stock']")).click();
    }

    @Then("I verify that in stock modal pop up is displayed")
    public void iVerifyThatInStockModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='IN STOCK']")).shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on \"view select items on sale\" link")
    public void iClickOnViewSaleItems() {
        try {
            $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).should(visible, Duration.ofSeconds(10));
        } catch (ElementNotFound e){
            System.out.println("Element not found");
        }
        if(!$(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).scrollIntoView(true);
        $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).click();
    }

    @When("Verify that \"Sale modal\" {string}")
    public void verifySaleModalData(String data) {
       switch (data){
           case  "opens":
               $(By.xpath("//*[text()='ON SALE']")).should(visible, Duration.ofSeconds(20));;
               break;
           case  "has a title":
               $(By.xpath("//div/p[text()='French Contemporary Fabric Panel Bed']")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has item#":
               with().pollInterval(5, SECONDS).await().until(() -> true);
               if(!$(By.xpath("(//*[@id='listColumn1-Item#'])[1]")).isDisplayed()){
                   WebDriverRunner.getWebDriver().navigate().refresh();
                   with().pollInterval(5, SECONDS).await().until(() -> true);
               }
               $(By.xpath("(//*[@id='listColumn1-Item#'])[1]")).shouldHave(text("Item#"), Duration.ofSeconds(5));
               $(By.xpath("(//*[@id='listColumn2-Item#'])[1]")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has price, member and sale price":
               $(By.xpath("(//*[@id = 'sku-price-list']//*[text()='Price'])[1]")).shouldHave(text("Price"), Duration.ofSeconds(5));
               if($(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--member') and text() = 'Member'])[1]")).isDisplayed()){
                   $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--member') and text() = 'Member'])[1]")).shouldHave(text("Member"), Duration.ofSeconds(5));
               } else {
                   $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--trade') and text() = 'Trade'])[1]")).shouldHave(text("Trade"), Duration.ofSeconds(5));
               }
               $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--sale') and text() = 'Sale'])[1]")).shouldHave(text("Sale"), Duration.ofSeconds(5));
               $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount')])[1]")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has qty dropdown":
               $(By.xpath("//*[text()='Qty']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[@data-testid='in-stock-qty-select']")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has \"add to cart\" and \"add to project\" buttons":
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener']")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has an item can be added to cart from modal":
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener']")).click();
               with().pollInterval(5, SECONDS).await().until(() -> true);
               $(By.xpath("//*[@id = 'ajax-proceed-to-cart']/span[1]")).should(visible, Duration.ofSeconds(20));
               $(By.xpath("//*[@id = 'ajax-continue-shopping']/span[1]")).should(visible, Duration.ofSeconds(20));
               $(By.xpath("(//*[@data-testid = 'dialog-title-close-button'])[2]")).click();
               break;
           case  "has an item can be added to project from modal":
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener']")).click();
               $(By.xpath("//h3[text() = 'ADD TO PROJECT']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[text() = 'CANCEL']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[text() = 'SAVE']")).should(visible, Duration.ofSeconds(5));
               break;
           default:
               break;
       }
    }

    @When("Verify that {string}")
    public void verifyData(String data) {
        switch (data){
            case  "shop the entire collection is present":
                $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "zoom button is clickable and zoom module is opened":
                $(By.xpath("//*[@id= 'Grommet/ZoomIn']")).click();
                $(By.xpath("//*[@id= 'Grommet/ZoomOut']")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'PDP']//*[@id= 'Grommet/ZoomIn'])[2]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "view carousel is present on the right of the zoomed hero image and scrolling are present":
                $(By.xpath("//*[@class= 'slick-slider slick-vertical slick-initialized']")).shouldBe(visible, Duration.ofSeconds(15));
                boolean arrowsCount = $$(By.xpath("//*[@class= 'slick-slider slick-vertical slick-initialized']//*[contains(@class, 'arrow-icon')]")).size() == 2;
                assertTrue(arrowsCount);
                break;
            case  "plus and minus buttons are clickable and functioning":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@class = 'slick-slider slick-vertical slick-initialized']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/prod18890296')])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@class= 'slick-slider slick-vertical slick-initialized']//*[contains(@class, 'arrow-icon')])[2]")).click();
                $(By.xpath("(//*[@class = 'slick-slider slick-vertical slick-initialized']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/prod18890296')])[1]")).shouldNot(visible, Duration.ofSeconds(15));
                break;
            case  "close the Zoom in Module":
                $(By.xpath("(//button[@class = 'MuiButtonBase-root MuiIconButton-root'])[2]")).click();
                $(By.xpath("//*[@class= 'slick-slider slick-vertical slick-initialized']")).shouldNotBe(visible, Duration.ofSeconds(15));
                break;
            case  "left and right arrows are present and number of alt images is 5":
                $(By.xpath("(//*[contains(@class, 'arrow-container')])[3]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[contains(@class, 'arrow-container')])[4]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'component-rh-image'])[7]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'component-rh-image'])[8]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'component-rh-image'])[9]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'component-rh-image'])[10]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'component-rh-image'])[11]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "line item selections (Size, Finish and Qty) are present":
                $(By.xpath("//*[contains(@id, 'optionSelect') and text() = 'Size']/..//select")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[contains(@id, 'optionSelect') and text() = 'Finish']/..//select)[1]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[contains(@id, 'qty-input-label') and text() = 'QTY']/..//select)[1]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "smaller preview product picture is present on the left of line items":
                $(By.xpath("//img[@alt = 'T-Brace Rectangular Extension Dining Table']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "view in-stock Items and View Sale Items links are present":
                $(By.xpath("(//*[contains(@data-testid , 'productImageLink')]/../span)[1]")).shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
                break;
            case  "text \"Configure this item to view delivery information to\" is present":
                $(By.xpath("(//*[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//*[text() = 'Configure this item to view delivery information ']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text Swatch is present":
                $(By.xpath("//a/*[contains(text(), 'Swatch')]")).shouldHave(text("Swatch"), Duration.ofSeconds(5));
                break;
            case  "Swatch image is present":
                $(By.xpath("//img[@alt = 'T-Brace Collection Swatch']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "line item for Swatch is present":
                boolean swatchItems = $$(By.xpath("(//p[contains(text() , 'Swatch')])[1]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 2;
                assertTrue(swatchItems);
                break;
            case  "text \"Swatches are shipped at no charge\" is present":
                $(By.xpath("//*[text() = 'Swatches are shipped at no charge. For free USPS expedited delivery to arrive within 2-3 business days, all swatches must be placed in a separate order from product orders.']")).shouldHave(text("Swatches are shipped at no charge. For free USPS expedited delivery to arrive within 2-3 business days, all swatches must be placed in a separate order from product orders."), Duration.ofSeconds(5));
                break;
            case  "text Furniture Touch-up Kit is present":
                $(By.xpath("//*[contains(text(), 'Furniture Touch-Up Kit')]")).shouldHave(text("Furniture Touch-Up Kit"), Duration.ofSeconds(5));
                break;
            case  "button Check for Replacement parts is present":
                $(By.xpath("(//*[text() ='CHECK FOR REPLACEMENT PARTS'])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text \"This item will be ready for delivery between\" is present":
                if (!$(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'This item will be ready for delivery between')]")).isDisplayed()) {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(0);
                        with().pollInterval(1, SECONDS).await().until(() -> true);
                    sizeList.selectByIndex(1);
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                }
                $(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'This item will be ready for delivery between')]")).shouldHave(text("This item will be ready for delivery between"), Duration.ofSeconds(15));
                break;
            case  "text \"Unlimited Furniture Delivery\" is present":
                $(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'Unlimited Furniture Delivery')]")).shouldHave(text("Unlimited Furniture Delivery"), Duration.ofSeconds(5));
                break;
            case  "text \"This item can be returned or exchanged within 30 days of delivery\" is present":
                $(By.xpath("//*[@id = 'component-sku']/..//p[contains (text(), 'This item can be returned or exchanged within 30 days of delivery. ')]")).shouldHave(text("This item can be returned or exchanged within 30 days of delivery. "), Duration.ofSeconds(5));
                break;
            case  "Add to Cart and Add to Project buttons are active":
                $(By.xpath("(//*[@id = 'add-to-cart-button'])[1][@disabled]")).shouldNot(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id = 'add-to-project-button'])[1][@disabled]")).shouldNot(visible, Duration.ofSeconds(15));
                break;
            case  "Add to Cart and Add to Project buttons are inactive":
                $(By.xpath("(//*[@id = 'add-to-cart-button'])[1][@disabled]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id = 'add-to-project-button'])[1][@disabled]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "confirm that Add to Cart slider is present":
                $(By.xpath("(//*[@id = 'add-to-cart-button'])[1]")).click();
                $(By.xpath("//*[text() = '1 Item  Added To Your Cart']")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("//button[@id = 'ajax-proceed-to-cart']/*[text() = 'View Cart']")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("//button[@id = 'ajax-continue-shopping']/*[text() = 'Keep Shopping']")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("//button[@id = 'ajax-continue-shopping']/*[text() = 'Keep Shopping']")).click();
                break;
            case  "confirm that Add to Cart slider for SO is present":
                $(By.xpath("//h2[text() = 'Special Order']")).shouldHave(text("Special Order"), Duration.ofSeconds(20));
                break;
            case  "verify data in the modal for SO":
                with().pollInterval(9, SECONDS).await().until(() -> true);
                $(By.xpath("//h3[text() = 'Cloud Modular Leather Corner Chair']")).shouldHave(text("Cloud Modular Leather Corner Chair"), Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Item #']")).shouldHave(text("Item #"), Duration.ofSeconds(20));
                $(By.xpath("//*[text() = '59810779 CTBZ']")).shouldHave(visible, Duration.ofSeconds(15));
                assertEquals(SKU, $(By.xpath("//*[text() = '59810779 CTBZ']")).getText());
                if($(By.xpath("(//*[contains(@class, 'item-price__amount--member')])[1]")).isDisplayed()){
                    $(By.xpath("(//*[contains(@class, 'item-price__amount--member')])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                    memberPriceInPG = $(By.xpath("(//*[contains(@class, 'item-price__amount--member')])[1]")).getText().substring(0, 6);
                    $(By.xpath("(//*[contains(@class, 'item-price__amount')])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                    regularPriceInPG = $(By.xpath("//*[contains(@class,'item-price__amount') and text() = 'Regular']")).getText().substring(0, 6);
                } else {
                    $(By.xpath("(//*[contains(@class, 'item-price__amount')])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                    tradePriceInPDP =  $(By.xpath("(//*[contains(@class, 'item-price__amount')])[1]")).getText();
                    $(By.xpath("(//*[contains(@class, 'item-price__amount')])[2]")).shouldHave(visible, Duration.ofSeconds(15));
                    regularPriceInPG = $(By.xpath("(//*[contains(@class, 'item-price__amount')])[2]")).getText();
                }
                break;
            case  "text \"Components starting at\" is present":
                $(By.xpath("//*[text() = 'Components starting at']")).shouldHave(text("Components starting at"), Duration.ofSeconds(15));
                break;
            case  "click Agree and add to cart":
                $(By.xpath("//*[@id = 'spo-auth-addToCart']")).click();
                break;
            case  "cart page has item (SKU)":
                assertEquals(SKU, $(By.xpath("(//*[@id = 'listColumn2-Item#'])[1]")).getText());
                break;
            case  "price is matching PDP":
                if($(By.xpath("//*[@data-testid= 'price-for-member']")).isDisplayed()){
                    assertEquals( memberPriceInPG.replaceAll(" ", ""),  $(By.xpath("//*[@data-testid= 'price-for-member']")).getText().replaceAll(".00", ""));
                } else {
                    assertEquals( tradePriceInPDP,  $(By.xpath("//*[@data-testid= 'price-for-trade']")).getText().replaceAll(".00", ""));
                }
                assertEquals( regularPriceInPG, $(By.xpath("(//*[@data-testid= 'price-for-regular'])[1]")).getText().substring(0, 6));
                break;
            case  "PDP has SALE and MEMBER prices":
                $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@data-testid = 'price-for-sale'])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@data-testid = 'price-label-sale'])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "default US zip code is present in PDP":
                $(By.xpath("(//*[@id = 'component-sku']//span)[1]")).shouldBe(visible, Duration.ofSeconds(20));
                if($(By.xpath("//*[@data-testid= 'price-for-member']")).isDisplayed()){
                    memberPriceInPG = $(By.xpath("(//*[@data-testid= 'price-for-member'])[1]")).getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "");
                } else {
                    tradePriceInPG = $(By.xpath("(//*[@data-testid= 'price-for-trade'])[1]")).getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "");
                }
                regularPriceInPG = $(By.xpath("(//*[@data-testid= 'price-for-regular'])[1]")).getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "");
                break;
            case  "price in PDP changed from US$ to CA$":
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[@id = 'component-sku']//span)[1]")).shouldBe(visible, Duration.ofSeconds(20));
                if($(By.xpath("//*[@data-testid= 'price-for-member']")).isDisplayed()){
                    assertTrue(Integer.parseInt(memberPriceInPG) < Integer.parseInt($(By.xpath("(//*[@data-testid= 'price-for-member'])[1]")).getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "")));
                } else {
                    pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                    $(By.xpath("(//*[@data-testid= 'price-for-trade'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                    assertTrue(Integer.parseInt(tradePriceInPG) < Integer.parseInt($(By.xpath("(//*[@data-testid= 'price-for-trade'])[1]")).getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "")));
                }
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[@data-testid= 'price-for-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                assertTrue(Integer.parseInt(regularPriceInPG) < Integer.parseInt($(By.xpath("(//*[@data-testid= 'price-for-regular'])[1]")).getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "")));
                break;
            case  "Confirm that PDP has price in GBP":
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[@id = 'component-sku']//span)[1]")).shouldBe(visible, Duration.ofSeconds(20));
                if($(By.xpath("//*[@data-testid= 'price-for-member']")).isDisplayed()){
                   assertEquals("£" ,$(By.xpath("(//*[@data-testid= 'price-for-member'])[1]")).getText().substring(0,1));
                } else {
                    pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                    $(By.xpath("(//*[@data-testid= 'price-for-trade'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                    assertEquals("£" ,$(By.xpath("(//*[@data-testid= 'price-for-trade'])[1]")).getText().substring(0,1));
                }
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[@data-testid= 'price-for-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                assertEquals("£" ,$(By.xpath("(//*[@data-testid= 'price-for-regular'])[1]")).getText().substring(0,1));
                break;
            case  "sku is present in Cart":
                assertEquals(SKU,  $(By.xpath("(//*[@id= 'listColumn2-Item#'])[1]")).getText());
            case  "user is logged in":
                assertEquals(SKU,  $(By.xpath("(//*[@id= 'listColumn2-Item#'])[1]")).getText());
                break;
            default: break;
        }
    }

    @When("I choose a random sale item")
    public void iChooseARandomSaleItem() {
        Random rand = new Random();
        $(By.xpath("//a/img[@class = 'desktop-img']")).shouldHave(visible, Duration.ofSeconds(30));
        int randomCollection = rand.nextInt($$(By.xpath("//a/img[@class = 'desktop-img']")).size());
        if(randomCollection == 0){
            int randomCollectionAgain = rand.nextInt($$(By.xpath("//a/img[@class = 'desktop-img']")).size());
            $(By.xpath("(//a/img[@class = 'desktop-img'])[" + randomCollectionAgain + "]")).click();
        } else {
            $(By.xpath("(//a/img[@class = 'desktop-img'])[" + randomCollection + "]")).click();
        }
        $(By.xpath("//p/span")).shouldHave(visible, Duration.ofSeconds(30));
        int randomItem = rand.nextInt($$(By.xpath("//p/span")).size());
        if(randomItem == 0){
            int randomItemAgain = rand.nextInt($$(By.xpath("//p/span")).size());
            $(By.xpath("(//p/span)[" + randomItemAgain + "]")).click();
        } else {
            $(By.xpath("(//p/span)[" + randomItem + "]")).click();
        }
    }

    @Then("I verify text {string}")
    public void iVerifyString(String text) {
        $(By.xpath("//*[text()='" + text + "']")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='" + text + "']")).shouldHave(text(text), Duration.ofSeconds(20));
    }

    @Then("I click on {string} switch button")
    public void iClickOnSwitchButton(String button) {
        switch (button) {
            case "Add an item to cart from pop-up modal":
                $(By.xpath("(//*[@data-testid = 'add-to-cart-dialog-opener'])[8]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@data-testid = 'add-to-cart-dialog-opener'])[8]")).click();
                break;
            default: break;
        }
    }

    @Then("I verify that text item# and SKU {string} is present")
    public void iVerifyTextItemAndSKUIsPresent(String data) {
        $(By.xpath("//*[@id = 'component-sku']/..//p[contains (text(), 'Item# " + data + "')]")).shouldHave(text("Item# " + data + ""), Duration.ofSeconds(15));
        SKU = $(By.xpath("//*[@id = 'component-sku']/..//p[contains (text(), 'Item# " + data + "')]")).getText().substring(6,19);
    }

    @Then("Verify that line item field {string} is present")
    public void iVerifyLineItemFieldIsPresent(String lineItem) {
        $(By.xpath("(//*[contains(@id, '" + lineItem + "-label') and text() = '" + lineItem + "']/..//select)[1]")).shouldHave(visible, Duration.ofSeconds(15));
    }

    @Then("I choose option {string}")
    public void iChooseOption(String option) {
        $(By.xpath("//*[@alt = '" + option + "']")).click();
    }

    @Then("verify that another modal appears with all the data for {string}")
    public void iVerifyAnotherModalAppearsWithAllTheData(String data) {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text() = 'SAVE']")).shouldBe(enabled, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'SAVE']")).click();
        $(By.xpath("(//h3)[2]")).shouldHave(text("1 ITEM ADDED TO TESTCOMPANY"), Duration.ofSeconds(20));
        $(By.xpath("(//img[@alt = 'T-Brace Rectangular Extension Dining Table'])[2]")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//h6[text() = 'T-Brace Rectangular Extension Dining Table']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//h6[text() = 'T-Brace Rectangular Extension Dining Table']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn1-Item#' and text() = 'Item#']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Item#' and text() = '" + data + "']")).shouldHave(visible, Duration.ofSeconds(15));
        assertEquals(SKU, $(By.xpath("//*[@id = 'listColumn2-Item#' and text() = '" + data + "']")).getText());
        $(By.xpath("//*[@id = 'listColumn1-Quantity' and text() = 'Quantity']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Quantity' and text() = '1']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn1-Finish' and text() = 'Finish']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Finish' and text() = 'Waxed Grey Oak/Pewter']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn1-Size' and text() = 'Size']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Size' and text() = '72\"-108\"L Extension']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'CONTINUE SHOPPING']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'GO TO PROJECT']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'CONTINUE SHOPPING']")).click();
        $(By.xpath("//*[text() = 'GO TO PROJECT']")).shouldNotHave(visible, Duration.ofSeconds(15));
    }

    @Then("Project modal appears and has all the data for {string}")
    public void iVerifyProjectModalAppearsAndHasAllTheData(String SKU) {
        $(By.xpath("(//*[@id = 'add-to-project-button'])[1]")).click();
        conciergeProjectScreen.getAddToProjectProjectName().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getAddToProjectProjectName().click();
        conciergeProjectScreen.getProjectNamePopUpDropDownListItem().scrollIntoView(true);
        conciergeProjectScreen.getProjectNamePopUpDropDownListItem().click();
        $(By.xpath("(//*[text() = 'T-Brace Rectangular Extension Dining Table'])[4]")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("(//*[@alt = 'T-Brace Rectangular Extension Dining Table'])[2]")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn1-Item#' and text() = 'Item#']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Item#' and text() = '" + SKU + "']")).shouldHave(visible, Duration.ofSeconds(15));
        assertEquals(SKU,  $(By.xpath("//*[@id = 'listColumn2-Item#' and text() = '" + SKU + "']")).getText());
        $(By.xpath("//*[@id = 'listColumn1-Quantity' and text() = 'Quantity']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Quantity' and text() = '1']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn1-Finish' and text() = 'Finish']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Finish' and text() = 'Waxed Grey Oak/Pewter']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn1-Size' and text() = 'Size']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'listColumn2-Size' and text() = '72\"-108\"L Extension']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'project-name-label']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'project-name']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'project-opportunity-select-label']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'project-opportunity-select']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'project-space-select-label']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[@id = 'project-space-select']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'ADD NEW PROJECT']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'ADD NEW SPACE']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'CANCEL']")).shouldHave(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text() = 'SAVE']")).shouldHave(visible, Duration.ofSeconds(15));
    }

    @Then("I chose zero choose in line items")
    public void iChoseZeroChooseInLineItems(){
       int lineItemsCount = $$(By.xpath("(//a[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//select[contains(@id, 'prod')]/option/..")).size();
       for(int i = 1;  i <= lineItemsCount; i++){
           Select itemList = new Select($(By.xpath("((//a[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//select[contains(@id, 'prod')]/option/..)[" + i + "]")));
           try {
               itemList.selectByIndex(0);
           } catch (UnsupportedOperationException e){
               WebDriverRunner.getWebDriver().navigate().refresh();
               itemList.selectByIndex(0);
           }
       }
    }

    @Then("I chose the {string} line item selections one by one")
    public void iChoseLineItemSelectionsOneByOne(String chose) {
        int lineItemsCount = $$(By.xpath("(//a[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//select[contains(@id, 'prod')]/option/..")).size();
        for (int i = 1; i <= lineItemsCount; i++) {
            Select itemList = new Select($(By.xpath("((//a[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//select[contains(@id, 'prod')]/option/..)[" + i + "]")));
            if (i != lineItemsCount) {
                try {
                    itemList.selectByIndex(Integer.parseInt(chose));
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                } catch (UnsupportedOperationException e) {
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    itemList.selectByIndex(Integer.parseInt(chose));
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                }
            } else {
                try {
                    itemList.selectByIndex(Integer.parseInt(chose) + 1);
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                } catch (UnsupportedOperationException e) {
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    itemList.selectByIndex(Integer.parseInt(chose) + 1);
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                }
            }
        }
    }

    @When("I Verify that {string} is present")
    public void verifyTat(String data) {
        switch (data){
            case  "PDP title":
                $(By.xpath("//h2[contains(@class, MuiTypography-h2)]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "view select items on sale link":
                $(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "wording also available in":
                $(By.xpath("//a[contains(text(), 'ALSO AVAILABLE')]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "wording shop the entire collection":
                $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "verify that dynamic and static colorization options are present":
                $(By.xpath("//*[contains(@data-testid, 'SELECT FROM')]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]/following-sibling::div//img")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'Finish Options']")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']")).shouldBe(visible, Duration.ofSeconds(15));
                boolean finishOption = $$(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']")).size() > 1;
                assertTrue(finishOption);
                break;
            case  "the \"Hero\" Image":
                $(By.xpath("//*[@data-testid = 'desktop-pdp-image']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "\"Zoom\" button":
                $(By.xpath("//*[@id= 'Grommet/ZoomIn']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "images carousel is present below Hero image":
                $(By.xpath("//*[@class= 'slick-slider slick-initialized']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "sections \"dimensions\" and \"details\"":
                $(By.xpath("//*[text() = 'DIMENSIONS']")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'DETAILS']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "section \"lather care\" or \"fabric care\"":
                try {
                    $(By.xpath("//*[text() = 'Leather Care']")).shouldBe(visible, Duration.ofSeconds(15));
                } catch (ElementNotFound e){
                    $(By.xpath("//*[text() = 'Fabric Care']")).shouldBe(visible, Duration.ofSeconds(15));
                }
                break;
            case  "line items are present":
                boolean lineItems = $$(By.xpath("//select[contains(@id, 'optionSelect')]")).size() > 1;
                assertTrue(lineItems);
                break;
            case  "\"add to cart\" and \"add to project\" buttons":
                $(By.xpath("(//*[@id = 'add-to-cart-button'])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id = 'add-to-project-button'])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text \"Learn more about our Return Policy\"":
                $(By.xpath("(//*[text() = 'Learn more about our'])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[text() = 'Return Policy'])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "YAML carousel":
                $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/../ul")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Items listed in YAML carousel have titles and regular and member price":
                boolean titlesYAMLSize = $$(By.xpath("//*[contains(@data-testid ,'productCardLink')]//span")).size() > 1;
                boolean regularPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-regular']")).size() > 1;
                boolean memberPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-member']")).size() > 1;
                assertTrue(titlesYAMLSize);
                assertTrue(regularPriceYAMLSize);
                assertTrue(memberPriceYAMLSize);
                break;
            case  "\"footer\" in PDP":
                $(By.xpath("//*[@id = 'footer']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            default:
                break;
        }
    }

    @When("I verify the rest of the checkings for {string}")
    public void iVerifyTheRestOfTheCheckingsFor(String SKU) {
         if(SKU.equals("57070740 CLNT")){
             $(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//a[contains(text(), 'ALSO AVAILABLE')]")).shouldBe(visible, Duration.ofSeconds(15));
//             $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[contains(@data-testid, 'SELECT FROM')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]/following-sibling::div//img")).shouldBe(visible, Duration.ofSeconds(15));
             try {
                 $(By.xpath("//*[text() = 'Leather Care']")).shouldBe(visible, Duration.ofSeconds(15));
             } catch (ElementNotFound e){
                 $(By.xpath("//*[text() = 'Fabric Care']")).shouldBe(visible, Duration.ofSeconds(15));
             }
             boolean optionSelectItems = $$(By.xpath("(//*[contains(@data-testid ,'productTitleLink')])[1]/../../../../../..//select[contains(@id ,'prod')]")).size() == 5;
             assertTrue(optionSelectItems);
             $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/../ul")).shouldBe(visible, Duration.ofSeconds(15));
             boolean titlesYAMLSize = $$(By.xpath("//*[contains(@data-testid ,'productCardLink')]//span")).size() > 1;
             boolean regularPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-regular']")).size() > 1;
             if($(By.xpath("(//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-member'])[1]")).isDisplayed()){
                 boolean memberPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-member']")).size() > 1;
                 assertTrue(memberPriceYAMLSize);
             } else {
                 boolean memberPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-trade']")).size() > 1;
                 assertTrue(memberPriceYAMLSize);
             }
             assertTrue(titlesYAMLSize);
             assertTrue(regularPriceYAMLSize);
         }
         if(SKU.equals("61970975 TEAK")){
             $(By.xpath("//a[contains(text(), 'ALSO AVAILABLE')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]")).shouldBe(visible, Duration.ofSeconds(15));

             $(By.xpath("//*[contains(@data-testid, 'SELECT FROM')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]/following-sibling::div//img")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'Finish Options']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']")).shouldBe(visible, Duration.ofSeconds(15));
             boolean finishOption = $$(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']")).size() > 1;
             assertTrue(finishOption);
             $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/../ul")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'Frame with Cushions Starting at']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span")).shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
             boolean viewItems = $$(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span")).size() > 1;
             assertTrue(viewItems);
             $(By.xpath("//*[text() = 'Care']")).shouldBe(visible, Duration.ofSeconds(15));
             boolean chaiseItems = $$(By.xpath("(//p[contains(text() , 'Chaise')])[1]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 2;
             assertTrue(chaiseItems);
             boolean cushionsItems = $$(By.xpath("(//p[contains(text() , 'Cushions')])[2]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 4;
             assertTrue(cushionsItems);
             boolean coversItems = $$(By.xpath("//p[contains(text() , 'COVERS')]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 2;
             assertTrue(coversItems);
             boolean swatchItems = $$(By.xpath("(//p[contains(text() , 'Swatch')])[1]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 4;
             assertTrue(swatchItems);
             boolean titlesYAMLSize = $$(By.xpath("//*[contains(@data-testid ,'productCardLink')]//span")).size() > 1;
             boolean regularPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-regular']")).size() > 1;
             if($(By.xpath("(//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-member'])[1]")).isDisplayed()){
                 boolean memberPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-member']")).size() > 1;
                 assertTrue(memberPriceYAMLSize);
             } else {
                 boolean memberPriceYAMLSize = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-trade']")).size() > 1;
                 assertTrue(memberPriceYAMLSize);
             }
             assertTrue(titlesYAMLSize);
             assertTrue(regularPriceYAMLSize);
         }
         if(SKU.equals("62870050 LOAK")){
             $(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span")).shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
             boolean viewItems = $$(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span")).size() > 1;
             assertTrue(viewItems);
             $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'Finish Options']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']")).shouldBe(visible, Duration.ofSeconds(15));
             boolean finishOption = $$(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']")).size() > 1;
             assertTrue(finishOption);
             boolean fromOption = $$(By.xpath("//*[contains(text() ,'From')]")).size() > 1;
             assertTrue(fromOption);
             if($(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).isDisplayed()){
                 boolean memberOption = $$(By.xpath("//*[contains(text() ,'Member')]")).size() > 1;
                 assertTrue(memberOption);
             } else {
                 boolean memberOption = $$(By.xpath("//*[contains(text() ,'Trade')]")).size() > 1;
                 assertTrue(memberOption);
             }
             $(By.xpath("//*[text() = 'Care']")).shouldBe(visible, Duration.ofSeconds(15));
             boolean benchItems = $$(By.xpath("(//p[contains(text() , 'Bench')])[1]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 3;
             assertTrue(benchItems);
             boolean swatchItems = $$(By.xpath("(//p[contains(text() , 'Swatch')])[1]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 2;
             assertTrue(swatchItems);
             boolean kitItems = $$(By.xpath("(//p[contains(text() , 'Touch-Up Kit')])[1]/../../../../../../..//select[contains(@id ,'prod')]")).size() == 2;
             assertTrue(kitItems);
         }
         if(SKU.equals("17050044 CAML")){
             $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/../ul")).shouldBe(visible, Duration.ofSeconds(15));
             boolean fromOption = $$(By.xpath("//*[contains(text() ,'From')]")).size() > 1;
             assertTrue(fromOption);
             if($(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).isDisplayed()){
                 boolean memberOption = $$(By.xpath("//*[contains(text() ,'Member')]")).size() > 1;
                 assertTrue(memberOption);
             } else {
                 boolean memberOption = $$(By.xpath("//*[contains(text() ,'Trade')]")).size() > 1;
                 assertTrue(memberOption);
             }
             $(By.xpath("(//*[contains(text() ,'SALE')])[3]")).shouldBe(visible, Duration.ofSeconds(15));
             boolean saleOption = $$(By.xpath("//*[contains(text() ,'SALE')]")).size() >=4;
             assertTrue(saleOption);
             $(By.xpath("//*[text() ='Color Options']")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("(//*[contains(@data-testid , 'productImageLink')]/../span)[1]")).shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
             boolean viewItems = $$(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span[1]")).size() > 1;
             assertTrue(viewItems);
             $(By.xpath("//*[text() ='Color Options']/following-sibling::ul")).shouldBe(visible, Duration.ofSeconds(15));
             $(By.xpath("//*[text() ='CHECK FOR REPLACEMENT PARTS']")).shouldBe(visible, Duration.ofSeconds(15));
         }
    }

    @When("Verify that \"In Stock modal\" {string}")
    public void verifyInStockModalData(String data) {
        switch (data){
            case  "opens":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("//*[text()='IN STOCK']")).shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
                $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[@id= 'listColumn2-Item#'])[1]")).shouldBe(visible, Duration.ofSeconds(15));
                SKU =  $(By.xpath("(//*[@id= 'listColumn2-Item#'])[1]")).getText();
                break;
            case  "has a title":
                $(By.xpath("//div/p[text()='French Contemporary Fabric Panel Bed']")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has item#":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                if(!$(By.xpath("(//*[@id='listColumn1-Item#'])[1]")).isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                }
                break;
            case  "has price and member price":
                $(By.xpath("(//*[@id = 'sku-price-list']//*[text()='Price'])[1]")).shouldHave(text("Price"), Duration.ofSeconds(5));
                if($(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--member') and text() = 'Member'])[1]")).isDisplayed()){
                    $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--member') and text() = 'Member'])[1]")).shouldHave(text("Member"), Duration.ofSeconds(5));
                } else {
                    $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--trade') and text() = 'Trade'])[1]")).shouldHave(text("Trade"), Duration.ofSeconds(5));
                }
                $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount')])[1]")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has qty dropdown":
                $(By.xpath("(//*[text()='Qty'])[1]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[@data-testid='in-stock-qty-select'])[4]")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has \"add to cart\" and \"add to project\" buttons":
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[4]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener'])[4]")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has an item can be added to cart from modal":
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[4]")).click();
                $(By.xpath("//*[@id = 'ajax-proceed-to-cart']/span[1]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[@id = 'ajax-continue-shopping']/span[1]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[@data-testid = 'dialog-title-close-button'])[2]")).click();
                break;
            case  "has an item can be added to project from modal":
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener'])[4]")).click();
                $(By.xpath("//h3[text() = 'ADD TO PROJECT']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text() = 'CANCEL']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text() = 'SAVE']")).should(visible, Duration.ofSeconds(5));
                break;
            default:
                break;
        }
    }

    @When("I go to custom rugs")
    public void iGoToCustomRugs() {
        $(By.xpath("//div[@data-navigation-account-item-id='rhbc_cat479005']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//div[@data-navigation-account-item-id='rhbc_cat479005']")).click();
        $(By.xpath("//*[text()='Rugs By Fiber']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Rugs By Fiber']")).click();
    }
    @Then("I verify that custom rugs are displayed")
    public void iVerifyThatCustomRugsAreDisplayed() {
        $(By.xpath("//*[text()='Wool Rugs']")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Performance Fiber Rugs']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I click on windows from top menu")
    public void iClickOnWindowsFromTopMenu() {
        $(By.xpath("//div[@data-navigation-account-item-id='cat160095']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//div[@data-navigation-account-item-id='cat160095']")).click();

        $(By.xpath("//*[text()='Custom Window Treatments']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Custom Window Treatments']")).click();
    }

    @Then("I verify that custom windows are displayed")
    public void iVerifyThatCustomWindowsAreDisplayed() {
        $(By.xpath("//*[text()='Custom Drapery Collections']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Custom Shades']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Custom Window Hardware']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that YAML carousel is displayed")
    public void iVerifyThatYAMLCarouselIsDisplayed() {
        $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']")).scrollTo();
        $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']")).scrollIntoView(true);
        List<String> items1 = new ArrayList<>();
        List<String> items2 = new ArrayList<>();
        List<String> expectedItems = new ArrayList<>(Arrays.asList("CLOUD SOFA", "CLOUD TRACK ARM SOFA" , "CLOUD SLOPE ARM MODULAR CUSTOMIZABLE SECTIONAL"));
        for (int i = 0; i < 3; i++) {
            items1.add(pdpScreen.getTtemYAMLListByNumber(i+1).getText());
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
        assertEquals(items1, expectedItems);
        $(By.xpath("(//*[text() = 'YOU MIGHT ALSO LIKE']/..//ul/div/div)[3]")).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        for (int i = 3; i < 6 ; i++) {
            items2.add(pdpScreen.getTtemYAMLListByNumber(i+1).getText());
        }
        assertNotEquals(items2, expectedItems);
    }

    @Then("I verify text \"Mattress fee\" and amount in checkout is present for state {string}")
    public void iVerifyTextMattressFeeAndAmountInCheckout(String state) {
        if(state.equals("CA")) {
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            assertEquals($(By.xpath("//*[text() = 'Mattress Fee']/../..//p")).getText(), "$10.50");
        }
        if(state.equals("RI")){
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            assertEquals($(By.xpath("//*[text() = 'Mattress Fee']/../..//p")).getText(), "$16.00");
        }
        if(state.equals("CT")){
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            assertEquals($(By.xpath("//*[text() = 'Mattress Fee']/../..//p")).getText(), "$11.75");
        }

    }

    @Then("I verify that text \"{string} requires a mattress recycling fee to be collected at checkout state\" is present in PDP")
    public void iVerifyMattressRecyclingFee(String state) {
        if(state.equals("CA")) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(1);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element Size not found");
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByIndex(2);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element qty not found");
                }
            }
            assertEquals("California requires a mattress recycling fee to be collected at checkout.", pdpScreen.getMattressRecyclingFeeText().getText());
        }
        if(state.equals("RI")){
            WebDriverRunner.getWebDriver().navigate().refresh();
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(1);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element Size not found");
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByIndex(2);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element qty not found");
                }
            }
            assertEquals("Rhode Island requires a mattress recycling fee to be collected at checkout.", pdpScreen.getMattressRecyclingFeeText().getText());
        }
        if(state.equals("CT")){
            WebDriverRunner.getWebDriver().navigate().refresh();
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(1);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element Size not found");
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByIndex(2);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element qty not found");
                }
            }
            assertEquals("Connecticut requires a mattress recycling fee to be collected at checkout.", pdpScreen.getMattressRecyclingFeeText().getText());
        }
    }

    @Then("I verify that replacements parts modal pop up is displayed")
    public void iVerifyThatReplacementsPartsModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='REPLACEMENT PARTS']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that check for replacements parts button is displayed")
    public void iVerifyThatCheckForReplacementsPartsButtonIsDisplayed() {
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).scrollTo();
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on special order fabrics")
    public void iClickOnSpecialOrderFabrics() {
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
            try {
                Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                sizeList.selectByIndex(1);
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException |
                     ElementNotFound e) {
                System.out.println("Element Size not found");
            }
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!pdpScreen.getSpecialOrdersButton().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        pdpScreen.getSpecialOrdersButton().should(visible, Duration.ofSeconds(40));
        pdpScreen.getSpecialOrdersButton().click();
    }

    @When("I choose color from special order fabrics")
    public void iChooseColorFromSpecialOrderFabrics() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        pdpScreen.getFogSpecialOrderColor().should(visible, Duration.ofSeconds(40));
        pdpScreen.getFogSpecialOrderColor().hover();
        pdpScreen.getFogSpecialOrderColor().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getCloseSpecialOrderPopUpButton().hover();
        pdpScreen.getCloseSpecialOrderPopUpButton().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }



    @Then("I verify that color has been chosen")
    public void iVerifyThatColorHasBeenChosen() {
        selectOption.getColorOption().shouldHave(text("Fog"), Duration.ofSeconds(20));

    }

    @Then("I confirm that default zip code for country {string} is present in Cart")
    public void confirmThatDefault(String country) {
        if(Objects.equals(country, "US")){
            zipCodeInTheCart = conciergeCartPageScreen.getPdpScreenZipCode().getText();
            assertEquals(zipCodeInTheCart, "92660");
        }
        if(Objects.equals(country, "GB")){
            zipCodeInTheCart = conciergeCartPageScreen.getPdpScreenZipCode().getText();
            assertEquals(zipCodeInTheCart, "94925");
        }
        if(Objects.equals(country, "CA")){
            zipCodeInTheCart = conciergeCartPageScreen.getPdpScreenZipCode().getText();
            assertEquals(zipCodeInTheCart, "M6A 2T9");
        }

    }

    @Then("I change state for {string} with zip code {string}")
    public void iChangeZipCodeFor(String state, String zipCode) {
        if(state.equals("CA")) {
            if (pdpScreen.getZipCode().getText().replaceAll("\\.", "").equals(zipCode)) {
                System.out.println("It's California");
            } else {
                pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getZipCode().click();
                pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getPostalCode().setValue(zipCode);
                pdpScreen.getConfirmationPostalCode().click();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
        }
        if(state.equals("RI")){
            pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getZipCode().click();
            pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getPostalCode().setValue(zipCode);
            pdpScreen.getConfirmationPostalCode().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if(state.equals("CT")){
            pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getZipCode().click();
            pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getPostalCode().setValue(zipCode);
            pdpScreen.getConfirmationPostalCode().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
    }

    @Then("I click on zip code and change it to {string}")
    public void iChangeZipCodeFor(String zipCode) {
      pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
      pdpScreen.getZipCode().click();
      pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
      pdpScreen.getPostalCode().setValue(zipCode);
      pdpScreen.getConfirmationPostalCode().click();
      with().pollInterval(9, SECONDS).await().until(() -> true);
    }

    @Then("I verify that zip code in PDP is {string}")
    public void iVerifyThatZipCodeIs(String zipCode) {
        $(By.xpath("(//*[@id = 'component-sku']//span)[1]")).shouldBe(visible, Duration.ofSeconds(20));
       String currentZipCode =  $(By.xpath("(//*[@id = 'component-sku']//span)[1]")).getText();
        assertEquals(currentZipCode, zipCode + ".");
    }

    @Then("I verify that availability, Delivery and returns messaging is displayed for {string}")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingIsDisplayedFor(String arg0) {

        if (arg0.equals("SO")) {
            if (!$(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).isDisplayed()) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
                $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).scrollTo();
                $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).should(visible, Duration.ofSeconds(30));

        }
        if (arg0.equals("BO")) {
            if (!$(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).isDisplayed()) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
            $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).scrollTo();
            $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).should(visible, Duration.ofSeconds(30));
        }
    }

    @Then("I remember the name of the first product and regular, member prices in PG and navigate to that PDP")
    public void iRememberTheNameOfTheFirstProductAndRegularMemberPriceInPG() {
        firstProductNameInPG = conciergeCartPageScreen.getFirstProductNameInPG().getText();
        regularPriceInPG = conciergeCartPageScreen.getRegularPriceInPG().getText();
        memberPriceInPG = conciergeCartPageScreen.getMemberPriceInPG().getText().replaceAll("[^0-9_$]", "");
        conciergeCartPageScreen.getFirstProductNameInPG().click();
    }

//    @Then("I remember the name of the first product and regular, member prices in PDP ")
//    public void iRememberTheNameOfTheFirstProductAndRegularMemberPriceInPG() {
//        firstProductNameInPG = conciergeCartPageScreen.getFirstProductNameInPG().getText();
//        regularPriceInPG = conciergeCartPageScreen.getRegularPriceInPG().getText();
//        memberPriceInPG = conciergeCartPageScreen.getMemberPriceInPG().getText().replaceAll("[^0-9_$]", "");
//        conciergeCartPageScreen.getFirstProductNameInPG().click();
//    }

    @Then("I Verify that the PDP title is present and prices match those prices in PG")
    public void iVerifyThatThePDPTitleIsPresentAndPricesMatchThosePricesInPG() {
        assertEquals(firstProductNameInPG, $(By.xpath("//h2[contains(@class, MuiTypography-h2)]")).getText());
        assertEquals(regularPriceInPG, conciergeCartPageScreen.getRegularPriceInPG().getText());
        assertEquals(memberPriceInPG, conciergeCartPageScreen.getMemberPriceInPG().getText().replaceAll(",", ""));
    }

    @When("I go to Swatch Landing Page")
    public void iGoToSwatchLandingPage() {
        String URL = Hooks.conciergeBaseURL + "/swatch/order.jsp";
        open(URL);
    }

    @Then("I verify that swatch landing page is displayed")
    public void iVerifyThatSwatchLandingPageIsDisplayed() {
        $(By.xpath("//*[text()='Premium Fabrics']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Premium Leathers']")).should(visible, Duration.ofSeconds(15));
    }
}
