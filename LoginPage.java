package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    //1. Create your page object/object repositaort in the form of By Locators.

    By emailId = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.className("login-button");
    By registerButton = By.className("register-button");

    //2. create constructor of page class

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page actions/page methods

    public String getPageTitle() throws InterruptedException {
        String lpTitle = driver.getTitle();
        Thread.sleep(3000);
        System.out.println("Login page title is " + lpTitle);
        return lpTitle;
    }

    public boolean verifyRegisterButton() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(registerButton).isDisplayed();
    }

    public HomePage doLogin(String username, String pwd) throws InterruptedException {
        driver.findElement(emailId).sendKeys(username);

         Thread.sleep(3000);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginButton).click();
        System.out.println("Credetials are: " + username + " - " + pwd);

        return new HomePage(driver);
    }
}