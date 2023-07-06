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

public class WalletPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputWalletName']")
    private WebElement walletNameInputField;
    @FindBy(xpath = "//textarea[@id='inputWalletDescription']")
    private WebElement walletDescriptionField;
    @FindBy(xpath = "//div[@id='inputWalletType']")
    private WebElement walletTypeDropdown;
    @FindBy(xpath = "//button[@id='inputWalleallowTransaction']")
    private WebElement allowTransactionButton;

    public WalletPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getWalletPageURL() {
        return driver.getCurrentUrl();
    }
    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void fillWalletDetail(String walletName, String description, String walletType){
        walletNameInputField.sendKeys(walletName);
        walletDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(walletTypeDropdown)).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + walletType + "')]")).click();
    }
    public void selectStatus(String status){
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
        if(status.equals("Inactive")){
            wait.until(ExpectedConditions.visibilityOf(allowTransactionButton)).click();
        }
    }
    public void clickSaveButton(String status){
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
        if(status.equals("Inactive")){
            wait.until(ExpectedConditions.visibilityOf(warningInfoModal));
            Assert.assertTrue(warningInfoModal.isDisplayed());
            okConfirmationButton.click();
        }
    }
    public void verifyWalletIsCreated(String walletName){
        String actualWalletName = driver.findElement(By.xpath("//td[text()='" + walletName + "']")).getText();
        Assert.assertEquals(actualWalletName, walletName);
    }
    public void clickViewIcon(String wallet){
        driver.findElement(By.xpath("//td[contains(text(),'" + wallet + "')]/preceding-sibling::td[2]")).click();
    }
    public void deleteWallet(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        okConfirmationButton.click();
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updateWallet(String description, String status){
        walletDescriptionField.sendKeys(description);
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
        wait.until(ExpectedConditions.visibilityOf(allowTransactionButton)).click();
    }
    public void verifyValidationMessageForWallet(){
        boolean allValidationMessagesDisplayed = true;
        for (WebElement msg : validationMessages) {
            if (!msg.isDisplayed()) {
                allValidationMessagesDisplayed = false;
                break;
            }
        }
        Assert.assertTrue(allValidationMessagesDisplayed, "All validation messages are not displayed");
    }
    public void clickFilterIcon(){
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void selectFilterCriteria(String criteria){
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void fillSearchInput(String walletName){
        searchInputField.sendKeys(walletName);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifyWalletSearchResult(String walletName){
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + walletName + "')]"));
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
    public void verifyDuplicateErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateValidationText.getText();
        Assert.assertTrue(duplicateErrorMessage.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
}
