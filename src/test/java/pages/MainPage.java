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

    public WebElement meWantItLink() {
        return driver.findElement(By.cssSelector(".cc-btn.cc-dismiss"));
    }

    public WebElement LogOutBtn() { return driver.findElement(By.id("navbarLogoutButton")); }

    public LoginPage clickLogin() {
        AccountBtn().click();
        LoginBtn().click();
        return new LoginPage(driver);
    }

    public void clickMeWantItLink() {
        meWantItLink().click();
    }

    public void clickDismissBtn() {
        dismissBtn().click();
    }
}
