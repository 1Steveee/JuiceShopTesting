package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public  MainPage(final  WebDriver driver) {
        this.driver = driver;
    }

    public WebElement navbarAccountBtn() {
        return driver.findElement(By.id("navbarAccount"));
    }

    public WebElement navbarLoginBtn() {
        return driver.findElement(By.id("navbarLoginButton"));
    }

    public void clickLogin() {
        final Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(5)).click(navbarAccountBtn()).perform();
        actions.pause(Duration.ofSeconds(5)).click(navbarLoginBtn()).perform();
    }

    public WebElement dismissBtn() {
        return driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']"));
    }

    public void clickDismissBtn() {
        dismissBtn().click();
    }
}
