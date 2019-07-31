package com.vytrack.utilities;

import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    public Loginpage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
        @FindBy(id = "prependedInput")
        public WebElement userName;
        @FindBy(id = "prependedInput2")
        public WebElement userPassword;
        @FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Brayan King')]")
        public WebElement nameOfStroreManager;
        @FindBy(xpath = "//li[@id='user-menu']//ul[@class='dropdown-menu']//a[@href='/user/logout']")
        public WebElement logOutButton2;
        @FindBy(xpath = "//li[@id='user-menu']//i[@class='fa-caret-down']")
        public WebElement logOutButton1;



}
