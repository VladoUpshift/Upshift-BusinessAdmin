package org.example;

import org.EditShiftPage;
import org.LoginPage;
import org.Setup;
import org.ShiftListPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


// The tests that are ran through the TestNG.xml file are the tests located in this class. If the
// Emailable report is not updated then configuration settings must be updated for the file: Configuration -> Listeners -> Use default reporters = true.
// Then the info will be sent and generated in the test-output package named as: emailable-report.html and index.html
public class generateReport {
    @BeforeClass
    public void setup() {
        Setup.startBrowser();
    }

    @Test
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

    @Test
    public void editShiftDescription() {
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterDescription("New Description");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifyShiftDescription("New Description");
    }

    @Test
    public void editShiftWhatToWear() {
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickEditShiftButton();
        ShiftListPage.clickFullEditButton();
        EditShiftPage.enterWhatToWear("New What To Wear");
        Assert.assertEquals(EditShiftPage.clickSaveEditShift(true), "Shift successfully updated!");
        ShiftListPage.openShiftDetails("58286");
        ShiftListPage.clickShiftDetailsButton();
        ShiftListPage.verifyWhatToWear("New What To Wear");
    }

    @AfterClass
    public void end() {
        Setup.endSession();
    }

}