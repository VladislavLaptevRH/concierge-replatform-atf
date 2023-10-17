package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter

public class ConciergeItemsScreen {
    private final SelenideElement firstItem = $(By.xpath("(//div[contains(@class,'cols-6')]//div[contains(@class,'MuiGrid-grid-xs-6')])[1]"));

    private final SelenideElement error = $(By.xpath("//*[text() = 'Error while adding items to project']"));

    private final SelenideElement selectSize = $(By.xpath("(//select[contains(@id, 'Size')])[1]"));

    private final SelenideElement selectDepth = $(By.xpath("(//select[contains(@id, 'Depth')])[1]"));

    private final SelenideElement selectFabric = $(By.xpath("(//select[contains(@id, 'Fabric')])[1]"));

    private final SelenideElement selectCanopyHeight= $(By.xpath("(//select[contains(@id, 'Canopy Height')])[1]"));

    private final SelenideElement selectColor = $(By.xpath("(//select[contains(@id, 'Color')])[1]"));

    private final SelenideElement selectFinish= $(By.xpath("(//select[contains(@id, 'Finish')])[1]"));

    private final SelenideElement selectQTY = $(By.xpath("(//select[contains(@id, 'qty')])[1]"));

    private final SelenideElement selectFill = $(By.xpath("(//select[contains(@id, 'Fill')])[1]"));

    private final SelenideElement selectLeather = $(By.xpath("(//select[contains(@id, 'Leather')])[1]"));

    private final List<SelenideElement> items = $$(By.xpath("//div[@class= 'MuiGrid-root MuiGrid-container']/div"));

    private final List<SelenideElement> twoItemsSection = $$(By.xpath("//ul[contains(@class,'MuiGridList-root')]/li[@class='MuiGridListTile-root']"));

    private final List<SelenideElement> twoItemsInRow = $$(By.xpath("(//li[@class='MuiGridListTile-root'][2])[1]"));

    private final List<SelenideElement> collectionsItems = $$(By.xpath("//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-12')]/div/ul[contains(@class,'MuiGridList-root')]/li[@class='MuiGridListTile-root']"));

    private final SelenideElement addToCartButton = $(By.xpath("(//button[@data-testid='add-to-cart-dialog-opener'])[1]"));

    private final SelenideElement addToCartButtonDisabled = $(By.xpath("(//button[@data-testid='add-to-cart-dialog-opener'])[1][@disabled]"));

    private final SelenideElement viewCartButton = $(By.cssSelector("#ajax-proceed-to-cart"));

    private final SelenideElement detailsSpan = $(By.xpath("//*[text()='DETAILS']"));

    private final SelenideElement detailsSpanWithSpase = $(By.xpath("//*[text()=' DETAILS']"));

    private final SelenideElement checkoutButton = $(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth'])[1]"));

    private final SelenideElement closePopUpButton = $(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/div[2]/div/div[2]/button"));

    private final SelenideElement addToProjectButton = $(By.xpath("(//*[text()='ADD TO PROJECT'])[1]"));

    private final SelenideElement saveProjectPopUpButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButton-containedPrimary MuiButton-fullWidth')]"));

    private final SelenideElement addedIttemToProjectTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement continueShoppingButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement aggreeeAndAddToCardButton = $(By.cssSelector("#spo-auth-addToCart"));

    private final SelenideElement collectionsText = $(By.xpath("//*[text()='collections']"));

    private final SelenideElement metalFloatingMirror = $(By.xpath("(//*[text()='Metal Floating Mirror'])[2]"));

    private final SelenideElement lapazSofaItem = $(By.xpath("(//*[text()='La Paz Sofa '])[2]"));

    private final SelenideElement collectionItem = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4']"));

    private final SelenideElement goToProjectButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]"));

    private final SelenideElement addToProjectTitleSelect = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']//h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement opportunityNameSelect = $(By.xpath("//select[@id='opportunityName']"));

    private final SelenideElement monogramColorChampagne = $(By.xpath("//input[@value='Champagne Metallic (MCHA)']"));

    private final SelenideElement addMonogramCheckBox = $(By.xpath("//*[contains(text(), 'Add Monogram for')]/../..//input"));

    private final SelenideElement addMonogramCheckBoxPdp = $(By.xpath("//span[@class='MuiIconButton-label']/input"));

    private final SelenideElement addGiftCheckBox = $(By.xpath("//*[contains(text(), 'Add Gift Box for')]/../..//input"));

    private final SelenideElement spaceNameSelect = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12'][3]//select"));

    private final SelenideElement agreeAndAddToCartButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'Agree & Add To Cart']"));

    private final SelenideElement choseFinishOption = $(By.xpath("//*[text() = 'Finish Options']/../ul/li[1]"));

    private final SelenideElement countrySelection = $(By.xpath("(//*[@class = 'MuiGrid-root MuiGrid-item']//div)[3]"));

    private final SelenideElement gbCountry = $(By.xpath("//*[text() = 'UNITED KINGDOM (£)']"));

    private final SelenideElement caCountry = $(By.xpath("//*[text() = 'CANADA ($)']"));

    private final SelenideElement usCountry = $(By.xpath("//*[text() = 'UNITED STATES ($)']"));

    private final SelenideElement selectCountrySaveButton = $(By.xpath("//*[text() = 'SAVE']"));

    private SelenideElement saleButtonMenu = $(By.xpath("//*[text()='SALE']"));

    private SelenideElement saleButtonMenuForUK = $(By.xpath("//*[text()='Sale']"));

    private final SelenideElement livingSaleMenuBar = $(By.xpath("(//*[contains(text(),'Living')])[2]"));

    private SelenideElement footerValidation = $(By.xpath("//*[@id = 'footer']"));

    private SelenideElement fabricChairInSale = $(By.xpath("//*[text()='Fabric Chairs']"));

    private SelenideElement freeShippingMessage = $(By.xpath("//*[text()='ENJOY FREE SHIPPING ON ALL TEXTILES']"));

    private SelenideElement moInCGPage = $(By.xpath("(//*[contains(text(),'Modular')])[1]"));

    private SelenideElement viewCartImage = $(By.xpath("//*[@id=\"header-cart-button\"]/div"));
    private final SelenideElement searchField = $(By.xpath("//*[@id = 'site-search-input']"));
    private final SelenideElement seeAllResult = $(By.xpath("//*[text() = 'SEE ALL RESULTS']"));
    private final SelenideElement searchResultHeader = $(By.xpath("//*[text()='sofa']"));
    private final SelenideElement inStock = $(By.xpath("//p[text()='in-stock']"));
    private final SelenideElement artResultHeader = $(By.xpath("//p[text()='art']"));
    private final SelenideElement swivelsResultHeader = $(By.xpath("//p[text()='swivels']"));
    private final SelenideElement multiSearchHeader = $(By.xpath("//*[text()=' white and blue corner leather sofa']"));
    private final SelenideElement searchClearButton = $(By.xpath("//input[@placeholder='SEARCH']//parent::div//descendant::*[@id='Grommet/X-Close']"));
    private final SelenideElement clearAll = $(By.xpath("//*[text()='Clear All']"));

}

