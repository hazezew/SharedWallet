package pageObj.web.pages.usermgt;

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

public class SearchBusinessUserByTemplatePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//div[@class=\"ant-select-selection__placeholder\"]")
    private WebElement ddOperatingEntityTemplate;

    @FindBy(id = "inputTreeIdentifier")
    private WebElement txtInputTreeIdentifier;

    @FindBy(xpath = "//button[contains(@class,\"input-search-button\")]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@class,\"ant-alert ant-alert-error\")]")
    private WebElement successErrorMessage;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]/descendant::span")
    private WebElement ddOperatingEntityTemplateMandatoryMessage;

    @FindBy(xpath = "(//div[@class=\"ant-tag ant-tag-blue\"]/descendant::i)[1]")
    private WebElement iconShowUserInfo;

    @FindBy(xpath = "(//i[@class=\"anticon anticon-apartment\"])[1]")
    private WebElement iconViewUserHierarchy;

    @FindBy(xpath = "(//div[contains(@class,\"ant-tabs-tab\")])[1]")
    private WebElement tabUserInfo;

    @FindBy(xpath = "(//div[contains(@class,\"ant-tabs-tab\")])[2]")
    private WebElement tabPersonalInformation;

    @FindBy(xpath = "(//div[contains(@class,\"ant-tabs-tab\")])[3]")
    private WebElement tabLoginInfo;

    @FindBy(xpath = "(//button[contains(@class,\"ant-btn-primary\")])[2]")
    private WebElement btnPopupUserInfoOk;

    @FindBy(xpath = "//button[@class=\"ant-btn ant-btn-primary\"]")
    private WebElement btnPopupUserHierarchyOk;

    public SearchBusinessUserByTemplatePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }
    public void setDdOperatingEntityTemplate(String template){
        wait.until(ExpectedConditions.visibilityOf(ddOperatingEntityTemplate)).click();
        WebElement selection=driver.findElement(By.xpath("//li[text()=\"" + template + "\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selection);
        wait.until(ExpectedConditions.visibilityOf(selection)).click();
    }

    public void setTxtInputTreeIdentifier(String identifier){
        wait.until(ExpectedConditions.visibilityOf(txtInputTreeIdentifier)).sendKeys(identifier);
    }
    public void clickBtnSearch(){
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
    }
    public String getSuccessErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOf(successErrorMessage)).getText();
    }

    public String getDdOperatingEntityTemplateMandatoryMessage(){
        return wait.until(ExpectedConditions.visibilityOf(ddOperatingEntityTemplateMandatoryMessage)).getText();
    }

    public void clickIconShowUserInfo(){
        wait.until(ExpectedConditions.visibilityOf(iconShowUserInfo)).click();
    }
    public void clickIconViewUserHierarchy(){
        wait.until(ExpectedConditions.visibilityOf(iconViewUserHierarchy)).click();
    }
    public void clickBtnPopupUserHierarchyOk(){
        wait.until(ExpectedConditions.visibilityOf(btnPopupUserHierarchyOk)).click();
    }

    public void clickTabUserInfo(){
        wait.until(ExpectedConditions.visibilityOf(tabUserInfo)).click();
    }
    public void clickTabPersonalInformation(){
        wait.until(ExpectedConditions.visibilityOf(tabPersonalInformation)).click();
    }
    public void clickTabLoginInfo(){
        wait.until(ExpectedConditions.visibilityOf(tabLoginInfo)).click();
    }
    public void clickBtnPopupUserInfoOk(){
        wait.until(ExpectedConditions.visibilityOf(btnPopupUserInfoOk)).click();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
