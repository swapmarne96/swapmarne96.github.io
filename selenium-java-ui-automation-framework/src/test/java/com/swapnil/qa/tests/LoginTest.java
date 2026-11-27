package com.swapnil.qa.tests;

import com.swapnil.qa.base.BaseTest;
import com.swapnil.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validUserCanLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().login("standard_user", "secret_sauce");

        Assert.assertEquals(loginPage.getPageTitle(), "Products",
                "The inventory page should be displayed after a successful login.");
    }
}
