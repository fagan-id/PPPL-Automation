package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class profilePage {
    WebDriver driver;

    public profilePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginBtn = By.id("login-btn");
    By postsNav = By.id("posts-page");
    By userName = By.xpath("/html/body/main/section/div/div[1]/div[2]/div[1]/div[2]/h2");
    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public String getUsername(){
        return driver.findElement(userName).getText();
    }

    public String isOnProfilePage(){
        return driver.getCurrentUrl();
    }
    public void clickPostsNav() {
        driver.findElement(postsNav).click();
    }
}
