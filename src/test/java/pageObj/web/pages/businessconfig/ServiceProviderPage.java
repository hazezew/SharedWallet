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

public class ServiceProviderPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputServicesName']")
    private WebElement nameField;
    @FindBy(xpath = "//div[@id='inputProviderService']")
    private WebElement providerServiceDropdown;
    @FindBy(xpath = "//div[@id='inputServiceProviderAddOperatingEntity']")
    private WebElement oetDropdown;
    @FindBy(xpath = "//textarea[@id='inputAddProviderDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//input[@id='inputProviderApiName']")
    private WebElement providerApiNameField;
    @FindBy(xpath = "//input[@id='inputEditServiceProviderAPIname']")
    private WebElement providerApiNameEditInput;
    @FindBy(xpath = "//div[@id='inputCommunicationProtocol']")
    private WebElement commProtocolDropdown;
    @FindBy(xpath = "//input[@id='inputSuccessCode']")
    private WebElement successCodeField;
    @FindBy(xpath = "//input[@id='inputFailureCode']")
    private WebElement failureCodeField;
    @FindBy(xpath = "//input[@id='inputApiUrl']")
    private WebElement apiUrlField;
    @FindBy(xpath = "//input[@id='inputEditServiceProviderAPIurl']")
    private WebElement apiUrlEditInput;
    @FindBy(xpath = "//div[@id='inputHttpType']")
    private WebElement httpTypeDropdown;
    @FindBy(xpath = "//div[@id='inputEditServiceProviderHttpType']")
    private WebElement httpTypeEditDropdown;
    @FindBy(xpath = "//div[@id='inputHttpProtocol']")
    private WebElement httpProtocolDropdown;
    @FindBy(xpath = "//div[@id='inputResponseType']")
    private WebElement responseTypeDropdown;
    @FindBy(xpath = "//div[@id='inputRequestType']")
    private WebElement requestTypeDropdown;
    @FindBy(xpath = "(//span[text()='Add field']/parent::button)[1]")
    private WebElement addFieldButtonForHeader;
    @FindBy(xpath = "(//span[text()='Add field']/parent::button)[2]")
    private WebElement addFieldButtonForRequest;
    @FindBy(xpath = "//th[span[text()='Mapping Detail Type']]/following-sibling::th[2]")
    private WebElement addFieldButtonForResponse;
    @FindBy(xpath = "//input[@name='headerMappingMobifinPacketField']")
    private WebElement headerPacketFieldInput;
    @FindBy(xpath = "//input[@name='headerMappingApiField']")
    private WebElement headerApiFieldInput;
    @FindBy(xpath = "//input[@name='headerMappingDeafultValueField']")
    private WebElement headerDefaultValueFieldInput;
    @FindBy(xpath = "//input[@name='requestMappingApiField']")
    private WebElement requestApiFieldInput;
    @FindBy(xpath = "//input[@name='requestMappingMobifinPacketField']")
    private WebElement requestPacketFieldInput;
    @FindBy(xpath = "//input[@name='requestMappingDefaultValueField']")
    private WebElement requestDefaultValueFieldInput;
    @FindBy(xpath = "//input[@name='responseMappingApiField']")
    private WebElement responseApiFieldInput;
    @FindBy(xpath = "//input[@name='responseMappingMobifinPacketField']")
    private WebElement responsePacketFieldInput;
    @FindBy(xpath = "//input[@name='responseMappingDefaultValueField']")
    private WebElement responseDefaultValueFieldInput;
    @FindBy(xpath = "(//div[@class='steps-action']/button[@type='submit'])[1]")
    private WebElement submitButton;
    @FindBy(xpath = "(//span[text()='Next']/parent::button)[1]")
    private WebElement nextButton;
    @FindBy(xpath = "//textarea[@id='inputServicesApiTemplate']")
    private WebElement apiTemplateTextArea;
    @FindBy(xpath = "//textarea[@id='inputEditApiTemplate']")
    private WebElement apiTemplateEditTextArea;
    @FindBy(xpath = "//button[@id='operationbarbuttonaddservice']")
    private WebElement addServiceButton;
    public ServiceProviderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getServiceProviderPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addServiceProviderDetail(String name, String providerService, String oEt, String description) {
        nameField.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(providerServiceDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + providerService + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(oetDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + oEt + "']")).click();
        descriptionField.sendKeys(description);
        clickNextButton();
    }

    public void addProviderApiDetail(String providerName, String commProtocol, String successCode, String failureCode) {
        providerApiNameField.sendKeys(providerName);
        wait.until(ExpectedConditions.visibilityOf(commProtocolDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + commProtocol + "']")).click();
        successCodeField.sendKeys(successCode);
        failureCodeField.sendKeys(failureCode);
        clickNextButton();
    }

    public void addApiDetail(String apiUrl, String httpType, String httpProtocol, String requestType, String responseType) {
        apiUrlField.sendKeys(apiUrl);
        wait.until(ExpectedConditions.visibilityOf(httpTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + httpType + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(httpProtocolDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + httpProtocol + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(requestTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + requestType + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(responseTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + responseType + "']")).click();
        clickNextButton();
    }

    public void addHeaderMappingDetail(String apiField, String packetField, String defaultValue) {
        wait.until(ExpectedConditions.visibilityOf(addFieldButtonForHeader)).click();
        headerApiFieldInput.sendKeys(apiField);
        headerPacketFieldInput.sendKeys(packetField);
        headerDefaultValueFieldInput.sendKeys(defaultValue);
        clickNextButton();
    }

    public void addRequestMappingDetail(String httpType, String apiField, String packetField, String defaultValue, String apiTemplate) {
        if (httpType.equals("Get")) {
            wait.until(ExpectedConditions.visibilityOf(addFieldButtonForRequest)).click();
            requestApiFieldInput.sendKeys(apiField);
            requestPacketFieldInput.sendKeys(packetField);
            requestPacketFieldInput.sendKeys(defaultValue);
        } else if (httpType.equals("Post")) {
            apiTemplateTextArea.sendKeys(apiTemplate);
        }
        clickNextButton();
    }

    public void addResponseMappingDetail(String apiField, String packetField, String defaultValue) {
        wait.until(ExpectedConditions.visibilityOf(addFieldButtonForResponse)).click();
        responseApiFieldInput.sendKeys(apiField);
        responsePacketFieldInput.sendKeys(packetField);
        responseDefaultValueFieldInput.sendKeys(defaultValue);
        clickNextButton();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
    }
    public void verifyServiceProviderCreated(String serviceProviderName){
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + serviceProviderName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, serviceProviderName);
    }
    public void clickViewIcon(String serviceProviderName){
        driver.findElement(By.xpath("//td[contains(text(),'" + serviceProviderName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteServiceProvider(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
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
    public void clickAddServiceButton(){
        wait.until(ExpectedConditions.visibilityOf(addServiceButton)).click();
    }
    public void addProviderService(String providerServiceName){
        wait.until(ExpectedConditions.visibilityOf(providerServiceDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + providerServiceName + "']")).click();
        clickNextButton();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateServiceProvider(String OET, String api, String apiUrl, String httpType, String template){
        wait.until(ExpectedConditions.visibilityOf(oetDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + OET + "']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");
        clickNextButton();
        providerApiNameEditInput.clear();
        providerApiNameEditInput.sendKeys(api);
        clickNextButton();
        apiUrlEditInput.clear();
        apiUrlEditInput.sendKeys(apiUrl);
        wait.until(ExpectedConditions.visibilityOf(httpTypeEditDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + httpType + "']")).click();
        clickNextButton();
        clickNextButton();
        apiTemplateEditTextArea.sendKeys(template);
        js.executeScript("window.scrollTo(0, 300)");
        clickNextButton();
        clickNextButton();
        js.executeScript("window.scrollTo(0, 300)");
        clickNextButton();
        clickNextButton();
    }
    public void clickNextButton(){
        wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
    }
    public void verifyErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String serviceProviderName) {
        searchInputField.sendKeys(serviceProviderName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyServiceProviderSearchResults(String serviceProviderName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + serviceProviderName + "')]"));
        boolean searchResultOnTable = true;
        for (WebElement msg : searchResults) {
            if (!msg.isDisplayed()) {
                searchResultOnTable = false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
    }

    public void clickExportButton(){
        wait.until(ExpectedConditions.visibilityOf(exportButton)).click();
    }
    public void fillExportDetail(String name, String description){
        exportNameField.sendKeys(name);
        exportDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(exportSaveButton)).click();
    }
    public void clickExportHistoryButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOf(exportHistoryButton)).click();
    }
    public void verifyExportHistory(String exportName){
        WebElement exportHistory= driver.findElement(By.xpath("//td[text()='"+exportName+"']"));
        Assert.assertTrue(exportHistory.isDisplayed());
        Assert.assertTrue(downloadButton.isEnabled());
        downloadButton.click();
        Assert.assertTrue(downloadProgressSuccess.isDisplayed(),"download success message is not displayed");
    }
}
