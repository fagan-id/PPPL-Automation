package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    public static ExtentReports getInstance(){
        if (extent==null){
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir")
                    + "/test-output/GeneratedExtentReport"+timeStamp+".html";

            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("OS",System.getProperty("os.name"));
            extent.setSystemInfo("Browser","Chrome");
            extent.setSystemInfo("Tester","Fagan");
            extent.setSystemInfo("Environtment","Staging");
            extent.setSystemInfo("Application", "Pokari");
        }
        return extent;
    }
    public static void startTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
        logInfo("Starting test: " + testName);
    }

    public static void logInfo(String message) {
        test.get().log(Status.INFO, message);
    }

    public static void logPass(String message) {
        test.get().log(Status.PASS, message);
    }

    public static void logFailure(String message) {
        test.get().log(Status.FAIL, message);
    }

    public static void logFailure(String message, byte[] screenshot) {
        if (test.get() != null) {
            try {
                if (screenshot != null && screenshot.length > 0) {
                    test.get().fail( message,
                            com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(
                                    java.util.Base64.getEncoder().encodeToString(screenshot),
                                    "Failure Screenshot"
                            ).build());
                } else {
                    test.get().fail(message);
                }
            } catch (Exception e) {
                // If screenshot attachment fails, still log the failure message
                test.get().fail( message + " (Screenshot attachment failed: " + e.getMessage() + ")");
            }
        }
    }

    public static void endTest() {
        getInstance().flush();
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
