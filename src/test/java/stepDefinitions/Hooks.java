package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;
import utils.ExtentReportManager;

import java.io.File;

public class Hooks {

    private static boolean databaseReset = false;
    private static boolean driverInitialized = false;

    @BeforeAll
    public static void setUpFeature() {
        // Reset database once per feature run
        resetDatabase();

        // Initialize driver once per feature
        DriverFactory.getDriver();
        driverInitialized = true;
    }

    @Before
    public void setUpScenario(Scenario scenario) {

        if (!driverInitialized) {
            DriverFactory.getDriver();
            driverInitialized = true;
        }

        // Start test reporting
        ExtentReportManager.startTest(scenario.getName());
        ExtentReportManager.logInfo("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        // Handle test reporting and screenshots
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            ExtentReportManager.logFailure(scenario.getName(), screenshot);
        } else {
            ExtentReportManager.logPass("Scenario passed: " + scenario.getName());
        }

        ExtentReportManager.endTest();
    }

    @AfterAll
    public static void tearDownDriver() {
        DriverFactory.quitDriver();
    }

    private static void resetDatabase() {
        if (!databaseReset) {
            try {
                System.out.println("Resetting database...");
                ProcessBuilder pb = new ProcessBuilder("php", "artisan", "migrate:fresh", "--seed");
                pb.directory(new File("C:\\htdocs\\pad1"));
                pb.inheritIO();
                Process process = pb.start();
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    throw new RuntimeException("Artisan command failed with code " + exitCode);
                }
                databaseReset = true;
                System.out.println("Database reset completed successfully");
            } catch (Exception e) {
                System.err.println("Database reset failed: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("Database setup failed", e);
            }
        }
    }
}