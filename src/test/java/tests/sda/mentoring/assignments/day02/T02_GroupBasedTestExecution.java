package tests.sda.mentoring.assignments.day02;

import org.testng.annotations.Test;
import utilities.TestBase;

public class T02_GroupBasedTestExecution extends TestBase {

    /*
        Requirements:
            1. Create tests with groups: "smoke", "regression", "api"
            2. Create XML configurations to run specific groups
            3. Implement include/exclude group scenarios
     */

    @Test(groups = {"smoke"})
    public void test01() {
        System.out.println("Smoke Test");
    }

    @Test(groups = {"regression"})
    public void test02() {
        System.out.println("Regression Test");
    }

    @Test(groups = {"api"})
    public void test03() {
        System.out.println("API Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void test04() {
        System.out.println("Smoke + Regression Test");
    }
}
