package stepDef;


import util.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.pages.operatorconfig.MoveSystemOperatorPage;
import pageObj.web.pages.operatorconfig.RoleConfigPage;
import pageObj.web.pages.operatorconfig.SystemOperatorEntityPage;
import pageObj.web.pages.operatorconfig.SystemOperatorOnboardingPage;

public class OperatorConfigStepDef extends AbstractPage {
    private MoveSystemOperatorPage moveSystemOperatorPage;
    private RoleConfigPage roleConfigPage;
    private SystemOperatorEntityPage systemOperatorEntityPage;
    private SystemOperatorOnboardingPage systemOperatorOnboardingPage;


    @And("web user moves mouse over operator config main menu")
    public void webUserMovesMouseOverPlatformConfigMainMenu() {
        adminDashboardPage.hoverOnOperatorConfigMenu();
    }


    @And("web user clicks on move system operator config sub menu")
    public void webUserClicksOnMoveSystemOperatorSubMenu() {
        moveSystemOperatorPage = adminDashboardPage.clickOnMoveSystemOperatorSubMenu();
    }

    @Then("web system displays move system operator config page")
    public void webSystemDisplaysMoveSystemOperatorPage() throws Exception {
        Assert.assertEquals(moveSystemOperatorPage.getMoveSystemOperatorPageURL(),
                PropertiesReader.getValue("moveSystemOperatorConfigurationPageURL"));
    }

    @And("web user clicks on role config sub menu")
    public void webUserClicksOnRoleConfigSubMenu() {
        roleConfigPage = adminDashboardPage.clickOnRoleConfigSubMenu();
    }

    @Then("web system displays role config page")
    public void webSystemDisplaysRoleConfigPage() throws Exception {
        Assert.assertEquals(roleConfigPage.getURL(), PropertiesReader.getValue("roleConfigurationPageURL"));
    }

    @And("web user clicks on system operator config sub menu")
    public void webUserClicksOnSystemOperatorConfigSubMenu() {
        systemOperatorEntityPage = adminDashboardPage.clickOnSystemOperatorSubMenu();
    }

    @Then("web system displays system operator config page")
    public void webSystemDisplaysSystemOperatorConfigPage() throws Exception {
        Assert.assertEquals(systemOperatorEntityPage.getURL(),
                PropertiesReader.getValue("systemOperatorConfigurationPageURL"));
    }

    @And("web user clicks on system operator onboarding sub menu")
    public void webUserClicksOnSystemOperatorOnboardingSubMenu() {
        systemOperatorOnboardingPage = adminDashboardPage.clickOnSystemOperatorOnboardingSubMenu();
    }

    @Then("web system displays system operator onboarding page")
    public void webSystemDisplaysSystemOperatorOnboardingPage() throws Exception {
        Assert.assertEquals(systemOperatorOnboardingPage.getURL(),
                PropertiesReader.getValue("systemOperatorOnboardingPageURL"));
    }

    @When("web user add role config {string} {string} {string}")
    public void addRoleConfig(String roleName, String description, String userCategory) {
        roleConfigPage.addRole(roleName, description, userCategory);
    }

    @When("web user click add button for role")
    public void clickAddButtonForRole() {
        roleConfigPage.clickAddButton();
    }

    @And("web user click save button for role")
    public void clickSaveButtonForRole() {
        roleConfigPage.clickSaveButton();
    }

    @Then("web user should see the {string} role is created")
    public void verifyTheRoleIsCreated(String roleName) {
        roleConfigPage.verifyRoleCreated(roleName);
    }

    @And("web user clicks on view icon for {string} role")
    public void clicksOnViewIconForRole(String roleName) {
        roleConfigPage.clickViewIcon(roleName);
    }

    @And("web user delete the created role")
    public void deleteTheCreatedRole() {
        roleConfigPage.deleteRole();
    }

    @Then("web system displays validation message for role")
    public void verifyValidationMessageForRole() {
        roleConfigPage.verifyValidationMessage();
    }

    @Then("verify system displays {string} error message for role")
    public void verifyErrorMessageForRole(String errorMessage) {
        roleConfigPage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for role")
    public void clickOnFilterIconForRole() {
        roleConfigPage.clickFilterIcon();
    }

    @And("web user enters {string} into role search name field")
    public void enterSearchedKeywordForRole(String roleName) {
        roleConfigPage.enterNameInToSearchField(roleName);
    }

    @And("web user select {string} for the search role filter criteria")
    public void selectSearchRoleFilterCriteria(String criteria) {
        roleConfigPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search role button")
    public void clicksSearchRoleButton() {
        roleConfigPage.clickSearchButton();
    }

    @Then("web system displays a list of roles with {string} on the name")
    public void verifySearchResultsForRole(String roleName) {
        roleConfigPage.verifyRoleSearchResults(roleName);
    }

    @When("web user click add button for system operator entity")
    public void clickAddButton() {
        systemOperatorEntityPage.clickAddButton();
    }

    @And("web user add SOE {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void addSystemOperatorEntity(String name, String description, String userCategory, String businessZone, String pap, String kyc, String kycLevel, String role, String timeZone) {
        systemOperatorEntityPage.addSystemOperatorEntity(name, description, userCategory, businessZone, pap, kyc, kycLevel, role, timeZone);
    }

    @And("web user click save button for SOE")
    public void clickSaveButtonForSOE() {
        systemOperatorEntityPage.clickSaveButton();
    }

    @Then("web user should see the {string} SOE is created")
    public void verifyTheSOEIsCreated(String soeName) {
        systemOperatorEntityPage.verifySOECreated(soeName);
    }

    @And("web user clicks on view icon for {string} SOE")
    public void clicksOnViewIconForSOE(String soeName) {
        systemOperatorEntityPage.clickViewIcon(soeName);
    }

    @And("web user delete the created SOE")
    public void deleteTheCreatedSOE() {
        systemOperatorEntityPage.deleteSOE();
    }

    @Then("web system displays validation message for SOE")
    public void verifyValidationMessageForSOE() {
        systemOperatorEntityPage.verifyValidationMessage();
    }

    @Then("verify system displays {string} error message for SOE")
    public void verifyErrorMessageForSOE(String errorMessage) {
        systemOperatorEntityPage.verifyErrorMessage(errorMessage);
    }

    @When("web user click on filter icon for SOE")
    public void clickOnFilterIconForSOE() {
        systemOperatorEntityPage.clickFilterIcon();
    }

    @And("web user enters {string} into SOE search name field")
    public void enterSearchedKeywordForSOE(String soeName) {
        systemOperatorEntityPage.enterNameInToSearchField(soeName);
    }

    @And("web user select {string} for the search SOE filter criteria")
    public void selectSearchSOEFilterCriteria(String criteria) {
        systemOperatorEntityPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search SOE button")
    public void clicksSearchSOEButton() {
        systemOperatorEntityPage.clickSearchButton();
    }

    @Then("web system displays a list of SOEs with {string} on the name")
    public void verifySearchResultsForSOE(String soeName) {
        systemOperatorEntityPage.verifySOESearchResults(soeName);
    }

    @When("web user click add button for system operator onboarding")
    public void clickAddButtonForSOOnboarding() {
        systemOperatorOnboardingPage.clickAddButton();
    }

    @And("web user add system operator {string} {string} {string} {string} {string} {string}")
    public void webUserAddSystemOperator(String SOE, String kycLevel, String fullName, String dob, String mobile, String email) {
        systemOperatorOnboardingPage.addSystemOperator(SOE, kycLevel, fullName, dob, mobile, email);
    }

    @And("web user click save button for system operator")
    public void clickSaveButtonForSystemOperator() {
        systemOperatorOnboardingPage.clickSaveButton();
    }

    @Then("web user should see the {string} system operator is created")
    public void verifyTheSystemOperatorIsCreated(String roleName) {
        systemOperatorOnboardingPage.verifySystemOperatorCreated(roleName);
    }

    @And("web user clicks on view icon for {string} system operator")
    public void clicksOnViewIconForSystemOperator(String roleName) {
        systemOperatorOnboardingPage.clickViewIcon(roleName);
    }

    @And("web user delete the created system operator")
    public void deleteTheCreatedSystemOperator() {
        systemOperatorOnboardingPage.deleteSystemOperator();
    }

    @And("web user select {string} system operator to move")
    public void selectSystemOperatorEntity(String systemOperatorEntity) {
        moveSystemOperatorPage.selectSystemOperatorEntity(systemOperatorEntity);
    }

    @And("web user select {string} new system operator entity")
    public void selectNewSystemOperatorEntity(String systemOperatorEntity) {
        moveSystemOperatorPage.selectNewSystemOperatorEntity(systemOperatorEntity);
    }

    @And("web user select {string} to kyc level")
    public void selectKycLevel(String kycLevel) {
        moveSystemOperatorPage.selectKycLevel(kycLevel);
    }

    @And("web user click move button")
    public void clickMoveButton() {
        moveSystemOperatorPage.clickMoveButton();
    }

    @Then("web system displays validation message for move system operator")
    public void verifyValidationMessageForMoveSystemOperator() {
        moveSystemOperatorPage.verifyValidationMessage();
    }
}
