package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class detailPostPage {
    WebDriver driver;

    By postDetail = By.xpath("/html/body/main/section/div/div/div");

    By commentInput = By.id("comment-input");
    By commentSubmit = By.id("submit-button");
    By myComment = By.id("comment-1");
    By lengthErrorBox = By.id("length-error");

    public detailPostPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isPostDetailDisplayed(){
        return  driver.findElement(postDetail).isDisplayed();
    }

    public void clickCommentInput() {
        WebElement input = driver.findElement(commentInput); // `commentInput` is a By

        // Scroll into view using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input);

        // Now click it
        input.click();
    }
    public void inputIntoCommentInput(String comment){
        driver.findElement(commentInput).clear();
        driver.findElement(commentInput).sendKeys(comment);
    }
    public void clickSendComment(){
        driver.findElement(commentSubmit).click();
    }
    public boolean isCommentVisibleSuccess(){
        return driver.findElement(myComment).isDisplayed();
    }

    public boolean isInputErrorDisplayed(){
        return driver.findElement(lengthErrorBox).isDisplayed();
    }
}
