package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.ServiceVendorPage;

public class BusinessConfigStepDef extends AbstractPage {
    private ServiceVendorPage serviceVendorPage;

    @And("web user moves mouse over Business Config main menu")
    public void webUserMovesMouseOverBusinessConfigMainMenu() {
        adminDashboardPage.hoverOnBusinessConfigMenu();
    }
    @And("web user clicks on service vendor sub menu")
    public void clicksOnUnitSubMenu() {
        serviceVendorPage = adminDashboardPage.clickOnServiceVendorSubMenu();
    }

    @Then("web system displays service vendor configuration page")
    public void webSystemDisplaysServiceVendorConfigurationPage() {
        Assert.assertEquals(Config.serviceVendorConfigurationPageURL, serviceVendorPage.getServiceVendorPageURL());
    }

    @When("web user clicks on add button for service vendor config")
    public void webUserClicksOnAddButtonForServiceVendorConfig() {
        serviceVendorPage.clickAddButton();
    }

    @And("web user fills service vendor details {string} {string} {string} and {string}")
    public void webUserFillsServiceVendorDetailsAnd(String name, String vendorType, String vendorService, String description) {
        serviceVendorPage.fillServiceVendorDetail(name,vendorType, vendorService, description);
    }

    @And("web user select {string} for service vendor status")
    public void webUserSelectForServiceVendorStatus(String status) {
        serviceVendorPage.selectStatus(status);
    }

    @And("web user fills extra service vendor details {string} {string} {string} and {string}")
    public void webUserFillsExtraServiceVendorDetailsAnd(String vendorService, String selectionAlgorithm, String sortingFunction, String lcr) {
        serviceVendorPage.fillExtraDetail(vendorService, selectionAlgorithm, sortingFunction, lcr);

    }

    @And("web user clicks on save button for service vendor")
    public void webUserClicksOnSaveButtonForServiceVendor() {
        serviceVendorPage.clickSaveButton();
    }

    @Then("web user should see the {string} service vendor is created")
    public void verifyTheServiceVendorIsCreated(String serviceVendorName) {
        serviceVendorPage.verifyServiceVendorCreated(serviceVendorName);
    }

    @And("web user clicks on view icon for {string} service vendor")
    public void clicksOnViewIconForServiceVendor(String serviceVendorName) {
        serviceVendorPage.clickViewIcon(serviceVendorName);
    }

    @And("web user delete the created service vendor")
    public void deleteTheCreatedServiceVendor() {
        serviceVendorPage.deleteServiceVendor();
    }

    @Then("web system displays validation message for service vendor config")
    public void verifyValidationMessageForServiceVendorConfig() {
        serviceVendorPage.verifyValidationMessage();
    }

    @Then("verify system displays {string} error message for service vendor")
    public void verifyErrorMessageForServiceVendor(String errorMessage) {
        serviceVendorPage.verifyErrorMessage(errorMessage);
    }

    @And("web user clicks edit button for service vendor")
    public void clicksEditButtonForServiceVendor() {
        serviceVendorPage.clickEditButton();
    }

    @When("web user update service vendor {string} and {string}")
    public void webUserUpdateServiceVendorAnd(String vendorService, String description) {
        serviceVendorPage.updateServiceVendor(vendorService, description);
    }
}
