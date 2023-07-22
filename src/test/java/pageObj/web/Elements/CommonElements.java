package pageObj.web.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonElements {

    @FindBy(xpath = "//button[@id='operationbarbuttonadd']")
    public static WebElement addButton;
    @FindBy(xpath = "//button[@id='operationbarbuttonsave']")
    public static WebElement saveButton;
    @FindBy(xpath = "//button[@id='operationbarbuttonserversearch']")
    public static WebElement filterIcon;
    @FindBy(xpath = "//button[.='Ok']")
    public static WebElement okConfirmationButton;
    @FindBy(xpath = "//button[@id='operationbarbuttondelete']")
    public static WebElement deleteButton;
    @FindBy(xpath = "//button[@id='operationbarbuttonedit']")
    public static WebElement editButton;
    @FindBy(xpath = "//button[@id='searchbutton']")
    public static WebElement searchButton;
    @FindBy(xpath = "//input[@name='name']")
    public static WebElement searchInputField;
    @FindBy(xpath = "//button[@id='operationbarbuttonback']")
    public static WebElement backButton;
    @FindBy(xpath = "//div[@class='ant-modal-content']")
    public static WebElement warningInfoModal;

    @FindBy(xpath = "//div[@class='ant-form-explain']")
    public static List<WebElement> validationMessages;

    @FindBy(xpath = "(//button[@id='operationbarbuttonexport'])[2]")
    public static WebElement exportButton;
    @FindBy(xpath = "//button[@class='ant-btn exportBtn ant-btn-icon-only']")
    public static WebElement exportHistoryButton;
    @FindBy(xpath = "//input[@id='form_in_modal_inputExportName']")
    public static WebElement exportNameField;
    @FindBy(xpath = "//textarea[@id='form_in_modal_inputExportDescription']")
    public static WebElement exportDescriptionField;
    @FindBy(xpath = "//button[.='Save']")
    public static WebElement exportSaveButton;
    @FindBy(xpath = "(//button[@class='ant-btn exportBtn'])[1]")
    public static WebElement downloadButton;
    @FindBy(xpath = "//div[@class='ant-progress-inner']")
    public static WebElement downloadProgressSuccess;

    @FindBy(xpath = "//div[@class='ant-alert ant-alert-error ant-alert-with-description server-alert']")
    public static WebElement duplicateErrorMessage;
    @FindBy(xpath = "//span[@class='ant-alert-description']")
    public static WebElement duplicateValidationText;
}
