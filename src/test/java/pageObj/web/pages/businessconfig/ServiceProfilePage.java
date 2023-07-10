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
import pageObj.web.Elements.CommonElements;

import java.time.Duration;

public class ServiceProfilePage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    @FindBy(xpath = "//input[@id='inputServiceProfileName']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='inputServiceProfileDescription']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='inputServiceProfileType']")
    private WebElement typeDropdown;
    @FindBy(xpath = "//div[@class='node-title']/following-sibling::div")
    private WebElement addTreeIcon;
    @FindBy(xpath = "//input[@placeholder='Please select']")
    private WebElement selectInput;
    @FindBy(xpath = "//span[text()='Load']/parent::button")
    private WebElement loadButton;
    @FindBy(xpath = "//input[@id='service_search']")
    private WebElement searchNameInputField;
    @FindBy(xpath = "//li[text()='Access Channel']")
    private WebElement accessChannelOption;
    @FindBy(xpath = "(//li[text()='Service'])[2]")
    private WebElement serviceOption;
    @FindBy(xpath = "//span[text()='Add']/parent::button")
    private WebElement addServiceButton;
    @FindBy(xpath = "//span[@class='ant-input-group-addon']/child::button")
    private WebElement searchButton;
    public WebElement getServiceCheckBox(String checkboxName){
        return driver.findElement(By.xpath("//div[text()='"+checkboxName+"']/preceding-sibling::div//input[@type='checkbox']"));
    }
    public ServiceProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getServiceProfilePageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }
    public void addServiceProfile(String name, String description, String type, String status){
        nameField.sendKeys(name);
        descriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(typeDropdown)).click();
        driver.findElement(By.xpath("//li[text()='" + type + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }
    public void configureServiceProfileTree(String accessChannel, String service, String product, String ucpGroup){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(addTreeIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(selectInput)).click();
        wait.until(ExpectedConditions.visibilityOf(accessChannelOption)).click();
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();
        searchNameInputField.sendKeys(accessChannel);
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        getServiceCheckBox(accessChannel).click();
        wait.until(ExpectedConditions.visibilityOf(addServiceButton)).click();

        js.executeScript("window.scrollTo(0, 500)");
        wait.until(ExpectedConditions.visibilityOf(addTreeIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(selectInput)).click();
        wait.until(ExpectedConditions.visibilityOf(serviceOption)).click();
        wait.until(ExpectedConditions.visibilityOf(loadButton)).click();
        searchNameInputField.sendKeys(service);
        wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        getServiceCheckBox(service).click();
        wait.until(ExpectedConditions.visibilityOf(addServiceButton)).click();



    }
}
