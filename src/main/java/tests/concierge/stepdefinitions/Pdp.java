package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import com.codeborne.selenide.ex.ElementNotFound;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    public static String result = "";



    @When("I click on add monogram checkbox from pdp")
    public void iClickOnAddMonogramCheckboxFromPdp() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getAddMonogramCheckBoxPdp().click();
    }

    @When("I choose monogram properties for pdp")
    public void iChooseMonogramPropertiesForPdp() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getMonogramColorChampagne().scrollIntoView(true);
        conciergeItemsScreen.getMonogramColorChampagne().click();
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramText().setValue("test");
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was added for pdp")
    public void iVerifyThatMonogramWasAddedForPdp() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        pdpScreen.getMonogramsStyleValue().should(visible, Duration.ofMinutes(1));
        pdpScreen.getMonogramsText().should(visible, Duration.ofSeconds(15));
        pdpScreen.getMonogramsStyle().should(visible, Duration.ofSeconds(15));
        pdpScreen.getMonogramsColor().should(visible, Duration.ofSeconds(15));
        pdpScreen.getMonogramsColorsValue().should(visible, Duration.ofSeconds(15));
    }

    @When("I add monogram to product on concierge")
    public void iVerfiyThatIMAbleToChooseMonogramConcierge() {
        $(By.xpath("//*[text()='PERSONALIZE YOUR SELECTIONS']")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//input[@name='checkboxBauer Bodoni 2 (BDNI-HD)']")).click();
        $(By.xpath("//input[@name='checkboxTone-on-Tone (TOT)']")).click();
        $(By.xpath("//input[@data-testid='monogram-input0']")).should(appear, Duration.ofSeconds(25)).setValue("Text");
        $(By.xpath("//button[@data-testid='monogram-add-button']")).should(visible, Duration.ofSeconds(25)).click();
    }

    @When("I click on \"view in stock items\" link")
    public void iClickOnViewInStockItems() {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        pdpScreen.getViewOnStockItemLink().shouldHave(text("In-Stock"), Duration.ofSeconds(15));
        pdpScreen.getViewOnStockItemLink().scrollIntoView(true);
        pdpScreen.getViewOnStockItemLink().click();
    }

    @Then("I verify that in stock modal pop up is displayed")
    public void iVerifyThatInStockModalPopUpIsDisplayed() {
        pdpScreen.getInStockPopUpTitle().shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
        pdpScreen.getInStockPopUpOptionText().shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on \"view select items on sale\" link")
    public void iClickOnViewSaleItems() {
        try {
            pdpScreen.getViewSelectItemsOnSaleLink().should(visible, Duration.ofSeconds(10));
        } catch (ElementNotFound e){
            System.out.println("Element not found");
        }
        if(!pdpScreen.getViewSelectItemsOnSaleLink().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        pdpScreen.getViewSelectItemsOnSaleLink().scrollIntoView(true);
        pdpScreen.getViewSelectItemsOnSaleLink().click();
    }

    @When("Verify that \"Sale modal\" {string}")
    public void verifySaleModalData(String data) {
       switch (data){
           case  "opens":
               pdpScreen.getPdpPopUpOnSaleText().should(visible, Duration.ofSeconds(15));;
               break;
           case  "has a title":
               pdpScreen.getPdpPopUpOnSaleTitle().should(visible, Duration.ofSeconds(5));
               break;
           case  "zip code is present":
               pdpScreen.getPdpPopUpInStockZipCode().should(visible, Duration.ofSeconds(5));
               break;
           case  "click on the postal link present in message below product name":
               pdpScreen.getPdpPopUpInStockZipCode().click();
               break;
           case  "Modal should displayed the list of ON SALE items":
               assertTrue(pdpScreen.getModalOnSaleItemsList().size() > 1);
               break;
           case  "has item#":
               with().pollInterval(5, SECONDS).await().until(() -> true);
               if(!pdpScreen.getPdpPopUpOnSaleItem().isDisplayed()){
                   WebDriverRunner.getWebDriver().navigate().refresh();
                   with().pollInterval(5, SECONDS).await().until(() -> true);
               }
               pdpScreen.getPdpPopUpOnSaleItem().shouldHave(text("Item#"), Duration.ofSeconds(5));
               pdpScreen.getPdpPopUpOnSaleItem().should(visible, Duration.ofSeconds(5));
               break;
           case  "has price, member and sale price":
              pdpScreen.getPdpPopUpOnSalePrice().shouldHave(text("Price"), Duration.ofSeconds(5));
               if(pdpScreen.getPdpPopUpOnSaleMemberPrice().isDisplayed()){
                   pdpScreen.getPdpPopUpOnSaleMemberPrice().shouldHave(text("Member"), Duration.ofSeconds(5));
               } else {
                   pdpScreen.getPdpPopUpOnSaleTradePrice().shouldHave(text("Trade"), Duration.ofSeconds(5));
               }
               pdpScreen.getPdpPopUpOnSaleSalePrice().shouldHave(text("Sale"), Duration.ofSeconds(5));
               pdpScreen.getPdpPopUpOnSaleSalePriceAmount().should(visible, Duration.ofSeconds(5));
               break;
           case  "has qty dropdown":
               pdpScreen.getPdpPopUpOnSaleQTY().should(visible, Duration.ofSeconds(5));
               pdpScreen.getPdpPopUpOnSaleQTYValue().should(visible, Duration.ofSeconds(5));
               break;
           case  "has \"add to cart\" and \"add to project\" buttons":
               pdpScreen.getPdpPopUpOnSaleAddToCartButton().should(visible, Duration.ofSeconds(5));
               pdpScreen.getPdpPopUpOnSaleAddToProjectButton().should(visible, Duration.ofSeconds(5));
               break;
           case  "has an item can be added to cart from modal":
               pdpScreen.getPdpPopUpOnSaleAddToCartButton().click();
               with().pollInterval(5, SECONDS).await().until(() -> true);
               pdpScreen.getPdpPopUpOnSaleGoToCartButton().should(visible, Duration.ofSeconds(20));
               pdpScreen.getPdpPopUpOnSaleContinueShoppingButton().should(visible, Duration.ofSeconds(20));
               pdpScreen.getPdpPopUpOnSaleCloseButton().click();
               break;
           case  "has an item can be added to project from modal":
               pdpScreen.getPdpPopUpOnSaleAddToProjectButton().click();
               pdpScreen.getInStockPopUpProjectTitle().should(visible, Duration.ofSeconds(5));
               pdpScreen.getCancelButton().should(visible, Duration.ofSeconds(5));
               pdpScreen.getSaveButton().should(visible, Duration.ofSeconds(5));
               break;
           case  "Add to cart button should be enabled":
               pdpScreen.getPdpModalEnabledAddToCartButton().shouldBe(visible, Duration.ofSeconds(15));
               pdpScreen.getPdpModalDisabledAddToCartButton().shouldNotBe(visible, Duration.ofSeconds(15));
               break;
           case  "postal code should be displayed as per the Header preferences":
               pdpScreen.getPostalCode().shouldBe(visible, Duration.ofSeconds(15));
               break;
           case  "availability and delivery message should be displayed for each onsale product":
               with().pollInterval(5, SECONDS).await().until(() -> true);
               for(int i = 1; i <= pdpScreen.getInStockModalItemsList().size(); i++){
                   pdpScreen.getInStockModalDeliveryInformationList().shouldBe(visible, Duration.ofSeconds(15));
               }
               break;
           case  "has changed zip code":
               if(pdpScreen.getPostalCodeModal().isDisplayed()){
                   WebDriverRunner.getWebDriver().navigate().refresh();
                   pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().click();
                   assertEquals(result, pdpScreen.getPdpPopUpInStockZipCode().getText());
               } else {
                   assertEquals(result, pdpScreen.getPdpPopUpInStockZipCode().getText());
               }
               break;
           case  "ADD TO CART button should get enabled":
               pdpScreen.getPdpModalEnabledAddToCartButton().shouldBe(visible, Duration.ofSeconds(15));

           default:
               break;
       }
    }

    @And("I click on search")
    public void iClickOnSearch() {
        pdpScreen.getSearchIcon().should(visible, Duration.ofSeconds(5));
        pdpScreen.getSearchIcon().click();
    }

//    @And("Video should be played")
//    public void videoShouldBePlayed() {
//        $(By.xpath("(//*[@class= 'slick-slider slick-vertical slick-initialized']//*[contains(@class, 'arrow-icon')])[2]")).click();
//        with().pollInterval(3, SECONDS).await().until(() -> true);
//        $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/TBrace_Alt_Thumbnail')])[6]")).should(visible, Duration.ofSeconds(5));
//        $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/TBrace_Alt_Thumbnail')])[6]")).click();
//        $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/TBrace_Alt_Thumbnail')])[4]")).should(visible, Duration.ofSeconds(5));
//        $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/TBrace_Alt_Thumbnail')])[4]")).click();
//
//        $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/TBrace_Alt_Thumbnail')])[4]")).getAttribute("currentTime");
//        $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/TBrace_Alt_Thumbnail')])[4]")).getAttribute("ended");
//
////        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
////        js.executeScript("document.")
//    }

    @And("I type item name {string}")
    public void iTypeItemName(String arg0) {
       pdpScreen.getSearchFieldInput().setValue(arg0);
       pdpScreen.getSeeAllResultButton().click();
        result = arg0;
    }

    @Then("Product name should be displayed on left top")
    public void visabilityOfProductName() {
        pdpScreen.getPdpPopUpOnSaleProductName().shouldBe(visible, Duration.ofSeconds(15));

    }

    @And("I type {string}")
    public void iType(String arg0) {
        conciergeItemsScreen.getSearchField().setValue(arg0);
        result = arg0;
    }

    @Then("I verify SEE ALL RESULTS button is present")
    public void iSEEALLRESULTS() {
        conciergeItemsScreen.getSeeAllResult().shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("Verify that {string}")
    public void verifyData(String data) {
        switch (data){
            case  "shop the entire collection is present":
                pdpScreen.getShopTheEntireCollectionTitle().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "zoom button is clickable and zoom module is opened":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getZoomInButton().click();
                pdpScreen.getZoomOutButton().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getZoomModule().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "view carousel is present on the right of the zoomed hero image and scrolling are present":
                pdpScreen.getRightSideImageCarousel().shouldBe(visible, Duration.ofSeconds(15));
                boolean arrowsCount = pdpScreen.getRightSideImageCarouselArrows().size() == 2;
                assertTrue(arrowsCount);
                break;
            case  "plus and minus buttons are clickable and functioning":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getFirstProductImage().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getRightSideImageCarouselDownArrow().click();
                pdpScreen.getSecondProductImage().shouldNot(visible, Duration.ofSeconds(15));
                break;
            case  "close the Zoom in Module":
                pdpScreen.getRightSideImageCarouselModuleCloseButton().click();
                pdpScreen.getRightSideImageCarousel().shouldNotBe(visible, Duration.ofSeconds(15));
                break;
            case  "left and right arrows are present and number of alt images is 5":
                pdpScreen.getLeftArrow().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getRightArrow().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFirstAltImage().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getSecondAltImage().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getThirdAltImage().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFourthAltImage().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFifthAltImage().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "line item selections (Size, Finish and Qty) are present":
                pdpScreen.getItemsLineSize().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getItemsLineFinish().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getItemsLineQTY().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "smaller preview product picture is present on the left of line items":
                pdpScreen.getLittlePreviewOfAltItemImage().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "view in-stock Items and View Sale Items links are present":
                pdpScreen.getViewInStockItemText().shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
                break;
            case  "text \"Configure this item to view delivery information to\" is present":
                pdpScreen.getConfigureDeliveryInformation().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text Swatch is present":
                pdpScreen.getSwatchText().shouldHave(text("Swatch"), Duration.ofSeconds(5));
                break;
            case  "Swatch image is present":
               pdpScreen.getSwatchImage().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "line item for Swatch is present":
                boolean swatchItems = pdpScreen.getSwatchItemsLine().size() >= 2;
                assertTrue(swatchItems);
                break;
            case  "text \"Swatches are shipped at no charge\" is present":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getNoChargeShippedSwatchesText().scrollIntoView(true);
                pdpScreen.getNoChargeShippedSwatchesText().shouldHave(text("Swatches are shipped at no charge. For free USPS expedited delivery to arrive within 2-3 business days, all swatches must be placed in a separate order from product orders."), Duration.ofSeconds(5));
                break;
            case  "text Furniture Touch-up Kit is present":
                pdpScreen.getFurnitureTouchKitText().shouldHave(text("Furniture Touch-Up Kit"), Duration.ofSeconds(5));
                break;
            case  "button Check for Replacement parts is present":
                with().pollInterval(1, SECONDS).await().until(() -> true);
                pdpScreen.getCheckForReplacementPartsButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text \"This item will be ready for delivery between\" is present":
                if (!pdpScreen.getDeliveryBetweenText().isDisplayed()) {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(0);
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                    sizeList.selectByIndex(1);
                    with().pollInterval(1, SECONDS).await().until(() -> true);
                }
                pdpScreen.getDeliveryInStockItemText().shouldHave(text("This item is in stock and will be delivered"), Duration.ofSeconds(15));
                break;
            case  "text \"Unlimited Furniture Delivery\" is present":
               pdpScreen.getUnlimitedFurnitureDeliveryText().shouldHave(text("Unlimited Furniture Delivery"), Duration.ofSeconds(5));
                break;
            case  "text \"This item can be returned or exchanged within 30 days of delivery\" is present":
                with().pollInterval(5, SECONDS).await().until(() -> true);
               if(pdpScreen.getReturnPolicyText().isDisplayed()){
                   pdpScreen.getReturnPolicyText().shouldHave(text("This item can be returned or exchanged within 30 days of delivery. "), Duration.ofSeconds(5));
               } else {
                   pdpScreen.getDeliveryInStockItemText().shouldHave(text("This item is in stock and will be ready for delivery between"), Duration.ofSeconds(15));
               }
                break;
            case  "Add to Cart and Add to Project buttons are active":
               pdpScreen.getDisabledAddToCartButton().shouldNot(visible, Duration.ofSeconds(15));
               pdpScreen.getDisabledAddToProjectButton().shouldNot(visible, Duration.ofSeconds(15));
                break;
            case  "Add to Cart and Add to Project buttons are inactive":
                pdpScreen.getDisabledAddToCartButton().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDisabledAddToProjectButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "confirm that Add to Cart slider is present":
                pdpScreen.getAddToCartButton().click();
                pdpScreen.getItemAddedToYourCartText().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getViewCartTextButton().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getKeepShoppingButton().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getKeepShoppingButton().click();
                break;
            case  "confirm that Add to Cart slider for SO is present":
               pdpScreen.getSpecialOrderText().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "verify data in the modal for SO":
                with().pollInterval(9, SECONDS).await().until(() -> true);
                pdpScreen.getCloudModularLeatherSofaText().shouldHave(text("Cloud Modular Leather Sofa"), Duration.ofSeconds(20));
                pdpScreen.getItemNumber().shouldHave(text("Item #"), Duration.ofSeconds(20));
                pdpScreen.getItemByText(SKU).shouldHave(visible, Duration.ofSeconds(15));
                assertEquals(SKU,  pdpScreen.getItemByText(SKU).getText());
                if(pdpScreen.getMemberPrice().isDisplayed()){
                    pdpScreen.getMemberPrice().shouldHave(visible, Duration.ofSeconds(15));
                    memberPriceInPG = pdpScreen.getMemberPrice().getText().substring(1, 7);
                   pdpScreen.getPrice().shouldHave(visible, Duration.ofSeconds(15));
                    regularPriceInPG = pdpScreen.getRegularPrice().getText().substring(1, 8);
                } else {
                    pdpScreen.getPrice().shouldHave(visible, Duration.ofSeconds(15));
                    tradePriceInPDP =  pdpScreen.getTradePrice().getText();
                    pdpScreen.getModalPrice().shouldHave(visible, Duration.ofSeconds(15));
                    regularPriceInPG =  pdpScreen.getModalPrice().getText();
                }
                break;
            case  "text \"Components starting at\" is present":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getStartingAtText().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "click Agree and add to cart":
                pdpScreen.getClickAgreeAndAddToCartButton().click();
                break;
            case  "cart page has item (SKU)":
                pdpScreen.getNullItem().shouldNotHave(visible, Duration.ofSeconds(15));
                assertEquals("59810778 SECM", pdpScreen.getSKUValue().getText());
                break;
            case  "price is matching PDP":
                System.out.println("regularPriceInPG: "+regularPriceInPG);
                assertEquals( Integer.parseInt(regularPriceInPG.replaceAll(",", "").replaceAll(" ", "")) + 289,  Integer.parseInt(pdpScreen.getShippingOverridePrice().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "").replaceAll(" ", "")));
                break;
            case  "PDP has SALE and MEMBER prices":
                pdpScreen.getPriceForRegular().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getPriceForSale().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getPriceForMember().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getPriceLabelMember().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "PDP has Regular and Member prices":
                pdpScreen.getPriceForRegular().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getPriceForMember().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "default US zip code is present in PDP":
                pdpScreen.getComponentSKU().shouldBe(visible, Duration.ofSeconds(20));
                if(pdpScreen.getComponentSKU().isDisplayed()){
                    memberPriceInPG = pdpScreen.getPriceForMember().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "");
                } else {
                    tradePriceInPG = pdpScreen.getPriceForTrade().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "");
                }
                regularPriceInPG = pdpScreen.getPriceForRegular().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "");
                break;
            case  "price in PDP changed from US$ to CA$":
                with().pollInterval(9, SECONDS).await().until(() -> true);
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                pdpScreen.getComponentSKU().shouldBe(visible, Duration.ofSeconds(20));
                if(pdpScreen.getPriceForMember().isDisplayed()){
                    assertTrue(Integer.parseInt(memberPriceInPG) < Integer.parseInt(pdpScreen.getPriceForMember().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "")));
                } else {
                    pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                    pdpScreen.getPriceForTrade().shouldBe(visible, Duration.ofSeconds(20));
                    assertTrue(Integer.parseInt(tradePriceInPG) < Integer.parseInt( pdpScreen.getPriceForTrade().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "")));
                }
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                pdpScreen.getPriceForRegular().shouldBe(visible, Duration.ofSeconds(20));
                assertTrue(Integer.parseInt(regularPriceInPG) < Integer.parseInt(pdpScreen.getPriceForRegular().getText().replaceAll(".00", "").replaceAll("\\$", "").replaceAll(",", "")));
                break;
            case  "Confirm that PDP has price in GBP":
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                pdpScreen.getComponentSKU().shouldBe(visible, Duration.ofSeconds(20));
                if(pdpScreen.getPriceForMember().isDisplayed()){
                   assertEquals("£" ,pdpScreen.getPriceForMember().getText().substring(0,1));
                } else {
                    pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                    pdpScreen.getPriceForTrade().shouldBe(visible, Duration.ofSeconds(20));
                    assertEquals("£" ,pdpScreen.getPriceForTrade().getText().substring(0,1));
                }
                pdpScreen.getConfirmationPostalCode().shouldNot(visible, Duration.ofSeconds(20));
                pdpScreen.getPriceForRegular().shouldBe(visible, Duration.ofSeconds(20));
                assertEquals("£" , pdpScreen.getPriceForRegular().getText().substring(0,1));
                break;
            case  "sku is present in Cart":
                assertEquals(SKU,  pdpScreen.getSKUValue().getText());
            case  "user is logged in":
                assertEquals(SKU,  pdpScreen.getSKUValue().getText());
                break;
            case  "cloud Modular Leather Sofa titles are present":
                pdpScreen.getCloudModularLeatherSofaFirstItem().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getCloudModularLeatherSofaSecondItem().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Verify the delivery information":
                pdpScreen.getDeliveryInformation().shouldBe(visible, Duration.ofSeconds(15));
                if(pdpScreen.getNullItem().isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                pdpScreen.getItemLocator().shouldNotBe(text("null"), Duration.ofSeconds(5));
                break;
            case  "we enter invalid zipcode then error message should be displayed":
                pdpScreen.getInvalidPostalCodeMessage().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "User should be navigated to respective PDP":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                assertEquals(result, pdpScreen.getPdpTitle().getText());
                break;
            case  "the page is loading":
                pdpScreen.getPublicSwatchHeroPageTitle().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getPublicSwatchHeroPageTitle().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "CARE INSTRUCTIONS link is present":
                pdpScreen.getCareInstructionLink().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "COMPLIMENTARY SWATCHES floater is present and moving as user scrolls down":
                pdpScreen.getComplimentarySwatchesFloater().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFooter().scrollIntoView(true);
                pdpScreen.getComplimentarySwatchesFloater().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "after selecting color ORDER SWATCHES button is activated":
               pdpScreen.getDisabledOrderSwatchesButton().shouldBe(visible, Duration.ofSeconds(15));
               pdpScreen.getOrderSwatchesColor().scrollIntoView(true);
               pdpScreen.getOrderSwatchesColor().click();
               pdpScreen.getEnabledOrderSwatchesButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "after clicking ORDER SWATCHES user sees DELIVERY pop up":
                pdpScreen.getEnabledOrderSwatchesButton().click();
                pdpScreen.getDeliveryPopUp().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "form has the fields: First Name, Last Name, Email, Phone, Address,Apt, suite etc, City, State, Zip, Country Dropdown, Place Order Button":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getDeliveryInformationPopUpFirstName().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpLastName().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpEmail().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpPhone().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpAptSuiteFloor().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpAddress().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpCity().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpStateDropDown().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpZip().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpCountryDropDown().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDeliveryInformationPopUpPlaceOrderButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "fill in all fields":
                pdpScreen.getDeliveryInformationPopUpFirstName().setValue("FirstName");
                pdpScreen.getDeliveryInformationPopUpLastName().setValue("LastName");
                pdpScreen.getDeliveryInformationPopUpEmail().setValue("test@test.com");
                pdpScreen.getDeliveryInformationPopUpPhone().setValue("+11111111111");
                pdpScreen.getDeliveryInformationPopUpAptSuiteFloor().setValue("5");
                pdpScreen.getDeliveryInformationPopUpAddress().setValue("Rio Robles");
                pdpScreen.getDeliveryInformationPopUpCity().setValue("San Jose");
                Select stateList = new Select(pdpScreen.getDeliveryInformationPopUpStateDropDown());
                stateList.selectByIndex(1);
                pdpScreen.getDeliveryInformationPopUpZip().setValue("11111");
                Select countryList = new Select(pdpScreen.getDeliveryInformationPopUpCountryDropDown());
                countryList.selectByIndex(0);
                pdpScreen.getDeliveryInformationPopUpPlaceOrderButton().click();
                break;
            case  "after placing order Thank You Message is displayed with text Your order has been placed..":
                pdpScreen.getThankYouMessageTitle().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getThankYouMessage().shouldHave(text("Your order has been placed, and you’ll receive a confirmation number shortly via email."), Duration.ofSeconds(20));
                break;
            case  "Keep Shopping button is present":
                pdpScreen.getSwatchesModalKeepShoppingButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "clicking Keep Shopping button closes the Thank you modal and user stays on the Swatches page":
                pdpScreen.getSwatchesModalKeepShoppingButton().click();
                pdpScreen.getPublicSwatchHeroPageTitle().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getPublicSwatchHeroPageTitle().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getCareInstructionLink().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "line Item section image is present":
                pdpScreen.getLineItemSectionImage().scrollIntoView(true);
                pdpScreen.getLineItemSectionImage().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Verify the Starting at price or configured price message":
                pdpScreen.getSalePrice().scrollIntoView(true);
                pdpScreen.getSalePrice().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Verify the Sale/Final Sale price":
                if(pdpScreen.getPdpOnSaleMemberPrice().isDisplayed()){
                    pdpScreen.getPdpOnSaleMemberPrice().shouldBe(visible, Duration.ofSeconds(15));
                } else {
                    pdpScreen.getPdpOnSaleTradePrice().shouldBe(visible, Duration.ofSeconds(15));
                }
                break;
            case  "ON SALE name in the left with close button right":
                pdpScreen.getPdpModelOnSaleName().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "scrollable functionality":
                pdpScreen.getInStockModalItemsList().last().scrollIntoView(true);
                pdpScreen.getInStockModalItemsList().last().should(visible, Duration.ofSeconds(5));
                break;
            case  "By default qty dropdown should be displayed one":
                assertEquals(pdpScreen.getQuantitySelect().getAttribute("value"), "1");
                break;
            case  "postal code model is present":
                pdpScreen.getPostalCode().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getConfirmationPostalCode().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getPdpZipCodeModalShippingCountry().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getPostalCodeModal().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "delivery information message should be displayed":
                pdpScreen.getAvailabilityDeliveryInformation().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "country should always default to the Ship to country selected in the user preferences":
                pdpScreen.getPdpZipCodeModalDefpultCountry().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed":
                pdpScreen.getSpecialOrderLink().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "SELECT FROM STOCKED AND SPECIAL ORDER model should be open":
                pdpScreen.getSpecialOrderPopUpModal().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "Hero image should get updated and Shown in text below hero image should be suppressed":
                assertEquals(result,  pdpScreen.getColorLineItem().getText());
                break;
            case  "Return policy link should navigate user to the Return policy page":
                switchTo().window(1);
                assertEquals(Hooks.getCurrentUrl(),"https://rh.com/us/en/customer-service/return-policy.jsp");
                break;
            case  "Shipping & Delivery Modal Should be opened with UFD tab which has US currency for shipping charges":
                pdpScreen.getUnlimitedFurnitureDeliveryModalText().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getUnlimitedFurnitureDeliveryModalUSCurrency().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "Shipping & Delivery Modal Should be opened with Standard Shipping tab which has US currency for shipping charges":
                pdpScreen.getUnlimitedFurnitureDeliveryModalText().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getUnlimitedFurnitureDeliveryModalStandartShippingTabText().shouldHave(visible, Duration.ofSeconds(15));
                pdpScreen.getUnlimitedFurnitureDeliveryModalStandartShippingTabText().click();
                pdpScreen.getUnlimitedFurnitureDeliveryModalUSStandartShippingCurrency().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "Shipping & Delivery Modal Should be opened with Shipments to UK tab which has UK(GBP) currency for shipping charges":
                pdpScreen.getUnlimitedFurnitureDeliveryModalStandartShippingTabText().click();
                pdpScreen.getUnlimitedFurnitureDeliveryModalGBStandartShippingCurrency().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "postal code should not be present in the delivery message":
                pdpScreen.getStandartDeliveryShippingText().shouldHave(visible, Duration.ofSeconds(15));
                break;
            case  "User should be able to see the products based on shipping country and postal code":
                if(!pdpScreen.getModalOnSaleItemsList().first().isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    iClickOnViewInStockItems();
                    pdpScreen.getPdpPopUpInStockZipCode().should(visible, Duration.ofSeconds(5));
                }
                assertEquals(result, pdpScreen.getPdpPopUpInStockZipCode().getText());
                with().pollInterval(9, SECONDS).await().until(() -> true);
                assertTrue(pdpScreen.getModalOnSaleItemsList().size() > 1);
                break;
            case  "By default zipcode should be displayed for each line item in the Availability section as per Ip address or if no ip address found then static zipcode should be present":
               assertEquals(pdpScreen.getLinesItemsList().size(), pdpScreen.getZipcodeList().size());
                break;
            default: break;
        }
    }

    @When("I choose a random sale item")
    public void iChooseARandomSaleItem() {
        Random rand = new Random();
        pdpScreen.getCollectionList().first().shouldHave(visible, Duration.ofSeconds(30));
        int randomCollection = rand.nextInt(pdpScreen.getCollectionList().size());
        if(randomCollection == 0){
            int randomCollectionAgain = rand.nextInt(pdpScreen.getCollectionList().size());
            pdpScreen.getCollectionByNumber(randomCollectionAgain).click();
        } else {
            pdpScreen.getCollectionByNumber(randomCollection).click();
        }
        pdpScreen.getProductIteList().first().shouldHave(visible, Duration.ofSeconds(30));
        int randomItem = rand.nextInt( pdpScreen.getProductIteList().size());
        if(randomItem == 0){
            int randomItemAgain = rand.nextInt( pdpScreen.getProductIteList().size());
            pdpScreen.getProductItemByNumber(randomItemAgain).click();
        } else {
            pdpScreen.getProductItemByNumber(randomItem).click();
        }
    }

    @Then("I verify text {string}")
    public void iVerifyString(String text) {
        pdpScreen.getItemByText(text).shouldBe(visible, Duration.ofSeconds(15));
        pdpScreen.getItemByText(text).shouldHave(text(text), Duration.ofSeconds(20));
    }

    @Then("postal code {string} should be present in the delivery message")
    public void postalCodeShouldBePresentInDeliveryMessage(String postalCode) {
        pdpScreen.getUnlimitedFurnitureDeliveryText().shouldHave(text(postalCode), Duration.ofSeconds(15));
    }

    @Then("I click on {string} switch button")
    public void iClickOnSwitchButton(String button) {
        switch (button) {
            case "Add an item to cart from pop-up modal":
                pdpScreen.getModalAddToCartButton().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getModalAddToCartButton().click();
                break;
            default: break;
        }
    }

    @Then("I verify that text item# and SKU is present")
    public void iVerifyTextItemAndSKUIsPresent() {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        if(!pdpScreen.getItemLocator().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            iChoseLineItemSelectionsOneByOne("1");
        }
        pdpScreen.getItemLocator().shouldBe(visible, Duration.ofSeconds(15));
        pdpScreen.getItemLocator().shouldNot(text("null"), Duration.ofSeconds(15));
        SKU = pdpScreen.getItemLocator().getText().substring(6,19);
    }

    @Then("I verify that text SKU is present")
    public void iVerifyTextSKUIsPresent() {
        with().pollInterval(9, SECONDS).await().until(() -> true);
        if(!pdpScreen.getItemLocator().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            iChoseLineItemSelectionsOneByOne("1");
        }
        pdpScreen.getItemLocator().shouldBe(visible, Duration.ofSeconds(15));
        pdpScreen.getItemLocator().shouldNot(text("null"), Duration.ofSeconds(15));
    }

    @Then("Verify that line item field {string} is present")
    public void iVerifyLineItemFieldIsPresent(String lineItem) {
        pdpScreen.getLineItemByLineItem(lineItem, lineItem).shouldHave(visible, Duration.ofSeconds(15));
    }

    @Then("I choose option {string}")
    public void iChooseOption(String option) {
        pdpScreen.getOption(option).click();
    }

    @Then("I click on button {string} in the cart")
    public void iClickOnTheButtonInTheCart(String button) {
        pdpScreen.getItemByText(button).click();
    }

    @Then("verify that another modal appears with all the data for {string}")
    public void iVerifyAnotherModalAppearsWithAllTheData(String data) {
        with().pollInterval(9, SECONDS).await().until(() -> true);
       pdpScreen.getSaveButton().shouldBe(enabled, Duration.ofSeconds(15));
        pdpScreen.getSaveButton().click();
        pdpScreen.getItemAddedToCompany().shouldHave(text("1 ITEM ADDED TO TESTCOMPANY"), Duration.ofSeconds(20));
        pdpScreen.getItemDescriptionImage().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getItemDescriptionTitle().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalItemNumber().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getItemByValue(data).shouldHave(visible, Duration.ofSeconds(15));
        assertEquals(SKU, pdpScreen.getItemByValue(data).shouldHave(visible, Duration.ofSeconds(15)).getText());
        pdpScreen.getModalQuantity().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalQuantityNumber().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalFinish().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalFinishValue().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalSize().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalSizeValue().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getContinueShoppingButton().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getGoToProjectButton().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getContinueShoppingButton().click();
        pdpScreen.getGoToProjectButton().shouldNotHave(visible, Duration.ofSeconds(15));
    }

    @Then("Project modal appears and has all the data for {string}")
    public void iVerifyProjectModalAppearsAndHasAllTheData(String SKU) {
        pdpScreen.getEnabledAddToProjectButton().click();
        conciergeProjectScreen.getAddToProjectProjectName().should(visible, Duration.ofMinutes(1));
        conciergeProjectScreen.getAddToProjectProjectName().click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        conciergeProjectScreen.getProjectNamePopUpDropDownListItem().scrollIntoView(true);
        conciergeProjectScreen.getProjectNamePopUpDropDownListItem().click();
        pdpScreen.getItemDescriptionImageLine().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getItemDescriptionImage().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalItemNumber().shouldHave(visible, Duration.ofSeconds(15));
        String s = SKU.replaceAll("[^0-9]", "");
        pdpScreen.getItemByValue(s).shouldHave(visible, Duration.ofSeconds(15));
        assertEquals(s,  pdpScreen.getItemByValue(s).getText().replaceAll("[^0-9]", ""));
        pdpScreen.getModalQuantity().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalQuantityNumber().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalFinish().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalSize().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getModalSizeValue().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getProjectName().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getProjectOpportunitySelectLabel().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getProjectOpportunitySelect().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getProjectSpaceSelectLabel().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getProjectSpaceSelect().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getAddNewProjectButton().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getAddNewSpaceButton().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getCancelButton().shouldHave(visible, Duration.ofSeconds(15));
        pdpScreen.getSaveButton().shouldHave(visible, Duration.ofSeconds(15));
    }

    @Then("I chose zero choose in line items")
    public void iChoseZeroChooseInLineItems(){
        with().pollInterval(5, SECONDS).await().until(() -> true);
        int lineItemsCount = pdpScreen.getLineItemsCount().size();
       for(int i = 1;  i <= lineItemsCount; i++){
           Select itemList = new Select(pdpScreen.getItemByNumber(i));
           try {
               itemList.selectByIndex(0);
               with().pollInterval(1, SECONDS).await().until(() -> true);
           } catch (java.lang.UnsupportedOperationException e){
               WebDriverRunner.getWebDriver().navigate().refresh();
               with().pollInterval(5, SECONDS).await().until(() -> true);
               itemList.selectByIndex(0);
               with().pollInterval(5, SECONDS).await().until(() -> true);
           }
       }
    }

    @Then("I chose the {string} line item selections one by one")
    public void iChoseLineItemSelectionsOneByOne(String chose) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeItemsScreen.getAddToCartButtonDisabled().isDisplayed()) {
            int lineItemsCount = pdpScreen.getLineItemsCount().size();
            for (int i = 1; i <= lineItemsCount; i++) {
                Select itemList = new Select(pdpScreen.getItemByNumber(i));
                if (i != lineItemsCount) {
                    try {
                        itemList.selectByIndex(Integer.parseInt(chose));
                        with().pollInterval(1, SECONDS).await().until(() -> true);
                    } catch (UnsupportedOperationException e) {
                        iChoseLineItemSelectionsOneByOne(chose);
                    }
                } else {
                    try {
                        itemList.selectByIndex(Integer.parseInt(chose) + 1);
                        with().pollInterval(1, SECONDS).await().until(() -> true);
                    } catch (UnsupportedOperationException e) {
                        iChoseLineItemSelectionsOneByOne(chose);
                    }
                }
            }
        }
    }

    @Then("I chose the {string} line item selections one by one for {string} items")
    public void iChoseLineItemSelectionsOneByOneWithItems(String chose, String quantityOfItems) {
            for (int i = 1; i <= Integer.parseInt(quantityOfItems); i++) {
                int lineItemsCount = pdpScreen.getLineItemsCount().size();
                for (int j = 1; j <= lineItemsCount; j++) {
                    Select itemList = new Select(pdpScreen.getItemByNumber(i));
                    if (j != lineItemsCount) {
                        try {
                            itemList.selectByIndex(Integer.parseInt(chose));
                            with().pollInterval(2, SECONDS).await().until(() -> true);
                        } catch (UnsupportedOperationException e) {
                            iChoseLineItemSelectionsOneByOne(chose);
                        }
                    } else {
                        try {
                            itemList.selectByIndex(Integer.parseInt(chose) + 1);
                            with().pollInterval(2, SECONDS).await().until(() -> true);
                        } catch (UnsupportedOperationException e) {
                            iChoseLineItemSelectionsOneByOne(chose);
                        }
                    }
                }
            }
        result = chose;
        }

    @When("I Verify that {string} is present")
    public void verifyThat(String data) {
        switch (data){
            case  "PDP title":
                with().pollInterval(5, SECONDS).await().until(() -> true);
              pdpScreen.getPdpTitle().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "view select items on sale link":
                pdpScreen.getViewSelectItemsOnSaleText().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "\"VIEW SALE ITEMS\" link below line item image":
                pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().scrollIntoView(true);
                pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().shouldHave(text("View\n" + "Sale\n" + "items"));
                break;
            case  "\"VIEW IN STOCK ITEMS\" link below line item image":
                pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().scrollIntoView(true);
                pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().shouldHave(text("View\n" + "In-Stock\n" + "items"));
                break;
            case  "wording also available in":
                pdpScreen.getAlsoAvailableText().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "wording shop the entire collection":
                pdpScreen.getShopTheEntireCollectionText().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "verify that dynamic and static colorization options are present":
                pdpScreen.getSelectFromText().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getSpecialOrderFabricsText().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getSpecialOrderFabricsSiblingText().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFinishOptionText().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFinishOptionSiblingText().first().shouldBe(visible, Duration.ofSeconds(15));
                boolean finishOption = pdpScreen.getFinishOptionSiblingText().size() > 1;
                assertTrue(finishOption);
                break;
            case  "the \"Hero\" Image":
               pdpScreen.getHeroImage().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "\"Zoom\" button":
                pdpScreen.getZoomButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "images carousel is present below Hero image":
                pdpScreen.getImageCarousel().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "sections \"dimensions\" and \"details\"":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                if(!pdpScreen.getDimensionSection().isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                //pdpScreen.getDimensionSection().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getDetailsSection().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "section \"lather care\" or \"fabric care\"":
                try {
                    pdpScreen.getLeatherCare().shouldBe(visible, Duration.ofSeconds(15));
                } catch (ElementNotFound e){
                    pdpScreen.getFabricCare().shouldBe(visible, Duration.ofSeconds(15));
                }
                break;
            case  "line items":
                boolean lineItems =pdpScreen.getLineItemsList().size() > 1;
                assertTrue(lineItems);
                break;
            case  "\"add to cart\" and \"add to project\" buttons":
                pdpScreen.getEnabledAddToCartButton().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getEnabledAddToProjectButton().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text \"Learn more about our Return Policy\"":
               pdpScreen.getLearnMoreAboutText().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getReturnPolicy().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getReturnPolicyLink().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "YAML carousel":
                pdpScreen.getYMAL().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getYMALList().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Items listed in YAML carousel have titles and regular and member price":
                boolean titlesYAMLSize = pdpScreen.getProductCardLinkList().size() > 1;
                boolean regularPriceYAMLSize = pdpScreen.getYAMLPriceForRegular().size() > 1;
                boolean memberPriceYAMLSize = pdpScreen.getYAMLPriceForMember().size() > 1;
                assertTrue(titlesYAMLSize);
                assertTrue(regularPriceYAMLSize);
                assertTrue(memberPriceYAMLSize);
                break;
            case  "\"footer\" in PDP":
                pdpScreen.getFooter().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "text item# and SKU '10024796 WGRY'":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getItemValue().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Section should be expanded":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getExpendedDetailSection().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "Upholstery Swatch section":
                pdpScreen.getUpholsterySwatch().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "item title":
                pdpScreen.getItemTitle().shouldBe(visible, Duration.ofSeconds(15));
                break;
            default:
                break;
        }
    }

    @When("I verify the rest of the checkings for {string}")
    public void iVerifyTheRestOfTheCheckingsFor(String SKU) {
         if(SKU.equals("57070740 CLNT")){
             pdpScreen.getViewSelectItemsOnSaleText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getAlsoAvailableText().shouldBe(visible, Duration.ofSeconds(15));
//             $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]")).shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getSelectFromText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getSpecialOrderFabricsText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getSpecialOrderFabricsSiblingText().shouldBe(visible, Duration.ofSeconds(15));
             try {
                pdpScreen.getLeatherCare().shouldBe(visible, Duration.ofSeconds(15));
             } catch (ElementNotFound e){
                 pdpScreen.getFabricCare().shouldBe(visible, Duration.ofSeconds(15));
             }
             boolean optionSelectItems = pdpScreen.getOptionSelectItem().size() == 5;
             assertTrue(optionSelectItems);
             pdpScreen.getYMAL().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getYMALList().shouldBe(visible, Duration.ofSeconds(15));
             boolean titlesYAMLSize = pdpScreen.getProductCardLinkList().size() > 1;
             boolean regularPriceYAMLSize = pdpScreen.getYAMLPriceForRegular().size() > 1;
             if(pdpScreen.getYAMLPriceForMember().first().isDisplayed()){
                 boolean memberPriceYAMLSize = pdpScreen.getYAMLPriceForMember().size() > 1;
                 assertTrue(memberPriceYAMLSize);
             } else {
                 boolean memberPriceYAMLSize = pdpScreen.getYAMLPriceForTrade().size() > 1;
                 assertTrue(memberPriceYAMLSize);
             }
             assertTrue(titlesYAMLSize);
             assertTrue(regularPriceYAMLSize);
         }
         if(SKU.equals("61970975 TEAK")){
             pdpScreen.getAlsoAvailableText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getShopTheEntireCollectionText().shouldBe(visible, Duration.ofSeconds(15));

             pdpScreen.getSelectFromText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getSpecialOrderFabricsText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getSpecialOrderFabricsSiblingText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getFinishOptionText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getFinishOptionSiblingText().first().shouldBe(visible, Duration.ofSeconds(15));
             boolean finishOption = pdpScreen.getFinishOptionSiblingText().size() > 1;
             assertTrue(finishOption);
             pdpScreen.getYMAL().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getYMALList().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getStartingAtText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getViewInStockItemText().shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
             boolean viewItems = pdpScreen.getViewInStockItemSize().size() > 1;
             assertTrue(viewItems);
             pdpScreen.getCare().shouldBe(visible, Duration.ofSeconds(15));
             boolean chaiseItems = pdpScreen.getFirstChaiseList().size() == 2;
             assertTrue(chaiseItems);
             boolean cushionsItems = pdpScreen.getSecondChaiseList().size() == 4;
             assertTrue(cushionsItems);
             boolean coversItems = pdpScreen.getCoversList().size() == 2;
             assertTrue(coversItems);
             boolean swatchItems = pdpScreen.getSwatchList().size() == 4;
             assertTrue(swatchItems);
             boolean titlesYAMLSize = pdpScreen.getProductCardLinkList().size() > 1;
             boolean regularPriceYAMLSize = pdpScreen.getYAMLPriceForRegular().size() > 1;
             if(pdpScreen.getYAMLPriceForMember().first().isDisplayed()){
                 boolean memberPriceYAMLSize = pdpScreen.getYAMLPriceForMember().size() > 1;
                 assertTrue(memberPriceYAMLSize);
             } else {
                 boolean memberPriceYAMLSize = pdpScreen.getYAMLPriceForTrade().size() > 1;
                 assertTrue(memberPriceYAMLSize);
             }
             assertTrue(titlesYAMLSize);
             assertTrue(regularPriceYAMLSize);
         }
         if(SKU.equals("62870050 LOAK")){
             pdpScreen.getViewInStockItemText().shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
             boolean viewItems = pdpScreen.getViewInStockItemSize().size() > 1;
             assertTrue(viewItems);
             pdpScreen.getShopTheEntireCollectionText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getFinishText().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getFinishOptionSiblingText().first().shouldBe(visible, Duration.ofSeconds(15));
             boolean finishOption = pdpScreen.getFinishOptionSiblingText().size() > 1;
             assertTrue(finishOption);
             if(pdpScreen.getPriceLabelMember().isDisplayed()){
                 boolean memberOption = pdpScreen.getMemberList().size() > 1;
                 assertTrue(memberOption);
             } else {
                 boolean memberOption = pdpScreen.getTradeList().size() > 1;
                 assertTrue(memberOption);
             }
             pdpScreen.getCare().shouldBe(visible, Duration.ofSeconds(15));
             boolean benchItems = pdpScreen.getBenchItmsList().size() <= 3;
             assertTrue(benchItems);
             boolean swatchItems = pdpScreen.getSwatchList().size() == 2;
             assertTrue(swatchItems);
             boolean kitItems = pdpScreen.getKitItems().size() == 2;
             assertTrue(kitItems);
         }
         if(SKU.equals("17050044 CAML")){
             pdpScreen.getYMAL().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getYMALList().shouldBe(visible, Duration.ofSeconds(15));
             if(pdpScreen.getYMALList().isDisplayed()){
                 boolean memberOption = pdpScreen.getMemberList().size() > 1;
                 assertTrue(memberOption);
             } else {
                 boolean memberOption = pdpScreen.getTradeList().size() > 1;
                 assertTrue(memberOption);
             }
             with().pollInterval(9, SECONDS).await().until(() -> true);
             pdpScreen.getThirdSaleElement().shouldBe(visible, Duration.ofSeconds(15));
             boolean saleOption = pdpScreen.getSaleList().size() >=4;
             assertTrue(saleOption);
             pdpScreen.getColorOptions().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getViewInStockItemText().shouldHave(text("View In-Stock items"), Duration.ofSeconds(5));
             boolean viewItems = pdpScreen.getViewItems().size() > 1;
             assertTrue(viewItems);
             pdpScreen.getColorOptionList().shouldBe(visible, Duration.ofSeconds(15));
             pdpScreen.getCheckForReplacementParts().shouldBe(visible, Duration.ofSeconds(15));
         }
    }

    @When("Verify that \"In Stock modal\" {string}")
    public void verifyInStockModalData(String data) {
        switch (data){
            case  "opens":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                pdpScreen.getInStockPopUpTitle().shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
                pdpScreen.getInStockPopUpOptionText().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getFirstItem().shouldBe(visible, Duration.ofSeconds(15));
                SKU =   pdpScreen.getFirstItem().getText();
                break;
            case  "has a title":
               pdpScreen.getPdpPopUpOnSaleTitle().should(visible, Duration.ofSeconds(5));
                break;
            case  "zip code is present":
                pdpScreen.getPdpPopUpInStockZipCode().should(visible, Duration.ofSeconds(5));
                break;
            case  "click on postal code and change country and postal code and confirm":
                pdpScreen.getPdpPopUpInStockZipCode().should(visible, Duration.ofSeconds(5));
                pdpScreen.getPdpPopUpInStockZipCode().click();
                pdpScreen.getPdpZipCodeModalShippingCountry().click();
                pdpScreen.getPdpZipCodeModalCanada().click();
                with().pollInterval(2, SECONDS).await().until(() -> true);
                pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getPostalCode().setValue("H1Y2B5");
                with().pollInterval(2, SECONDS).await().until(() -> true);
                pdpScreen.getConfirmationPostalCode().click();
                pdpScreen.getConfirmationChangePostalCode().click();
                with().pollInterval(9, SECONDS).await().until(() -> true);
                result = "H1Y 2B5";
                break;
            case  "has item#":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                if(!pdpScreen.getPdpPopUpOnSaleItem().isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                }
                break;
            case  "has price and member price":
                pdpScreen.getPdpPopUpOnSalePrice().shouldHave(text("Price"), Duration.ofSeconds(5));
                if(pdpScreen.getPdpPopUpOnSaleMemberPrice().isDisplayed()){
                   pdpScreen.getPdpPopUpOnSaleMemberPrice().shouldHave(text("Member"), Duration.ofSeconds(5));
                } else {
                    pdpScreen.getPdpPopUpOnSaleTradePrice().shouldHave(text("Trade"), Duration.ofSeconds(5));
                }
                pdpScreen.getPdpPopUpOnSaleSalePriceAmount().should(visible, Duration.ofSeconds(5));
                break;
            case  "has qty dropdown":
                pdpScreen.getPdpPopUpOnSaleQTY().should(visible, Duration.ofSeconds(5));
                pdpScreen.getInStockQTYSelect().should(visible, Duration.ofSeconds(5));
                break;
            case  "has \"add to cart\" and \"add to project\" buttons":
                pdpScreen.getAddToCartDialogOpener().should(visible, Duration.ofSeconds(5));
                pdpScreen.getAddToProjectDialogOpener().should(visible, Duration.ofSeconds(5));
                break;
            case  "has an item can be added to cart from modal":
                pdpScreen.getAddToCartDialogOpener().click();
                pdpScreen.getPdpPopUpOnSaleGoToCartButton().should(visible, Duration.ofSeconds(5));
                pdpScreen.getPdpPopUpOnSaleContinueShoppingButton().should(visible, Duration.ofSeconds(5));
                pdpScreen.getPdpPopUpOnSaleCloseButton().click();
                break;
            case  "has an item can be added to project from modal":
                pdpScreen.getAddToProjectDialogOpener().click();
                pdpScreen.getInStockPopUpProjectTitle().should(visible, Duration.ofSeconds(5));
                pdpScreen.getCancelButton().should(visible, Duration.ofSeconds(5));
                pdpScreen.getSaveButton().should(visible, Duration.ofSeconds(5));
                break;
            case  "Add to cart button should be enabled":
                pdpScreen.getPdpModalEnabledAddToCartButton().shouldBe(visible, Duration.ofSeconds(15));
                pdpScreen.getPdpModalDisabledAddToCartButton().shouldNotBe(visible, Duration.ofSeconds(15));
                break;
            case  "we can change the qty by selecting value from dropdown":
                result = pdpScreen.getInStockModalQuantityDropDownList().getAttribute("value");
                Select itemList = new Select(pdpScreen.getInStockModalQuantityDropDownList());
                itemList.selectByIndex(5);
                assertNotEquals(result, pdpScreen.getInStockModalQuantityDropDownList().getAttribute("value"));
                break;
            case  "availability and delivery message should be displayed for each instock product":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                for(int i = 1; i <= pdpScreen.getInStockModalItemsList().size(); i++){
                    pdpScreen.getInStockModalDeliveryInformationList().shouldBe(visible, Duration.ofSeconds(15));
                }
                break;
            default: break;
        }
    }

    @When("I go to custom rugs")
    public void iGoToCustomRugs() {
        pdpScreen.getDataNavigationAccountItemRHBC().should(visible, Duration.ofSeconds(40));
        pdpScreen.getDataNavigationAccountItemRHBC().click();
        pdpScreen.getRugsByFiber().should(visible, Duration.ofSeconds(40));
        pdpScreen.getRugsByFiber().click();
    }
    @Then("I verify that custom rugs are displayed")
    public void iVerifyThatCustomRugsAreDisplayed() {
        pdpScreen.getWoolRugs().should(visible, Duration.ofSeconds(25));
        pdpScreen.getPerformanceFiberRugs().should(visible, Duration.ofSeconds(25));
    }

    @Then("I chose {string} product on the page")
    public void iChoseProductOnThePage(String arg) {
        pdpScreen.getProductNumberByNumber(arg).click();
    }

    @When("I click on windows from top menu")
    public void iClickOnWindowsFromTopMenu() {
        pdpScreen.getDataNavigationAccountItemCAT().should(visible, Duration.ofSeconds(40));
        pdpScreen.getDataNavigationAccountItemCAT().click();
        pdpScreen.getCustomWindowTreatments().should(visible, Duration.ofSeconds(40));
        pdpScreen.getCustomWindowTreatments().click();
    }

    @Then("I verify that custom windows are displayed")
    public void iVerifyThatCustomWindowsAreDisplayed() {
        pdpScreen.getCustomDraperyCollection().should(visible, Duration.ofSeconds(40));
        pdpScreen.getCustomShades().should(visible, Duration.ofSeconds(40));
        pdpScreen.getCustomWindowHardware().should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that YAML carousel is displayed")
    public void iVerifyThatYAMLCarouselIsDisplayed() {
        pdpScreen.getYamlCarouselMenu().scrollTo();
        pdpScreen.getYamlCarouselMenu().should(visible, Duration.ofSeconds(40));
        pdpScreen.getYamlCarouselMenu().scrollIntoView(true);
        List<String> items1 = new ArrayList<>();
        List<String> items2 = new ArrayList<>();
        List<String> expectedItems = new ArrayList<>(Arrays.asList("CLOUD SOFA", "CLOUD TRACK ARM SOFA" , "CLOUD SLOPE ARM MODULAR CUSTOMIZABLE SECTIONAL"));
        for (int i = 0; i < 3; i++) {
            items1.add(pdpScreen.getTtemYAMLListByNumber(i+1).getText());
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
        assertEquals(items1, expectedItems);
        pdpScreen.getYamlCarouselMenuRightArrow().click();
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
            pdpScreen.getNanPrice().shouldNotBe(visible, Duration.ofSeconds(15));
            assertEquals(pdpScreen.getMatressFee().getText(), "$10.50");
        }
        if(state.equals("RI")){
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            pdpScreen.getNanPrice().shouldNotBe(visible, Duration.ofSeconds(15));
            assertEquals(pdpScreen.getMatressFee().getText(), "$16.00");
        }
        if(state.equals("CT")){
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            pdpScreen.getNanPrice().shouldNotBe(visible, Duration.ofSeconds(15));
            assertEquals(pdpScreen.getMatressFee().getText(), "$11.75");
        }

    }

    @Then("Mattress Recycling Fees message should be displayed below line item for state {string}")
    public void mattressRecyclingFeesMessageShouldBeDisplayedBelowLineItem(String state) {
        if(state.equals("CA")) {
            assertEquals(pdpScreen.getPdpMattressFeeText().getText(), "California requires a mattress recycling fee to be collected at checkout.");
            pdpScreen.getPdpMattressFeeLink().shouldBe(visible, Duration.ofSeconds(15));
        }
        if(state.equals("RI")){
            assertEquals(pdpScreen.getPdpMattressFeeText().getText(), "Rhode Island requires a mattress recycling fee to be collected at checkout.");
            pdpScreen.getPdpMattressFeeLink().shouldBe(visible, Duration.ofSeconds(15));
        }
        if(state.equals("CT")){
            assertEquals(pdpScreen.getPdpMattressFeeText().getText(), "Connecticut requires a mattress recycling fee to be collected at checkout.");
            pdpScreen.getPdpMattressFeeLink().shouldBe(visible, Duration.ofSeconds(15));
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
        pdpScreen.getReplacementParts().should(visible, Duration.ofSeconds(40));
    }

    @Then("I click on postal code and change country to {string} and postal code to {string} and confirm")
    public void iClickOnPostalCodeChangeCountryAndPostalCodeAndConfirm(String country, String postalCode) {
        pdpScreen.getZipCode().should(visible, Duration.ofSeconds(5));
        pdpScreen.getZipCode().click();
        pdpScreen.getPdpZipCodeModalShippingCountry().click();
        pdpScreen.getCountryByName(country).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
        pdpScreen.getPostalCode().setValue(postalCode);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getConfirmationPostalCode().click();
        pdpScreen.getConfirmationChangePostalCode().click();
        with().pollInterval(9, SECONDS).await().until(() -> true);
    }

    @Then("I click on postal code and change country to {string} and postal code to {string} and verify confirmation message")
    public void iClickOnPostalCodeChangeCountryAndPostalCodeAndVerifyConfirmationMessage(String country, String postalCode) {
        pdpScreen.getPdpPopUpInStockZipCode().should(visible, Duration.ofSeconds(5));
        pdpScreen.getPdpPopUpInStockZipCode().click();
        pdpScreen.getPdpZipCodeModalShippingCountry().click();
        pdpScreen.getPdpZipCodeModalCanada().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(15));
        pdpScreen.getPostalCode().setValue(postalCode);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getConfirmationPostalCode().click();
        pdpScreen.getConfirmationMessagePostalCode().should(visible, Duration.ofSeconds(15));
    }

    @Then("I am checking the re-enter zip code functional")
    public void ImCheckingReEnterCodeFunctional() {
        pdpScreen.getZipCode().should(visible, Duration.ofSeconds(5));
        pdpScreen.getZipCode().click();
        pdpScreen.getPdpZipCodeModalShippingCountry().click();
        pdpScreen.getPdpZipCodeModalCanada().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(15));
        pdpScreen.getPostalCode().setValue("H1Y2B5");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getConfirmationPostalCode().click();
        pdpScreen.getReEnterZipCodeButton().should(visible, Duration.ofSeconds(15));
        pdpScreen.getReEnterZipCodeButton().click();
        pdpScreen.getPostalCodeModal().should(visible, Duration.ofSeconds(15));
    }



    @Then("I verify that cart modal is displayed")
    public void iVerifyThatCartModalIsDisplayed() {
        pdpScreen.getItemAddedToCart().should(visible, Duration.ofSeconds(15));
        pdpScreen.getViewCart().should(visible, Duration.ofSeconds(15));
        pdpScreen.getKeepShoppingText().should(visible, Duration.ofSeconds(15));
        pdpScreen.getDialogTitleCloseButton().click();
    }

    @Then("I verify that cart modal is displayed for more than one item")
    public void iVerifyThatCartModalIsDisplayedForMoreThanOneItem() {
        pdpScreen.getSpecialOrderText().should(visible, Duration.ofSeconds(15));
        pdpScreen.getAgreeAndAddToCart().should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify that project modal is displayed")
    public void iVerifyThatProjectModalIsDisplayed() {
        pdpScreen.getAddToProjectButton().should(visible, Duration.ofSeconds(15));
        pdpScreen.getCancelButton().should(visible, Duration.ofSeconds(15));
        pdpScreen.getSaveButton().should(visible, Duration.ofSeconds(15));
        pdpScreen.getFormDialogCloseButtons().click();
    }

    @Then("I verify that check for replacements parts button is displayed")
    public void iVerifyThatCheckForReplacementsPartsButtonIsDisplayed() {
        pdpScreen.getCheckForReplacementParts().scrollTo();
        pdpScreen.getCheckForReplacementParts().should(visible, Duration.ofSeconds(40));
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

    @When("I choose color {string} from special order fabrics")
    public void iChooseSpecificColorFromSpecialOrderFabrics(String color) {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        pdpScreen.getColorByName(color).should(visible, Duration.ofSeconds(40));
        pdpScreen.getColorByName(color).hover();
        pdpScreen.getColorByName(color).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getCloseSpecialOrderPopUpButton().hover();
        pdpScreen.getCloseSpecialOrderPopUpButton().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        result = color;
    }

    @Then("I verify that color has been chosen")
    public void iVerifyThatColorHasBeenChosen() {
        selectOption.getColorOption().shouldHave(text("Azure"), Duration.ofSeconds(20));
    }

    @Then("I click {string} on pdp page")
    public void iClickOnPDPPage(String data) {
        switch (data) {
            case "DETAILS section":
                pdpScreen.getDetailSection().click();
                break;
            case "link (If available) in DETAILS section":
                try {
                   pdpScreen.getDetailsSectionLink().click();
                } catch (ElementNotFound e) {
                    System.out.println("link is unavailable");
                }
                break;
            case "any product image in carousel":
                result = pdpScreen.getFirstProductItemInTheYAMLCarousel().getText();
                pdpScreen.getFirstProductItemInTheYAMLCarousel().click();
                break;
            case  "\"VIEW SALE ITEMS\" link below line item image":
                pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().scrollIntoView(true);
                pdpScreen.getViewSelectItemsOnSaleTextBelowLineItem().click();
                break;
            case "postal code link":
                pdpScreen.getZipCode().should(visible, Duration.ofSeconds(15));
                pdpScreen.getZipCode().click();
                pdpScreen.getPostalCodeModal().should(visible, Duration.ofSeconds(15));
                break;
            case  "text \"Unlimited Furniture Delivery\" is present":
                pdpScreen.getUnlimitedFurnitureDeliveryText().click();
                break;
            case  "Shipping & Delivery Modal Should be opened with Shipments to Canada tab which has CAN currency for shipping charges":
                pdpScreen.getShippingAndDeliveryModalTab().should(visible, Duration.ofSeconds(15));
                pdpScreen.getShippingAndDeliveryModalTab().click();
                pdpScreen.getShippingAndDeliveryModalDeliveryAreaText().should(visible, Duration.ofSeconds(15));
                break;
            case  "SELECT FROM STOCKED AND SPECIAL ORDER":
                pdpScreen.getSpecialOrderLink().click();
                break;
            case  "return policy link":
                pdpScreen.getReturnPolicy().click();
                break;
            default: break;
        }
    }

            @Then("I confirm that default zip code for country {string} is present in Cart")
            public void confirmThatDefault(String country) {
                if(Objects.equals(country, "US")){
                    zipCodeInTheCart = conciergeCartPageScreen.getPdpScreenZipCode().getText();
                    assertEquals(zipCodeInTheCart, "94925");
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
                with().pollInterval(9, SECONDS).await().until(() -> true);
                if(!pdpScreen.getZipCode().isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
                pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getZipCode().click();
                pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getPostalCode().setValue(zipCode);
                pdpScreen.getConfirmationPostalCode().click();
                with().pollInterval(9, SECONDS).await().until(() -> true);
            }

    @Then("I click on zip code and change it to {string} in modal opener")
    public void iChangeZipCodeForInModalOpener(String zipCode) {
        pdpScreen.getPdpPopUpInStockZipCode().should(visible, Duration.ofSeconds(40));
        pdpScreen.getPdpPopUpInStockZipCode().click();
        pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
        pdpScreen.getPostalCode().setValue(zipCode);
        pdpScreen.getConfirmationPostalCode().click();
        result = zipCode;
        with().pollInterval(9, SECONDS).await().until(() -> true);
    }

            @Then("I verify that zip code in PDP is {string}")
            public void iVerifyThatZipCodeIs(String zipCode) {
                with().pollInterval(9, SECONDS).await().until(() -> true);
                pdpScreen.getComponentSKU().shouldBe(visible, Duration.ofSeconds(20));

                if(!pdpScreen.getZipCodeByArg(zipCode).isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    for(int i = 0; i <=3; i++) {
                        iChangeZipCodeFor(zipCode);
                        with().pollInterval(9, SECONDS).await().until(() -> true);
                        if(pdpScreen.getZipCodeByArg(zipCode).isDisplayed()){
                            break;
                        }
                    }
                }
                String currentZipCode =  pdpScreen.getComponentSKU().getText();
                with().pollInterval(9, SECONDS).await().until(() -> true);
                assertEquals(currentZipCode, zipCode + ".");
                with().pollInterval(9, SECONDS).await().until(() -> true);
            }

            @Then("I verify that availability, Delivery and returns messaging is displayed for {string}")
            public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingIsDisplayedFor(String arg0) {

                if (arg0.equals("SO")) {
                    if (!pdpScreen.getSpecialOrderText().isDisplayed()) {
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }
                    pdpScreen.getSpecialOrderText().scrollTo();
                    pdpScreen.getSpecialOrderText().should(visible, Duration.ofSeconds(30));

                }
                if (arg0.equals("BO")) {
                    if (!pdpScreen.getReturnDeliveryText().isDisplayed()) {
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }
                }
            }

            @Then("I remember the name of the first product and regular, member prices in PG and navigate to that PDP")
            public void iRememberTheNameOfTheFirstProductAndRegularMemberPriceInPG() {
                firstProductNameInPG = conciergeCartPageScreen.getFirstProductNameInPG().getText();
                regularPriceInPG = conciergeCartPageScreen.getRegularPriceInPG().getText();
                memberPriceInPG = conciergeCartPageScreen.getMemberPriceInPG().getText().replaceAll("[^0-9_$]", "");
                conciergeCartPageScreen.getFirstProductNameInPG().click();
            }

            @Then("I Verify that the PDP title is present and prices match those prices in PG")
            public void iVerifyThatThePDPTitleIsPresentAndPricesMatchThosePricesInPG() {
                if(!pdpScreen.getPdpTitle().isDisplayed()){
                    String URL = Hooks.getCurrentUrl().replace("//", "/");
                    open(URL);
                }
                assertEquals(firstProductNameInPG, pdpScreen.getPdpTitle().getText());
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
                pdpScreen.getPremiumFabrics().should(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text()='Premium Leathers']")).should(visible, Duration.ofSeconds(15));
            }

            @Then("I verify presence of MultiSKU")
            public void iVerifyMultiSKU(){
                with().pollInterval(6, SECONDS).await().until(() -> true);
                pdpScreen.getItemsValues().should(visible, Duration.ofSeconds(15));
            }

            @Then("I verify product name in cart page")
            public void iVerifyProductNameinCartPage(){
                with().pollInterval(6, SECONDS).await().until(() -> true);
                pdpScreen.getKensingtonItemText().should(visible, Duration.ofSeconds(15));
            }

            @Then("I verify {string} is present")
            public void iVerify(String text){
                with().pollInterval(6, SECONDS).await().until(() -> true);
                pdpScreen.getItemByText(text).should(visible, Duration.ofSeconds(15));
            }

            @Then("I verify product count in cart page")
            public void iVerifyProductCountinCartPage(){
                with().pollInterval(6, SECONDS).await().until(() -> true);
                pdpScreen.getCountInTheCart().should(visible, Duration.ofSeconds(15));
            }

            @Then("I verify product count in project page")
            public void iVerifyProductCountinProjectPage(){
                with().pollInterval(6, SECONDS).await().until(() -> true);
                pdpScreen.getCountInTheCart().should(visible, Duration.ofSeconds(15));
            }
        }