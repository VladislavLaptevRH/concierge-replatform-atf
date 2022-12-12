package tests.concierge.pageObject;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Getter

public class SaleScreen {
    private final SelenideElement saleOption = $(By.xpath("//div[@data-navigation-account-item-id= 'cat3890154']"));
    private final List<SelenideElement> listOfSaleMainCategory = $$(By.xpath("//div[@class= 'MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-evenly']/div"));
    private final List<SelenideElement> listOfSaleSubCategory = $$(By.xpath("(//ul[@class='MuiList-root'])[1]/li"));
    private final List<SelenideElement> listOfSaleCollection = $$(By.xpath("(//ul[@class='MuiList-root'])[2]/li"));
    private final SelenideElement catLiving = $(By.xpath("(//div[@data-navigation-account-item-id = 'cat160024'])[2]"));
    private final SelenideElement subCatChair =$(By.xpath("(//p[@data-navigation-item-typography-id='cat10210007'])"));
    private final SelenideElement randomProduct =$(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']"));
    private final SelenideElement price = $(By.id("price-label"));
    private final SelenideElement memberPrice = $(By.xpath("(//p[@data-testid='price-label-member'])[1]"));
    private final SelenideElement finalPrice = $(By.xpath("(//p[@data-testid='price-label-final-sale'])"));
    private final SelenideElement regularPrice = $(By.xpath("(//p[@data-testid='price-label-regular'])"));
}
