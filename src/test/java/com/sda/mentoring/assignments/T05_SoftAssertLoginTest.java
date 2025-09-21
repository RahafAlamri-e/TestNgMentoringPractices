package com.sda.mentoring.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T05_SoftAssertLoginTest {

    /*
        1. Navigate to https://claruswaysda.github.io/signIn.html
        2. Enter username: "wronguser"
        3. Enter password: "wrongpass"
        4. Click Submit button
        5. Use soft assertions to verify:
            JavaScript alert is displayed
            Alert message text is "Incorrect username or password"
     */

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void negativeLoginTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("wronguser");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("wrongpass");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        softAssert.assertNotNull(alert, "Expected alert but it was not present");


        String actualAlertText = alert.getText();
        softAssert.assertEquals(actualAlertText, "Incorrect username or password", "Alert message did not match expected message");

        alert.accept();
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
