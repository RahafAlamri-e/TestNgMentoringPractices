package utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    @DataProvider
    public static Object[][] getFakerData() {
        Faker faker = new Faker();
        Object[][] data = new Object[3][3];
        for (int i = 0; i < 3; i++) {
            data[i][0] = faker.name().fullName();
            data[i][1] = String.valueOf(faker.number().numberBetween(18, 60));
            data[i][2] = faker.number().numberBetween(1,5);
        }
        return data;
    }


    @DataProvider
    public static Object[][] getEmployeeDataFromExcel(){
        ExcelUtilities eu = new ExcelUtilities("Users.xlsx", "Employees");
        return eu.getExcelDataAsArray();
    }

}
