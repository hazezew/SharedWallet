package pageObj.web.pages.operation;

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

public class ResendNotificationPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//span[text()='Send']/parent::button")
    private WebElement sendButton;

    private WebElement getSendButton(String receiver){
        return driver.findElement(By.xpath("//td[text()='"+receiver+"']/following-sibling::td[2]"));
    }

    public ResendNotificationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }
    public void clickSendIcon(String receiverDetail){
        getSendButton(receiverDetail).click();
    }
    public void clickSendButton(){
        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();
    }

    public void clickFilterIcon() {
        wait.until(ExpectedConditions.visibilityOf(filterIcon)).click();
    }

    public void enterNameInToSearchField(String notification) {
        searchInputField.sendKeys(notification);
    }

    public void selectSearchCriteria(String criteria) {
        driver.findElement(By.xpath("(//div[@title='" + criteria + "'])[1]")).click();
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
    }

    public void verifyResendNotificationSearchResults(String notification) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + notification + "')]"));
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
