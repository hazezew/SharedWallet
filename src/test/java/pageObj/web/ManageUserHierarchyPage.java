package pageObj.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManageUserHierarchyPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "treeNodeText")
    private WebElement txtTreeIdentifier;

    @FindBy(xpath = "//button[contains(@class,\"input-search-button\")]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement usernameMandatoryValidation;

    @FindBy(xpath = "//span[@class=\"ant-alert-description\"]")
    private WebElement userValidationMessage;

    @FindBy(xpath = "(//span[@class=\"ant-alert-message\"])[2]")
    private WebElement popupUserValidationMessage;

    @FindBy(xpath = "//button[@class=\"ant-btn\"]")
    private WebElement popupBtnCancel;

    @FindBy(xpath = "(//button[contains(@class,\"btn ant-dropdown-trigger\")])[3]")
    private WebElement treeMobileNumber;

    @FindBy(xpath = "//span[text()=\"Edit\"]")
    private WebElement popupButtonEdit;

    @FindBy(xpath = "//button[contains(@class,\"wizard-next-btn\")]")
    private WebElement btnNext;

    @FindBy(xpath = "//button[contains(@class,\"wizard-submit-btn\")]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//button[@class=\"ant-btn\"]/following::button")
    private WebElement popupConfirmation;

    public ManageUserHierarchyPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void setTxtTreeIdentifier(String username){
        wait.until(ExpectedConditions.visibilityOf(txtTreeIdentifier)).sendKeys(username);
    }

    public void clickBtnSearch(){
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
    }

    public String getUsernameMandatoryValidation(){
        return wait.until(ExpectedConditions.visibilityOf(usernameMandatoryValidation)).getText();
    }

    public String getUserValidationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(userValidationMessage)).getText();
    }

    public String getPopupUserValidationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(popupUserValidationMessage)).getText();
    }

    public void clickPopupBtnCancel(){
        wait.until(ExpectedConditions.visibilityOf(popupBtnCancel)).click();
    }

    public void hoverTreeMobileNumber(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", treeMobileNumber);
        action.moveToElement(wait.until(ExpectedConditions.visibilityOf(treeMobileNumber))).build().perform();
    }

    public void clickPopupButtonEdit(){
        wait.until(ExpectedConditions.visibilityOf(popupButtonEdit)).click();
    }
    public void clickBtnNext(){
        wait.until(ExpectedConditions.visibilityOf(btnNext)).click();
    }

    public void clickBtnSubmit(){
        wait.until(ExpectedConditions.visibilityOf(btnSubmit)).click();
    }

    public void clickPopupConfirmation(){
        wait.until(ExpectedConditions.visibilityOf(popupConfirmation)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getURL(){
        driver.navigate().refresh();
        return driver.getCurrentUrl();
    }
}
