package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
@Getter
public class ConciergeSearchScreen {

    public final String text = "//*[text() = '%s ']";
    private final SelenideElement searchItemInput = $(By.xpath("//*[@id = 'site-search-input']"));
    private final SelenideElement sizeFilter = $(By.xpath("//*[text() = 'Size']"));
    private final SelenideElement materialFilter = $(By.xpath("//*[text() = 'Material']"));
    private final SelenideElement brandFilter = $(By.xpath("//*[text() = 'Brand']"));
    private final SelenideElement brandFilterInteriorsCheckBox = $(By.xpath("//*[@id = 'refinementOptionData_checkbox-Interiors']"));
    private final SelenideElement dashboardSearchButton = $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]"));
    private final SelenideElement leftSidebarSearchButton = $(By.xpath("//*[@id = 'search-icon-svg']/../.."));
    private final SelenideElement seeAllResultSearchButton = $(By.xpath(" //*[text() = 'SEE ALL RESULTS']"));
    private final SelenideElement seatingCollection = $(By.xpath("//*[text() = 'Seating Collections']"));


    private final SelenideElement sofaFirstItem = $(By.xpath("(//*[contains(text(), 'couch')])[1]"));

    public SelenideElement getTextByValue(String arg) {
        String path = String.format(text, arg);
        return $(byXpath(path));
    }
}
