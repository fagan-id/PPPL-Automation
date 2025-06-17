package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
    WebDriver driver;
    WebDriverWait wait;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginNav = By.xpath("//*[@id=\"navbar-default\"]/ul/li[5]/a");

    public void clickProfileNav(){
        driver.findElement(loginNav).click();
    }

    public boolean getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.startsWith("http://127.0.0.1:8000");
    }
}
