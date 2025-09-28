package tests.sda.mentoring.taskes.day05;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.sda.mentoring.taskes.day05.T03Pages.AddRecordDynamicWebTablePage;
import utilities.Driver;

public class T03_DynamicWebTableManagement {

    AddRecordDynamicWebTablePage tablePage = new AddRecordDynamicWebTablePage();


    @DataProvider(name = "records")
    public Object[][] records() {
        Faker faker = new Faker();

        return new Object[][]{
                {faker.name().fullName(), String.valueOf(faker.number().numberBetween(18, 60)), faker.number().numberBetween(1, 6)},
                {faker.name().fullName(), String.valueOf(faker.number().numberBetween(18, 60)), faker.number().numberBetween(1, 6)},
                {faker.name().fullName(), String.valueOf(faker.number().numberBetween(18, 60)), faker.number().numberBetween(1, 6)},
                {faker.name().fullName(), String.valueOf(faker.number().numberBetween(18, 60)), faker.number().numberBetween(1, 6)},
                {faker.name().fullName(), String.valueOf(faker.number().numberBetween(18, 60)), faker.number().numberBetween(1, 6)}
        };
    }

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test(dataProvider = "records")
    public void testAddRecords(String name, String age, int countryIndex) {
        tablePage
                .enterName(name)
                .enterAge(age)
                .selectCountrByIndex(countryIndex)
                .clickAddRecord()
                .verifyRecordAdded(name, age, countryIndex);
    }

    @Test(dependsOnMethods = "testAddRecords")
    public void testDeleteRecord() {
        tablePage.deleteRecordByIndex(4);
    }

}
