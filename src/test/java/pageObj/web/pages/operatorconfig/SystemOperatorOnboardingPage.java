package pageObj.web.pages.operatorconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObj.web.Elements.CommonElements;

import java.time.Duration;

public class SystemOperatorOnboardingPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//div[@id='inputSystemOperatorOnBoadingBusinessEntityName']")
    private WebElement soeDropdown;
    @FindBy(xpath = "//div[@id='inputSystemOperatorOnBoadingKYCLevel']']")
    private WebElement kycLevelDropdown;
    @FindBy(xpath = "//input[@placeholder='Please Enter Your Full name']']")
    private WebElement fullNameInput;
    @FindBy(xpath = "//input[@placeholder='Select date']']")
    private WebElement dateField;
    @FindBy(xpath = "//input[@placeholder='Please Enter your mobile number']']")
    private WebElement mobileNumberInput;
    @FindBy(xpath = "//input[@placeholder='Please Enter Your Email']']")
    private WebElement emailField;
    @FindBy(xpath = "//span[text()='Next']/parent::button']")
    private WebElement nextButton;
    @FindBy(xpath = "//input[@class='ant-calendar-input ']")
    private WebElement dobInput;

    public SystemOperatorOnboardingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void clickDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath("//li[text()='" + dropdownOption + "']")).click();
    }
    public void addSystemOperator(String SOE, String kycLevel, String fullName, String dob, String mobile, String email){
        soeDropdown.click();
        clickDropdownOption(SOE);
        wait.until(ExpectedConditions.visibilityOf(kycLevelDropdown));
        clickDropdownOption(kycLevel);
        fullNameInput.sendKeys(fullName);
        dateField.click();
        dobInput.sendKeys(dob);
        fullNameInput.click();
        mobileNumberInput.sendKeys(mobile);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        emailField.sendKeys(email);
        nextButton.click();
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void verifySystemOperatorCreated(String systemOperatorName) {
        String actualSystemOperatorName = driver.findElement(By.xpath("//td[text()='" + systemOperatorName + "']")).getText();
        Assert.assertEquals(actualSystemOperatorName, systemOperatorName);
    }

    public void clickViewIcon(String systemOperatorName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + systemOperatorName + "')]/preceding-sibling::td[2]")).click();
    }

    public void deleteSystemOperator() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }

}
