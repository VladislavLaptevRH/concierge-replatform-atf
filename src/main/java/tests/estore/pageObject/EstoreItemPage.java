package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreItemPage {

    private final SelenideElement selectQuantity = $(By.xpath("//select[contains(@id,'prod') and contains(@id,'qty-input')]"));

    private final SelenideElement selectQuantityCartPage = $(By.xpath("//select[contains(@id,'quantity')]"));

    private final SelenideElement firstItem = $(By.xpath("(//div[contains(@class,'cols-6')]//div[contains(@class,'MuiGrid-grid-xs-6')])[1]"));

    private final SelenideElement items = $(By.xpath("//a[@data-testid='productCardLink-prod27080291']"));

    private final List<SelenideElement> twoItemsSection = $$(By.xpath("//ul[contains(@class,'MuiGridList-root')]/li[@class='MuiGridListTile-root']"));

    private final List<SelenideElement> twoItemsInRow = $$(By.xpath("(//li[@class='MuiGridListTile-root'][2])[1]"));

    private final List<SelenideElement> collectionsItems = $$(By.xpath("//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-12')]/div/ul[contains(@class,'MuiGridList-root')]/li[@class='MuiGridListTile-root']"));

    private final SelenideElement addToCartButton = $(By.xpath("(//button[@id='component-related-product-card_add-to-cart-btn'])[1]"));

    private final SelenideElement viewSearchResultsButton = $(By.xpath("//*[@data-testid='add-to-cart-dialog-opener']"));

    private final SelenideElement addToCartButtonNotDisabled = $(By.xpath("(//button[@data-testid='add-to-cart-dialog-opener'])[1][not(@disabled)]"));

    private final SelenideElement addToCartDisabledButton = $(By.xpath("(//*[@data-testid= 'add-to-cart-dialog-opener'])[1][@disabled]"));

    private final SelenideElement selectFabric = $(By.xpath("(//select[contains(@id, 'Fabric')])[1]"));

    private final SelenideElement selectFinish = $(By.xpath("(//select[contains(@id, 'Finish')])[1]"));

    private final SelenideElement selectQTY = $(By.xpath("(//select[contains(@id, 'qty')])[1]"));
    private final SelenideElement selectColor = $(By.xpath("(//select[contains(@id, 'Color')])[1]"));

    private final SelenideElement viewCartButton = $(By.cssSelector("#ajax-proceed-to-cart"));

    private final SelenideElement detailsSpan = $(By.xpath("//*[text()='DETAILS']"));

    private final SelenideElement checkoutButton = $(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth'])[1]"));

    private final SelenideElement closePopUpButton = $(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/div[2]/div/div[2]/button"));

    private final SelenideElement addToProjectButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//*[text()='ADD TO PROJECT'][1]"));

    private final SelenideElement saveProjectPopUpButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButton-containedPrimary MuiButton-fullWidth')]"));

    private final SelenideElement addedIttemToProjectTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement continueShoppingButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement aggreeeAndAddToCardButton = $(By.cssSelector("#specialOrderConfirmation_addToCart-btn"));

    private final SelenideElement collectionsText = $(By.xpath("//*[contains(text(),'collections')]"));

    private final SelenideElement metalFloatingMirror = $(By.xpath("(//*[text()='Metal Floating Mirror'])[2]"));

    private final SelenideElement lapazSofaItem = $(By.xpath("(//*[text()='La Paz Sofa'])[2]"));

    private final SelenideElement collectionItem = $(By.xpath("(//div[@id='component-rh-image'])[1]"));

    private final SelenideElement goToProjectButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]"));

    private final SelenideElement addToProjectTitleSelect = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']//h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement opportunityNameSelect = $(By.xpath("//select[@id='opportunityName']"));

    private final SelenideElement monogramColorChampagne = $(By.xpath("//input[@value='Champagne Metallic (MCHA)']"));

    private final SelenideElement addMonogramCheckBox = $(By.xpath("(//span[@class='MuiIconButton-label']/input)[2]"));

    private final SelenideElement addMonogramCheckBoxPdp = $(By.xpath("//span[@class='MuiIconButton-label']/input"));

    private final SelenideElement addGiftCheckBox = $(By.xpath("(//span[@class='MuiIconButton-label']/input)[3]"));

    private final SelenideElement spaceNameSelect = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12'][3]//select"));

    private final SelenideElement agreeAndAddToCartButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'Agree & Add To Cart']"));

    private final SelenideElement addToWishListButton = $(By.xpath("(//div[@id='component-relatedProductActions_addToWishlist-btn'])[1]"));

    private final SelenideElement viewWishlistButton = $(By.id("addToWishlistDialog_viewWishList-btn"));

    private final SelenideElement continueWithOriginalAddressButton = $(By.xpath("(//button[@data-testid='add-to-cart-dialog-opener'])[1]"));


    public void clickToViewSearchResultsButton() {
        viewSearchResultsButton.should(Condition.interactable).click();
    }
}
