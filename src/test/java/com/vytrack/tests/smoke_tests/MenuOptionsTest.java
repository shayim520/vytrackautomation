package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {

    WebDriver driver;

    String UsernameBox = "prependedInput";
    String PasswordBox = "prependedInput2";
    String LoginButton = "_submit";
    String FleetLocator = "//span[@class='title title-level-1'][contains(text(),'Fleet')]";
    String VehicleLocator = "//span[text()='Vehicles']";
    String customersLocator = "//span[@class='title title-level-1'][contains(text(),'Customers')]";
    String accountLocator = "//span[@class='title title-level-2'][contains(text(),'Accounts')]";
    String conatctsLocator = "//span[@class='title title-level-2'][contains(text(),'Contacts')]";
    String activitiesLocator = "//span[@class='title title-level-1'][contains(text(),'Activities')]";
    String calls = "//span[@class='title title-level-2'][contains(text(),'Calls')]";
    String calendarEventsLocator = "//span[@class='title title-level-2'][contains(text(),'Calendar Events')]";
    String dashboardLocator1 = "//li[@class='dropdown dropdown-level-1 first active']//span[@class='title title-level-1']";
    String dashboardLocator2 = "//li[@class='dropdown-menu-single-item first active']//span[@class='title title-level-2'][contains(text(),'Dashboard')]";
    String fleetLocatorStM = "//li[@class='dropdown dropdown-level-1']//span[@class='title title-level-1'][contains(text(),'Fleet')]";
    String vehicleLocatorStM = "//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]";
    String salesLocator = "//span[@class='title title-level-1'][contains(text(),'Sales')]";//li[@class='dropdown dropdown-level-1']//span[@class='title title-level-1'][contains(text(),'Sales')]
    String opportunities = "//span[@class='title title-level-2'][contains(text(),'Opportunities')]";



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
//        driver.findElement(By.id(UsernameBox)).sendKeys("user195");
//        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
//        driver.findElement(By.id(LoginButton)).click();



        //(//li/div/div/ul/li[3]/a/span[@class='title title-level-2'])[1]
    }

    @Test(priority = 1)
    public void loginD(){

        driver.findElement(By.id(UsernameBox)).sendKeys("user195");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
        String expectedResult = "Dashboard";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(priority = 2)
    public void navigateToFleetD(){

//        Actions action = new Actions(driver);


        driver.findElement(By.id(UsernameBox)).sendKeys("user195");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
        driver.findElement(By.xpath(FleetLocator)).click();
//        action.moveToElement(driver.findElement(By.xpath(FleetLocator)));


        driver.findElement(By.xpath(VehicleLocator)).click();
        sleep(2);
        System.out.println(driver.getTitle());
        String expectedTitleResult = "Car - Entities - System - Car - Entities - System";
        String actualTitleResult = driver.getTitle();
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
       sleep(2);


        String expactedPageName = "Cars";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);

    }

    @Test(priority = 3)
    public void navigateToCustomersAccountD(){


        driver.findElement(By.id(UsernameBox)).sendKeys("user195");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();

        driver.findElement(By.xpath(customersLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(accountLocator)).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs("Accounts - Customers"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "Accounts - Customers";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "Accounts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);


    }

    @Test(priority = 4)
    public void navigateToCustomersContactsD(){

        driver.findElement(By.id(UsernameBox)).sendKeys("user195");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();

        driver.findElement(By.xpath(customersLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(conatctsLocator)).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs("Contacts - Customers"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "Contacts - Customers";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "Contacts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);
    }

    @Test(priority = 5)
    public void navigateToActivitiesD(){

        driver.findElement(By.id(UsernameBox)).sendKeys("user195");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();

        driver.findElement(By.xpath(activitiesLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(calendarEventsLocator)).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "Calendar Events - Activities";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "Calendar Events";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(priority = 6)
    public void loginStM(){
//
        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
        String expectedResult = "Dashboard";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(priority = 7)
    public void navigateToDashboard(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
       sleep(2);

//        driver.findElement(By.xpath(dashboardLocator1)).click();
//        sleep(2);
//        driver.findElement(By.xpath(dashboardLocator2)).click();
//
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.titleIs("Dashboard - Dashboards"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        String expectedTitleResult = "Dashboard";
        String actualTitleResult = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);

        String expactedPageName = "Dashboard";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);

    }

    @Test(priority = 8)
    public void navigateToFleetStM(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123", Keys.ENTER);


         sleep(2);

         driver.findElement(By.xpath(fleetLocatorStM)).click();
         sleep(2);

        driver.findElement(By.xpath(vehicleLocatorStM)).click();
        sleep(2);
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        System.out.println(driver.getTitle());
        String expectedTitleResult = "All - Car - Entities - System - Car - Entities - System";
        String actualTitleResult = driver.getTitle();
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
        sleep(2);


        String expactedPageName = "All Cars";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);

    }

    @Test(priority = 9)
    public void navigateToCustomersAccountStM(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();

sleep(2);
        driver.findElement(By.xpath(customersLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        sleep(2);
        driver.findElement(By.xpath(accountLocator)).click();
        sleep(2);

//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.titleIs("All - Accounts - Customers"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "All - Accounts - Customers";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "All Accounts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);


    }

    @Test(priority = 10)
    public void navigateToCustomersContactsStM(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
        sleep(2);
        driver.findElement(By.xpath(customersLocator)).click();
        sleep(2);
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(conatctsLocator)).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs("All - Contacts - Customers"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "All - Contacts - Customers";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "All Contacts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);
    }

    @Test(priority = 11)
    public void navigateToSales(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();

        sleep(2);

        driver.findElement(By.xpath(salesLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        sleep(2);
        driver.findElement(By.xpath(opportunities)).click();
        sleep(2);

//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.titleIs("Open Opportunities - Opportunities - Sales"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "Open Opportunities - Opportunities - Sales";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "Open Opportunities";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);

    }

    @Test(priority = 12)
    public void navigateToActivitiesCallsStM(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
        sleep(2);

        driver.findElement(By.xpath(activitiesLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        sleep(1);
        driver.findElement(By.xpath(calls)).click();
        sleep(1);
//
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.titleIs("All - Calls - Activities"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "All - Calls - Activities";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "All Calls";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);
    }


    @Test(priority = 13)
    public void navigateToActivitiesStM(){

        driver.findElement(By.id(UsernameBox)).sendKeys("storemanager234");
        driver.findElement(By.id(PasswordBox)).sendKeys("UserUser123");
        driver.findElement(By.id(LoginButton)).click();
        sleep(2);

        driver.findElement(By.xpath(activitiesLocator)).click();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        sleep(1);
        driver.findElement(By.xpath(calendarEventsLocator)).click();
        sleep(2);

//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));

//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//       sleep(2);
        String expectedTitleResult = "All - Calendar Events - Activities";
        String actualTitleResult = driver.getTitle();
        System.out.println(actualTitleResult);
        Assert.assertEquals(actualTitleResult,expectedTitleResult);
//        sleep(2);
        String expactedPageName = "All Calendar Events";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actualPageName))));
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expactedPageName);
    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }

    public void sleep(int a){
        try {
            Thread.sleep(a*1000);
        }catch(Exception e){

        }

    }
}
