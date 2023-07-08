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

public class ServiceVendorPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputServicesName']")
    private WebElement nameField;
    @FindBy(xpath = "//div[@id='inputServicesAddVendorType']")
    private WebElement vendorTypeDropdown;
    @FindBy(xpath = "//div[@id='inputVendorService']")
    private WebElement vendorServiceDropdown;
    @FindBy(xpath = "//textarea[@id='inputServicesAddDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "(//div[contains(@id, 'servicevendor')])[1]")
    private WebElement vendorServiceRuleDropdown;
    @FindBy(xpath = "(//div[contains(@id, 'servicevendor')])[2]")
    private WebElement selectionAlgorithmDropdown;
    @FindBy(xpath = "(//div[contains(@id, 'servicevendor')])[3]")
    private WebElement sortingFunctionDropdown;
    @FindBy(xpath = "(//div[contains(@id, 'servicevendor')])[4]")
    private WebElement lcrDropdown;
    @FindBy(xpath = "//div[@id='inputServicesVendorId']")
    private WebElement editVendorServiceDropdown;
    @FindBy(xpath = "//textarea[@id='inputServicesDescription']")
    private WebElement editDescriptionField;
    @FindBy(xpath = "//input[@name='vendorName']")
    private WebElement searchNameField;

    public ServiceVendorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getServiceVendorPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void fillServiceVendorDetail(String name, String vendorTyp, String vendorService, String description) {
        nameField.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(vendorTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + vendorTyp + "']")).click();

        wait.until(ExpectedConditions.visibilityOf(vendorServiceDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + vendorService + "']")).click();
        descriptionField.sendKeys(description);
    }

    public void selectStatus(String status) {
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void fillExtraDetail(String vendorServiceRule, String selectionAlgorithm, String sortingFunction, String lcr) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");

        wait.until(ExpectedConditions.visibilityOf(vendorServiceRuleDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + vendorServiceRule + "']")).click();

        wait.until(ExpectedConditions.visibilityOf(selectionAlgorithmDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + selectionAlgorithm + "']")).click();
        if(selectionAlgorithm.equals("LCR"))
        {
        wait.until(ExpectedConditions.visibilityOf(sortingFunctionDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + sortingFunction + "']")).click();

        wait.until(ExpectedConditions.visibilityOf(lcrDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + lcr + "']")).click();
    }}
    public void clickSaveButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyServiceVendorCreated(String serviceVendorName){
        String actualServiceVendorName = driver.findElement(By.xpath("//td[text()='" + serviceVendorName + "']")).getText();
        Assert.assertEquals(actualServiceVendorName, serviceVendorName);
    }
    public void clickViewIcon(String serviceVendorName){
        driver.findElement(By.xpath("//td[contains(text(),'" + serviceVendorName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteServiceVendor(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
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
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateServiceVendor(String vendorService, String description){
        wait.until(ExpectedConditions.visibilityOf(editVendorServiceDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + vendorService + "']")).click();
        editDescriptionField.sendKeys(description);
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String serviceVendorName) {
        searchNameField.sendKeys(serviceVendorName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyServiceVendorSearchResults(String serviceVendorName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + serviceVendorName + "')]"));
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
