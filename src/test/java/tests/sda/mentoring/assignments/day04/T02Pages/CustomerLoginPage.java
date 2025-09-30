package tests.sda.mentoring.assignments.day04.T02Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CustomerLoginPage {

    public CustomerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    private WebElement homeBtn;

    @FindBy(xpath = "//button[@ng-click='customer()']")
    private WebElement customerLoginBtn;

    @FindBy(id = "userSelect")
    private WebElement userSelect;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginBtn;

    public void loginAsCustomer(String customerName) {
        homeBtn.click();
        customerLoginBtn.click();
        new Select(userSelect).selectByVisibleText(customerName);
        loginBtn.click();
    }
}