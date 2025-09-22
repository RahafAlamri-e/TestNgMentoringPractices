package com.sda.mentoring.taskes.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T03_DependencyTest {
    /*
        1. Create a class called DependencyTest
        2. Create a @BeforeClass method to set up WebDriver
        3. Create the following dependent test chain:
            openYahoo() - Navigate to Yahoo
            openBing() - Navigate to Bing (depends on Yahoo test)
            openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)
        4. Add intentional failure in Yahoo test and observe behavior
        5. Create @AfterClass method to close driver
     */

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test()
    public void openYahoo() {
        driver.get("https://www.yahoo.com");
        Assert.fail();
    }

    @Test(dependsOnMethods = "openYahoo")
    public void openBing() {
        driver.get("https://www.bing.com");
    }

    @Test(dependsOnMethods = {"openBing", "openYahoo"})
    public void openDuckDuckGo() {
        driver.get("https://duckduckgo.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
