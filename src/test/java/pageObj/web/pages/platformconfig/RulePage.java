package pageObj.web.pages.platformconfig;

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

public class RulePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputRuleName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputRuleDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//input[@id='inputRuleExpression']")
    private WebElement expressionField;
    @FindBy(xpath = "//div[@id='inputRuleAddUsedBy']")
    private WebElement usedByDropdown;
    @FindBy(xpath = "//textarea[@id='inputRuleEditDescription']")
    private WebElement editDescriptionField;
    @FindBy(xpath = "//input[@id='inputRuleEditExpression']")
    private WebElement editExpressionField;
    @FindBy(xpath = "//span[@id='inputRuleViewDescription']")
    private WebElement descriptionView;

    public RulePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getRulePageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addRuleDetail(String name, String description, String expression, String usedBy, String status) {
        nameField.sendKeys(name);
        descriptionField.sendKeys(description);
        expressionField.sendKeys(expression);
        wait.until(ExpectedConditions.visibilityOf(usedByDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + usedBy + "')]")).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void clickSaveButton(String status) {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
        if (status.equals("Inactive")) {
            wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
        }
    }

    public void verifyRuleCreated(String ruleName) {
        String actualUnitName = driver.findElement(By.xpath("//td[text()='" + ruleName + "']")).getText();
        Assert.assertEquals(actualUnitName, ruleName);
    }

    public void clickOnViewIcon(String ruleName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + ruleName + "')]/preceding-sibling::td[2]")).click();
    }

    public void clickDeleteButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }

    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }

    public void updateRuleConfig(String description, String expression) {
        editDescriptionField.sendKeys(description);
        editExpressionField.clear();
        editExpressionField.sendKeys(expression);
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
    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void enterNameInToSearchField(String unitName) {
        searchInputField.sendKeys(unitName);
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifyRuleSearchResults(String ruleName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + ruleName + "')]"));
        boolean searchResultOnTable = true;
        for (WebElement msg : searchResults) {
            if (!msg.isDisplayed()) {
                searchResultOnTable = false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
    }
    public void verifyValidationMessageForDuplicateName(String validationMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, validationMessage);
    }
}