package com.swapnil.qa.tests;

import com.swapnil.qa.base.BaseTest;
import com.swapnil.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify a valid user can log in and reach the inventory page")
    public void validUserCanLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getPageTitle(), "Products",
                "The inventory page should be displayed after a successful login.");
    }

    @Test(description = "Verify an invalid password displays a useful validation message")
    public void invalidPasswordShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().login("standard_user", "incorrect_password");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "An error message should be displayed for invalid credentials.");
    }
}
