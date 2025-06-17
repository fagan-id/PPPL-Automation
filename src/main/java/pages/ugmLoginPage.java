package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ugmLoginPage {
    WebDriver driver;
    public ugmLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By inputUsername = By.id("username");
    By inputPassword = By.id("password");

    By loginBtn = By.name("submit");

    public void inputCredentialsAndLogin(String username, String password){
        driver.findElement(inputUsername).sendKeys(username);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
