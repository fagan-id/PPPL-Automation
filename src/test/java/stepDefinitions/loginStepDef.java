package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import pages.*;

import java.time.Duration;

import static utils.DriverFactory.getDriver;

public class loginStepDef {
    WebDriver driver = getDriver(); // shared driver


    @Given("user is on the Pokari page")
    public void user_is_on_home_page(){
        homePage home = new homePage(driver);
        Assertions.assertTrue(home.getCurrentUrl());
    }

    @When("user clicks on the \"Profile\" menu")
    public void user_click_on_the_profile(){
        homePage home = new homePage(driver);
        home.clickProfileNav();
    }

    @And("user clicks the \"Login with Google\" button")
    public void user_click_login_with_google_button(){
        profilePage profile = new profilePage(driver);
        profile.clickLoginBtn();
    }

    @And("user enters their UGM email and password on the Google Sign-In page")
    public void enter_ugm_email(){
        googleOAuthPage google = new googleOAuthPage(driver);
        ugmLoginPage ugm = new ugmLoginPage(driver);

        google.inputEmail("mmustafafagan@mail.ugm.ac.id");
        ugm.inputCredentialsAndLogin("mmustafafagan","Mfagan1425");
        google.clickContinueBtn1();
        google.clickContinueBtn2();
    }

    @And("user enters their non-UGM email and password on the Google Sign-In page")
    public void enter_non_ugm_email(){
        googleOAuthPage google = new googleOAuthPage(driver);
        google.inputEmail("mustafafagan@gmail.com");
        google.clickContinueBtn2();
    }

    @Then("system authenticates and redirects the user to the Register page")
    public void user_is_redirected_user_to_the_register_page(){
        registerPage register = new registerPage(driver);
        Assertions.assertEquals("http://127.0.0.1:8000/registration",register.isOnRegisterPage());
    }

    @Then("system authenticates the login attempt and shows an error message: “Only UGM Google are allowed to login”")
    public void user_failed_to_redirected_to_the_register_page(){
        googleOAuthPage google = new googleOAuthPage(driver);
        Assertions.assertTrue(google.isAccessBlocked());
    }
}
