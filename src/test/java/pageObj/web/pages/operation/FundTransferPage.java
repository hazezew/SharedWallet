package pageObj.web.pages.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FundTransferPage{
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//div[@id='inputFundmanagementAddFromAccount']")
    private WebElement fromAccountDropdown;
    @FindBy(xpath = "//div[@id='inputFundmanagementAddToAccount']")
    private WebElement toAccountDropdown;
    @FindBy(xpath = "//div[@id='inputFundmanagementAddService']")
    private WebElement serviceDropdown;
    @FindBy(xpath = "//div[@id='inputFundmanagementAddProduct']")
    private WebElement productDropdown;
    @FindBy(xpath = "//input[@id='inputFundmanagementAddAmount']")
    private WebElement amountInput;
    @FindBy(xpath = "//input[@id='inputFundmanagementAddRemark']")
    private WebElement remarkInput;
    @FindBy(xpath = "//input[@id='inputFundmanagementAddPassword']")
    private WebElement passwordInput;

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
    public void clickDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath("//li[text()='" + dropdownOption + "']")).click();
    }
    public void enterFundDetail(String fromAccount, String toAccount, String service, String product, String amount, String remark, String password){
        wait.until(ExpectedConditions.visibilityOf(fromAccountDropdown)).click();
        clickDropdownOption(fromAccount);
        wait.until(ExpectedConditions.visibilityOf(toAccountDropdown)).click();
        clickDropdownOption(toAccount);
        wait.until(ExpectedConditions.visibilityOf(serviceDropdown)).click();
        clickDropdownOption(service);
        wait.until(ExpectedConditions.visibilityOf(productDropdown)).click();
        clickDropdownOption(product);
        amountInput.sendKeys(amount);
        remarkInput.sendKeys(remark);
        passwordInput.sendKeys(password);
    }
}
