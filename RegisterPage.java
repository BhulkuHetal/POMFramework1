package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage  {

    WebDriver driver;
    //1. Create your page object/object repositaort in the form of By Locators.

    By genderButton = By.id("gender-female");
    By firstname = By.id("FirstName");
    By lastname = By.id("LastName");
    By Day = By.name("DateOfBirthDay");
    By Month = By.name("DateOfBirthMonth");
    By Year = By.name("DateOfBirthYear");
    By emailID = By.id("Email");
    By companyName = By.id("Company");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page actions/page methods

    public String getRegisterPageTitle() throws InterruptedException {

        return driver.getTitle();
    }

    public void doRegister(String fn, String ln,String day, String month, String year, String email, String CN,
                           String pwd, String cpwd) throws InterruptedException {

        driver.findElement(genderButton).click();
        driver.findElement(firstname).sendKeys(fn);
        driver.findElement(lastname).sendKeys(ln);
        driver.findElement(Day).sendKeys(day);
        driver.findElement(Month).sendKeys(month);
        driver.findElement(Year).sendKeys(year);
        driver.findElement(emailID).sendKeys(email);
        driver.findElement(companyName).sendKeys(CN);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(cpwd);
        driver.findElement(registerButton).click();



    }
}

















