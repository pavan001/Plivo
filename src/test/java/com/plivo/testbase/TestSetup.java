package com.plivo.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.plivo.utilities.ExtentManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;

public class TestSetup {


    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testLog = new ThreadLocal<ExtentTest>();

    public Map<String, ExtentTest> map = new HashMap<String, ExtentTest>();

    @BeforeSuite
    public void setUp() {

        extent = ExtentManager.GetExtent();

    }

    @BeforeClass
    public synchronized void beforeClass() {
        String className = getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        ExtentTest parent = extent.createTest(className);
        parentTest.set(parent);


    }


    @AfterMethod
    public synchronized void afterMethod() {


        extent.flush();
    }

    @AfterSuite
    public void tearDown() {

    }
}
