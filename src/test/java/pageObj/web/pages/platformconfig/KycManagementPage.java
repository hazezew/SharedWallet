package pageObj.web.pages.platformconfig;

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

public class KycManagementPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputKYCAddName']")
    private WebElement kycNameInput;
    @FindBy(xpath = "//textarea[@id='inputKYCAddDescription']")
    private WebElement kycDescriptionField;
    @FindBy(xpath = "//div[contains(@id, 'inputKYCAddLevelName')]")
    private WebElement kycLevelDropdown;
    @FindBy(xpath = "//input[contains(@id, 'inputKYCAddStepName')]")
    private WebElement kycStepNameField;
    @FindBy(xpath = "//button[.='Add Field']")
    private WebElement addFieldButton;
    @FindBy(xpath = "//button[span[text()='Add Field Group']]")
    private WebElement addFieldGroupButton;
    @FindBy(xpath = "//div[@id='inputKYCAddFieldFromLibrary']")
    private WebElement fieldLibraryDropdown;
    @FindBy(xpath = "//span[text()='Add New Step']")
    private WebElement addNewStepButton;
    @FindBy(xpath = "(//span[text()='Use as it from Library'])[2]")
    private WebElement fromLibraryButton;
    @FindBy(xpath = "//input[@id='inputParameterAddName']")
    private WebElement fieldGroupName;
    @FindBy(xpath = "//input[@id='inputParameterAddDisplayName[en-US]']")
    private WebElement fieldGroupDisplayName;
    @FindBy(xpath = "//textarea[@id='inputParameterAddDescription']")
    private WebElement fieldGroupDescription;
    @FindBy(xpath = "//div[@class='table-header-btn-group']/button[.='Add Field']")
    private WebElement addFieldInsideFieldGroupButton;
    @FindBy(xpath = "//span[text()='Load']/parent::button")
    private WebElement loadButton;
    @FindBy(xpath = "//button[span[text()='Cancel']]/following-sibling::button")
    private WebElement saveButtonForField;
    @FindBy(xpath = "//span[text()='Use as it from Library']")
    private WebElement fromLibraryButtonForGroup;

    public KycManagementPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getKycPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void fillKycNameAndDescription(String name, String description, String status) {
        kycNameInput.sendKeys(name);
        kycDescriptionField.sendKeys(description);
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void selectKycLevel(String kycLevel) {
        wait.until(ExpectedConditions.visibilityOf(kycLevelDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + kycLevel + "')]")).click();
    }

    public void clickAddNewStep() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");
        wait.until(ExpectedConditions.visibilityOf(addNewStepButton)).click();
    }

    public void enterKycStepName(String kycStepName) {
        kycStepNameField.sendKeys(kycStepName);
    }

    public void addFieldGroup(String name, String description, String displayName) {
        wait.until(ExpectedConditions.visibilityOf(addFieldGroupButton)).click();
        fieldGroupName.sendKeys(name);
        fieldGroupDisplayName.sendKeys(displayName);
        fieldGroupDescription.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(addFieldInsideFieldGroupButton)).click();
    }
    public void addParametersInToFieldGroup(String name, String mpin, String email) {
        wait.until(ExpectedConditions.visibilityOf(fromLibraryButton)).click();
        wait.until(ExpectedConditions.visibilityOf(fieldLibraryDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + name + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();

        wait.until(ExpectedConditions.visibilityOf(addFieldInsideFieldGroupButton)).click();
        wait.until(ExpectedConditions.visibilityOf(fromLibraryButton)).click();
        wait.until(ExpectedConditions.visibilityOf(fieldLibraryDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + mpin + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();

        wait.until(ExpectedConditions.visibilityOf(addFieldInsideFieldGroupButton)).click();
        wait.until(ExpectedConditions.visibilityOf(fromLibraryButton)).click();
        wait.until(ExpectedConditions.visibilityOf(fieldLibraryDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + email + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();

        wait.until(ExpectedConditions.visibilityOf(saveButtonForField)).click();
    }
    public void clickSaveButton(){
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyKycIsCreated(String kycName){
        String actualPouchName = driver.findElement(By.xpath("//a[text()='" + kycName + "']")).getText();
        Assert.assertEquals(actualPouchName, kycName);
    }
    public void clickViewIcon(String kycName){
        driver.findElement(By.xpath("//td[a[text()='"+kycName+"']]/preceding-sibling::td[3]")).click();
    }
    public void deleteKyc(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();

    }
    public void addFieldGroupFromLibrary(String fieldGroupName){
        wait.until(ExpectedConditions.visibilityOf(addFieldGroupButton)).click();
        wait.until(ExpectedConditions.visibilityOf(fromLibraryButtonForGroup)).click();
        wait.until(ExpectedConditions.visibilityOf(fieldLibraryDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + fieldGroupName + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
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
    public void verifyErrorMessageForDuplicatedName(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
    public void clickFilterButton(){
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectFilterCriteria(String criteria){
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void fillSearchInput(String kycName){
        searchInputField.sendKeys(kycName);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifySearchResult(String kycName){
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + kycName + "')]"));
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
