package com.demo.nopcommerce;

import Base.BasePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {


    BasePage basePage;
    WebDriver driver;
    Properties prop;
    RegisterPage registerPage;

    // BM - T - AM
    // BM - T - AM
    //BT - T - T - T AT

    @BeforeTest
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.intialiserDriver(webEngine);
        driver.get(prop.getProperty("url"));
        driver.get(prop.getProperty("urlreg"));
        registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() throws InterruptedException {
        String rejTitle = registerPage.getRegisterPageTitle();
        System.out.println(rejTitle);
        Assert.assertEquals(rejTitle, Constants.REGISTER_PAGE_TITLE, "registerpage title mismatched");
    }

    @Test (priority = 2)
    public void registerTest() throws InterruptedException {
        registerPage.doRegister(prop.getProperty("fn"),prop.getProperty("ln"),
                prop.getProperty("day"),prop.getProperty("month"),prop.getProperty("year"),prop.getProperty("email"),
                prop.getProperty("CN"),prop.getProperty("pwd"),prop.getProperty("cpwd") );
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}


