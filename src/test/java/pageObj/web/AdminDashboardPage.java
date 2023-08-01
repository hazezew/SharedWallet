package pageObj.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObj.web.pages.businessconfig.*;
import pageObj.web.pages.operation.*;
import pageObj.web.pages.operatorconfig.MoveSystemOperatorPage;
import pageObj.web.pages.operatorconfig.RoleConfigPage;
import pageObj.web.pages.operatorconfig.SystemOperatorEntityPage;
import pageObj.web.pages.operatorconfig.SystemOperatorOnboardingPage;
import pageObj.web.pages.platformconfig.NotificationTemplatePage;
import pageObj.web.pages.platformconfig.*;
import pageObj.web.pages.technicalconfig.*;
import pageObj.web.pages.usermgt.*;

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

    //    Main menu Technical Config and its submenu items
    @FindBy(xpath = "//span[contains(text(),'Technical Config')]")
    private WebElement linkTechnicalConfig;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/fieldmapping\"]")
    private WebElement linkFieldMapping;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/processes\"]")
    private WebElement linkProcess;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/scheduler\"]")
    private WebElement linkScheduler;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/processscheduler\"]")
    private WebElement linkProcessScheduler;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/processrundetails\"]")
    private WebElement linkProcessRunDetails;

    @FindBy(xpath = "//a[@href=\"#/mobifin/operation/reporttool\"]")
    private WebElement linkReportTool;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/menuconfiguration\"]")
    private WebElement linkMenuConfig;

    @FindBy(xpath = "//span[contains(text(),'Black List Management')]")
    private WebElement linkBlackListManagement;

    @FindBy(xpath = "//a[@href=\"#/mobifin/technicalconfiguration/systemparameter\"]")
    private WebElement linkSystemParameter;

    @FindBy(xpath = "//span[contains(text(),'KeyGroup Management')]")
    private WebElement linkKeyGroupManagement;

    @FindBy(xpath = "//span[contains(text(),'Workflow Management')]")
    private WebElement linkWorkflowManagement;

//    main menu items

    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    private WebElement linkUserManagement;

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

    //    menu items under the main menu User Management
    @FindBy(linkText = "View User")
    private WebElement linkViewUser;
    @FindBy(partialLinkText = "Update User Profile")
    private WebElement linkUpdateUserProfile;
    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/userwalletmanagement\"]")
    private WebElement linkWalletManagement;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/viewuserhierarchy\"]")
    private WebElement linkManageUserHierarchy;

    @FindBy(xpath = "//a[@href=\"#/mobifin/usermanagement/searchbybusinesstemplate\"]")
    private WebElement linkSearchBusinessUserByTemplate;

    private WebElement getMenuLinkUsingId(String menuId){
        return driver.findElement(By.xpath("//li[@id='"+menuId+"']"));
    }
    private WebElement getMenuLinkUsingSpan(String spanText){
        return driver.findElement(By.xpath("//span[text()='"+spanText+"']"));
    }

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

    //    Events for web elements under Technical Config main menu
    public void hoverLinkTechnicalConfig() {
        action.moveToElement(linkTechnicalConfig).build().perform();
    }

    public FieldMappingPage clickLinkFieldMapping() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkFieldMapping);
        wait.until(ExpectedConditions.visibilityOf(linkFieldMapping)).click();
        return new FieldMappingPage(driver);
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

    public UpgradeUserKYCPage clickLinkUpgradeUserKYC() {
        action.moveToElement(linkUpgradeUserKYC).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkUpgradeUserKYC)).click();
        return new UpgradeUserKYCPage(driver);
    }

    public SystemUserManagementPage clickLinkSystemUserManagement() {
        action.moveToElement(linkSystemUserManagement).build().perform();
        wait.until(ExpectedConditions.visibilityOf(linkSystemUserManagement)).click();
        return new SystemUserManagementPage(driver);
    }

    public WalletManagementPage clickLinkWalletManagement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkWalletManagement);
        wait.until(ExpectedConditions.visibilityOf(linkWalletManagement)).click();
        return new WalletManagementPage(driver);
    }

    public ManageUserHierarchyPage clickLinkManageUserHierarchy() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkManageUserHierarchy);
        wait.until(ExpectedConditions.visibilityOf(linkManageUserHierarchy)).click();
        return new ManageUserHierarchyPage(driver);
    }

    public SearchBusinessUserByTemplatePage clickLinkSearchBusinessUserByTemplate() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkSearchBusinessUserByTemplate);
        wait.until(ExpectedConditions.visibilityOf(linkSearchBusinessUserByTemplate)).click();
        return new SearchBusinessUserByTemplatePage(driver);
    }

    public ViewUserPage clickSubmenuViewUser() {
//    public ViewUserPage clickSubmenuViewUser() {
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
        action.moveToElement(getMenuLinkUsingSpan("Platform Config")).build().perform();
    }

    public String getURL() {
        driver.navigate().refresh();
        return driver.getCurrentUrl();
    }

    public ParameterPage clickOnParameterSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Parameter")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Parameter"))).click();
        return new ParameterPage(driver);
    }

    public UserCategoryPage clickOnUserCategorySubMenu() {
        action.moveToElement(getMenuLinkUsingId("User Category")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("User Category"))).click();
        return new UserCategoryPage(driver);
    }

    public UnitPage clickOnUnitSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Unit")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Unit"))).click();
        return new UnitPage(driver);
    }

    public PouchPage clickOnPouchSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Pouch")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Pouch"))).click();
        return new PouchPage(driver);
    }

    public WalletPage clickOnWalletSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Wallet")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Wallet"))).click();
        return new WalletPage(driver);
    }

    public KycManagementPage clickOnKycSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Kyc Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("KYC Profile")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("KYC Profile"))).click();
        return new KycManagementPage(driver);
    }

    public ServicePage clickOnServiceSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Service")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Service"))).click();
        return new ServicePage(driver);
    }

    public void hoverOnBusinessConfigMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Business Config")).build().perform();
    }

    public ServiceVendorPage clickOnServiceVendorSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Vendor Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Service Vendor")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Service Vendor"))).click();
        return new ServiceVendorPage(driver);
    }

    public AccessChannelPage clickOnAccessChannelSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Access Channel")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Access Channel"))).click();
        return new AccessChannelPage(driver);
    }

    public UnitCreditPolicyPage clickOnUcpSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Ucp")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Ucp"))).click();
        return new UnitCreditPolicyPage(driver);
    }

    public UcpGroupPage clickOnUcpGroupSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Ucp Group")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Ucp Group"))).click();
        return new UcpGroupPage(driver);
    }

    public RulePage clickRuleSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Rule")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Rule"))).click();
        return new RulePage(driver);
    }

    public CounterPage clickCounterSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Counter")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Counter"))).click();
        return new CounterPage(driver);
    }

    public ProductPage clickProductSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Product")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Product"))).click();
        return new ProductPage(driver);
    }

    public ProductGroupPage clickProductGroupSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Product Group")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Product Group"))).click();
        return new ProductGroupPage(driver);
    }

    public NotificationTemplatePage clickNotificationTemplateSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Notification Template")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Notification Template"))).click();
        return new NotificationTemplatePage(driver);
    }
    public WalletTemplatePage clickOnWalletTemplateSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Wallet Template")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Wallet Template"))).click();
        return new WalletTemplatePage(driver);
    }
    public ServiceProviderPage clickOnServiceProviderSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Vendor Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Service Provider")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Service Provider"))).click();
        return new ServiceProviderPage(driver);
    }

    public AssignProviderPage clickOnAssignProviderSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Vendor Management")).build().perform();
        action.moveToElement(getMenuLinkUsingSpan("Assign Provider")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Assign Provider"))).click();
        return new AssignProviderPage(driver);
    }

    public NotificationPage clickOnNotificationSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Notification")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Notification"))).click();
        return new NotificationPage(driver);
    }


    public ProductManagementPage clickOnProductManagementSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Product Management")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Product Management"))).click();
        return new ProductManagementPage(driver);
    }

    public ResponseNodePage clickOnResponseNodeSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Service Profile Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Response Node")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Response Node"))).click();
        return new ResponseNodePage(driver);
    }

    public ServiceProfilePage clickOnServiceProfileSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Service Profile Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Service Profile")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Service Profile"))).click();
        return new ServiceProfilePage(driver);
    }

    public AuthenticationPage clickOnAuthenticationSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("PAP Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Authentication")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Authentication"))).click();
        return new AuthenticationPage(driver);
    }

    public DeviceAuthenticationPage clickOnDeviceAuthenticationSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("PAP Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Device Authentication")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Device Authentication"))).click();
        return new DeviceAuthenticationPage(driver);
    }

    public ApiGroupPage clickOnApiGroupSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("PAP Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Api Group")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Api Group"))).click();
        return new ApiGroupPage(driver);
    }
    public AccessNodePage clickOnAccessNodeSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("PAP Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Access Node")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Access Node"))).click();
        return new AccessNodePage(driver);
    }
    public PlatformAccessProfilePage clickOnPlatformAccessProfileSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("PAP Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Platform Access Profile")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Platform Access Profile"))).click();
        return new PlatformAccessProfilePage(driver);
    }
    public SettlementGroupPage clickOnSettlementGroupSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Business Hierarchy Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Settlement Group")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Settlement Group"))).click();
        return new SettlementGroupPage(driver);
    }

    public PlatformAccessRolePage clickOnPlatformAccessRoleSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Business Hierarchy Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Platform Access Role")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Platform Access Role"))).click();
        return new PlatformAccessRolePage(driver);
    }
    public BusinessHierarchyPage clickOnBusinessHierarchySubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Business Hierarchy Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Business Hierarchy")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Business Hierarchy"))).click();
        return new BusinessHierarchyPage(driver);
    }

    public void hoverOnOperatorConfigMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Operator Config")).build().perform();
    }

    public MoveSystemOperatorPage clickOnMoveSystemOperatorSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Move System Operator")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Move System Operator"))).click();
        return new MoveSystemOperatorPage(driver);
    }

    public RoleConfigPage clickOnRoleConfigSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Role")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Role"))).click();
        return new RoleConfigPage(driver);
    }
    public SystemOperatorEntityPage clickOnSystemOperatorSubMenu() {
        action.moveToElement(getMenuLinkUsingId("System Operator Entity")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("System Operator Entity"))).click();
        return new SystemOperatorEntityPage(driver);
    }
    public SystemOperatorOnboardingPage clickOnSystemOperatorOnboardingSubMenu() {
        action.moveToElement(getMenuLinkUsingId("System Operator Onboarding")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("System Operator Onboarding"))).click();
        return new SystemOperatorOnboardingPage(driver);
    }
    public AddBlackListPage clickAddBlacklistSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Black List Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Add Blacklist")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Add Blacklist"))).click();
        return new AddBlackListPage(driver);
    }
    public ApplyBlackListPage clickApplyBlackListSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Black List Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Apply Blacklist")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Apply Blacklist"))).click();
        return new ApplyBlackListPage(driver);
    }
    public MenuConfigPage clickMenuConfigSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Menu Config")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Menu Config"))).click();
        return new MenuConfigPage(driver);
    }
    public ProcessPage clickProcessSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Process")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Process"))).click();
        return new ProcessPage(driver);
    }
    public ProcessSchedulerPage clickProcessSchedulerSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Process Scheduler")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Process Scheduler"))).click();
        return new ProcessSchedulerPage(driver);
    }
    public ProcessRunDetailPage clickProcessRunDetailSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Process Run Details")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Process Run Details"))).click();
        return new ProcessRunDetailPage(driver);
    }
    public SchedulerPage clickSchedulerSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Scheduler")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Scheduler"))).click();
        return new SchedulerPage(driver);
    }
    public StandardMasterPage clickStandardMasterSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Standard Master")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Standard Master"))).click();
        return new StandardMasterPage(driver);
    }
    public void hoverOnOperationMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Operation")).build().perform();
    }
    public AccountManagementPage clickOnAccountManagementSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Fund Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Account Management")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Account Management"))).click();
        return new AccountManagementPage(driver);
    }
    public FundTransferPage clickOnFundTransferSubMenu() {
        action.moveToElement(getMenuLinkUsingSpan("Fund Management")).build().perform();
        action.moveToElement(getMenuLinkUsingId("Fund Transfer")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Fund Transfer"))).click();
        return new FundTransferPage(driver);
    }
    public AddMoneyPage clickOnAddMoneySubMenu() {
        action.moveToElement(getMenuLinkUsingId("Add Money")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Add Money"))).click();
        return new AddMoneyPage(driver);
    }
    public ResendNotificationPage clickOnResendNotificationSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Resend Notification")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Resend Notification"))).click();
        return new ResendNotificationPage(driver);
    }
    public TransactionReversalPage clickOnTransactionReversalSubMenu() {
        action.moveToElement(getMenuLinkUsingId("Transaction Reversal")).build().perform();
        wait.until(ExpectedConditions.visibilityOf(getMenuLinkUsingId("Transaction Reversal"))).click();
        return new TransactionReversalPage(driver);
    }
}
