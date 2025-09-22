package com.sda.mentoring.taskes.day01;

import org.testng.annotations.Test;

    public class T02AttributePracticeTest_Youmna {

    @Test (priority = 1, description = "test priority 1")
    void test01(){
        System.out.println("test01");
    }

    @Test (priority = 2, description = "test priority 2")
    void test02(){
        System.out.println("test02");
    }

    @Test (priority = 3, description = "test priority 3")
    void test03(){
        System.out.println("test03");
    }

    @Test (priority = 4, description = "test priority 4")
    void test04(){
        System.out.println("test04");
    }

    @Test (priority = 5, description = "test priority 5")
    void test05(){
        System.out.println("test05");
    }

    @Test (enabled = false, description = "disables test")
    void testEnable(){
        System.out.println("disabled");
    }

    @Test (timeOut = 3000, description = "time out 3000, would pass")
    void testTimeout01() throws InterruptedException {
        System.out.println("testTimeout01");
        Thread.sleep(2000);
    }

    @Test (timeOut = 1000, description = "time out 1000, would fail")
    void testTimeout02() throws InterruptedException {
        System.out.println("testTimeout");
        Thread.sleep(2000);
    }

    @Test (groups = {"smoke", "regression"}, description = "first test in group smoke")
    void testSmoke1(){
        System.out.println("First smoke test");
    }

    @Test (groups = "smoke", description = "second test in group smoke")
    void testSmoke2(){
        System.out.println("second smoke test");
    }

    @Test (groups = "regression", description = "first test in group regression")
    void testRegression01(){
        System.out.println("First regression test");
    }

    @Test (groups = "regression", description = "second test in group regression")
    void testRegression02(){
        System.out.println("second regression test");
    }

    @Test (groups = "api", description = "first test in group api")
    void testApi01(){
        System.out.println("First api test");
    }

    @Test (groups = "api", description = "second test in group api")
    void testApi02(){
        System.out.println("second api test");
    }
}