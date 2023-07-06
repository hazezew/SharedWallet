package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.pages.businessconfig.*;

public class BusinessConfigStepDef extends AbstractPage {
    private ServiceVendorPage serviceVendorPage;
    private ServiceProfilePage serviceProfilePage;
    private ServiceProviderPage serviceProviderPage;
    private ApiGroupPage apiGroupPage;
    private AccessNodePage accessNodePage;
    private AssignProviderPage assignProviderPage;
    private AuthenticationPage authenticationPage;
    private BusinessHierarchyPage businessHierarchyPage;
    private DeviceAuthenticationPage deviceAuthenticationPage;
    private NotificationPage notificationPage;
    private PlatformAccessProfilePage platformAccessProfilePage;
    private PlatformAccessRolePage platformAccessRolePage;
    private ProductManagementPage productManagementPage;
    private ResponseNodePage responseNodePage;
    private SettlementGroupPage settlementGroupPage;

    @And("web user moves mouse over Business Config main menu")
    public void webUserMovesMouseOverBusinessConfigMainMenu() {
        adminDashboardPage.hoverOnBusinessConfigMenu();
    }
    @And("web user clicks on service vendor sub menu")
    public void clicksOnUnitSubMenu() {
        serviceVendorPage = adminDashboardPage.clickOnServiceVendorSubMenu();
    }

    @Then("web system displays service vendor configuration page")
    public void webSystemDisplaysServiceVendorConfigurationPage() {
        Assert.assertEquals(Config.serviceVendorConfigurationPageURL, serviceVendorPage.getServiceVendorPageURL());
    }

    @When("web user clicks on add button for service vendor config")
    public void webUserClicksOnAddButtonForServiceVendorConfig() {
        serviceVendorPage.clickAddButton();
    }

    @And("web user fills service vendor details {string} {string} {string} and {string}")
    public void webUserFillsServiceVendorDetailsAnd(String name, String vendorType, String vendorService, String description) {
        serviceVendorPage.fillServiceVendorDetail(name,vendorType, vendorService, description);
    }

    @And("web user select {string} for service vendor status")
    public void webUserSelectForServiceVendorStatus(String status) {
        serviceVendorPage.selectStatus(status);
    }

    @And("web user fills extra service vendor details {string} {string} {string} and {string}")
    public void webUserFillsExtraServiceVendorDetailsAnd(String vendorService, String selectionAlgorithm, String sortingFunction, String lcr) {
        serviceVendorPage.fillExtraDetail(vendorService, selectionAlgorithm, sortingFunction, lcr);

    }

    @And("web user clicks on save button for service vendor")
    public void webUserClicksOnSaveButtonForServiceVendor() {
        serviceVendorPage.clickSaveButton();
    }

    @Then("web user should see the {string} service vendor is created")
    public void verifyTheServiceVendorIsCreated(String serviceVendorName) {
        serviceVendorPage.verifyServiceVendorCreated(serviceVendorName);
    }

    @And("web user clicks on view icon for {string} service vendor")
    public void clicksOnViewIconForServiceVendor(String serviceVendorName) {
        serviceVendorPage.clickViewIcon(serviceVendorName);
    }

    @And("web user delete the created service vendor")
    public void deleteTheCreatedServiceVendor() {
        serviceVendorPage.deleteServiceVendor();
    }

    @Then("web system displays validation message for service vendor config")
    public void verifyValidationMessageForServiceVendorConfig() {
        serviceVendorPage.verifyValidationMessage();
    }

    @Then("verify system displays {string} error message for service vendor")
    public void verifyErrorMessageForServiceVendor(String errorMessage) {
        serviceVendorPage.verifyErrorMessage(errorMessage);
    }

    @And("web user clicks edit button for service vendor")
    public void clicksEditButtonForServiceVendor() {
        serviceVendorPage.clickEditButton();
    }

    @When("web user update service vendor {string} and {string}")
    public void webUserUpdateServiceVendorAnd(String vendorService, String description) {
        serviceVendorPage.updateServiceVendor(vendorService, description);
    }

    @And("web user clicks on notification sub menu")
    public void clicksOnNotificationSubMenu() {
        notificationPage = adminDashboardPage.clickOnNotificationSubMenu();
    }
    @Then("web system displays notification configuration page")
    public void webSystemDisplaysNotificationConfigurationPage() {
        Assert.assertEquals(Config.notificationConfigurationPageURL, notificationPage.getNotificationPageURL());
    }
    @When("web user clicks on add button for notification")
    public void clicksOnAddButtonForNotification() {
        notificationPage.clickAddButton();
    }

    @And("web user clicks on service provider sub menu")
    public void clicksOnServiceProviderSubMenu() {
        serviceProviderPage = adminDashboardPage.clickOnServiceProviderSubMenu();
    }
    @Then("web system displays service provider configuration page")
    public void webSystemDisplaysServiceProviderConfigurationPage() {
        Assert.assertEquals(Config.serviceProviderConfigurationPageURL, serviceProviderPage.getServiceProviderPageURL());
    }
    @When("web user clicks on add button for service provider")
    public void clicksOnAddButtonForServiceProvider() {
        serviceProviderPage.clickAddButton();
    }

    @And("web user clicks on assign provider sub menu")
    public void clicksOnAssignProviderSubMenu() {
        assignProviderPage = adminDashboardPage.clickOnAssignProviderSubMenu();
    }
    @Then("web system displays assign provider configuration page")
    public void webSystemDisplaysAssignProviderConfigurationPage() {
        Assert.assertEquals(Config.assignProviderConfigurationPageURL, assignProviderPage.getAssignProviderPageURL());
    }

    @And("web user clicks on product management sub menu")
    public void clicksOnProductManagementSubMenu() {
        productManagementPage = adminDashboardPage.clickOnProductManagementSubMenu();
    }
    @Then("web system displays product management configuration page")
    public void webSystemDisplaysProductManagementConfigurationPage() {
        Assert.assertEquals(Config.productManagementConfigurationPageURL, productManagementPage.getProductManagementPageURL());
    }
    @When("web user clicks on add button for product management")
    public void clicksOnAddButtonForProductManagement() {
        productManagementPage.clickAddButton();
    }


    @And("web user clicks on response node sub menu")
    public void clicksOnResponseNodeSubMenu() {
        responseNodePage = adminDashboardPage.clickOnResponseNodeSubMenu();
    }
    @Then("web system displays response node configuration page")
    public void webSystemDisplaysResponseNodeConfigurationPage() {
        Assert.assertEquals(Config.responseNodeConfigurationPageURL, responseNodePage.getResponseNodePageURL());
    }
    @When("web user clicks on add button for response node")
    public void clicksOnAddButtonForResponseNode() {
        responseNodePage.clickAddButton();
    }


    @And("web user clicks on service profile sub menu")
    public void clicksOnServiceProfileSubMenu() {
        serviceProfilePage = adminDashboardPage.clickOnServiceProfileSubMenu();
    }
    @Then("web system displays service profile configuration page")
    public void webSystemDisplaysServiceProfileConfigurationPage() {
        Assert.assertEquals(Config.serviceProfileConfigurationPageURL, serviceProfilePage.getServiceProfilePageURL());
    }
    @When("web user clicks on add button for service profile")
    public void clicksOnAddButtonForServiceProfile() {
        serviceProfilePage.clickAddButton();
    }

    @And("web user clicks on authentication sub menu")
    public void clicksOnAuthenticationSubMenu() {
        authenticationPage = adminDashboardPage.clickOnAuthenticationSubMenu();
    }
    @Then("web system displays authentication configuration page")
    public void webSystemDisplaysAuthenticationConfigurationPage() {
        Assert.assertEquals(Config.authenticationConfigurationPageURL, authenticationPage.getAuthenticationPageURL());
    }
    @When("web user clicks on add button for authentication")
    public void clicksOnAddButtonForAuthentication() {
        authenticationPage.clickAddButton();
    }


    @And("web user clicks on device authentication sub menu")
    public void clicksOnDeviceAuthenticationSubMenu() {
        deviceAuthenticationPage = adminDashboardPage.clickOnDeviceAuthenticationSubMenu();
    }
    @Then("web system displays device authentication configuration page")
    public void webSystemDisplaysDeviceAuthenticationConfigurationPage() {
        Assert.assertEquals(Config.deviceAuthenticationConfigurationPageURL, deviceAuthenticationPage.getDeviceAuthenticationPageURL());
    }
    @When("web user clicks on add button for device authentication")
    public void clicksOnAddButtonForDeviceAuthentication() {
        deviceAuthenticationPage.clickAddButton();
    }


    @And("web user clicks on api group sub menu")
    public void clicksOnApiGroupSubMenu() {
        apiGroupPage = adminDashboardPage.clickOnApiGroupSubMenu();
    }
    @Then("web system displays api group configuration page")
    public void webSystemDisplaysApiGroupConfigurationPage() {
        Assert.assertEquals(Config.apiGroupConfigurationPageURL, apiGroupPage.getApiGroupPageURL());
    }
    @When("web user clicks on add button for api group")
    public void clicksOnAddButtonForApiGroup() {
        apiGroupPage.clickAddButton();
    }




    @And("web user clicks on access node sub menu")
    public void clicksOnAccessNodeSubMenu() {
        accessNodePage = adminDashboardPage.clickOnAccessNodeSubMenu();
    }
    @Then("web system displays access node configuration page")
    public void webSystemDisplaysAccessNodeConfigurationPage() {
        Assert.assertEquals(Config.accessNodeConfigurationPageURL, accessNodePage.getAccessNodePageURL());
    }
    @When("web user clicks on add button for access node")
    public void clicksOnAddButtonForAccessNode() {
        accessNodePage.clickAddButton();
    }

    @And("web user clicks on platform access profile sub menu")
    public void clicksOnPlatformAccessProfileSubMenu() {
        platformAccessProfilePage = adminDashboardPage.clickOnPlatformAccessProfileSubMenu();
    }
    @Then("web system displays platform access profile configuration page")
    public void webSystemDisplaysPlatformAccessProfileConfigurationPage() {
        Assert.assertEquals(Config.platformAccessProfileConfigurationPageURL, platformAccessProfilePage.getPlatformAccessProfilePageURL());
    }
    @When("web user clicks on add button for pap")
    public void clicksOnAddButtonForPlatformAccessProfile() {
        platformAccessProfilePage.clickAddButton();
    }

    @And("web user clicks on settlement group sub menu")
    public void clicksOnSettlementGroupSubMenu() {
        settlementGroupPage = adminDashboardPage.clickOnSettlementGroupSubMenu();
    }
    @Then("web system displays settlement group configuration page")
    public void webSystemDisplaysSettlementGroupConfigurationPage() {
        Assert.assertEquals(Config.settlementGroupConfigurationPageURL, settlementGroupPage.getSettlementGroupPageURL());
    }
    @When("web user clicks on add button for settlement group")
    public void clicksOnAddButtonForSettlementGroup() {
        settlementGroupPage.clickAddButton();
    }
    @And("web user clicks on platform access role sub menu")
    public void clicksOnPlatformAccessRoleSubMenu() {
        platformAccessRolePage = adminDashboardPage.clickOnPlatformAccessRoleSubMenu();
    }
    @Then("web system displays platform access role configuration page")
    public void webSystemDisplaysPlatformAccessRoleConfigurationPage() {
        Assert.assertEquals(Config.platformAccessRoleConfigurationPageURL, platformAccessRolePage.getPlatformAccessRolePageURL());
    }
    @When("web user clicks on add button for platform access role")
    public void clicksOnAddButtonForPlatformAccessRole() {
        platformAccessRolePage.clickAddButton();
    }


    @And("web user clicks on business hierarchy sub menu")
    public void clicksOnBusinessHierarchySubMenu() {
        businessHierarchyPage = adminDashboardPage.clickOnBusinessHierarchySubMenu();
    }
    @Then("web system displays business hierarchy configuration page")
    public void webSystemDisplaysBusinessHierarchyConfigurationPage() {
        Assert.assertEquals(Config.businessHierarchyConfigurationPageURL, businessHierarchyPage.getBusinessHierarchyPageURL());
    }
}
