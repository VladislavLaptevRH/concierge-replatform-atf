package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

@Getter
public class EstorePDPScreen {

    private final SelenideElement addToCartInactiveButton = $(By.xpath("(//*[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-10'])[1]//button[contains(@class,'disabled') and @id='component-related-product-card_add-to-cart-btn']"));

    private final SelenideElement sortButton = $(By.xpath("(//*[contains(text(),'sort')])[2]"));

    private final SelenideElement sortByButton = $(By.xpath("//*[text()='Featured']"));

    private final SelenideElement priceLowToHigh = $(By.xpath("//*[text()='Price Low to High']"));

    private final SelenideElement priceHighToLow = $(By.xpath("//*[text()='Price High to Low']"));

    private final SelenideElement firstProduct = $(By.id("component-rh-image_wrapper"));

    private final SelenideElement priceBox = $(By.xpath("//span[@class='priceBox']"));

    private final SelenideElement sizeOption = $(By.xpath("(//select[contains(@id,'Size')])[1]"));

    private final SelenideElement finishOption = $(By.xpath("(//select[contains(@id,'Finish')])[1]"));


    public void selectSizeOption() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        sizeOption.should(Condition.and("", Condition.interactable, Condition.visible,
                Condition.appear), Duration.ofSeconds(40));
        Select selectSize = new Select(sizeOption);
        selectSize.selectByIndex(1);
    }

    public void selectFinishOption() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        finishOption.should(Condition.and("", Condition.interactable, Condition.visible,
                Condition.appear), Duration.ofSeconds(40));
        Select selectFinishOption = new Select(finishOption);
        selectFinishOption.selectByIndex(1);
    }

}
