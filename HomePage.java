package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;

    By myAccount = By.className("ico-account");
    By logOut = By.className("ico-logout");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean isLogOutLinkPresent() {
        return driver.findElement(logOut).isDisplayed();
    }

    public String getLogOutText() {
        return driver.findElement(logOut).getText();
    }
        public boolean isMyAccountPresent() {
        return driver.findElement(myAccount).isDisplayed();

        }

        public String getMyAccountText()
        {
            return driver.findElement(myAccount).getText();
        }


    }

