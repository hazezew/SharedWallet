package pageObj.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class ProductGroupPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputProductgroupName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputProductgroupDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputProductgroupProduct']")
    private WebElement productDropdown;
    @FindBy(xpath = "//span[text()='Settlement Detail']")
    private WebElement settlementTab;
    @FindBy(xpath = "//button[@class='ant-btn addBtn ant-btn-primary']")
    private WebElement addSettlementButton;
    @FindBy(xpath = "//div[contains(@id, 'productRuleList')]")
    private WebElement ruleDropdown;
    @FindBy(xpath = "//div[contains(@id, 'productSettlement')]")
    private WebElement settlementGroupDropdown;

    public ProductGroupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getProductGroupPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addProductGroupDetail(String name, String description, String product, String status) {
        nameField.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(productDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + product + "')]")).click();
        driver.findElement(By.xpath("//span[.='Product Group Info']")).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void addSettlementGroup(String rule, String settlementGroup) {
        wait.until(ExpectedConditions.visibilityOf(settlementTab)).click();
        wait.until(ExpectedConditions.visibilityOf(addSettlementButton)).click();
        wait.until(ExpectedConditions.visibilityOf(ruleDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + rule + "')]")).click();
        wait.until(ExpectedConditions.visibilityOf(settlementGroupDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + settlementGroup + "')]")).click();
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyProductGroupIsCreated(String productGroup){
        String actualPouchName = driver.findElement(By.xpath("//td[text()='" + productGroup + "']")).getText();
        Assert.assertEquals(actualPouchName, productGroup);
    }
    public void clickViewIcon(String productGroupName){
        driver.findElement(By.xpath("//td[contains(text(),'" + productGroupName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteProductGroup(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        okConfirmationButton.click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateProductGroup(String description, String product, String status){
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(productDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + product + "')]")).click();
        driver.findElement(By.xpath("//span[.='Product Group Info']")).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
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
    public void clickFilterButton(){
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectFilterCriteria(String criteria){
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void fillSearchInput(String productGroupName){
        searchInputField.sendKeys(productGroupName);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifySearchResult(String productGroupName){
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + productGroupName + "')]"));
        boolean searchResultOnTable = true;
        for (WebElement msg : searchResults) {
            if (!msg.isDisplayed()) {
                searchResultOnTable = false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
    }
    public void verifyErrorMessageForDuplicatedName(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
}