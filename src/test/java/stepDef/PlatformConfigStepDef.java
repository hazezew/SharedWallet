package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObj.web.*;
import pageObj.web.pages.platformconfig.NotificationTemplatePage;
import pageObj.web.pages.platformconfig.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;


public class PlatformConfigStepDef extends AbstractPage {

    private ParameterPage parameterConfigPage;
    private UserCategoryPage userCategoryPage;
    private UnitPage unitPage;
    private PouchPage pouchPage;
    private WalletPage walletPage;
    private WalletTemplatePage walletTemplatePage;
    private KycManagementPage kycManagementPage;
    private ServicePage servicePage;
    private AccessChannelPage accessChannelPage;
    private UnitCreditPolicyPage unitCreditPolicyPage;
    private UcpGroupPage ucpGroupPage;
    private CounterPage counterPage;
    private RulePage rulePage;
    private ProductPage productPage;
    private ProductGroupPage productGroupPage;
    private NotificationTemplatePage notificationTemplatePage;
    @And("web user moves mouse over Platform Config main menu")
    public void webUserMovesMouseOverPlatformConfigMainMenu() {
        adminDashboardPage.hoverOnPlatformConfigMenu();
    }

    @And("web user clicks on Parameter sub menu")
    public void webUserClicksOnParameterSubMenu() {
        parameterConfigPage = adminDashboardPage.clickOnParameterSubMenu();
    }

    @Then("web system displays Parameter Configuration page")
    public void webSystemDisplaysUpdateUserProfilePage() {
        Assert.assertEquals(Config.parameterConfigurationPageURL, parameterConfigPage.getParameterConfigPageURL());
    }

    @When("web user click on Add button")
    public void webUserClickOnAddButton() {
        parameterConfigPage.clickAddButton();
    }

    @And("web user fills in the parameter details for {string}, {string}, {string}, {string}, {string},{string}, and {string}")
    public void theUserFillsInTheParameterDetailsForAnd(String parameterName, String displayName, String description, String usedBy, String fieldType, String componentType, String dataType) {
        parameterConfigPage.fillParameterDetails(parameterName, displayName, description, usedBy, fieldType, componentType, dataType);
    }

    @And("web user click Add Field button on the Extra Details")
    public void clickAddFieldButtonOnTheExtraDetails() {
        parameterConfigPage.clickAddFieldButton();
    }

    @And("web user enters {string} and {string}")
    public void addExtraParameter(String key, String value) {
        parameterConfigPage.inputExtraParameter(key, value);
    }

    @When("web user click save button")
    public void clickSaveButton() {
        parameterConfigPage.clickSaveButton();
    }

    @Then("web user should see the {string} parameter is created")
    public void verifyTheParameterIsCreated(String parameterName) {
        parameterConfigPage.verifyTheParameterIsCreated(parameterName);
    }

    @And("web user enters {string} into Validation Message Field")
    public void inputValidationMessageField(String validationMessage) {
        parameterConfigPage.enterValidationMessage(validationMessage);
    }

    @And("web user fills in the parameter details for {string}, {string}, {string}, {string} and {string}")
    public void webUserFillsInTheParameterDetails(String parameterName, String displayName, String description, String usedBy, String fieldType) {
        parameterConfigPage.fillInTheParameterDetails(parameterName, displayName, description, usedBy, fieldType);
    }

    @And("web user selects {string} for allow multiple option")
    public void webUserSelectsForAllowMultipleOption(String allowMultipleOption) {
        driver.findElement(By.xpath("//span[text()='" + allowMultipleOption + "']")).click();
    }

    @And("web user enters {string} into Allowed Limit text field")
    public void enterIntoAllowedLimitTextField(String allowedLimitValue) {
        parameterConfigPage.setAllowedLimit(allowedLimitValue);
    }

    @And("web user add child fields for the aggregator parameter")
    public void addChildFields() {
        parameterConfigPage.addChildField();
    }

    @Then("verify system displays {string} error message for parameter")
    public void verifySystemDisplaysErrorMessageForParameter(String errorMessage) {
        parameterConfigPage.verifyDuplicatedValidationMessage(errorMessage);
    }

    @Then("web system displays validation message")
    public void verifyValidationMessage() {
        Assert.assertEquals("Error Message", parameterConfigPage.getParameterConfigPageURL());
    }

    @Then("web system displays validation message {string}")
    public void webSystemDisplaysValidationMessage(String expectedValidationMessage) {
        List<WebElement> errorMessages = driver.findElements(By.xpath("//div[@class='ant-form-explain']"));
        List<String> actualErrorMessages = new ArrayList<>();
        for (WebElement errorMessage : errorMessages) {
            actualErrorMessages.add(errorMessage.getText());
        }
        assertTrue(actualErrorMessages.contains(expectedValidationMessage));
    }

    @And("web user clicks on User Category sub menu")
    public void clicksOnUserCategorySubMenu() {
        userCategoryPage = adminDashboardPage.clickOnUserCategorySubMenu();
    }

    @Then("web system displays User Category Configuration page")
    public void verifyUserCategoryConfigurationPage() {
        Assert.assertEquals(Config.userCategoryConfigurationPageURL, userCategoryPage.getUserCategoryPageURL());
    }

    @When("web user clicks on Add button for User Category")
    public void clicksOnAddButtonForUserCategory() {
        userCategoryPage.clickOnAddButton();
    }

    @And("web user fills user category details for {string}, {string}, {string}")
    public void fillsUserCategoryDetails(String name, String category, String description) {
        userCategoryPage.fillUserCategoryDetail(name, category, description);
    }

    @And("web user click Remove Button for Extra Field")
    public void clickRemoveButtonForExtraField() {
        parameterConfigPage.clickRemoveButtonForExtraField();
    }

    @Then("web system displays error message {string}")
    public void verifyErrorMessage(String ExpectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.xpath("//span[@class='ant-alert-description']")).getText();
        Assert.assertEquals(actualErrorMessage, ExpectedErrorMessage);
    }

    @And("web user clicks add identifier field")
    public void clicksAddIdentifierField() {
        userCategoryPage.clickOnAddIdentifierField();
    }

    @And("web user fills identifier {string} and {string} and credential {string} and {string} fields")
    public void fillIdentifierAndCredentialFields(String identifier1, String identifier2, String credential1, String credential2) {
        userCategoryPage.fillIdentifierField(identifier1, identifier2, credential1, credential2);
    }

    @Then("web user click view icon for {string} parameter")
    public void clickViewIconForParameter(String parameterName) {
        parameterConfigPage.clickViewIcon(parameterName);
    }

    @Then("web user delete the created parameter")
    public void clickDeleteButton() {
        parameterConfigPage.clickDeleteButton();
    }

    @Then("web user click edit icon for parameter")
    public void clickEditIconForParameter() {
        parameterConfigPage.clickEditButtonForParameter();
    }

    @Then("web user update Display name {string} and Data Type {string}")
    public void updateDisplayNameAndDataType(String displayName, String dataType) {
        parameterConfigPage.editParameter(displayName, dataType);
    }

    @And("web user click remove user identifier button")
    public void clickRemoveUserIdentifierButton() {
        userCategoryPage.clickRemoveIdentifierButton();
    }

    @And("web user click save user category")
    public void clickSaveUserCategory() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        userCategoryPage.clickSaveButton();
    }

    @Then("web user should see the {string} user category is created")
    public void verifyTheUserCategoryIsCreated(String userCategoryName) {
        userCategoryPage.verifyUserCategoryIsCreated(userCategoryName);
    }

    @Then("web user click view icon for {string} user category")
    public void clickViewIconForUserCategory(String userCategoryName) {
        userCategoryPage.clickViewIconForUserCategory(userCategoryName);
    }

    @Then("web user click edit icon for user category")
    public void clickEditIconForUserCategory() {
        userCategoryPage.clickEditIconForUserCategory();
    }

    @Then("web user delete the created user category")
    public void clickDeleteButtonForUserCategory() {
        userCategoryPage.clickDeleteButtonForUserCategory();
    }

    @Then("web user update category type to {string} and description to {string}")
    public void updateCategoryTypeAndDescription(String categoryType, String description) {
        userCategoryPage.updateUserCategory(categoryType, description);
    }

    @Then("verify system displays validation message")
    public void verifyValidationMessageForUserCategory() {
        userCategoryPage.verifyValidationMessages();
    }

    @When("web user click on filter icon on user category")
    public void clickOnFilterIconOnUserCategory() {
        userCategoryPage.clickFilterUserCategory();
    }

    @And("web user enters {string} into search name field")
    public void entersIntoSearchNameField(String userCategoryName) {
        userCategoryPage.searchUserCategory(userCategoryName);
    }

    @Then("verify system displays {string} error message for user category")
    public void verifySystemDisplaysErrorMessageForUserCategory(String errorMessage) {
        userCategoryPage.verifyErrorMessage(errorMessage);
    }

    @And("web user clicks search button")
    public void webUserClicksSearchButton() {
        userCategoryPage.clickSearchButton();
    }

    @Then("web system displays a list of user categories contains {string} on the name")
    public void verifyAListOfUserCategories(String searchInput) {
        userCategoryPage.verifySearchResults(searchInput);
    }

    @And("web user select {string} for the search filter criteria")
    public void selectForTheSearchFilter(String filterCriteria) {
        userCategoryPage.selectFilterCriteria(filterCriteria);
    }

    @When("web user click on filter icon on parameter")
    public void clickOnFilterIconOnParameter() {
        parameterConfigPage.clickFilterParameterButton();
    }

    @And("web user select {string} for the search parameter filter criteria")
    public void selectForTheSearchParameterFilterCriteria(String filterCriteria) {
        parameterConfigPage.selectParameterFilterCriteria(filterCriteria);
    }

    @And("web user enters {string} into parameter search name field")
    public void inputParameterNameInToSearchField(String parameterName) {
        parameterConfigPage.inputParameterName(parameterName);
    }

    @And("web user clicks search parameter button")
    public void clicksSearchParameterButton() {
        parameterConfigPage.clickSearchParameter();
    }

    @Then("web system displays a list of parameters contains {string} on the name")
    public void verifySearchResultListOfParameters(String parameterName) {
        parameterConfigPage.verifySearchResult(parameterName);
    }
    @And("web user clicks on Unit sub menu")
    public void clicksOnUnitSubMenu() {
        unitPage = adminDashboardPage.clickOnUnitSubMenu();
    }

    @Then("web system displays Unit Configuration page")
    public void webSystemDisplaysUnitConfigurationPage() {
        Assert.assertEquals(Config.unitConfigurationPageURL, unitPage.getUnitPageURL());
    }

    @When("web user clicks on Add button for Unit Config")
    public void clicksOnAddButtonForUnit() {
        unitPage.clickAddButton();
    }

    @And("web user fills unit config detail {string} {string} {string} and {string}")
    public void fillsUnitConfigDetail(String unitName, String description, String unitType, String subUnitType) {
        unitPage.fillUnitDetail(unitName, description, unitType, subUnitType);
    }

    @And("web user select the {string} of a unit")
    public void selectStatus(String status) {
        unitPage.selectStatus(status);
    }

    @And("web user clicks save button with {string}")
    public void clicksSaveButton(String status) {
        unitPage.clickSaveButton(status);
    }

    @And("web user clicks on view icon for {string} unit")
    public void clicksOnEditIconForUnit(String unitName) {
        unitPage.clickOnViewIcon(unitName);
    }

    @Then("web user should see the {string} unit is created")
    public void verifyTheUnitIsCreated(String unitName) {
        unitPage.verifyUnitCreated(unitName);
    }

    @Then("verify system displays {string} error message for unit")
    public void verifySystemDisplaysErrorMessageForUnit(String validationMessage) {
        unitPage.verifyValidationMessageForDuplicateName(validationMessage);
    }

    @And("web user delete the created unit")
    public void deleteTheCreatedUnit() {
        unitPage.clickDeleteButton();
    }

    @Then("web system displays validation message for unit config")
    public void verifyValidationMessageForUnitConfig() {
        unitPage.verifyValidationMessage();
    }

    @And("web user clicks edit button")
    public void webUserClicksEditButton() {
        unitPage.clickEditButton();
    }

    @And("web user update description as {string} UnitType as {string} and {string}")
    public void updateUnitConfig(String description, String unitType, String subUnitType) {
        unitPage.updateUnitConfig(description, unitType, subUnitType);
    }

    @When("web user click on filter icon for unit")
    public void clickOnFilterIconForUnit() {
        unitPage.clickFilterIcon();
    }

    @And("web user enters {string} into unit search name field")
    public void enterSearchedKeyword(String unitName) {
        unitPage.enterNameInToSearchField(unitName);
    }

    @And("web user select {string} for the search unit filter criteria")
    public void selectSearchUnitFilterCriteria(String criteria) {
        unitPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search unit button")
    public void clicksSearchUnitButton() {
        unitPage.clickSearchButton();
    }

    @Then("web system displays a list of units with {string} on the name")
    public void verifySearchResults(String unitName) {
        unitPage.verifyUnitSearchResults(unitName);
    }

    @When("web user clicks on Pouch sub menu")
    public void webUserClicksOnPouchSubMenu() {
        pouchPage = adminDashboardPage.clickOnPouchSubMenu();
    }

    @Then("web system displays Pouch Configuration page")
    public void verifyPouchConfigurationPage() {
        Assert.assertEquals(Config.pouchConfigurationPageURL, pouchPage.getPouchPageURL());
    }

    @When("web user clicks on Add button for Pouch Config")
    public void clicksOnAddButtonForPouchConfig() {
        pouchPage.clickAddButton();
    }

    @And("web user fills pouch config detail {string} {string} {string} {string} {string}and{string}")
    public void webUserFillsPouchConfigDetailAnd(String name, String description, String pouchType, String currency, String allocationType, String provisionType) {
        pouchPage.fillPouchDetails(name, description, pouchType, currency, allocationType, provisionType);
    }

    @And("web user add extra parameter {string} as parameter and {string} as default value")
    public void addExtraParameterForPouch(String parameter, String defaultValue) {
        pouchPage.addExtraParameter(parameter, defaultValue);
    }

    @When("web user clicks add parameter")
    public void clicksAddParameter() {
        pouchPage.clickAddParameter();
    }

    @And("web user click {string} status")
    public void webUserClickStatus(String status) {
        pouchPage.selectStatus(status);
    }

    @And("web user clicks save button")
    public void clicksSaveButton() {
        pouchPage.clickSaveButton();
    }

    @When("web user clicks view icon for {string} pouch")
    public void webUserClicksViewIconForPouch(String pouchName) {
        pouchPage.clickViewIcon(pouchName);
    }

    @Then("web user should see the {string} pouch is created")
    public void webUserShouldSeeThePouchIsCreated(String pouchName) {
        pouchPage.verifyPouchIsCreated(pouchName);
    }

    @And("web user clicks edit button for pouch")
    public void clicksEditIcon() {
        pouchPage.clickEditButton();
    }

    @Then("web user delete the created pouch")
    public void deleteTheCreatedPouch() {
        pouchPage.deletePouch();
    }

    @And("web user update pouch description as {string} status as {string}")
    public void updatePouch(String description, String status) {
        pouchPage.updatePouch(description, status);
    }

    @Then("verify system displays {string} error message for pouch")
    public void verifySystemDisplaysErrorMessageForPouch(String errorMessage) {
        pouchPage.verifyErrorMessageForDuplicatedName(errorMessage);
    }

    @And("web user allows transaction for pouch")
    public void aAllowsTransactionForPouch() {
        pouchPage.clickAllowTransaction();
    }

    @When("web user click on filter icon for pouch")
    public void clickOnFilterIconForPouch() {
        pouchPage.clickFilterButton();
    }

    @And("web user select {string} for the search pouch filter criteria")
    public void SelectForThePouchSearchUnitFilterCriteria(String criteria) {
        pouchPage.selectFilterCriteria(criteria);
    }

    @And("web user enters {string} into pouch search name field")
    public void entersIntoPouchSearchNameField(String pouchName) {
        pouchPage.fillSearchInput(pouchName);
    }

    @And("web user clicks search pouch button")
    public void clicksSearchPouchButton() {
        pouchPage.clickSearchButton();
    }

    @Then("web system displays a list of pouchs with {string} on the name")
    public void verifySearchResult(String pouchName) {
        pouchPage.verifySearchResult(pouchName);
    }

    @Then("web system displays validation message for pouch config")
    public void verifyPouchValidationMessage() {
        pouchPage.verifyValidationMessage();
    }

    @And("web user clicks on wallet sub menu")
    public void clicksOnWalletSubMenu() {
        walletPage = adminDashboardPage.clickOnWalletSubMenu();
    }

    @Then("web system displays Wallet Configuration page")
    public void verifySystemDisplaysWalletConfigurationPage() {
        Assert.assertEquals(Config.walletConfigurationPageURL, walletPage.getWalletPageURL());
    }

    @When("web user clicks on Add button for Wallet Config")
    public void clicksOnAddButtonForWalletConfig() {
        walletPage.clickAddButton();
    }

    @When("web user click on filter icon for Wallet")
    public void clickOnFilterIconForWallet() {
        walletPage.clickFilterIcon();
    }

    @And("web user select {string} for the search wallet filter criteria")
    public void selectSearchWalletFilterCriteria(String criteria) {
        walletPage.selectFilterCriteria(criteria);
    }

    @And("web user enters {string} into wallet search name field")
    public void inputSearchWallet(String walletName) {
        walletPage.fillSearchInput(walletName);
    }

    @And("web user clicks search wallet button")
    public void clicksSearchWalletButton() {
        walletPage.clickSearchButton();
    }

    @And("web user fills wallet config detail {string} {string} and {string}")
    public void webUserFillsWalletConfigDetailAnd(String walletName, String description, String walletType) {
        walletPage.fillWalletDetail(walletName, description, walletType);
    }

    @And("web user select the status {string} for wallet")
    public void selectStatusForWallet(String status) {
        walletPage.selectStatus(status);
    }

    @And("web user clicks save button with {string} for wallet")
    public void clicksSaveButtonForWallet(String status) {
        walletPage.clickSaveButton(status);
    }

    @Then("web user should see the {string} wallet is created")
    public void verifyWalletIsCreated(String walletName) {
        walletPage.verifyWalletIsCreated(walletName);
    }

    @And("web user clicks on view icon for {string} wallet")
    public void clicksOnViewIconForWallet(String wallet) {
        walletPage.clickViewIcon(wallet);
    }

    @And("web user delete the created wallet")
    public void deleteTheCreatedWallet() {
        walletPage.deleteWallet();
    }

    @When("web user clicks edit button for wallet")
    public void clicksEditButtonForWallet() {
        walletPage.clickEditButton();
    }

    @And("web user update wallet {string} and status to {string}")
    public void webUserUpdateWalletAndStatusTo(String description, String status) {
        walletPage.updateWallet(description, status);
    }

    @Then("web system displays validation message for wallet config")
    public void verifyValidationMessageForWallet() {
        walletPage.verifyValidationMessageForWallet();
    }

    @Then("web system displays a list of wallet with {string} on the name")
    public void verifyWalletSearchResult(String walletName) {
        walletPage.verifyWalletSearchResult(walletName);
    }

    @And("web user clicks on export button")
    public void clicksOnExportButton() {
        walletPage.clickExportButton();
    }

    @And("web user enters {string} and {string} into wallet export fields")
    public void webUserEntersAndIntoWalletExportFields(String name, String description) {
        walletPage.fillExportDetail(name, description);
    }

    @And("web user clicks save export history button for wallet")
    public void clicksSaveExportHistoryButtonForWallet() {
        walletPage.clickExportHistoryButton();
    }

    @Then("web user verify {string} record created in export history")
    public void verifyRecordCreatedInExportHistory(String exportName) {
        walletPage.verifyExportHistory(exportName);
    }

    @Then("verify system displays {string} error message")
    public void verifySystemDisplaysErrorMessage(String errorMessage) {
        walletPage.verifyDuplicateErrorMessage(errorMessage);
    }

    @When("web user clicks on KYC sub menu")
    public void clicksOnKYCSubMenu() {
        kycManagementPage = adminDashboardPage.clickOnKycSubMenu();
    }

    @Then("web system displays KYC Configuration page")
    public void VerifyKYCConfigurationPage() {
        Assert.assertEquals(Config.kycConfigurationPageURL, kycManagementPage.getKycPageURL());
    }
    @Then("verify system displays {string} error message for kyc")
    public void verifySystemDisplaysErrorMessageForKyc(String errorMessage) {
        kycManagementPage.verifyErrorMessageForDuplicatedName(errorMessage);
    }
    @When("web user clicks on Add button for KYC Config")
    public void clicksOnAddButtonForKYCConfig() {
        kycManagementPage.clickAddButton();
    }

    @And("web user fills kyc details name as {string} description as {string} and status {string}")
    public void fillsKycNameAndDescription(String name, String description, String status) {
        kycManagementPage.fillKycNameAndDescription(name, description, status);
    }
    @And("web user clicks edit button for kyc")
    public void clicksEditButtonForKyc() {
        kycManagementPage.clickEditButton();
    }
    @And("web user select kyc level as {string}")
    public void webUserSelectKycLevelAs(String kycLevel) {
        kycManagementPage.selectKycLevel(kycLevel);
    }

    @And("web user click add new step button")
    public void clickAddNewStepButton() {
        kycManagementPage.clickAddNewStep();
    }

    @And("web user enters {string} in to kyc step name field")
    public void webUserEntersInToKycStepNameField(String kycStepName) {
        kycManagementPage.enterKycStepName(kycStepName);
    }

    @And("web user add field group with name as {string} description as {string} and display name as {string}")
    public void webUserAddFieldGroupWithNameAsDescriptionAsAndDisplayNameAs(String name, String description, String displayName) {
        kycManagementPage.addFieldGroup(name, description, displayName);
    }
    @Then("web user delete the created kyc")
    public void deleteTheCreatedKyc() {
        kycManagementPage.deleteKyc();
    }
    @Then("web system displays validation message for kyc config")
    public void verifyKycValidationMessage() {
        kycManagementPage.verifyValidationMessage();
    }
    @Then("web user should see the {string} kyc is created")
    public void webUserShouldSeeKycIsCreated(String kycName) {
        kycManagementPage.verifyKycIsCreated(kycName);
    }
    @And("web user selects parameters {string} {string} and {string} in to field group")
    public void webUserSelectsParametersAndInToFieldGroup(String name, String mpin, String email) {
        kycManagementPage.addParametersInToFieldGroup(name, mpin, email);
    }
    @When("web user clicks view icon for {string} kyc")
    public void webUserClicksViewIconForKyc(String kycName) {
        kycManagementPage.clickViewIcon(kycName);
    }
    @When("web user click on filter icon for kyc")
    public void clickOnFilterIconForKyc() {
        kycManagementPage.clickFilterButton();
    }

    @And("web user select {string} for the search kyc filter criteria")
    public void SelectForTheKycSearchUnitFilterCriteria(String criteria) {
        kycManagementPage.selectFilterCriteria(criteria);
    }

    @And("web user enters {string} into kyc search name field")
    public void entersIntoKycSearchNameField(String kycName) {
        kycManagementPage.fillSearchInput(kycName);
    }

    @And("web user clicks search kyc button")
    public void clicksSearchKycButton() {
        kycManagementPage.clickSearchButton();
    }

    @Then("web system displays a list of kyc's with {string} on the name")
    public void verifySearchResultForKyc(String kycName) {
        kycManagementPage.verifySearchResult(kycName);
    }
    @And("web user clicks on Service sub menu")
    public void clicksOnServiceSubMenu() {
        servicePage = adminDashboardPage.clickOnServiceSubMenu();
    }

    @Then("web system displays Service Configuration page")
    public void webSystemDisplaysServiceConfigurationPage() {
        Assert.assertEquals(Config.serviceConfigurationPageURL, servicePage.getUnitPageURL());
    }

    @When("web user clicks on Add button for Service Config")
    public void webUserClicksOnAddButtonForServiceConfig() {
        servicePage.clickAddButton();
    }

    @And("web user enters service info {string} {string} {string} {string} and {string}")
    public void webUserEntersServiceInfoAnd(String name, String displayName, String description, String serviceType, String serviceBehavior) {
        servicePage.addServiceDetails(name, displayName, description, serviceType, serviceBehavior);
    }

    @And("web user select the {string} of a service")
    public void webUserSelectTheOfAService(String status) {
        servicePage.selectStatus(status);
    }

    @And("web user navigates to parameters tab")
    public void webUserNavigatesToParametersTab() {
        servicePage.navigatesToParameterTab();
    }

    @And("web user add parameter details parameter as {string} default value {string}")
    public void webUserAddParameterDetailsParameterAsDefaultValue(String parameter, String defaultValue) {
        servicePage.addParameter(parameter, defaultValue);
    }

    @And("web user click save button for service")
    public void webUserClickSaveButtonForService() {
        servicePage.clickSaveButton();
    }

    @Then("web user should see the {string} service is created")
    public void webUserShouldSeeTheServiceIsCreated(String serviceName) {
        servicePage.verifyServiceIsCreated(serviceName);
    }

    @And("web user clicks on view icon for {string} service")
    public void webUserClicksOnViewIconForService(String serviceName) {
        servicePage.clickViewIcon(serviceName);
    }

    @And("web user delete the created service")
    public void webUserDeleteTheCreatedService() {
        servicePage.deleteService();
    }

    @Then("web system displays validation message for service config")
    public void webSystemDisplaysValidationMessageForServiceConfig() {
        servicePage.verifyValidationMessage();
    }

    @And("web user update service display name {string} service type {string} and service behavior {string}")
    public void webUserUpdateServiceDisplayNameServiceTypeAndServiceBehavior(String displayName, String serviceType, String serviceBehavior) {
        servicePage.updateService(displayName, serviceType, serviceBehavior);
    }

    @Then("verify system displays {string} error message for service")
    public void verifySystemDisplaysErrorMessageForService(String errorMessage) {
        servicePage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for service")
    public void webUserClickOnFilterIconForService() {
        servicePage.clickEditIconForService();
    }

    @And("web user select {string} for the search service filter criteria")
    public void webUserSelectForTheSearchServiceFilterCriteria(String criteria) {
        servicePage.selectFilterCriteria(criteria);
    }

    @And("web user enters {string} into service search name field")
    public void webUserEntersIntoServiceSearchNameField(String serviceName) {
        servicePage.enterSearchName(serviceName);
    }

    @And("web user clicks search service button")
    public void webUserClicksSearchServiceButton() {
        servicePage.clickSearchButton();
    }

    @Then("web system displays a list of services with {string} on the name")
    public void webSystemDisplaysAListOfServicesWithOnTheName(String serviceName) {
        servicePage.verifySearchResult(serviceName);
    }

    @And("web user clicks on export button for parameter")
    public void webUserClicksOnExportButtonForService() {
        parameterConfigPage.clickExportButton();
    }

    @And("web user enters {string} and {string} into parameter export fields")
    public void webUserEntersAndIntoServiceExportFields(String name, String description) {
        parameterConfigPage.fillExportDetail(name, description);

    }

    @And("web user clicks save export history button for parameter")
    public void webUserClicksSaveExportHistoryButtonForService() {
        parameterConfigPage.clickExportHistoryButton();
    }

    @Then("web user verify {string} record created in parameter export history")
    public void webUserVerifyRecordCreatedInServiceExportHistory(String exportName) {
        parameterConfigPage.verifyExportHistory(exportName);
    }

    @And("web user clicks on access channel sub menu")
    public void webUserClicksOnAccessChannelSubMenu() {
        accessChannelPage = adminDashboardPage.clickOnAccessChannelSubMenu();
    }

    @Then("web system displays access channel configuration page")
    public void webSystemDisplaysAccessChannelConfigurationPage() {
        Assert.assertEquals(Config.accessChannelConfigurationPageURL, accessChannelPage.getAccessChannelPageURL());
    }

    @When("web user clicks on Add button for access channel")
    public void webUserClicksOnAddButtonForAccessChannel() {
        accessChannelPage.clickAddButton();
    }

    @And("web user fills access channel config detail {string} {string} {string} and {string}")
    public void webUserFillsAccessChannelConfigDetail(String name, String description, String secrete, String confirm) {
        accessChannelPage.fillAccessChannelDetail(name, description, secrete, confirm);
    }

    @Then("web system displays {string} validation message")
    public void verifyConfirmationValidationMessage(String validationMessage) {
        accessChannelPage.verifyConfirmationValidation(validationMessage);
    }

    @And("web user set Expiry enable with {string} access token validity and {string} as access token Idle expiry")
    public void webUserSetExpiryEnable(String tokenValidity, String tokenExpiry) {
        accessChannelPage.setExpiryAndAccessToken(tokenValidity, tokenExpiry);
    }

    @And("web user select the {string} of a access token")
    public void webUserSelectTheOfAAccessToken(String status) {
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    @And("web user clicks save button for access channel")
    public void clicksSaveButtonForAccessChannel() {
        accessChannelPage.clickSaveButton();
    }

    @Then("web user should see the {string} access channel is created")
    public void verifyTheAccessChannelIsCreated(String accessChannelName) {
        accessChannelPage.verifyAccessChannelCreated(accessChannelName);
    }

    @And("web user clicks on view icon for {string} service channel")
    public void webUserClicksOnViewIconForServiceChannel(String accessChannelName) {
        accessChannelPage.clickOnViewIcon(accessChannelName);
    }

    @And("web user delete the created service channel")
    public void deleteTheCreatedServiceChannel() {
        accessChannelPage.deleteAccessChannel();
    }

    @And("web user clicks on Edit button")
    public void clicksOnEditButton() {
        accessChannelPage.clickEditButton();
    }

    @And("web user update access channel description as {string} token validity as {string} and token expiry as {string}")
    public void updateAccessChannel(String description, String tokenValidity, String tokenExpiry) {
        accessChannelPage.updateAccessChannel(description, tokenValidity, tokenExpiry);
    }

    @Then("web system displays validation message for access channel config")
    public void verifyValidationMessageForAccessChannelConfig() {
        accessChannelPage.verifyValidationMessage();
    }

    @Then("verify system displays {string} error message for access channel")
    public void verifySystemDisplaysErrorMessageForAccessChannel(String errorMessage) {
        accessChannelPage.verifyErrorMessage(errorMessage);
    }


    @When("web user click on filter icon for access channel")
    public void clickOnFilterIconForAccessChannel() {
        accessChannelPage.clickFilterIcon();
    }

    @And("web user enters {string} into access channel search name field")
    public void enterSearchedKeywordForAccessChannel(String accessChannelName) {
        accessChannelPage.enterNameInToSearchField(accessChannelName);
    }

    @And("web user select {string} for the search access channel filter criteria")
    public void selectSearchAccessChannelFilterCriteria(String criteria) {
        accessChannelPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search for access channel button")
    public void clicksSearchAccessChannelButton() {
        accessChannelPage.clickSearchButton();
    }

    @Then("web system displays a list of access channel with {string} on the name")
    public void verifySearchResultsForAccessChannel(String accessChannel) {
        accessChannelPage.verifyAccessChannelSearchResults(accessChannel);
    }

    @And("web user clicks on ucp sub menu")
    public void clicksOnUcpSubMenu() {
        unitCreditPolicyPage = adminDashboardPage.clickOnUcpSubMenu();
    }

    @Then("web system displays ucp configuration page")
    public void webSystemDisplaysUcpConfigurationPage() {
        Assert.assertEquals(Config.ucpConfigurationPageURL, unitCreditPolicyPage.getUnitCreditPolicyPageURL());
    }

    @When("web user clicks on add button for ucp config")
    public void webUserClicksOnAddButtonForUcpConfig() {
        unitCreditPolicyPage.clickAddButton();
    }


    @And("web user clicks on ucp group sub menu")
    public void clicksOnUcpGroupSubMenu() {
        ucpGroupPage = adminDashboardPage.clickOnUcpGroupSubMenu();
    }

    @Then("web system displays ucp group configuration page")
    public void webSystemDisplaysUcpGroupConfigurationPage() {
        Assert.assertEquals(Config.ucpGroupConfigurationPageURL, ucpGroupPage.getUcpGroupPageURL());
    }

    @When("web user clicks on add button for ucp group config")
    public void webUserClicksOnAddButtonForUcpGroupConfig() {
        ucpGroupPage.clickAddButton();
    }


    @And("web user clicks on counter sub menu")
    public void clicksOnCounterSubMenu() {
        counterPage = adminDashboardPage.clickCounterSubMenu();
    }

    @Then("web system displays counter configuration page")
    public void webSystemDisplaysCounterConfigurationPage() {
        Assert.assertEquals(Config.counterConfigurationPageURL, counterPage.getCounterPageURL());
    }

    @When("web user clicks on add button for counter config")
    public void webUserClicksOnAddButtonForCounterConfig() {
        counterPage.clickAddButton();
    }


    @And("web user clicks on rule sub menu")
    public void clicksOnRuleSubMenu() {
        rulePage = adminDashboardPage.clickRuleSubMenu();
    }

    @Then("web system displays rule configuration page")
    public void webSystemDisplaysRuleConfigurationPage() {
        Assert.assertEquals(Config.ruleConfigurationPageURL, rulePage.getRulePageURL());
    }

    @When("web user clicks on add button for rule config")
    public void webUserClicksOnAddButtonForRuleConfig() {
        rulePage.clickAddButton();
    }


    @And("web user clicks on product sub menu")
    public void clicksOnProductSubMenu() {
        productPage = adminDashboardPage.clickProductSubMenu();
    }

    @Then("web system displays product configuration page")
    public void webSystemDisplaysProductConfigurationPage() {
        Assert.assertEquals(Config.productConfigurationPageURL, productPage.getProductPageURL());
    }

    @When("web user clicks on add button for product config")
    public void webUserClicksOnAddButtonForProductConfig() {
        productPage.clickAddButton();
    }


    @And("web user clicks on product group sub menu")
    public void clicksOnProductGroupSubMenu() {
        productGroupPage = adminDashboardPage.clickProductGroupSubMenu();
    }

    @Then("web system displays product group configuration page")
    public void webSystemDisplaysProductGroupConfigurationPage() {
        Assert.assertEquals(Config.productGroupConfigurationPageURL, productGroupPage.getProductGroupPageURL());
    }

    @When("web user clicks on add button for product group config")
    public void webUserClicksOnAddButtonForProductGroupConfig() {
        productGroupPage.clickAddButton();
    }


    @And("web user clicks on notification template sub menu")
    public void clicksOnNotificationTemplateSubMenu() {
        notificationTemplatePage = adminDashboardPage.clickNotificationTemplateSubMenu();
    }

    @Then("web system displays notification template configuration page")
    public void webSystemDisplaysNotificationTemplateConfigurationPage() {
        Assert.assertEquals(Config.notificationTemplateConfigurationPageURL, notificationTemplatePage.getNotificationTemplatePageURL());
    }

    @When("web user clicks on add button for notification template config")
    public void webUserClicksOnAddButtonForNotificationTemplateConfig() {
        notificationTemplatePage.clickAddButton();
    }


    @And("web user fills UCP config detail {string} {string} {string} {string} {string} {string} {string} {string} and {string}")
    public void webUserFillsUCPConfigDetailAnd(String name, String description, String unit, String ucpType, String slabType, String creditType, String calculationType, String creditOn, String valueType) {
        unitCreditPolicyPage.addUcpDetail(name, description, unit, ucpType, slabType, creditType, calculationType, creditOn, valueType);
    }

    @And("web user clicks on save button for ucp")
    public void clicksOnSaveButtonForUcp() {
        unitCreditPolicyPage.clickSaveButton();
    }

    @And("web user enters {int} for ucp value")
    public void webUserEntersForUcpValue(int value) {
        unitCreditPolicyPage.addValue(value);
    }

    @Then("web user should see the {string} ucp is created")
    public void verifyTheUcpIsCreated(String ucpName) {
        unitCreditPolicyPage.verifyUcpCreated(ucpName);
    }

    @And("web user clicks on view icon for {string} ucp")
    public void clicksOnEditIconForUcp(String ucpName) {
        unitCreditPolicyPage.clickOnViewIcon(ucpName);
    }

    @And("web user delete the created ucp")
    public void deleteTheCreatedUcp() {
        unitCreditPolicyPage.clickDeleteButton();
    }

    @Then("web system displays validation message for ucp config")
    public void verifyValidationMessageForUcpConfig() {
        unitCreditPolicyPage.verifyValidationMessage();
    }

    @And("web user clicks edit button for ucp")
    public void clicksEditButtonForUcp() {
        unitCreditPolicyPage.clickEditButton();
    }

    @And("web user update ucp config Unit as {string} Unit Type as {string} Slab Type as {string} and Value Type as {string}")
    public void updateUcp(String unit, String unitType, String slabType, String valueType) {
        unitCreditPolicyPage.updateUcpConfig(unit, unitType, slabType, valueType);
    }

    @Then("web user verify {string} ucp is updated with {string} {string} {string} and {string}")
    public void verifyUcpIsUpdated(String ucpName, String unit, String unitType, String slabType, String valueType) {
        unitCreditPolicyPage.verifyUpdatedUcp(ucpName, unit, unitType, slabType, valueType);
    }

    @And("web user add slab detail min as {int} maximum as {int} and value as {int}")
    public void addSlabDetailMinAsMaximumAsAndValueAs(int minimum, int maximum, int value) {
        unitCreditPolicyPage.addSlabDetail(minimum,maximum, value);
    }
    @When("web user click on filter icon for ucp")
    public void clickOnFilterIconForUcp() {
        unitCreditPolicyPage.clickFilterIcon();
    }
    @And("web user select {string} for the search ucp filter criteria")
    public void selectSearchUcpFilterCriteria(String criteria) {
        unitCreditPolicyPage.selectSearchCriteria(criteria);
    }
    @And("web user enters {string} into ucp search name field")
    public void enterSearchedKeywordforucp(String ucpName) {
        unitCreditPolicyPage.enterNameInToSearchField(ucpName);
    }
    @And("web user clicks search ucp button")
    public void clicksSearchUcpButton() {
        unitCreditPolicyPage.clickSearchButton();
    }
    @Then("web system displays a list of ucps with {string} on the name")
    public void verifyUcpSearchResults(String ucpName) {
        unitCreditPolicyPage.verifyUcpSearchResults(ucpName);
    }
    @Then("verify system displays {string} error message for ucp")
    public void verifySystemDisplaysErrorMessageForUcp(String validationMessage) {
        unitCreditPolicyPage.verifyValidationMessageForDuplicateName(validationMessage);
    }

    @And("web user adds product config detail {string} {string} {string} {string} {string} {string} {string} {string} {string} and {string}")
    public void webUserAddsProductConfigDetailAnd(String name, String displayName, String description, String usedBy, String service, String productType, String productSubType, String denomination, String productValue, String displayOrder) {
        productPage.addProductDetail(name, displayName,description,usedBy, service, productType, productSubType, denomination, productValue, displayOrder);
    }

    @And("web user clicks on save button for product")
    public void clicksOnSaveButtonForProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        productPage.clickSaveButton();
    }
    @Then("web user should see the {string} product is created")
    public void verifyTheProductIsCreated(String productName) {
        productPage.verifyProductCreated(productName);
    }
    @And("web user clicks on view icon for {string} product")
    public void clicksOnEditIconForProduct(String productName) {
        productPage.clickOnViewIcon(productName);
    }
    @And("web user delete the created product")
    public void deleteTheCreatedProduct() {
        productPage.clickDeleteButton();
    }
    @Then("verify system displays {string} error message for product")
    public void verifySystemDisplaysErrorMessageForProduct(String validationMessage) {
        productPage.verifyValidationMessageForDuplicateName(validationMessage);
    }
    @Then("web system displays validation message for product config")
    public void verifyValidationMessageForProductConfig() {
        productPage.verifyValidationMessage();
    }
    @And("web user clicks edit button for product")
    public void licksEditButtonForProduct() {
        productPage.clickEditButton();
    }

    @And("web user fills rule config detail {string} {string} {string} {string} and {string}")
    public void webUserFillsRuleConfigDetailAnd(String name, String description, String expression, String usedBy, String status) {
        rulePage.addRuleDetail(name, description, expression, usedBy, status);
    }
    @And("web user clicks save button for rule with {string}")
    public void clicksSaveButtonForRule(String status) {
        rulePage.clickSaveButton(status);
    }
    @Then("web user should see the {string} rule is created")
    public void verifyRuleIsCreated(String ruleName) {
        rulePage.verifyRuleCreated(ruleName);
    }
    @And("web user clicks on view icon for {string} rule")
    public void clicksOnEditIconForRule(String ruleName) {
        rulePage.clickOnViewIcon(ruleName);
    }
    @And("web user delete the created rule")
    public void deleteTheCreatedRule() {
        rulePage.clickDeleteButton();
    }
    @And("web user clicks edit button for rule")
    public void clicksEditButton() {
        rulePage.clickEditButton();
    }

    @And("web user update rule description as {string} and expression as {string}")
    public void updateRuleConfiguration(String description, String expression) {
        rulePage.updateRuleConfig(description, expression);
    }
    @Then("web system displays validation message for rule config")
    public void verifyValidationMessageForRuleConfig() {
        rulePage.verifyValidationMessage();
    }
    @When("web user click on filter icon for rule")
    public void clickOnFilterIconForRule() {
        rulePage.clickFilterIcon();
    }
    @And("web user select {string} for the search rule filter criteria")
    public void selectSearchRuleFilterCriteria(String criteria) {
        rulePage.selectSearchCriteria(criteria);
    }
    @And("web user enters {string} into rule search name field")
    public void enterSearchedKeywordForRule(String ruleName) {
        rulePage.enterNameInToSearchField(ruleName);
    }
    @And("web user clicks search rule button")
    public void clicksSearchRuleButton() {
        rulePage.clickSearchButton();
    }
    @Then("web system displays a list of rules with {string} on the name")
    public void verifySearchResultsForRule(String ruleName) {
        rulePage.verifyRuleSearchResults(ruleName);
    }

    @Then("verify system displays {string} error message for rule")
    public void verifySystemDisplaysErrorMessageForRule(String validationMessage) {
        rulePage.verifyValidationMessageForDuplicateName(validationMessage);
    }

    @And("web user add product group details {string} {string} {string} and {string}")
    public void webUserAddProductGroupDetailsAnd(String name, String description, String product, String status) {
        productGroupPage.addProductGroupDetail(name, description, product, status);
    }

    @And("web user add settlement detail {string} and {string}")
    public void webUserAddSettlementDetailAnd(String rule, String settlementGroup) {
        productGroupPage.addSettlementGroup(rule, settlementGroup);
    }
    @And("web user clicks on save button for product group")
    public void clicksSaveButtonForProductGroup() {
        productGroupPage.clickSaveButton();
    }
    @Then("web user should see the {string} product group is created")
    public void webUserShouldSeeTheProductGroupIsCreated(String productGroupName) {
        productGroupPage.verifyProductGroupIsCreated(productGroupName);
    }
    @When("web user clicks view icon for {string} product group")
    public void webUserClicksViewIconForProductGroup(String productGroupName) {
        productGroupPage.clickViewIcon(productGroupName);
    }
    @Then("web user delete the created product group")
    public void deleteTheCreatedProductGroup() {
        productGroupPage.deleteProductGroup();
    }
    @And("web user clicks edit button for product group")
    public void clicksEditIconForProductGroup() {
        productGroupPage.clickEditButton();
    }

    @And("web user update product group details {string} {string} and {string}")
    public void updateProductGroupDetails(String description, String product, String status) {
        productGroupPage.updateProductGroup(description, product, status);
    }
    @Then("web system displays validation message for product group config")
    public void verifyProductGroupValidationMessage() {
        productGroupPage.verifyValidationMessage();
    }
    @When("web user click on filter icon for product group")
    public void clickOnFilterIconForProductGroup() {
        productGroupPage.clickFilterButton();
    }
    @And("web user select {string} for the search product group filter criteria")
    public void SelectForTheProductGroupSearchUnitFilterCriteria(String criteria) {
        productGroupPage.selectFilterCriteria(criteria);
    }
    @And("web user enters {string} into product group search name field")
    public void entersIntoProductGroupSearchNameField(String productGroup) {
        productGroupPage.fillSearchInput(productGroup);
    }
    @And("web user clicks search product group button")
    public void clicksSearchProductGroupButton() {
        productGroupPage.clickSearchButton();
    }
    @Then("web system displays a list of product groups with {string} on the name")
    public void verifySearchResultForProductGroup(String productGroupName) {
        productGroupPage.verifySearchResult(productGroupName);
    }
    @Then("verify system displays {string} error message for product group")
    public void verifySystemDisplaysErrorMessageForProductGroup(String errorMessage) {
        productGroupPage.verifyErrorMessageForDuplicatedName(errorMessage);
    }
    @And("web user clicks on save button for kyc")
    public void clicksSaveButtonForKyc() {
        kycManagementPage.clickSaveButton();
    }

    @And("web user add field group with name {string} from library")
    public void addFieldGroupFromLibrary(String fieldGroupName) {
        kycManagementPage.addFieldGroupFromLibrary(fieldGroupName);
    }

    @And("web user clicks on wallet template sub menu")
    public void clicksOnWalletTemplateSubMenu() {
        walletTemplatePage = adminDashboardPage.clickOnWalletTemplateSubMenu();
    }
    @Then("web system displays wallet template Configuration page")
    public void webSystemDisplaysWalletTemplateConfigurationPage() {
        Assert.assertEquals(Config.walletTemplateConfigurationPageURL, walletTemplatePage.getWalletTemplatePageURL());
    }
    @When("web user clicks on Add button for wallet template Config")
    public void clicksOnAddButtonForWalletTemplate() {
        walletTemplatePage.clickAddButton();
    }

    @And("web user fills wallet template detail {string} {string} {string} and {string}")
    public void webUserFillsWalletTemplateDetailAnd(String name, String description, String wallet, String pouch) {
        walletTemplatePage.fillWalletTemplateDetail(name, description, wallet, pouch);
    }

    @And("web user clicks on save button for wallet template")
    public void clicksOnSaveButtonForWalletTemplate() {
        walletTemplatePage.clickSaveButton();
    }
    @Then("web user should see the {string} wallet template is created")
    public void verifyWalletTemplateIsCreated(String walletTemplateName) {
        walletTemplatePage.verifyWalletTemplateIsCreated(walletTemplateName);
    }

    @And("web user clicks on view icon for {string} wallet template")
    public void clicksOnViewIconForWalletTemplate(String walletTemplateName) {
        walletTemplatePage.clickViewIcon(walletTemplateName);
    }
    @And("web user delete the created wallet template")
    public void deleteTheCreatedWalletTemplate() {
        walletTemplatePage.deleteWalletTemplate();
    }

    @And("web user update wallet template {string} {string} and {string}")
    public void updateWalletTemplate(String description, String wallet, String pouch) {
        walletTemplatePage.updateWalletTemplate(description, wallet, pouch);
    }
    @When("web user clicks edit button for wallet template")
    public void clicksEditButtonForWalletTemplate() {
        walletTemplatePage.clickEditButton();
    }
}
