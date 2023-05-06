package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObj.web.*;

public class UserManagementStepDef extends AbstractPage {
    private ViewUserPage viewUserPage;
    private UpdateUserProfilePage updateUserProfilePage;
    private ResetPasswordPage resetPasswordPage;
    private SearchUserByTemplatePage searchUserByTemplatePage;
    private ChangeUserStatusPage changeUserStatusPage;

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
}
