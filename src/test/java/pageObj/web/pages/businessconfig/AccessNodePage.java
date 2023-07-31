package pageObj.web.pages.businessconfig;

import org.checkerframework.checker.signature.qual.PrimitiveType;
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
import java.util.List;

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
    @FindBy(xpath = "//textarea[@id='inputPapaccessnodeEditMessage']")
    private WebElement editMessageField;
    @FindBy(xpath = "//textarea[@id='inputPapaccessnodeEditDescription']")
    private WebElement editDescriptionField;

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

    public void addAccessNode(String name, String description, String accessType, String message, String accessCode) {
        nameInput.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(accessTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + accessType + "']")).click();
        if (accessType.equals("Block")) {
            wait.until(ExpectedConditions.visibilityOf(responseCodeDropdown)).click();
            driver.findElement(By.xpath("//li[text()='" + accessCode + "']")).click();
        }
        messageField.sendKeys(message);

    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void verifyAccessNodeCreated(String accessNodeName) {
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + accessNodeName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, accessNodeName);
    }

    public void clickViewIcon(String accessNodeName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + accessNodeName + "')]/preceding-sibling::td[2]")).click();
    }

    public void deleteAccessNode() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
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

    public void verifyErrorMessage(String errorMessage) {
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
        wait.until(ExpectedConditions.visibilityOf(backButton)).click();
    }

    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }

    public void updateAccessNode(String description, String accessType, String message, String accessCode) {
        editDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(editAccessTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + accessType + "']")).click();
        if (accessType.equals("Block")) {
            wait.until(ExpectedConditions.visibilityOf(responseCodeDropdown)).click();
            driver.findElement(By.xpath("//li[text()='" + accessCode + "']")).click();
        }
        editMessageField.clear();
        editMessageField.sendKeys(message);
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String accessNodeName) {
        searchInputField.sendKeys(accessNodeName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyAccessNodeSearchResults(String accessNodeName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + accessNodeName + "')]"));
        boolean searchResultOnTable = true;
        for (WebElement msg : searchResults) {
            if (!msg.isDisplayed()) {
                searchResultOnTable = false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
    }
}
