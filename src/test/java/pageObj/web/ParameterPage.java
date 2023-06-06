package pageObj.web;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObj.web.Elements.CommonElements;

import java.time.Duration;
import java.util.List;

public class ParameterPage extends CommonElements{
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id='inputParameterAddName']")
    private WebElement parameterNameInput;
    @FindBy(xpath = "//input[@id='inputParameterAddDisplayName[en-US]']")
    private WebElement displayNameInput;
    @FindBy(xpath = "//textarea[@id='inputParameterAddDescription']")
    private WebElement descriptionInput;
    @FindBy(xpath = "//div[@title='KYC']")
    private WebElement usedByDropdown;
    @FindBy(xpath = "//div[@id='inputParameterAddFieldtype']//div[@class='ant-select-selection__rendered']")
    private WebElement fieldTypeDropdown;
    @FindBy(xpath = "//label[@class='custom-inactive ant-radio-button-wrapper']/span[2]/span[.='No']")
    private WebElement allowMultipleOptionNo;
    @FindBy(xpath = "//div[@id='inputParameterAddComponenttype']//div[@class='ant-select-selection__rendered']")
    private WebElement componentTypeDropdown;
    @FindBy(xpath = "//button[@class='ant-btn exportBtn ant-btn-button']")
    private WebElement addFieldButton;
    @FindBy(xpath = "//input[@id= 'extraDetailsParamKeyFieldRequired[1]']")
    private WebElement keyField;
    @FindBy(xpath = "//input[@id= 'extraDetailsParamValueFieldRequired[1]']")
    private WebElement valueField;
    @FindBy(xpath = "//div[@id='inputParameterAddDatatype']//div[@class='ant-select-selection__rendered']")
    private WebElement dataTypeDropdown;
    @FindBy(xpath = "//input[@id='inputParameterAddValidationMessage[en-US]']")
    private WebElement inputValidationMessage;
    @FindBy(xpath = "//input[@id='inputParameterAddAllowdLimit']")
    private WebElement allowLimitInputField;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement addChildFieldButton;
    @FindBy(xpath = "//div[contains(@id,'inputParameterAddChildField')]")
    private WebElement fieldNameDropdown;
    @FindBy(xpath = "//td[2]/button[@class='switch-btn ant-switch ant-switch-checked']")
    private WebElement isMandatory;
    @FindBy(xpath = "//td[3]/button[@class='switch-btn ant-switch ant-switch-checked']")
    private WebElement isEditable;
    @FindBy(xpath = "(//button[@class='ant-btn deleteBtn ant-btn-primary'])[2]")
    private WebElement removeButton;
    @FindBy(xpath = "//input[@id='inputParameterEditDisplayName[en-US]']")
    private WebElement editDisplayNameInput;
    @FindBy(xpath = "//div[@id='inputParameterEditDatatype']")
    private WebElement editDataTypeDropdown;
    public ParameterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public String getParameterConfigPageURL() {
        return driver.getCurrentUrl();
    }

    public void fillParameterDetails(String parameterName, String displayName, String description, String usedBy, String fieldType, String componentType, String dataType) {
//        PlatformConfigElements.parameterNameInput1.sendKeys(parameterName);
        parameterNameInput.sendKeys(parameterName);
        displayNameInput.sendKeys(displayName);
        descriptionInput.sendKeys(description);

        wait.until(ExpectedConditions.visibilityOf(usedByDropdown)).click();
        List<WebElement> options = usedByDropdown.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(usedBy)) {
                option.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(fieldTypeDropdown)).click();
        List<WebElement> options1 = fieldTypeDropdown.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement option : options1) {
            if (option.getText().equals(fieldType)) {
                option.click();
                break;
            }
        }
//        allowMultipleOptionNo.click();
        wait.until(ExpectedConditions.visibilityOf(componentTypeDropdown)).click();
        driver.findElement(By.xpath("//li[.='" + componentType + "']")).click();
//        List<WebElement>componentOption = componentTypeDropdown.findElements(By.xpath("//ul[@role='listbox']/li"));
//        for(WebElement option: componentOption){
//            if(option.getText().equals(componentType)){
//                option.click();
//                break;
//            }
//        }

        wait.until(ExpectedConditions.visibilityOf(dataTypeDropdown)).click();
        List<WebElement> options3 = dataTypeDropdown.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals(dataType)) {
                option.click();
                break;
            }
        }
    }

    public void clickAddFieldButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(addFieldButton)).click();
    }

    public void inputExtraParameter(String key, String value) {
        keyField.sendKeys(key);
        valueField.sendKeys(value);
    }

    public void clickSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void clickRemoveButtonForExtraField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(removeButton)).click();
    }

    public void clickViewIcon(String parameterName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + parameterName + "')]/preceding-sibling::td[2]")).click();
    }

    public void clickDeleteButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }

    public void clickFilterParameterButton() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void clickEditButtonForParameter() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }

    public void verifyTheParameterIsCreated(String parameterName) {
        Assert.assertEquals(parameterName, driver.findElement(By.xpath("//td[text()='" + parameterName + "']")).getText());
    }

    public void fillInTheParameterDetails(String parameterName, String displayName, String description, String usedBy, String fieldType) {
        parameterNameInput.sendKeys(parameterName);
        displayNameInput.sendKeys(displayName);
        descriptionInput.sendKeys(description);

        wait.until(ExpectedConditions.visibilityOf(usedByDropdown)).click();

        WebElement li = driver.findElement(By.xpath("//li[contains(text(),'" + usedBy + "')]"));
        li.click();
//        driver.findElement(By.xpath("//li[.='"+usedBy+"']")).click();

        wait.until(ExpectedConditions.visibilityOf(fieldTypeDropdown)).click();
        driver.findElement(By.xpath("//li[.='" + fieldType + "']")).click();

    }

    public void enterValidationMessage(String validationMessage) {
        inputValidationMessage.sendKeys(validationMessage);
    }

    public void setAllowedLimit(String allowedLimitValue) {
        allowLimitInputField.sendKeys(allowedLimitValue);
    }

    public void addChildField() {
        fieldNameDropdown.click();
        driver.findElement(By.xpath("//li[.='Agent Info']")).click();

//        addChildFieldButton.click();
//        driver.findElement(By.xpath("//div[contains(@id,'inputParameterAddChildField[1]')]")).click();
//        driver.findElement(By.xpath("//li[.='Address']")).click();
//
//        addChildFieldButton.click();
//        driver.findElement(By.xpath("//div[contains(@id,'inputParameterAddChildField[2]')]")).click();
//        driver.findElement(By.xpath("//li[.='Agent Email']")).click();

////        List<WebElement> options = fieldNameDropdown.findElements(By.xpath(".//ul/li"));
////        int index = (int) (Math.random() * options.size());
////        options.get(index).click();

        isMandatory.click();
        isEditable.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void editParameter(String displayName, String dataType) {
        editDisplayNameInput.sendKeys(displayName);
        editDataTypeDropdown.click();
        WebElement li = driver.findElement(By.xpath("//li[contains(text(),'" + dataType + "')]"));
        li.click();
    }

    public void selectParameterFilterCriteria(String filterCriteria) {
        driver.findElement(By.xpath("(//div[@title='" + filterCriteria + "'])[1]")).click();
    }
    public void verifyDuplicatedValidationMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
    public void inputParameterName(String parameterName) {
        searchInputField.sendKeys(parameterName);
    }

    public void clickSearchParameter() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifySearchResult(String parameterName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + parameterName + "')]"));
        boolean searchResultOnTable = true;
        for (WebElement msg : searchResults) {
            if (!msg.isDisplayed()) {
                searchResultOnTable = false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
    }
    public void clickExportButton(){
        wait.until(ExpectedConditions.visibilityOf(exportButton)).click();
    }
    public void fillExportDetail(String name, String description){
        exportNameField.sendKeys(name);
        exportDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(exportSaveButton)).click();
    }
    public void clickExportHistoryButton(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOf(exportHistoryButton)).click();
    }
    public void verifyExportHistory(String exportName){
        WebElement exportHistory= driver.findElement(By.xpath("//td[text()='"+exportName+"']"));
        Assert.assertTrue(exportHistory.isDisplayed());
        Assert.assertTrue(downloadButton.isEnabled());
        downloadButton.click();
        Assert.assertTrue(downloadProgressSuccess.isDisplayed(),"download success message is not displayed");
    }
}
