package pageObj.web;

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

//    menu items under the main menu User Management
    @FindBy(linkText = "View User")
    private WebElement linkViewUser;

    @FindBy(partialLinkText = "Update User Profile")
    private WebElement linkUpdateUserProfile;

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
