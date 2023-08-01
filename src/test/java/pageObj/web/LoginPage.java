package pageObj.web;

import util.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private String loginSuccessErrorMessage;

    @FindBy(id = "inputLoginUsername")
    private WebElement txtUsername;

    @FindBy(id = "inputLoginPd")
    private WebElement txtPassword;

    @FindBy(xpath = "//div[@class=\"ant-select-selection__rendered\"]")
    private WebElement ddTimeZone;

    @FindBy(id = "btnLoginLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id='inputLoginUsername']//following::span[1]")
    private WebElement emptyUsernameMsg;

    @FindBy(xpath = "//*[@id='inputLoginPd']//following::span[1]")
    private WebElement emptyPasswordMsg;

    @FindBy(xpath = "//div[contains(@class,\"notification\") and contains(@class,\"description\")]")
    private WebElement usernamePasswordValidationMsg;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void setTxtUsername() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).clear();
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).sendKeys(PropertiesReader.getValue("username"));
    }
    public void setTxtPassword() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).clear();
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(PropertiesReader.getValue("password"));
    }
    public void setIncorrectPassword() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).clear();
        wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(PropertiesReader.getValue("incorrectPassword"));
    }
    public void setIncorrectUsername() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).clear();
        wait.until(ExpectedConditions.visibilityOf(txtUsername)).sendKeys(PropertiesReader.getValue("incorrectUsername"));
    }
    public void selectTimeZone(String timeZone){
        wait.until(ExpectedConditions.visibilityOf(ddTimeZone)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(text(),\"" + timeZone + "\")]")))).click();
    }
    public AdminDashboardPage clickBtnLogin(){
        String username=txtUsername.getAttribute("value");
        String password=txtPassword.getAttribute("value");
        wait.until(ExpectedConditions.visibilityOf(btnLogin)).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (username.length() != 0 && password.length() != 0)
            setLoginSuccessErrorMessage();
        return new AdminDashboardPage(driver);
    }
    private void setLoginSuccessErrorMessage(){
        loginSuccessErrorMessage=wait.until(ExpectedConditions.visibilityOf(usernamePasswordValidationMsg)).getText();
    }
    public String getLoginSuccessErrorMessage(){
        return loginSuccessErrorMessage;
    }
    public String getEmptyUsernameMsg(){
        return wait.until(ExpectedConditions.visibilityOf(emptyUsernameMsg)).getText();
    }
    public String getEmptyPasswordMsg(){
        return wait.until(ExpectedConditions.visibilityOf(emptyPasswordMsg)).getText();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
