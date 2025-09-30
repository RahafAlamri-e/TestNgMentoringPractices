package tests.sda.mentoring.taskes.day06;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;

public class T02_ParallelSearchTest {

    @DataProvider(name = "searchTerms", parallel = true)
    public Object[][] getSearchTerms() {
        return new Object[][]{
                {"Selenium"},
                {"Java"},
                {"Laptop"},
                {"Headphones"}
        };
    }

    @Test(dataProvider = "searchTerms")
    public void amazonSearchTest(String keyword) {
        Driver.getDriver().get("https://www.amazon.com");

        try {
            WebElement continueBtn = Driver.getDriver().findElement(By.xpath("//button[text()='Continue shopping']"));
            continueBtn.click();
        } catch (Exception e) {
            System.out.println("No 'Continue shopping' button found, continuing...");
        }

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        try {
            WebElement dismissBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-action-type='DISMISS']")));
            dismissBtn.click();
        } catch (Exception e) {
            System.out.println("No Dismiss popup.");
        }


        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys(keyword);
        searchBox.submit();

        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));

        String text = resultText.getText();
        Assert.assertTrue(text.toLowerCase().contains(keyword.toLowerCase()));

        System.out.println("✅ Thread ID: " + Thread.currentThread().getId() + " | Searched for: " + keyword);

        Driver.closeDriver();
    }
}

