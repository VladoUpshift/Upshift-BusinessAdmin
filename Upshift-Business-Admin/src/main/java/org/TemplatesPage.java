package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.Setup.*;

public class TemplatesPage {

    public static final By CREATE_TEMPLATE_BUTTON = By.xpath("//button[contains(text(),'Create Template')]");
    public static final By SELECT_LOCATION_DROPDOWN = By.cssSelector("div[class^='upshift-dropdown__control upshift-dropdown__control--is-focused']");
    public static final By LOCATION_DROPDOWN_OPTION = By.id("react-select-64-option-0");
    public static final By POST_FROM_TEMPLATE_BUTTON = By.xpath("//span//button[contains(text(),'Post From Template')]");
    public static final By NUMBER_OF_UPSHIFTERS_INPUT_FIELD = By.id("positions");
    public static final By HOURLY_PAY_RATE_INPUT_FIELD = By.id("pay_value");
    public static final By DATE_PICKER_BUTTON = By.xpath("//button[contains(text(),'Pick a Date')]");
    public static final By DATE_PICKER_31AUG = By.cssSelector("div[aria-label='Thu Aug 31 2023']");
    public static final By OK_BUTTON = By.xpath("//button[contains(text(),'OK')]");
    public static final By POST_LIVE_BUTTON = By.cssSelector("button[type='submit']");

    public static void openPostFromTemplateModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_TEMPLATE_BUTTON));
        driver.findElement(POST_FROM_TEMPLATE_BUTTON).click();
}

//TODO - LOCATOR MADNESS!!!!!
    public static void postShift(){
        wait.until(ExpectedConditions.visibilityOfElementLocated( SELECT_LOCATION_DROPDOWN)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATION_DROPDOWN_OPTION)).click();
        driver.findElement(NUMBER_OF_UPSHIFTERS_INPUT_FIELD).sendKeys("1");
        driver.findElement(HOURLY_PAY_RATE_INPUT_FIELD).sendKeys("30");
        driver.findElement(DATE_PICKER_BUTTON).click();
        driver.findElement(DATE_PICKER_31AUG).click();
        driver.findElement(OK_BUTTON).click();
        driver.findElement(POST_LIVE_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification__content")));
        String successNotificationTitle = driver.findElement(By.className(".notification__title")).getText();
        Assert.assertEquals(successNotificationTitle,"1");
    }
}
