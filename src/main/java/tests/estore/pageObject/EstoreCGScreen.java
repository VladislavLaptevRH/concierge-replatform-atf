package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

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

    private SelenideElement priceForRegular = $(By.xpath("//p[@data-testid='price-for-regular']"));

    private SelenideElement priceForMember = $(By.xpath("//p[@data-testid='price-for-member']"));

    private SelenideElement cortonaSofaCollectionUppercase = $(By.xpath("//*[text()='CORTONA SOFA COLLECTION']"));

    private SelenideElement collectionModalProductImage = $(By.xpath("//div[@data-cmp='cardImages']//div[@id='component-rh-image_wrapper']"));

    private SelenideElement seatingCollectionTitle = $(By.xpath("//span[text()='Seating Collections']"));

    private SelenideElement singleGridView = $(By.xpath("//div[contains(@class,'cg-slide-12 MuiGrid-item MuiGrid-grid-xs-12')]"));

    private SelenideElement memberDiscountText = $(By.xpath("//*[text()='MEMBERS SAVE 25% OFF REGULAR PRICE']"));

    private SelenideElement descriptionBella = $(By.xpath("//*[text()='Bella']"));

    private SelenideElement descriptionBellaModular = $(By.xpath("//*[text()='Bella Modular']"));

    private SelenideElement inStockMessageText = $(By.xpath("//*[text()='In-stock items delivered in 3-7 days']"));

    private SelenideElement twoGridViewCg = $(By.xpath("//div[contains(@class, 'grid-item-6')]"));

    private SelenideElement threeGridViewCg = $(By.xpath("//div[contains(@class, 'grid-item-4')]"));

    private SelenideElement swatches1upGridView = $(By.xpath("//*[@data-id='component-collection-card-details_swatches_col12']"));

    private SelenideElement swatches2upGridView = $(By.xpath("//*[@data-id='component-collection-card-details_swatches_col6']"));

    private SelenideElement swatches3upGridView = $(By.xpath("//*[@data-id='component-collection-card-details_swatches_col6']"));


    public void verifyThatSwatches1upGridViewIsDisplayed() {
        swatches1upGridView.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSwatches2upGridViewIsDisplayed() {
        swatches2upGridView.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSwatches3upGridViewIsDisplayed() {
        swatches3upGridView.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatThreeGridViewIsDisplayed() {
        threeGridViewCg.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatTwoGridViewIsDisplayed() {
        twoGridViewCg.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatinStockMessageTextIsDisplayed() {
        inStockMessageText.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatCGDescriptionIsDisplayed() {
        descriptionBella.should(Condition.visible, Duration.ofSeconds(12));
        descriptionBellaModular.should(Condition.visible, Duration.ofSeconds(12));

    }

    public void verifyThatSeatinCollectionTitleIsDisplayedOnCG() {
        seatingCollectionTitle.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatMemberDiscountMessageIsDisplayedOnCG() {
        memberDiscountText.should(Condition.visible, Duration.ofSeconds(12));
    }

    public void verifyThatSingleGridViewIsDisplayed() {
        singleGridView.should(Condition.visible, Duration.ofSeconds(12));
    }
}
