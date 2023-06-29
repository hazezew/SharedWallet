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

public class UnitCreditPolicyPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id='inputUcpAddName']")
    private WebElement ucpNameField;
    @FindBy(xpath = "//textarea[@id='inputUcpAddDescription']")
    private WebElement ucpDescriptionField;
//    @FindBy(xpath = "//div[@id='inputUcpAddUnittype']")
//    private WebElement unitDropdown;
//    @FindBy(xpath = "//div[@id='inputUcpAddUcptype']")
//    private WebElement ucpTypeDropdown;
//    @FindBy(xpath = "//div[@id='inputUcpAddSlabtype']")
//    private WebElement slabTypeDropdown;
//    @FindBy(xpath = "//div[@id='inputUcpAddCredittype']")
//    private WebElement creditTypeDropdown;
//    @FindBy(xpath = "//div[@id='inputUcpAddCalculationType']")
//    private WebElement calculationTypeDropdown;
//    @FindBy(xpath = "//div[@id='inputUcpAddCrediton']")
//    private WebElement creditOnDropdown;
    @FindBy(xpath = "//input[@id='inputUcpAddValue']")
    private WebElement valueField;
    @FindBy(xpath = "//div[@id='inputUcpEditUnittype']")
    private WebElement editUnitDropdown;
    @FindBy(xpath = "//div[@id='inputUcpEditUcptype']")
    private WebElement editUcpTypeDropdown;
    @FindBy(xpath = "//div[@id='inputUcpEditSlabtype']")
    private WebElement editSlabTypeDropdown;
    @FindBy(xpath = "//div[@id='inputUcpEditValuetype']")
    private WebElement editValueTypeDropdown;
    @FindBy(xpath = "(//input[@class='ant-input-number-input'])[1]")
    private WebElement minimumInputField;
    @FindBy(xpath = "(//input[@class='ant-input-number-input'])[2]")
    private WebElement maximumInputField;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement valueInputField;

    private WebElement getUcpDropdown(String type) {
        return driver.findElement(By.xpath("//div[@id='inputUcpAdd" + type + "']"));
    }

    public UnitCreditPolicyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getUnitCreditPolicyPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addUcpDetail(String name, String description, String unit, String ucpType, String slabType, String creditType, String calculationType, String creditOn, String valueType) {
        ucpNameField.sendKeys(name);
        ucpDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Unittype"))).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + unit + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Ucptype"))).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + ucpType + "')]")).click();
        if (ucpType.equals("Slab Based")) {
            wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Slabtype"))).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + slabType + "')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Credittype"))).click();
        driver.findElement(By.xpath("//span[contains(text(), '" + creditType + "')]")).click();
        if (creditType.equals("Percentage")) {
            wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("CalculationType"))).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + calculationType + "')]")).click();
            wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Crediton"))).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + creditOn + "')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("ValueType"))).click();
        driver.findElement(By.xpath("//li[text() = '" + valueType + "']")).click();
    }
    public void clickSaveButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void addValue(int value){
        valueField.sendKeys(String.valueOf(value));
    }
    public void verifyUcpCreated(String ucpName) {
        String actualUnitName = driver.findElement(By.xpath("//td[text()='" + ucpName + "']")).getText();
        Assert.assertEquals(actualUnitName, ucpName);
    }
    public void clickOnViewIcon(String ucpName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + ucpName + "')]/preceding-sibling::td[2]")).click();
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
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateUcpConfig(String unit, String ucpType, String slabType, String valueType){
        wait.until(ExpectedConditions.visibilityOf(editUnitDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + unit + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(editUcpTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + ucpType + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(editSlabTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + slabType + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(editValueTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text() = '" + valueType + "']")).click();
    }
    public void verifyUpdatedUcp(String ucpName, String unit, String ucpType, String slabType, String valueType){
        driver.findElement(By.xpath("//td[contains(text(),'" + ucpName + "')]/preceding-sibling::td[2]")).click();

        String actualUnit = driver.findElement(By.xpath("//span[@id='inputUcpViewUnittype']/parent::div")).getText();
        Assert.assertEquals(actualUnit,unit,"The unit for ucp is not updated");

        String actualUcpType = driver.findElement(By.xpath("//span[@id='inputUcpAddUcptype']")).getText();
        Assert.assertEquals(actualUcpType,ucpType,"The Ucp Type for ucp is not updated");

        String actualSlabType = driver.findElement(By.xpath("//span[@id='inputUcpViewSlabtype']")).getText();
        Assert.assertEquals(actualSlabType,slabType,"The slab Type for ucp is not updated");

        String actualValueType = driver.findElement(By.xpath("//span[@id='inputUcpViewValuetype']")).getText();
        Assert.assertEquals(actualValueType,valueType, "The value Type for ucp is not updated");
    }
    public void addSlabDetail(int minimum, int maximum, int value){
        minimumInputField.sendKeys(String.valueOf(minimum));
        maximumInputField.sendKeys(String.valueOf(maximum));
        valueInputField.sendKeys((String.valueOf(value)));
    }
    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void enterNameInToSearchField(String ucpName) {
        searchInputField.sendKeys(ucpName);
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifyUcpSearchResults(String ucpName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + ucpName + "')]"));
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
