package tests.sda.mentoring.taskes.day06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CLContactListPage {

    public CLContactListPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "logout")
    public WebElement logout;

}
