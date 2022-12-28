package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreSaleScreen {

    private SelenideElement saleButtonMenu = $(By.xpath("//*[text()='SALE']"));

    private SelenideElement sofasButton = $(By.xpath("//*[text()='Sofas']"));

    private SelenideElement saleCategoryButton = $(By.xpath("(//div[@id='lower-nav']//div[1])[1]"));

    private SelenideElement saleLivingCategory = $(By.xpath("//*[text()='Living']"));

    private SelenideElement saleDiningCategory = $(By.xpath("//*[text()='Dining']"));

    private SelenideElement bedLivingCategory = $(By.xpath("//*[text()='Bed']"));

    private SelenideElement textilesSaleCategory = $(By.xpath("//*[text()='Textiles']"));
}
