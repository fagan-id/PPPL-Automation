package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.detailPostPage;
import pages.profilePage;
import pages.registerPage;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DriverFactory.getDriver;

public class commentStepDef {

    WebDriver driver = getDriver();

    @Given("The user is on the job vacancy post detail page")
    public void user_is_on_job_vacancy_detail_page(){
        detailPostPage detail = new detailPostPage(driver);
        Assertions.assertTrue(detail.isPostDetailDisplayed());
    }

    @When("The user clicks on the comment input field")
    public void user_click_comment_input_field(){
        detailPostPage detail = new detailPostPage(driver);
        detail.clickCommentInput();
    }

    @And("The user types a {string} into the input field")
    public void user_fill_in_comment_input_field(String comment){
        detailPostPage detail = new detailPostPage(driver);
        detail.inputIntoCommentInput(comment);
    }
    @And("The user clicks the \"Send\" button")
    public void user_click_send_comment_button(){
        detailPostPage detail = new detailPostPage(driver);
        detail.clickSendComment();
    }
    @Then("The system displays the new comment in the comment section on the right side of the post")
    public void user_is_redirected(){
        detailPostPage detail = new detailPostPage(driver);
        Assertions.assertTrue(detail.isCommentVisibleSuccess());
    }

    @Then("The system {string}")
    public void system_behavior_based_on_expectedOutcome(String expectedOutcome) {
        if (expectedOutcome.contains("displays the new comment in the comment section on the right side of the post")) {
            detailPostPage detail = new detailPostPage(driver);
            Assertions.assertTrue(detail.isCommentVisibleSuccess());
        } else if (expectedOutcome.contains("displays an error message saying 'Maximum 1000 character allowed'")) {
            detailPostPage detail = new detailPostPage(driver);
            Assertions.assertTrue(detail.isInputErrorDisplayed());
        }
    }
}
