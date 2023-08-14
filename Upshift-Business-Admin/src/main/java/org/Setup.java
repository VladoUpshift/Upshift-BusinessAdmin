package org;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Setup {

    static ChromeDriver driver = new ChromeDriver();
    static SoftAssert softAssert = new SoftAssert();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void startBrowser() {
        driver.manage().window().maximize();
        driver.get("https://new.staging.upshift.work/login");
    }

    public static void endSession() {
        driver.quit();
    }

    public static void waitFor(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    //TODO
    public void takeScreenshot(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss-SSS");
        LocalDateTime dateTime = LocalDateTime.now();
        takeScreenshot(dateTime.format(formatter));
    }
}


