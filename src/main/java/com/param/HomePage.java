package com.param;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    By accountUser = By.className("account-user");
    By searchBar = By.cssSelector("[data-testid=suggestion]");
    By searchIcon = By.cssSelector("[data-testid=search-icon]");

    public LoginPage clickLoginButton() {
        click(accountUser);
        return new LoginPage();
    }

    public String getAccountButtonText() {
        WebElement loginButton = findElement(accountUser);
        return loginButton.getText();
    }

    public AfterSearchPage search(String keyword) {
        findElement(searchBar).sendKeys(keyword);
        click(searchIcon);
        return new AfterSearchPage();
    }

    public String getSearchBarPlaceholderText() {
        return findElement(searchBar).getAttribute("placeholder");
    }
}
