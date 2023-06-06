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

public class PouchPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputPouchName']")
    private WebElement pouchNameInputField;
    @FindBy(xpath = "//textarea[@id='inputPouchDescription']")
    private WebElement pouchDescriptionTextArea;
    @FindBy(xpath = "//div[@id='inputPouchType']")
    private WebElement pouchTypeDropdown;
    @FindBy(xpath = "//div[@id='inputcurrency']")
    private WebElement currencyDropdown;
    @FindBy(xpath = "//div[@id='inputPouchProvision']")
    private WebElement pouchProvisionDropdown;
    @FindBy(xpath = "//div[@id='inputPouchAllocationType']")
    private WebElement pouchAllocationDropdown;
    @FindBy(xpath = "//button[@id='inputAllowNegativeBalance']")
    private WebElement allowNegativeButton;
    @FindBy(xpath = "//button[@class='ant-btn addBtn ant-btn-primary']")
    private WebElement addParameterButton;
    @FindBy(xpath = "//div[contains(@id, 'parameter')]")
    private WebElement pouchParameter;
    @FindBy(xpath = "//input[contains(@id, 'defaultValue')]")
    private WebElement defaultValueInputField;
    @FindBy(xpath = "//button[contains(@id, 'isVisible')]")
    private WebElement isVisibleButton;
    @FindBy(xpath = "//button[contains(@id, 'isMandatory')]")
    private WebElement isMandatoryButton;
    @FindBy(xpath = "//button[contains(@id, 'isEditable')]")
    private WebElement isEditableButton;
    @FindBy(xpath = "//button[@id='inputallowTransaction']")
    private WebElement allowTransactionButton;
    @FindBy(xpath = "//div[@class='ant-modal-content']")
    private WebElement warningInfoModal;

    public PouchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getPouchPageURL() {
        return driver.getCurrentUrl();
    }
    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();

    }
    public void fillPouchDetails(String name, String description, String pouchType, String currency, String allocationType, String provisionType){
        pouchNameInputField.sendKeys(name);
        pouchDescriptionTextArea.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(pouchTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + pouchType + "')]")).click();
        if (pouchType.equals("MONETARY")){
            wait.until(ExpectedConditions.visibilityOf(currencyDropdown)).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + currency + "')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOf(pouchAllocationDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + allocationType + "')]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(pouchProvisionDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + provisionType + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(allowNegativeButton)).click();
    }
    public void clickAddParameter(){
        wait.until(ExpectedConditions.visibilityOf(addParameterButton)).click();
    }
    public void selectStatus(String status){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, 500)");
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }
    public void addExtraParameter(String parameter, String defaultValue){
        pouchParameter.click();
        driver.findElement(By.xpath("//li[text()='"+parameter+"']")).click();
        defaultValueInputField.sendKeys(defaultValue);
        wait.until(ExpectedConditions.visibilityOf(isMandatoryButton)).click();
        wait.until(ExpectedConditions.visibilityOf(isEditableButton)).click();
        wait.until(ExpectedConditions.visibilityOf(isVisibleButton)).click();
    }
    public void clickSaveButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
//        if(warningInfoModal.isDisplayed()){
//            okConfirmationButton.click();
//        }
    }
    public void clickViewIcon(String pouchName){
        driver.findElement(By.xpath("//td[contains(text(),'" + pouchName + "')]/preceding-sibling::td[2]")).click();
    }
    public void verifyPouchIsCreated(String pouchName){
        String actualPouchName = driver.findElement(By.xpath("//td[text()='" + pouchName + "']")).getText();
        Assert.assertEquals(actualPouchName, pouchName);
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void verifyErrorMessageForDuplicatedName(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
    public void deletePouch(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        okConfirmationButton.click();
    }
    public void updatePouch(String description, String status){
        pouchDescriptionTextArea.sendKeys(description);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(allowNegativeButton)).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }
    public void clickAllowTransaction(){
        wait.until(ExpectedConditions.visibilityOf(allowTransactionButton)).click();
    }
    public void clickFilterButton(){
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectFilterCriteria(String criteria){
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void fillSearchInput(String pouchName){
        searchInputField.sendKeys(pouchName);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifySearchResult(String pouchName){
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + pouchName + "')]"));
        boolean searchResultOnTable = true;
        for (WebElement msg : searchResults) {
            if (!msg.isDisplayed()) {
                searchResultOnTable = false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
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
}
