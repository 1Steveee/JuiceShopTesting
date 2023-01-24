package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliverySectionPage {

    private WebDriver driver;

    public DeliverySectionPage(WebDriver driver) {

        this.driver = driver;
    }

    private WebElement oneDayDeliveryBtn() {
        return driver.findElement(By.cssSelector("mat-cell > mat-radio-button"));
    }

    private WebElement continueBtn() {
        return driver.findElement(By.cssSelector("div > button:nth-child(2)"));
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

    public PaymentPage selectDeliveryMethod() {
        oneDayDeliveryBtn().click();
        continueBtn().click();
        return new PaymentPage(driver);
    }

}
