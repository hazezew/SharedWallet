package pageObj.web.pages.businessconfig;

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

public class PlatformAccessProfilePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputPlatformaccessProfileName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputPlatformaccessProfileDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//button[contains(@class,'node-add')]")
    private WebElement addTreeButton;
    @FindBy(xpath = "//input[@placeholder='Please select']")
    private WebElement selectInput;
    @FindBy(xpath = "(//li[text()='Access Channel'])[2]")
    private WebElement accessChannelOption;
    @FindBy(xpath = "(//li[text()='Authentication'])[3]")
    private WebElement authenticationOption;
    private WebElement getNodeOptions(String node){
        return driver.findElement(By.xpath("//li[text()='"+node+"']"));
    }
    private WebElement getSwitchButton(String nodeName){
        return driver.findElement(By
                .xpath("//span[contains(text(),'"+nodeName+"')]/ancestor::div[4]/following-sibling::div/child::button[@role='switch']"));
    }

    public PlatformAccessProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getPlatformAccessProfilePageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addPapConfig(String name, String description, String apiGroup, String accessChannel, String authentication){
        addTreeButton.click();
        nameField.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(selectInput)).click();
        wait.until(ExpectedConditions.visibilityOf(getNodeOptions("API Group"))).click();
        wait.until(ExpectedConditions.visibilityOf(getNodeOptions(apiGroup))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        addTreeButton.click();
        wait.until(ExpectedConditions.visibilityOf(selectInput)).click();
        wait.until(ExpectedConditions.visibilityOf(accessChannelOption)).click();
        wait.until(ExpectedConditions.visibilityOf(getNodeOptions(accessChannel))).click();

        addTreeButton.click();
        wait.until(ExpectedConditions.visibilityOf(selectInput)).click();
        wait.until(ExpectedConditions.visibilityOf(authenticationOption)).click();
        wait.until(ExpectedConditions.visibilityOf(getNodeOptions(authentication))).click();
    }

    public void clickSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
    public void verifyPAPCreated(String papName){
        String actualPAPName = driver.findElement(By.xpath("//td[text()='" + papName + "']")).getText();
        Assert.assertEquals(actualPAPName, papName);
    }
    public void clickViewIcon(String papName){
        driver.findElement(By.xpath("//td[contains(text(),'" + papName + "')]/preceding-sibling::td[2]")).click();
    }
    public void deletePAP(){
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
    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void updatePAP(String description, String apiGroup, String accessChannel){
        descriptionField.sendKeys(description);
        getSwitchButton(apiGroup).click();
        getSwitchButton(accessChannel).click();
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

    public void enterNameInToSearchField(String papName) {
        searchInputField.sendKeys(papName);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyPAPSearchResults(String papName) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + papName + "')]"));
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
