package com.param;

import org.openqa.selenium.By;
import java.util.Set;
import static com.param.BaseTest.getDriver;

public class AfterSearchPage extends BasePage {

    By productCard = By.className("p-card-wrppr");

    public boolean hasProducts() {
        return findElement(productCard).isDisplayed();
    }

}
