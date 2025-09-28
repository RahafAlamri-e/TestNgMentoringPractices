package tests.sda.mentoring.taskes.day05;

import org.testng.annotations.Test;
import tests.sda.mentoring.taskes.day05.T01Pages.ClaruswaySdaPage;
import utilities.Driver;

public class T01_WebTableRecordManagement {

    /*
Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 5 records
Delete first record you created.
(Use Fluent POM and don't use any index in locators)
*/

    @Test
    public void test01() {
        Driver.getDriver().get("https://claruswaysda.github.io");
        ClaruswaySdaPage sdaPage = new ClaruswaySdaPage();
        sdaPage
                .clickWebTable()
                .enterFakeRecord(5)
                .deleteLastAddedRecord();
    }
}
