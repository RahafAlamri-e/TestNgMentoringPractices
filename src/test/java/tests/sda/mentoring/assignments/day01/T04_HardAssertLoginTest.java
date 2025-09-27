package tests.sda.mentoring.assignments.day01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T04_HardAssertLoginTest {
    /*
        1. Navigate to https://claruswaysda.github.io/signIn.html
        2. Enter username: "admin"
        3. Enter password: "123"
        4. Click Submit button
        5. Use hard assertions to verify:
        New page URL is "https://claruswaysda.github.io/signIn.html"
        Page contains text "Employee Table"
     */

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(description = "Positive Login Test with hard assertions (should fail)")
    public void positiveLoginTest() {

        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBtn.click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://claruswaysda.github.io/signIn.html", "actual url did not match expected url");

        WebElement bodyElement = driver.findElement(By.id("employeeHeader"));
        Assert.assertTrue(bodyElement.getText().contains("Employee Table"), "page does not contain expected text: Employee Table");

    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
