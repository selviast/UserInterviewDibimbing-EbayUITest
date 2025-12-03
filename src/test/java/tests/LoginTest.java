package tests;

import core.BaseTest;
import core.DriverManager;
import core.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "test login", groups = "regression")
    public void testLogin() {

    }

    @DataProvider(name = "wrongLoginData")
    public Object[][] wrongLoginData() {
        return TestUtils.getTestData("src/test/resources/testdata/testdata.xlsx", "wrong-login-data");
    }

}

