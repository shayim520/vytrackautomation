package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class TestBase {

    public WebDriver driver;
    public Actions action;



    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigrationReader.getProperty("implictwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigrationReader.getProperty("urlV"));


    }

    @AfterMethod
    public void teardown(){



        Driver.closeDriver();
    }
}
