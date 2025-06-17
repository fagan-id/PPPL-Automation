package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class googleOAuthPage {
    WebDriver driver;

    public googleOAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInput = By.xpath("//*[@id=\"identifierId\"]");

    By googleAcc = By.cssSelector("[data-identifier='mmustafafagan@mail.ugm.ac.id]");

    By continueBtn = By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span");
    By continueBtn2 = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[3]/div/div/div[2]/div/div/button/span");

    By accessBlocked = By.id("headingText");


    public void inputEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(emailInput).sendKeys(Keys.ENTER);
    }
    public void clickGoogleAcc()  {
        driver.findElement(googleAcc).click();
    }

    public void clickContinueBtn1(){
        driver.findElement(continueBtn).click();
    }
    public void clickContinueBtn2(){
        driver.findElement(continueBtn2).click();
    }

    public boolean isAccessBlocked(){
        return driver.findElement(accessBlocked).isDisplayed();
    }
}
