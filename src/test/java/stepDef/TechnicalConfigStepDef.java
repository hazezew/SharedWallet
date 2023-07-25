package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.pages.technicalconfig.*;

public class TechnicalConfigStepDef extends AbstractPage {
    private FieldMappingPage fieldMappingPage;
    private AddBlackListPage addBlackListPage;
    private ApplyBlackListPage applyBlackListPage;
    private MenuConfigPage menuConfigPage;
    private ProcessPage processPage;
    private SchedulerPage schedulerPage;
    private StandardMasterPage standardMasterPage;
    private ProcessRunDetailPage processRunDetailPage;
    private ProcessSchedulerPage processSchedulerPage;


    @And("web user moves mouse over Technical Config main menu")
    public void webUserMovesMouseOverTechnicalConfigMainMenu() {
        adminDashboardPage.hoverLinkTechnicalConfig();
    }

    @And("web user clicks on Field Mapping sub menu")
    public void webUserClicksOnFieldMappingSubMenu() {
        fieldMappingPage = adminDashboardPage.clickLinkFieldMapping();
    }

    @Then("web system displays Field Mapping page")
    public void webSystemDisplaysFieldMappingPage() {
        Assert.assertEquals(fieldMappingPage.getURL(), Config.fieldMappingPageURL);
    }
    @And("web user clicks on add blacklist sub menu")
    public void webUserClicksOnAddBlacklistSubMenu() {
        addBlackListPage = adminDashboardPage.clickAddBlacklistSubMenu();
    }

    @Then("web system displays add blacklist page")
    public void webSystemDisplaysAddBlacklistPage() {
        Assert.assertEquals(addBlackListPage.getURL(), Config.addBlacklistPageURL);
    }

    @And("web user clicks on apply blacklist sub menu")
    public void webUserClicksOnApplyBlacklistSubMenu() {
        applyBlackListPage = adminDashboardPage.clickApplyBlackListSubMenu();
    }

    @Then("web system displays apply blacklist page")
    public void webSystemDisplaysApplyBlacklistPage() {
        Assert.assertEquals(applyBlackListPage.getURL(), Config.applyBlacklistPageURL);
    }
    @And("web user clicks on menu config sub menu")
    public void webUserClicksMenuConfigSubMenu() {
        menuConfigPage = adminDashboardPage.clickMenuConfigSubMenu();
    }

    @Then("web system displays menu config page")
    public void webSystemDisplaysMenuConfigPage() {
        Assert.assertEquals(menuConfigPage.getURL(), Config.menuConfigPageURL);
    }
    @And("web user clicks on process config sub menu")
    public void webUserClicksOnProcessSubMenu() {
        processPage = adminDashboardPage.clickProcessSubMenu();
    }
    @Then("web system displays process config page")
    public void webSystemDisplaysProcessPage() {
        Assert.assertEquals(processPage.getURL(), Config.processPageURL);
    }

    @And("web user clicks on process run detail sub menu")
    public void webUserClicksOnProcessRunDetailSubMenu() {
        processRunDetailPage = adminDashboardPage.clickProcessRunDetailSubMenu();
    }

    @Then("web system displays process run detail page")
    public void webSystemDisplaysProcessRunDetailPage() {
        Assert.assertEquals(processRunDetailPage.getURL(), Config.processRunDetailPageURL);
    }
    @And("web user clicks on process scheduler sub menu")
    public void webUserClicksOnProcessSchedulerSubMenu() {
        processSchedulerPage = adminDashboardPage.clickProcessSchedulerSubMenu();
    }
    @Then("web system displays process scheduler page")
    public void webSystemDisplaysProcessSchedulerPage() {
        Assert.assertEquals(processSchedulerPage.getURL(), Config.processSchedulerPageURL);
    }
    @And("web user clicks on scheduler sub menu")
    public void webUserClicksOnSchedulerSubMenu() {
        schedulerPage = adminDashboardPage.clickSchedulerSubMenu();
    }
    @Then("web system displays scheduler page")
    public void webSystemDisplaysSchedulerPage() {
        Assert.assertEquals(schedulerPage.getURL(), Config.schedulerPageURL);
    }
    @And("web user clicks on standard master sub menu")
    public void webUserClicksOnStandardMasterSubMenu() {
        standardMasterPage = adminDashboardPage.clickStandardMasterSubMenu();
    }
    @Then("web system displays standard master page")
    public void webSystemDisplaysStandardMasterPage() {
        Assert.assertEquals(standardMasterPage.getURL(), Config.standardMasterPageURL);
    }
}
