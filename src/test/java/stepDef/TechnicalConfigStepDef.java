package stepDef;

import util.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void webSystemDisplaysFieldMappingPage() throws Exception {
        Assert.assertEquals(fieldMappingPage.getURL(), PropertiesReader.getValue("fieldMappingPageURL"));
    }
    @And("web user clicks on add blacklist sub menu")
    public void webUserClicksOnAddBlacklistSubMenu() {
        addBlackListPage = adminDashboardPage.clickAddBlacklistSubMenu();
    }

    @Then("web system displays add blacklist page")
    public void webSystemDisplaysAddBlacklistPage() throws Exception {
        Assert.assertEquals(addBlackListPage.getURL(),
                PropertiesReader.getValue("addBlacklistPageURL"));
    }

    @And("web user clicks on apply blacklist sub menu")
    public void webUserClicksOnApplyBlacklistSubMenu() {
        applyBlackListPage = adminDashboardPage.clickApplyBlackListSubMenu();
    }

    @Then("web system displays apply blacklist page")
    public void webSystemDisplaysApplyBlacklistPage() throws Exception {
        Assert.assertEquals(applyBlackListPage.getURL(),
                PropertiesReader.getValue("applyBlacklistPageURL"));
    }
    @And("web user clicks on menu config sub menu")
    public void webUserClicksMenuConfigSubMenu() {
        menuConfigPage = adminDashboardPage.clickMenuConfigSubMenu();
    }

    @Then("web system displays menu config page")
    public void webSystemDisplaysMenuConfigPage() throws Exception {
        Assert.assertEquals(menuConfigPage.getURL(), PropertiesReader.getValue("menuConfigPageURL"));
    }
    @And("web user clicks on process config sub menu")
    public void webUserClicksOnProcessSubMenu() {
        processPage = adminDashboardPage.clickProcessSubMenu();
    }
    @Then("web system displays process config page")
    public void webSystemDisplaysProcessPage() throws Exception {
        Assert.assertEquals(processPage.getURL(), PropertiesReader.getValue("processPageURL"));
    }

    @And("web user clicks on process run detail sub menu")
    public void webUserClicksOnProcessRunDetailSubMenu() {
        processRunDetailPage = adminDashboardPage.clickProcessRunDetailSubMenu();
    }

    @Then("web system displays process run detail page")
    public void webSystemDisplaysProcessRunDetailPage() throws Exception {
        Assert.assertEquals(processRunDetailPage.getURL(),
                PropertiesReader.getValue("processRunDetailPageURL"));
    }
    @And("web user clicks on process scheduler sub menu")
    public void webUserClicksOnProcessSchedulerSubMenu() {
        processSchedulerPage = adminDashboardPage.clickProcessSchedulerSubMenu();
    }
    @Then("web system displays process scheduler page")
    public void webSystemDisplaysProcessSchedulerPage() throws Exception {
        Assert.assertEquals(processSchedulerPage.getURL(), PropertiesReader.getValue("processSchedulerPageURL"));
    }
    @And("web user clicks on scheduler sub menu")
    public void webUserClicksOnSchedulerSubMenu() {
        schedulerPage = adminDashboardPage.clickSchedulerSubMenu();
    }
    @Then("web system displays scheduler page")
    public void webSystemDisplaysSchedulerPage() throws Exception {
        Assert.assertEquals(schedulerPage.getURL(), PropertiesReader.getValue("schedulerPageURL"));
    }
    @And("web user clicks on standard master sub menu")
    public void webUserClicksOnStandardMasterSubMenu() {
        standardMasterPage = adminDashboardPage.clickStandardMasterSubMenu();
    }
    @Then("web system displays standard master page")
    public void webSystemDisplaysStandardMasterPage() throws Exception {
        Assert.assertEquals(standardMasterPage.getURL(),
                PropertiesReader.getValue("standardMasterPageURL"));
    }

    @When("web user click on filter icon for process")
    public void clickOnFilterIconForProcess() {
        processPage.clickFilterIcon();
    }

    @And("web user enters {string} into process search name field")
    public void enterSearchedKeywordForProcess(String processName) {
        processPage.enterNameInToSearchField(processName);
    }

    @And("web user select {string} for the search process filter criteria")
    public void selectSearchProcessFilterCriteria(String criteria) {
        processPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search process button")
    public void clicksSearchProcessButton() {
        processPage.clickSearchButton();
    }

    @Then("web system displays a list of processes with {string} on the name")
    public void verifySearchResultsForProcess(String processName) {
        processPage.verifyProcessSearchResults(processName);
    }

    @When("web user click add button for field mapping")
    public void clickAddbutton() {
        fieldMappingPage.clickAddButton();
    }

    @And("web user click save button for field mapping")
    public void clickSaveButton() {
        fieldMappingPage.clickSaveButton();
    }
    @Then("web system displays validation message for field mapping")
    public void verifyValidationMessageForFieldMapping() {
        fieldMappingPage.verifyValidationMessage();
    }

    @When("web user click on filter icon for field mapping")
    public void clickOnFilterIconForFieldMapping() {
        fieldMappingPage.clickFilterIcon();
    }

    @And("web user enters {string} into field mapping search name field")
    public void enterSearchedKeywordForFieldMapping(String fieldMappingName) {
        fieldMappingPage.enterNameInToSearchField(fieldMappingName);
    }

    @And("web user select {string} for the search field mapping filter criteria")
    public void selectSearchFieldMappingFilterCriteria(String criteria) {
        fieldMappingPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search field mapping button")
    public void clicksSearchFieldMappingButton() {
        fieldMappingPage.clickSearchButton();
    }

    @Then("web system displays a list of field mappings with {string} on the name")
    public void verifySearchResultsForFieldMapping(String fieldMappingName) {
        fieldMappingPage.verifyFieldMappingSearchResults(fieldMappingName);
    }

    @When("web user click on filter icon for process run detail")
    public void clickOnFilterIconForProcessRunDetail() {
        processRunDetailPage.clickFilterIcon();
    }

    @And("web user enters {string} into process run detail search name field")
    public void enterSearchedKeywordForProcessRunDetail(String processName) {
        processRunDetailPage.enterNameInToSearchField(processName);
    }

    @And("web user select {string} for the search process run detail filter criteria")
    public void selectSearchProcessRunDetailFilterCriteria(String criteria) {
        processRunDetailPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search process run detail button")
    public void clicksSearchProcessRunDetailButton() {
        processRunDetailPage.clickSearchButton();
    }

    @Then("web system displays a list of process run details with {string} on the name")
    public void verifySearchResultsForProcessRunDetail(String processName) {
        processRunDetailPage.verifyProcessRunDetailSearchResults(processName);
    }

    @When("web user click on filter icon for process scheduler")
    public void clickOnFilterIconForProcessProcessScheduler() {
        processSchedulerPage.clickFilterIcon();
    }

    @And("web user enters {string} into process scheduler search name field")
    public void enterSearchedKeywordForProcessProcessScheduler(String schedulerName) {
        processSchedulerPage.enterNameInToSearchField(schedulerName);
    }

    @And("web user select {string} for the search process scheduler filter criteria")
    public void selectSearchProcessProcessSchedulerFilterCriteria(String criteria) {
        processSchedulerPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search process scheduler button")
    public void clicksSearchProcessProcessSchedulerButton() {
        processSchedulerPage.clickSearchButton();
    }

    @Then("web system displays a list of process schedulers with {string} on the name")
    public void verifySearchResultsForProcessScheduler(String schedulerName) {
        processSchedulerPage.verifyProcessSchedulerSearchResults(schedulerName);
    }

    @When("web user click on filter icon for scheduler")
    public void clickOnFilterIconForScheduler() {
        schedulerPage.clickFilterIcon();
    }

    @And("web user enters {string} into scheduler search name field")
    public void enterSearchedKeywordForScheduler(String processName) {
        schedulerPage.enterNameInToSearchField(processName);
    }

    @And("web user select {string} for the search scheduler filter criteria")
    public void selectSearchSchedulerFilterCriteria(String criteria) {
        schedulerPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search scheduler button")
    public void clicksSearchSchedulerButton() {
        schedulerPage.clickSearchButton();
    }

    @Then("web system displays a list of schedulers with {string} on the name")
    public void verifySearchResultsForScheduler(String schedulerName) {
        schedulerPage.verifySchedulerSearchResults(schedulerName);
    }

    @When("web user click on filter icon for standard master")
    public void clickOnFilterIconForStandardMaster() {
        standardMasterPage.clickFilterIcon();
    }

    @And("web user enters {string} into standard master search name field")
    public void enterSearchedKeywordForStandardMaster(String standardMasterName) {
        standardMasterPage.enterNameInToSearchField(standardMasterName);
    }

    @And("web user select {string} for the search standard master filter criteria")
    public void selectSearchStandardMasterFilterCriteria(String criteria) {
        standardMasterPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search standard master button")
    public void clicksSearchStandardMasterButton() {
        standardMasterPage.clickSearchButton();
    }

    @Then("web system displays a list of standard masters with {string} on the name")
    public void verifySearchResultsForStandardMaster(String standardMasterName) {
        standardMasterPage.verifyStandardMasterSearchResults(standardMasterName);
    }

}
