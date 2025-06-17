package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

import pages.profilePage;
import pages.registerPage;

import static utils.DriverFactory.getDriver;

public class registrationStepDef {

    WebDriver driver = getDriver(); // shared driver

    @Given("user is on the Register page")
    public void user_is_on_register_page(){
        registerPage register = new registerPage(driver);
        Assertions.assertEquals("http://127.0.0.1:8000/registration",register.isOnRegisterPage());
    }

    @When("user selects \"Alumni\" as the role")
    public void user_select_role(){
        registerPage register = new registerPage(driver);
        register.selectAlumniRole();
    }

    @Then("user click on \"Next\" Button")
    public void user_click_next_btn(){
        registerPage register = new registerPage(driver);
        register.clickNextBtn();
    }

    @And("system displays alumni data containing name and student ID")
    public void display_name_and_id(){
        registerPage register = new registerPage(driver);
        String name = register.isNameDisplayed();
        String id = register.isIdDisplayed();

        register.setNameNimInput(name,id);
    }

    @And("user enters the graduation year as {string}")
    public void enter_graduation_year(String date){
        registerPage register = new registerPage(driver);
        register.clearGradYearInput();
        register.setGradYearInput(date);
    }

    @And("user clicks the \"Submit\" button")
    public void user_click_submit_btn(){
        registerPage register = new registerPage(driver);
        register.clickSubmitBtn();
    }

    @Then("system {string}")
    public void system_behavior_based_on_expectedOutcome(String expectedOutcome) {
        if (expectedOutcome.contains("saves the alumni data and redirects to the Profile page")) {
            profilePage profile = new profilePage(driver);
            String name = profile.getUsername();
            assertEquals("M. MUSTAFA FAGAN", name);
        } else if (expectedOutcome.contains("shows a validation error and does not proceed to the Profile page")) {
            registerPage register = new registerPage(driver);
            boolean isErrorDisplayed = register.isErrorDisplayed(); // You need to implement this
            assertTrue(isErrorDisplayed, "Expected a validation error, but none was shown.");
        } else {
            fail("Unexpected expectedOutcome value: " + expectedOutcome);
        }
    }
}
