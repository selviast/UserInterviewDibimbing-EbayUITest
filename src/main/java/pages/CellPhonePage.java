package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CellPhonePage extends BasePage {
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    @FindBy(xpath = "//a[contains(normalize-space(), 'Cell Phone & Smartphone Parts')]")
    private WebElement smartPhonePartsMenu;

    @FindBy(xpath = "//button[@class='filter-button filter-button--unselected brwr__all-filters']")
    private WebElement allFilter;

    @FindBy(xpath = "//*[@aria-label='Condition']")
    private WebElement filterConditionDropdown;

    @FindBy(xpath = "//label[@for='group-checkbox-New']")
    private WebElement checkboxConditionNew;

    @FindBy(xpath = "//*[@aria-label='Price']")
    private WebElement filterPriceDropdown;

    @FindBy(xpath = "//label[contains(@for, 'under-idr')]")
    private WebElement radioBtnPriceUnder;

//    @FindBy(xpath = "//*[contains(@aria-label, 'Item Location')]")
//    private WebElement filterItemLocationDropdown;

    @FindBy(xpath = "//h3[@class='seo-accordion__title' and @aria-label='Item location']")
    private WebElement filterItemLocationDropdown;

    @FindBy(xpath = "//label[contains(@for, 'worldwide')]")
    private WebElement radioBtnItemLocationWorldwide;

    @FindBy(xpath = "//button[@class='btn-submit btn btn--primary']")
    private WebElement applyButton;

    @FindBy(xpath = "//span[contains(text(),'Condition: New')]")
    private WebElement conditionFilterApplied;

    @FindBy(xpath = "//span[contains(text(),'Price: Under')]")
    private WebElement priceFilterApplied;

    @FindBy(xpath = "//span[contains(text(),'Item location: Worldwide')]")
    private WebElement itemLocFilterApplied;

    @FindBy(xpath = "//button[contains(@class,'filter-button--selected') and contains(., 'filters applied')]")
    private WebElement allFilterApplied;

    public CellPhonePage(WebDriver driver) {
        super(driver);
    }

    public void scrollToElement(WebElement element) {
        try {
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            // fallback jika elemen masih jauh di bawah
            new Actions(driver).scrollByAmount(0, 400).perform();
        }
    }

    public void searchByFilter() {
        log.info("Click menu smartphone");
        waitForClickable(smartPhonePartsMenu);
        smartPhonePartsMenu.click();

        waitForClickable(allFilter);
        allFilter.click();

        waitForVisibility(filterConditionDropdown);
        filterConditionDropdown.click();

        waitForVisibility(checkboxConditionNew);
        checkboxConditionNew.click();

        filterPriceDropdown.click();
        waitForVisibility(radioBtnPriceUnder);
        radioBtnPriceUnder.click();

        waitForClickable(filterItemLocationDropdown);
        scrollToElement(filterItemLocationDropdown);
        filterItemLocationDropdown.click();

        waitForClickable(radioBtnItemLocationWorldwide);
        scrollToElement(radioBtnItemLocationWorldwide);
        radioBtnItemLocationWorldwide.click();

        applyButton.click();
    }

    public void dropdownAllFilterApplied() {
        waitForClickable(allFilterApplied);
        allFilterApplied.click();
    }

    public boolean isConditionFilterApplied() {
        waitForVisibility(conditionFilterApplied);
        log.info(conditionFilterApplied.getText() + " sudah tertampil");
        return conditionFilterApplied.isDisplayed();
    }

    public boolean isPriceFilterApplied() {
        waitForVisibility(priceFilterApplied);
        log.info(priceFilterApplied.getText() + " sudah tertampil");
        return priceFilterApplied.isDisplayed();
    }

    public boolean isItemLocationFilterApplied() {
        waitForVisibility(itemLocFilterApplied);
        log.info(itemLocFilterApplied.getText() + " sudah tertampil");
        return itemLocFilterApplied.isDisplayed();
    }


}
