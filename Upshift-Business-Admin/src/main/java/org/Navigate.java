package org;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.Setup.driver;
import static org.Setup.wait;

public class Navigate {

    public static final By TEMPLATES_BUTTON_SIDENAV = By.cssSelector("a[href='/templates']");

    public static void navigateToTemplates(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEMPLATES_BUTTON_SIDENAV)).click();
    }

    public static void scrollAndClick(By locator) {
        WebElement scrollAndClick = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", scrollAndClick);
        scrollAndClick.click();
    }

    public static void sendKeysTo(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }
}
