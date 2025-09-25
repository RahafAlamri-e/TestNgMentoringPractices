package com.sda.mentoring.taskes.day03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.Assert.assertTrue;

public class T01_CrossBrowserFormTesting extends TestBase {

    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill form and submit
    Do all actions and assert
    Do this test with Chrome, Edge and Firefox
    */

    String url = "https://claruswaysda.github.io/ActionsForm.html";

    By nameById = By.id("name");
    By ageById = By.id("age");
    By selectOptionsByXpath = By.xpath("//select[@id='options']");
    By codingByXpath = By.xpath("//input[@value='coding']");
    By femaleByXpath = By.xpath("//input[@value='female']");
    By generateButtonByXpath = By.xpath("//button[@type='button']");

    @Test
    void test01(){

        driver.get(url);
        driver.findElement(nameById).sendKeys("Rahaf");
        driver.findElement(ageById).sendKeys("23");

        Select select = new   Select(driver.findElement(selectOptionsByXpath));
        select.selectByValue("it");

        driver.findElement(codingByXpath).click();
        driver.findElement(femaleByXpath).click();
        driver.findElement(generateButtonByXpath).click();

        String alert = driver.switchTo().alert().getText();
        Assert.assertTrue(alert.contains("Your passcode is:"));

    }
}
