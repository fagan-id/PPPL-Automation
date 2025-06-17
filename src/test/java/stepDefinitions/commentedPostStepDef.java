package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.detailPostPage;
import pages.homePage;
import pages.postPage;
import pages.profilePage;
import utils.ExtentReportManager;

import static utils.DriverFactory.getDriver;

public class commentedPostStepDef {

    WebDriver driver = getDriver();

    @Given("The user has previously commented on one or more job vacancy posts")
    public void user_has_commented(){
        try {
            detailPostPage detail = new detailPostPage(driver);
            Assertions.assertTrue(detail.isCommentVisibleSuccess());
            ExtentReportManager.logPass("Validated that Alumni has previously commented!");

        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed validating previous comment", screenshot);
        }
    }

    @When("The user clicks on the \"Posts\" menu")
    public void user_click_on_posts_menu(){
        try {
            profilePage profile = new profilePage(driver);
            profile.clickPostsNav();

            ExtentReportManager.logPass("Successfully Navigated into the Posts Page!");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed navigating into the Posts Page", screenshot);
        }
    }

    @And("The user clicks the \"My Commented Posts\" button")
    public void user_clicks_on_my_commented_post(){
        try {
            postPage posts = new postPage(driver);
            posts.clickMyComment();

            ExtentReportManager.logPass("Successfully Navigated into the My Comment Parts!");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Failed navigating into the My Comment Parts!", screenshot);
        }
    }
    @Then("The user is redirected to a list of job vacancy posts they have commented on")
    public void user_is_redirected_to_job_vacancy_list(){
        try {
            postPage posts = new postPage(driver);
            posts.isPostDisplayed();

            ExtentReportManager.logPass("redirected to a list of job vacancy posts they have commented on");
        }catch (Exception e){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentReportManager.logFailure("Fail to redirected to a list of job vacancy posts they have commented on", screenshot);
        }
    }
}
