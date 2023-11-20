package tests.concierge.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class PdpScreen {

    public final String itemYAMLList = "(//*[text() = 'YOU MIGHT ALSO LIKE']/..//span)[%s]";

    public final String productNumber = "(//*[@id = 'flip-carousel-div'])[%s]/../../..";

    public final String textLocator = "(//*[text() = '%s'])[1]";

    public final String collection = "(//a/img[@class = 'desktop-img'])[%s]";

    public final String productItem = "(//p/span)[%s]";

    public final String lineItem = "(//*[contains(@id, '%s-label') and text() = '%s']/..//select)[1]";

    public final String option = "//*[@alt = '%s']";

    public final String modalItemValue = "//*[@id = 'listColumn2-Item#' and contains(text(), '%s')]";

    public final String itemListNumber = "((//a[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//select[contains(@id, 'prod')]/option/..)[%s]";
    public final String zipCodeValue = "//*[contains(text(), '%s')]";

    public final String stockedColor = "//*[text() = '%s ']";

    private final String pdpZipCodeCountry = "//*[text() ='%s']";


    private final SelenideElement manageRegistryButton = $(By.xpath("//*[text()='MANAGE REGISTRY']"));

    private final SelenideElement detailsSectionLink = $(By.xpath("//*[contains(@href, '/catalog/product') and text() = 'FreshBed™ Sleep System']"));

    private final SelenideElement detailSection = $(By.xpath("(//*[text() = 'DETAILS'])[1]"));

    private final ElementsCollection lineItemsList = $$(By.xpath("//select[contains(@id, 'optionSelect')]"));

    private final SelenideElement inStockFacet = $(By.xpath("//*[@id = 'refinementOptionData_checkbox-In-Stock']//p[text() = 'in-stock']"));

    private final ElementsCollection memberList = $$(By.xpath(" //*[contains(text() ,'Member')]"));

    private final ElementsCollection tradeList = $$(By.xpath("//*[contains(text() ,'Trade')]"));

    private final ElementsCollection benchItmsList = $$(By.xpath("//*[contains(text() ,'Trade')]"));

    private final ElementsCollection lineItemsCount = $$(By.xpath(" (//a[contains(@data-testid, 'productTitleLink')])[1]/../../../../../..//select[contains(@id, 'prod')]/option/.."));
    private final SelenideElement quantitySelect = $(By.xpath("(//*[text() = 'QTY'])[1]/..//select"));

    private final SelenideElement memberPrice = $(By.xpath("(//*[contains(@class, 'item-price__amount--member')])[1]"));

    private final SelenideElement price = $(By.xpath("(//*[contains(@class, 'item-price__amount')])[1]"));

    private final SelenideElement thirdSaleElement = $(By.xpath("(//*[contains(text() ,'SALE')])[3]"));

    private final ElementsCollection saleList = $$(By.xpath("//*[contains(text() ,'SALE')]"));
    private final SelenideElement tradePrice = $(By.xpath("(//*[contains(@class, 'item-price__amount')])[1]"));
    private final SelenideElement colorOptions = $(By.xpath("//*[text() ='Color Options']"));

    private final SelenideElement reEnterZipCodeButton = $(By.xpath("//*[text() ='RE-ENTER POSTAL CODE']"));
    private final SelenideElement regularPrice = $(By.xpath("//*[contains(@class,'item-price__amount') and text() = 'Regular']"));
    private final SelenideElement modalPrice = $(By.xpath(" (//*[contains(@class, 'item-price__amount')])[2]"));

    private final SelenideElement expendedDetailSection = $(By.xpath("(//section/ul/li[text() = 'Crafted of solid wood and engineered wood with American white oak veneers'])[1]"));

    private final SelenideElement firstProductItemInTheYAMLCarousel = $(By.xpath("(//*[text() = 'YOU MIGHT ALSO LIKE']/..//span)[1]"));

    private final SelenideElement addToRegistryButton = $(By.xpath("(//button[@data-testid='add-to-registry-dialog-opener'])[1]"));

    private final SelenideElement nullItem = $(By.xpath("(//*[contains(text(), 'Item# null')])[1]"));

    private final SelenideElement SKUValue = $(By.xpath("(//*[@id = 'listColumn2-Item#'])[1]"));

    private final SelenideElement shippingOverridePrice = $(By.xpath("//*[@aria-describedby= 'shipping-override-price-dialog']"));

    private final SelenideElement publicSwatchHeroPageImage = $(By.xpath("//*[@alt = 'Fabric Swatch Hero']"));
    private final SelenideElement publicSwatchHeroPageTitle = $(By.xpath("//h1[text() = 'PREMIUM FABRICS']"));
    private final SelenideElement careInstructionLink = $(By.xpath("(//a[@href='http://images.restorationhardware.com/content/catalog/tearsheets/Fabric_Care_Instructions.pdf'])[1]"));
    private final SelenideElement complimentarySwatchesFloater = $(By.xpath("//*[@id = 'order-panel']"));
    private final SelenideElement clickAgreeAndAddToCartButton = $(By.xpath("//*[@id = 'spo-auth-addToCart']"));
    private final SelenideElement disabledOrderSwatchesButton = $(By.xpath("//*[@data-testid = 'order-swatches-button'][@disabled]"));
    private final SelenideElement enabledOrderSwatchesButton = $(By.xpath("//*[@data-testid = 'order-swatches-button']"));
    private final SelenideElement deliveryPopUp = $(By.xpath("//*[@class = 'swatch-shipping-container']/h2[text() = 'Delivery Information']"));
    private final SelenideElement orderSwatchesColor = $(By.xpath("(//input[contains(@name, 'checkboxsku')])[1]"));
    private final SelenideElement priceForRegular = $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]"));
    private final SelenideElement deliveryInformationPopUpFirstName = $(By.xpath("//label[text() = 'First name']/..//input[@name = 'firstName']"));
    private final SelenideElement deliveryInformationPopUpLastName = $(By.xpath("//label[text() = 'Last name']/..//input[@name = 'lastName']"));
    private final SelenideElement deliveryInformationPopUpEmail = $(By.xpath("//label[text() = 'Email']/..//input[@name = 'email']"));
    private final SelenideElement deliveryInformationPopUpPhone = $(By.xpath("//label[text() = 'Phone']/..//input[@name = 'phone']"));
    private final SelenideElement deliveryInformationPopUpAddress = $(By.xpath("//label[text() = 'Address']/..//input[@name = 'address']"));
    private final SelenideElement deliveryInformationPopUpAptSuiteFloor = $(By.xpath("//label[text() = 'Apt, Suite, Floor, etc']/..//input[@name = 'address2']"));
    private final SelenideElement deliveryInformationPopUpCity = $(By.xpath("//label[text() = 'City']/..//input[@name = 'city']"));
    private final SelenideElement deliveryInformationPopUpStateDropDown = $(By.xpath("//label[text() = 'State']/..//select[@name = 'state']"));
    private final SelenideElement deliveryInformationPopUpCountryDropDown = $(By.xpath("//label[text() = 'Country']/..//select[@name = 'country']"));
    private final SelenideElement deliveryInformationPopUpZip = $(By.xpath("//label[text() = 'Zip']/..//input[@name = 'zip']"));
    private final SelenideElement deliveryInformationPopUpPlaceOrderButton = $(By.xpath("//*[text() = 'PLACE ORDER']"));
    private final SelenideElement priceForTrade = $(By.xpath("(//*[@data-testid= 'price-for-trade'])[1]"));
    private final SelenideElement thankYouMessageTitle = $(By.xpath("//h2[text() = 'THANK YOU']"));
    private final SelenideElement thankYouMessage = $(By.xpath("//h2[text() = 'THANK YOU']/../p"));
    private final SelenideElement priceForSale = $(By.xpath("(//*[@data-testid = 'price-for-sale'])[1]"));

    private final SelenideElement swatchesModalKeepShoppingButton = $(By.xpath("//button[@data-testid = 'swatch-thank-you-keep-shopping']"));

    private final SelenideElement priceLabelSale = $(By.xpath("(//*[@data-testid = 'price-label-sale'])[1]"));

    private final SelenideElement priceForMember = $(By.xpath("(//*[@data-testid='price-for-member'])[1]"));

    private final SelenideElement priceLabelMember = $(By.xpath("(//*[@data-testid = 'price-label-member'])[1]"));

    private final SelenideElement componentSKU = $(By.xpath(" (//*[@id = 'component-sku']//span)[1]"));

    private final SelenideElement startingAtText = $(By.xpath("(//*[text() = 'Starting at'])[1]"));
    private final SelenideElement specialOrderText = $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]"));
    private final SelenideElement returnDeliveryText = $(By.xpath("(//*[contains(text(),'This item can be returned within 30 days of delivery.')])[1]"));
    private final SelenideElement returnOrExchangedDeliveryText = $(By.xpath("//*[contains(text(),'This item can be returned or exchanged within 30 days of delivery. ')]"));

    private final SelenideElement monogramsStyleValue = $(By.xpath("//*[text()='Bauer Bodoni 2 (BDNI-HD)']"));

    private final SelenideElement itemsPerPage = $(By.xpath("//*[@id = 'itemsPerPage']"));
    private final SelenideElement monogramsText = $(By.xpath("//*[text()='Text']"));
    private final SelenideElement viewOnStockItemLink = $(By.xpath("//*[text()='In-Stock']"));
    private final SelenideElement monogramsStyle = $(By.xpath("//*[text()='Style']"));
    private final SelenideElement inStockPopUpTitle = $(By.xpath("//*[text()='IN STOCK']"));
    private final SelenideElement viewSelectItemsOnSaleLink = $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']"));
    private final SelenideElement pdpPopUpOnSaleText = $(By.xpath("//*[text()='ON SALE']"));
    private final SelenideElement pdpPopUpOnSaleItem = $(By.xpath("(//*[@id='listColumn1-Item#'])[1]"));
    private final SelenideElement pdpPopUpOnSalePrice = $(By.xpath("(//*[@id = 'sku-price-list']//*[text()='Price'])[1]"));
    private final SelenideElement pdpPopUpOnSaleMemberPrice = $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--member') and contains(text() , 'Member')])[1]"));
    private final SelenideElement pdpOnSaleMemberPrice = $(By.xpath(" //*[text() = 'VIEW SELECT ITEMS ON SALE']/../../../following-sibling::div//*[@data-testid = 'price-for-member']"));
    private final SelenideElement pdpOnSaleTradePrice = $(By.xpath(" //*[text() = 'VIEW SELECT ITEMS ON SALE']/../../../following-sibling::div//*[@data-testid = 'price-for-trade']"));
    private final SelenideElement pdpPopUpOnSaleTradePrice = $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--trade') and text() = 'Trade'])[1]"));
    private final SelenideElement pdpPopUpOnSaleSalePrice = $(By.xpath("(//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount--sale') and text() = 'Sale'])[1]"));
    private final SelenideElement pdpPopUpOnSaleSalePriceAmount = $(By.xpath(" (//*[@id='sku-price-list']//p[contains(@class, 'product-price__amount')])[1]"));
    private final SelenideElement pdpPopUpOnSaleQTY = $(By.xpath("//*[text()='Qty']"));
    private final SelenideElement inStockQTYSelect = $(By.xpath("(//*[@data-testid='in-stock-qty-select'])[1]"));
    private final SelenideElement addToCartDialogOpener = $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[1]"));

    private final SelenideElement addToProjectDialogOpener = $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener'])[1]"));
    private final SelenideElement pdpPopUpOnSaleQTYValue = $(By.xpath("//*[@data-testid='in-stock-qty-select']"));
    private final SelenideElement pdpPopUpOnSaleAddToCartButton = $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener']"));
    private final SelenideElement pdpPopUpOnSaleAddToProjectButton = $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener']"));
    private final SelenideElement pdpPopUpOnSaleGoToCartButton = $(By.xpath("//*[@id = 'ajax-proceed-to-cart']/span[1]"));
    private final SelenideElement pdpPopUpOnSaleContinueShoppingButton = $(By.xpath("//*[@id = 'ajax-continue-shopping']/span[1]"));
    private final SelenideElement pdpPopUpOnSaleCloseButton = $(By.xpath("(//*[@data-testid = 'dialog-title-close-button'])[2]"));
    private final SelenideElement pdpPopUpOnSaleTitle = $(By.xpath("//div/p[text()='French Contemporary Fabric Panel Bed']"));
    private final SelenideElement pdpPopUpOnSaleProductName = $(By.xpath("(//div/p[contains(@class, 'MuiTypography-paragraph')])[1]"));
    private final SelenideElement pdpPopUpInStockZipCode = $(By.xpath("//*[text() = 'These options are available for']/*[@data-testid = 'in-stock-link']"));
    private final SelenideElement inStockPopUpOptionText = $(By.xpath("//*[text()='These options are available for']"));
    private final ElementsCollection modalOnSaleItemsList = $$(By.xpath("//*[@data-testid = 'dialog-title-close-button']/../..//*[@id = 'component-rh-image']"));
    private final ElementsCollection modalInStockItemsList = $$(By.xpath("//*[@data-testid = 'dialog-title-close-button']/../..//*[@id = 'component-rh-image']"));
    private final SelenideElement firstItem = $(By.xpath("(//*[@id= 'listColumn2-Item#'])[1]"));
    private final SelenideElement inStockPopUpProjectTitle = $(By.xpath("//h3[text() = 'ADD TO PROJECT']"));
    private final SelenideElement dataNavigationAccountItemRHBC = $(By.xpath("//div[@data-navigation-account-item-id='rhbc_cat479005']"));
    private final SelenideElement dataNavigationAccountItemCAT = $(By.xpath("//div[@data-navigation-account-item-id='cat160095']"));
    private final SelenideElement customDraperyCollection = $(By.xpath("//*[text()='Custom Drapery Collections']"));
    private final SelenideElement customShades = $(By.xpath("//*[text()='Custom Shades']"));
    private final SelenideElement customWindowHardware = $(By.xpath("//*[text()='Custom Window Hardware']"));
    private final SelenideElement nanPrice = $(By.xpath("//*[text() = '$NaN']"));
    private final SelenideElement matressFee = $(By.xpath("//*[text() = 'Mattress Fee']/../..//p"));
    private final SelenideElement customWindowTreatments = $(By.xpath("//*[text()='Custom Window Treatments']"));
    private final SelenideElement replacementParts = $(By.xpath("//*[text()='REPLACEMENT PARTS']"));
    private final SelenideElement rugsByFiber = $(By.xpath("//*[text()='Rugs By Fiber']"));
    private final SelenideElement woolRugs = $(By.xpath("//*[text()='Wool Rugs']"));
    private final SelenideElement itemAddedToCart = $(By.xpath("//*[text()='1 Item  Added To Your Cart']"));
    private final SelenideElement performanceFiberRugs = $(By.xpath("//*[text()='Performance Fiber Rugs']"));
    private final SelenideElement viewCart = $(By.xpath("//*[text()='View Cart']"));
    private final SelenideElement searchIcon = $(By.xpath("(//*[@class = 'MuiIconButton-label'])[1]"));
    private final SelenideElement searchFieldInput = $(By.xpath("//*[@id = 'site-search-input']"));
    private final SelenideElement keepShoppingText = $(By.xpath("//*[text()='Keep Shopping']"));
    private final SelenideElement dialogTitleCloseButton = $(By.xpath("//*[@data-testid ='dialog-title-close-button']"));
    private final SelenideElement agreeAndAddToCart = $(By.xpath("//*[text() = 'Agree & Add To Cart']"));
    private final SelenideElement addToProjectButton = $(By.xpath("//*[text()='ADD TO PROJECT']"));
    private final SelenideElement seeAllResultButton = $(By.xpath("//*[text() = 'SEE ALL RESULTS']"));
    private final SelenideElement shopTheEntireCollectionTitle = $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]"));
    private final SelenideElement zoomInButton = $(By.xpath("//*[@id= 'Grommet/ZoomIn']"));
    private final SelenideElement zoomOutButton = $(By.xpath("//*[@id= 'Grommet/ZoomOut']"));
    private final SelenideElement zoomModule = $(By.xpath("(//*[@id= 'PDP']//*[@id= 'Grommet/ZoomIn'])[2]"));
    private final SelenideElement leftArrow = $(By.xpath("(//*[contains(@class, 'arrow-container')])[3]"));
    private final SelenideElement firstAltImage = $(By.xpath("(//*[@id= 'component-rh-image'])[7]"));
    private final SelenideElement secondAltImage = $(By.xpath("(//*[@id= 'component-rh-image'])[8]"));
    private final SelenideElement thirdAltImage = $(By.xpath("(//*[@id= 'component-rh-image'])[9]"));
    private final SelenideElement fourthAltImage = $(By.xpath("(//*[@id= 'component-rh-image'])[10]"));
    private final SelenideElement fifthAltImage = $(By.xpath("(//*[@id= 'component-rh-image'])[11]"));
    private final SelenideElement rightArrow = $(By.xpath("(//*[contains(@class, 'arrow-container')])[4]"));
    private final SelenideElement monogramsColor = $(By.xpath("//*[text()='Color']"));
    private final SelenideElement rightSideImageCarousel = $(By.xpath("//*[@class= 'slick-slider slick-vertical slick-initialized']"));
    private final SelenideElement monogramsColorsValue = $(By.xpath("//*[text()='TOT']"));

    private final SelenideElement yamlCarouselMenu = $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']"));

    private final SelenideElement itemsLineSize = $(By.xpath("//*[contains(@id, 'optionSelect') and text() = 'Size']/..//select"));

    private final SelenideElement itemsLineFinish = $(By.xpath("(//*[contains(@id, 'optionSelect') and text() = 'Finish']/..//select)[1]"));

    private final SelenideElement itemsLineQTY= $(By.xpath("(//*[contains(@id, 'qty-input-label') and text() = 'QTY']/..//select)[1]"));

    private final SelenideElement littlePreviewOfAltItemImage = $(By.xpath("//img[@alt = 'T-Brace Rectangular Extension Dining Table']"));

    private final SelenideElement care = $(By.xpath("//*[text() = 'Care']"));

    private final SelenideElement colorOptionList = $(By.xpath("//*[text() ='Color Options']/following-sibling::ul"));

    private final SelenideElement viewInStockItemText = $(By.xpath("(//*[contains(@data-testid , 'productImageLink')]/../span)[1]"));
    private final ElementsCollection viewInStockItemSize = $$(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span"));

    private final ElementsCollection viewItems = $$(By.xpath("//*[contains(@data-testid , 'productImageLink')]/../span[1]"));

    private final ElementsCollection firstChaiseList = $$(By.xpath("(//p[contains(text() , 'Chaise')])[1]/../../../../../../..//select[contains(@id ,'prod')]"));

    private final ElementsCollection secondChaiseList = $$(By.xpath("(//p[contains(text() , 'Cushions')])[2]/../../../../../../..//select[contains(@id ,'prod')]"));

    private final ElementsCollection coversList = $$(By.xpath("//p[contains(text() , 'COVERS')]/../../../../../../..//select[contains(@id ,'prod')]"));
    private final ElementsCollection swatchList = $$(By.xpath("(//p[contains(text() , 'Swatch')])[1]/../../../../../../..//select[contains(@id ,'prod')]"));

    private final ElementsCollection kitItems = $$(By.xpath("(//p[contains(text() , 'Touch-Up Kit')])[1]/../../../../../../..//select[contains(@id ,'prod')]"));
    private final SelenideElement configureDeliveryInformation = $(By.xpath("//*[text() = 'Configure this item to view delivery information']"));
    private final SelenideElement yamlCarouselMenuRightArrow = $(By.xpath("(//*[text() = 'YOU MIGHT ALSO LIKE']/..//ul/div/div)[3]"));
    private final ElementsCollection rightSideImageCarouselArrows = $$(By.xpath("//*[@class= 'slick-slider slick-vertical slick-initialized']//*[contains(@class, 'arrow-icon')]"));
    private final SelenideElement swatchText = $(By.xpath("//a/*[contains(text(), 'Swatch')]"));

    private final SelenideElement swatchImage = $(By.xpath("//img[contains(@alt, 'Swatch')]"));

    private final SelenideElement deliveryInStockItemText = $(By.xpath(" (//*[contains (text(), 'This item is in stock and will be delivered')])[1]"));

    private final ElementsCollection swatchItemsLine = $$(By.xpath("(//p[contains(text() , 'Swatch')])[1]/../../../../../../..//select[contains(@id ,'prod')]"));

    private final ElementsCollection productCardLinkList = $$(By.xpath("//*[contains(@data-testid ,'productCardLink')]//span"));

    private final ElementsCollection YAMLPriceForRegular = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-regular']"));

    private final ElementsCollection YAMLPriceForMember = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-member']"));

    private final ElementsCollection priceForMemberCollection = $$(By.xpath("//*[@id='rh-price-range-display']/div[2]/p[@data-testid='price-for-member']"));

    private final ElementsCollection priceForRegularCollection = $$(By.xpath("//*[@id='rh-price-range-display']/div[2]/p[@data-testid='price-for-regular']"));

    private final ElementsCollection YAMLPriceForTrade = $$(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/..//*[@data-testid='price-for-trade']"));

    private final SelenideElement noChargeShippedSwatchesText = $(By.xpath("//*[text() = 'Swatches are shipped at no charge. For free USPS expedited delivery to arrive within 2-3 business days, all swatches must be placed in a separate order from product orders.']"));

    private final SelenideElement itemLocator = $(By.xpath("(//*[contains(text(), 'Item#')])[1]"));

    private final SelenideElement footer = $(By.xpath("//*[@id = 'footer']"));

    private final SelenideElement itemValue = $(By.xpath("//*[text() = 'Item# 10024796 WGRY']"));

    private final SelenideElement upholsterySwatch = $(By.xpath("//p[contains(text(), 'Upholstery Swatch')]"));

    private final SelenideElement itemTitle = $(By.xpath("(//*[contains(@class, 'MuiTypography-root MuiTypography')]/..)[1]"));

    private final SelenideElement deliveryInformation = $(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'will be ready for delivery between')]"));

    private final SelenideElement unlimitedFurnitureDeliveryText = $(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'Unlimited Furniture Delivery')]"));

    private final SelenideElement unlimitedFurnitureDeliveryModalText = $(By.xpath("//*[text() = 'Unlimited Furniture Delivery']"));

    private final SelenideElement unlimitedFurnitureDeliveryModalStandartShippingTabText = $(By.xpath("//*[text() = 'Standard Shipping']"));

    private final SelenideElement unlimitedFurnitureDeliveryModalUSCurrency = $(By.xpath("(//*[text() = 'Unlimited Furniture Delivery']/..//*[contains(text() , '$')])[1]"));

    private final SelenideElement unlimitedFurnitureDeliveryModalUSStandartShippingCurrency = $(By.xpath("(//*[text() = 'U.S. Standard Shipping']/..//*[contains(text() , '$')])[1]"));

    private final SelenideElement unlimitedFurnitureDeliveryModalGBStandartShippingCurrency = $(By.xpath("(//*[text() = 'U.S. Standard Shipping']/..//*[contains(text() , '£')])[1]"));

    private final SelenideElement shippingAndDeliveryModalTab = $(By.xpath("//*[text() = 'Shipments to Canada']"));

    private final SelenideElement standartDeliveryShippingText = $(By.xpath("//*[text() = 'Ships free of charge via Standard Delivery Shipping']"));
    private final SelenideElement shippingAndDeliveryModalDeliveryAreaText = $(By.xpath("//*[text() = 'CANADIAN DELIVERY AREA']"));

    private final SelenideElement returnPolicyText = $(By.xpath("//*[@id = 'component-sku']/..//p[contains (text(), 'This item can be returned or exchanged within 30 days of delivery.')]"));

    private final SelenideElement furnitureTouchKitText = $(By.xpath("//*[contains(text(), 'Furniture Touch-Up Kit')]"));

    private final SelenideElement returnPolicyLink = $(By.xpath("(//*[@href = 'https://rh.com/customer-service/return-policy.jsp'])[1]"));

    private final SelenideElement disabledAddToCartButton = $(By.xpath("(//*[@id = 'add-to-cart-button'])[1][@disabled]"));

    private final SelenideElement YMAL = $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']"));
    private final SelenideElement YMALList = $(By.xpath("//*[text() = 'YOU MIGHT ALSO LIKE']/../ul"));

    private final SelenideElement disabledAddToProjectButton = $(By.xpath("(//*[@id = 'add-to-project-button'])[1][@disabled]"));

    private final SelenideElement enabledAddToCartButton = $(By.xpath("(//*[@id = 'add-to-cart-button'])[1]"));

    private final SelenideElement pdpModalEnabledAddToCartButton = $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[1]"));
    private final SelenideElement pdpModalDisabledAddToCartButton = $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[1][@disabled]"));

    private final SelenideElement enabledAddToProjectButton = $(By.xpath("(//*[@id = 'add-to-project-button'])[1]"));
    private final SelenideElement addToCartButton = $(By.xpath("(//*[@id = 'add-to-cart-button'])[1]"));
    private final SelenideElement learnMoreAboutText = $(By.xpath("(//*[text() = 'Learn more about our'])[1]"));

    private final SelenideElement returnPolicy = $(By.xpath("(//*[text() = 'Return Policy'])[1]"));

    private final SelenideElement modalAddToCartButton = $(By.xpath("(//*[@data-testid = 'add-to-cart-dialog-opener'])[8]"));
    private final SelenideElement checkForReplacementPartsButton = $(By.xpath("(//*[text() ='CHECK FOR REPLACEMENT PARTS'])[1]"));
    private final SelenideElement cancelButton = $(By.xpath("//*[text()='CANCEL']"));

    private final SelenideElement checkForReplacementParts = $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']"));

    private final SelenideElement formDialogCloseButtons = $(By.xpath("//*[@data-testid ='form-dialog-close-button']"));

    private final SelenideElement itemAddedToYourCartText = $(By.xpath(" //*[text() = '1 Item  Added To Your Cart']"));
    private final SelenideElement viewCartTextButton = $(By.xpath("//button[@id = 'ajax-proceed-to-cart']/*[text() = 'View Cart']"));
    private final SelenideElement keepShoppingButton = $(By.xpath("//button[@id = 'ajax-continue-shopping']/*[text() = 'Keep Shopping']"));
    private final SelenideElement deliveryBetweenText = $(By.xpath("//*[@id = 'component-sku']//p[contains (text(), 'This item will be ready for delivery between')]"));

    private final SelenideElement rightSideImageCarouselDownArrow = $(By.xpath("(//*[@class= 'slick-slider slick-vertical slick-initialized']//*[contains(@class, 'arrow-icon')])[2]"));

    private final SelenideElement firstProductImage = $(By.xpath("(//*[@class = 'slick-slider slick-vertical slick-initialized']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/prod18890296')])[1]"));

    private final SelenideElement pdpTitle = $(By.xpath("(//h1[contains(@class, MuiTypography)])[1]"));

    private final SelenideElement cloudModularLeatherSofaText = $(By.xpath("//h3[text() = 'Cloud Modular Leather Sofa']"));
    private final SelenideElement premiumFabrics = $(By.xpath("//*[text()='Premium Fabrics']"));

    private final SelenideElement itemsValues = $(By.xpath("//*[text()='Items#: 89630210 BWMR, 89720340 BWMR']"));
    private final SelenideElement kensingtonItemText = $(By.xpath("//*[text()='KENSINGTON LEFT-ARM L-SECTIONAL']"));

    private final SelenideElement cloudModularLeatherSofaFirstItem = $(By.xpath("(//*[text()='Cloud Modular Leather Sofa'])[1]"));

    private final SelenideElement cloudModularLeatherSofaSecondItem = $(By.xpath("(//*[text()='Cloud Modular Leather Sofa'])[2]"));

    private final SelenideElement itemNumber = $(By.xpath("//*[text() = 'Item #']"));

    private final SelenideElement lineItemSectionImage = $(By.xpath("(//*[contains(@class, 'MuiGrid-spacing-xs-4')])[4]//img"));
    private final SelenideElement salePrice = $(By.xpath("//*[@data-testid = 'price-for-sale']"));

    private final SelenideElement pdpModelOnSaleName = $(By.xpath("//*[text() = 'ON SALE']"));

    private final SelenideElement pdpModelLoadMoreButton = $(By.xpath("//*[text() = 'LOAD MORE']"));

    private final ElementsCollection collectionList = $$(By.xpath("//a/img[@class = 'desktop-img']"));

    private final ElementsCollection productIteList = $$(By.xpath("//p/span"));
    private final SelenideElement saveButton = $(By.xpath("//*[text() = 'SAVE']"));

    private final SelenideElement modalQuantity = $(By.xpath("//*[@id = 'listColumn1-Quantity' and text() = 'Quantity']"));

    private final SelenideElement modalQuantityNumber = $(By.xpath("//*[@id = 'listColumn2-Quantity' and text() = '1']"));
    private final SelenideElement modalFinish= $(By.xpath("//*[@id = 'listColumn1-Finish' and text() = 'Finish']"));

    private final SelenideElement modalFinishValue= $(By.xpath("//*[@id = 'listColumn2-Finish']"));
    private final SelenideElement modalSize= $(By.xpath("//*[@id = 'listColumn1-Size' and text() = 'Size']"));
    private final SelenideElement modalSizeValue= $(By.xpath("//*[@id = 'listColumn2-Size']"));
    private final SelenideElement itemAddedToCompany = $(By.xpath("(//h3)[2]"));

    private final SelenideElement projectName = $(By.xpath("//*[@id = 'project-name']"));

    private final SelenideElement projectOpportunitySelectLabel = $(By.xpath("//*[@id = 'project-opportunity-select-label']"));

    private final SelenideElement projectOpportunitySelect = $(By.xpath("//*[@id = 'project-opportunity-select']"));

    private final SelenideElement projectSpaceSelectLabel = $(By.xpath("//*[@id = 'project-space-select-label']"));

    private final SelenideElement projectSpaceSelect = $(By.xpath("//*[@id = 'project-space-select']"));
    private final SelenideElement countInTheCart = $(By.xpath("//*[text()='1'']"));

    private final SelenideElement continueShoppingButton = $(By.xpath("//*[text() = 'CONTINUE SHOPPING']"));

    private final SelenideElement goToProjectButton = $(By.xpath("//*[text() = 'GO TO PROJECT']"));

    private final SelenideElement addNewProjectButton = $(By.xpath("//*[text() = 'ADD NEW PROJECT']"));

    private final SelenideElement addNewSpaceButton = $(By.xpath("//*[text() = 'ADD NEW SPACE']"));

    private final SelenideElement itemDescriptionImage = $(By.xpath("(//img[@alt = 'T-Brace Rectangular Extension Dining Table'])[2]"));
    private final SelenideElement itemDescriptionImageLine = $(By.xpath(" (//*[text() = 'T-Brace Rectangular Extension Dining Table'])[3]"));
    private final SelenideElement itemDescriptionTitle = $(By.xpath("//h6[text() = 'T-Brace Rectangular Extension Dining Table']"));

    private final SelenideElement secondProductImage = $(By.xpath("(//*[@class = 'slick-slider slick-vertical slick-initialized']//img[contains(@src, '//media.restorationhardware.com/is/image/rhis/prod18890296')])[1]"));

    private final SelenideElement invalidPostalCodeMessage = $(By.xpath("//*[text() = 'Please enter a valid postal code']"));

    private final SelenideElement modalItemNumber = $(By.xpath("//*[@id = 'listColumn1-Item#' and text() = 'Item#']"));

    private final SelenideElement viewSelectItemsOnSaleText = $(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']"));
    private final SelenideElement viewSelectItemsOnSaleTextBelowLineItem = $(By.xpath("(//*[contains(@data-testid, 'productImageLink')]/../..//span)[1]"));

    private final SelenideElement alsoAvailableText = $(By.xpath("//a[contains(text(), 'ALSO AVAILABLE')]"));

    private final SelenideElement shopTheEntireCollectionText = $(By.xpath("//a[contains(text(), 'SHOP THE ENTIRE COLLECTION')]"));

    private final SelenideElement selectFromText = $(By.xpath("//*[contains(@data-testid, 'SELECT FROM')]"));

    private final SelenideElement specialOrderFabricsSiblingText = $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]/following-sibling::div//img"));

    private final SelenideElement specialOrderFabricsText = $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER FabricS')]"));

    private final SelenideElement finishOptionText = $(By.xpath("//*[text() = 'Finish Options']"));
    private final SelenideElement finishText = $(By.xpath("(//*[text() = 'Finish'])[1]"));
    private final SelenideElement imageCarousel = $(By.xpath("//*[@class= 'slick-slider slick-initialized']"));
    private final SelenideElement dimensionSection = $(By.xpath("//*[text() = 'DIMENSIONS']"));

    private final SelenideElement detailsSection = $(By.xpath("//*[text() = 'DETAILS']"));

    private final SelenideElement leatherCare = $(By.xpath("//*[text() = 'Leather Care']"));
    private final SelenideElement fabricCare = $(By.xpath("//*[text() = 'Fabric Care']"));
    private final ElementsCollection finishOptionSiblingText = $$(By.xpath("//*[text() = 'Finish Options']/..//*[@id = 'component-rh-image_wrapper']"));

    private final ElementsCollection optionSelectItem = $$(By.xpath("(//*[contains(@data-testid ,'productTitleLink')])[1]/../../../../../..//select[contains(@id ,'prod')]"));

    private final SelenideElement heroImage = $(By.xpath("//*[@data-testid = 'desktop-pdp-image']"));

    private final SelenideElement zoomButton = $(By.xpath(" //*[@id= 'Grommet/ZoomIn']"));

    private final SelenideElement rightSideImageCarouselModuleCloseButton = $(By.xpath(" (//button[@class = 'MuiButtonBase-root MuiIconButton-root'])[2]"));

    private final SelenideElement specialOrdersButton = $(By.xpath("//div[contains(@data-testid,'SPECIAL ORDER FabricS')]"));

    private final SelenideElement zipCode = $(By.xpath("(//*[@data-testid = 'postal-code-dialog-opener'])[1]"));

    private final ElementsCollection inStockModalItemsList = $$(By.xpath("//*[@id = 'component-in-stock-product-card']"));

    private final ElementsCollection linesItemsList = $$(By.xpath("//*[@id = 'component-rh-link']/p"));

    private final ElementsCollection zipcodeList = $$(By.xpath(" //*[@data-testid = 'postal-code-dialog-opener']"));
    private final SelenideElement confirmationPostalCode = $(By.xpath("//*[@data-testid= 'submit-postal']"));

    private final SelenideElement confirmationChangePostalCode = $(By.xpath("//*[text() = 'CONFIRM CHANGE']"));

    private final SelenideElement confirmationMessagePostalCode = $(By.xpath("//*[text() = \"You've changed your shipping country. Please note that product availability may vary by shipping country.\"]"));

    private final SelenideElement inStockModalDeliveryInformationList = $(By.xpath("//*[@id = 'component-in-stock-product-card']//*[contains(text(), 'will be ready for delivery between')]"));

    private final SelenideElement pdpZipCodeModalShippingCountry = $(By.xpath("//*[@id = 'country-zipcode-selection']"));

    private final SelenideElement pdpZipCodeModalCanada = $(By.xpath("//*[text() ='Canada']"));

    private final SelenideElement pdpZipCodeModalDefpultCountry = $(By.xpath("//*[text() = 'United States']"));

    private final SelenideElement fogSpecialOrderColor = $(By.xpath("//*[text() = 'Fog ']"));
    private final SelenideElement inStockModalQuantityDropDownList = $(By.xpath("(//*[@data-testid = 'in-stock-qty-select'])[1]//select"));

    private final SelenideElement postalCode = $(By.xpath("//*[@id= 'postal-code-international']"));

    private final SelenideElement availabilityDeliveryInformation = $(By.xpath("//*[contains(text() , 'This item will be ready for delivery between')]"));

    private final SelenideElement postalCodeModal = $(By.xpath("//*[text() = 'PLEASE ENTER YOUR POSTAL CODE']"));

    private final SelenideElement mattressFeeText = $(By.xpath("//*[text() = 'Mattress Fee']"));

    private final SelenideElement pdpMattressFeeText = $(By.xpath("//*[@data-testid = 'delivery-message-0']"));

    private final SelenideElement pdpMattressFeeLink = $(By.xpath("//*[@href = '/graphql/?group=general-modals&id=mattress-recycling']"));
    private final SelenideElement specialOrderLink = $(By.xpath("//*[contains(@data-testid, 'SPECIAL ORDER')]"));

    private final SelenideElement mattressRecyclingFeeText = $(By.xpath("//*[@href= '/graphql/?group=general-modals&id=mattress-recycling']/.."));

    private final SelenideElement fogSelectedOption = $(By.xpath("(//select[contains(@id,'prod') and contains(@id,'Color')])[1]//option[@data-option='selected']"));

    private final SelenideElement closeSpecialOrderPopUpButton = $(By.xpath("//button[@data-testid = 'dialog-title-close-button']"));

    private final SelenideElement specialOrderPopUpModal = $(By.xpath("//*[@data-testid = 'dialog-title-close-button']/../.."));


    private final SelenideElement colorLineItem = $(By.xpath("(//label[text() = 'Color']/..//option[@data-option='selected'])[1]"));

    private final SelenideElement specialOrderPopUpHeaderHeader = $(By.xpath("//p[@data-testid = 'swatch-panel-dialog-delivery-message']"));

    private final SelenideElement productTitleGiftCard = $(By.xpath("//*[@class='MuiTypography-root MuiTypography-h2' and text()='RH GIFT CARD']"));

    public SelenideElement getTtemYAMLListByNumber(int number) {
        String path = String.format(itemYAMLList, number);
        return $(byXpath(path));
    }

    public SelenideElement getProductNumberByNumber(String number) {
        String path = String.format(productNumber, number);
        return $(byXpath(path));
    }

    public SelenideElement getItemByText(String number) {
        String path = String.format(textLocator, number);
        return $(byXpath(path));
    }

    public SelenideElement getCollectionByNumber(Integer number) {
        String path = String.format(collection, number);
        return $(byXpath(path));
    }

    public SelenideElement getProductItemByNumber(Integer number) {
        String path = String.format(productItem, number);
        return $(byXpath(path));
    }

    public SelenideElement getLineItemByLineItem(String lineItem1, String lineItem2) {
        String path = String.format(lineItem, lineItem1, lineItem2);
        return $(byXpath(path));
    }

    public SelenideElement getOption(String option) {
        String path = String.format(option, option);
        return $(byXpath(path));
    }

    public SelenideElement getItemByValue(String value) {
        String path = String.format(modalItemValue, value);
        return $(byXpath(path));
    }

    public SelenideElement getItemByNumber(Integer number) {
        String path = String.format(itemListNumber, number);
        return $(byXpath(path));
    }

    public SelenideElement getZipCodeByArg(String arg) {
        String path = String.format(zipCodeValue, arg);
        return $(byXpath(path));
    }

    public SelenideElement getColorByName(String color) {
        String path = String.format(stockedColor, color);
        return $(byXpath(path));
    }

    public SelenideElement getCountryByName(String country) {
        String path = String.format(pdpZipCodeCountry, country);
        return $(byXpath(path));
    }

}
