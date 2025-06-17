package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class registerPage {
    WebDriver driver;

    public registerPage(WebDriver driver) {
        this.driver = driver;
    }
    By nameInput = By.name("name");
    By nimInput = By.name("nim");
    By gradYearInput = By.name("graduate_year");

    By selectRadioAlumniRole = By.id("role-alumni");
    By selectRadioMahasiswaRole = By.id("role-student");
    By submitBtn = By.id("submit-btn");
//    By registerText = By.xpath("//h1[contains(text(), 'Registration Form')]");
    By nextBtn = By.xpath("//*[@id=\"next-btn\"]");

    By errorBox = By.xpath("/html/body/main/section/div/div/div[1]");

    public void setNameNimInput(String name, String nim) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(nimInput).sendKeys(nim);
    }

    public void clearGradYearInput(){
        driver.findElement(gradYearInput).clear();
    }
    public void setGradYearInput(String year) {
        driver.findElement(gradYearInput).sendKeys(year);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public String isOnRegisterPage(){
        return driver.getCurrentUrl();
    }

    public void selectAlumniRole(){
        driver.findElement(selectRadioAlumniRole).click();
    }


    public String isNameDisplayed() {
        return driver.findElement(nameInput).getText();
    }
    public String isIdDisplayed(){
        return driver.findElement(nimInput).getText();
    }

    public void clickNextBtn(){
        driver.findElement(nextBtn).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorBox).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
