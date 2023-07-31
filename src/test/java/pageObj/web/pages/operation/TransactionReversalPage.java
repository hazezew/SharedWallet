package pageObj.web.pages.operation;

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

public class TransactionReversalPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='TransactionId']")
    private WebElement transactionIdInput;
    @FindBy(xpath = "//input[@name='TRANS_FROM_DATE']']")
    private WebElement fromDateInput;
    @FindBy(xpath = "//input[@name='TRANS_TO_DATE']']")
    private WebElement toDateInput;
    @FindBy(xpath = "//button[@id='searchbutton']']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[text()='Ok']")
    private WebElement okButton;
    @FindBy(xpath = "//input[@class='ant-calendar-input ']")
    private WebElement selectDateInput;

    public TransactionReversalPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void enterTransactionReversal(String transactionId, String fromDate, String toDate){
        transactionIdInput.sendKeys(transactionId);
        wait.until(ExpectedConditions.visibilityOf(fromDateInput)).click();
        selectDateInput.sendKeys(fromDate);
        wait.until(ExpectedConditions.visibilityOf(toDateInput)).click();
        selectDateInput.sendKeys(toDate);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifyValidationMessage() {
        boolean allValidationMessagesDisplayed = true;
        for (WebElement msg : validationMessages) {
            if (!msg.isDisplayed()) {
                allValidationMessagesDisplayed = false;
                break;
            }
        }
        Assert.assertTrue(allValidationMessagesDisplayed, "All validation messages are not displayed");
    }
}
