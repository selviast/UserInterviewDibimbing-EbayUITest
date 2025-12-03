package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    @FindBy (xpath = "//input[@id='gh-ac']")
    private WebElement searchBar;

    @FindBy (xpath = "//span[@class='gh-search-button__label']")
    private WebElement searchButton;

    @FindBy (xpath = "//span[@class='gh-categories__title']")
    private WebElement allCategoriesDropdown;

    @FindBy (xpath = "//a[normalize-space()='Cell Phones, Smart Watches & Accessories']")
    private WebElement cellPhoneCat;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void navigateCellPhoneCat() {
        log.info("Navigate to url......");
        waitForClickable(allCategoriesDropdown);
        allCategoriesDropdown.click();
        waitForClickable(cellPhoneCat);
        cellPhoneCat.click();
    }

    public void accessProductViaSearchBar(String searchInput) {
        log.info("Navigate to url......");
        waitForClickable(searchBar);
        searchBar.click();
        searchBar.sendKeys(searchInput);
        searchButton.click();
    }

}
