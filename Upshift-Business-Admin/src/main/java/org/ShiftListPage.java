package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.Navigate.scrollAndClick;
import static org.Setup.*;

public class ShiftListPage {

    public static final By SHIFT_ID_58286 = By.xpath("//span[normalize-space()='#58286']");
    public static final By FULL_EDIT_BUTTON = By.xpath("//button[contains(text(),'Full Edit')]");
    public static final By EDIT_SHIFT_BUTTON = By.cssSelector("svg[data-icon='pen']");
    public static final By NO_PENDING_APPLICANTS_TEXT = By.xpath("//h1[normalize-space()='No Pending Applicants.']");
    public static final By EDIT_SHIFT_MODAL_HEADER = By.xpath("//span[contains(text(),'Quick Edit Shift ID: 58286')]");
    public static final By SHIFT_DETAILS_LOCATION = By.xpath("//h5[contains(text(),'Location 2')]");
    public static final By SHIFT_DETAILS_POSITION = By.xpath("//h3[contains(text(),'AD Carry')]");
    public static final By SHIFT_DETAILS_PERKS = By.xpath("//span[contains(text(),'New Perks')]");
    public static final By SHIFT_DETAILS_DESCRIPTION = By.xpath("//p[contains(text(),'New Description')]");
    public static final By SHIFT_LIST_ALL_BUTTONS = By.cssSelector("span button");
    public static final By SHIFT_DETAILS_WHAT_TO_WEAR = By.xpath("//p[contains(text(),'New What To Wear')]");
    public static final By SHIFT_DETAILS_ARRIVAL_INSTRUCTIONS = By.xpath("//p[contains(text(),'We need to have 80 characters minimum for arrival instructions,We need to have 80 characters minimum for arrival instructions')]");
    public static final By SHIFT_DETAILS_SPECIAL_INSTRUCTIONS = By.xpath("//p[contains(text(),'Everyone is special')]");
    public static final By SHIFT_DETAILS_TRAVEL_TIPS = By.xpath("//p[contains(text(),'Tips for travel')]");
    public static final By NUMBER_OF_UPSHIFTERS_EDIT_SHIFT_MODAL = By.cssSelector("input[placeholder='Number of upshifters']");

    public static void openShiftDetails(String shiftId) {
        scrollAndClick(By.xpath("//span[normalize-space()='#" + shiftId + "']"));

        String noApplicants = wait.until(ExpectedConditions.visibilityOfElementLocated(NO_PENDING_APPLICANTS_TEXT)).getText();
        softAssert.assertEquals(noApplicants, "No Pending Applicants.");
        softAssert.assertAll();
    }

    public static void clickEditShiftButton() {
        scrollAndClick(EDIT_SHIFT_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EDIT_SHIFT_MODAL_HEADER));
    }

    public static void clickFullEditButton() {
        scrollAndClick(FULL_EDIT_BUTTON);

        String editShiftUrl = driver.getCurrentUrl();
        softAssert.assertEquals(editShiftUrl, "https://business.staging.upshift.work/shift/edit/58286");
        softAssert.assertAll();
    }

    public static void verifyShiftLocation(String expectedLocationName) {
        String currentLocationName = driver.findElement(SHIFT_DETAILS_LOCATION).getText();
        Assert.assertEquals(currentLocationName, expectedLocationName);
    }

    public static void verifyShiftPosition(String expectedPositionName) {
        String currentPositionName = driver.findElement(SHIFT_DETAILS_POSITION).getText();
        Assert.assertEquals(currentPositionName, expectedPositionName);
    }

    public static void verifyShiftPerks(String expectedPerks) {
        String currentPerks = driver.findElement(SHIFT_DETAILS_PERKS).getText();
        Assert.assertEquals(currentPerks, expectedPerks);
    }

    public static void verifyShiftDescription(String expectedDescription) {
        String currentDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(SHIFT_DETAILS_DESCRIPTION)).getText();
        Assert.assertEquals(currentDescription, expectedDescription);
    }

    public static void clickShiftDetailsButton() {
        List<WebElement> detailsButton = driver.findElements(SHIFT_LIST_ALL_BUTTONS);
        detailsButton.get(7).click();
    }

    public static void verifyWhatToWear(String expectedWhatToWear) {
        String currentWhatToWear = wait.until(ExpectedConditions.visibilityOfElementLocated(SHIFT_DETAILS_WHAT_TO_WEAR)).getText();
        Assert.assertEquals(currentWhatToWear, expectedWhatToWear);
    }

    public static void verifyArrivalInstructions(String expectedArrivalInstructions) {
        String currentArrivalInstructions = wait.until(ExpectedConditions.visibilityOfElementLocated(SHIFT_DETAILS_ARRIVAL_INSTRUCTIONS)).getText();
        Assert.assertEquals(currentArrivalInstructions, expectedArrivalInstructions);
    }

    public static void verifySpecialInstructions(String expectedSpecialInstructions) {
        String currentSpecialInstructions = wait.until(ExpectedConditions.visibilityOfElementLocated(SHIFT_DETAILS_SPECIAL_INSTRUCTIONS)).getText();
        Assert.assertEquals(currentSpecialInstructions, expectedSpecialInstructions);
    }

    public static void verifyTravelTips(String expectedTravelTips) {
        String currentTravelTips = wait.until(ExpectedConditions.visibilityOfElementLocated(SHIFT_DETAILS_TRAVEL_TIPS)).getText();
        Assert.assertEquals(currentTravelTips, expectedTravelTips);
    }

    public static void verifyNumberOfPositions(String expectedNumberOfPositions) {
        String currentNumberOfPositions = wait.until(ExpectedConditions.visibilityOfElementLocated(NUMBER_OF_UPSHIFTERS_EDIT_SHIFT_MODAL)).getAttribute("value");
        Assert.assertEquals(currentNumberOfPositions, expectedNumberOfPositions);
    }
}
