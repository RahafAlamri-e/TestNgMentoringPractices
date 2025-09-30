package tests.sda.mentoring.assignments.day04.T02Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CustomerManagementPage {

    public CustomerManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerBtn;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    private WebElement customersTab;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> customerRows;

    public void addCustomer(String fName, String lName, String pCode) {
        addCustomerBtn.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postCode.sendKeys(pCode);
        submitBtn.click();
        Driver.getDriver().switchTo().alert().accept();
    }

    public void openCustomersTab() {
        customersTab.click();
    }

    public void deleteAllCustomers() {
        openCustomersTab();
        while (!customerRows.isEmpty()) {
            customerRows.get(0).findElement(By.xpath(".//button[text()='Delete']")).click();
        }
    }
}