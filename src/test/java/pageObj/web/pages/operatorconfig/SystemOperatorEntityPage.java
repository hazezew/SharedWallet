package pageObj.web.pages.operatorconfig;

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

public class SystemOperatorEntityPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputSystemoperatorentityName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputSystemoperatorentityDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputSystemoperatorentityUsercategory']")
    private WebElement userCategoryDropdown;
    @FindBy(xpath = "//div[@id='inputSystemoperatorentityBusinessZone']")
    private WebElement businessZoneDropdown;
    @FindBy(xpath = "//div[@id='inputSystemoperatorentityPlatformAccessProfile']")
    private WebElement papDropdown;
    @FindBy(xpath = "//div[@id='inputSystemoperatorentityKYC']")
    private WebElement kycDropdown;
    @FindBy(xpath = "//div[@id='inputSystemoperatorentityKYCLevel']")
    private WebElement kycLevelDropdown;
    @FindBy(xpath = "//div[@id='inputSystemoperatorentityRole']")
    private WebElement roleDropdown;
    @FindBy(xpath = "inputSystemoperatorentityTimeZone")
    private WebElement timeZoneDropdown;

    public SystemOperatorEntityPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void clickDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath("//li[text()='" + dropdownOption + "']")).click();
    }

    public void addSystemOperatorEntity(String name, String description, String userCategory, String businessZone, String pap, String kyc, String kycLevel, String role, String timeZone) {
        nameField.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(userCategoryDropdown)).click();
        clickDropdownOption(userCategory);
        wait.until(ExpectedConditions.visibilityOf(businessZoneDropdown)).click();
        clickDropdownOption(businessZone);
        wait.until(ExpectedConditions.visibilityOf(papDropdown)).click();
        clickDropdownOption(pap);
        wait.until(ExpectedConditions.visibilityOf(kycDropdown)).click();
        clickDropdownOption(kyc);
        wait.until(ExpectedConditions.visibilityOf(kycLevelDropdown)).click();
        clickDropdownOption(kycLevel);
        wait.until(ExpectedConditions.visibilityOf(roleDropdown)).click();
        clickDropdownOption(role);
        wait.until(ExpectedConditions.visibilityOf(timeZoneDropdown)).click();
        clickDropdownOption(timeZone);
    }
    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifySOECreated(String soeName){
        String actualSOEName = driver.findElement(By.xpath("//td[text()='" + soeName + "']")).getText();
        Assert.assertEquals(actualSOEName, soeName);
    }
    public void clickViewIcon(String soeName){
        driver.findElement(By.xpath("//td[contains(text(),'" + soeName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteSOE(){
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
    public void verifyErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
        wait.until(ExpectedConditions.visibilityOf(backButton)).click();
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String soeName) {
        searchInputField.sendKeys(soeName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifySOESearchResults(String soeName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + soeName + "')]"));
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
