package tests.sda.mentoring.assignments.day04.T01Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ContactListPage {

    @FindBy(id = "logout")
    WebElement logoutButton;

    @FindBy(id = "add-contact")
    WebElement addContactBtn;

    @FindBy(xpath = "//table//tr[@class='contactTableBodyRow']")
    List<WebElement> contactRows;

    public ContactListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void logout() {
        logoutButton.click();
    }

    public void clickAddContact() {
        addContactBtn.click();
    }

    public int getContactCount() {
        return contactRows.size();
    }

    public boolean isContactDisplayed(String name) {
        return contactRows.stream().anyMatch(t -> t.findElement(By.xpath("./td[2]")).getText().equals(name));
    }
}
