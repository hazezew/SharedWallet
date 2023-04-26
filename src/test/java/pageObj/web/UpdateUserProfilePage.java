package pageObj.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateUserProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(xpath = "//button[@class=\"ant-btn ant-input-search-button ant-btn-primary\"]")
    private WebElement btnSearch;

    @FindBy(xpath = "(//span[@class=\"ant-alert-message\"])[2]")
    private WebElement validationMessage;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement userValidationMsg;

    @FindBy(xpath = "//div[contains(@class,\"alert\")]")
    private WebElement errorMessageDisplay;

    @FindBy(xpath = "(//div[contains(@class,\"ant-select-selection\")])[2]")
    private WebElement ddLanguage;

    @FindBy(xpath = "(//button[contains(@class,\"wizard\") and contains(@class,\"primary\")])[2]")
    private WebElement btnNext;

    @FindBy(xpath = "(//button[contains(@class,\"wizard\")])[3]")
    private WebElement btnNext2;

    @FindBy(xpath = "//input[contains(@id,\"FULL_NAME\")]")
    private WebElement txtFullName;

    @FindBy(xpath = "//input[contains(@id,\"EMAIL_1\")]")
    private WebElement txtEmail;

    @FindBy(xpath = "(//button[contains(@class,\"previous\")])[2]")
    private WebElement btnPrevious;

    @FindBy(xpath = "//input[contains(@name,\"PASSWORD\")]")
    private WebElement txtNewPassword;

    @FindBy(xpath = "//input[contains(@name,\"USERNAME\")]")
    private WebElement txtNewUsername;

    @FindBy(xpath = "(//button[contains(@class,\"submit\")])[2]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//span[text()=\"Cancel\"]/following::button")
    private WebElement btnOkConfirm;

    public UpdateUserProfilePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }
    public void setTxtUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).sendKeys(username);
    }
    public void clickBtnSearch(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
//        getErrorMessageDisplay();
    }
    public String getUserValidationMsg(){
        return wait.until(ExpectedConditions.visibilityOf(userValidationMsg)).getText();
    }
    public String getValidationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(validationMessage)).getText();
    }
    public String getErrorMessageDisplay(){
        return wait.until(ExpectedConditions.visibilityOf(errorMessageDisplay)).getText();
    }
    public void setDdLanguage(String language){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ddLanguage);
        wait.until(ExpectedConditions.visibilityOf(ddLanguage)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),\""+ language +"\")]")))).click();
    }

    public void clickBtnNext(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", btnNext);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
    }
    public void clickBtnNext2(){
        wait.until(ExpectedConditions.visibilityOf(btnNext2)).click();
    }

    public void setTxtFullName(String name){
        clickBtnPrevious();
        wait.until(ExpectedConditions.visibilityOf(txtFullName)).clear();
        wait.until(ExpectedConditions.visibilityOf(txtFullName)).sendKeys(name);
    }

    public void setTxtEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(txtEmail)).clear();
        wait.until(ExpectedConditions.visibilityOf(txtEmail)).sendKeys(email);
    }

    public void clickBtnPrevious(){
        wait.until(ExpectedConditions.visibilityOf(btnPrevious)).click();
    }

    public void setTxtNewPassword(String newPassword){
        wait.until(ExpectedConditions.visibilityOf(txtNewPassword)).sendKeys(newPassword);
    }

    public void setTxtNewUsername(String newUsername){
        wait.until(ExpectedConditions.visibilityOf(txtNewUsername)).sendKeys(newUsername);
    }
    public void clickBtnSubmit(){
        wait.until(ExpectedConditions.visibilityOf(btnSubmit)).click();
    }

    public void clickBtnOkConfirm(){
        wait.until(ExpectedConditions.visibilityOf(btnOkConfirm)).click();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
