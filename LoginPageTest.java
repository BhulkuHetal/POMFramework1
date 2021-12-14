package com.demo.nopcommerce;

import Base.BasePage;
import Pages.LoginPage;
import Utils.Constants;;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;



public class LoginPageTest {



        BasePage basePage;
        WebDriver driver;
        Properties prop;
        LoginPage loginPage;

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
            loginPage = new LoginPage(driver);
        }

        @Test(priority = 1)
        public void verifyLoginPageTitleTest() throws InterruptedException {
            Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE, "Loginpage title mismatched");
        }

        @Test(priority = 2)
        public void verifyRegisterButtonTest() throws InterruptedException {
            Assert.assertTrue(loginPage.verifyRegisterButton(), "Register button is not displayed");
        }

        @Test (priority = 3)
        public void loginTest() throws InterruptedException {
            loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password") );
        }


        @AfterTest
        public void tearDown(){
            driver.quit();
        }
    }


