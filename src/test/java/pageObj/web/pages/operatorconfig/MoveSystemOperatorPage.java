package pageObj.web.pages.operatorconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoveSystemOperatorPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public MoveSystemOperatorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public String getMoveSystemOperatorPageURL(){
        return driver.getCurrentUrl();
    }
}
