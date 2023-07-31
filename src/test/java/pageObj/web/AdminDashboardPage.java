package pageObj.web;

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
    @FindBy(xpath = "//li[@id='Counter']")
    private WebElement counterSubLink;
    @FindBy(xpath = "//li[@id='Rule']")
    private WebElement ruleSubLink;
    @FindBy(xpath = "//li[@id='Ucp Group']")
    private WebElement ucpGroupSubLink;
    @FindBy(xpath = "//li[@id='Product']")
    private WebElement productSubLink;
    @FindBy(xpath = "//li[@id='Product Group']")
    private WebElement productGroupSubLink;
    @FindBy(xpath = "//li[@id='Ucp']")
    private WebElement ucpSubLink;
    @FindBy(xpath = "//li[@id='Notification Template']")
    private WebElement notificationTemplateSubLink;
    @FindBy(xpath = "//li[@id='Wallet Template']")
    private WebElement walletTemplateSubLink;
    @FindBy(xpath = "//span[text()='Service Profile Management']")
    private WebElement serviceProfileManagementSubLink;
    @FindBy(xpath = "//span[text()='PAP Management']")
    private WebElement papManagementSubLink;
    @FindBy(xpath = "//span[text()='Business Hierarchy Management']")
    private WebElement businessHierarchyManagementSubLink;
    @FindBy(xpath = "//li[@id='Service Provider']")
    private WebElement serviceProviderSubLink;
    @FindBy(xpath = "//li[@id='Assign Provider']")
    private WebElement assignProviderSubLink;
    @FindBy(xpath = "//li[@id='Notification']")
    private WebElement notificationSubLink;
    @FindBy(xpath = "//li[@id='Product Management']")
    private WebElement productManagementSubLink;
    @FindBy(xpath = "//li[@id='Response Node']")
    private WebElement responseNodeSubLink;
    @FindBy(xpath = "//li[@id='Service Profile']")
    private WebElement serviceProfileSubLink;
    @FindBy(xpath = "//li[@id='Authentication']")
    private WebElement authenticationSubLink;
    @FindBy(xpath = "//li[@id='Device Authentication']")
    private WebElement deviceAuthenticationSubLink;
    @FindBy(xpath = "//li[@id='Api Group']")
    private WebElement apiGroupSubLink;
    @FindBy(xpath = "//li[@id='Access Node']")
    private WebElement accessNodeSubLink;
    @FindBy(xpath = "//li[@id='Platform Access Profile']")
    private WebElement platformAccessProfileSubLink;
    @FindBy(xpath = "//li[@id='Settlement Group']")
    private WebElement settlementGroupSubLink;
    @FindBy(xpath = "//li[@id='Platform Access Role']")
    private WebElement platformAccessRoleSubLink;
    @FindBy(xpath = "//li[@id='Business Hierarchy']")
    private WebElement businessHierarchySubLink;

    @FindBy(xpath = "//span[text()='Operator Config']")
    private WebElement operatorConfigLink;
    @FindBy(xpath = "//li[@id='Move System Operator']")
    private WebElement moveSystemOperatorLink;
    @FindBy(xpath = "//li[@id='System Operator Onboarding']")
    private WebElement systemOperatorOnboardingLink;
    @FindBy(xpath = "//li[@id='Role']")
    private WebElement roleConfigLink;
    @FindBy(xpath = "//li[@id='System Operator Entity']")
    private WebElement systemOperatorLink;
    @FindBy(xpath = "//span[text()='Black List Management']")
    private WebElement blackListManagementLink;
    @FindBy(xpath = "//li[@id='Add Blacklist']")
    private WebElement addBlacklistLink;
    @FindBy(xpath = "//li[@id='Apply Blacklist']")
    private WebElement applyBlacklistLink;
    @FindBy(xpath = "//li[@id='Process']")
    private WebElement processLink;
    @FindBy(xpath = "//li[@id='Scheduler']")
    private WebElement schedulerLink;
    @FindBy(xpath = "//li[@id='Process Scheduler']")
    private WebElement processSchedulerLink;
    @FindBy(xpath = "//li[@id='Process Run Details']")
    private WebElement processRunDetailLink;
    @FindBy(xpath = "//li[@id='Menu Config']")
    private WebElement menuConfigLink;
    @FindBy(xpath = "//li[@id='Standard Master']")
    private WebElement standardMasterLink;
    @FindBy(xpath = "//span[text()='Operation']")
    private WebElement operationLink;
    @FindBy(xpath = "//li[@id='Account Management']")
    private WebElement accountManagementLink;
    @FindBy(xpath = "//span[text()='Fund Management']")
    private WebElement fundManagementLink;
    @FindBy(xpath = "//li[@id='Add Money']")
    private WebElement addMoneyLink;
    @FindBy(xpath = "//li[@id='Fund Transfer']")
    private WebElement fundTransferLink;
    @FindBy(xpath = "//li[@id='Resend Notification']")
    private WebElement resendNotificationLink;
    @FindBy(xpath = "//li[@id='Transaction Reversal']")
    private WebElement transactionReversalLink;

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

    public UnitPage clickOnUnitSubMenu() {
        action.moveToElement(unitSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(unitSubLink)).click();
        return new UnitPage(driver);
    }

    public PouchPage clickOnPouchSubMenu() {
        action.moveToElement(pouchSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(pouchSubLink)).click();
        return new PouchPage(driver);
    }

    public WalletPage clickOnWalletSubMenu() {
        action.moveToElement(walletSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(walletSubLink)).click();
        return new WalletPage(driver);
    }

    public KycManagementPage clickOnKycSubMenu() {
        action.moveToElement(kycManagementLink).build().perform();
        action.moveToElement(kycProfileLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(kycProfileLink)).click();
        return new KycManagementPage(driver);
    }

    public ServicePage clickOnServiceSubMenu() {
        action.moveToElement(serviceSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(serviceSubLink)).click();
        return new ServicePage(driver);
    }

    public void hoverOnBusinessConfigMenu() {
        action.moveToElement(businessConfigLink).build().perform();
    }

    public ServiceVendorPage clickOnServiceVendorSubMenu() {
        action.moveToElement(vendorManagementSubLink).build().perform();
        action.moveToElement(serviceVendorSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(serviceVendorSubLink)).click();
        return new ServiceVendorPage(driver);
    }

    public AccessChannelPage clickOnAccessChannelSubMenu() {
        action.moveToElement(accessChannelSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(accessChannelSubLink)).click();
        return new AccessChannelPage(driver);
    }

    public UnitCreditPolicyPage clickOnUcpSubMenu() {
        action.moveToElement(ucpSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(ucpSubLink)).click();
        return new UnitCreditPolicyPage(driver);
    }

    public UcpGroupPage clickOnUcpGroupSubMenu() {
        action.moveToElement(ucpGroupSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(ucpGroupSubLink)).click();
        return new UcpGroupPage(driver);
    }

    public RulePage clickRuleSubMenu() {
        action.moveToElement(ruleSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(ruleSubLink)).click();
        return new RulePage(driver);
    }

    public CounterPage clickCounterSubMenu() {
        action.moveToElement(counterSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(counterSubLink)).click();
        return new CounterPage(driver);
    }

    public ProductPage clickProductSubMenu() {
        action.moveToElement(productSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(productSubLink)).click();
        return new ProductPage(driver);
    }

    public ProductGroupPage clickProductGroupSubMenu() {
        action.moveToElement(productGroupSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(productGroupSubLink)).click();
        return new ProductGroupPage(driver);
    }

    public NotificationTemplatePage clickNotificationTemplateSubMenu() {
        action.moveToElement(notificationTemplateSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(notificationTemplateSubLink)).click();
        return new NotificationTemplatePage(driver);
    }
    public WalletTemplatePage clickOnWalletTemplateSubMenu() {
        action.moveToElement(walletTemplateSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(walletTemplateSubLink)).click();
        return new WalletTemplatePage(driver);
    }
    public ServiceProviderPage clickOnServiceProviderSubMenu() {
        action.moveToElement(vendorManagementSubLink).build().perform();
        action.moveToElement(serviceProviderSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(serviceProviderSubLink)).click();
        return new ServiceProviderPage(driver);
    }

    public AssignProviderPage clickOnAssignProviderSubMenu() {
        action.moveToElement(vendorManagementSubLink).build().perform();
        action.moveToElement(assignProviderSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(assignProviderSubLink)).click();
        return new AssignProviderPage(driver);
    }

    public NotificationPage clickOnNotificationSubMenu() {
        action.moveToElement(notificationSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(notificationSubLink)).click();
        return new NotificationPage(driver);
    }


    public ProductManagementPage clickOnProductManagementSubMenu() {
        action.moveToElement(productManagementSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(productManagementSubLink)).click();
        return new ProductManagementPage(driver);
    }

    public ResponseNodePage clickOnResponseNodeSubMenu() {
        action.moveToElement(serviceProfileManagementSubLink).build().perform();
        action.moveToElement(responseNodeSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(responseNodeSubLink)).click();
        return new ResponseNodePage(driver);
    }

    public ServiceProfilePage clickOnServiceProfileSubMenu() {
        action.moveToElement(serviceProfileManagementSubLink).build().perform();
        action.moveToElement(serviceProfileSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(serviceProfileSubLink)).click();
        return new ServiceProfilePage(driver);
    }

    public AuthenticationPage clickOnAuthenticationSubMenu() {
        action.moveToElement(papManagementSubLink).build().perform();
        action.moveToElement(authenticationSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(authenticationSubLink)).click();
        return new AuthenticationPage(driver);
    }

    public DeviceAuthenticationPage clickOnDeviceAuthenticationSubMenu() {
        action.moveToElement(papManagementSubLink).build().perform();
        action.moveToElement(deviceAuthenticationSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(deviceAuthenticationSubLink)).click();
        return new DeviceAuthenticationPage(driver);
    }

    public ApiGroupPage clickOnApiGroupSubMenu() {
        action.moveToElement(papManagementSubLink).build().perform();
        action.moveToElement(apiGroupSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(apiGroupSubLink)).click();
        return new ApiGroupPage(driver);
    }
    public AccessNodePage clickOnAccessNodeSubMenu() {
        action.moveToElement(papManagementSubLink).build().perform();
        action.moveToElement(accessNodeSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(accessNodeSubLink)).click();
        return new AccessNodePage(driver);
    }
    public PlatformAccessProfilePage clickOnPlatformAccessProfileSubMenu() {
        action.moveToElement(papManagementSubLink).build().perform();
        action.moveToElement(platformAccessProfileSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(platformAccessProfileSubLink)).click();
        return new PlatformAccessProfilePage(driver);
    }
    public SettlementGroupPage clickOnSettlementGroupSubMenu() {
        action.moveToElement(businessHierarchyManagementSubLink).build().perform();
        action.moveToElement(settlementGroupSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(settlementGroupSubLink)).click();
        return new SettlementGroupPage(driver);
    }

    public PlatformAccessRolePage clickOnPlatformAccessRoleSubMenu() {
        action.moveToElement(businessHierarchyManagementSubLink).build().perform();
        action.moveToElement(platformAccessRoleSubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(platformAccessRoleSubLink)).click();
        return new PlatformAccessRolePage(driver);
    }
    public BusinessHierarchyPage clickOnBusinessHierarchySubMenu() {
        action.moveToElement(businessHierarchyManagementSubLink).build().perform();
        action.moveToElement(businessHierarchySubLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(businessHierarchySubLink)).click();
        return new BusinessHierarchyPage(driver);
    }

    public void hoverOnOperatorConfigMenu() {
        action.moveToElement(operatorConfigLink).build().perform();
    }

    public MoveSystemOperatorPage clickOnMoveSystemOperatorSubMenu() {
        action.moveToElement(moveSystemOperatorLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(moveSystemOperatorLink)).click();
        return new MoveSystemOperatorPage(driver);
    }

    public RoleConfigPage clickOnRoleConfigSubMenu() {
        action.moveToElement(roleConfigLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(roleConfigLink)).click();
        return new RoleConfigPage(driver);
    }
    public SystemOperatorEntityPage clickOnSystemOperatorSubMenu() {
        action.moveToElement(systemOperatorLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(systemOperatorLink)).click();
        return new SystemOperatorEntityPage(driver);
    }
    public SystemOperatorOnboardingPage clickOnSystemOperatorOnboardingSubMenu() {
        action.moveToElement(systemOperatorOnboardingLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(systemOperatorOnboardingLink)).click();
        return new SystemOperatorOnboardingPage(driver);
    }
    public AddBlackListPage clickAddBlacklistSubMenu() {
        action.moveToElement(blackListManagementLink).build().perform();
        action.moveToElement(addBlacklistLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(addBlacklistLink)).click();
        return new AddBlackListPage(driver);
    }
    public ApplyBlackListPage clickApplyBlackListSubMenu() {
        action.moveToElement(blackListManagementLink).build().perform();
        action.moveToElement(applyBlacklistLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(applyBlacklistLink)).click();
        return new ApplyBlackListPage(driver);
    }
    public MenuConfigPage clickMenuConfigSubMenu() {
        action.moveToElement(menuConfigLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(menuConfigLink)).click();
        return new MenuConfigPage(driver);
    }
    public ProcessPage clickProcessSubMenu() {
        action.moveToElement(processLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(processLink)).click();
        return new ProcessPage(driver);
    }
    public ProcessSchedulerPage clickProcessSchedulerSubMenu() {
        action.moveToElement(processSchedulerLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(processSchedulerLink)).click();
        return new ProcessSchedulerPage(driver);
    }
    public ProcessRunDetailPage clickProcessRunDetailSubMenu() {
        action.moveToElement(processRunDetailLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(processRunDetailLink)).click();
        return new ProcessRunDetailPage(driver);
    }
    public SchedulerPage clickSchedulerSubMenu() {
        action.moveToElement(schedulerLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(schedulerLink)).click();
        return new SchedulerPage(driver);
    }
    public StandardMasterPage clickStandardMasterSubMenu() {
        action.moveToElement(standardMasterLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(standardMasterLink)).click();
        return new StandardMasterPage(driver);
    }
    public void hoverOnOperationMenu() {
        action.moveToElement(operationLink).build().perform();
    }
    public AccountManagementPage clickOnAccountManagementSubMenu() {
        action.moveToElement(fundManagementLink).build().perform();
        action.moveToElement(accountManagementLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(accountManagementLink)).click();
        return new AccountManagementPage(driver);
    }
    public FundTransferPage clickOnFundTransferSubMenu() {
        action.moveToElement(fundManagementLink).build().perform();
        action.moveToElement(fundTransferLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(fundTransferLink)).click();
        return new FundTransferPage(driver);
    }
    public AddMoneyPage clickOnAddMoneySubMenu() {
        action.moveToElement(addMoneyLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(addMoneyLink)).click();
        return new AddMoneyPage(driver);
    }
    public ResendNotificationPage clickOnResendNotificationSubMenu() {
        action.moveToElement(resendNotificationLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(resendNotificationLink)).click();
        return new ResendNotificationPage(driver);
    }
    public TransactionReversalPage clickOnTransactionReversalSubMenu() {
        action.moveToElement(transactionReversalLink).build().perform();
        wait.until(ExpectedConditions.visibilityOf(transactionReversalLink)).click();
        return new TransactionReversalPage(driver);
    }
}
