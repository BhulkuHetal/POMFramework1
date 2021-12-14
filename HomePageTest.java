package com.demo.nopcommerce;

import Base.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {

    BasePage basePage;
    WebDriver driver;
    Properties prop;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.intialiserDriver(webEngine);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyHomePageTitleTest()
    {
        String hpTitle = homePage.getHomePageTitle();
        System.out.println(hpTitle);
        Assert.assertEquals(hpTitle, Constants.HOME_PAGE_TITLE, "Homepage title is missing");
    }

    public void verifyLogOutLinkTest(){
        Assert.assertTrue(homePage.isLogOutLinkPresent(),"Log out link not present");
        String logOutLink = homePage.getLogOutText();
        System.out.println("Log out link is: "+ logOutLink);
        Assert.assertEquals(logOutLink, Constants.HOME_PAGE_LOGOUT,"Log out test mismatch");
    }

    public void tearDown()
    { driver.quit();}
}
