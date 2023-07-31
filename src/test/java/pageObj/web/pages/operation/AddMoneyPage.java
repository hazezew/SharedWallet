package pageObj.web.pages.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObj.web.Elements.CommonElements;

import java.time.Duration;

public class AddMoneyPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputEmoneyAddFromUserName']")
    private WebElement fromUserInput;
    @FindBy(xpath = "//div[@id='inputEmoneyAddFromWallet']']")
    private WebElement fromWalletDropdown;
    @FindBy(xpath = "//div[@id='inputEmoneyAddFromPouch']']")
    private WebElement fromPouchWallet;
    @FindBy(xpath = "//input[@id='inputEmoneyAddToUserName']']")
    private WebElement toUserInput;
    @FindBy(xpath = "//div[@id='inputEmoneyAddToWallet']']")
    private WebElement toWalletDropdown;
    @FindBy(xpath = "//div[@id='inputEmoneyAddToPouch']']")
    private WebElement toPouchDropdown;
    @FindBy(xpath = "//input[@id='inputEmoneyAddAmount']']")
    private WebElement amountInput;
    @FindBy(xpath = "//div[@id='inputEmoneyAddService']']")
    private WebElement serviceDropdown;
    @FindBy(xpath = "name//div[@id='inputEmoneyAddProduct']']")
    private WebElement productDropdown;
    @FindBy(xpath = "//input[@id='inputEmoneyAddRemark']']")
    private WebElement remarkInput;

    public AddMoneyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public void clickDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath("//li[text()='" + dropdownOption + "']")).click();
    }
    public String getURL() {
        return driver.getCurrentUrl();
    }
    public void enterAddMoneyDetail(String fromUser, String fromWallet, String fromPouch, String toUser, String toWallet, String toPouch, String amount, String service, String product, String remark){
        fromUserInput.sendKeys(fromUser);
        wait.until(ExpectedConditions.visibilityOf(fromWalletDropdown)).click();
        clickDropdownOption(fromWallet);
        wait.until(ExpectedConditions.visibilityOf(fromPouchWallet)).click();
        clickDropdownOption(fromPouch);
        toUserInput.sendKeys(toUser);
        wait.until(ExpectedConditions.visibilityOf(toWalletDropdown)).click();
        clickDropdownOption(toWallet);
        wait.until(ExpectedConditions.visibilityOf(toPouchDropdown)).click();
        clickDropdownOption(toPouch);
        amountInput.sendKeys(amount);
        wait.until(ExpectedConditions.visibilityOf(serviceDropdown)).click();
        clickDropdownOption(service);
        wait.until(ExpectedConditions.visibilityOf(productDropdown)).click();
        clickDropdownOption(product);
        remarkInput.sendKeys(remark);
    }

}
