package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.pages.operation.*;

public class OperationStepDef extends AbstractPage {
    private AccountManagementPage accountManagementPage;
    private AddMoneyPage addMoneyPage;
    private FundTransferPage fundTransferPage;
    private ResendNotificationPage resendNotificationPage;
    private TransactionReversalPage transactionReversalPage;


    @And("web user moves mouse over operation main menu")
    public void webUserMovesMouseOverPlatformConfigMainMenu() {
        adminDashboardPage.hoverOnOperationMenu();
    }
    @And("web user clicks on account management sub menu")
    public void webUserClicksOnAccountManagementSubMenu() {
        accountManagementPage = adminDashboardPage.clickOnAccountManagementSubMenu();
    }
    @Then("web system displays account management page")
    public void webSystemDisplaysAccountMgtPage() {
        Assert.assertEquals(Config.accountManagementPageURL, accountManagementPage.getURL());
    }
    @And("web user clicks on add money sub menu")
    public void webUserClicksOnAddMoneySubMenu() {
        addMoneyPage = adminDashboardPage.clickOnAddMoneySubMenu();
    }
    @Then("web system displays add money page")
    public void webSystemDisplaysAddMoneyPage() {
        Assert.assertEquals(Config.addMoneyPageURL, addMoneyPage.getURL());
    }
    @And("web user clicks on fund transfer sub menu")
    public void webUserClicksOnFundTransferSubMenu() {
        fundTransferPage = adminDashboardPage.clickOnFundTransferSubMenu();
    }
    @Then("web system displays fund transfer page")
    public void webSystemDisplaysFundTransferPage() {
        Assert.assertEquals(Config.fundTransferPageURL, fundTransferPage.getURL());
    }
    @And("web user clicks on resend notification sub menu")
    public void webUserClicksOnResendNotificationSubMenu() {
        resendNotificationPage = adminDashboardPage.clickOnResendNotificationSubMenu();
    }
    @Then("web system displays resend notification page")
    public void webSystemDisplaysResendNotificationPage() {
        Assert.assertEquals(Config.resendNotificationPageURL, resendNotificationPage.getURL());
    }
    @And("web user clicks on transaction reversal sub menu")
    public void webUserClicksOnTransactionReversalSubMenu() {
        transactionReversalPage = adminDashboardPage.clickOnTransactionReversalSubMenu();
    }
    @Then("web system displays transaction reversal page")
    public void webSystemDisplaysTransactionPage() {
        Assert.assertEquals(Config.transactionReversalPageURL, transactionReversalPage.getURL());
    }

    @When("web user input add money detail {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void inputAddMoneyDetail(String fromUser, String fromWallet, String fromPouch, String toUser, String toWallet, String toPouch, String amount, String service, String product, String remark) {
    addMoneyPage.enterAddMoneyDetail(fromUser, fromWallet, fromPouch, toUser, toWallet, toPouch, amount, service, product,remark);
    }

    @When("web user enter transaction reversal detail {string} {string} {string}")
    public void enterTransactionReversal(String transactionId, String fromDate, String toDate) {
        transactionReversalPage.enterTransactionReversal(transactionId, fromDate, toDate);
    }

    @And("web user click search button")
    public void clickSearchButton() {
        transactionReversalPage.clickSearchButton();
    }

    @Then("web system displays validation message for transaction reversal")
    public void verifyValidationMessages() {
        transactionReversalPage.verifyValidationMessage();
    }

    @When("web user click on filter icon for account management")
    public void clickOnFilterIconForAccountManagement() {
        accountManagementPage.clickFilterIcon();
    }

    @And("web user enters {string} into account management search name field")
    public void enterSearchedKeywordForAccountManagement(String accountName) {
        accountManagementPage.enterNameInToSearchField(accountName);
    }

    @And("web user select {string} for the search account management filter criteria")
    public void selectSearchAccountManagementFilterCriteria(String criteria) {
        accountManagementPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search account management button")
    public void clicksSearchAccountManagementButton() {
        accountManagementPage.clickSearchButton();
    }

    @Then("web system displays a list of account managements with {string} on the name")
    public void verifySearchResultsForAccountManagement(String accountName) {
        accountManagementPage.verifyAccountManagementSearchResults(accountName);
    }

    @When("web user enters fund detail {string} {string} {string} {string} {string} {string} {string}")
    public void enterFundDetail(String fromAccount, String toAccount, String service, String product, String amount, String remark, String password) {
        fundTransferPage.enterFundDetail(fromAccount, toAccount, service, product, amount, remark, password);
    }

    @When("web user click send icon for {string} address")
    public void clickSendButtonForAddress(String receiverDetail) {
        resendNotificationPage.clickSendIcon(receiverDetail);
    }

    @And("web user click send button")
    public void clickSendButton() {
        resendNotificationPage.clickSendButton();
    }

    @When("web user click on filter icon for resend notification")
    public void clickOnFilterIconForResendNotification() {
        resendNotificationPage.clickFilterIcon();
    }

    @And("web user enters {string} into resend notification search receiver field")
    public void enterSearchedKeywordForResendNotification(String notification) {
        resendNotificationPage.enterNameInToSearchField(notification);
    }

    @And("web user select {string} for the search resend notification filter criteria")
    public void selectSearchResendNotificationFilterCriteria(String criteria) {
        resendNotificationPage.selectSearchCriteria(criteria);
    }

    @And("web user clicks search resend notification button")
    public void clicksSearchResendNotificationButton() {
        resendNotificationPage.clickSearchButton();
    }

    @Then("web system displays a list of resend notifications with {string} on the receiver")
    public void verifySearchResultsForResendNotification(String notification) {
        resendNotificationPage.verifyResendNotificationSearchResults(notification);
    }

}
