package org.example;

import org.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class AppTest {
    @BeforeMethod
    public void setup() {
        Setup.startBrowser();
    }

    @Test(enabled = false)
    public void loginAsBusiness() throws InterruptedException {
        LoginPage.selectUserType();
        LoginPage.login();
        Navigate.navigateToTemplates();
    }

    //TODO
    @Test(enabled = false)
    public void postFromTemplate() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58626");
}

    @Test(enabled = false)
    public void editShiftLocation() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.selectLocation();
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.verifyShiftLocation("Location 2");
    }

    @Test(enabled = false)
    public void editShiftPosition() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.selectPosition("AD Carry");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.verifyShiftPosition("AD Carry");
    }

    @Test(enabled = false)
    public void editShiftPerks() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterPerks("New Perks");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.verifyShiftPerks("New Perks");
    }

    @Test(enabled = false)
    public void editShiftDescription() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterDescription("New Description");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifyShiftDescription("New Description");
    }

    @Test(enabled = false)
    public void editShiftWhatToWear() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterWhatToWear("New What To Wear");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifyWhatToWear("New What To Wear");
    }

    @Test(enabled = false)
    public void editShiftArrivalInstructions() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.clickEditArrivalInstructionsButton();
        EditShiftPage.enterArrivalInstructions("We need to have 80 characters minimum for arrival instructions,We need to have 80 characters minimum for arrival instructions");
        EditShiftPage.saveArrivalInstructionsModal();
        Navigate.refreshPage();
        EditShiftPage.verifyArrivalInstructionsFullEdit("We need to have 80 characters minimum for arrival instructions,We need to have 80 characters minimum for arrival instructions");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(false), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifyArrivalInstructions("We need to have 80 characters minimum for arrival instructions,We need to have 80 characters minimum for arrival instructions");
    }

    @Test(enabled = false)
    public void editShiftSpecialInstructions() throws InterruptedException {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterSpecialInstructions("Everyone is special");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifySpecialInstructions("Everyone is special");
    }

    @Test(enabled = false)
    public void editShiftTravelTips() {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterTravelTips("Tips for travel");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifyTravelTips("Tips for travel");
    }

    @Test(enabled = false)
    public void editShiftNumberOfUpshifters() throws InterruptedException {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterNumberOfUpshifters("10");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(false), "Shift successfully updated!");
        Navigate.refreshPage();
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.verifyNumberOfPositions("10");
    }

    @Test(enabled = false)
    public void editShiftOver21() throws InterruptedException {
        LoginPage.selectUserType();
        LoginPage.login();
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.clickCheckBox(1);
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(false), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.verifyCheckBox(1);

        Setup.waitFor(5000);
    }

    @Test(enabled = false)
    public static void sendMailNow() {
    }

    @AfterClass
    public void end() {Setup.endSession();}
}