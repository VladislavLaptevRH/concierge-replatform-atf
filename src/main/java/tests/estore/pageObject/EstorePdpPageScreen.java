package tests.estore.pageObject;

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

    private final SelenideElement inStockTitle = $(By.xpath("//p[text()='In Stock']"));

    private SelenideElement turkishTowelCollectionTitle = $(By.xpath("(//*[text()='802-Gram Turkish Towel Collection'])[3]"));

    private SelenideElement itemInStockOption = $(By.xpath("//*[text()='Item']"));

    private SelenideElement sizeInStockOption = $(By.xpath("(//*[text()='Size'])[5]"));

    private SelenideElement colorInStockOption = $(By.xpath("(//*[text()='Color'])[7]"));

    private SelenideElement detailsButton = $(By.xpath("//*[text()='DETAILS']"));

    private SelenideElement dimensionsButton = $(By.xpath("//*[text()='DIMENSIONS']"));

    private SelenideElement postalCodeButton = $(By.xpath("//*[@id='component-order-summary']//span"));

    private SelenideElement submitPostalCode = $(By.xpath("//button[@data-testid='submit-postal']"));

    private SelenideElement lineItemImage = $(By.xpath("//img[@alt='802-Gram Turkish Towel Collection']"));

    private SelenideElement sizeOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Size')])[1]"));

    private SelenideElement colorOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Color')])[1]"));

    private SelenideElement depthOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Depth')])[1]"));

    private SelenideElement fillOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Fill')])[1]"));

    private SelenideElement qtyOption = $(By.xpath("(//select[ contains(@id,'qty')])[1]"));

    private SelenideElement leatherOption = $(By.xpath("(//select[contains(@id,'option') and contains(@id,'Leather')])[1]"));

    private SelenideElement skuIdValue = $(By.xpath("(//p[@data-testid='item-sku-id-desktop'])[1]"));

    private SelenideElement postalCodeField = $(By.xpath("//*[@id='postal-code-international']"));

    private SelenideElement dollarSign = $(By.xpath("//*[contains(text(),'$')]"));

    private SelenideElement textBeforePriceAtLineItem = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[text()='Starting at']"));

    private SelenideElement textComponentStartingAt = $(By.xpath("//p[contains(text(),'Components starting at')]"));

    private SelenideElement lineItemId = $(By.xpath("(//p[@data-testid='item-sku-id-desktop'])[1]"));

    private SelenideElement addToCartBtn = $(By.xpath("(//span[text()='Add To Cart'])[1]"));

    private SelenideElement itemAddedInCarMsg = $(By.xpath("//p[contains(text(),'1 Item Added To Your Cart')]"));

    private SelenideElement viewCartBtn = $(By.xpath("//span[text()='View Cart']"));

    private SelenideElement addAndAgreeBtn = $(By.xpath("//span[text()='Agree & Add To Cart']"));

    private SelenideElement heroImageMemberPrice = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//p[@data-testid='price-for-member']"));

    private SelenideElement heroImageRegularPrice = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//p[@data-testid='price-for-regular']"));

    private SelenideElement lineItemMemberPrice = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[@data-testid='price-for-member'])[1]"));

    private SelenideElement lineItemRegularPrice = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']//p[@data-testid='price-for-regular'])[1]"));

    private SelenideElement QtyInStockItems = $(By.xpath("(//div[@data-testid='in-stock-qty-select'])[1]"));

    private SelenideElement QtyInStockItems_2 = $(By.xpath("(//div[@data-testid='in-stock-qty-select'])[2]"));

    private SelenideElement addToCartBtnInStockItems = $(By.xpath("(//*[@id=\"inStockProductCardActions_addToCart-btn\"]/span[1])[1]"));

    private SelenideElement viewSaleItems = $(By.xpath("(//*[text()='Sale'])[1]"));

    private SelenideElement addToWishlist = $(By.xpath("(//*[@id=\"component-relatedProductActions_addToWishlist-btn\"])[1]"));

    private SelenideElement viewWishlistButton = $(By.xpath("(//*[@id=\"addToWishlistDialog_viewWishList-btn\"]/span[1])"));

    private SelenideElement keepShopping = $(By.xpath("(//*[@id=\"ajax-continue-shopping\"]/span[1])"));

    private final SelenideElement selectColorElement = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]"));

    private final SelenideElement selectSize = $(By.xpath("(//select[contains(@id, 'Size')])[1]"));

    private final SelenideElement viewCartValidation = $(By.xpath("//p[text()='802-Gram Turkish Towel Collection']"));

    private final SelenideElement selectDepth = $(By.xpath("(//select[contains(@id, 'Depth')])[1]"));

    private final SelenideElement selectFill = $(By.xpath("(//select[contains(@id, 'Fill')])[1]"));

    private final SelenideElement selectColor = $(By.xpath("(//select[contains(@id, 'Color')])[1]"));

    private final SelenideElement selectLength = $(By.xpath("(//select[contains(@id, 'Length')])[1]"));

    private final SelenideElement selectLeather = $(By.xpath("(//select[contains(@id, 'Leather')])[1]"));

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

    private final SelenideElement selectFabric = $(By.xpath("(//select[contains(@id, 'Fabric')])[1]"));

    private final SelenideElement selectCushionFill = $(By.xpath("(//select[contains(@id, 'Cushion Fill')])[1]"));

    private final SelenideElement viewSaleItem = $(By.xpath("(//*[@id=\"component-relatedProductCartd_view-sale-btn\"])[1]"));

    private final SelenideElement PDPTitle =  $(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2']"));

    private final SelenideElement PDPTitleLeatherSofa = $(By.xpath("//h1[contains(@class,'MuiTypography-h1')]"));

    private final SelenideElement heroImage = $(By.xpath("//*[@data-testid='desktop-pdp-image']"));

    private final SelenideElement returnPolicyLink =$(By.xpath("//span[text()='Return Policy']"));

    private final SelenideElement configureDeliveryInformationText = $(By.xpath("//p[contains(text(),'Configure this item to view delivery information')]"));

    private final SelenideElement pdpDetailsSection = $(By.xpath("//span[text()='DETAILS']"));

    private final SelenideElement pdpDimensionsSection = $(By.xpath("//span[text()='DIMENSIONS']"));

    private final SelenideElement pdpFabricCareSection = $(By.xpath("//span[text()='Fabric Care']"));

    private final SelenideElement pdpCareSection = $(By.xpath("//span[text()='Care']"));

    private final SelenideElement alsoAvailableInLeatherText = $(By.xpath("//a[text()='ALSO AVAILABLE IN LEATHER']"));

    private final SelenideElement alsoAvailableInAluminumText = $(By.xpath("//a[text()='ALSO AVAILABLE IN ALUMINUM']"));

    private final SelenideElement shopTheEntireCollectionText = $(By.xpath("//a[text()='SHOP THE ENTIRE COLLECTION']"));

    private final SelenideElement touchUpKitText = $(By.xpath("//*[contains(text(),'Touch-Up Kit')]"));

    private final SelenideElement pdpFooter = $(By.xpath("//div[@class='MuiContainer-root']/footer"));

    private final SelenideElement pdpColorOption = $(By.xpath("//p[text()='Color Options']"));

    private final SelenideElement swatchText = $(By.xpath("//*[contains(text(),'Swatch')]"));

    private final SelenideElement viewTouchUpKitText = $(By.xpath("//*[contains(text(),'Touch-Up Kit')]"));

    private final SelenideElement unlimitedFurnitureDeliveryText = $(By.xpath("//*[contains(text(),'Unlimited Furniture Delivery')]"));

    private final  SelenideElement inStockMemberPrice = $(By.xpath("//p[contains(@class,'product-price__amount--member') and contains(text(),'Member')]"));

    private final SelenideElement inStockRegularPrice = $(By.xpath("//p[contains(@class,'product-price__amount') and contains(text(),'Regular')]"));

    private final SelenideElement cloudModuleText = $(By.xpath("//p[contains(text(),'Cloud Modular Leather Sofa')]"));

    private final SelenideElement fabricColorBar = $(By.xpath("//div[contains(@data-testid,'SPECIAL ORDER FabricS')]"));

    private final SelenideElement colorFromColorOption = $(By.xpath("(//img[@alt='Bisque'])[1]"));

    private final SelenideElement addedItemInViewCart = $(By.id("listColumn1-ITEM"));

    private final SelenideElement fabricPanelTitle = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//h1"));

    private final SelenideElement addMonoGramCheckBox = $(By.xpath("(//span[@data-testid='monogram-checkbox'])[1]"));

    private final SelenideElement monoGramFont = $(By.xpath("(//p[text()='Select Font']/..//span)[1]"));

    private final SelenideElement monoGramColor = $(By.xpath("(//p[text()='Select Color']/..//span)[1]"));

    private final SelenideElement monoGramText = $(By.xpath("//input[@data-testid='monogram-input0']"));

    private final SelenideElement monogramAddButton = $(By.xpath("//button[@data-testid='monogram-add-button']"));

    private final SelenideElement personalizationText = $(By.xpath("//p[text()='PERSONALIZATION']"));

    private final SelenideElement editLinkText = $(By.xpath("//p[text()='Edit']"));

    private final SelenideElement removeLinkText = $(By.xpath("//p[text()='Remove']"));

    private final SelenideElement complimentarySwatchesText = $(By.xpath("//h5[text() = 'Complimentary Swatches']"));

    private final SelenideElement selectSwatchColor = $(By.xpath("(//div[@class='MuiGridListTile-tile'])[1]"));

    private final SelenideElement orderSwatchButton = $(By.xpath("//button[@data-testid='order-swatches-button']"));

    private final SelenideElement deliveryInformationText = $(By.xpath("//div[@class='swatch-shipping-container']"));

    private final SelenideElement swatchFirstName = $(By.xpath("//input[@name='firstName']"));

    private final SelenideElement swatchLastName = $(By.xpath("//input[@name='lastName']"));

    private final SelenideElement swatchEmail = $(By.xpath("//input[@name='email']"));

    private final SelenideElement swatchPhone = $(By.xpath("//input[@name='phone']"));

    private final SelenideElement swatchAddress = $(By.xpath("//input[@name='address']"));

    private final SelenideElement swatchCity = $(By.xpath("//input[@name='city']"));

    private final SelenideElement swatchZip = $(By.xpath("//input[@name='zip']"));

    private final SelenideElement swatchState = $(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[1]"));

    private final SelenideElement placeOrderBtn = $(By.xpath("//span[text()='PLACE ORDER']"));

    private final SelenideElement thankYouMessage = $(By.xpath("//h2[text()='THANK YOU']"));

    private final SelenideElement orderPlacedMessage = $(By.xpath("//p[contains(text(),'Your order has been placed')]"));
}