package page.T01Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    @FindBy(id = "signup")
    WebElement registerButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit")
    WebElement submitButton;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void registerNewUser(String fName, String lName, String mail, String pass) {
        registerButton.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        password.sendKeys(pass);
        submitButton.click();
    }

    public void login(String mail, String pass) {
        email.clear();
        email.sendKeys(mail);
        password.clear();
        password.sendKeys(pass);
        submitButton.click();
    }
}
