package pageObj.web.pages.businessconfig;

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
import java.util.List;

public class NotificationPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputNotificationADDName']")
    private WebElement nameField;
    @FindBy(xpath = "//div[@id='inputNotificationADDNotificationtype']")
    private WebElement notificationTypeDropdown;
    @FindBy(xpath = "//textarea[@id='inputNotificationADDDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputNotificationAddNotificationcategory']")
    private WebElement notificationCategoryDropdown;
    @FindBy(xpath = "//div[@id='inputNotificationAddVendorservice']")
    private WebElement vendorServiceDropdown;
    @FindBy(xpath = "//div[@id='inputNotificationAddVendor']")
    private WebElement vendorDropdown;
    @FindBy(xpath = "//div[text()='Receiver Details']")
    private WebElement receiverTab;
    @FindBy(xpath = "//div[text()='Notification Details']")
    private WebElement notificationTab;
    @FindBy(xpath = "//input[contains(@id,'AddReciver')]")
    private WebElement receiverNameInput;
    @FindBy(xpath = "//input[@id='inputNotificationAddUsername']")
    private WebElement fromUsernameInput;
    @FindBy(xpath = "//div[@id='inputNotificationAddNotificationerrorcode']")
    private WebElement errorCodeDropdown;

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getNotificationPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addNotification(String name, String notificationType, String description, String notificationCategory, String vendor, String vendorService, String mobileNumber, String fromEmail, String email){
        nameField.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(notificationTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + notificationType + "']")).click();
        if(notificationType.equals("EMAIL")){
            fromUsernameInput.sendKeys(fromEmail);
        }
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(notificationCategoryDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + notificationCategory + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(vendorDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + vendor + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(vendorServiceDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + vendorService + "']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(receiverTab)).click();
        if(notificationType.equals("EMAIL")){
            receiverNameInput.sendKeys(email);
        }
        else if (notificationType.equals("SMS")) {
            receiverNameInput.sendKeys(mobileNumber);
        }
        wait.until(ExpectedConditions.visibilityOf(notificationTab)).click();
    }
    public void clickSaveButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyNotificationCreated(String notificationName){
        String actualNotificationName = driver.findElement(By.xpath("//td[text()='" + notificationName + "']")).getText();
        Assert.assertEquals(actualNotificationName, notificationName);
    }
    public void clickViewIcon(String notificationName){
        driver.findElement(By.xpath("//td[contains(text(),'" + notificationName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteNotification(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateNotification(String notificationType, String username, String category, String errorCode, String email){
        wait.until(ExpectedConditions.visibilityOf(notificationTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + notificationType + "']")).click();
        fromUsernameInput.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(notificationCategoryDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + category + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(notificationTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + notificationType + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(errorCodeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + errorCode + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(receiverTab)).click();
        receiverNameInput.sendKeys(email);
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
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String notificationName) {
        searchInputField.sendKeys(notificationName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyNotificationSearchResults(String notificationName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + notificationName + "')]"));
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