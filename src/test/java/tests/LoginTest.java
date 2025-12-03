package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import core.BaseTest;
import core.DriverManager;
import core.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DiscoverGistPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "test logim",
            groups = "regression")
    public void testLogin() {

    }

    @DataProvider(name = "wrongLoginData")
    public Object[][] wrongLoginData() {
        return TestUtils.getTestData("src/test/resources/testdata/testdata.xlsx", "wrong-login-data");
    }

}

