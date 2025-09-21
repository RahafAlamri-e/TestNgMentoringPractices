package com.sda.mentoring.taskes;

import org.testng.annotations.Test;

public class T02_AttributePracticeTest {
    /*
        1. Create a class called AttributePracticeTest
        2. Create 5 test methods with different priorities (1, 3, 2, 5, 4)
        3. Create one test method with enabled = false
        4. Create a test method with timeout of 3 seconds that includes Thread.sleep(2000)
        5. Create a test method with timeout of 1 second that includes Thread.sleep(2000)
        6. Add meaningful descriptions to all test methods
        7. Create test methods with groups: "smoke", "regression", "api"
     */

    @Test(priority = 1, description = "Test with priority 1")
    public void test01() {
        System.out.println("priority 1");
    }

    @Test(priority = 3, description = "Test with priority 3")
    public void test02() {
        System.out.println("priority 3");
    }

    @Test(priority = 2, description = "Test with priority 2")
    public void test03() {
        System.out.println("priority 2");
    }

    @Test(priority = 5, description = "Test with priority 5")
    public void test04() {
        System.out.println("priority 5");
    }

    @Test(priority = 4, description = "Test with priority 4")
    public void test05() {
        System.out.println("priority 4");
    }

    @Test(enabled = false, description = "Disabled test")
    public void test06() {
        System.out.println("test disable");
    }

    @Test(timeOut = 3000, description = "Test with timeout of 3 seconds including Thread.sleep(2000)")
    public void test07() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("executed within 3 second");
    }

    @Test(timeOut = 1000, description = "Test with timeout of 1 second including Thread.sleep(2000)")
    public void test08() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("executed within 1 second");
    }

    @Test(groups = "smoke", description = "Smoke test")
    public void test09() {
        System.out.println("smoke test");
    }

    @Test(groups = "regression", description = "Regression test")
    public void test10() {
        System.out.println("regression test");
    }

    @Test(groups = "api", description = "API test")
    public void test11() {
        System.out.println("API test");
    }
}
