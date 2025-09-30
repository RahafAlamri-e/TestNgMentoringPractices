package tests.sda.mentoring.assignments.day04.T02Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AccountManagementPage {

    public AccountManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountBtn;

    @FindBy(id = "userSelect")
    private WebElement customerDropdown;

    @FindBy(id = "currency")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//button[text()='Process']")
    private WebElement processBtn;

    public void createAccount(String customerName, String currency) {
        openAccountBtn.click();
        new Select(customerDropdown).selectByVisibleText(customerName);
        new Select(currencyDropdown).selectByVisibleText(currency);
        processBtn.click();
        Driver.getDriver().switchTo().alert().accept();
    }
}