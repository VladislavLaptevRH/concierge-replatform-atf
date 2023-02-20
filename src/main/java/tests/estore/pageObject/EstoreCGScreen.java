package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

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

}
