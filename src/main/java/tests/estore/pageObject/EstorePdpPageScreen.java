package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstorePdpPageScreen {

    private final SelenideElement postalCodePdp = $(By.xpath("(//*[@data-testid='postal-code-dialog-opener'])[1]"));

    private final SelenideElement countryZipCodeSelection = $(By.xpath("//*[@id='country-zipcode-selection']"));

    private final SelenideElement regularPrice = $(By.xpath("//p[@data-testid='price-for-regular']"));

    private final SelenideElement regularTheFirstPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[1]"));

    private final SelenideElement regularTheSecondPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[3]"));

    private final SelenideElement confirmChangeButton = $(By.xpath("//*[text()='CONFIRM CHANGE']"));

    private final SelenideElement memberPrice = $(By.xpath("//p[@data-testid='price-for-member']"));

    private final SelenideElement memberTheFirstPrice = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private final SelenideElement memberTheSecondPrice = $(By.xpath("(//p[@data-testid='price-for-member'])[3]"));

    private final SelenideElement memberPriceLabel = $(By.xpath("//p[@id='price-label-member']"));

    private final SelenideElement regularPriceLabel = $(By.xpath("//p[@id='price-label-regular']"));

    private final SelenideElement inStockOptionsButton = $(By.xpath("//*[text()='In-Stock Options']"));

    private final SelenideElement inStockTitle = $(By.xpath("//*[text()='IN STOCK']"));

    private SelenideElement turkishTowelCollectionTitle = $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[4]"));

    private SelenideElement itemInStockOption = $(By.xpath("//*[text()='Item#']"));

    private SelenideElement sizeInStockOption = $(By.xpath("//*[text()='Size']"));

    private SelenideElement colorInStockOption = $(By.xpath("//*[text()='Color']"));

    private SelenideElement detailsButton = $(By.xpath("//*[text()='DETAILS']"));

    private SelenideElement dimensionsButton = $(By.xpath("//*[text()='DIMENSIONS']"));

    private SelenideElement postalCodeButton = $(By.xpath("//*[@id='component-order-summary']//span"));

    private SelenideElement submitPostalCode = $(By.xpath("//button[@data-testid='submit-postal']"));

    private SelenideElement lineItemImage = $(By.xpath("//img[@alt='802-Gram Turkish Towel Collection']"));

    private SelenideElement sizeOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Size')])[1]"));

    private SelenideElement colorOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Color')])[1]"));

    private SelenideElement skuIdValue = $(By.xpath("(//p[@data-testid='item-sku-id-desktop'])[1]"));

    private SelenideElement postalCodeField = $(By.xpath("//*[@id='postal-code-international']"));

    private SelenideElement dollarSign = $(By.xpath("//*[contains(text(),'$')]"));
}
