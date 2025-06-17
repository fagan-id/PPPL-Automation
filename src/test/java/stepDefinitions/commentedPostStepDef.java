package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.detailPostPage;

import static utils.DriverFactory.getDriver;

public class commentedPostStepDef {

    WebDriver driver = getDriver();

    @Given("The user has previously commented on one or more job vacancy posts")
    public void user_has_commented(){

    }

    @When("The user clicks on the \"Posts\" menu")
    public void user_click_on_posts_menu(){

    }

    @And("The user clicks the \"My Commented Posts\" button")
    public void user_clicks_on_my_commented_post(){

    }
    @Then("The user is redirected to a list of job vacancy posts they have commented on")
    public void user_is_redirected_to_job_vacancy_list(){

    }
}
