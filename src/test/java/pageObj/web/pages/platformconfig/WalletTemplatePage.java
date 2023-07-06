package pageObj.web.pages.platformconfig;

import org.openqa.selenium.By;
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

public class WalletTemplatePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputWalletTemplateName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputWalletTemplateDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[contains(@id, 'walletFields')]")
    private WebElement walletDropdown;
    @FindBy(xpath = "//div[contains(@id, 'pouchFields')]")
    private WebElement pouchDropdown;
    @FindBy(xpath = "//span[text()='Add Field']/parent::button")
    private WebElement addFieldButton;
    @FindBy(xpath = "//span[text()='OK']/parent::button")
    private WebElement deleteConfirmationButton;
    public WalletTemplatePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getWalletTemplatePageURL() {
        return driver.getCurrentUrl();
    }
    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void fillWalletTemplateDetail(String name, String description, String wallet, String pouch){
        nameField.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(addFieldButton)).click();
        wait.until(ExpectedConditions.visibilityOf(walletDropdown)).click();
        driver.findElement(By.xpath("//li[text() = '" + wallet + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(pouchDropdown)).click();
        driver.findElement(By.xpath("//li[text() = '" + pouch + "']")).click();
    }
    public void clickSaveButton(){
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void verifyWalletTemplateIsCreated(String walletTemplateName){
        String actualWalletName = driver.findElement(By.xpath("//td[text()='" + walletTemplateName + "']")).getText();
        Assert.assertEquals(actualWalletName, walletTemplateName);
    }
    public void clickViewIcon(String walletTemplate){
        driver.findElement(By.xpath("//td[contains(text(),'" + walletTemplate + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteWalletTemplate(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(deleteConfirmationButton)).click();
    }
    public void updateWalletTemplate(String description, String wallet, String pouch){
        descriptionField.clear();
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(walletDropdown)).click();
        driver.findElement(By.xpath("//li[text() = '" + wallet + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(pouchDropdown)).click();
        driver.findElement(By.xpath("//li[text() = '" + pouch + "']")).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
}
