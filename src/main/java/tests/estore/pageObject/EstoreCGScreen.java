package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

@Getter
public class EstoreCGScreen {
    private SelenideElement previewTheCollectionLastItem = $(By.xpath("(//div[@data-cmp='cardImages']//div[@id='component-rh-image_wrapper'])[13]"));

    private SelenideElement backToTopButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiFab-root']"));

    private SelenideElement sofaCollections = $(By.xpath("//*[text()='Sofa  collections']"));

    private SelenideElement lastItemFromScreenCollection = $(By.xpath("(//div[@id='component-rh-image_wrapper'])[20]"));

    private SelenideElement cGdefaultGridView = $(By.xpath("//div[@id='component-rh-image_wrapper']"));

    private SelenideElement componentCollectionCardDetails = $(By.id("component-collection-card-details"));

    private SelenideElement previewTheCollectionButton = $(By.xpath("(//*[@id = 'collection-gallery-grid'])[1]"));

    private SelenideElement cortonaSofaCollectionTitelPreviewPopUp = $(By.xpath("//*[text()='CORTONA SOFA COLLECTION']"));

    private SelenideElement closePreviewModalModelPopUp = $(By.xpath("//button[@data-testid='dialog-title-close-button']"));

    private SelenideElement cortonaOttomanText = $(By.xpath("//*[text()='Cortona Ottoman']"));

    private SelenideElement previewModelFirstItem = $(By.xpath("(//div[@data-cmp='cardImages'])[1]"));

    private SelenideElement cortonaSofa = $(By.xpath("//*[text()='Cortona Sofaa']"));

    private List<SelenideElement> priceForRegular = $$(By.xpath("//p[@data-testid='price-for-regular']"));

    private List<SelenideElement> priceForMember = $$(By.xpath("//p[@data-testid='price-for-member']"));

    private SelenideElement cortonaSofaCollectionUppercase = $(By.xpath("//*[text()='CORTONA SOFA COLLECTION']"));

    private SelenideElement collectionModalProductImage = $(By.xpath("//div[@data-cmp='cardImages']//div[@id='component-rh-image_wrapper']"));

    private SelenideElement seatingCollectionTitle = $(By.xpath("//span[text()='Seating Collections']"));

    private SelenideElement singleGridView = $(By.xpath("//div[contains(@class,'cg-slide-12 MuiGrid-item MuiGrid-grid-xs-12')]"));

    private SelenideElement memberDiscountText = $(By.xpath("//*[text()='MEMBERS SAVE 25% OFF REGULAR PRICE']"));

    private SelenideElement descriptionBella = $(By.xpath("//*[text()='Bella']"));

    private SelenideElement descriptionBellaModular = $(By.xpath("//*[text()='Bella Modular']"));

    private SelenideElement inStockMessageText = $(By.xpath("(//*[contains(text(),'In-stock items delivered')])[1]"));

    private SelenideElement twoGridViewCg = $(By.xpath("//div[contains(@class, 'grid-item-6')]"));

    private SelenideElement threeGridViewCg = $(By.xpath("//div[contains(@class, 'grid-item-4')]"));

    private SelenideElement swatches1upGridView = $(By.xpath("//*[@data-id='component-collection-card-details_swatches_col12']"));

    private SelenideElement swatches2upGridView = $(By.xpath("//*[@data-id='component-collection-card-details_swatches_col6']"));

    private SelenideElement swatches3upGridView = $(By.xpath("//*[@data-id='component-collection-card-details_swatches_col6']"));

    private SelenideElement swatchesCg = $(By.xpath("(//*[@alt='swatchImage'])[1]"));

    private SelenideElement chairCgName = $(By.xpath("(//*[contains(text(),'Chair')])[1]"));

    private SelenideElement viewSelectItemsOnSale = $(By.xpath("(//button[@class='MuiButtonBase-root'])[1]"));

    private SelenideElement saveUpSaleMessage = $(By.xpath("//*[text()='SAVE UP TO 50% OFF SELECT ITEMS']"));

    private SelenideElement withRhMembershipSaleMessage = $(By.xpath("//*[text()='WITH RH MEMBERSHIP']"));

    private SelenideElement cgChairs = $(By.xpath("(//*[contains(text(),'Chairs')])[2]"));

    private SelenideElement cg1Grid = $(By.xpath("//div[contains(@class,'grid-item-12')]"));

    private SelenideElement cgImages = $(By.xpath("(//img[contains(@alt,'Collection')])[1]"));

    private SelenideElement cgCollectionTitle = $(By.xpath("//h1//span[contains(text(),'collections')]"));

    private SelenideElement noSearchResultMessage = $(By.xpath("//*[text()='We’re sorry, we cannot find what you are looking for.']"));

    private SelenideElement titleTerzoDiningTables = $(By.xpath("//*[text()='TERZO ROUND DINING TABLE']"));


    public void verifyThatTitleisDisplayedOnCg(String title){
        $(By.xpath("//*[text()='" + title + "']")).should(visible, Duration.ofSeconds(12));
    }

    public void verifyThatTitleTerzoDiningTables() {
        titleTerzoDiningTables.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatNoSearchResultMessageIsDisplayed() {
        noSearchResultMessage.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatTitleIsDisplayedOnCg() {
        cgCollectionTitle.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatImagesAreDisplayedOnCg() {
        cgImages.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatCg1GridSelectedByDefault() {
        cg1Grid.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatCgTitleIsDisplayed(String title) {
        $(By.xpath("//*[contains(text(),'" + title + "')]")).should(Condition.visible, Duration.ofSeconds(14));
    }

    public void verifyThatSaveUpSaleMessageIsDisplayed() {
        saveUpSaleMessage.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatWithRhMembershipSaleMessageIsDisplayed() {
        withRhMembershipSaleMessage.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyColorForViewSelectItemsForSaleMessage() {
        String viewSelectItemsOnSaleColor = $(By.xpath("(//button[@class='MuiButtonBase-root'])[1]")).getAttribute("class");
        String[] colorText = viewSelectItemsOnSaleColor.split("#");
        assertTrue(colorText[1].equals("CA2022 !important"));
    }

    public String verifyTextDecoration() {
        String cssValueTextDecoration = viewSelectItemsOnSale.getCssValue("text-decoration");
        return cssValueTextDecoration;
    }

    public int getProductRegularPriceOnCg() {
        return Integer.parseInt(priceForRegular.get(0).getText().replaceAll("[^0-9]", ""));
    }

    public int getProductMemberPriceOnCg() {
        return Integer.parseInt(priceForMember.get(0).getText().replaceAll("[^0-9]", ""));
    }

    public void verifyThatSwathcesOnCgAreDisplayed() {
        swatchesCg.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyThatChairCGNameIsDisplayed() {
        chairCgName.should(Condition.visible, Duration.ofSeconds(12));
    }


    public void verifyThatSwatches1upGridViewIsDisplayed() {
        swatches1upGridView.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSwatches2upGridViewIsDisplayed() {
        swatches2upGridView.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSwatches3upGridViewIsDisplayed() {
        swatches3upGridView.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSwatches3upGridViewIsNotDisplayed() {
        swatches3upGridView.shouldNot(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatThreeGridViewIsDisplayed() {
        threeGridViewCg.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatTwoGridViewIsDisplayed() {
        twoGridViewCg.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatinStockMessageTextIsDisplayed() {
        inStockMessageText.scrollIntoView(true).isDisplayed();
        inStockMessageText.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatCGDescriptionIsDisplayed() {
        descriptionBella.should(Condition.visible, Duration.ofSeconds(12));
        descriptionBellaModular.should(Condition.visible, Duration.ofSeconds(12));

    }

    public void verifyThatSeatinCollectionTitleIsDisplayedOnCG() {
        seatingCollectionTitle.should(Condition.visible, Duration.ofSeconds(18));
    }

    public void verifyThatMemberDiscountMessageIsDisplayedOnCG() {
        memberDiscountText.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSingleGridViewIsDisplayed() {
        singleGridView.should(Condition.visible, Duration.ofSeconds(12));
    }
}
