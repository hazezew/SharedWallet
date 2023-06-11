package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObj.web.AbstractPage;
import pageObj.web.FieldMappingPage;

public class TechnicalConfigStepDef extends AbstractPage {
    private FieldMappingPage fieldMappingPage;

    @And("web user moves mouse over Technical Config main menu")
    public void webUserMovesMouseOverTechnicalConfigMainMenu() {
        adminDashboardPage.hoverLinkTechnicalConfig();
    }

    @And("web user clicks on Field Mapping sub menu")
    public void webUserClicksOnFieldMappingSubMenu() {
        fieldMappingPage=adminDashboardPage.clickLinkFieldMapping();
    }

    @Then("web system displays Field Mapping page")
    public void webSystemDisplaysFieldMappingPage() {
        Assert.assertEquals(fieldMappingPage.getURL(), Config.fieldMappingPageURL);
    }
}
