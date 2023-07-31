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

public class RoleConfigPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputrolesRole']")
    private WebElement roleNameField;
    @FindBy(xpath = "//div[@id='inputrolesUserCategory']")
    private WebElement userCategoryDropdown;
    @FindBy(xpath = "//textarea[@id='inputrolesDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[text()='Platform Config']")
    private WebElement platformConfigModule;
    @FindBy(xpath = "//div[text()='Business Config']")
    private WebElement businessConfigModule;
    @FindBy(xpath = "//div[text()='Operator Config']")
    private WebElement operatorConfigModule;
    @FindBy(xpath = "(//div[text()='ADD']//input[@type='checkbox'])[1]")
    private WebElement addCheckboxForPlatformConfig;
    @FindBy(xpath = "(//div[text()='ADD']//input[@type='checkbox'])[2]")
    private WebElement addCheckboxForBusinessConfig;
    @FindBy(xpath = "(//div[text()='ADD']//input[@type='checkbox'])[2]")
    private WebElement addCheckboxForOperatorConfig;

    public RoleConfigPage(WebDriver driver) {
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

    public void addRole(String roleName, String description, String userCategory) {
        roleNameField.sendKeys(roleName);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(userCategoryDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + userCategory + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(platformConfigModule)).click();
        wait.until(ExpectedConditions.visibilityOf(addCheckboxForPlatformConfig)).click();
        platformConfigModule.click();
        businessConfigModule.click();
        wait.until(ExpectedConditions.visibilityOf(addCheckboxForBusinessConfig)).click();
        businessConfigModule.click();
        operatorConfigModule.click();
        wait.until(ExpectedConditions.visibilityOf(addCheckboxForOperatorConfig)).click();
        operatorConfigModule.click();
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void verifyRoleCreated(String roleName) {
        String actualRoleName = driver.findElement(By.xpath("//td[text()='" + roleName + "']")).getText();
        Assert.assertEquals(actualRoleName, roleName);
    }

    public void clickViewIcon(String roleName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + roleName + "')]/preceding-sibling::td[2]")).click();
    }

    public void deleteRole() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }

    public void verifyValidationMessage() {
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

    public void enterNameInToSearchField(String roleName) {
        searchInputField.sendKeys(roleName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyRoleSearchResults(String roleName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + roleName + "')]"));
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
