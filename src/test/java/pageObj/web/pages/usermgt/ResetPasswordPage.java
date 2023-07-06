package pageObj.web.pages.usermgt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(xpath = "//button[contains(@class,\"search-button\")]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement usernameValidationMessage;

//    Element xpath identifier needs to be completed when issue is fixed
    @FindBy(xpath = "")
    private WebElement validationMessage;

    public ResetPasswordPage(WebDriver driver){
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
    public String  getUsernameValidationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(usernameValidationMessage)).getText();
    }
    public String getValidationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(validationMessage)).getText();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
}