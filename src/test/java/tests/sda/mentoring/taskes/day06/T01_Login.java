package tests.sda.mentoring.taskes.day06;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class T01_Login {

    @Test
    void positiveLoginTest() {

        CLHomePage homePage = new CLHomePage();
        CLContactListPage contactListPage = new CLContactListPage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        assert contactListPage.logout.isDisplayed();
        Driver.closeDriver();

    }

    @Test
    void negativeLoginTest() {
        CLHomePage homePage = new CLHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
        homePage.submit.click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(homePage.error));
        assert homePage.error.isDisplayed();
        Driver.closeDriver();
    }
}
