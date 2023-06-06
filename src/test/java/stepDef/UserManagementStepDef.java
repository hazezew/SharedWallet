package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObj.web.*;

public class UserManagementStepDef extends AbstractPage {
    private ViewUserPage viewUserPage;
    private UpdateUserProfilePage updateUserProfilePage;
    private ResetPasswordPage resetPasswordPage;
    private SearchUserByTemplatePage searchUserByTemplatePage;
    private ChangeUserStatusPage changeUserStatusPage;
    private UpgradeUserKYCPage upgradeUserKYCPage;
    private SystemUserManagementPage systemUserManagementPage;
    private WalletManagementPage walletManagementPage;
    private ManageUserHierarchyPage manageUserHierarchyPage;
    private SearchBusinessUserByTemplatePage searchBusinessUserByTemplatePage;

    @Then("web user moves mouse over User Management main menu")
    public void web_user_moves_mouse_over_User_Management_main_menu() {
        adminDashboardPage.hoverLinkUserManagement();
    }

    @Then("web user clicks on View User sub menu")
    public void web_user_clicks_on_View_User_sub_menu() {
        viewUserPage=adminDashboardPage.clickSubmenuViewUser();
    }

    @Then("web system displays View User page")
    public void webSystemDisplaysViewUserPage() {
        Assert.assertEquals(viewUserPage.getURL(), Config.viewUserPageURL);
    }

    @And("web user enters {string} into username search textfield")
    public void webUserEntersIntoUsernameSearchTextfield(String username) {
        viewUserPage.setTxtUsername(username);
    }

    @And("web user clicks on search user button")
    public void webUserClicksOnSearchUserButton() {
        viewUserPage.clickBtnSearch();
    }
    @Then("view user page displays user validation message {string}")
    public void viewUserPageDisplaysUserValidationMessage(String emptyUserMsg) {
        Assert.assertEquals(viewUserPage.getUserValidationMsg(),emptyUserMsg);
    }

    @Then("view user page displays the searched user details")
    public void viewUserPageDisplaysTheSearchedUserDetails() {
//        Redo the test after bug resolution and implementation
        Assert.fail("Searching a user has never been well implemented. Please complete this test after implementation");
    }

    @Then("view user page displays {string} message")
    public void viewUserPageDisplaysMessage(String userDoesNotExistMsg) {
        Assert.assertEquals(viewUserPage.getErrorMessageDisplay(),userDoesNotExistMsg);
    }

    @And("web user clicks on Update User Profile sub menu")
    public void webUserClicksOnUpdateUserProfileSubMenu() {
        updateUserProfilePage=adminDashboardPage.clickSubmenuLinkUpdateUserProfile();
    }

    @Then("web system displays Update User Profile page")
    public void webSystemDisplaysUpdateUserProfilePage() {
        Assert.assertEquals(Config.updateUserProfilePageURL,updateUserProfilePage.getURL());
    }

    @And("web user enters {string} into username search textfield for update")
    public void webUserEntersIntoUsernameSearchTextfieldForUpdate(String username) {
        updateUserProfilePage.setTxtUsername(username);
    }

    @And("web user clicks on search user button for update")
    public void webUserClicksOnSearchUserButtonForUpdate() {
        updateUserProfilePage.clickBtnSearch();
    }
    @Then("Update User Profile page displays validation message {string}")
    public void updateUserProfilePageDisplaysValidationMessage(String usernameValidationMsg) {
        Assert.assertEquals(updateUserProfilePage.getUserValidationMsg(),usernameValidationMsg);
    }

    @Then("Update User Profile page displays the searched user details")
    public void updateUserProfilePageDisplaysTheSearchedUserDetails() {
//        Redo the test after bug resolution and implementation
//        Assert.fail("Updating a user has never been well implemented. Please complete this test after implementation");

    }

    @Then("Update User Profile page displays {string} message")
    public void updateUserProfilePageDisplaysMessage(String invalidUsernameMsg) {
        Assert.assertEquals(updateUserProfilePage.getValidationMessage(),invalidUsernameMsg);
    }

    @And("for User Profile update user selects {string} from Language dropdown")
    public void forUserProfileUpdateUserSelectsFromLanguageDropdown(String language) {
        updateUserProfilePage.setDdLanguage(language);
    }

    @And("for User Profile update user clicks on Next button")
    public void forUserProfileUpdateUserClicksOnNextButton() {
        updateUserProfilePage.clickBtnNext();
    }

    @And("for User Profile update user clicks on Next button again")
    public void forUserProfileUpdateUserClicksOnNextButtonAgain() {
        updateUserProfilePage.clickBtnNext2();
    }

    @And("for User Profile update user enters {string} into Fullname textfield")
    public void forUserProfileUpdateUserEntersIntoFullnameTextfield(String fullName) {
        updateUserProfilePage.setTxtFullName(fullName);
    }

    @And("for User Profile update user enters {string} into Email textfield")
    public void forUserProfileUpdateUserEntersIntoEmailTextfield(String email) {
        updateUserProfilePage.setTxtEmail(email);
    }

    @And("for User Profile update user enters {string} into Password textfield")
    public void forUserProfileUpdateUserEntersIntoPasswordTextfield(String newPassword) {
        updateUserProfilePage.setTxtNewPassword(newPassword);
    }

    @And("for User Profile update user enters {string} into Username textfield")
    public void forUserProfileUpdateUserEntersIntoUsernameTextfield(String newUsername) {
        updateUserProfilePage.setTxtNewUsername(newUsername);
    }

    @And("User Profile update user clicks on Submit button")
    public void userProfileUpdateUserClicksOnSubmitButton() {
        updateUserProfilePage.clickBtnSubmit();
    }

    @And("User Profile update user clicks on Ok popup alert button for confirmation")
    public void userProfileUpdateUserClicksOnOkPopupAlertForConfirmation() {
        updateUserProfilePage.clickBtnOkConfirm();
    }

    @And("web user clicks on Reset Password sub menu")
    public void webUserClicksOnResetPasswordSubMenu() {
        resetPasswordPage=adminDashboardPage.clickLinkResetPassword();
    }

    @Then("web system displays Reset Password page")
    public void webSystemDisplaysResetPasswordPage() {
        Assert.assertEquals(resetPasswordPage.getURL(),Config.resetPasswordPageURL);
    }

    @And("web user clicks on search user button for password reset")
    public void webUserClicksOnSearchUserButtonForPasswordReset() {
        resetPasswordPage.clickBtnSearch();
    }

    @Then("Reset Password page displays validation message {string}")
    public void resetPasswordPageDisplaysValidationMessage(String usernameValidationMsg) {
        Assert.assertEquals(usernameValidationMsg,resetPasswordPage.getUsernameValidationMessage());
    }

    @And("reset password user enters {string} into username search textfield")
    public void resetPasswordUserEntersIntoUsernameSearchTextfield(String username) {
        resetPasswordPage.setTxtUsername(username);
    }

    @Then("Reset Password page displays User details for password reset")
    public void resetPasswordPageDisplaysUserDetailsForPasswordReset() {
        Assert.fail("Searching an existing system user is not possible.");
    }

    @Then("Reset Password page displays message {string}")
    public void resetPasswordPageDisplaysMessage(String userValidationMsg) {
        Assert.assertEquals(resetPasswordPage.getValidationMessage(),userValidationMsg);
    }

    @And("web user clicks on Search User By Template sub menu")
    public void webUserClicksOnSearchUserByTemplateSubMenu() {
        searchUserByTemplatePage=adminDashboardPage.clickLinkSearchUserByTemplate();
    }

    @Then("web system displays Search User By Template page")
    public void webSystemDisplaysSearchUserByTemplatePage() {
        Assert.assertEquals(Config.SearchUserByTemplatePageURL,searchUserByTemplatePage.getURL());
    }

    @And("web user clicks on search button for Search User By Template")
    public void webUserClicksOnSearchButtonForSearchUserByTemplate() {
        searchUserByTemplatePage.clickBtnSearch();
    }

    @Then("Search User By Template page displays validation message {string}")
    public void searchUserByTemplatePageDisplaysValidationMessage(String validationMessage) {
        Assert.assertEquals(searchUserByTemplatePage.getSystemOperatorEntityValidation(),validationMessage);
    }

    @And("web user selects {string} from System Operator Entity dropdown")
    public void webUserSelectsFromSystemOperatorEntityDropdown(String systemOperatorEntity) {
        searchUserByTemplatePage.selectDDSystemOperatorEntity(systemOperatorEntity);
    }

    @Then("Search User By Template displays all users of selected template")
    public void searchUserByTemplateDisplaysAllUsersOfSelectedTemplate() {
        Assert.fail("Search User By Template with valid System Operator Entity implementation is not completed with error message: "+searchUserByTemplatePage.getErrorSuccessMessage());
    }

    @And("web user clicks on Change Status sub menu")
    public void webUserClicksOnChangeStatusSubMenu() {
        changeUserStatusPage=adminDashboardPage.clickLinkChangeStatus();
    }

    @Then("web system displays Change Status page")
    public void webSystemDisplaysChangeStatusPage() {
        Assert.assertEquals(changeUserStatusPage.getURL(),Config.changeUserStatusPageURL);
    }

    @And("web user clicks on search button for Change Status")
    public void webUserClicksOnSearchButtonForChangeStatus() {
        changeUserStatusPage.clickBtnSearch();
    }

    @Then("Change Status page displays validation message {string}")
    public void changeStatusPageDisplaysValidationMessage(String validationMessage) {
        Assert.assertEquals(changeUserStatusPage.getUsernameValidation(),validationMessage);
    }

    @And("change Status user enters {string} into username search textfield")
    public void changeStatusUserEntersIntoUsernameSearchTextfield(String username) {
        changeUserStatusPage.setTxtUsername(username);
    }

    @Then("Change Status page displays user details")
    public void changeStatusPageDisplaysUserDetails() {
        Assert.fail("Implementation not properly done. With internal error message: "+changeUserStatusPage.getErrorSuccessMessage());
    }

    @Then("Change Status page displays an error message {string}")
    public void changeStatusPageDisplaysAnErrorMessage(String errorMessage) {
        Assert.assertEquals(changeUserStatusPage.getErrorSuccessMessage(),errorMessage);
    }

    @And("web user clicks on Upgrade User KYC sub menu")
    public void webUserClicksOnUpgradeUserKYCSubMenu() {
        upgradeUserKYCPage=adminDashboardPage.clickLinkUpgradeUserKYC();
    }

    @Then("web system displays Upgrade User KYC page")
    public void webSystemDisplaysUpgradeUserKYCPage() {
        Assert.assertEquals(upgradeUserKYCPage.getURL(),Config.upgradeUserKYCPageURL);
    }

    @And("web user clicks on search button for Upgrade User KYC")
    public void webUserClicksOnSearchButtonForUpgradeUserKYC() {
        upgradeUserKYCPage.clickBtnSearch();
    }

    @Then("Upgrade User KYC page displays validation message {string}")
    public void upgradeUserKYCPageDisplaysValidationMessage(String usernameMandatoryValidation) {
        Assert.assertEquals(upgradeUserKYCPage.getUsernameValidation(),usernameMandatoryValidation);
    }

    @And("Upgrade User KYC user enters {string} into username search textfield")
    public void upgradeUserKYCUserEntersIntoUsernameSearchTextfield(String username) {
        upgradeUserKYCPage.setTxtUsername(username);
    }

    @Then("Upgrade User KYC page displays user details")
    public void upgradeUserKYCPageDisplaysUserDetails() {
        Assert.fail("Implementation not properly completed. Retest needed after proper implementation");
    }

    @Then("Upgrade User KYC page displays an error message {string}")
    public void upgradeUserKYCPageDisplaysAnErrorMessage(String errorMessage) {
        Assert.assertEquals(upgradeUserKYCPage.getErrorMessage(),errorMessage);
    }

    @And("web user clicks on System User Management sub menu")
    public void webUserClicksOnSystemUserManagementSubMenu() {
        systemUserManagementPage=adminDashboardPage.clickLinkSystemUserManagement();
    }

    @Then("web system displays System User Management page")
    public void webSystemDisplaysSystemUserManagementPage() {
        Assert.assertEquals(systemUserManagementPage.getURL(),Config.systemUserManagementPageURL);
    }

    @And("System User Management page user clicks on Add button")
    public void systemUserManagementPageUserClicksOnAddButton() {
        systemUserManagementPage.clickBtnAdd();
    }

    @And("on System User Management page user selects {string} from System Operator Entity dropdown")
    public void onSystemUserManagementPageUserSelectsFromSystemOperatorEntityDropdown(String entity) {
        systemUserManagementPage.selectDDSystemOperatorEntity(entity);
    }

    @And("on System User Management page user selects {string} from KYC Level dropdown")
    public void onSystemUserManagementPageUserSelectsFromKYCLevelDropdown(String kyc) {
        systemUserManagementPage.selectDDKYCLevel(kyc);
    }

    @And("on System User Management page user enters {string} into First Name textfield")
    public void onSystemUserManagementPageUserEntersIntoFirstNameTextfield(String firstName) {
        systemUserManagementPage.setTxtFirstName(firstName);
    }

    @And("on System User Management page user enters {string} into Middle Name SIB textfield")
    public void onSystemUserManagementPageUserEntersIntoMiddleNameSIBTextfield(String middleName) {
        systemUserManagementPage.setTxtMiddleName(middleName);
    }

    @And("on System User Management page user enters {string} into Last Name SIB textfield")
    public void onSystemUserManagementPageUserEntersIntoLastNameSIBTextfield(String lastName) {
        systemUserManagementPage.setTxtLastName(lastName);
    }

    @And("on System User Management page user enters {string} into Mobile Number SIB textfield")
    public void onSystemUserManagementPageUserEntersIntoMobileNumberSIBTextfield(String mobile) {
        systemUserManagementPage.setTxtMobileNumber(mobile);
    }

    @And("on System User Management page user enters {string} into AddressOne SIB textfield")
    public void onSystemUserManagementPageUserEntersIntoAddressSIBTextfield(String address) {
        systemUserManagementPage.setTxtAddress1(address);
    }

    @And("on System User Management page user enters {string} into Email SIB textfield")
    public void onSystemUserManagementPageUserEntersIntoEmailSIBTextfield(String email) {
        systemUserManagementPage.setTxtEmail(email);
    }

    @And("on System User Management page user clicks on Submit button")
    public void onSystemUserManagementPageUserClicksOnSubmitButton() {
        systemUserManagementPage.clickBtnSubmit();
    }

    @Then("System User Management page display a success message {string}")
    public void systemUserManagementPageDisplayASuccessMessage(String successMessage) {
        Assert.assertEquals(systemUserManagementPage.getErrorSuccessMessage(),successMessage);
    }

    @Then("System User Management page displays message {string}")
    public void systemUserManagementPageDisplaysMessage(String validationMessage) {
        Assert.assertEquals(systemUserManagementPage.getTenantValidationMessage(),validationMessage);
    }

    @Then("System User Management page displays an error message {string}")
    public void systemUserManagementPageDisplaysAnErrorMessage(String errorSuccessMessage) {
        Assert.assertEquals(systemUserManagementPage.getErrorSuccessMessage(),errorSuccessMessage);
    }

    @And("web user clicks on Wallet Management sub menu")
    public void webUserClicksOnWalletManagementSubMenu() {
        walletManagementPage=adminDashboardPage.clickLinkWalletManagement();
    }

    @Then("web system displays Wallet Management page")
    public void webSystemDisplaysWalletManagementPage() {
        Assert.assertEquals(walletManagementPage.getURL(),Config.walletManagementPageURL);
    }

    @And("on Wallet Management user enters {string} into user textfield")
    public void onWalletManagementUserEntersIntoUserTextfield(String username) {
        walletManagementPage.setTxtUsername(username);
    }

    @And("on Wallet Management user clicks search button")
    public void onWalletManagementUserClicksSearchButton() {
        walletManagementPage.clickBtnSearch();
    }

    @Then("Wallet Management page displays a mandatory validation message {string}")
    public void walletManagementPageDisplaysAMandatoryValidationMessage(String userMandatoryMessage) {
        Assert.assertEquals(walletManagementPage.getMandatoryUserValidation(),userMandatoryMessage);
    }

    @And("Wallet Management page displays no wallet owner details")
    public void walletManagementPageDisplaysNoWalletOwnerDetails() {
        Assert.assertFalse(walletManagementPage.getUserWalletStatus(),"System should not display wallet details for an empty wallet info");
    }

    @Then("Wallet Management page displays a validation message {string}")
    public void walletManagementPageDisplaysAValidationMessage(String validationMessage) {
        Assert.assertEquals(walletManagementPage.getValidationMessageDisplay(),validationMessage);
    }

    @Then("Wallet Management page displays wallet owner details")
    public void walletManagementPageDisplaysWalletOwnerDetails() {
        Assert.assertTrue(walletManagementPage.getUserWalletStatus(),"Implementation is not complete at time of writing this scenario.");
    }

    @And("on Wallet Management page user enters {string} into Wallet textfield")
    public void onWalletManagementPageUserEntersIntoWalletTextfield(String wallet) {
        walletManagementPage.setTxtWallet(wallet);
    }

    @And("web user clicks on Manage User Hierarchy sub menu")
    public void webUserClicksOnManageUserHierarchySubMenu() {
        manageUserHierarchyPage=adminDashboardPage.clickLinkManageUserHierarchy();
    }

    @Then("web system displays Manage User Hierarchy page")
    public void webSystemDisplaysManageUserHierarchyPage() {
        Assert.assertEquals(manageUserHierarchyPage.getURL(),Config.manageUserHierarchyPageURL);
    }

    @And("on Manage User Hierarchy page user clicks on search button")
    public void onManageUserHierarchyPageUserClicksOnSearchButton() {
        manageUserHierarchyPage.clickBtnSearch();
    }

    @Then("Manage User Hierarchy page displays a mandatory validation message {string}")
    public void manageUserHierarchyPageDisplaysAMandatoryValidationMessage(String mandatoryFieldValidation) {
        Assert.assertEquals(manageUserHierarchyPage.getUsernameMandatoryValidation(),mandatoryFieldValidation);
    }

    @When("on Manage User Hierarchy page user enters {string} into Tree Identifier textfield")
    public void onManageUserHierarchyPageUserEntersIntoTreeIdentifierTextfield(String username) {
        manageUserHierarchyPage.setTxtTreeIdentifier(username);
    }

    @Then("Manage User Hierarchy page displays popup validation message {string}")
    public void manageUserHierarchyPageDisplaysPopupValidationMessage(String popupValidationMessage) {
        Assert.assertEquals(manageUserHierarchyPage.getPopupUserValidationMessage(),popupValidationMessage);
    }

    @And("on Manage User Hierarchy popup page user clicks on cancel button")
    public void onManageUserHierarchyPopupPageUserClicksOnCancelButton() {
        manageUserHierarchyPage.clickPopupBtnCancel();
    }

    @And("Manage User Hierarchy page displays another validation message {string}")
    public void manageUserHierarchyPageDisplaysAnotherValidationMessage(String validationMessage) {
        Assert.assertEquals(manageUserHierarchyPage.getUserValidationMessage(),validationMessage);
    }

    @Then("Manage User Hierarchy page user moves mouse over wallet owner mobile number")
    public void manageUserHierarchyPageUserMovesMouseOverWalletOwnerMobileNumber() {
        manageUserHierarchyPage.hoverTreeMobileNumber();
    }

    @And("Manage User Hierarchy page user clicks on Edit option")
    public void manageUserHierarchyPageUserClicksOnEditOption() {
        manageUserHierarchyPage.clickPopupButtonEdit();
    }

    @And("Manage User Hierarchy page user clicks on Next button")
    public void manageUserHierarchyPageUserClicksOnNextButton() {
        manageUserHierarchyPage.clickBtnNext();
    }

    @And("Manage User Hierarchy page user clicks on Submit button")
    public void manageUserHierarchyPageUserClicksOnSubmitButton() {
        manageUserHierarchyPage.clickBtnSubmit();
    }

    @And("Manage User Hierarchy page user clicks on Confirm button")
    public void manageUserHierarchyPageUserClicksOnConfirmButton() {
        manageUserHierarchyPage.clickPopupConfirmation();
    }

    @And("web user clicks on Search Business User By Template sub menu")
    public void webUserClicksOnSearchBusinessUserByTemplateSubMenu() {
        searchBusinessUserByTemplatePage=adminDashboardPage.clickLinkSearchBusinessUserByTemplate();
    }

    @Then("web system displays Search Business User By Template page")
    public void webSystemDisplaysSearchBusinessUserByTemplatePage() {
        Assert.assertEquals(searchBusinessUserByTemplatePage.getURL(),Config.searchBusinessUserByTemplatePageURL);
    }

    @And("on Search Business User By Template page user clicks on search button")
    public void onSearchBusinessUserByTemplatePageUserClicksOnSearchButton() {
        searchBusinessUserByTemplatePage.clickBtnSearch();
    }

    @Then("Search Business User By Template page displays {string} message")
    public void searchBusinessUserByTemplatePageDisplaysMessage(String message) {
        Assert.assertEquals(searchBusinessUserByTemplatePage.getSuccessErrorMessage(),message);
    }

    @Then("Search Business User By Template page displays a mandatory validation message {string}")
    public void searchBusinessUserByTemplatePageDisplaysAMandatoryValidationMessage(String mandatoryValidationMessage) {
        Assert.assertEquals(searchBusinessUserByTemplatePage.getDdOperatingEntityTemplateMandatoryMessage(),mandatoryValidationMessage);
    }

    @And("on Search Business User By Template page user selects {string} from Operating Entity Template dropdown")
    public void onSearchBusinessUserByTemplatePageUserSelectsFromOperatingEntityTemplateDropdown(String template) {
        searchBusinessUserByTemplatePage.setDdOperatingEntityTemplate(template);
    }
    @And("on Search Business User By Template page user enters {string} into Tree Identifier textfield")
    public void onSearchBusinessUserByTemplatePageUserEntersIntoTreeIdentifierTextfield(String identifier) {
        searchBusinessUserByTemplatePage.setTxtInputTreeIdentifier(identifier);
    }

    @Then("on Search Business User By Template page user clicks on show user info icon")
    public void onSearchBusinessUserByTemplatePageUserClicksOnShowUserInfoIcon() {
        searchBusinessUserByTemplatePage.clickIconShowUserInfo();
    }

    @And("on Search Business User By Template page user clicks on user info tab")
    public void onSearchBusinessUserByTemplatePageUserClicksOnUserInfoTab() {
        searchBusinessUserByTemplatePage.clickTabUserInfo();
    }

    @And("on Search Business User By Template page user clicks on agent info tab")
    public void onSearchBusinessUserByTemplatePageUserClicksOnAgentInfoTab() {
        searchBusinessUserByTemplatePage.clickTabPersonalInformation();
    }

    @And("on Search Business User By Template page user clicks on login info tab")
    public void onSearchBusinessUserByTemplatePageUserClicksOnLoginInfoTab() {
        searchBusinessUserByTemplatePage.clickTabLoginInfo();
    }

    @And("on Search Business User By Template page user clicks on user info ok button")
    public void onSearchBusinessUserByTemplatePageUserClicksOnUserInfoOkButton() {
        searchBusinessUserByTemplatePage.clickBtnPopupUserInfoOk();
    }

    @Then("on Search Business User By Template page user clicks on view user hierarchy icon")
    public void onSearchBusinessUserByTemplatePageUserClicksOnViewUserHierarchyIcon() {
        searchBusinessUserByTemplatePage.clickIconViewUserHierarchy();
    }

    @And("on Search Business User By Template page user clicks on user hierarchy ok button")
    public void onSearchBusinessUserByTemplatePageUserClicksOnUserHierarchyOkButton() {
        searchBusinessUserByTemplatePage.clickBtnPopupUserHierarchyOk();
    }
}
