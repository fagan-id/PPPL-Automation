package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.detailPostPage;
import pages.postPage;
import pages.profilePage;

import static utils.DriverFactory.getDriver;

public class viewPostDetailStepDef {

    WebDriver driver = getDriver();

    @Given("user is on the Profile page and logged in as an alumni")
    public void user_is_on_profile_page(){
        profilePage profile = new profilePage(driver);
        Assertions.assertEquals("http://127.0.0.1:8000/profile/alumni",profile.isOnProfilePage());
    }

    @Then("user clicks on the \"Posts\" menu")
    public void user_click_on_post_menu(){
        profilePage profile = new profilePage(driver);
        profile.clickPostsNav();
    }

    @And("The user clicks on one of the posts")
    public void user_click_on_post(){
        postPage post = new postPage(driver);
        post.selectPost();
    }

    @Then("The user is redirected to the details page of that post")
    public void display_detail_post(){
        detailPostPage detailPost = new detailPostPage(driver);
        Assertions.assertTrue(detailPost.isPostDetailDisplayed());
    }
}
