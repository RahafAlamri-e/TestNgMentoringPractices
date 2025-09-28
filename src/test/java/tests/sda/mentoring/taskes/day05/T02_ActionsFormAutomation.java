package tests.sda.mentoring.taskes.day05;

import org.testng.annotations.Test;
import tests.sda.mentoring.taskes.day05.T02Pages.RegistrationFormPage;
import utilities.Driver;

public class T02_ActionsFormAutomation {



    @Test
    public void test01() {
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage
                .enterName()
                .enterAge()
                .selectDepartment("it")
                .chooseCodingInterest()
                .selectFemale()
                .clickGeneratePasscode()
                .getAlartMag()
                .clickSubmit()
                .performDragAndDrop()
                .performRightClick()
                .performDoubleClick()
                .performHover();

        Driver.closeDriver();
    }
}
