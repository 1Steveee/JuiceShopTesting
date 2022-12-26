package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private WebDriver driver;

    public  MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement AccountBtn() {
        return driver.findElement(By.id("navbarAccount"));
    }

    public WebElement LoginBtn() {
        return driver.findElement(By.id("navbarLoginButton"));
    }

    public WebElement dismissBtn() {
        return driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']"));
    }

    public WebElement LogOutBtn() { return driver.findElement(By.id("navbarLogoutButton")); }

    public LoginPage clickLogin() {
        boolean dismissBtnAvailable = dismissBtnDisplaying();
        if (dismissBtnAvailable) {
            dismissBtn().click();
        }
        AccountBtn().click();
        LoginBtn().click();
        return new LoginPage(driver);
    }

    public boolean dismissBtnDisplaying() {
        try {
            boolean btnDisplayed = dismissBtn().isDisplayed();
            if (btnDisplayed) {
                return true;
            }
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
        return false;
    }
}
