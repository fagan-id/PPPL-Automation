package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ExtentReportManager;


import static utils.DriverFactory.getDriver;

public class loginStepDef {
    WebDriver driver = getDriver();

    @Given("user is on the Pokari page")
    public void user_is_on_home_page(){
        try{
            homePage home = new homePage(driver);
            Assertions.assertTrue(home.getCurrentUrl());
            ExtentReportManager.logInfo("Successfully navigated to Pokari home page");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to navigate to home page", screenshot);
        }
    }

    @When("user clicks on the \"Profile\" menu")
    public void user_click_on_the_profile(){
        try{
            homePage home = new homePage(driver);
            home.clickProfileNav();
            ExtentReportManager.logInfo("Clicked on Profile menu");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to click Profile menu", screenshot);
        }
    }

    @And("user clicks the \"Login with Google\" button")
    public void user_click_login_with_google_button(){
        try{
            profilePage profile = new profilePage(driver);
            profile.clickLoginBtn();

            ExtentReportManager.logInfo("Clicked Login with Google button");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to click Login with Google button", screenshot);
        }
    }

    @And("user enters their UGM email and password on the Google Sign-In page")
    public void enter_ugm_email(){
        try {
            googleOAuthPage google = new googleOAuthPage(driver);
            ugmLoginPage ugm = new ugmLoginPage(driver);

            google.inputEmail("mmustafafagan@mail.ugm.ac.id");
            ugm.inputCredentialsAndLogin("mmustafafagan","Mfagan1425");
            google.clickContinueBtn1();
            google.clickContinueBtn2();
            ExtentReportManager.logInfo("Successfully entered UGM credentials");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to enter UGM credentials", screenshot);
        }
    }

    @And("user enters their non-UGM email and password on the Google Sign-In page")
    public void enter_non_ugm_email(){
        try{
            googleOAuthPage google = new googleOAuthPage(driver);
            google.inputEmail("mustafafagan@gmail.com");
            google.clickContinueBtn2();
            ExtentReportManager.logInfo("Entered non-UGM email credentials");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to enter non-UGM credentials", screenshot);
        }
    }

    @Then("system authenticates and redirects the user to the Register page")
    public void user_is_redirected_user_to_the_register_page(){
        try{
            String currentUrl = driver.getCurrentUrl();
            registerPage register = new registerPage(driver);
            Assertions.assertEquals(currentUrl,register.isOnRegisterPage());
            ExtentReportManager.logPass("Successfully redirected to registration page");
        }catch (Exception e){
            String currentUrl = driver.getCurrentUrl();
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed to redirect to registration page. Current URL: " + currentUrl, screenshot);
        }
    }

    @Then("system authenticates the login attempt and shows an error message: “Only UGM Google are allowed to login”")
    public void user_failed_to_redirected_to_the_register_page(){
        try{
            googleOAuthPage google = new googleOAuthPage(driver);
            Assertions.assertTrue(google.isAccessBlocked());
            ExtentReportManager.logPass("Access correctly blocked for non-UGM email");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Error while checking access blocked status", screenshot);
        }

    }

    @And("user click on the Logout button")
    public void userClickOnTheButton() {
        try{
            homePage home = new homePage(driver);
            profilePage profile = new profilePage(driver);

            home.clickProfileNav();
            profile.logout();
            ExtentReportManager.logPass("Successfully Logged Out!");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Error while navigating to Logout", screenshot);

        }
    }
}
