package pageObj.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObj.web.Elements.CommonElements;

import java.time.Duration;

public class UnitCreditPolicyPage extends CommonElements {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    WebElement ucpNameField = driver.findElement(By.cssSelector("#inputUcpAddName"));
    WebElement ucpDescriptionField = driver.findElement(By.cssSelector("#inputUcpAddDescription"));

    @FindBy(xpath = "//div[@id='inputUcpAddUnittype']")
    private WebElement unitDropdown;
    @FindBy(xpath = "//div[@id='inputUcpAddUcptype']")
    private WebElement ucpTypeDropdown;
    @FindBy(xpath = "//div[@id='inputUcpAddSlabtype']")
    private WebElement slabTypeDropdown;
    @FindBy(xpath = "//div[@id='inputUcpAddCredittype']")
    private WebElement creditTypeDropdown;
    @FindBy(xpath = "//div[@id='inputUcpAddCalculationType']")
    private WebElement calculationTypeDropdown;
    @FindBy(xpath = "//div[@id='inputUcpAddCrediton']")
    private WebElement creditOnDropdown;
    private WebElement getUcpDropdown(String type){
        return driver.findElement(By.xpath("//div[@id='inputUcpAdd"+type+"']"));
    }
    public UnitCreditPolicyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public String getUnitCreditPolicyPageURL() {
        return driver.getCurrentUrl();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
    }

    public void addUcpDetail(String name, String description, String unit, String ucpType, String slabType, String creditType, String calculationType, String creditOn, String valueType) {
        ucpNameField.sendKeys(name);
        ucpDescriptionField.sendKeys(description);
        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Unittype"))).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + unit + "')]")).click();

        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Ucptype"))).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + ucpType + "')]")).click();
        if(ucpType.equals("Slab Based")){
            wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Slabtype"))).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + slabType + "')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Credittype"))).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + creditType + "')]")).click();
        if(creditType.equals("Percentage")){
            wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("CalculationType"))).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + calculationType + "')]")).click();
            wait.until(ExpectedConditions.visibilityOf(getUcpDropdown("Crediton"))).click();
            driver.findElement(By.xpath("//li[contains(text(), '" + creditOn + "')]")).click();
        }
    }
}
