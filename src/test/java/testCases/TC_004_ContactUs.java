package testCases;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObject.ContactUs;
import pageObject.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_ContactUs extends BaseClass {

    @Test(dataProvider = "ContactData", dataProviderClass = DataProviders.class)
    public void verify_contactus(String name, String email, String message) throws InterruptedException, IOException {
        HomePage hp = new HomePage(driver);
        hp.clickcontactus();

        ContactUs cp = new ContactUs(driver);

        validateText("contact", cp.isContactUsMessageDisplayed(), "Text Mismatched");
        cp.entername(name);
        cp.enteremail(email);
        cp.entersubject("Category");
        cp.enetermessage(message);

        // Click on the file upload button to open the dialog
        cp.uploadfile();

        // Execute AutoIt script for file upload
        String autoItScriptPath = "D:\\AutoIt\\fu.exe";  // Ensure correct path
        Process process = new ProcessBuilder(autoItScriptPath).start();
        process.waitFor(); 
        logger.info("AutoIt script executed successfully");

        // Add some wait time to ensure file is uploaded before submitting
        Thread.sleep(10000);

        cp.clicksubmit();
        logger.info("Submit button clicked.");

        // Handle the alert after clicking Submit
        handleUnexpectedAlert();

        validateText("con_success", cp.isSuccessMessageDisplayed(), "Success text mismatched");
    }
    
 // Method to verify file upload
    public boolean verifyFileUpload(String expectedFileName) {
        try {
            WebElement uploadedFileName = driver.findElement(By.xpath("//span[@id='uploadedFileName']"));
            String fileNameText = uploadedFileName.getText();
            return fileNameText.contains(expectedFileName);
        } catch (Exception e) {
            logger.error("Error verifying file upload: " + e.getMessage());
            return false;
        }
    }

    // Method to handle the alert
    public void handleUnexpectedAlert() {
        try {
            // Switch to alert
            Alert alert = driver.switchTo().alert();
            logger.info("Unexpected alert found: " + alert.getText());
            alert.accept(); // Click OK
            logger.info("Alert accepted successfully.");
        } catch (NoAlertPresentException e) {
            logger.info("No alert present after clicking submit.");
        }
    }
}
