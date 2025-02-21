package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); // specify location of the report

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Test Automation");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }

        // Add a custom test run summary page at the start of the report
        extent.addTestRunnerOutput("Test Summary: \nTotal Tests: [Total Count], Passed: [Pass Count], Failed: [Fail Count], Skipped: [Skip Count]");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); // to display groups in report
        test.log(Status.PASS, result.getName() + " got successfully executed");

        try {
            // Capture screenshot for passed test
            BaseClass base = (BaseClass) result.getInstance();
            String imgPath = base.captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath, "Passed Test Screenshot");
            test.info("Screenshot captured for passed test.");
        } catch (IOException e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Error while capturing screenshot: " + e.getMessage());
        }

        // Log test duration
        long duration = result.getEndMillis() - result.getStartMillis();
        test.info("Test Duration: " + duration / 1000 + " seconds");

        // Log start and end time
        test.info("Test started at: " + new SimpleDateFormat("HH:mm:ss").format(new Date(result.getStartMillis())));
        test.info("Test ended at: " + new SimpleDateFormat("HH:mm:ss").format(new Date(result.getEndMillis())));
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL, result.getName() + " got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            // Capture screenshot for failed test
            BaseClass base = (BaseClass) result.getInstance();
            String imgPath = base.captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath, "Failed Test Screenshot");
            test.info("Screenshot captured for failed test.");
        } catch (IOException e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Error while capturing screenshot: " + e.getMessage());
        }

        // Log error details
        test.log(Status.FAIL, "Exception: " + result.getThrowable().getMessage());
        test.info("Error Stack Trace: " + result.getThrowable().getStackTrace());

        // Add browser logs if needed
        try {
            BaseClass base = (BaseClass) result.getInstance();
            String browserLogs = base.getBrowserLogs(); // This method can be implemented in BaseClass
            test.log(Status.INFO, "Browser Logs: " + browserLogs);
        } catch (Exception e) {
            test.log(Status.INFO, "Failed to fetch browser logs.");
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();

        // Log execution time of the overall test suite
        long totalExecutionTime = testContext.getEndDate().getTime() - testContext.getStartDate().getTime();
        extent.addTestRunnerOutput("Total Execution Time: " + totalExecutionTime / 1000 + " seconds");

        // Final report summary
        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReport = new File(pathOfExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method to fetch test description (you can modify this as per your use case)
    private String getTestDescription(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        // Test case descriptions (can be expanded or changed based on your use case)
        switch (testName) {
            case "TC_007_Subscription":
                return "This test verifies the subscription functionality, ensuring users can subscribe to a newsletter.";
            case "TC_002_SignUp":
                return "This test verifies the user sign-up functionality, ensuring users can register with valid details.";
            case "TC_003_Acc_Info":
                return "This test checks the account information page and ensures that users can update their information.";
            default:
                return "No description available for this test case.";
        }
    }
}
