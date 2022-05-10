package com.test.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter

public class ConciergeItemsScreen {
    private final List<SelenideElement> items = $$(By.xpath("//ul[contains(@class,'MuiGridList-root')]/li"));

    private final List<SelenideElement> twoItemsSection = $$(By.xpath("//ul[contains(@class,'MuiGridList-root')]/li[@class='MuiGridListTile-root']"));

    private final List<SelenideElement> twoItemsInRow = $$(By.xpath("(//li[@class='MuiGridListTile-root'][2])[1]"));

    private final List<SelenideElement> collectionsItems = $$(By.xpath("//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-12')]/div/ul[contains(@class,'MuiGridList-root')]/li[@class='MuiGridListTile-root']"));

    private final SelenideElement addToCartButton = $(By.xpath("(//button[@data-testid='add-to-cart-dialog-opener'])[1]"));

    private final SelenideElement viewCartButton = $(By.cssSelector("#ajax-proceed-to-cart"));

    private final SelenideElement detailsSpan = $(By.xpath("//*[text()='DETAILS']"));

    private final SelenideElement checkoutButton = $(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item')][2]//button"));

    private final SelenideElement closePopUpButton = $(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/div[2]/div/div[2]/button"));

    private final SelenideElement addToProjectButton = $(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//*[text()='ADD TO PROJECT'][1]"));

    private final SelenideElement saveProjectPopUpButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButton-containedPrimary MuiButton-fullWidth')]"));

    private final SelenideElement addedIttemToProjectTitle = $(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement continueShoppingButton = $(By.xpath("//div[2]/button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

    private final SelenideElement aggreeeAndAddToCardButton = $(By.cssSelector("#spo-auth-addToCart"));

    private final SelenideElement collectionsText = $(By.xpath("//*[text()='collections']"));

    private final SelenideElement metalFloatingMirror = $(By.xpath("(//*[text()='Metal Floating Mirror'])[2]"));

    private final SelenideElement lapazSofaItem = $(By.xpath("(//*[text()='La Paz Sofa'])[2]"));

    private final SelenideElement collectionItem = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][1]/li"));

    private final SelenideElement goToProjectButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]"));

    private final SelenideElement addToProjectTitleSelect = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']//h3[@class='MuiTypography-root MuiTypography-h3']"));

    private final SelenideElement opportunityNameSelect = $(By.xpath("//select[@id='opportunityName']"));

    private final SelenideElement addMonogramCheckBox = $(By.xpath("(//span[@class='MuiIconButton-label']/input)[2]"));

    private final SelenideElement addGiftCheckBox = $(By.xpath("(//span[@class='MuiIconButton-label']/input)[3]"));

    private final SelenideElement spaceNameSelect = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12'][3]//select"));
}
