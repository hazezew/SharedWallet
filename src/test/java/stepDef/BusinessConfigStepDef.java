package stepDef;

import util.PropertiesReader;
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
    public void webSystemDisplaysServiceVendorConfigurationPage() throws Exception {
        Assert.assertEquals(serviceVendorPage.getServiceVendorPageURL(), PropertiesReader.getValue("serviceVendorConfigurationPageURL"));
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

    @When("web user click on filter icon for service vendor")
    public void clickOnFilterIconForServiceVendor() {
        serviceVendorPage.clickFilterIcon();
    }

    @And("web user enters {string} into service vendor search name field")
    public void enterSearchedKeyword(String serviceVendorName) {
        serviceVendorPage.enterNameInToSearchField(serviceVendorName);
    }

    @And("web user select {string} for the search service vendor filter criteria")
    public void selectSearchServiceVendorFilterCriteria(String criteria) {
        serviceVendorPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search service vendor button")
    public void clicksSearchServiceVendorButton() {
        serviceVendorPage.clickSearchButton();
    }

    @Then("web system displays a list of service vendors with {string} on the name")
    public void verifySearchResults(String serviceVendorName) {
        serviceVendorPage.verifyServiceVendorSearchResults(serviceVendorName);
    }


    @And("web user clicks on notification sub menu")
    public void clicksOnNotificationSubMenu() {
        notificationPage = adminDashboardPage.clickOnNotificationSubMenu();
    }
    @Then("web system displays notification configuration page")
    public void webSystemDisplaysNotificationConfigurationPage() throws Exception {
        Assert.assertEquals(notificationPage.getNotificationPageURL(),
                PropertiesReader.getValue("notificationConfigurationPageURL"));
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
    public void webSystemDisplaysServiceProviderConfigurationPage() throws Exception {
        Assert.assertEquals(serviceProviderPage.getServiceProviderPageURL(),
                PropertiesReader.getValue("serviceProviderConfigurationPageURL"));
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
    public void webSystemDisplaysAssignProviderConfigurationPage() throws Exception {
        Assert.assertEquals(assignProviderPage.getAssignProviderPageURL(),
                PropertiesReader.getValue("assignProviderConfigurationPageURL"));
    }

    @And("web user clicks on product management sub menu")
    public void clicksOnProductManagementSubMenu() {
        productManagementPage = adminDashboardPage.clickOnProductManagementSubMenu();
    }
    @Then("web system displays product management configuration page")
    public void webSystemDisplaysProductManagementConfigurationPage() throws Exception {
        Assert.assertEquals(productManagementPage.getProductManagementPageURL(),
                PropertiesReader.getValue("productManagementConfigurationPageURL"));
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
    public void webSystemDisplaysResponseNodeConfigurationPage() throws Exception {
        Assert.assertEquals(responseNodePage.getResponseNodePageURL(),
                PropertiesReader.getValue("responseNodeConfigurationPageURL"));
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
    public void webSystemDisplaysServiceProfileConfigurationPage() throws Exception {
        Assert.assertEquals(serviceProfilePage.getServiceProfilePageURL(),
                PropertiesReader.getValue("serviceProfileConfigurationPageURL"));
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
    public void webSystemDisplaysAuthenticationConfigurationPage() throws Exception {
        Assert.assertEquals(authenticationPage.getAuthenticationPageURL(),
                PropertiesReader.getValue("authenticationConfigurationPageURL"));
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
    public void webSystemDisplaysDeviceAuthenticationConfigurationPage() throws Exception {
        Assert.assertEquals(deviceAuthenticationPage.getDeviceAuthenticationPageURL(),
                PropertiesReader.getValue("deviceAuthenticationConfigurationPageURL"));
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
    public void webSystemDisplaysApiGroupConfigurationPage() throws Exception {
        Assert.assertEquals(apiGroupPage.getApiGroupPageURL(),
                PropertiesReader.getValue("apiGroupConfigurationPageURL"));
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
    public void webSystemDisplaysAccessNodeConfigurationPage() throws Exception {
        Assert.assertEquals(accessNodePage.getAccessNodePageURL(),
                PropertiesReader.getValue("accessNodeConfigurationPageURL"));
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
    public void webSystemDisplaysPlatformAccessProfileConfigurationPage() throws Exception {
        Assert.assertEquals(platformAccessProfilePage.getPlatformAccessProfilePageURL(),
                PropertiesReader.getValue("platformAccessProfileConfigurationPageURL"));
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
    public void webSystemDisplaysSettlementGroupConfigurationPage() throws Exception {
        Assert.assertEquals(settlementGroupPage.getSettlementGroupPageURL(),
                PropertiesReader.getValue("settlementGroupConfigurationPageURL"));
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
    public void webSystemDisplaysPlatformAccessRoleConfigurationPage() throws Exception {
        Assert.assertEquals(platformAccessRolePage.getPlatformAccessRolePageURL(),
                PropertiesReader.getValue("platformAccessRoleConfigurationPageURL"));
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
    public void webSystemDisplaysBusinessHierarchyConfigurationPage() throws Exception {
        Assert.assertEquals(businessHierarchyPage.getBusinessHierarchyPageURL(),
                PropertiesReader.getValue("businessHierarchyConfigurationPageURL"));
    }

    @And("web user adds service provider detail {string} {string} {string} {string}")
    public void addServiceProviderDetail(String name, String providerService, String oEt, String description) {
        serviceProviderPage.addServiceProviderDetail(name, providerService, oEt, description);
    }

    @And("web user adds provider api detail {string} {string} {string} {string}")
    public void addProviderApiDetail(String providerName, String commProtocol, String successCode, String failureCode) {
        serviceProviderPage.addProviderApiDetail(providerName,commProtocol,successCode, failureCode);
    }

    @And("web user adds api details Api url {string} {string} http protocol as {string} request type as {string} response type {string}")
    public void addApiDetail(String apiUrl, String httpType, String httpProtocol, String requestType, String responseType) {
        serviceProviderPage.addApiDetail(apiUrl, httpType, httpProtocol, requestType, responseType);
    }

    @And("web user adds Header Mapping details Api field {string} Packet field {string} default value {string}")
    public void addHeaderMappingDetails(String apiField, String packetField, String defaultValue) {
        serviceProviderPage.addHeaderMappingDetail(apiField, packetField, defaultValue);
    }

    @And("web user adds Request Mapping details with {string} Api field {string} Packet field {string} default value {string} api template {string}")
    public void addRequestMappingDetail(String httpType, String apiField, String packetField, String defaultValue, String apiTemplate) {
        serviceProviderPage.addRequestMappingDetail(httpType, apiField, packetField, defaultValue, apiTemplate);

    }
    @And("web user adds Response Mapping details Api field {string} Packet field {string} default value {string}")
    public void addResponseMappingDetail(String apiField, String packetField, String defaultValue) {
        serviceProviderPage.addResponseMappingDetail(apiField, packetField, defaultValue);

    }
    @And("web user click submit button")
    public void clickSubmitButton() {
        serviceProviderPage.clickSubmitButton();
    }
    @Then("web user should see the {string} service provider is created")
    public void verifyTheServiceProviderIsCreated(String serviceProviderName) {
        serviceProviderPage.verifyServiceProviderCreated(serviceProviderName);
    }

    @And("web user clicks on view icon for {string} service provider")
    public void clicksOnViewIconForServiceProvider(String serviceProviderName) {
        serviceProviderPage.clickViewIcon(serviceProviderName);
    }

    @And("web user delete the created service provider")
    public void deleteTheCreatedServiceProvider() {
        serviceProviderPage.deleteServiceProvider();
    }

    @And("web user clicks on add service button")
    public void clicksOnAddServiceButton() {
        serviceProviderPage.clickAddServiceButton();
    }

    @And("web user add provider service as {string}")
    public void addProviderServiceAs(String providerServiceName) {
        serviceProviderPage.addProviderService(providerServiceName);
    }

    @And("web user clicks on edit button")
    public void clicksOnEditButton() {
        serviceProviderPage.clickEditButton();
    }

    @And("web user update provider OE as {string} api {string} url {string} http type {string} template {string}")
    public void updateProviderService(String OET, String api, String apiUrl, String httpType, String template) {
        serviceProviderPage.updateServiceProvider(OET, api, apiUrl, httpType, template);
    }

    @And("web user clicks on next button")
    public void clicksOnNextButton() {
        serviceProviderPage.clickNextButton();
    }
    @Then("web system displays validation message for service provider")
    public void verifyValidationMessageForServiceProviderConfig() {
        serviceProviderPage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for service provider")
    public void verifyErrorMessageForServiceProvider(String errorMessage) {
        serviceProviderPage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for service provider")
    public void clickOnFilterIconForServiceProvider() {
        serviceProviderPage.clickFilterIcon();
    }

    @And("web user enters {string} into service provider search name field")
    public void enterSearchedKeywordForProvider(String serviceProvider) {
        serviceProviderPage.enterNameInToSearchField(serviceProvider);
    }

    @And("web user select {string} for the search service provider filter criteria")
    public void selectSearchServiceProviderFilterCriteria(String criteria) {
        serviceProviderPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search service provider button")
    public void clicksSearchServiceProviderButton() {
        serviceProviderPage.clickSearchButton();
    }

    @Then("web system displays a list of service providers with {string} on the name")
    public void verifySearchResultsForProvider(String serviceProvider) {
        serviceProviderPage.verifyServiceProviderSearchResults(serviceProvider);
    }

    @And("web user clicks on export button for service provider")
    public void clicksOnExportButtonForService() {
        serviceProviderPage.clickExportButton();
    }

    @And("web user enters {string} and {string} into service provider export fields")
    public void entersAndIntoServiceExportFields(String name, String description) {
        serviceProviderPage.fillExportDetail(name, description);

    }

    @And("web user clicks save export history button for service provider")
    public void clicksSaveExportHistoryButtonForService() {
        serviceProviderPage.clickExportHistoryButton();
    }

    @Then("web user verify {string} record created in service provider export history")
    public void verifyRecordCreatedInServiceExportHistory(String exportName) {
        serviceProviderPage.verifyExportHistory(exportName);
    }

    @And("web user add notification detail {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void addNotificationDetail(String name, String notificationType, String description, String notificationCategory, String vendor, String vendorService, String mobileNumber, String fromEmail, String email) {
        notificationPage.addNotification(name, notificationType, description, notificationCategory,vendor, vendorService, mobileNumber, fromEmail, email);
    }

    @And("web user clicks on save button for notification")
    public void clickSaveButton() {
        notificationPage.clickSaveButton();
    }
    @Then("web user should see the {string} notification is created")
    public void verifyTheNotificationIsCreated(String notificationName) {
        notificationPage.verifyNotificationCreated(notificationName);
    }

    @And("web user clicks on view icon for {string} notification")
    public void clicksOnViewIconForNotification(String notificationName) {
        notificationPage.clickViewIcon(notificationName);
    }

    @And("web user delete the created notification")
    public void deleteTheCreatedNotification() {
        notificationPage.deleteNotification();
    }

    @And("web user clicks on edit button for notification")
    public void clickEditButton() {
        notificationPage.clickEditButton();
    }

    @And("web user update notification with type {string} username {string} category {string} Error code {string} and email {string}")
    public void updateNotificationConfiguration(String notificationType, String username, String category, String errorCode, String email) {
        notificationPage.updateNotification(notificationType, username, category, errorCode, email);
    }
    @Then("web system displays validation message for notification")
    public void verifyValidationMessageForNotificationConfig() {
        notificationPage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for notification")
    public void verifyErrorMessageForNotification(String errorMessage) {
        notificationPage.verifyErrorMessage(errorMessage);
    }


    @When("web user click on filter icon for notification")
    public void clickOnFilterIconForNotification() {
        notificationPage.clickFilterIcon();
    }

    @And("web user enters {string} into notification search name field")
    public void enterSearchedKeywordForNotification(String notificationName) {
        notificationPage.enterNameInToSearchField(notificationName);
    }

    @And("web user select {string} for the search notification filter criteria")
    public void selectSearchNotificationFilterCriteria(String criteria) {
        notificationPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search notification button")
    public void clicksSearchNotificationButton() {
        notificationPage.clickSearchButton();
    }

    @Then("web system displays a list of notifications with {string} on the name")
    public void verifySearchResultsForNotification(String notificationName) {
        notificationPage.verifyNotificationSearchResults(notificationName);
    }


    @When("web user click on filter icon for assign provider")
    public void clickOnFilterIconForAssignProvider() {
        assignProviderPage.clickFilterIcon();
    }

    @And("web user enters {string} into assign provider search name field")
    public void enterSearchedKeywordForAssignProvider(String vendorName) {
        assignProviderPage.enterNameInToSearchField(vendorName);
    }

    @And("web user select {string} for the search assign provider filter criteria")
    public void selectSearchAssignProviderFilterCriteria(String criteria) {
        assignProviderPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search assign provider button")
    public void clicksSearchAssignProviderButton() {
        assignProviderPage.clickSearchButton();
    }

    @Then("web system displays a list of assign providers with {string} on the name")
    public void verifySearchResultsForAssignProvider(String vendorName) {
        assignProviderPage.verifyAssignProviderSearchResults(vendorName);
    }

    @When("web user click on filter icon for product management")
    public void clickOnFilterIconForProductManagement() {
        productManagementPage.clickFilterIcon();
    }

    @And("web user enters {string} into product management search name field")
    public void enterSearchedKeywordForProductManagement(String vendorName) {
        productManagementPage.enterNameInToSearchField(vendorName);
    }

    @And("web user select {string} for the search product management filter criteria")
    public void selectSearchProductManagementFilterCriteria(String criteria) {
        productManagementPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search product management button")
    public void clicksSearchProductManagementButton() {
        productManagementPage.clickSearchButton();
    }

    @Then("web system displays a list of product managements with {string} on the name")
    public void verifySearchResultsForProductManagement(String vendorName) {
        productManagementPage.verifyVendorSearchResults(vendorName);
    }

    @And("web user add response node detail {string} {string} {string} {string}")
    public void addResponseNode(String name, String description, String message, String responseCode) {
        responseNodePage.addResponseNode(name, description, message, responseCode);
    }

    @And("web user click save button for response node")
    public void clickSaveButtonForResponseNode() {
        responseNodePage.clickSaveButton();
    }
    @Then("web user should see the {string} response node is created")
    public void verifyTheResponseNodeIsCreated(String responseNodeName) {
        responseNodePage.verifyResponseNodeCreated(responseNodeName);
    }

    @And("web user clicks on view icon for {string} response node")
    public void clicksOnViewIconForResponseNode(String responseNodeName) {
        responseNodePage.clickViewIcon(responseNodeName);
    }

    @And("web user delete the created response node")
    public void deleteTheCreatedResponseNode() {
        responseNodePage.deleteResponseNode();
    }

    @And("web user clicks on edit button for response node")
    public void clickEditButtonForResponseNode() {
        responseNodePage.clickEditButton();
    }

    @And("web user update response node {string} {string} {string}")
    public void webUserUpdateResponseNode(String description, String responseCode, String message) {
        responseNodePage.updateResponseNode(description, responseCode, message);
    }
    @Then("verify system displays {string} error message for response node")
    public void verifyErrorMessageForResponseNode(String errorMessage) {
        responseNodePage.verifyErrorMessage(errorMessage);
    }
    @Then("web system displays validation message for response node")
    public void verifyValidationMessageForResponseNodeConfig() {
        responseNodePage.verifyValidationMessage();
    }

    @When("web user click on filter icon for response node")
    public void clickOnFilterIconForResponseNode() {
        responseNodePage.clickFilterIcon();
    }

    @And("web user enters {string} into response node search name field")
    public void enterSearchedKeywordForResponseNode(String responseNodeName) {
        responseNodePage.enterNameInToSearchField(responseNodeName);
    }

    @And("web user select {string} for the search response node filter criteria")
    public void selectSearchResponseNodeFilterCriteria(String criteria) {
        responseNodePage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search response node button")
    public void clicksSearchResponseNodeButton() {
        responseNodePage.clickSearchButton();
    }

    @Then("web system displays a list of response nodes with {string} on the name")
    public void verifySearchResultsForResponseNode(String responseNodeName) {
        responseNodePage.verifyResponseNodeSearchResults(responseNodeName);
    }

    @And("web user add service profile detail {string} {string} {string} {string}")
    public void addServiceProfileDetail(String name, String description, String type, String status) {
        serviceProfilePage.addServiceProfile(name, description, type, status);
    }

    @And("web user configure service profile tree {string} {string} {string} {string}")
    public void configureServiceProfileTree(String accessChannel, String service, String product, String ucpGroup) {
        serviceProfilePage.configureServiceProfileTree(accessChannel,service,product,ucpGroup);
    }

    @And("web user click save button for service profile")
    public void clickSaveButtonForSP() {
        serviceProfilePage.clickSaveButton();
    }
    @Then("web user should see the {string} service profile is created")
    public void verifyTheServiceProfileIsCreated(String serviceProfileName) {
        serviceProfilePage.verifyServiceProfileCreated(serviceProfileName);
    }

    @And("web user clicks on view icon for {string} service profile")
    public void clicksOnViewIconForServiceProfile(String serviceProfileName) {
        serviceProfilePage.clickViewIcon(serviceProfileName);
    }

    @And("web user delete the created service profile")
    public void deleteTheCreatedServiceProfile() {
        serviceProfilePage.deleteServiceProfile();
    }

    @When("web user clicks on edit button for service profile")
    public void clickEditButtonForServiceProfile() {
        serviceProfilePage.clickEditButton();
    }

    @And("web user update service profile description {string} and type {string}")
    public void updateServiceProfile(String description, String type) {
        serviceProfilePage.updateServiceProfile(description, type);
    }
    @Then("web system displays validation message for service profile")
    public void verifyValidationMessageForServiceProfile() {
        serviceProfilePage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for service profile")
    public void verifyErrorMessageForServiceProfile(String errorMessage) {
        serviceProfilePage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for service profile")
    public void clickOnFilterIconForServiceProfile() {
        serviceProfilePage.clickFilterIcon();
    }

    @And("web user enters {string} into service profile search name field")
    public void enterSearchedKeywordForProfile(String serviceProfile) {
        serviceProfilePage.enterNameInToSearchField(serviceProfile);
    }

    @And("web user select {string} for the search service profile filter criteria")
    public void selectSearchServiceProfileFilterCriteria(String criteria) {
        serviceProfilePage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search service profile button")
    public void clicksSearchServiceProfileButton() {
        serviceProfilePage.clickSearchButton();
    }

    @Then("web system displays a list of service profiles with {string} on the name")
    public void verifySearchResultsForProfile(String serviceProvider) {
        serviceProfilePage.verifyServiceProfileSearchResults(serviceProvider);
    }

    @When("web user add authentication detail {string} {string} {string} {string} {string} {string} {string} {string}")
    public void addAuthenticationConfig(String name, String description, String papType, String authenticationType, String credParameter, String faType, String length, String packet) {
        authenticationPage.addAuthenticationConfig(name, description, papType, authenticationType, credParameter,faType, length, packet);
    }

    @And("web user click save button for authentication")
    public void clickSaveButtonForAuthentication() {
        authenticationPage.clickSaveButton();
    }
    @Then("web user should see the {string} authentication is created")
    public void verifyTheAuthenticationIsCreated(String authenticationName) {
        authenticationPage.verifyAuthenticationCreated(authenticationName);
    }

    @And("web user clicks on view icon for {string} authentication")
    public void clicksOnViewIconForAuthentication(String authenticationName) {
        authenticationPage.clickViewIcon(authenticationName);
    }

    @And("web user delete the created authentication")
    public void deleteTheCreatedAuthentication() {
        authenticationPage.deleteAuthentication();
    }

    @And("web user click on edit button for authentication")
    public void clickEditButtonForAuthentication() {
        authenticationPage.clickEditButton();
    }

    @And("web user update authentication with pap node {string} fa type {string} length {string} packet field {string}")
    public void updateAuthenticationConfig(String papNodeType, String faType, String length, String packetField) {
        authenticationPage.updateAuthenticationConfig(papNodeType,faType,length,packetField);
    }
    @Then("web system displays validation message for authentication")
    public void verifyValidationMessageForAuthenticationConfig() {
        authenticationPage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for authentication")
    public void verifyErrorMessageForAuthentication(String errorMessage) {
        authenticationPage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for authentication")
    public void clickOnFilterIconForAuthentication() {
        authenticationPage.clickFilterIcon();
    }

    @And("web user enters {string} into authentication search name field")
    public void enterSearchedKeywordForAuthentication(String authenticationName) {
        authenticationPage.enterNameInToSearchField(authenticationName);
    }

    @And("web user select {string} for the search authentication filter criteria")
    public void selectSearchAuthenticationFilterCriteria(String criteria) {
        authenticationPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search authentication button")
    public void clicksSearchAuthenticationButton() {
        authenticationPage.clickSearchButton();
    }

    @Then("web system displays a list of authentications with {string} on the name")
    public void verifySearchResultsForAuthentication(String authenticationName) {
        authenticationPage.verifyAuthenticationSearchResults(authenticationName);
    }

    @And("web user add device authentication {string} {string} {string} {string} {string} {string}")
    public void addDeviceAuthentication(String name, String description, String allowedGeoRadius, String deviceStatus, String packetField, String parameter1) {
        deviceAuthenticationPage.addDeviceAuthentication(name, description, allowedGeoRadius, deviceStatus,packetField, parameter1);
    }


    @And("web user click save button for device authentication")
    public void clickSaveButtonForDeviceAuthentication() {
        deviceAuthenticationPage.clickSaveButton();
    }
    @Then("web user should see the {string} device authentication is created")
    public void verifyTheDeviceAuthenticationIsCreated(String authenticationName) {
        deviceAuthenticationPage.verifyDeviceAuthenticationCreated(authenticationName);
    }

    @And("web user clicks on view icon for {string} device authentication")
    public void clicksOnViewIconForDeviceAuthentication(String authenticationName) {
        deviceAuthenticationPage.clickViewIcon(authenticationName);
    }

    @And("web user delete the created device authentication")
    public void deleteTheCreatedDeviceAuthentication() {
        deviceAuthenticationPage.deleteDeviceAuthentication();
    }

    @And("web user click on edit button for device authentication")
    public void clickEditButtonForDeviceAuthentication() {
        deviceAuthenticationPage.clickEditButton();
    }
    @And("web user update device authentication config des {string} radius {string} status {string} parameter {string}")
    public void webUserUpdateDeviceAuthenticationConfigDesRadiusStatusParameter(String description, String radius, String status, String parameter) {
        deviceAuthenticationPage.updateDeviceAuthentication(description, radius, status, parameter);
    }
    @Then("web system displays validation message for device authentication")
    public void verifyValidationMessageForDeviceAuthenticationConfig() {
        deviceAuthenticationPage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for device authentication")
    public void verifyErrorMessageForDeviceAuthentication(String errorMessage) {
        deviceAuthenticationPage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for device authentication")
    public void clickOnFilterIconForDeviceAuthentication() {
        deviceAuthenticationPage.clickFilterIcon();
    }

    @And("web user enters {string} into device authentication search name field")
    public void enterSearchedKeywordForDeviceAuthentication(String deviceAuthenticationName) {
        deviceAuthenticationPage.enterNameInToSearchField(deviceAuthenticationName);
    }

    @And("web user select {string} for the search device authentication filter criteria")
    public void selectSearchDeviceAuthenticationFilterCriteria(String criteria) {
        deviceAuthenticationPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search device authentication button")
    public void clicksSearchDeviceAuthenticationButton() {
        deviceAuthenticationPage.clickSearchButton();
    }

    @Then("web system displays a list of device authentications with {string} on the name")
    public void verifySearchResultsForDeviceAuthentication(String deviceAuthenticationName) {
        deviceAuthenticationPage.verifyDeviceAuthenticationSearchResults(deviceAuthenticationName);
    }

    @And("web user add api group config {string} {string} {string} and {string}")
    public void addApiGroupConfig(String name, String description, String allowedApi, String status) {
        apiGroupPage.addApiGroupConfig(name, description, allowedApi, status);
    }

    @And("web user click save button for api group")
    public void clickSaveButtonForApiGroup() {
        apiGroupPage.clickSaveButton();
    }
    @Then("web user should see the {string} api group is created")
    public void verifyTheApiGroupIsCreated(String apiGroupName) {
        apiGroupPage.verifyApiGroupCreated(apiGroupName);
    }

    @And("web user clicks on view icon for {string} api group")
    public void clicksOnViewIconForApiGroup(String apiGroupName) {
        apiGroupPage.clickViewIcon(apiGroupName);
    }

    @And("web user delete the created api group")
    public void deleteTheCreatedApiGroup() {
        apiGroupPage.deleteApiGroup();
    }

    @And("web user click on edit button for api group")
    public void clickEditForApiGroup() {
        apiGroupPage.clickEditButton();
    }

    @And("web user update api group descripiton {string} allowed api {string} {string}")
    public void updateApiGroup(String description, String allowedApi1, String allowedApi2) {
        apiGroupPage.updateApiGroup(description, allowedApi1, allowedApi2);
    }
    @Then("web system displays validation message for api group")
    public void verifyValidationMessageForApiGroupConfig() {
        apiGroupPage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for api group")
    public void verifyErrorMessageForApiGroup(String errorMessage) {
        apiGroupPage.verifyErrorMessage(errorMessage);
    }


    @When("web user click on filter icon for api group")
    public void clickOnFilterIconForApiGroup() {
        apiGroupPage.clickFilterIcon();
    }

    @And("web user enters {string} into api group search name field")
    public void enterSearchedKeywordForApiGroup(String apiGroupName) {
        apiGroupPage.enterNameInToSearchField(apiGroupName);
    }

    @And("web user select {string} for the search api group filter criteria")
    public void selectSearchApiGroupFilterCriteria(String criteria) {
        apiGroupPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search api group button")
    public void clicksSearchApiGroupButton() {
        apiGroupPage.clickSearchButton();
    }

    @Then("web system displays a list of api groups with {string} on the name")
    public void verifySearchResultsForApiGroup(String apiGroupName) {
        apiGroupPage.verifyApiGroupSearchResults(apiGroupName);
    }

    @And("web user add access node {string} {string} {string} {string} {string}")
    public void addAccessNode(String name, String description, String accessType, String message, String accessCode) {
        accessNodePage.addAccessNode(name, description, accessType, message, accessCode);
    }

    @And("web user click save button for access node")
    public void clickSaveButtonForAccessNode() {
        accessNodePage.clickSaveButton();
    }
    @Then("web user should see the {string} access node is created")
    public void verifyTheAccessNodeIsCreated(String accessNodeName) {
        accessNodePage.verifyAccessNodeCreated(accessNodeName);
    }

    @And("web user clicks on view icon for {string} access node")
    public void clicksOnViewIconForAccessNode(String accessNodeName) {
        accessNodePage.clickViewIcon(accessNodeName);
    }

    @And("web user delete the created access node")
    public void deleteTheCreatedAccessNode() {
        accessNodePage.deleteAccessNode();
    }
    @Then("web system displays validation message for access node")
    public void verifyValidationMessageForAccessNodeConfig() {
        accessNodePage.verifyValidationMessage();
    }
    @Then("verify system displays {string} error message for access node")
    public void verifyErrorMessageForAccessNode(String errorMessage) {
        accessNodePage.verifyErrorMessage(errorMessage);
    }

    @And("web user click on edit button for access node")
    public void clickOnEditButtonForAccessNode() {
        accessNodePage.clickEditButton();
    }
    @And("web user update access node config {string} {string} {string} {string}")
    public void updateAccessNode(String description, String accessType, String message, String accessCode) {
        accessNodePage.updateAccessNode(description, accessType, message, accessCode);
    }

    @When("web user click on filter icon for access node")
    public void clickOnFilterIconForAccessNode() {
        accessNodePage.clickFilterIcon();
    }

    @And("web user enters {string} into access node search name field")
    public void enterSearchedKeywordForAccessNode(String accessNodeName) {
        accessNodePage.enterNameInToSearchField(accessNodeName);
    }

    @And("web user select {string} for the search access node filter criteria")
    public void selectSearchAccessNodeFilterCriteria(String criteria) {
        accessNodePage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search access node button")
    public void clicksSearchAccessNodeButton() {
        accessNodePage.clickSearchButton();
    }

    @Then("web system displays a list of access nodes with {string} on the name")
    public void verifySearchResultsForAccessNode(String accessNodeName) {
        accessNodePage.verifyAccessNodeSearchResults(accessNodeName);
    }

    @And("web user add PAP config  {string} {string} {string} {string} {string}")
    public void webUserAddPAPConfig(String name, String description, String apiGroup, String accessChannel, String authentication) {
        platformAccessProfilePage.addPapConfig(name, description, apiGroup, accessChannel, authentication);
    }

    @And("web user click save button for pap")
    public void clickSaveButtonForPAP() {
        platformAccessProfilePage.clickSaveButton();
    }
    @Then("web user should see the {string} pap is created")
    public void verifyThePAPIsCreated(String papName) {
        platformAccessProfilePage.verifyPAPCreated(papName);
    }

    @And("web user clicks on view icon for {string} pap")
    public void clicksOnViewIconForPAP(String papName) {
        platformAccessProfilePage.clickViewIcon(papName);
    }

    @And("web user delete the created pap")
    public void deleteTheCreatedPAP() {
        platformAccessProfilePage.deletePAP();
    }
    @Then("web system displays validation message for pap")
    public void verifyValidationMessageForPAPConfig() {
        platformAccessProfilePage.verifyValidationMessage();
    }

    @And("web user click on edit button for pap")
    public void clickOnEditButtonForPap() {
        platformAccessProfilePage.clickEditButton();
    }

    @And("web user update pap detail {string} {string} {string}")
    public void webUserUpdatePapDetail(String description, String apiGroup, String accessChannel) {
        platformAccessProfilePage.updatePAP(description, apiGroup, accessChannel);
    }
    @Then("verify system displays {string} error message for pap")
    public void verifyErrorMessageForPAP(String errorMessage) {
        platformAccessProfilePage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for pap")
    public void clickOnFilterIconForPAP() {
        platformAccessProfilePage.clickFilterIcon();
    }

    @And("web user enters {string} into pap search name field")
    public void enterSearchedKeywordForPAP(String papName) {
        platformAccessProfilePage.enterNameInToSearchField(papName);
    }

    @And("web user select {string} for the search pap filter criteria")
    public void selectSearchPAPFilterCriteria(String criteria) {
        platformAccessProfilePage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search pap button")
    public void clicksSearchPAPButton() {
        platformAccessProfilePage.clickSearchButton();
    }

    @Then("web system displays a list of paps with {string} on the name")
    public void verifySearchResultsForPAP(String papName) {
        platformAccessProfilePage.verifyPAPSearchResults(papName);
    }
}
