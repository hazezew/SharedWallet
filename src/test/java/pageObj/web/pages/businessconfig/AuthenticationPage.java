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
import java.util.List;

public class AuthenticationPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputAuthenticationName']")
    private WebElement nameInput;
    @FindBy(xpath = "//textarea[@id='inputAuthenticationDescription']")
    private WebElement descriptionInput;
    @FindBy(xpath = "//div[@id='inputAuthenticationPAPnodetype']")
    private WebElement papNodeDropdown;
    @FindBy(xpath = "//div[@id='inputAuthenticationValueType']")
    private WebElement authenticationTypeDropdown;
    @FindBy(xpath = "//div[@id='inputAuthenticationCredentialParameter']")
    private WebElement credParameterDropdown;
    @FindBy(xpath = "//div[@id='inputAuthenticationauthtwotypefector']")
    private WebElement faTypeDropdown;
    @FindBy(xpath = "//input[@id='inputAuthenticationLength']")
    private WebElement lengthInput;
    @FindBy(xpath = "//input[@id='inputAuthenticationPacketField']")
    private WebElement packetInput;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getAuthenticationPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addAuthenticationConfig(String name, String description, String papType, String authenticationType, String credParameter, String faType, String length, String packet){
        nameInput.sendKeys(name);
        descriptionInput.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(papNodeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + papType + "']")).click();
        if(papType.equals("Credential Evaluator")){
            wait.until(ExpectedConditions.visibilityOf(authenticationTypeDropdown)).click();
            driver.findElement(By.xpath("//li[text()='" + authenticationType + "']")).click();
            wait.until(ExpectedConditions.visibilityOf(credParameterDropdown)).click();
            driver.findElement(By.xpath("//li[text()='" + credParameter + "']")).click();
        }else if(papType.equals("2FA Evaluator")) {
            wait.until(ExpectedConditions.visibilityOf(faTypeDropdown)).click();
            driver.findElement(By.xpath("//li[text()='" + faType + "']")).click();
            lengthInput.sendKeys(length);
        }
        packetInput.sendKeys(packet);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyAuthenticationCreated(String authenticationName){
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + authenticationName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, authenticationName);
    }
    public void clickViewIcon(String authenticationName){
        driver.findElement(By.xpath("//td[contains(text(),'" + authenticationName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteAuthentication(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateAuthenticationConfig(String papNodeType, String faType, String length, String packetField){
        wait.until(ExpectedConditions.visibilityOf(papNodeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + papNodeType + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(faTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + faType + "']")).click();
        lengthInput.sendKeys(length);
        packetInput.sendKeys(packetField);
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

    public void enterNameInToSearchField(String authenticationName) {
        searchInputField.sendKeys(authenticationName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyAuthenticationSearchResults(String authenticationName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + authenticationName + "')]"));
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
