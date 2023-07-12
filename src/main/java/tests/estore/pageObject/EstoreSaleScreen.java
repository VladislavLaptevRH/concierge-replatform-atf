package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreSaleScreen {

    private SelenideElement saleButtonMenu = $(By.xpath("//*[text()='SALE']"));

    private SelenideElement sofasButton = $(By.xpath("//*[text()='Living']"));

    private SelenideElement saleCategoryButton = $(By.xpath("//div[@data-navigation-account-item-id='cat3890154']"));

    private SelenideElement saleLivingCategory = $(By.xpath("//*[text()='Living']"));

    private SelenideElement saleDiningCategory = $(By.xpath("//*[text()='Dining']"));

    private SelenideElement bedLivingCategory = $(By.xpath("//*[text()='Bed']"));

    private SelenideElement textilesSaleCategory = $(By.xpath("//*[text()='Textiles']"));

    private SelenideElement mainSaleList = $(By.xpath("(//ul[@class='MuiList-root'])[1]//li[1]/span"));

    private SelenideElement subSaleList = $(By.xpath("(//ul[@class='MuiList-root'])[2]//li[3]/span"));


}
