package com.param;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static com.param.BaseTest.getDriver;

public class BasePage {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }
}
