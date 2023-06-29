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

public class ProductPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id='inputProductName']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@id='inputProductDisplayName[en-US]']")
    private WebElement displayNameField;
    @FindBy(xpath = "//textarea[@id='inputProductDiscription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputProductService']")
    private WebElement serviceDropdown;
    @FindBy(xpath = "//div[@id='inputProductAddUsedby']")
    private WebElement usedByDropdown;
    @FindBy(xpath = "//div[@id='inputProductProductType']")
    private WebElement productTypeDropdown;
    @FindBy(xpath = "//div[@id='inputProductProductSubType']")
    private WebElement productSubTypeDropdown;
    @FindBy(xpath = "//div[@id='inputProductAddDenominationType']")
    private WebElement denominationTypeDropdown;
    @FindBy(xpath = "//input[@id='inputProductDisplayorder']")
    private WebElement displayOrderInput;

    @FindBy(xpath = "//input[@id='inputProductAddAmount']")
    private WebElement productValueInput;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getProductPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addProductDetail(String name, String displayName, String description, String usedBy, String service, String productType, String productSubType,String denomination, String productValue, String displayOrder) {
        nameField.sendKeys(name);
        displayNameField.sendKeys(displayName);
        descriptionField.sendKeys(description);

        wait.until(ExpectedConditions.visibilityOf(usedByDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + usedBy + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(serviceDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + service + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(productTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + productType + "')]")).click();
        if(productType.equals("Transactional")){
            wait.until(ExpectedConditions.visibilityOf(productSubTypeDropdown)).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + productSubType + "')]")).click();

            wait.until(ExpectedConditions.visibilityOf(denominationTypeDropdown)).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + denomination + "')]")).click();
            wait.until(ExpectedConditions.visibilityOf(productValueInput)).sendKeys(productValue);

        }

        wait.until(ExpectedConditions.visibilityOf(displayOrderInput)).sendKeys(displayOrder);

    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void verifyProductCreated(String productName) {
        String actualUnitName = driver.findElement(By.xpath("//td[text()='" + productName + "']")).getText();
        Assert.assertEquals(actualUnitName, productName);
    }
    public void clickOnViewIcon(String productName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + productName + "')]/preceding-sibling::td[2]")).click();
    }
    public void clickDeleteButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(okConfirmationButton)).click();
    }
    public void verifyValidationMessageForDuplicateName(String validationMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, validationMessage);
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
}