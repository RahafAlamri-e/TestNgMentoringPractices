package tests.sda.mentoring.assignments.day04;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.sda.mentoring.assignments.day04.T02Pages.*;
import utilities.Driver;

public class T02_BankingTest {
    /*
        Test Scenario:
            1. Open 5 new customer accounts
            2. Deposit 100 USD to each account
            3. Withdraw 100 USD from any one account
            4. Delete all created accounts
            5. Verify account operations
     */

    ManagerLoginPage managerLoginPage;
    CustomerManagementPage customerManagementPage;
    AccountManagementPage accountManagementPage;
    CustomerLoginPage customerLoginPage;
    TransactionPage transactionPage;

    String[] customers = {"Ali Test", "Sara Test", "Omar Test", "Mona Test", "Khalid Test"};

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        managerLoginPage = new ManagerLoginPage();
        customerManagementPage = new CustomerManagementPage();
        accountManagementPage = new AccountManagementPage();
        customerLoginPage = new CustomerLoginPage();
        transactionPage = new TransactionPage();
    }

    @Test(priority = 1)
    public void testAddCustomers() {
        managerLoginPage.loginAsManager();
        for (String name : customers) {
            String[] split = name.split(" ");
            customerManagementPage.addCustomer(split[0], split[1], "12345");
        }
    }

    @Test(priority = 2)
    public void testOpenAccounts() {
        managerLoginPage.goHome();
        managerLoginPage.loginAsManager();
        for (String name : customers) {
            accountManagementPage.createAccount(name, "Dollar");
        }
    }

    @Test(priority = 3)
    public void testDepositToAccounts() {
        for (String name : customers) {
            customerLoginPage.loginAsCustomer(name);
            transactionPage.deposit(100);
            Assert.assertEquals(transactionPage.getBalance(), "100");
            managerLoginPage.goHome();
        }
    }

    @Test(priority = 4)
    public void testWithdrawFromOneAccount() {
        customerLoginPage.loginAsCustomer(customers[0]);
        transactionPage.withdraw(100);
        Assert.assertEquals(transactionPage.getBalance(), "0");
        managerLoginPage.goHome();
    }

    @Test(priority = 5)
    public void testDeleteCustomers() {
        managerLoginPage.loginAsManager();
        customerManagementPage.deleteAllCustomers();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}