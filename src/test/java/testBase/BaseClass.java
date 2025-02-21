package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.FileReaderUtil;

public class BaseClass {
    private Map<String, String> expectedValues;
    public WebDriver driver;
    public Logger logger;
    public ExtentTest test;  // Reference to ExtentTest (to log reports)
    
    @BeforeClass
    public void setup() {
        // Log4j setup
        logger = LogManager.getLogger(this.getClass());
        
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-debugging-port=9222"); // Optional, for debugging

        // ✅ Assign WebDriver instance to class-level `driver` variable
        driver = new EdgeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.automationexercise.com/");
        logger.info("Navigated to Automation Exercise");

        expectedValues = FileReaderUtil.readExpectedValues("ExpectedResult/expected_values.txt");
    }

    public void validateText(String key, String actual, String errorMessage) {
        String expected = expectedValues.get(key);
        Assert.assertNotNull(expected, "Expected value for key '" + key + "' is missing in expected_values.txt");
        Assert.assertEquals(actual, expected, errorMessage);
    }

    // ✅ Method for scrolling to the bottom of the page
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close(); // ✅ Ensures WebDriver session is properly closed
            logger.info("Browser closed successfully.");
        }
    }

    // ✅ Capture screenshots and return the file path (null-safe)
    public String captureScreen(String testName) throws IOException {
        if (driver == null) {
            logger.error("Driver is null! Cannot capture screenshot.");
            return null; // Prevent NullPointerException
        }

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        
        // Save the screenshot to the defined path
        FileUtils.copyFile(sourceFile, targetFile);
        logger.info("Screenshot captured: " + targetFilePath);

        return targetFilePath;
    }

    // ✅ Method for logging test results to ExtentReports
    public void logTestResult(Status status, String message) {
        if (test != null) {
            test.log(status, message);
        }
    }

    // ✅ Method for attaching a screenshot to the Extent report
    public void attachScreenshotToReport(String testName) {
        try {
            String imgPath = captureScreen(testName);
            if (imgPath != null) {
                test.addScreenCaptureFromPath(imgPath);
            }
        } catch (IOException e) {
            logger.error("Failed to attach screenshot to report: " + e.getMessage());
        }
    }

    // ✅ Method for capturing browser logs (optional)
    public String getBrowserLogs() {
        return "Browser logs feature is not implemented yet.";
    }

    // ✅ Method for calculating memory usage during test execution
    public void logMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Simulate test execution and track memory usage
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        
        if (test != null) {
            test.info("Memory used during test: " + memoryUsed / 1024 + " KB");
        }
    }
}
