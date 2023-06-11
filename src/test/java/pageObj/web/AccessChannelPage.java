package pageObj.web;

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
import java.util.Locale;

public class AccessChannelPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputAccesschannelName']")
    private WebElement nameInputField;
    @FindBy(xpath = "//textarea[@id='inputAccesschannelDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//input[@id='inputAccesschannelSecret']")
    private WebElement secretField;
    @FindBy(xpath = "//input[@id='inputAccesschannelConfirmSecret']")
    private WebElement confirmSecretField;
    @FindBy(xpath = "//button[@id='inputAccesschannelEccEnable']")
    private WebElement eccEnableButton;
    @FindBy(xpath = "//button[@id='inputAccesschannelExpiryEnable']")
    private WebElement enableExpiryButton;
    @FindBy(xpath = "//input[@id='inputAccesschannelAccessTokenValidity']")
    private WebElement accessTokenValidity;
    @FindBy(xpath = "//input[@id='inputAccesschannelIdleExpiry']")
    private WebElement accessTokenExpiry;
    @FindBy(xpath = "//div[@class='ant-form-explain']")
    private WebElement validationLabel;
    public AccessChannelPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getAccessChannelPageURL() {
        return driver.getCurrentUrl();
    }
    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void fillAccessChannelDetail(String name, String description, String secret, String confirmSecret){
        nameInputField.clear();
        nameInputField.sendKeys(name);
        descriptionField.clear();
        descriptionField.sendKeys(description);
        secretField.clear();
        secretField.sendKeys(secret);
        confirmSecretField.clear();
        confirmSecretField.sendKeys(confirmSecret);

    }
    public void verifyConfirmationValidation(String validation){
        String actualValidation = validationLabel.getText();
        Assert.assertEquals(actualValidation, validation);
    }
    public void setExpiryAndAccessToken(String tokenValidity, String tokenExpiry){
        wait.until(ExpectedConditions.visibilityOf(eccEnableButton)).click();
        wait.until(ExpectedConditions.visibilityOf(enableExpiryButton)).click();
        accessTokenValidity.sendKeys(tokenValidity);
        accessTokenExpiry.sendKeys(tokenExpiry);
    }
    public void clickSaveButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyAccessChannelCreated(String accessChannelName){
        String actualUnitName = driver.findElement(By.xpath("//td[text()='" + accessChannelName + "']")).getText();
        Assert.assertEquals(actualUnitName, accessChannelName);
    }
    public void clickOnViewIcon(String accessChannelName){
        driver.findElement(By.xpath("//td[contains(text(),'" + accessChannelName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteAccessChannel(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateAccessChannel(String description, String tokenValidity, String tokenExpiry){
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(eccEnableButton)).click();
        accessTokenValidity.sendKeys(tokenValidity);
        accessTokenExpiry.sendKeys(tokenExpiry);
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

    public void enterNameInToSearchField(String unitName) {
        searchInputField.sendKeys(unitName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyAccessChannelSearchResults(String unitName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + unitName + "')]"));
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
