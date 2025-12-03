package tests;

import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CellPhonePage;
import pages.DashboardPage;

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
}
