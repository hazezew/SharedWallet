package pageObj.web.pages.businessconfig;

import io.cucumber.java.bm.Diberi;
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

public class ResponseNodePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputResponsenodeName']")
    private WebElement nameInputField;
    @FindBy(xpath = "//textarea[@id='inputResponsenodeDescription']")
    private WebElement descriptionInputField;
    @FindBy(xpath = "//input[@id='inputResponsenodeMessage']")
    private WebElement messageInputField;
    @FindBy(xpath = "//div[@id='inputResponsenodeResponsecode']")
    private WebElement responseCodeDropdown;
    @FindBy(xpath = "//textarea[@id='inputResponsenodeEditDescription']")
    private WebElement desciptionEditField;
    @FindBy(xpath = "//input[@id='inputResponsenodeEditMessage']")
    private WebElement messageEditField;

    public ResponseNodePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getResponseNodePageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addResponseNode(String name, String description, String message, String responseCode){
        nameInputField.sendKeys(name);
        descriptionInputField.sendKeys(description);
        messageInputField.sendKeys(message);
        wait.until(ExpectedConditions.visibilityOf(responseCodeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + responseCode + "']")).click();
    }
    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyResponseNodeCreated(String responseNodeName){
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + responseNodeName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, responseNodeName);
    }
    public void clickViewIcon(String responseNodeName){
        driver.findElement(By.xpath("//td[contains(text(),'" + responseNodeName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteResponseNode(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateResponseNode(String description, String responseCode, String message){
        desciptionEditField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(responseCodeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + responseCode + "']")).click();
        messageEditField.clear();
        messageEditField.sendKeys(message);
    }
    public void verifyErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
    public void verifyValidationMessage(){
        boolean allValidationMessagesDisplayed = true;
        for (WebElement msg : validationMessages) {
            if (!msg.isDisplayed()) {
                allValidationMessagesDisplayed = false;
                break;
            }
        }
        Assert.assertTrue(allValidationMessagesDisplayed, "All validation messages are not displayed");
    }


    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String responseNodeName) {
        searchInputField.sendKeys(responseNodeName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyResponseNodeSearchResults(String responseNodeName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + responseNodeName + "')]"));
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
