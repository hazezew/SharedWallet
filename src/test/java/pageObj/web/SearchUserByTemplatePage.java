package pageObj.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchUserByTemplatePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "(//div[contains(@class,\"ant-select-selection\")])[1]")
    public WebElement ddSystemOperatorEntity;

    @FindBy(xpath = "//button[contains(@class,\"btn-primary\")]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[@class=\"ant-form-explain\"]")
    private WebElement SystemOperatorEntityValidation;

    @FindBy(xpath = "//span[@class=\"ant-alert-message\"]")
    private WebElement errorSuccessMessage;

    public SearchUserByTemplatePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void selectDDSystemOperatorEntity(String systemOperatorEntity){
        wait.until(ExpectedConditions.visibilityOf(ddSystemOperatorEntity)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),\""+ systemOperatorEntity +"\")]")))).click();
    }

    public void clickBtnSearch(){
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
    }

    public String getSystemOperatorEntityValidation(){
        return wait.until(ExpectedConditions.visibilityOf(SystemOperatorEntityValidation)).getText();
    }

    public String getErrorSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOf(errorSuccessMessage)).getText();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
