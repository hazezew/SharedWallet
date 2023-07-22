package pageObj.web.pages.businessconfig;

import org.checkerframework.checker.signature.qual.FieldDescriptor;
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

public class ApiGroupPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputApigroupName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputApigroupDescription']")
    private WebElement descriptionInput;
    @FindBy(xpath = "//div[@id='inputApigroupAllowedApi']")
    private WebElement allowedApiDropdown;


    public ApiGroupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getApiGroupPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addApiGroupConfig(String name, String description, String allowedApi, String status){
        nameField.sendKeys(name);
        descriptionInput.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(allowedApiDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + allowedApi + "']")).click();
        descriptionInput.click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyApiGroupCreated(String apiGroupName){
        String actualApiGroupName = driver.findElement(By.xpath("//td[text()='" + apiGroupName + "']")).getText();
        Assert.assertEquals(actualApiGroupName, apiGroupName);
    }
    public void clickViewIcon(String apiGroupName){
        driver.findElement(By.xpath("//td[contains(text(),'" + apiGroupName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteApiGroup(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateApiGroup(String description, String allowedApi1, String allowedApi2){
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(allowedApiDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + allowedApi1 + "']")).click();
        driver.findElement(By.xpath("//li[text()='" + allowedApi2 + "']")).click();
        descriptionInput.click();

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
    public void verifyErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
        wait.until(ExpectedConditions.visibilityOf(backButton)).click();
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String apiGroupName) {
        searchInputField.sendKeys(apiGroupName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyApiGroupSearchResults(String apiGroupName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + apiGroupName + "')]"));
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
