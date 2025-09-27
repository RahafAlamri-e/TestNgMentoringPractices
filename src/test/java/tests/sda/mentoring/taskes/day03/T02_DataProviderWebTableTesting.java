package tests.sda.mentoring.taskes.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import utilities.TestBase;

import java.time.Duration;

public class T02_DataProviderWebTableTesting {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add records to the table using DataProvider
    Do it with all 3 ways
    */

    WebDriver driver;
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"john", "25", 2},
                {"mary", "30", 3},
                {"tom", "28", 4}
        };
    }

    @Test(dataProvider = "getData")
    void addRecordTest(String name, String age, int country) {

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

    }

    @Test(dataProvider = "getFakerData", dataProviderClass = utilities.DataProviderUtilities.class)
    void addRecordFakerTest(String name, String age, int country) {

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

    }

    @Test(dataProvider = "getEmployeeDataFromExcel", dataProviderClass = utilities.DataProviderUtilities.class)
    void addRecordDPExcelTest(String name, double age, String country) {

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys((int) age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
