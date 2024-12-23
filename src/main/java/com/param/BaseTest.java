package com.param;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void startUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("--disable-notifications");

        driver.set(new ChromeDriver(chromeOptions));

        getDriver().get("https://www.trendyol.com");
        getDriver().findElement(By.className("modal-close"))
                .click();
        getDriver().findElement(By.id("onetrust-accept-btn-handler"))
                .click();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
