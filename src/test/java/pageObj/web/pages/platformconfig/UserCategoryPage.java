package pageObj.web.pages.platformconfig;

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

public class UserCategoryPage extends CommonElements{
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//input[@id='inputAddUserCategoryName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputAddUserCategoryDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputAddUserCategoryCategoryType']")
    private WebElement categoryTypeDropdown;
    @FindBy(xpath = "//button[@class='ant-btn addBtn ant-btn-primary']")
    private WebElement addIdentifierField;
    @FindBy(xpath = "//div[contains(@id, 'userIdentifierParam')]")
    private WebElement userIdentifierField;
    @FindBy(xpath = "//div[contains(@id, 'userCrential')]")
    private WebElement userCredentialField;
    @FindBy(xpath = "//button[@class='ant-btn deleteBtn ant-btn-danger']")
    private WebElement removeUserIdentifierButton;
    @FindBy(xpath = "//div[@id='inputEditUserCategoryCategoryType']")
    private WebElement editCategoryTypeDropdown;
    @FindBy(xpath = "//textarea[@id='inputEditUserCategoryDescription']")
    private WebElement editDescriptionField;
    @FindBy(xpath = "(//input[@class='ant-input filter-group-second'])[1]")
    private WebElement searchField;
    @FindBy(xpath = "//span[contains(.,'Name already Exists')]")
    private WebElement duplicateErrorMessageLabel;

    public UserCategoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getUserCategoryPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickOnAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void fillUserCategoryDetail(String name, String category, String description) {
        nameField.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(categoryTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + category + "']")).click();
        descriptionField.sendKeys(description);
    }

    public void clickOnAddIdentifierField() {
        wait.until(ExpectedConditions.visibilityOf(addIdentifierField)).click();
    }

    public void fillIdentifierField(String identifier1, String identifier2, String credential1, String credential2) {
        userIdentifierField.click();
        WebElement li1 = driver.findElement(By.xpath("//li[contains(text(),'" + identifier1 + "')]"));
        li1.click();
        WebElement li2 = driver.findElement(By.xpath("//li[contains(text(),'" + identifier2 + "')]"));
        li2.click();
        userCredentialField.click();
        WebElement li3 = driver.findElement(By.xpath("//li[contains(text(),'" + credential1 + "')]"));
        li3.click();
        WebElement li4 = driver.findElement(By.xpath("//li[contains(text(),'" + credential2 + "')]"));
        li4.click();
    }

    public void clickRemoveIdentifierButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(removeUserIdentifierButton)).click();
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }

    public void verifyUserCategoryIsCreated(String userCategoryName) {
        Assert.assertEquals(userCategoryName, driver.findElement(By.xpath("//td[text()='" + userCategoryName + "']")).getText());
    }
    public void verifyErrorMessage(String errorMessage){
        String actualValidationMessage = duplicateErrorMessageLabel.getText();
//        Assert.assertTrue(duplicateValidationText.isDisplayed());
        Assert.assertEquals(actualValidationMessage, errorMessage);
    }
    public void clickViewIconForUserCategory(String userCategoryName) {
        driver.findElement(By.xpath("//td[contains(text(),'" + userCategoryName + "')]/preceding-sibling::td[2]")).click();
    }

    public void clickEditIconForUserCategory() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }
    public void clickDeleteButtonForUserCategory() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
        okConfirmationButton.click();
    }

    public void updateUserCategory(String categoryType, String description) {
        wait.until(ExpectedConditions.visibilityOf(editCategoryTypeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + categoryType + "']")).click();
        editDescriptionField.sendKeys(description);
    }

    public void verifyValidationMessages() {
        boolean allMessagesDisplayed = true;
        for (WebElement msg : validationMessages) {
            if (!msg.isDisplayed()) {
                allMessagesDisplayed = false;
                break;
            }
        }
        Assert.assertTrue(allMessagesDisplayed, "Not all validation messages were displayed.");
    }
    public void clickFilterUserCategory() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }
    public void searchUserCategory(String userCategoryName) {
        searchField.sendKeys(userCategoryName);
    }
    public void selectFilterCriteria(String filterCriteria) {
        driver.findElement(By.xpath("(//div[@title='" + filterCriteria + "'])[1]")).click();
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }
    public void verifySearchResults(String searchInput){
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '"+searchInput+"')]"));
        boolean searchResultOnTable = true;
        for(WebElement msg: searchResults){
            if(!msg.isDisplayed()){
                searchResultOnTable=false;
                break;
            }
        }
        Assert.assertTrue(searchResultOnTable, "Search results not displayed");
    }
}
