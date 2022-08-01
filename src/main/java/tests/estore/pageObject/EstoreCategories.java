package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class EstoreCategories {

    private final SelenideElement livingCategory = $(By.xpath("//div[@data-navigation-account-item-id='cat160024']"));

    private final SelenideElement sofaCollections = $(By.xpath("//*[text()='Sofa Collections']"));
}
