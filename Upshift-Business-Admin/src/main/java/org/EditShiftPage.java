package org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.Navigate.scrollAndClick;
import static org.Navigate.sendKeysTo;
import static org.Setup.*;

public class EditShiftPage {

    public static final By SAVE_FULL_EDIT_BUTTON = By.xpath("//button[normalize-space()='Save']");
    public static final By CONFIRM_FULL_EDIT_MODAL_BUTTON = By.xpath("//button[normalize-space()='Confirm']");
    public static final By NOTIFICATION_TITLE = By.cssSelector(".notification__title");
    public static final By PERKS_INPUT_FIELD = By.cssSelector("input[placeholder='Perks']");
    public static final By DESCRIPTION_INPUT_FIELD = By.cssSelector("div[data-placeholder='Description *']");
    public static final By WHAT_TO_WEAR_INPUT_FIELD = By.cssSelector("div[data-placeholder='What to Wear *']");
    public static final By EDIT_ARRIVAL_INSTRUCTIONS_INPUT_FIELD = By.cssSelector("div[data-placeholder='Arrival Instructions *'][contenteditable='true']");
    public static final By EDIT_ARRIVAL_INSTRUCTIONS_BUTTON = By.cssSelector("svg[data-icon='pen-to-square']");
    public static final By CONFIRM_EDIT_ARRIVAL_INSTRUCTIONS_BUTTON = By.xpath("//button[contains(text(),'Yes, edit')]");
    public static final By SAVE_ARRIVAL_INSTRUCTIONS_BUTTON = By.xpath("//button[contains(text(),'Save')]");
    public static final By SPECIAL_INSTRUCTIONS_INPUT_FIELD = By.cssSelector("div[data-placeholder='Special Instructions']");
    public static final By TRAVEL_TIPS_INPUT_FIELD = By.cssSelector("div[data-placeholder='Travel Tips']");
    public static final By NUMBER_OF_UPSHIFTERS_INPUT_FIELD = By.cssSelector("input[name='positions']");
    public static final By ARRIVAL_INSTRUCTIONS_DISABLED_EDIT = By.cssSelector("div[class$='rich_text_editor__isDisabled']");

    public static void selectLocation() {
        //Locator works only if the location currently is " AEWAWA " terrible locator
        scrollAndClick(By.xpath("//div[contains(text(),'AEWAWA')]"));

        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("div[class$='option']"));
        dropdownOptions.get(1).click();
    }

    public static String clickSaveEditShift(boolean confirm) {
        scrollAndClick(SAVE_FULL_EDIT_BUTTON);
        if (confirm) {
            scrollAndClick(CONFIRM_FULL_EDIT_MODAL_BUTTON);
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_TITLE)).getText();
    }

    public static void selectPosition(String positionName) {
        //Locator works only if the postion currently is " Aberdzija " terrible locator
        scrollAndClick(By.xpath("//div[contains(text(),'Aberdzija')]"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + positionName + "')]"))).click();
    }

    public static void enterPerks(String perksDetails) {
        sendKeysTo(PERKS_INPUT_FIELD, perksDetails);
    }

    public static void enterDescription(String descriptionDetails) {
        sendKeysTo(DESCRIPTION_INPUT_FIELD, Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        sendKeysTo(DESCRIPTION_INPUT_FIELD, descriptionDetails);
    }

    public static void enterWhatToWear(String whatToWearDetails) {
        sendKeysTo(WHAT_TO_WEAR_INPUT_FIELD, Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        sendKeysTo(WHAT_TO_WEAR_INPUT_FIELD, whatToWearDetails);
    }

    public static void enterArrivalInstructions(String arrivalInstructionsDetails) {
        sendKeysTo(EDIT_ARRIVAL_INSTRUCTIONS_INPUT_FIELD, Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        sendKeysTo(EDIT_ARRIVAL_INSTRUCTIONS_INPUT_FIELD, arrivalInstructionsDetails);
    }

    public static void clickEditArrivalInstructionsButton() {
        scrollAndClick(EDIT_ARRIVAL_INSTRUCTIONS_BUTTON);
        scrollAndClick(CONFIRM_EDIT_ARRIVAL_INSTRUCTIONS_BUTTON);
    }

    public static void saveArrivalInstructionsModal() {
        List<WebElement> saveButton = driver.findElements(SAVE_ARRIVAL_INSTRUCTIONS_BUTTON);
        saveButton.get(0).click();
    }

    public static void verifyArrivalInstructionsFullEdit(String expectedArrivalInstructions) {
        String currentArrivalInstructions = wait.until(ExpectedConditions.visibilityOfElementLocated(ARRIVAL_INSTRUCTIONS_DISABLED_EDIT)).getText();
        Assert.assertEquals(currentArrivalInstructions, expectedArrivalInstructions);
    }

    public static void enterSpecialInstructions(String specialInstructionsDetails) {
        sendKeysTo(SPECIAL_INSTRUCTIONS_INPUT_FIELD, Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        sendKeysTo(SPECIAL_INSTRUCTIONS_INPUT_FIELD, specialInstructionsDetails);
    }

    public static void enterTravelTips(String travelTipsDetails) {
        sendKeysTo(TRAVEL_TIPS_INPUT_FIELD, Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        sendKeysTo(TRAVEL_TIPS_INPUT_FIELD, travelTipsDetails);
    }

    public static void enterNumberOfUpshifters(String numberOfUpshifters){
        sendKeysTo(NUMBER_OF_UPSHIFTERS_INPUT_FIELD,Keys.CONTROL + Keys.chord("A") + Keys.DELETE);
        sendKeysTo(NUMBER_OF_UPSHIFTERS_INPUT_FIELD,numberOfUpshifters);
    }

    public static void clickCheckBox(int position){
        List<WebElement> editShiftCheckboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.react-switch-handle")));
        editShiftCheckboxes.get(position).click();
    }

    public static void verifyCheckBox(int position){
        List<WebElement> editShiftCheckboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.react-switch-handle")));
        Assert.assertEquals(editShiftCheckboxes.get(position).getAttribute("aria-checked"),"true");
    }

}
