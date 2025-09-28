package tests.sda.mentoring.assignments.day05.T03Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class AddRecordDynamicWebTablePage {

    private By nameBy = By.id("nameInput");
    private By ageBy = By.id("ageInput");
    private By countryBy = By.id("countrySelect");
    private By addRecordBtnBy = By.xpath("//button[.='Add Record']");
    private By tableRowsBy = By.xpath("//table//tbody//tr");

    public AddRecordDynamicWebTablePage enterName(String name) {
        Driver.getDriver().findElement(nameBy).clear();
        Driver.getDriver().findElement(nameBy).sendKeys(name);
        return this;
    }

    public AddRecordDynamicWebTablePage enterAge(String age) {
        Driver.getDriver().findElement(ageBy).clear();
        Driver.getDriver().findElement(ageBy).sendKeys(age);
        return this;
    }

    public AddRecordDynamicWebTablePage selectCountrByIndex(int idx) {
        Select select = new Select(Driver.getDriver().findElement(countryBy));
        select.selectByIndex(idx);
        return this;
    }

    public AddRecordDynamicWebTablePage clickAddRecord() {
        Driver.getDriver().findElement(addRecordBtnBy).click();
        return this;
    }

    public AddRecordDynamicWebTablePage verifyRecordAdded(String name, String age, int countryIndex) {
        List<WebElement> rows = Driver.getDriver().findElements(tableRowsBy);

        Select select = new Select(Driver.getDriver().findElement(countryBy));
        String expectedCountry = select.getOptions().get(countryIndex).getText();

        boolean found = rows.stream().anyMatch(
                row -> row.getText().contains(name)
                        && row.getText().contains(age)
                        && row.getText().contains(expectedCountry)
        );

        assert found;
        return this;
    }

    public AddRecordDynamicWebTablePage deleteRecordByIndex(int index) {
        List<WebElement> rows = Driver.getDriver().findElements(tableRowsBy);

        if (index >= 0 && index < rows.size()) {
            WebElement targetRow = rows.get(index);
            targetRow.findElement(By.xpath(".//button[.='Delete']")).click();
        } else {
            throw new IllegalArgumentException("Invalid row index: " + index + ". Table size: " + rows.size());
        }

        return this;

    }
}
