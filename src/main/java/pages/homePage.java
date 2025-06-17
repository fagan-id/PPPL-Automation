package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    By postsNav = By.id("posts-page");
    By loginNav = By.xpath("//*[@id=\"navbar-default\"]/ul/li[5]/a");



    public void clickProfileNav(){
        driver.findElement(loginNav).click();
    }

    public boolean getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.startsWith("http://127.0.0.1:8000");
    }
}
