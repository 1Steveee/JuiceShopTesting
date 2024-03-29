package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSummaryPage {
    private WebDriver driver;

    private WebElement checkoutBtn() {
        return driver.findElement(By.cssSelector("mat-card > #checkoutButton"));
    }

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderPriceText() {
        return driver.findElement(By.cssSelector(".mat-footer-cell.price")).getText();
    }

    public String getOrderNameText() {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(2)")).getText();
    }

    public String getOrderAddressText() {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(3)")).getText();
    }

    public String getCountryCodeText() {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(4)")).getText();
    }

    public String getPhoneNumberText() {
        return driver.findElement(By.cssSelector("mat-card:nth-child(1) > div > div:nth-child(5)")).getText();
    }

    public OrderConfirmationPage placeOrder() {
        checkoutBtn().click();
        return new OrderConfirmationPage(driver);
    }

}
