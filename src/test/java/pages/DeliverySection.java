package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliverySection {

    private WebDriver driver;

    public DeliverySection(WebDriver driver) {

        this.driver = driver;
    }

    public String getName() {
        return driver.findElement(By.cssSelector("mat-card > div > div:nth-child(2)")).getText();
    }

    public String getAddress() {
        return driver.findElement(By.cssSelector("mat-card > div > div:nth-child(3)")).getText();
    }

    public String getCountryCode() {
        return driver.findElement(By.cssSelector("mat-card > div > div:nth-child(4)")).getText();
    }

    public String getPhoneNumber() {
        return driver.findElement(By.cssSelector("mat-card > div > div:nth-child(5)")).getText();
    }
}
