package tests.sda.mentoring.assignments.day04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.T01Pages.AddContactPage;
import page.T01Pages.ContactListPage;
import page.T01Pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class T01_ContactListApplicationTest {

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
     */

    @Test
    public void testContactListScenario() throws InterruptedException {

        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage();
        ContactListPage contactListPage = new ContactListPage();

        // 1. Navigate to the application
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        //  2. Create a new user account
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String newEmail = faker.internet().emailAddress();
        String newPassword = faker.internet().password(7, 10);

        loginPage.registerNewUser(firstName, lastName, newEmail, newPassword);

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared after registration.");
        }

        // 3. Login with the created user
        contactListPage.logout();
        loginPage.login(newEmail, newPassword);

        // 4. Add 5 different contacts
        List<String> contactNames = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            contactListPage.clickAddContact();
            AddContactPage addContactPage = new AddContactPage();

            String cFirst = faker.name().firstName();
            String cLast  = faker.name().lastName();

            contactNames.add(cFirst + " " + cLast);

            addContactPage.addContact(cFirst, cLast, faker.internet().emailAddress(), faker.phoneNumber().subscriberNumber(10));
            Thread.sleep(1000);
        }


        // 5. Assert that all contacts are properly added and displayed
        Assert.assertEquals(contactListPage.getContactCount(), 5);

        for (String name : contactNames) {
            Assert.assertTrue(contactListPage.isContactDisplayed(name));
        }
        System.out.println(contactNames);


        Driver.closeDriver();
    }
}
