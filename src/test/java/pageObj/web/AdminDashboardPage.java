package pageObj.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(xpath = "//div[contains(@class,\"notification\") and contains(@class,\"description\")]")
    private WebElement loginSuccessMsg;

    @FindBy(xpath = "//span[contains(@class,\"avatar\")]")
    private WebElement linkSettings;

    @FindBy(xpath = "//span[contains(text(),\"Logout\")]")
    private WebElement linkLogout;

//    main menu items

    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    private WebElement linkUserManagement;


//    Sub menu items under the main menu User Management
    @FindBy(linkText = "View User")
    private WebElement linkViewUser;

    @FindBy(partialLinkText = "Update User Profile")
    private WebElement linkUpdateUserProfile;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/resetpassword\"]")
    private WebElement linkResetPassword;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/searchbytemplate\"]")
    private WebElement linkSearchUserByTemplate;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/changestatus\"]")
    private WebElement linkChangeStatus;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/kyclevelupgrade\"]")
    private WebElement linkUpgradeUserKYC;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/systemusermanagement\"]")
    private WebElement linkSystemUserManagement;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/userwalletmanagement\"]")
    private WebElement linkWalletManagement;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/viewuserhierarchy\"]")
    private WebElement linkManageUserHierarchy;

    public AdminDashboardPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }
    public void clickLinkSettings(){
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(linkSettings)).click();
    }
    public LoginPage clickLinkLogout(){
        wait.until(ExpectedConditions.visibilityOf(linkLogout)).click();
        return new LoginPage(driver);
    }
//    Events for web elements under User Configuration main menu
    public void hoverLinkUserManagement(){
        action.moveToElement(linkUserManagement).build().perform();
    }
    public ResetPasswordPage clickLinkResetPassword(){
        wait.until(ExpectedConditions.visibilityOf(linkResetPassword)).click();
        return new ResetPasswordPage(driver);
    }

    public SearchUserByTemplatePage clickLinkSearchUserByTemplate(){
        wait.until(ExpectedConditions.visibilityOf(linkSearchUserByTemplate)).click();
        return new SearchUserByTemplatePage(driver);
    }

    public ChangeUserStatusPage clickLinkChangeStatus(){
        wait.until(ExpectedConditions.visibilityOf(linkChangeStatus)).click();
        return new ChangeUserStatusPage(driver);
    }

    public UpgradeUserKYCPage clickLinkUpgradeUserKYC(){
        action.moveToElement(linkUpgradeUserKYC).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkUpgradeUserKYC)).click();
        return new UpgradeUserKYCPage(driver);
    }

    public SystemUserManagementPage clickLinkSystemUserManagement(){
        action.moveToElement(linkSystemUserManagement).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkSystemUserManagement)).click();
        return new SystemUserManagementPage(driver);
    }

    public WalletManagementPage clickLinkWalletManagement(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkWalletManagement);
        wait.until(ExpectedConditions.visibilityOf(linkWalletManagement)).click();
        return new WalletManagementPage(driver);
    }

    public ManageUserHierarchyPage clickLinkManageUserHierarchy(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkManageUserHierarchy);
        wait.until(ExpectedConditions.visibilityOf(linkManageUserHierarchy)).click();
        return new ManageUserHierarchyPage(driver);
    }

    public ViewUserPage clickSubmenuViewUser(){
        action.moveToElement(linkViewUser).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkViewUser)).click();
        return new ViewUserPage(driver);
    }

    public UpdateUserProfilePage clickSubmenuLinkUpdateUserProfile(){
        action.moveToElement(linkUpdateUserProfile).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkUpdateUserProfile)).click();
        return new UpdateUserProfilePage(driver);
    }

    public String getURL(){
        driver.navigate().refresh();
        return driver.getCurrentUrl();
    }
}
