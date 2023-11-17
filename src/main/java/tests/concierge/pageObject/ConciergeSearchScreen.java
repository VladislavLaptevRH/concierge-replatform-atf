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
    private final SelenideElement brandFilter = $(By.xpath("//*[text() = 'brand ss']"));
    private final SelenideElement brandFilterInteriorsCheckBox = $(By.xpath("//*[@id = 'refinementOptionData_checkbox-Interiors']"));
    private final SelenideElement dashboardSearchButton = $(By.xpath("//button[contains(@class,'MuiButton-containedSizeLarge')]"));
    private final SelenideElement leftSidebarSearchButton = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[4]"));
    private final SelenideElement seeAllResultSearchButton = $(By.xpath(" //*[text() = 'SEE ALL RESULTS']"));


    public SelenideElement getTextByValue(String arg) {
        String path = String.format(text, arg);
        return $(byXpath(path));
    }
}
