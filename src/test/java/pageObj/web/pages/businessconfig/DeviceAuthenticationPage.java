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

public class DeviceAuthenticationPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputdeviceauthenticationAddName']")
    private WebElement nameInput;
    @FindBy(xpath = "//textarea[@id='inputdeviceauthenticationAddDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//input[@id='inputdeviceauthenticationAddGeoRadius']")
    private WebElement allowedGeoRadiusInput;
    @FindBy(xpath = "//div[@id='inputdeviceauthenticationAddDeviceStatus']")
    private WebElement allowedDeviceStatusDropdown;
    @FindBy(xpath = "//div[@id='inputdeviceauthenticationAddDevicePacketField']")
    private WebElement packetFieldDropdown;
    @FindBy(xpath = "//input[@id='inputdeviceauthenticationAddParamstr1']")
    private WebElement parameter1Input;
    @FindBy(xpath = "//textarea[@id='inputdeviceauthenticationEditDescription']")
    private WebElement editDescriptionInput;
    @FindBy(xpath = "//input[@id='inputdeviceauthenticationEditGeoRadius']")
    private WebElement editRadiusInput;
    @FindBy(xpath = "//div[@id='inputdeviceauthenticationEditDeviceStatus']")
    private WebElement editStatusDropdown;
    @FindBy(xpath = "//input[@id='inputdeviceauthenticationEditParamstr2']")
    private WebElement parameter2Input;
    public DeviceAuthenticationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getDeviceAuthenticationPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addDeviceAuthentication(String name, String description, String allowedGeoRadius, String deviceStatus, String packetField, String parameter1){
        nameInput.sendKeys(name);
        descriptionField.sendKeys(description);
        allowedGeoRadiusInput.sendKeys(allowedGeoRadius);
        wait.until(ExpectedConditions.visibilityOf(allowedDeviceStatusDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + deviceStatus + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(packetFieldDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + packetField + "']")).click();
        parameter1Input.sendKeys(parameter1);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyDeviceAuthenticationCreated(String deviceAuthenticationName){
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + deviceAuthenticationName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, deviceAuthenticationName);
    }
    public void clickViewIcon(String deviceAuthenticationName){
        driver.findElement(By.xpath("//td[contains(text(),'" + deviceAuthenticationName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteDeviceAuthentication(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateDeviceAuthentication(String description, String radius, String status, String parameter){
        editDescriptionInput.clear();
        editDescriptionInput.sendKeys(description);
        editRadiusInput.clear();
        editRadiusInput.sendKeys(radius);
        wait.until(ExpectedConditions.visibilityOf(editStatusDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + status + "']")).click();
        parameter2Input.sendKeys(parameter);
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

    public void enterNameInToSearchField(String deviceAuthenticationName) {
        searchInputField.sendKeys(deviceAuthenticationName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyDeviceAuthenticationSearchResults(String deviceAuthenticationName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + deviceAuthenticationName + "')]"));
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
