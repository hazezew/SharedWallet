package pageObj.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpgradeUserKYCPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement txtUsername;

    @FindBy(xpath = "//button[contains(@class,\"ant-input-search-button ant-btn-primary\")]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement usernameValidation;

    @FindBy(xpath = "")
    private WebElement validationMessage;

    public UpgradeUserKYCPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void setTxtUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).sendKeys(username);
    }
    public void clickBtnSearch(){
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
    }

    public String getUsernameValidation(){
        return wait.until(ExpectedConditions.visibilityOf(usernameValidation)).getText();
    }

    public String getErrorMessage(){
//        validationMessage WebElement locator to be defined as there is no WebElement at time of writing
        return wait.until(ExpectedConditions.visibilityOf(validationMessage)).getText();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
