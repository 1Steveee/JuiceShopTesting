package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {

    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement orderConfirmationTitle() {
        return driver.findElement(By.cssSelector("h1.confirmation"));
    }

    public String getOrderConfirmationTitleText() {
        return orderConfirmationTitle().getText();
    }

    public String getAppleJuiceText() {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) > .cdk-column-product")).getText();
    }

    public String getGreenSmoothieText() {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) > .cdk-column-product")).getText();
    }

    public String getAppleJuiceQuantity() {
        return driver.findElement
                (By.cssSelector("mat-table > mat-row:nth-child(2) > .mat-column-quantity > span")).getText();
    }

    public String getGreenSmoothieQuantity() {
        return driver.findElement
                (By.cssSelector("mat-table > mat-row:nth-child(3) > .mat-column-quantity > span")).getText();
    }

    public String getAppleJuicePrice() {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(2) >.mat-column-price")).getText();
    }

    public String getGreenSmoothiePrice() {
        return driver.findElement(By.cssSelector("mat-table > mat-row:nth-child(3) >.mat-column-price")).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(By.cssSelector(".mat-column-total-price > table > tr:nth-child(4) > td")).getText();
    }
}
