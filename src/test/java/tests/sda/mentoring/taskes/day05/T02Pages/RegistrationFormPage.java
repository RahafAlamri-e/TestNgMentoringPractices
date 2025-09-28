package tests.sda.mentoring.taskes.day05.T02Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

public class RegistrationFormPage {

    By nameById = By.id("name");
    By ageById = By.id("age");
    By selectOptionsByXpath = By.xpath("//select[@id='options']");
    By codingByXpath = By.xpath("//input[@value='coding']");
    By femaleByXpath = By.xpath("//input[@value='female']");
    By generateButtonByXpath = By.xpath("//button[@type='button']");
    By submitButtonById = By.id("submitButton");

    Faker faker = new Faker();

    public RegistrationFormPage enterName(){
        String randomName = faker.name().fullName();
        Driver.getDriver().findElement(nameById).sendKeys(randomName);
        return this;
    }

    public RegistrationFormPage enterAge(){
        int randomAge = faker.number().numberBetween(18, 60);
        Driver.getDriver().findElement(ageById).sendKeys(String.valueOf(randomAge));
        return this;
    }

    public RegistrationFormPage selectDepartment(String dept){
        new Select(Driver.getDriver().findElement(selectOptionsByXpath)).selectByValue(dept);
        return this;
    }

    public RegistrationFormPage chooseCodingInterest(){
        Driver.getDriver().findElement(codingByXpath).click();
        return this;
    }

    public RegistrationFormPage selectFemale(){
        Driver.getDriver().findElement(femaleByXpath).click();
        return this;
    }

    public RegistrationFormPage clickGeneratePasscode(){
        Driver.getDriver().findElement(generateButtonByXpath).click();
        return this;
    }

    public RegistrationFormPage getAlartMag(){
        String firstAlertText = Driver.getDriver().switchTo().alert().getText();
        String passcode = firstAlertText.replace("Your passcode is:", "").trim();
        Driver.getDriver().switchTo().alert().accept();

        Driver.getDriver().switchTo().alert().sendKeys(passcode);
        Driver.getDriver().switchTo().alert().accept();

        return this;
    }

    public ActionsClickDragPage clickSubmit(){
        Driver.getDriver().switchTo().frame("iframeSubmit");
        Driver.getDriver().findElement(submitButtonById).click();

        String originalWindow = Driver.getDriver().getWindowHandle();
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("actionsClickDrag"));

        return new ActionsClickDragPage();
    }

}
