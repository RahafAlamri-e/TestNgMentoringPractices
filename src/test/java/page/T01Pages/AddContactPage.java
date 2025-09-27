package page.T01Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddContactPage {

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public AddContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void addContact(String fName, String lName, String mail, String phoneNum) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        phone.sendKeys(phoneNum);
        submitBtn.click();
    }
}
