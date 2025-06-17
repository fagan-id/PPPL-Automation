package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class postPage {
    WebDriver driver;

    public postPage(WebDriver driver) {
        this.driver = driver;
    }

    By newPostBtn = By.id("new-post-btn");
    By myCommentPostBtn = By.id("my-commented-post-button");
    By positionInput = By.id("position");
    By companyInput = By.id("company");
    By vacancyDescInput = By.id("vacancy_description");
    By startDateInput = By.id("start_date");
    By endDateInput = By.id("end_date");
    By responsibilityInput = By.id("responsibility");
    By addResponsibilityBtn = By.id("add-responsibility");
    By qualificationInput = By.id("qualification");
    By addQualificationBtn = By.id("add-qualification");
    By benefitInput = By.id("benefit");
    By addBenefitBtn = By.id("add-benefits");
    By posterInput = By.id("vacancy_picture");
    By postBtn = By.id("submit-vacancy");

    By selectPost = By.xpath("//*[@id=\"post-container\"]/a[1]");

    By postForm = By.xpath("//*[@id=\"crud-modal-post\"]/div/div");

    public void clickNewPostBtn() {
        driver.findElement(newPostBtn).click();
    }

    public void setPositionInput(String position) {
        new Select(driver.findElement(positionInput)).selectByValue(position);
    }

    public void setCompanyInput(String company) {
        new Select(driver.findElement(companyInput)).selectByValue(company);
    }

    public void setVacancyDescInput(String desc) {
        driver.findElement(vacancyDescInput).sendKeys(desc);
    }

    public void setStartDateInput(String startDate) {
        driver.findElement(startDateInput).sendKeys(startDate);;
    }

    public void setEndDateInput(String endDate) {
        driver.findElement(endDateInput).sendKeys(endDate);;
    }

    public void setResponsibilityInput(String responsibility) {
        driver.findElement(responsibilityInput).sendKeys(responsibility);
    }

    public void clickAddResponsibility() {
        driver.findElement(addResponsibilityBtn).click();
    }

    public void setQualificationInput(String qualification) {
        driver.findElement(qualificationInput).sendKeys(qualification);
    }

    public void clickAddQualification() {
        driver.findElement(addQualificationBtn).click();
    }

    public void setBenefitInput(String benefit) {
        driver.findElement(benefitInput).sendKeys(benefit);
    }

    public void clickAddBenefit() {
        driver.findElement(addBenefitBtn).click();
    }

    public void setPosterInput(String imgPath) {
        driver.findElement(posterInput).sendKeys(imgPath);
    }

    public void clickPostBtn() {
        driver.findElement(postBtn).click();
    }

    public void isFormDisplayed(){
        driver.findElement(postForm).isDisplayed();
    }

    public void selectPost(){
        driver.findElement(selectPost).click();
    }

    public void isPostDisplayed(){
        driver.findElement(selectPost).isDisplayed();
    }

    public void clickMyComment(){
        driver.findElement(myCommentPostBtn).click();
    }
}
