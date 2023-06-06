package stepDef;

import config.Config;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObj.web.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;


public class PlatformConfigStepDef extends AbstractPage {

    private ParameterPage parameterConfigPage;
    private UserCategoryPage userCategoryPage;
    private UnitPage unitPage;
    private PouchPage pouchPage;
    private WalletPage walletPage;
    private KycManagementPage kycManagementPage;
    private ServicePage servicePage;
    private AccessChannelPage accessChannelPage;

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

//    @When("web user fills all parameter details(.+)(.+)(.+)$")
//    public void webUserEntersIntoTheNameTextField(String parameterName, String displayName, String description) {
//        parameterConfigPage.fillParameterDetails(parameterName,displayName,description);
//    }

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

    @When("web user clicks on Add button for KYC Config")
    public void clicksOnAddButtonForKYCConfig() {
        kycManagementPage.clickAddButton();
    }

    @And("web user fills kyc details name as {string} description as {string} and status {string}")
    public void fillsKycNameAndDescription(String name, String description, String status) {
        kycManagementPage.fillKycNameAndDescription(name,description,status);
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

    @And("web user selects parameters {string} {string} and {string} in to field group")
    public void webUserSelectsParametersAndInToFieldGroup(String name, String mpin, String email) {
        kycManagementPage.addParametersInToFieldGroup(name, mpin, email);
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
    public void webUserFillsAccessChannelConfigDetailAnd(String name, String description, String secrete, String token) {
    }
}