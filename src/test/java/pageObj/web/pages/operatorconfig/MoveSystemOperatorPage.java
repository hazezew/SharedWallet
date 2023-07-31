package pageObj.web.pages.operatorconfig;

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

public class MoveSystemOperatorPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//div[@id='inputMoveSystemOperatorSystemOperator']")
    private WebElement systemOperatorDropdown;
    @FindBy(xpath = "//div[@id='inputMoveSystemOperatorNewSystemOperatorEntity']")
    private WebElement newSystemOperatorDropdown;
    @FindBy(xpath = "//div[@id='inputMoveSystemOperatorKyc']")
    private WebElement kycLevelDropdown;
    @FindBy(xpath = "//button[@id='searchbutton']")
    private WebElement moveButton;

    public MoveSystemOperatorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getMoveSystemOperatorPageURL(){
        return driver.getCurrentUrl();
    }
    public void clickDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath("//li[text()='" + dropdownOption + "']")).click();
    }
    public void selectNewSystemOperatorEntity(String newSystemOperatorEntity){
        wait.until(ExpectedConditions.visibilityOf(newSystemOperatorDropdown)).click();
        clickDropdownOption(newSystemOperatorEntity);
    }
    public void selectSystemOperatorEntity(String systemOperatorEntity){
        wait.until(ExpectedConditions.visibilityOf(systemOperatorDropdown)).click();
        clickDropdownOption(systemOperatorEntity);
    }
    public void selectKycLevel(String kycLevel){
        wait.until(ExpectedConditions.visibilityOf(kycLevelDropdown)).click();
        clickDropdownOption(kycLevel);
    }
    public void clickMoveButton(){
        wait.until(ExpectedConditions.visibilityOf(moveButton)).click();
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
