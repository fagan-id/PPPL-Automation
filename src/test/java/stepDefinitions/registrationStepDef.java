package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

import pages.profilePage;
import pages.registerPage;
import utils.ExtentReportManager;

import static utils.DriverFactory.getDriver;

public class registrationStepDef {

    WebDriver driver = getDriver(); // shared driver

    @Given("user is on the Register page")
    public void user_is_on_register_page(){
        try{
            registerPage register = new registerPage(driver);
            Assertions.assertEquals("http://127.0.0.1:8000/registration",register.isOnRegisterPage());

            ExtentReportManager.logInfo("Successfully navigated to Register page");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to navigate to Register page", screenshot);
        }
    }

    @When("user selects \"Alumni\" as the role")
    public void user_select_role(){
        try {
            registerPage register = new registerPage(driver);
            register.selectAlumniRole();

            ExtentReportManager.logInfo("Successfully navigated to Register page");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Alumni Failed To Select Role", screenshot);
        }
    }

    @Then("user click on \"Next\" Button")
    public void user_click_next_btn(){
        try {
            registerPage register = new registerPage(driver);
            register.clickNextBtn();

            ExtentReportManager.logInfo("Navigated via 'Next' Button");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Alumni Failed To Click 'Next' Button", screenshot);
        }
    }

    @And("system displays alumni data containing name and student ID")
    public void display_name_and_id(){
        try {
            registerPage register = new registerPage(driver);
            String name = register.isNameDisplayed();
            String id = register.isIdDisplayed();

            register.setNameNimInput(name,id);
            ExtentReportManager.logInfo("Sistem Displayed Alumni Data");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to display alumni data", screenshot);
        }
    }

    @And("user enters the graduation year as {string}")
    public void enter_graduation_year(String date){
        try{
            registerPage register = new registerPage(driver);
            register.clearGradYearInput();
            register.setGradYearInput(date);

            ExtentReportManager.logInfo("Succesfully Entered Graduation Year!");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to enter graduation year", screenshot);
        }
    }

    @And("user clicks the \"Submit\" button")
    public void user_click_submit_btn(){
        try {
            registerPage register = new registerPage(driver);
            register.clickSubmitBtn();

            ExtentReportManager.logInfo("Succesfully Clicked Submit Button");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to click submit button", screenshot);
        }

    }

    @Then("system {string}")
    public void system_behavior_based_on_expectedOutcome(String expectedOutcome) {
        if (expectedOutcome.contains("saves the alumni data and redirects to the Profile page")) {
            profilePage profile = new profilePage(driver);
            String name = profile.getUsername();
            assertEquals("M. MUSTAFA FAGAN", name);
            ExtentReportManager.logInfo("Succesfully Saved Alumni Data and Redirected to Profile Page");
        } else if (expectedOutcome.contains("shows a validation error and does not proceed to the Profile page")) {
            registerPage register = new registerPage(driver);
            boolean isErrorDisplayed = register.isErrorDisplayed(); // You need to implement this
            assertTrue(isErrorDisplayed, "Expected a validation error, but none was shown.");
            ExtentReportManager.logInfo("Succesfully showed an validation error!");
        } else {
            fail("Unexpected expectedOutcome value: " + expectedOutcome);
        }
    }
}
