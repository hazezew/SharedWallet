package pageObj.web.pages.technicalconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObj.web.Elements.CommonElements;

import java.time.Duration;

public class FieldMappingPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public FieldMappingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void clickSaveButton(){
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
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
}
