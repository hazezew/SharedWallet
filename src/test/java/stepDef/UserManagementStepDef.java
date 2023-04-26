package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.UpdateUserProfilePage;
import pageObj.web.ViewUserPage;

public class UserManagementStepDef extends AbstractPage {
    private ViewUserPage viewUserPage;
    private UpdateUserProfilePage updateUserProfilePage;

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
}
