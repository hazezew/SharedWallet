package pageObj.web;

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

public class UnitPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id='inputUnitName']")
    private WebElement unitNameInputField;
    @FindBy(xpath = "//textarea[@id='inputUnitDescription']")
    private WebElement unitDescriptionField;
    @FindBy(xpath = "//div[@id='inputunitType']")
    private WebElement inputTypeDropdown;
    @FindBy(xpath = "//div[@id='inputsubunitType']")
    private WebElement subUnitTypeDropdown;
    @FindBy(xpath = "//button[@class='ant-btn addBtn ant-btn-primary']")
    private WebElement addParameterButton;

    public UnitPage(WebDriver driver) {
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

    public void fillUnitDetail(String unitName, String unitDes, String unitType, String subUnitType) {
        unitNameInputField.sendKeys(unitName);
        unitDescriptionField.sendKeys(unitDes);
        wait.until(ExpectedConditions.visibilityOf(inputTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + unitType + "')]")).click();
        if (unitType.equals("NONMONETARY")) {
            wait.until(ExpectedConditions.visibilityOf(subUnitTypeDropdown)).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + subUnitType + "')]")).click();
        }
    }

    public void selectStatus(String status) {
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void clickSaveButton(String status) {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
        if (status.equals("Inactive")) {
            wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
        }
    }

    public void clickOnViewIcon(String unitName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + unitName + "')]/preceding-sibling::td[2]")).click();
    }

    public void verifyUnitCreated(String unitName) {
        String actualUnitName = driver.findElement(By.xpath("//td[text()='" + unitName + "']")).getText();
        Assert.assertEquals(actualUnitName, unitName);
    }

    public void clickDeleteButton() {
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

    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }

    public void updateUnitConfig(String description, String unitType, String subUnitType) {
        unitDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(inputTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + unitType + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(subUnitTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + subUnitType + "')]")).click();
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
    public void verifyValidationMessageForDuplicateName(String validationMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, validationMessage);
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyUnitSearchResults(String unitName) {
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