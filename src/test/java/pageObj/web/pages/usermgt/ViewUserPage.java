package pageObj.web.pages.usermgt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewUserPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(xpath = "//button[@class=\"ant-btn ant-input-search-button ant-btn-primary\"]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@class,\"alert\")]")
    private WebElement errorMessageDisplay;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement userValidationMsg;

    public ViewUserPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }
    public void setTxtUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).clear();
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
    public String getErrorMessageDisplay(){
        return wait.until(ExpectedConditions.visibilityOf(errorMessageDisplay)).getText();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
