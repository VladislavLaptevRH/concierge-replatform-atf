package tests.estore.pageObject;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstorePdpPageScreen {

    private final SelenideElement postalCodePdp = $(By.xpath("(//*[@data-testid='postal-code-dialog-opener'])[1]"));

    private final SelenideElement countryZipCodeSelection = $(By.xpath("//*[@id='country-zipcode-selection']"));

    private final SelenideElement regularPrice = $(By.xpath("//p[@data-testid='price-for-regular']"));

    private final SelenideElement regularTheFirstPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[1]"));

    private final SelenideElement regularPdpProductPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[2]"));

    private final SelenideElement regularTheSecondPrice = $(By.xpath("(//p[@data-testid='price-for-regular'])[3]"));

    private final SelenideElement confirmChangeButton = $(By.xpath("//*[text()='CONFIRM CHANGE']"));

    private final SelenideElement memberPrice = $(By.xpath("//p[@data-testid='price-for-member']"));

    private final SelenideElement memberTheFirstPrice = $(By.xpath("(//p[@data-testid='price-for-member'])[1]"));

    private final SelenideElement memberPdpProductPrice = $(By.xpath("(//p[@data-testid='price-for-member'])[3]"));

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

    private SelenideElement textBeforePriceAtLineItem = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[text()='Starting at']"));

    private SelenideElement lineItemId =  $(By.xpath("(//p[@data-testid='item-sku-id-desktop'])[1]"));

    private  SelenideElement addToCartBtn = $(By.xpath("(//span[text()='ADD TO CART'])[1]"));

    private  SelenideElement itemAddedInCarMsg = $(By.xpath("//p[contains(text(),'1 Item Added To Your Cart')]"));

    private SelenideElement viewCartBtn = $(By.xpath("//span[text()='View Cart']"));

    private SelenideElement heroImageMemberPrice = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//p[@data-testid='price-for-member']"));

    private SelenideElement heroImageRegularPrice = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//p[@data-testid='price-for-regular']"));

    private SelenideElement lineItemMemberPrice = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[@data-testid='price-for-member'])[1]"));

    private SelenideElement lineItemRegularPrice = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[@data-testid='price-for-regular'])[1]"));

    private SelenideElement heroImageForwardBtn = $(By.xpath("(//*[contains(@class,'arrow-icon')])[2]"));

    private SelenideElement heroImageBackBtn = $(By.xpath("(//*[contains(@class,'arrow-icon')])[1]"));

    private SelenideElement heroImagePlusIconZoomInBtn =  $(By.xpath("//*[text()='Grommet/ZoomIn']/.."));

    private SelenideElement heroImagePlusIconZoomOutBtn =  $(By.xpath("//*[text()='Grommet/ZoomOut']/.."));

    private  SelenideElement heroImageZoomInBtn =  $(By.xpath("(//*[text()='Grommet/ZoomIn']/..)[2]"));

    private  SelenideElement heroImageZoomOutBtn =  $(By.xpath("//*[text()='Grommet/ZoomOut']/.."));

    private SelenideElement heroImageUpwardBtn = $(By.xpath("(//*[contains(@class,'arrow-icon')])[6]"));

    private SelenideElement heroImageDownwardBtn = $(By.xpath("(//*[contains(@class,'arrow-icon')])[7]"));

    private SelenideElement heroImageCloseIcon = $(By.xpath("//*[@id ='Combined-Shape' and @fill='currentColor']"));

    private SelenideElement countrySelectionBtn = $(By.xpath("//div[@id='country-selection']"));

    private  SelenideElement countyCode = $(By.xpath("//li[@data-value='GB']"));

    private  SelenideElement postalCodeInput = $(By.xpath("//input[@id='postal-code-international']"));

    private SelenideElement postalCodeSubmitBtn = $(By.xpath("//button[@data-testid='submit-postal']"));

    private SelenideElement viewStockMsg = $(By.xpath("//*[text()='These options are available for']"));

    private SelenideElement availableItemMsg= $(By.xpath("(//p[contains(text(),'This item is in stock and will be delivered on or before')])[2]"));
}
