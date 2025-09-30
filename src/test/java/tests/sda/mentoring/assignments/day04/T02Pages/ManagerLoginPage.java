package tests.sda.mentoring.assignments.day04.T02Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class ManagerLoginPage {

    public ManagerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[ng-click='manager()']")
    private WebElement managerLoginBtn;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    private WebElement homeBtn;

    public void loginAsManager() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(managerLoginBtn));
        managerLoginBtn.click();
    }

    public void goHome() {
        homeBtn.click();
    }
}