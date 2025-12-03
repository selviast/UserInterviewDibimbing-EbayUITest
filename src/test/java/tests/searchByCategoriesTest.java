package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import core.BaseTest;
import core.DriverManager;
import core.TestUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CellPhonePage;
import pages.DashboardPage;
import pages.SearchResultPage;

public class searchByCategoriesTest extends BaseTest {
    @Test(description = "Search by category cellphone",
            groups = "regression")
    public void searchByCat() {
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        CellPhonePage cellPhonePage = new CellPhonePage(DriverManager.getDriver());

        dashboardPage.navigateCellPhoneCat();
        cellPhonePage.searchByFilter();
        cellPhonePage.dropdownAllFilterApplied();

        Assert.assertTrue(cellPhonePage.isConditionFilterApplied(), "Condition filter not applied!");
        Assert.assertTrue(cellPhonePage.isPriceFilterApplied(), "Price filter not applied!");
        Assert.assertTrue(cellPhonePage.isItemLocationFilterApplied(), "Item location filter not applied!");
    }

    @DataProvider(name = "searchInput")
    public Object[][] searchInput() {
        return TestUtils.getTestData("src/test/resources/testdata/testdata.xlsx", "search-input-data");
    }

    @Test(description = "Search by input string via SearchBar",
            groups = "regression", dataProvider = "searchInput")
    public void accessProductViaSearchBar(String searchInput) {

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());

        dashboardPage.accessProductViaSearchBar(searchInput);

        Assert.assertTrue(searchResultPage.isFirstItemListedAfterSearchContains(searchInput), "No item matches with input search..");

    }
}
