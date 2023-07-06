package pageObj.web.pages.usermgt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WalletManagementPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(xpath = "//button[contains(@class,\"ant-btn ant-input-search-button\")]")
    private WebElement btnSearch;

    @FindBy(xpath = "(//div[@class=\"ant-form-explain\"])[1]")
    private WebElement mandatoryUserValidation;

    @FindBy(xpath ="//span[@class=\"ant-alert-message\"]")
    private WebElement validationMessageDisplay;

    @FindBy(xpath ="(//span/div[@class=\"data-div\"])[1]")
    private WebElement walletUserInfo;

    @FindBy(xpath = "//div[text()=\"User Info\"]")
    private WebElement tabUserInfo;

    @FindBy(xpath = "//div[text()=\"Wallet Info\"]")
    private WebElement tabWalletInfo;

    @FindBy(xpath = "//input[@id=\"inputUserWalletwallet\"]")
    private WebElement txtWallet;

    public WalletManagementPage(WebDriver driver){
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

    public String getMandatoryUserValidation(){
        return wait.until(ExpectedConditions.visibilityOf(mandatoryUserValidation)).getText();
    }

    public String getValidationMessageDisplay(){
        return wait.until(ExpectedConditions.visibilityOf(validationMessageDisplay)).getText();
    }

    public void clickTabUserInfo(){
        wait.until(ExpectedConditions.visibilityOf(tabUserInfo)).click();
    }

    public void clickTabWalletInfo(){
        wait.until(ExpectedConditions.visibilityOf(tabWalletInfo)).click();
    }

    public boolean getUserWalletStatus(){
        clickTabUserInfo();
        return walletUserInfo.isDisplayed();
    }

    public void setTxtWallet(String wallet){
        clickTabWalletInfo();
        wait.until(ExpectedConditions.visibilityOf(txtWallet)).sendKeys(wallet);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}