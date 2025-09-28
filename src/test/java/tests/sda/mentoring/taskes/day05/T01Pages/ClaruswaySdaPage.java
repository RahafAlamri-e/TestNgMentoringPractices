package tests.sda.mentoring.taskes.day05.T01Pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class ClaruswaySdaPage {
    By addRecordWebTableBy = By.xpath("//a[.='Add Record Web Table']");

    public AddRecordWebTablePage clickWebTable(){
        Driver.getDriver().findElement(addRecordWebTableBy).click();
        return new AddRecordWebTablePage();
    }
}
