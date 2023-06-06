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

public class ServicePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputServicesName']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@id='inputServicesAddDisplayName[en-US]']")
    private WebElement displayNameField;
    @FindBy(xpath = "//textarea[@id='inputServicesDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputServicesAddServiceType']")
    private WebElement serviceTypeDropdown;
    @FindBy(xpath = "//div[@id='inputServicesAddServiceBehaviour']")
    private WebElement serviceBehaviorDropdown;
    @FindBy(xpath = "(//span[text()='Parameters'])[1]")
    private WebElement parametersTab;
    @FindBy(xpath = "//button[.='Add Parameter']")
    private WebElement addParameterButton;
    @FindBy(xpath = "//div[contains(@id, 'parameters')]")
    private WebElement parameterDropdown;
    @FindBy(xpath = "//input[contains(@id, 'defaultValue')]")
    private WebElement defaultValueField;
    @FindBy(xpath = "//button[contains(@id, 'visibility')]")
    private WebElement isVisibility;
    @FindBy(xpath = "//button[contains(@id, 'isMandatory')]")
    private WebElement isMandatory;
    @FindBy(xpath = "//input[@id='inputServicesEditDisplayName[en-US]']")
    private WebElement editDisplayNameField;

    public ServicePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getUnitPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addServiceDetails(String name, String displayName, String description, String serviceType, String serviceBehavior) {
        nameField.sendKeys(name);
        displayNameField.sendKeys(displayName);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(serviceTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + serviceType + "')]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(serviceBehaviorDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + serviceBehavior + "']")).click();
    }
    public void selectStatus(String status){
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }
    public void navigatesToParameterTab(){
        wait.until(ExpectedConditions.visibilityOf(parametersTab)).click();
    }
    public void addParameter(String parameter, String defaultValue) {
        wait.until(ExpectedConditions.visibilityOf(addParameterButton)).click();
        parameterDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + parameter + "']")).click();
        defaultValueField.sendKeys(defaultValue);
        wait.until(ExpectedConditions.visibilityOf(isVisibility)).click();
        wait.until(ExpectedConditions.visibilityOf(isMandatory)).click();
    }
    public void clickSaveButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyServiceIsCreated(String serviceName){
        String actualUnitName = driver.findElement(By.xpath("//td[text()='" + serviceName + "']")).getText();
        Assert.assertEquals(actualUnitName, serviceName);
    }
    public void clickViewIcon(String serviceName){
        driver.findElement(By.xpath("//td[contains(text(),'" + serviceName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteService(){
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
    public void updateService(String displayName, String serviceType, String serviceBehavior){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
        editDisplayNameField.sendKeys(displayName);
        wait.until(ExpectedConditions.visibilityOf(serviceTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + serviceType + "')]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(serviceBehaviorDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + serviceBehavior + "']")).click();
    }
    public void verifyErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
    public void clickEditIconForService(){
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectFilterCriteria(String criteria){
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void enterSearchName(String serviceName){
        searchInputField.sendKeys(serviceName);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifySearchResult(String serviceName){
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + serviceName + "')]"));
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
