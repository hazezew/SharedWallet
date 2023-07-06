package pageObj.web.pages.usermgt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeUserStatusPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement txtUsername;

    @FindBy(xpath = "(//button[contains(@class,\"ant-btn-primary\")])[3]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement usernameValidation;

    @FindBy(xpath = "//span[@class=\"ant-alert-message\"]")
    private WebElement errorSuccessMessage;

    public ChangeUserStatusPage(WebDriver driver){
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

    public String getErrorSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOf(errorSuccessMessage)).getText();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
