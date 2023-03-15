package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstorePDPScreen {
    private final SelenideElement sortButton = $(By.xpath("//*[text()='sort']"));

    private final SelenideElement sortByButton = $(By.xpath("//*[text()='sort by:']"));

    private final SelenideElement priceLowToHigh = $(By.xpath("//*[text()='Price Low to High']"));

    private final SelenideElement priceHighToLow = $(By.xpath("//*[text()='Price High to Low']"));

    private final SelenideElement firstProduct = $(By.id("component-rh-image_wrapper"));

    private final SelenideElement priceBox = $(By.xpath("//span[@class='priceBox']"));

}
