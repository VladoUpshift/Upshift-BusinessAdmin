package org;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.Setup.*;

public class LoginPage {
    public static final By EMAIL_INPUT_FIELD = By.name("email");
    public static final By PASSWORD_INPUT_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.cssSelector("button[ type ='submit']");
    public static final By USER_TYPE_BUTTON = By.cssSelector("a[href='https://business.staging.upshift.work']");
    public static final By UPSHIFT_LOGO_IMAGE = By.cssSelector("img[alt='Upshift logo']");

    public static void selectUserType() {
        driver.findElement(USER_TYPE_BUTTON).click();

        String businessUrl = driver.getCurrentUrl();
        softAssert.assertEquals(businessUrl, "https://business.staging.upshift.work/login");
        softAssert.assertAll();
    }

    public static void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UPSHIFT_LOGO_IMAGE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT_FIELD)).sendKeys("vlado-tuesday@upshiftwork.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT_FIELD)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT_FIELD)).sendKeys("Upshift123");

        driver.findElement(LOGIN_BUTTON).click();
        String pickAShiftHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))).getText();
        softAssert.assertEquals(pickAShiftHeader, "Pick a Shift");
        softAssert.assertAll();
    }
}
