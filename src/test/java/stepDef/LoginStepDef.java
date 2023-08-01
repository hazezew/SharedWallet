package stepDef;

import util.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.LoginPage;

public class LoginStepDef extends AbstractPage {
    private LoginPage loginPage;
    private WebDriver driver;

    public LoginStepDef(){
        this.driver=super.driver;
    }
    @When("user has entered Shared Wallet system URL")
    public void user_has_entered_Shared_Wallet_system_URL() throws Exception {
        driver.navigate().to(PropertiesReader.getValue("webURL"));
        loginPage=new LoginPage(driver);
    }

    @When("web user enters username into username text field")
    public void web_user_enters_into_Username_text_field() throws Exception {
        loginPage.setTxtUsername();
    }

    @When("web user enters password into password text field")
    public void web_user_enters_into_password_text_field() throws Exception {
        loginPage.setTxtPassword();
    }
    @And("web user enters incorrect username into username text field")
    public void enterIncorrectPasswordInToUsernameField() throws Exception {
        loginPage.setIncorrectUsername();
    }
    @And("web user enters incorrect password into password text field")
    public void enterIncorrectPasswordInToPasswordField() throws Exception {
        loginPage.setIncorrectPassword();
    }
    @When("web user selects {string} from timezone dropdown")
    public void web_user_selects_from_timezone_dropdown(String timezone) {
        loginPage.selectTimeZone(timezone);
    }

    @When("web user clicks on Login button")
    public void web_user_clicks_on_Login_button() {
        adminDashboardPage=loginPage.clickBtnLogin();
    }

    @Then("web system displays {string} message")
    public void webSystemDisplaysAsASuccessfulLoginMessage(String loginSuccessMsg) {
        Assert.assertEquals(loginPage.getLoginSuccessErrorMessage(),loginSuccessMsg);
    }

    @And("web system displays Admin dashboard")
    public void web_system_displays_Admin_dashboard() throws Exception {
        Assert.assertEquals(adminDashboardPage.getURL(),PropertiesReader.getValue("adminDashboardPageURL"));
    }
    @And("web user clicks on settings link")
    public void webUserClicksOnSettingsLink() {
        adminDashboardPage.clickLinkSettings();
    }

    @Then("web user clicks on Logout link")
    public void web_user_clicks_on_Logout_button() {
        loginPage=adminDashboardPage.clickLinkLogout();
    }

    @Then("web system logs out and displays login page")
    public void web_system_logs_out_and_displays_login_page() throws Exception {
        Assert.assertEquals(loginPage.getURL(),PropertiesReader.getValue("webURL"));
    }

    @Then("web system displays {string} as mandatory username validation message")
    public void webSystemDisplaysAsMandatoryUsernameValidationMessage(String usernameValidationMsg) {
        Assert.assertEquals(loginPage.getEmptyUsernameMsg(),usernameValidationMsg);
    }

    @Then("web system displays {string} as mandatory password validation message")
    public void webSystemDisplaysAsMandatoryPasswordValidationMessage(String passwordValidationMsg) {
        Assert.assertEquals(loginPage.getEmptyPasswordMsg(),passwordValidationMsg);
    }
}
