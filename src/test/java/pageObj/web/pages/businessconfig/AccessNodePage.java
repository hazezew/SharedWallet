package pageObj.web.pages.businessconfig;

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

public class AccessNodePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputPapaccessnodeName']")
    private WebElement nameInput;
    @FindBy(xpath = "//textarea[@id='inputPapaccessnodeDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputPapaccessnodeType']")
    private WebElement accessTypeDropdown;
    @FindBy(xpath = "//textarea[@id='inputPapaccessnodeMessage ']")
    private WebElement messageField;
    @FindBy(xpath = "//div[@id='inputPapaccessnodeErrorcode']")
    private WebElement responseCodeDropdown;
    @FindBy(xpath = "//div[@id='inputPapaccessnodeEditType']")
    private WebElement editAccessTypeDropdown;
    @FindBy(xpath = "inputPapaccessnodeEditMessage']")
    private WebElement editMessageField;


    public AccessNodePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getAccessNodePageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addAccessNode(String name, String description, String accessType, String message, String accessCode){
        nameInput.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(accessTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + accessType + "']")).click();
        if(accessType.equals("Block")){
            wait.until(ExpectedConditions.visibilityOf(responseCodeDropdown)).click();
            driver.findElement(By.xpath("//li[text()='" + accessCode + "']")).click();
        }
        messageField.sendKeys(message);

    }
    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyAccessNodeCreated(String accessNodeName){
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + accessNodeName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, accessNodeName);
    }
    public void clickViewIcon(String accessNodeName){
        driver.findElement(By.xpath("//td[contains(text(),'" + accessNodeName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteAccessNode(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
}
