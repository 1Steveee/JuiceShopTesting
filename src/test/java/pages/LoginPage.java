package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement notaCustomerLink() {
        return driver.findElement(By.id("newCustomerLink"));
    }

    public WebElement emailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement loginBtn() {
        return driver.findElement(By.id("loginButton"));
    }

    public String notaCustomerLinkText() {
        return notaCustomerLink().getText();
    }

    public RegisterPage clickNotCustomerLink() {
        notaCustomerLink().click();
        return new RegisterPage(driver);
    }

    public void loginToPage(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        mainPage.AccountBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.LogOutBtn()));
    }
}
