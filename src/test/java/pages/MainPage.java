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

    private WebElement LoginBtn() {
        return driver.findElement(By.id("navbarLoginButton"));
    }

    private WebElement dismissBtn() {
        return driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']"));
    }

    private WebElement siteBasketBtn() {
        return driver.findElement(By.cssSelector("button.mat-focus-indicator:nth-child(7)"));
    }

    private WebElement meWantItLink() {
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

    public BasketPage clickSiteBasket() {
        siteBasketBtn().click();
        return new BasketPage(driver);
    }

    public void LogOut() {
        AccountBtn().click();
        LogOutBtn().click();
    }
}
