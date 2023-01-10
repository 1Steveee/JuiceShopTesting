package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {

    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkOut() {
        return driver.findElement(By.id("checkoutButton"));
    }

    public String getAppleJuiceText() {
        return driver.findElement(By
                .cssSelector("mat-row:nth-child(2) > mat-cell.mat-cell.cdk-cell.cdk-column-product")).getText();
    }

    public String getGreenSmoothieText() {
        return driver.findElement(By
                .cssSelector("mat-row:nth-child(3) > mat-cell.mat-cell.cdk-cell.cdk-column-product")).getText();
    }

    public String getAppleJuicePrice() {
        return driver.findElement(
                By.cssSelector("mat-row:nth-child(2) > mat-cell.mat-cell" +
                        ".cdk-cell.cdk-column-price.mat-column-price.ng-star-inserted")).getText();
    }

    public String getGreenSmoothiePrice() {
        return driver.findElement(
                By.cssSelector("mat-row:nth-child(3) > mat-cell.mat-cell" +
                        ".cdk-cell.cdk-column-price.mat-column-price.ng-star-inserted")).getText();
    }

    public String getAppleJuiceQuantity() {
        return driver.findElement(By.cssSelector("mat-row:nth-child(2) > mat-cell.mat-cell.cdk-cell" +
                ".content-align.cdk-column-quantity.mat-column-quantity.ng-star-inserted > span")).getText();
    }

    public String getGreenSmoothieQuantity() {
        return driver.findElement(By.cssSelector("mat-row:nth-child(3) > mat-cell.mat-cell.cdk-cell" +
                ".content-align.cdk-column-quantity.mat-column-quantity.ng-star-inserted > span")).getText();
    }

    public String getBasketPageTotalPrice() {
        System.out.println(driver.findElement(By.id("price")));
        return driver.findElement(By.id("price")).getText();
    }

    public SelectAddressPage clickCheckOutLink() {
        checkOut().click();
        return new SelectAddressPage(driver);
    }

}
