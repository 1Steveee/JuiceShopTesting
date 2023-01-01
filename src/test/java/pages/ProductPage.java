package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement addToCartSuccessMessage() {
        return driver.findElement(By.cssSelector(".mat-simple-snack-bar-content"));
    }

    public WebElement addAppleJuiceBtn() {
        return driver.findElement(
                By.cssSelector("div > mat-grid-tile:nth-child(1) > div > mat-card > div:nth-child(2) > button"));
    }

    public WebElement addGreenSmoothieBtn() {
        return driver.findElement(
                By.cssSelector("div > mat-grid-tile:nth-child(8) > div > mat-card > div:nth-child(2) > button"));
    }

    public WebElement warningNotification() {
        return driver.findElement(By.cssSelector(".warn-notification"));
    }

    public void addAppleJuiceToCart() {
        clickOverlay();
        this.actions
                .pause(Duration.ofSeconds(5)).click(addAppleJuiceBtn()).build().perform();
    }

    public void addGreenSmoothieToCart()  {
        this.actions.pause(Duration.ofSeconds(7)).build().perform();
        addGreenSmoothieBtn().click();
    }

    public String getAddToCartSuccessMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(addToCartSuccessMessage())).getText();
    }

    public void clickOverlay() {
        driver.findElement(By.cssSelector(".cdk-overlay-transparent-backdrop")).click();
    }

    public String getWarningNotificationText() {
        return warningNotification().getText();
    }
}
