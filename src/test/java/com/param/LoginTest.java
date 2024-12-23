package com.param;

import org.testng.annotations.Test;

import static com.param.Constant.noPasswordWarning;
import static com.param.Constant.incorrectPasswordWarning;
import static com.param.UserPool.*;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginWithValidInfo() {
        User user = getValidUser();
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword(), true);

        String currentUrl = homePage.getCurrentURL();
        assertEquals(currentUrl, "https://www.trendyol.com/");

        String accountText = homePage.getAccountButtonText();
        assertEquals(accountText, "Hesabım");
    }

    @Test
    public void shouldNotLoginWithInvalidPassword() {
        User user = getFalsePasswordUser();
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword(), false);

        String warningText = loginPage.getWarningText();
        assertEquals(warningText, incorrectPasswordWarning);
    }

    @Test
    public void shouldNotLoginWithEmptyPassword() {
        User user = getEmptyPasswordUser();
        HomePage homePage = new HomePage();
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword(), false);

        String warningText = loginPage.getWarningText();
        assertEquals(warningText, noPasswordWarning);
    }
}