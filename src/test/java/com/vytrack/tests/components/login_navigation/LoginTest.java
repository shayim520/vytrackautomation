package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.ConfigrationReader;
import com.vytrack.utilities.Loginpage;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest  extends TestBase{



//    String UsernameBox = "prependedInput";
//    String PasswordBox = "prependedInput2";
//
//    String nameOfStroreManager = "//a[@class='dropdown-toggle'][contains(text(),'Brayan King')]";


    @Test(priority = 2)
    public void login(){

//        driver.findElement(By.id(UsernameBox)).sendKeys(ConfigrationReader.getProperty("storeManagerUsername"));
//        driver.findElement(By.id(PasswordBox)).sendKeys(ConfigrationReader.getProperty("password"),Keys.ENTER);

        Loginpage log = new Loginpage();
       log.userName.sendKeys(ConfigrationReader.getProperty("storeManagerUsername"));
       log.userPassword.sendKeys(ConfigrationReader.getProperty("password"),Keys.ENTER);
       driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigrationReader.getProperty("implictwait")),TimeUnit.SECONDS);
//        sleep(2);
        String expectedResult = "Dashboard";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test(priority = 1)
    public void verifyNameOfStoreManager(){

//        driver.findElement(By.id(UsernameBox)).sendKeys(ConfigrationReader.getProperty("storeManagerUsername"));
//        driver.findElement(By.id(PasswordBox)).sendKeys(ConfigrationReader.getProperty("password"),Keys.ENTER);
        Loginpage log = new Loginpage();
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(log.userName));


      log.userName.sendKeys(ConfigrationReader.getProperty("storeManagerUsername"));
      log.userPassword.sendKeys(ConfigrationReader.getProperty("password"),Keys.ENTER);
      driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigrationReader.getProperty("implictwait")),TimeUnit.SECONDS);

        String actualResult = log.nameOfStroreManager.getText();
        String expctedResult = "Brayan King";

        Assert.assertEquals(actualResult,expctedResult);
//        Assert.assertTrue(driver.findElement(By.xpath(nameOfStroreManager)).isDisplayed(),expctedResult);
//
//        System.out.println(driver.findElement(By.xpath(nameOfStroreManager)).isDisplayed());
        System.out.println(actualResult);

    }

    public static void sleep(int i){
        try{
            Thread.sleep(i*1000);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

    }

}
