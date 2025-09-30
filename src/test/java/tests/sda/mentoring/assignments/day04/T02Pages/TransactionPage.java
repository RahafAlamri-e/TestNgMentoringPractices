package tests.sda.mentoring.assignments.day04.T02Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TransactionPage {

    public TransactionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    private WebElement depositTab;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    private WebElement withdrawTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//strong[2]")
    private WebElement balanceLabel;


    public void deposit(int amount) {
        depositTab.click();
        amountInput.sendKeys(String.valueOf(amount));
        submitBtn.click();
    }

    public void withdraw(int amount) {
        withdrawTab.click();
        amountInput.sendKeys(String.valueOf(amount));
        submitBtn.click();
    }

    public String getBalance() {
        return balanceLabel.getText();
    }
}