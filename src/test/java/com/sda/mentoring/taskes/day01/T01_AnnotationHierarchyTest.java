package com.sda.mentoring.taskes.day01;

import org.testng.annotations.*;

public class T01_AnnotationHierarchyTest {
    /*
    Create a TestNG class called AnnotationHierarchyTest
    Implement all TestNG annotations (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod,
    @Test, @AfterMethod, @AfterClass, @AfterTest, @AfterSuite)
    Add print statements in each method to observe execution order
    Create 2 test methods
    Run the test and analyze console output
     */

    @BeforeSuite
    void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("@BeforeMethod");
    }

    @Test
    void test01() {
        System.out.println("@Test 1");
    }

    @Test
    void test02() {
        System.out.println("@Test 2");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("@AfterMethod");
    }

    @AfterClass
    void afterClass() {
        System.out.println("@AfterClass");
    }

    @AfterTest
    void afterTest() {
        System.out.println("@AfterTest");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("@AfterSuite");
    }
}
