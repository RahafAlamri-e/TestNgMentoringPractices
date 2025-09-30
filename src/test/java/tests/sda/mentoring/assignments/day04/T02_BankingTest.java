package tests.sda.mentoring.assignments.day04;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.sda.mentoring.assignments.day04.T02Pages.*;
import utilities.Driver;

public class T02_BankingTest {

    ManagerLoginPage managerLoginPage;
    CustomerManagementPage customerManagementPage;
    AccountManagementPage accountManagementPage;
    CustomerLoginPage customerLoginPage;
    TransactionPage transactionPage;

    // أسماء العملاء
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
        managerLoginPage.goHome();   // ⬅️ نرجع للصفحة الرئيسية
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
            Assert.assertEquals(transactionPage.getBalance(), "100",
                    "❌ Balance not updated correctly for " + name);
            managerLoginPage.goHome();   // ⬅️ بعد كل تسجيل دخول نرجع Home
        }
    }

    @Test(priority = 4)
    public void testWithdrawFromOneAccount() {
        customerLoginPage.loginAsCustomer(customers[0]);
        transactionPage.withdraw(100);
        Assert.assertEquals(transactionPage.getBalance(), "0",
                "❌ Withdrawal not processed correctly for " + customers[0]);
        managerLoginPage.goHome();   // ⬅️ نرجع Home بعد العملية
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