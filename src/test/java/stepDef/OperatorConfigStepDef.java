package stepDef;


import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
    public void webSystemDisplaysMoveSystemOperatorPage() {
        Assert.assertEquals(Config.moveSystemOperatorConfigurationPageURL, moveSystemOperatorPage.getMoveSystemOperatorPageURL());
    }

    @And("web user clicks on role config sub menu")
    public void webUserClicksOnRoleConfigSubMenu() {
        roleConfigPage = adminDashboardPage.clickOnRoleConfigSubMenu();
    }

    @Then("web system displays role config page")
    public void webSystemDisplaysRoleConfigPage() {
        Assert.assertEquals(Config.roleConfigurationPageURL, roleConfigPage.getURL());
    }

    @And("web user clicks on system operator config sub menu")
    public void webUserClicksOnSystemOperatorConfigSubMenu() {
        systemOperatorEntityPage = adminDashboardPage.clickOnSystemOperatorSubMenu();
    }

    @Then("web system displays system operator config page")
    public void webSystemDisplaysSystemOperatorConfigPage() {
        Assert.assertEquals(Config.systemOperatorConfigurationPageURL, systemOperatorEntityPage.getURL());
    }

    @And("web user clicks on system operator onboarding sub menu")
    public void webUserClicksOnSystemOperatorOnboardingSubMenu() {
        systemOperatorOnboardingPage = adminDashboardPage.clickOnSystemOperatorOnboardingSubMenu();
    }

    @Then("web system displays system operator onboarding page")
    public void webSystemDisplaysSystemOperatorOnboardingPage() {
        Assert.assertEquals(Config.systemOperatorOnboardingPageURL, systemOperatorOnboardingPage.getURL());
    }
}
