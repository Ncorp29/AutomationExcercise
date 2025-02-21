package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.SubscriptionPage;
import testBase.BaseClass;
import utilities.FileReaderUtil;

public class TC_007_Subscription extends BaseClass {
    private Map<String, String> expectedValues;
    private SubscriptionPage sp;

    @BeforeClass
    public void setupTest() {
        expectedValues = FileReaderUtil.readExpectedValues("ExpectedResult/expected_values.txt"); // Load expected values
        sp = new SubscriptionPage(driver);
    }

    @Test
    public void verifySubscription() {
       // try {
            // Assertion for Subscription Section Header
            validateText("SubscriptionText",sp.getSubscriptionText(),"Text Mismatched");

            // Enter email and subscribe
            sp.enterEmail("test@example.com");
            sp.clickSubscribe();

            // Explicit Wait for success message to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(sp.getSuccessMessageElement()));

            // Assertion for Subscription Success Message
            validateText("SubscriptionSuccessMessage",sp.getSuccessMessageText(),"Text Mismatched");
//            try {
//                String screenshotPath = captureScreen("verifySubscription");
//                System.out.println("Screenshot captured: " + screenshotPath);
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//            throw e; // Re-throw exception after capturing the screenshot
//        }
    }
}
