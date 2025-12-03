package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    private static final Logger log = LogManager.getLogger(SearchResultPage.class);

    @FindBy (xpath = "//ul[contains(@class,'srp-results')]/li[contains(@class,'s-card')][1]")
    private WebElement firstItemListedAfterSearch;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstItemListedAfterSearchContains(String searchInput) {
        waitForVisibility(firstItemListedAfterSearch);

        String itemText = firstItemListedAfterSearch.getText();
        log.info("First carousel item text: " + itemText);

        return itemText.toLowerCase().contains(searchInput.toLowerCase());

    }
}
