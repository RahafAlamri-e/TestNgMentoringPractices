package tests.sda.mentoring.taskes.day07;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.sda.mentoring.assignments.day04.T01Pages.AddContactPage;
import tests.sda.mentoring.assignments.day04.T01Pages.ContactListPage;
import tests.sda.mentoring.assignments.day04.T01Pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class T01_ContactListExtentReports {

    /*
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    1. Navigate to the application
    2. Create a new user account
    3. Login with the created user
    4. Add 5 different contacts
    5. Assert that all contacts are properly added and displayed

    Page Objects Needed:
    - LoginPage (registration and login elements)
    - ContactListPage (contact management elements)
    - AddContactPage (contact form elements)

    Assertions:
    - Verify successful user registration
    - Verify successful login
    - Verify each contact is added correctly
    - Verify total contact count equals 5

    Reporting Requirements:
    - Use ExtentReports
    - Create TestBaseReport base class
    - Add .info() logs for each major step
    - Use .pass() for successful assertions
    - Use .fail() for failed assertions with screenshots
    - Add system information (Browser, Environment, Tester)
    - Generate report with timestamp in filename
    */

    @BeforeMethod
    void beforeMethod(){
        ExtentReportManager.createTest("Create Five Contacts Test Started");
        ExtentReportManager.log(Status.INFO, "Test started at: "+ LocalTime.now());
    }

    @AfterMethod
    void tearDown(ITestResult result) {
        ExtentReportManager.log(Status.INFO, "Test finished at: " + LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
    }

    @Test
    public void testContactListScenario() throws InterruptedException {

        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage();
        ContactListPage contactListPage = new ContactListPage();

        // 1. Navigate to the application
        try {
            Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
            ExtentReportManager.log(Status.PASS, "User Navigate to ContactList Page");
        } catch (Exception e){
            ExtentReportManager.log(Status.FAIL, "User Failed to Navigate ContactList Page");
        }

        //  2. Create a new user account
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String newEmail = faker.internet().emailAddress();
        String newPassword = faker.internet().password(7, 10);

        loginPage.registerNewUser(firstName, lastName, newEmail, newPassword);
        ExtentReportManager.log(Status.INFO, "User is Signing Up to the Application");

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared after registration.");
        }

        // 3. Login with the created user
        contactListPage.logout();
        ExtentReportManager.log(Status.INFO, "User is Logout from the Application");
        loginPage.login(newEmail, newPassword);
        ExtentReportManager.log(Status.INFO, "User is Login to the Application");


        // 4. Add 5 different contacts
        List<String> contactNames = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            contactListPage.clickAddContact();
            ExtentReportManager.log(Status.INFO, "Creating Contact number" + i );
            AddContactPage addContactPage = new AddContactPage();

            String cFirst = faker.name().firstName();
            String cLast  = faker.name().lastName();

            contactNames.add(cFirst + " " + cLast);

            addContactPage.addContact(cFirst, cLast, faker.internet().emailAddress(), faker.phoneNumber().subscriberNumber(10));
            Thread.sleep(1000);
        }


        // 5. Assert that all contacts are properly added and displayed
        try {
            Assert.assertEquals(contactListPage.getContactCount(), 5);
            ExtentReportManager.log(Status.PASS, "All Contact is Created");
        }catch (Exception e){
            ExtentReportManager.log(Status.FAIL, "Not All Contact is Created");
        }

        for (String name : contactNames) {
            try {
                Assert.assertTrue(!contactListPage.isContactDisplayed(name));
                ExtentReportManager.log(Status.PASS, "Contact who name is: " + name + " Displayed");
            }catch (Exception e){
                ExtentReportManager.log(Status.FAIL, "Contact who name is: " + name + " Not Displayed");
            }
        }

        System.out.println(contactNames);
        Driver.closeDriver();
    }
}
