package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergePGScreen {

    private final String topNavMenu = "//*[contains(@id, 'container-rhrheader-rhr-catalogNav')]//span[text() = '%s']";
    private final String topNavSubMenu = "(//li[contains(@id, 'rhrCtalogNavigationDetails_navigation')]/span[text() = '%s'])[1]";
    private final String topNavGallery = "(//span[text() = '%s'])[1]";
    private final SelenideElement threeGridView = $(By.xpath("(//*[text() = 'sort']/../..//*[local-name() = 'svg'])[2]"));
    private final SelenideElement twoGridView = $(By.xpath("(//*[text() = 'sort']/../..//*[local-name() = 'svg'])[2]"));
    private final SelenideElement threeGridViewIsActive = $(By.xpath("//*[text() = 'sort']/../..//*[local-name() = 'svg' and @data-active = 'true']"));
    private final SelenideElement twoGridViewIsActive = $(By.xpath("//*[text() = 'sort']/../..//*[local-name() = 'svg' and @data-active = 'true']"));
    private final SelenideElement threeGridViewIsInactive= $(By.xpath("//*[text() = 'sort']/../..//*[local-name() = 'svg' and @data-active = 'false']"));
    private final SelenideElement twoGridViewIsInactive = $(By.xpath("//*[text() = 'sort']/../..//*[local-name() = 'svg' @data-active = 'false']"));
    private final SelenideElement result = $(By.xpath("//*[text() = 'RESULTS']"));
    private final SelenideElement sort = $(By.xpath("//*[text() = 'sort']"));
    private final SelenideElement featuredFilter = $(By.xpath("(//*[text() = 'sort'])[2]/..//*[text() = 'Featured']"));
    private final SelenideElement enjoyFreeShipping = $(By.xpath("//*[text()='ENJOY FREE SHIPPING ON ALL TEXTILES']"));
    public SelenideElement getTopNavManuByName(String name) {
        String path = String.format(topNavMenu, name);
        return $(byXpath(path));
    }
    public SelenideElement getTopNavSubManuByName(String name) {
        String path = String.format(topNavSubMenu, name);
        return $(byXpath(path));
    }
    public SelenideElement getTopNavGalleryByName(String name) {
        String path = String.format(topNavGallery, name);
        return $(byXpath(path));
    }
}
