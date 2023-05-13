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

public class SystemUserManagementPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id="operationbarbuttonadd")
    private WebElement btnAdd;

    @FindBy(xpath = "(//div[@class=\"ant-select-selection__rendered\"])[2]")
    private WebElement ddSystemOperatorEntity;

    @FindBy(xpath = "(//div[@class=\"ant-select-selection__rendered\"])[3]")
    private WebElement ddKYCLevel;

    @FindBy(xpath = "//div[@class=\"wizard-html\"]")
    private WebElement tenantValidationMessage;

    @FindBy(xpath = "//input[contains(@id,\"FIRST_NAME_SIB\")]")
    private WebElement txtFirstName;

    @FindBy(xpath = "//input[contains(@id,\"MIDDLE_NAME_SIB\")]")
    private WebElement txtMiddleName;

    @FindBy(xpath = "//input[contains(@id,\"LAST_NAME_SIB\")]")
    private WebElement txtLastName;

    @FindBy(xpath = "//input[contains(@id,\"MOB_NUMBER_SIB\")]")
    private WebElement txtMobileNumber;

    @FindBy(xpath = "//input[contains(@id,\"ADDRESS1_SIB\")]")
    private WebElement txtAddress1;

    @FindBy(xpath = "//input[contains(@id,\"EMAIL_SIB\")]")
    private WebElement txtEmail;

    @FindBy(xpath = "//button[contains(@class,\"ant-btn wizard-submit-btn\")]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//span[@class=\"ant-alert-message\"]")
    private WebElement errorSuccessMessage;

    public SystemUserManagementPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void clickBtnAdd(){
        wait.until(ExpectedConditions.visibilityOf(btnAdd)).click();
    }

    public void selectDDSystemOperatorEntity(String systemOperatorEntity){
        wait.until(ExpectedConditions.visibilityOf(ddSystemOperatorEntity)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),\"" + systemOperatorEntity + "\")]")))).click();
    }

    public void selectDDKYCLevel(String KYCLevel){
        wait.until(ExpectedConditions.visibilityOf(ddKYCLevel)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),\"" + KYCLevel + "\")]")))).click();
    }

    public String getTenantValidationMessage(){
        return wait.until(ExpectedConditions.visibilityOf(tenantValidationMessage)).getText();
    }

    public void setTxtFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOf(txtFirstName)).sendKeys(firstName);
    }
    public void setTxtMiddleName(String middleName){
        wait.until(ExpectedConditions.visibilityOf(txtMiddleName)).sendKeys(middleName);
    }

    public void setTxtLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOf(txtLastName)).sendKeys(lastName);
    }

    public void setTxtMobileNumber(String mobileNumber){
        wait.until(ExpectedConditions.visibilityOf(txtMobileNumber)).sendKeys(mobileNumber);
    }
    public void setTxtAddress1(String address1){
        wait.until(ExpectedConditions.visibilityOf(txtAddress1)).sendKeys(address1);
    }
    public void setTxtEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(txtEmail)).sendKeys(email);
    }
    public void clickBtnSubmit(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSubmit);
        wait.until(ExpectedConditions.visibilityOf(btnSubmit)).click();
    }
    public String  getErrorSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOf(errorSuccessMessage)).getText();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

}
