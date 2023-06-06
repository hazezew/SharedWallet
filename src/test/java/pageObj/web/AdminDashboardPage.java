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

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/resetpassword\"]")
    private WebElement linkResetPassword;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/searchbytemplate\"]")
    private WebElement linkSearchUserByTemplate;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/changestatus\"]")
    private WebElement linkChangeStatus;

    //    menu items under the main menu User Management
    @FindBy(linkText = "View User")
    private WebElement linkViewUser;

    @FindBy(partialLinkText = "Update User Profile")
    private WebElement linkUpdateUserProfile;

    @FindBy(xpath = "//span[text()='Platform Config']")
    private WebElement platformConfigLink;
    @FindBy(xpath = "//li[@id='Parameter']")
    private WebElement parameterLink;
    @FindBy(xpath = "//li[@id='User Category']")
    private WebElement userCategoryLink;
    @FindBy(xpath = "//li[@id='Unit']")
    private WebElement unitSubLink;
    @FindBy(xpath = "//li[@id='Pouch']")
    private WebElement pouchSubLink;
    @FindBy(xpath = "//li[@id='Wallet']")
    private WebElement walletSubLink;
    @FindBy(xpath = "//span[text()='Kyc Management']")
    private WebElement kycManagementLink;
    @FindBy(xpath = "//li[@id='KYC Profile']")
    private WebElement kycProfileLink;
    @FindBy(xpath = "//li[@id='Service']")
    private WebElement serviceSubLink;
    @FindBy(xpath = "//span[text()='Business Config']")
    private WebElement businessConfigLink;
    @FindBy(xpath = "//li[@id='Service Vendor']")
    private WebElement serviceVendorSubLink;
    @FindBy(xpath = "//span[text()='Vendor Management']")
    private WebElement vendorManagementSubLink;
    @FindBy(xpath = "//li[@id='Access Channel']")
    private WebElement accessChannelSubLink;

    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public void clickLinkSettings() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(linkSettings)).click();
    }

    public LoginPage clickLinkLogout() {
        wait.until(ExpectedConditions.visibilityOf(linkLogout)).click();
        return new LoginPage(driver);
    }

    //    Events for web elements under User Configuration main menu
    public void hoverLinkUserManagement() {
        action.moveToElement(linkUserManagement).build().perform();
    }

    public ResetPasswordPage clickLinkResetPassword() {
        wait.until(ExpectedConditions.visibilityOf(linkResetPassword)).click();
        return new ResetPasswordPage(driver);
    }

    public SearchUserByTemplatePage clickLinkSearchUserByTemplate() {
        wait.until(ExpectedConditions.visibilityOf(linkSearchUserByTemplate)).click();
        return new SearchUserByTemplatePage(driver);
    }

    public ChangeUserStatusPage clickLinkChangeStatus() {
        wait.until(ExpectedConditions.visibilityOf(linkChangeStatus)).click();
        return new ChangeUserStatusPage(driver);
    }

    public ViewUserPage clickSubmenuViewUser() {
        action.moveToElement(linkViewUser).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkViewUser)).click();
        return new ViewUserPage(driver);
    }

    public UpdateUserProfilePage clickSubmenuLinkUpdateUserProfile() {
        action.moveToElement(linkUpdateUserProfile).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkUpdateUserProfile)).click();
        return new UpdateUserProfilePage(driver);
    }

    public void hoverOnPlatformConfigMenu() {
        action.moveToElement(platformConfigLink).build().perform();
    }

    public String getURL() {
        driver.navigate().refresh();
        return driver.getCurrentUrl();
    }

    public ParameterPage clickOnParameterSubMenu() {
        action.moveToElement(parameterLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(parameterLink)).click();
        return new ParameterPage(driver);
    }
    public UserCategoryPage clickOnUserCategorySubMenu() {
        action.moveToElement(userCategoryLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(userCategoryLink)).click();
        return new UserCategoryPage(driver);
    }
    public UnitPage clickOnUnitSubMenu(){
        action.moveToElement(unitSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(unitSubLink)).click();
        return new UnitPage(driver);
    }
    public PouchPage clickOnPouchSubMenu(){
        action.moveToElement(pouchSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(pouchSubLink)).click();
        return new PouchPage(driver);
    }
    public WalletPage clickOnWalletSubMenu(){
        action.moveToElement(walletSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(walletSubLink)).click();
        return new WalletPage(driver);
    }
    public KycManagementPage clickOnKycSubMenu(){
        action.moveToElement(kycManagementLink).build().perform();
        action.moveToElement(kycProfileLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(kycProfileLink)).click();
        return new KycManagementPage(driver);
    }
    public ServicePage clickOnServiceSubMenu(){
        action.moveToElement(serviceSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(serviceSubLink)).click();
        return new ServicePage(driver);
    }
    public void hoverOnBusinessConfigMenu() {
        action.moveToElement(businessConfigLink).build().perform();
    }
    public ServiceVendorPage clickOnServiceVendorSubMenu(){
        action.moveToElement(vendorManagementSubLink).build().perform();
        action.moveToElement(serviceVendorSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(serviceVendorSubLink)).click();
        return new ServiceVendorPage(driver);
    }
    public AccessChannelPage clickOnAccessChannelSubMenu(){
        action.moveToElement(accessChannelSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(accessChannelSubLink)).click();
        return new AccessChannelPage(driver);
    }
}
